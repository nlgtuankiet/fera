package com.nlgtuankiet.fera.browsetype

import android.os.Bundle
import android.view.View
import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.android.material.tabs.TabLayoutMediator
import com.nlgtuankiet.fera.browsetype.databinding.BrowseTypeFragmentBinding
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Keep
@Singleton
class BrowseTypeFragment @Inject constructor(
  val viewModelFactory: Provider<BrowseTypeViewModel>,
  private val getMediaInfo: GetMediaInfo,
  private val pagerAdapterFactory: BrowseTypePagerAdapter.Factory
) : Fragment(R.layout.browse_type_fragment), MavericksView {

  init {
    println("init BrowseTypeFragment")
  }
  val viewModel: BrowseTypeViewModel by fragmentViewModel()
  private lateinit var binding: BrowseTypeFragmentBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = BrowseTypeFragmentBinding.bind(view)
    val pagerAdapter = pagerAdapterFactory.create(this)
    binding.pager.adapter = pagerAdapter
    TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
      tab.text = withState(viewModel) { it.mediaFolders[position].name }
    }.attach()
    viewModel.onEach(BrowseTypeState::pageCount) {
      pagerAdapter.notifyDataSetChanged()
    }
  }

  override fun invalidate() {
  }
}
