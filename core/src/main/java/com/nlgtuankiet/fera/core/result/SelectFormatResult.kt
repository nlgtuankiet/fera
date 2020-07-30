package com.nlgtuankiet.fera.core.result

import com.nlgtuankiet.fera.domain.entity.CodecCode
import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.MuxerCode


data class SelectFormatResult(
  val extension: Extension,
  val muxerCode: MuxerCode,
)

data class SelectCodecResult(
  val codecCode: CodecCode,
)

enum class SelectType {
  Muxer,
  VideoDecoder,
}