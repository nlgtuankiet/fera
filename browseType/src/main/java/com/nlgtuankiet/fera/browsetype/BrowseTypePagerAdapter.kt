package com.nlgtuankiet.fera.browsetype

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.browsetype.itemlist.ItemListFragment
import com.nlgtuankiet.fera.browsetype.itemlist.ItemListFragmentArgs
import com.nlgtuankiet.fera.core.Retained
import javax.inject.Inject
import javax.inject.Provider

class BrowseTypePagerAdapter constructor(
  private val browseTypeFragment: BrowseTypeFragment,
  private val viewModelProvider: Provider<BrowseTypeViewModel>,
) : FragmentStateAdapter(browseTypeFragment) {
  private val viewModel: BrowseTypeViewModel
    get() = viewModelProvider.get()

  class Factory @Inject constructor(
    @Retained private val viewModelProvider: Provider<BrowseTypeViewModel>,
  ) {
    fun create(fragment: BrowseTypeFragment): BrowseTypePagerAdapter {
      return BrowseTypePagerAdapter(fragment, viewModelProvider)
    }
  }

  override fun getItemCount(): Int {
    return withState(viewModel) { it.pageCount }
  }

  override fun createFragment(position: Int): Fragment {
    return ItemListFragment().apply {
      arguments = Bundle().apply {
        putParcelable("args", ItemListFragmentArgs(position))
      }
    }
  }
}
