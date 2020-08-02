package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.name
import com.nlgtuankiet.fera.domain.entity.pathOf
import com.nlgtuankiet.fera.domain.gateway.FileGateway
import javax.inject.Inject

class GetReplaceableFilePath @Inject constructor(
  private val fileGateway: FileGateway
) {

  suspend operator fun invoke(input: Path, extension: Extension?): Path {
    val fullName = input.name
    val fileNameWithoutExtension = fullName.substringBeforeLast('.')
    val inputExtension = fullName.substringAfterLast('.', "").trim()
    val outputExtension = extension?.value ?: inputExtension
    var no = 2
    // TODO tracking when no bigger than 100
    while (no < 1000) {
      val candidate = pathOf("${fileNameWithoutExtension}~${no}.${outputExtension}")
      if (!fileGateway.isExits(candidate)) {
        return candidate
      }
      no++
    }
    throw IllegalStateException("Replace file is > 1000")
  }
}