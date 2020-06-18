package com.nlgtuankiet.fera.data

import android.content.Context
import androidx.annotation.Keep
import com.nlgtuankiet.fera.core.DataComponent
import com.nlgtuankiet.fera.core.FFmpegPath
import com.nlgtuankiet.fera.core.FFprobePath
import com.nlgtuankiet.fera.domain.MediaFileRepository
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Singleton

@Component(
  modules = [
    DataProvisionModule::class,
    DataBindingModule::class
  ]
)
@Singleton
interface DataComponentImpl : DataComponent {

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance context: Context): DataComponent
  }
}

@Module
interface DataBindingModule {
  @Binds
  fun ffmpegGateway(impl: CommandLineFFmpegGateway): FFmpegGateway

  @Binds
  fun mediaFileRepository(impl: MediaFileRepositoryImpl): MediaFileRepository
}

@Module
object DataProvisionModule {

  @JvmStatic
  @Provides
  @Singleton
  fun moshi(): Moshi {
    return Moshi.Builder()
      .build()
  }

  @JvmStatic
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
  @JvmStatic
  @Singleton
  @FFmpegPath
  fun ffmpegPath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!
      .find("libffmpeg.so")!!.absolutePath
  }

  @Provides
  @JvmStatic
  @Singleton
  @FFprobePath
  fun ffprobePath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!
      .find("libffprobe.so")!!.absolutePath
  }
}

@Keep
class DataComponentProvider :
  DataComponent.DataComponentProvider {
  override fun get(context: Context): DataComponent {
    return DaggerDataComponentImpl.factory().create(context)
  }
}
