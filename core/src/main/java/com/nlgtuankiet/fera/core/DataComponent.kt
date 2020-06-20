package com.nlgtuankiet.fera.core

import android.content.Context
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import okhttp3.Call
import okhttp3.OkHttpClient

interface DataComponent {
  val ffmpegGateway: FFmpegGateway
  val mediaFileRepository: MediaFileRepository
  val okHttpClient: Call.Factory

  interface DataComponentProvider {
    fun get(context: Context): DataComponent
  }
}
