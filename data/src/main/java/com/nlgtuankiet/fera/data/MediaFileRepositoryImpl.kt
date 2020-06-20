package com.nlgtuankiet.fera.data

import android.content.Context
import android.database.ContentObserver
import android.database.Cursor
import android.net.Uri
import android.os.CancellationSignal
import android.os.Handler
import android.os.Looper
import android.provider.MediaStore
import androidx.core.database.getStringOrNull
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.entity.FilePath
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@OptIn(ExperimentalStdlibApi::class)
class MediaFileRepositoryImpl @Inject constructor(
  private val context: Context
) : MediaFileRepository {
  private val contentHandler by lazy {
    Handler(Looper.getMainLooper())
  }

  override suspend fun getRecentFiles(limit: Int): Flow<List<MediaFile>> {
    val imageSource = getRecentMediaFilesInternal(
      uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
      type = MediaType.Image,
      limit = 4
    )

    val videoSource = getRecentMediaFilesInternal(
      uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
      type = MediaType.Video,
      limit = 4
    )

    val audioSource = getRecentMediaFilesInternal(
      uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
      type = MediaType.Audio,
      limit = 4
    )

    return combine(imageSource, videoSource, audioSource) { image, video, audio ->
      sequence {
        yieldAll(image)
        yieldAll(video)
        yieldAll(audio)
      }.sortedByDescending { it.date }.take(limit).toList()
    }.distinctUntilChanged().onEach { println("onEach: $it") }
  }

  private fun getRecentMediaFilesInternal(
    uri: Uri,
    type: MediaType,
    limit: Int
  ): Flow<List<MediaFile>> {

    return query(
      uri = uri,
      projection = arrayOf(
        @Suppress("DEPRECATION")
        MediaStore.MediaColumns.DATA,
        MediaStore.MediaColumns.DISPLAY_NAME,
        MediaStore.MediaColumns.DATE_MODIFIED,
      ),
      sortOrder = MediaStore.MediaColumns.DATE_MODIFIED,
      sortDirection = SortDirection.Descending,
      limit = limit,
    ) { cursor ->
      MediaFile(
        name = cursor.requireString(MediaStore.MediaColumns.DISPLAY_NAME),
        type = type,
        date = cursor.requireString(MediaStore.MediaColumns.DATE_MODIFIED),
        path = FilePath(cursor.requireString(MediaStore.MediaColumns.DATA)),
      )
    }.distinctUntilChanged()
  }

  /**
   *           MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
   arrayOf(),
   null,
   null,
   MediaStore.Video.Media.DATE_MODIFIED
   */

  @OptIn(ExperimentalCoroutinesApi::class)
  private fun <T> query(
    uri: Uri,
    projection: Array<String>? = null,
    selection: String? = null,
    selectionArgs: Array<String>? = null,
    sortOrder: String? = null,
    sortDirection: SortDirection = SortDirection.Ascending,
    limit: Int? = null,
    cursorMapper: (Cursor) -> T
  ): Flow<List<T>> = callbackFlow {
    val cancellationSignal = CancellationSignal()
    val observer = object : ContentObserver(contentHandler) {
      override fun onChange(selfChange: Boolean) {
        super.onChange(selfChange)
        if (channel.isClosedForSend) {
          return
        }
        val sortStatement = buildString {
          if (sortOrder != null) {
            append(sortOrder)
            when (sortDirection) {
              SortDirection.Ascending -> append(" ASC")
              SortDirection.Descending -> append(" DESC")
            }
          }
          if (limit != null) {
            append(" LIMIT $limit")
          }
        }.trim()
        val cursor = context.contentResolver.query(
          uri,
          projection,
          selection,
          selectionArgs,
          sortStatement,
          cancellationSignal
        )
        val result = mutableListOf<T>()
        requireNotNull(cursor).use {
          cursor.forEach {
            if (channel.isClosedForSend) {
              return
            }
            result.add(cursorMapper.invoke(it))
          }
        }

        channel.offer(result)
      }
    }
    if (!channel.isClosedForSend) {
      // TODO notifyForDescendants or not?
      context.contentResolver.registerContentObserver(uri, true, observer)
      observer.onChange(true)
    }
    awaitClose {
      cancellationSignal.cancel()
      context.contentResolver.unregisterContentObserver(observer)
    }
  }

  private enum class SortDirection {
    Ascending,
    Descending,
  }

  private inline fun <T> Cursor.map(block: (Cursor) -> T): List<T> {
    val result = mutableListOf<T>()
    while (this.moveToNext()) {
      result.add(block(this))
    }
    return result
  }

  private inline fun <T> Cursor.forEach(block: (Cursor) -> T) {
    while (this.moveToNext()) {
      block(this)
    }
  }

  private fun Cursor.requireString(columnName: String): String {
    return requireNotNull(getStringOrNull(getColumnIndex(columnName)))
  }
}
