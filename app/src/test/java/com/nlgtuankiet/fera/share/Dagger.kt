package com.nlgtuankiet.fera.share

import com.nlgtuankiet.fera.dagger.AppBindingModule
import com.nlgtuankiet.fera.dagger.AppProvisionModule
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import com.squareup.moshi.Moshi
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(
  modules = [
    AppProvisionModule::class,
    FFmpegModule::class,
    AppBindingModule::class
  ]
)
@Singleton
interface TestComponent {
  fun moshi(): Moshi
  fun getMediaInfo(): GetMediaInfo
}

@Module
object LocalFFmpegModule {
  @Provides
  @JvmStatic
  @Singleton
  @FFmpegPath
  fun ffmpegPath(): String {
    return "ffmpeg"
  }

  @Provides
  @JvmStatic
  @Singleton
  @FFprobePath
  fun ffprobePath(): String {
    return "ffprobe"
  }
}

fun testComponent(): TestComponent {
  return DaggerTestComponent.create()
}

fun moshi(): Moshi {
  return testComponent().moshi()
}
