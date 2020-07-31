package com.nlgtuankiet.fera.domain.entity

inline class Path(val value: String)

val Path.parent: Path
  get() = value.substringBeforeLast("/").asPath()

val Path.name: String
  get() = value.substringAfterLast("/")

fun pathOf(value: String): Path {
  return Path(value.removeSuffix("/"))
}

@Suppress("NOTHING_TO_INLINE")
inline fun String.asPath() = Path(this.removeSuffix("/"))
