package com.nlgtuankiet.fera.initializer

import android.content.Context

fun initializeGlide(context: Context) {
  Class.forName("com.nlgtuankiet.fera.image.GlideInitializer")
    .newInstance().let {
      @Suppress("UNCHECKED_CAST")
      it as Function1<Context, Unit>
    }
    .invoke(context)
}
