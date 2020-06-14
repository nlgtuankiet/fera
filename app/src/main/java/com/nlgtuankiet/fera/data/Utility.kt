package com.nlgtuankiet.fera.data

import android.os.Looper

fun assertNotMainThread() {
  require(Looper.myLooper() != Looper.getMainLooper()) {
    "On main thread!"
  }
}

