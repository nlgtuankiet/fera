package com.nlgtuankiet.fera.data

import android.content.Context
import android.database.ContentObserver
import android.database.Cursor
import android.os.Handler
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner
import com.nlgtuankiet.fera.domain.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class CachedContentProviderRepository<T>(
  private val context: Context,
  private val scope: CoroutineScope,
  private val handler: Handler,
  private val queryParams: QueryParams,
  private val recordMapper: (Cursor) -> T
) : LifecycleObserver {
  private val triggerChannel = Channel<Boolean>(capacity = Channel.CONFLATED)
  private val contentObserver = object : ContentObserver(handler) {
    override fun onChange(selfChange: Boolean) {
      triggerChannel.offer(selfChange)
    }
  }
  private var cached: List<T>? = null
  private val onCacheChangeListener = mutableListOf<() -> Unit>()

  private val starter: Unit by lazy {
    scope.launch(Dispatchers.IO) {
      for (trigger in triggerChannel) {
        Log("re-query in ${Thread.currentThread().name} $queryParams} ")
        cached = query()
        onCacheChangeListener.forEach { it.invoke() }
      }
    }
    Unit
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  @Suppress("unused")
  fun onAppStart() {
    context.contentResolver.unregisterContentObserver(contentObserver)
    context.contentResolver.registerContentObserver(
      queryParams.uri,
      true,
      contentObserver
    )
    triggerChannel.offer(true)
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  @Suppress("unused")
  fun onAppStop() {
    context.contentResolver.unregisterContentObserver(contentObserver)
  }

  init {
    ProcessLifecycleOwner.get().lifecycle.addObserver(this)
  }

  private fun query(): List<T> {
    assertNotMainThread()
    val sortStatement = buildString {
      if (queryParams.sortOrder != null) {
        append(queryParams.sortOrder)
        when (queryParams.sortDirection) {
          SortDirection.Ascending -> append(" ASC")
          SortDirection.Descending -> append(" DESC")
        }
      }
      if (queryParams.limit != null) {
        append(" LIMIT ${queryParams.limit}")
      }
    }.trim()
    val cursor = context.contentResolver.query(
      queryParams.uri,
      queryParams.projection?.toTypedArray(),
      queryParams.selection,
      queryParams.selectionArgs?.toTypedArray(),
      sortStatement
    )
    val result = ArrayList<T>()
    requireNotNull(cursor).use { tableCursor ->
      tableCursor.forEach { rowCursor ->
        result.add(recordMapper.invoke(rowCursor))
      }
    }
    return result
  }

  fun getFlow(): Flow<List<T>> {
    // defer query until first flow
    starter
    return callbackFlow<List<T>> {
      val listener: () -> Unit = {
        cached?.let { channel.offer(it) }
      }
      listener.invoke()
      onCacheChangeListener.add(listener)
      awaitClose {
        onCacheChangeListener.remove(listener)
      }
    }.distinctUntilChanged()
  }
}
