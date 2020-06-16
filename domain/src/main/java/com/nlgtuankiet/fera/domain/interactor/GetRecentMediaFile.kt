package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.entity.MediaFile
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRecentMediaFile @Inject constructor(
  private val mediaFileRepository: MediaFileRepository
) {
  suspend operator fun invoke(limit: Int = 4): Flow<List<MediaFile>> {
    return mediaFileRepository.getRecentFiles(limit = limit)
  }
}