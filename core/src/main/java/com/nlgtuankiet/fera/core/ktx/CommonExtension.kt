package com.nlgtuankiet.fera.core.ktx

@Suppress("NOTHING_TO_INLINE")
inline fun <T> T?.notNull(): T = this!!

fun <T, R> Map<T, R>.copy(block: MutableMap<T, R>.() -> Unit): Map<T, R> {
  val instance = toMutableMap()
  block.invoke(instance)
  return instance
}
