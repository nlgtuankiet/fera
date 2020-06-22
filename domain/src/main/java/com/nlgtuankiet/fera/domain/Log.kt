package com.nlgtuankiet.fera.domain

object Log {
  @JvmStatic
  operator fun invoke(message: String) {
    println(message)
  }

  fun w(message: String) {
    println("WARN: $message")
  }
}
