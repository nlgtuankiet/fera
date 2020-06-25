package com.nlgtuankiet.fera.configure

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.configure.databinding.ConfigureFragmentBinding
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Keep
@Singleton
class ConfigureFragment @Inject constructor(
  val viewModelFactory: Provider<ConfigureViewModel>,
  private val configureController: ConfigureController,
  private val getMediaInfo: GetMediaInfo,
) : Fragment(R.layout.configure_fragment), MavericksView {

  init {
    println("init BrowseTypeFragment")
  }

  val viewModel: ConfigureViewModel by fragmentViewModel()
  private lateinit var binding: ConfigureFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ConfigureFragmentBinding.bind(view)
    binding.epoxyRecyclerView.setController(configureController)
    configureController.requestModelBuild()
  }

  override fun invalidate() {
  }
}
