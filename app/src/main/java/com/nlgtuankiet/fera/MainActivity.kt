package com.nlgtuankiet.fera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
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

    // TODO is there any better way to do this?
    val fragmentContainer = findViewById<FragmentContainerView>(R.id.nav_host_fragment)
    fragmentContainer.doOnPreDraw {
      findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, _, _ ->
        fragmentContainer.hideKeyboard()
      }
    }
  }
}
