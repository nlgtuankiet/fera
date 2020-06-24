package com.nlgtuankiet.fera.domain.repository

import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import kotlinx.coroutines.flow.Flow

interface MediaFileRepository {
  fun getRecentFiles(limit: Int): Flow<List<MediaFile>>
  fun getMediaFiles(type: MediaType): Flow<List<MediaFile>>
}
