package com.nlgtuankiet.fera.domain.entity

import java.nio.file.Path

data class MediaFile(
  val name: String,
  val path: Path, // good ? alternative ?
  val type: MediaType
)