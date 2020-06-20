package com.nlgtuankiet.fera

import android.os.StrictMode

fun setupStrictMode() {
  if (!BuildConfig.DEBUG) {
    return
  }
  val threadPolicy = StrictMode.ThreadPolicy.Builder().apply {
    detectAll()
    penaltyLog()
    penaltyDeath()
  }.build()
  StrictMode.setThreadPolicy(threadPolicy)

  val vmPolicy = StrictMode.VmPolicy.Builder().apply {
    detectAll()
    penaltyLog()
    penaltyDeath()
  }.build()
  StrictMode.setVmPolicy(vmPolicy)
}