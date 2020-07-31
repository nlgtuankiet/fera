package com.nlgtuankiet.fera.data

import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.gateway.FileGateway
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FileGatewayImpl @Inject constructor() : FileGateway {
  override suspend fun isExits(path: Path): Boolean {
    return File(path.value).exists()
  }
}