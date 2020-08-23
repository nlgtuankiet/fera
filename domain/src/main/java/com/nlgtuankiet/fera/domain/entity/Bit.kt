package com.nlgtuankiet.fera.domain.entity

inline class Bit(val value: Long)

fun bitOf(value: Long): Bit {
  require(value > 0)
  return Bit(value)
}
