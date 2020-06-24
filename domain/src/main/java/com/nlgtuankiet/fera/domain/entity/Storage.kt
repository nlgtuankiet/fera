package com.nlgtuankiet.fera.domain.entity

import java.nio.file.Path

data class Storage(
  val name: String,
  val path: Path,
  val availableBytes: Long,
  val totalBytes: Long
)
