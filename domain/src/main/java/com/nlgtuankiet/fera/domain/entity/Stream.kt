package com.nlgtuankiet.fera.domain.entity

data class Stream(
  val index: Int,
  val codec: Codec,
  val codecLongName: String?,
  val profile: String?,
  val codecTimeBase: String,
  val codecTag: String,
  val codecTagString: String
)
