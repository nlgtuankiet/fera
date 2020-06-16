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
import java.io.File
import java.nio.file.Files
import javax.inject.Singleton


@Component(
  modules = [
    AppModule::class,
    FFmpegModule::class,
    DataBindingModule::class
  ]
)
@Singleton
interface AppComponent : com.nlgtuankiet.fera.core.CoreComponent {
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

  @JvmStatic
  private fun File.find(name: String): File {
    return Files.walk(this.toPath()).filter {
      println(it.toFile().absolutePath)
      it.toFile().run { isFile && this.name == name }
    }.findFirst().get().toFile()
  }

  @Provides
  @JvmStatic
  @Singleton
  @FFmpegPath
  fun ffmpegPath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!.find("libffmpeg.so")
      .absolutePath

  }

  @Provides
  @JvmStatic
  @Singleton
  @FFprobePath
  fun ffprobePath(context: Context): String {
    assertNotMainThread()
    return File(context.packageResourcePath).parentFile!!.find("libffprobe.so")
      .absolutePath
  }


}