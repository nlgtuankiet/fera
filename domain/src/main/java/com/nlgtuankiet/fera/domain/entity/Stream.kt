package com.nlgtuankiet.fera.domain.entity

data class VideoStream(
  override val index: Int,
  val codec: Codec,
  val codecLongName: String?,
  val profile: String?,
  val codecTimeBase: String,
  val codecTag: String,
  val codecTagString: String,
  val size: Size,
  val ratio: String,
  val frameRate: Double,
  val bitRate: Long,
) : Stream

data class AudioStream(
  override val index: Int,
  val codec: Codec,
  val codecLongName: String?,
  val profile: String?,
  val codecTimeBase: String,
  val codecTag: String,
  val codecTagString: String,
  val sampleRate: Long,
  val channels: Int,
  val bitRate: Long
) : Stream

interface Stream {
  val index: Int
}
