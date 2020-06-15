package com.nlgtuankiet.fera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nlgtuankiet.fera.data.CommandLineFFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import dagger.android.AndroidInjector
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var getMediaInfo: Provider<GetMediaInfo>

  @Inject
  lateinit var commandLineFFmpegGateway: CommandLineFFmpegGateway

  @Inject
  lateinit var fragmentFactory: AppFragmentFactory

  override fun onCreate(savedInstanceState: Bundle?) {
    @Suppress("UNCHECKED_CAST")
    (this.applicationContext as AndroidInjector<MainActivity>).inject(this)
    supportFragmentManager.fragmentFactory = fragmentFactory
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
//    Executors.newFixedThreadPool(1).execute {
//      runBlocking(Dispatchers.IO) {
//        try {
//          val job = launch {
//            commandLineFFmpegGateway.executeCommand("""-y -i ${"/storage/emulated/0/fera_test_resources/bunny_720.mp4"} -c:v hevc /storage/emulated/0/fera_test_resources/bunny_720_2.mp4""")
//          }
//        } catch (ex: Exception) {
//          ex.printStackTrace()
//        }
//      }
//    }
  }
}