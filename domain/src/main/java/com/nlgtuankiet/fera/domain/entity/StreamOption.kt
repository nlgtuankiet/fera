package com.nlgtuankiet.fera.domain.entity

// TODO support for codec option
data class VideoStreamOption(
  // -r:v:0 30
  val rate: FramePerSecond? = null,

  // -s:v:0 300x300
  val size: Size? = null,

  // -c:v:0 libx264
  val encoderCode: EncoderCode? = null,

  // -b:v:0
  val bitrate: Bit? = null,
) : StreamOption {
  override fun isEmpty(): Boolean {
    return rate == null
        && size == null
        && encoderCode == null
        && bitrate == null
  }
}


interface StreamOption {
  fun isEmpty(): Boolean
}