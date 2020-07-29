package com.nlgtuankiet.fera.core.result

import java.util.UUID

fun createNewRequestCode(): String {
  return UUID.randomUUID().toString()
}