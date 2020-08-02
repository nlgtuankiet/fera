package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.FormatOption
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.StreamOption
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import javax.inject.Inject


class Convert @Inject constructor(
  private val fFmpegGateway: FFmpegGateway
) {
  suspend operator fun invoke(
    input: Path,
    mediaInfo: MediaInfo,
    formatOption: FormatOption?,
    streamOptions: Map<Int, StreamOption>,
    output: Path,
  ) {
    fFmpegGateway.convert(input, mediaInfo, formatOption, streamOptions, output)
  }
}