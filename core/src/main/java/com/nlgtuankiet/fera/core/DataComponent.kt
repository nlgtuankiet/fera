package com.nlgtuankiet.fera.core

import android.content.Context
import android.os.storage.StorageManager
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.repository.MediaFileRepository
import com.nlgtuankiet.fera.domain.repository.StorageRepository
import okhttp3.Call

interface DataComponent {
  val ffmpegGateway: FFmpegGateway
  val mediaFileRepository: MediaFileRepository
  val callFactory: Call.Factory
  val storageRepository: StorageRepository
  val storageManage: StorageManager

  interface DataComponentProvider {
    fun get(context: Context): DataComponent
  }
}
