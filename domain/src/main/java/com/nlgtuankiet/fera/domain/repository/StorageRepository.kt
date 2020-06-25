package com.nlgtuankiet.fera.domain.repository

import com.nlgtuankiet.fera.domain.entity.Storage
import kotlinx.coroutines.flow.Flow

interface StorageRepository {
  fun getStorage(): Flow<List<Storage>>
}
