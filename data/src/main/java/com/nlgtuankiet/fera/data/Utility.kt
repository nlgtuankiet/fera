package com.nlgtuankiet.fera.data

import android.database.Cursor
import android.os.Looper
import androidx.core.database.getStringOrNull

fun assertNotMainThread() {
  require(Looper.myLooper() != Looper.getMainLooper()) {
    "On main thread!"
  }
}

inline fun <T> Cursor.map(block: (Cursor) -> T): List<T> {
  val result = mutableListOf<T>()
  while (this.moveToNext()) {
    result.add(block(this))
  }
  return result
}

inline fun <T> Cursor.forEach(crossinline block: (Cursor) -> T) {
  while (this.moveToNext()) {
    block(this)
  }
}

fun Cursor.requireString(columnName: String): String {
  return requireNotNull(getStringOrNull(getColumnIndex(columnName)))
}
