package com.nlgtuankiet.fera.core

import android.content.Context
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import okhttp3.Call

interface CoreComponent {
  val ffmpegGateway: FFmpegGateway
  val mediaFileRepository: MediaFileRepository
  val callFactory: Call.Factory
}

interface HasCoreComponent {
  val coreComponent: CoreComponent
}

val Context.coreComponent: CoreComponent
  get() = (this.applicationContext as HasCoreComponent).coreComponent
