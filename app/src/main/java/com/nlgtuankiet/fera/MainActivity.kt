package com.nlgtuankiet.fera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import dagger.android.AndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
  @Inject
  lateinit var fragmentFactory: AppFragmentFactory

  @Inject
  lateinit var fFmpegGateway: FFmpegGateway

  override fun onCreate(savedInstanceState: Bundle?) {
    @Suppress("UNCHECKED_CAST")
    (this.applicationContext as AndroidInjector<MainActivity>).inject(this)
    supportFragmentManager.fragmentFactory = fragmentFactory
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}
