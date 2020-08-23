package com.nlgtuankiet.fera.data.ffmpeg.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class FFprobeFormatOutput(
  @Json(name = "streams")
  val streams: List<FFprobeStream>,
  @Json(name = "format")
  val format: FFprobeFormat,
)

@JsonClass(generateAdapter = true)
data class FFprobeFormat(
  @Json(name = "format_name")
  val name: String,
  // TODO where is it?
//  @Json(name = "format_long_name")
//  val longName: String
)

@JsonClass(generateAdapter = true)
data class FFprobeStream(
  @Json(name = "index")
  val index: Int,
  @Json(name = "codec_name")
  val codecName: String?,
  @Json(name = "codec_long_name")
  val codecLongName: String?,
  @Json(name = "profile")
  val profile: String?,
  @Json(name = "codec_type")
  val codecType: String?,
  @Json(name = "codec_time_base")
  val codecTimeBase: String,
  @Json(name = "codec_tag")
  val codecTag: String,
  @Json(name = "codec_tag_string")
  val codecTagString: String,
  @Json(name = "extradata")
  val extraData: String?,
  @Json(name = "extradata_hash")
  val extradataHash: String?,
  @Json(name = "id")
  val id: String?,
  @Json(name = "r_frame_rate")
  val rFrameRate: String,
  @Json(name = "avg_frame_rate")
  val avgFrameRate: String,
  @Json(name = "time_base")
  val timeBase: String,
  @Json(name = "start_pts")
  val startPts: Long?,
  @Json(name = "start_time")
  val startTime: Float?,
  @Json(name = "duration_ts")
  val durationTs: Long?,
  @Json(name = "duration")
  val duration: Float?,
  @Json(name = "bit_rate")
  val bitRate: Int?,
  @Json(name = "max_bit_rate")
  val maxBitRate: Int?,
  @Json(name = "bits_per_raw_sample")
  val bitsPerRawSample: Int?,
  @Json(name = "nb_frames")
  val nbFrames: Int?,
  @Json(name = "nb_read_frames")
  val nbReadFrames: Int?,
  @Json(name = "nb_read_packets")
  val nbReadPackets: Int?,

  // audio
  @Json(name = "sample_fmt")
  val sampleFmt: String?,
  @Json(name = "sample_rate")
  val sampleRate: Long?,
  @Json(name = "channels")
  val channels: Int?,
  @Json(name = "channel_layout")
  val channelLayout: String?,
  @Json(name = "bits_per_sample")
  val bitsPerSample: Int?,

  // video
  @Json(name = "width")
  val width: Int?,
  @Json(name = "height")
  val height: Int?,
  @Json(name = "coded_width")
  val codedWidth: Int?,
  @Json(name = "coded_height")
  val codedHeight: Int?,
  @Json(name = "closed_captions")
  val closedCaptions: Boolean?,
  @Json(name = "has_b_frames")
  val hasBFrames: Int?,
  @Json(name = "sample_aspect_ratio")
  val sampleAspectRatio: String?,
  @Json(name = "display_aspect_ratio")
  val displayAspectRatio: String?,
  @Json(name = "pix_fmt")
  val pixFmt: String?,
  @Json(name = "level")
  val level: Int?,
  @Json(name = "color_range")
  val color_range: String?,
  @Json(name = "color_space")
  val color_space: String?,
  @Json(name = "color_transfer")
  val color_transfer: String?,
  @Json(name = "color_primaries")
  val color_primaries: String?,
  @Json(name = "chroma_location")
  val chroma_location: String?,
  @Json(name = "field_order")
  val field_order: String?,
  @Json(name = "timecode")
  val timeCode: String?,
  @Json(name = "refs")
  val refs: Int?
)
