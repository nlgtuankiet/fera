package com.nlgtuankiet.fera.home

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import com.nlgtuankiet.fera.home.databinding.HomeFragmentBinding
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Keep
@Singleton
class HomeFragment @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val controller: HomeController,
  val viewModelFactory: Provider<HomeViewModel>
) : Fragment(R.layout.home_fragment), MavericksView {

  val viewModel: HomeViewModel by fragmentViewModel()
  private lateinit var binding: HomeFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = HomeFragmentBinding.bind(view)
    binding.content.setController(controller)
  }


  override fun invalidate() {
    controller.requestModelBuild()
  }
}