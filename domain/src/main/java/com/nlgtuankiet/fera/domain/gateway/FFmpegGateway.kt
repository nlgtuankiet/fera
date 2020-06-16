package com.nlgtuankiet.fera.domain.gateway

import com.nlgtuankiet.fera.domain.entity.MediaInfo

interface FFmpegGateway {
  suspend fun getMediaInfo(input: String): MediaInfo
  suspend fun test(command: String, useFfmpeg: Boolean = true)
}