package com.nlgtuankiet.fera.core.result

import com.nlgtuankiet.fera.domain.entity.EncoderCode

data class SelectVideoEncoderResult(
  val encoderCode: EncoderCode,
)

enum class SelectType {
  Muxer,
  VideoEncoder,
}
