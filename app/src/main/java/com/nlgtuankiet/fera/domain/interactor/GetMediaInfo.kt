package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import javax.inject.Inject

class GetMediaInfo @Inject constructor(
  private val ffmpegGateway: FFmpegGateway
) {
  suspend operator fun invoke(input: String): MediaInfo {
    return ffmpegGateway.getMediaInfo(input = input)
  }
}