package com.nlgtuankiet.fera.browse.model

import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.entity.Path

data class MediaGroup(
  val name: String,
  val path: Path,
  val total: Int,
  val type: MediaType,
  val medias: List<MediaFile>
) {
  init {
    require(medias.isNotEmpty())
  }
}
