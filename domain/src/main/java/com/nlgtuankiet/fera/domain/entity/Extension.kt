package com.nlgtuankiet.fera.domain.entity

inline class Extension(val value: String)

fun extensionOf(value: String): Extension {
  require(value.isNotBlank())
  return Extension(value)
}
