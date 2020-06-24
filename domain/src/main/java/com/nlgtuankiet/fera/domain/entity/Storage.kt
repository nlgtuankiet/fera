package com.nlgtuankiet.fera.domain.entity

data class Storage(
  val name: String,
  val path: Path,
  val availableBytes: Long,
  val totalBytes: Long
)
