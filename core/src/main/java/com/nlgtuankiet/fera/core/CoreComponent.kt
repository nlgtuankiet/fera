package com.nlgtuankiet.fera.core

import android.content.Context
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway

interface CoreComponent {
  val ffmpegGateway: FFmpegGateway
  val mediaFileRepository: MediaFileRepository
}

interface HasCoreComponent {
  val coreComponent: CoreComponent
}

val Context.coreComponent: CoreComponent
  get() = (this.applicationContext as HasCoreComponent).coreComponent
