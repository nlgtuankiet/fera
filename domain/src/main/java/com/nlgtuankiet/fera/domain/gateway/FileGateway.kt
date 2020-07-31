package com.nlgtuankiet.fera.domain.gateway

import com.nlgtuankiet.fera.domain.entity.Path

interface FileGateway {
  suspend fun isExits(path: Path): Boolean
}