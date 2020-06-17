package com.nlgtuankiet.fera.domain.entity

import java.time.Instant

data class MediaFile(
  val name: String,
  val type: MediaType,
  val date: String,
  val path: FilePath,
  val modifiedAt: Instant = Instant.now()
)