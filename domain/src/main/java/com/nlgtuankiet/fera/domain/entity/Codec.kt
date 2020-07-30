package com.nlgtuankiet.fera.domain.entity

inline class CodecCode(val value: String)

fun codecCodeOf(value: String): CodecCode {
  require(value.isNotBlank())
  return CodecCode(value)
}

@Suppress("NOTHING_TO_INLINE")
inline fun String.asCodecCode(): CodecCode = CodecCode(this)

inline class DecoderCode(val value: String)

fun decoderCodeOf(value: String): DecoderCode {
  require(value.isNotBlank())
  return DecoderCode(value)
}

@Suppress("NOTHING_TO_INLINE")
inline fun String.asDecoderCode(): DecoderCode = DecoderCode(this)

inline class EncoderCode(val value: String)

fun encoderCodeOf(value: String): EncoderCode {
  require(value.isNotBlank())
  return EncoderCode(value)
}

@Suppress("NOTHING_TO_INLINE")
inline fun String.asEncoderCode(): EncoderCode = EncoderCode(this)

enum class CodecType {
  Video,
  Audio,
  Subtitle,
  Data,
}

data class Codec(
  val code: CodecCode,
  val decoders: List<DecoderCode>? = null,
  val encoders: List<EncoderCode>? = null,
  val canDecode: Boolean,
  val canEncode: Boolean,
  val type: CodecType,
  val isIntraFrameOnly: Boolean,
  val canCompressLossy: Boolean,
  val canCompressLossless: Boolean
)
