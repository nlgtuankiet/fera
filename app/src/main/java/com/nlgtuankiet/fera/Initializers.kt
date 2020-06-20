package com.nlgtuankiet.fera

import android.content.Context
import android.os.StrictMode

fun initialize(context: Context) {
  setupStrictMode()
  initializeGlide(context)
}

fun setupStrictMode() {
  if (!BuildConfig.DEBUG) {
    return
  }
  val threadPolicy = StrictMode.ThreadPolicy.Builder().apply {
    detectCustomSlowCalls()
    detectResourceMismatches()
    detectUnbufferedIo()
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

fun initializeGlide(context: Context) {
  Class.forName("com.nlgtuankiet.fera.image.GlideInitializer")
    .newInstance().let {
      @Suppress("UNCHECKED_CAST")
      it as Function1<Context, Unit>
    }
    .invoke(context)
}