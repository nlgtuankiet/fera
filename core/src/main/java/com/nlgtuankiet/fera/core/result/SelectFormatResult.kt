package com.nlgtuankiet.fera.core.result

import com.nlgtuankiet.fera.domain.entity.CodecCode
import com.nlgtuankiet.fera.domain.entity.DecoderCode
import com.nlgtuankiet.fera.domain.entity.EncoderCode
import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.MuxerCode


data class SelectFormatResult(
  val extension: Extension,
  val muxerCode: MuxerCode,
)

data class SelectVideoEncoderResult(
  val codecCode: CodecCode,
  val encoderCode: EncoderCode,
  val hasManyEncoder: Boolean,
)

enum class SelectType {
  Muxer,
  VideoEncoder,
}