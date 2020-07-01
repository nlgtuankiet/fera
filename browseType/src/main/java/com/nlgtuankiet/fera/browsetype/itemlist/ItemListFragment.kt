package com.nlgtuankiet.fera.browsetype.itemlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.parentFragmentViewModel
import com.nlgtuankiet.fera.browsetype.BrowseTypeState
import com.nlgtuankiet.fera.browsetype.BrowseTypeViewModel
import com.nlgtuankiet.fera.core.Layout
import com.nlgtuankiet.fera.core.coreComponent
import com.nlgtuankiet.fera.core.databinding.EpoxyRecyclerViewBinding

class ItemListFragment : Fragment(Layout.EpoxyRecyclerView), MavericksView {

  private val viewModel: BrowseTypeViewModel by parentFragmentViewModel()
  private lateinit var binding: EpoxyRecyclerViewBinding

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding = EpoxyRecyclerViewBinding.bind(view)
    val args: ItemListFragmentArgs = arguments?.getParcelable("args") as? ItemListFragmentArgs
      ?: return
    val controller = ItemListController(
      viewModel = viewModel,
      args = args,
      timeGateway = coreComponent.timeGateway,
    )
    // TODO dynamic span count
    binding.epoxyRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
      .apply {
        spanSizeLookup = controller.spanSizeLookup
      }
    binding.epoxyRecyclerView.setController(controller)
    viewModel.onEach(BrowseTypeState::mediaFolders) { folders ->
      controller.requestModelBuild()
    }
  }

  override fun invalidate() {
  }
}
