package com.nlgtuankiet.fera.domain.entity

data class MediaInfo(
  val streams: List<Stream>,
  val format: MediaFormat,
)

data class MediaFormat(
  val name: String,
  val longName: String,
)
