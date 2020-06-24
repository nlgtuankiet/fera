package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.Storage
import com.nlgtuankiet.fera.domain.repository.StorageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStorage @Inject constructor(
  private val storageRepository: StorageRepository
) {
  operator fun invoke(): Flow<List<Storage>> {
    return storageRepository.getStorage()
  }
}
