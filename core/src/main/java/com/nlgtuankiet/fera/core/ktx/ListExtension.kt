package com.nlgtuankiet.fera.core.ktx

@Suppress("NOTHING_TO_INLINE")
inline fun <T> List<T>.second(): T {
  return get(1)
}
