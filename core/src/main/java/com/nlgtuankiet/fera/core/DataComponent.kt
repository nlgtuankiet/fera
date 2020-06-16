package com.nlgtuankiet.fera.core

import android.content.Context
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway

interface DataComponent {
  val ffmpegGateway: FFmpegGateway

  interface DataComponentProvider {
    fun get(context: Context): DataComponent
  }
}