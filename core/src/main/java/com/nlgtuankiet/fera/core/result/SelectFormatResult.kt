package com.nlgtuankiet.fera.core.result

import com.nlgtuankiet.fera.domain.entity.EncoderCode
import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.MuxerCode


data class SelectFormatResult(
  val extension: Extension,
  val muxerCode: MuxerCode,
)

data class SelectVideoEncoderResult(
  val encoderCode: EncoderCode,
)

enum class SelectType {
  Muxer,
  VideoEncoder,
}