package com.nlgtuankiet.fera.domain.entity

data class MediaFile(
  val name: String,
  val type: MediaType,
  val dateModified: EpochSecond,
  val path: Path,
//  val modifiedAt: Instant = Instant.now() // TODO problem with lint check
)
