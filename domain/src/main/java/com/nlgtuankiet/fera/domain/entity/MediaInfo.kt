package com.nlgtuankiet.fera.domain.entity

data class MediaInfo(
  val streams: List<Stream>,
  val format: Format,
)

data class Format(
  val name: String,
  val longName: String,
)
