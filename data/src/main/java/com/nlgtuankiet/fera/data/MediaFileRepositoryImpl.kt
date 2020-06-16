package com.nlgtuankiet.fera.data

import android.content.Context
import android.provider.MediaStore
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.entity.MediaFile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MediaFileRepositoryImpl @Inject constructor(
  private val context: Context
): MediaFileRepository {
  override suspend fun getRecentFiles(limit: Int): Flow<List<MediaFile>> {
    val cursor = context.contentResolver.query(
      MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
      arrayOf(MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DATE_MODIFIED),
      null,
      null,
      MediaStore.Video.Media.DATE_MODIFIED
    )
    TODO()
  }
}