package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.repository.MediaFileRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMediaFiles @Inject constructor(
  private val mediaFileRepository: MediaFileRepository
) {
  operator fun invoke(type: MediaType): Flow<List<MediaFile>> {
    return mediaFileRepository.getMediaFiles(type = type)
  }
}
