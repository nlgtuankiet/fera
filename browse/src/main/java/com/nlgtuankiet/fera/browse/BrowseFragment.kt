package com.nlgtuankiet.fera.browse

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.browse.databinding.BrowseFragmentBinding
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Keep
@Singleton
// TODO implement snap items
class BrowseFragment @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val controller: BrowseController,
  val viewModelFactory: Provider<BrowseViewModel>
) : Fragment(R.layout.browse_fragment), MavericksView {

  val viewModel: BrowseViewModel by fragmentViewModel()
  private lateinit var binding: BrowseFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = BrowseFragmentBinding.bind(view)
    binding.content.setController(controller)
  }

  override fun invalidate() {
    println("invalidate with $viewModel")
    controller.requestModelBuild()
  }
}
