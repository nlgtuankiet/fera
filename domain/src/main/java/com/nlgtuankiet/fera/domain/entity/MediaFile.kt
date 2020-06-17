package com.nlgtuankiet.fera.domain.entity

data class MediaFile(
  val name: String,
  val type: MediaType,
  val date: String,
  val path: FilePath,
//  val modifiedAt: Instant = Instant.now() // TODO problem with lint check
)
