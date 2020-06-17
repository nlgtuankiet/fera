package com.nlgtuankiet.fera.share

import com.nlgtuankiet.fera.core.FFmpegPath
import com.nlgtuankiet.fera.core.FFprobePath
import com.nlgtuankiet.fera.dagger.AppBindingModule
import com.nlgtuankiet.fera.dagger.AppProvisionModule
import com.nlgtuankiet.fera.data.DataBindingModule
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import com.squareup.moshi.Moshi
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(
  modules = [
    DataBindingModule::class,
    FakeDataProvisionModule::class,
    AppProvisionModule::class,
    AppBindingModule::class,
  ]
)
@Singleton
interface TestComponent {
  fun moshi(): Moshi
  fun getMediaInfo(): GetMediaInfo
}

fun testComponent(): TestComponent {
  return DaggerTestComponent.create()
}

fun moshi(): Moshi {
  return testComponent().moshi()
}

@Module
object FakeDataProvisionModule {

  @JvmStatic
  @Provides
  @Singleton
  fun moshi(): Moshi {
    return Moshi.Builder()
      .build()
  }

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
