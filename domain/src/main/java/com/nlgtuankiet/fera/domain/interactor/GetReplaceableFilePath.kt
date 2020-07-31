package com.nlgtuankiet.fera.domain.interactor

import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.append
import com.nlgtuankiet.fera.domain.entity.name
import com.nlgtuankiet.fera.domain.entity.parent
import com.nlgtuankiet.fera.domain.gateway.FileGateway
import javax.inject.Inject

class GetReplaceableFilePath @Inject constructor(
  private val fileGateway: FileGateway
) {

  suspend operator fun invoke(path: Path): Path {
    val name = path.name
    val nameWithoutExtension = name.substringBeforeLast('.')
    val extension = name.substringAfterLast('.', "")
    var no = 2
    while (true) {
      val candidate = path.parent.append("${nameWithoutExtension}~${no}.${extension}")
      if (!fileGateway.isExits(candidate)) {
        return candidate
      }
      no++
    }
  }
}