package com.nlgtuankiet.fera.initializer

import android.content.Context

fun initialize(context: Context) {
  setupStrictMode()
  initializeGlide(context)
  initializeEpoxy(context)
}
