package com.nlgtuankiet.fera.data

import android.net.Uri

data class QueryParams(
  val uri: Uri,
  val projection: List<String>? = null,
  val selection: String? = null,
  val selectionArgs: List<String>? = null,
  val sortOrder: String? = null,
  val sortDirection: SortDirection = SortDirection.Ascending,
  val limit: Int? = null,
)

enum class SortDirection {
  Ascending,
  Descending,
}
