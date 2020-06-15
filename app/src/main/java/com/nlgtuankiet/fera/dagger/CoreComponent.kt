package com.nlgtuankiet.fera.dagger

import android.content.Context
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway


interface CoreComponent {
  val ffmpegGateway: FFmpegGateway
}

interface HasCoreComponent {
  val coreComponent: CoreComponent
}

val Context.coreComponent: CoreComponent
  get() = (this.applicationContext as HasCoreComponent).coreComponent