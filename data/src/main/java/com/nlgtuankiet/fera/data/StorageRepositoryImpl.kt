package com.nlgtuankiet.fera.data

import android.content.Context
import android.os.StatFs
import android.os.storage.StorageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ProcessLifecycleOwner
import com.nlgtuankiet.fera.domain.entity.Storage
import com.nlgtuankiet.fera.domain.entity.asPath
import com.nlgtuankiet.fera.domain.entity.name
import com.nlgtuankiet.fera.domain.repository.StorageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@OptIn(ExperimentalCoroutinesApi::class)
@Singleton
// TODO how to find storage name
class StorageRepositoryImpl @Inject constructor(
  private val context: Context,
  private val storageManager: StorageManager
) : StorageRepository, LifecycleEventObserver {
  private val packageName by lazy {
    context.applicationInfo.packageName
  }

  private val scope = CoroutineScope(Dispatchers.IO + Job())
  private val appResumeTrigger = Channel<Unit>(capacity = Channel.CONFLATED)
  private var cached: List<Storage>? = null
  private val onCacheChangedListener = mutableListOf<(List<Storage>) -> Unit>()
  private val starterMarker: Unit by lazy {
    scope.launch {
      for (trigger in appResumeTrigger) {
        val storage = queryStorage()
        cached = storage
        onCacheChangedListener.forEach { it.invoke(storage) }
      }
    }
    Unit
  }

  init {
    ProcessLifecycleOwner.get().lifecycle.addObserver(this)
  }

  private fun queryStorage(): List<Storage> {
    assertNotMainThread()
    return ContextCompat.getExternalFilesDirs(context, null)
      .toList()
      .map { inputFile ->
        inputFile.toString()
          .removeSuffix("/")
          .removeSuffix("files")
          .removeSuffix("/")
          .removeSuffix(packageName)
          .removeSuffix("/")
          .removeSuffix("Android/data")
          .asPath()
      }
      .map { path ->
        val stats = StatFs(path.value)
        val name = path.name
        Storage(
          name = name,
          path = path,
          availableBytes = stats.availableBytes,
          totalBytes = stats.totalBytes
        )
      }
  }

  override fun getStorage(): Flow<List<Storage>> {
    starterMarker
    return callbackFlow {
      val listener = { storage: List<Storage> ->
        channel.offer(storage)
        Unit
      }
      cached?.let { channel.offer(it) }
      onCacheChangedListener.add(listener)
      awaitClose {
        onCacheChangedListener.remove(listener)
      }
    }
  }

  override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
    if (event == Lifecycle.Event.ON_RESUME) {
      appResumeTrigger.offer(Unit)
    }
  }
}
