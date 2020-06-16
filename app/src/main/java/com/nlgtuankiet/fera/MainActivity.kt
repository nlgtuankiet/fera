package com.nlgtuankiet.fera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nlgtuankiet.fera.data.CommandLineFFmpegGateway
import dagger.android.AndroidInjector
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var fragmentFactory: AppFragmentFactory

  @Inject
  lateinit var commandLineFFmpegGateway: Provider<CommandLineFFmpegGateway>

  override fun onCreate(savedInstanceState: Bundle?) {
    @Suppress("UNCHECKED_CAST")
    (this.applicationContext as AndroidInjector<MainActivity>).inject(this)
    supportFragmentManager.fragmentFactory = fragmentFactory
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    GlobalScope.launch(Dispatchers.IO) {
      kotlin.runCatching {
        commandLineFFmpegGateway.get().executeFFmpeg("")
      }.onFailure {
        println(it.message)
        it.printStackTrace()
      }
      kotlin.runCatching {
        commandLineFFmpegGateway.get().executeFFprobe("")
      }.onFailure {
        println(it.message)
        it.printStackTrace()
      }
    }
  }



  fun File.listName() {
    if (this.isDirectory) {
      println(this.path)
      this.listFiles()?.forEach { it.listName() }
    } else {
      println(this.path)
    }
  }
}