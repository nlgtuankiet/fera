package com.nlgtuankiet.fera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nlgtuankiet.fera.dagger.DaggerAppComponent
import com.nlgtuankiet.fera.data.CommandLineFFmpegGateway
import com.nlgtuankiet.fera.data.ffmpeg.runCommand
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.bytedeco.ffmpeg.ffprobe
import org.bytedeco.javacpp.Loader
import java.lang.Exception
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var getMediaInfo: Provider<GetMediaInfo>

  @Inject
  lateinit var commandLineFFmpegGateway: CommandLineFFmpegGateway

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    DaggerAppComponent.create().inject(this)
    Executors.newFixedThreadPool(1).execute {
      runBlocking(Dispatchers.IO) {
        try {
          val result = commandLineFFmpegGateway.executeCommand("""-v quiet -hide_banner -print_format json -show_format -show_streams ${"/storage/emulated/0/DCIM/Camera/VID_20200516_161726.mp4"}""")
//          val result = commandLineFFmpegGateway.executeFfmpeg("""-i ${"/storage/emulated/0/DCIM/Camera/VID_20200516_161726.mp4"}""")
          println(result)
        } catch (ex: Exception) {
          ex.printStackTrace()
        }

      }
    }
  }
}