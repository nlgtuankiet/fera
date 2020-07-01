package com.nlgtuankiet.fera.data

import android.content.Context
import android.os.storage.StorageManager
import androidx.annotation.Keep
import com.nlgtuankiet.fera.core.DataComponent
import com.nlgtuankiet.fera.core.FFmpegPath
import com.nlgtuankiet.fera.core.FFprobePath
import com.nlgtuankiet.fera.core.LibraryPath
import com.nlgtuankiet.fera.core.ktx.requireService
import com.nlgtuankiet.fera.data.ffmpeg.setLibraryPath
import com.nlgtuankiet.fera.domain.Log
import com.nlgtuankiet.fera.domain.entity.asPath
import com.nlgtuankiet.fera.domain.entity.parent
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.gateway.TimeGateway
import com.nlgtuankiet.fera.domain.repository.MediaFileRepository
import com.nlgtuankiet.fera.domain.repository.StorageRepository
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import javax.inject.Provider
import javax.inject.Singleton

@Component(
  modules = [
    DataProvisionModule::class,
    DataBindingModule::class
  ]
)
@Singleton
interface DataComponentImpl : DataComponent {

  @get:LibraryPath
  val libraryPath: Provider<String>

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): DataComponentImpl
  }
}

@Module
@Suppress("unused")
interface DataBindingModule {
  @Binds
  fun ffmpegGateway(impl: CommandLineFFmpegGateway): FFmpegGateway

  @Binds
  @ExperimentalCoroutinesApi
  fun mediaFileRepository(impl: MediaFileRepositoryImpl): MediaFileRepository

  @Binds
  fun storageRepository(impl: StorageRepositoryImpl): StorageRepository

  @Binds
  fun timeGateway(impl: TimeGatewayImpl): TimeGateway
}

@Module
object DataProvisionModule {

  @Provides
  @Singleton
  fun moshi(): Moshi {
    return Moshi.Builder()
      .build()
  }

  @Provides
  @Singleton
  fun okHttpClient(): OkHttpClient {
    assertNotMainThread()
    return OkHttpClient.Builder()
      .build()
  }

  @Provides
  fun callFactory(clientProvider: Provider<OkHttpClient>): Call.Factory {
    return object : Call.Factory {
      override fun newCall(request: Request): Call {
        return clientProvider.get().newCall(request)
      }
    }
  }

  @Provides
  fun storageManager(context: Context): StorageManager {
    return context.requireService()
  }

  private fun File.find(name: String): File? {
    if (isDirectory) {
      listFiles()?.forEach {
        val found = it.find(name)
        if (found != null) {
          return found
        }
      }
    } else {
      if (getName() == name) {
        return this
      }
    }
    return null
  }

  @Provides
  @Singleton
  @FFmpegPath
  fun ffmpegPath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!
      .find("libffmpeg.so")!!.absolutePath.also { Log("ffmpeg path is $it") }
  }

  @Provides
  @Singleton
  @LibraryPath
  fun libraryPath(@FFmpegPath fFmpegPath: String): String {
    assertNotMainThread()
    return fFmpegPath.asPath().parent.value
  }

  @Provides
  @Singleton
  @FFprobePath
  fun ffprobePath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!
      .find("libffprobe.so")!!.absolutePath
  }
}

@Keep
@Suppress("unused")
class DataComponentProvider :
  DataComponent.DataComponentProvider {
  override fun get(context: Context): DataComponent {
    return DaggerDataComponentImpl.factory().create(context).also {
      setLibraryPath(it.libraryPath)
    }
  }
}
