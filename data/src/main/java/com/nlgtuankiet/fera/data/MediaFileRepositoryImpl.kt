package com.nlgtuankiet.fera.data

import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.HandlerThread
import android.provider.MediaStore
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.entity.asPath
import com.nlgtuankiet.fera.domain.repository.MediaFileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Singleton
class MediaFileRepositoryImpl @Inject constructor(
  private val context: Context
) : MediaFileRepository {
  private val scope = CoroutineScope(Dispatchers.IO + Job())

  // TODO handler reuse
  private val contentHandler by lazy {
    HandlerThread("MediaFileRepositoryImpl").apply {
      start()
    }.let { Handler(it.looper) }
  }

  private val imageProvider = createImageRepository(
    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
    MediaType.Image
  )

  private val videoProvider = createImageRepository(
    MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
    MediaType.Video
  )

  private val audioProvider = createImageRepository(
    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
    MediaType.Audio
  )

  override fun getRecentFiles(limit: Int): Flow<List<MediaFile>> {
    return combine(
      imageProvider.getFlow().map { it.take(limit) },
      videoProvider.getFlow().map { it.take(limit) },
      audioProvider.getFlow().map { it.take(limit) },
    ) { image, video, audio ->
      sequence {
        yieldAll(image)
        yieldAll(video)
        yieldAll(audio)
      }.sortedByDescending { it.dateModified }.take(limit).toList()
    }.distinctUntilChanged().onEach { println("onEach getRecentFiles $it") }
  }

  override fun getMediaFiles(type: MediaType): Flow<List<MediaFile>> {
    val provider = when (type) {
      MediaType.Image -> imageProvider
      MediaType.Video -> videoProvider
      MediaType.Audio -> audioProvider
    }
    return provider.getFlow()
  }

  private fun createImageRepository(
    uri: Uri,
    type: MediaType
  ): CachedContentProviderRepository<MediaFile> {
    return CachedContentProviderRepository(
      context = context,
      scope = scope,
      handler = contentHandler,
      queryParams = QueryParams(
        uri = uri,
        projection = listOf(
          @Suppress("DEPRECATION")
          MediaStore.MediaColumns.DATA,
          MediaStore.MediaColumns.DISPLAY_NAME,
          MediaStore.MediaColumns.DATE_MODIFIED,
        ),
        sortOrder = MediaStore.MediaColumns.DATE_MODIFIED,
        sortDirection = SortDirection.Descending
      )
    ) { cursor ->
      @Suppress("DEPRECATION")
      MediaFile(
        name = cursor.requireString(MediaStore.MediaColumns.DISPLAY_NAME),
        type = type,
        dateModified = cursor.requireLong(MediaStore.MediaColumns.DATE_MODIFIED),
        path = cursor.requireString(MediaStore.MediaColumns.DATA).asPath(),
      )
    }
  }
}
