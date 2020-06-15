package com.nlgtuankiet.fera.domain.entity

data class Stream(
  val index: Int,
  val codecName: String?,
  val codecLongName: String?,
  val profile: String?,
  val codecType: String?,
  val codecTimeBase: String,
  val codecTag: String,
  val codecTagString: String
)