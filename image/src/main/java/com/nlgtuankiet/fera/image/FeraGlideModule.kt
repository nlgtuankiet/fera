package com.nlgtuankiet.fera.image

import android.content.Context
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.nlgtuankiet.fera.core.BuildConfig
import com.nlgtuankiet.fera.core.coreComponent
import java.io.InputStream

@GlideModule
class FeraGlideModule : AppGlideModule() {

  override fun isManifestParsingEnabled(): Boolean {
    return false
  }

  override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
    registry.replace(
      GlideUrl::class.java,
      InputStream::class.java,
      OkHttpUrlLoader.Factory(context.coreComponent.callFactory)
    )
  }

  override fun applyOptions(context: Context, builder: GlideBuilder) {
    builder.apply {
      // log
      val logLevel = if (BuildConfig.DEBUG) {
        Log.VERBOSE
      } else {
        Log.ASSERT
      }
      setLogLevel(logLevel)

      // default request options
      val defaultRequestOption = RequestOptions().apply {
        format(DecodeFormat.PREFER_ARGB_8888)
      }
      setDefaultRequestOptions(defaultRequestOption)
    }
  }
}