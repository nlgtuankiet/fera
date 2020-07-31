package com.nlgtuankiet.fera.domain.entity

inline class FramePerSecond(val value: Double)

fun framePerSecondOf(value: Double): FramePerSecond {
  require(value > 0)
  return FramePerSecond(value)
}