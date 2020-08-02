package com.nlgtuankiet.fera.browse

import android.os.Bundle
import android.os.FileObserver
import android.os.StatFs
import android.view.View
import androidx.annotation.Keep
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.browse.databinding.BrowseFragmentBinding
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import java.io.File
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Keep
@FragmentScope
// TODO implement snap items
class BrowseFragment @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val controller: Provider<BrowseController>,
  val viewModelFactory: Provider<BrowseViewModel>
) : Fragment(R.layout.browse_fragment), MavericksView {

  val viewModel: BrowseViewModel by fragmentViewModel()
  private lateinit var binding: BrowseFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = BrowseFragmentBinding.bind(view)
    binding.content.setController(controller.get())

    Executors.newSingleThreadExecutor().execute {
      val list = ContextCompat.getExternalFilesDirs(requireContext(), null)
        .toList()
        .map { it.toString().replace("Android/data/com.nlgtuankiet.fera/files", "") }
      println("list is $list")
      list.forEach { path ->
        val stats = StatFs(path)
        println("$path ava: ${stats.availableBytes * 1.0 / 1024 / 1024}")
        println("$path total: ${stats.totalBytes * 1.0 / 1024 / 1024}")
        object : FileObserver(File(path)) {
          override fun onEvent(event: Int, path: String?) {
            println("onEvent $path")
          }
        }.startWatching()
      }
    }
  }

  override fun invalidate() {
    println("invalidate with $viewModel")
    controller.get().requestModelBuild()
  }
}
