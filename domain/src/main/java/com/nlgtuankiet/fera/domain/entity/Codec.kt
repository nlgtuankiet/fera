package com.nlgtuankiet.fera.domain.entity

inline class CodecCode(val value: String)

enum class CodecType {
  Video,
  Audio,
  Subtitle,
  Data,
}

class Codec(
  val code: CodecCode,
  val description: String,
  val canDecode: Boolean,
  val canEncode: Boolean,
  val type: CodecType,
  val isIntraFrameOnly: Boolean,
  val canCompressLossy: Boolean,
  val canCompressLossless: Boolean
)
