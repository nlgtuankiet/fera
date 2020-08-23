package com.nlgtuankiet.fera.configure

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.configure.databinding.ConfigureFragmentBinding
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.ktx.addOnScrollStateChangeListener
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
import javax.inject.Inject
import javax.inject.Provider

@Keep
@FragmentScope
class ConfigureFragment @Inject constructor(
  val viewModelFactory: Provider<ConfigureViewModel>,
  private val configureController: Provider<ConfigureController>,
) : Fragment(R.layout.configure_fragment), MavericksView {

  val viewModel: ConfigureViewModel by fragmentViewModel()
  private lateinit var binding: ConfigureFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = ConfigureFragmentBinding.bind(view)
    binding.epoxyRecyclerView.setController(configureController.get())
    binding.epoxyRecyclerView.addOnScrollStateChangeListener {
      if (it != RecyclerView.SCROLL_STATE_IDLE) {
        configureController.get().onScroll()
        binding.epoxyRecyclerView.hideKeyboard()
      }
    }
  }

  override fun invalidate() {
    configureController.get().requestModelBuild()
  }
}
