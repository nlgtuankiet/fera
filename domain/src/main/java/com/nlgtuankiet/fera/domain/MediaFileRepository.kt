package com.nlgtuankiet.fera.domain

import com.nlgtuankiet.fera.domain.entity.MediaFile
import kotlinx.coroutines.flow.Flow

interface MediaFileRepository {
  suspend fun getRecentFiles(limit: Int): Flow<List<MediaFile>>
}
