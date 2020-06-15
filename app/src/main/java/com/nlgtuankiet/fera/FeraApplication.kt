package com.nlgtuankiet.fera

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

class FeraApplication : Application() {
  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }
}