package com.nlgtuankiet.fera.domain.entity

inline class CodecCode(val value: String)

@Suppress("NOTHING_TO_INLINE")
inline fun String.asCodecCode(): CodecCode = CodecCode(this)

inline class DecoderCode(val value: String)

@Suppress("NOTHING_TO_INLINE")
inline fun String.asDecoderCode(): DecoderCode = DecoderCode(this)

inline class EncoderCode(val value: String)

@Suppress("NOTHING_TO_INLINE")
inline fun String.asEncoderCode(): EncoderCode = EncoderCode(this)

enum class CodecType {
  Video,
  Audio,
  Subtitle,
  Data,
}

class Codec(
  val code: CodecCode,
  val decoder: List<DecoderCode>? = null,
  val encoder: List<EncoderCode>? = null,
  val description: String,
  val canDecode: Boolean,
  val canEncode: Boolean,
  val type: CodecType,
  val isIntraFrameOnly: Boolean,
  val canCompressLossy: Boolean,
  val canCompressLossless: Boolean
)
