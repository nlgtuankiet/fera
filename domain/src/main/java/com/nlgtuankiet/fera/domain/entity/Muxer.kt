package com.nlgtuankiet.fera.domain.entity

inline class MuxerCode(val value: String)

fun muxerCodeOf(value: String): MuxerCode {
  require(value.isNotBlank())
  return MuxerCode(value)
}

data class Muxer(
  val code: MuxerCode,
  val canMuxing: Boolean,
  val canDemuxing: Boolean,
  val commonExtension: Set<Extension> = emptySet(),
  val defaultVideoCodec: CodecCode? = null,
  val defaultAudioCodec: CodecCode? = null,
  val defaultSubtitleCodec: CodecCode? = null,
)