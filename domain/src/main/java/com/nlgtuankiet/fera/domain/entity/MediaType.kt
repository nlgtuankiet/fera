package com.nlgtuankiet.fera.domain.entity

enum class MediaType {
  Video,
  Image,
  Audio,
}

fun String.asMediaType(): MediaType {
  return when (this) {
    "video" -> MediaType.Video
    "image" -> MediaType.Image
    "audio" -> MediaType.Audio
    else -> error("Unknown type: $this")
  }
}
