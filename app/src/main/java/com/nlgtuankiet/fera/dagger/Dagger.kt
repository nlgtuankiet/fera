package com.nlgtuankiet.fera.dagger

import android.app.Application
import android.content.Context
import com.nlgtuankiet.fera.FeraApplication
import com.nlgtuankiet.fera.MainActivity
import com.nlgtuankiet.fera.data.CommandLineFFmpegGateway
import com.nlgtuankiet.fera.data.assertNotMainThread
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.squareup.moshi.Moshi
import dagger.*
import org.bytedeco.ffmpeg.ffmpeg
import org.bytedeco.ffmpeg.ffprobe
import org.bytedeco.javacpp.Loader
import java.io.File
import javax.inject.Singleton


@Component(
  modules = [
    AppModule::class,
    FFmpegModule::class,
    DataBindingModule::class
  ]
)
@Singleton
interface AppComponent: CoreComponent {
  fun inject(app: FeraApplication)
  fun inject(activity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(@BindsInstance app: FeraApplication): AppComponent
  }
}

@Module
object AppModule {
  @JvmStatic
  @Provides
  @Singleton
  fun moshi(): Moshi {
    return Moshi.Builder()
      .build()
  }
}

@Module
interface DataBindingModule {
  @Binds
  fun ffmpegGateway(impl: CommandLineFFmpegGateway): FFmpegGateway

  @Binds
  fun context(impl: FeraApplication): Context

  @Binds
  fun application(impl: FeraApplication): Application
}

@Module
object FFmpegModule {
  @Provides
  @JvmStatic
  @Singleton
  @FFmpegPath
  fun ffmpegPath(): String {
    assertNotMainThread()
    return Loader.load(ffmpeg::class.java).ensureExecutable()
  }

  @Provides
  @JvmStatic
  @Singleton
  @FFprobePath
  fun ffprobePath(): String {
    assertNotMainThread()
    return Loader.load(ffprobe::class.java).ensureExecutable()
  }

  private fun String.ensureExecutable(): String {
    require(File(this).setExecutable(true))
    return this
  }
}