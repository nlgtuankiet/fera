package com.nlgtuankiet.fera.domain.gateway

import com.nlgtuankiet.fera.domain.entity.FormatOption
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.StreamOption

interface FFmpegGateway {
  suspend fun convert(
    input: Path,
    mediaInfo: MediaInfo,
    formatOption: FormatOption?,
    streamOptions: Map<Int, StreamOption>,
    output: Path
  )
  suspend fun getMediaInfo(input: String): MediaInfo
  suspend fun runRawCommand(command: String, useFfmpeg: Boolean = true): String
}
