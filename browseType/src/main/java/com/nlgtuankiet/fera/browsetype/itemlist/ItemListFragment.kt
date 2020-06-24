package com.nlgtuankiet.fera.browsetype.itemlist

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.parentFragmentViewModel
import com.nlgtuankiet.fera.browsetype.BrowseTypeState
import com.nlgtuankiet.fera.browsetype.BrowseTypeViewModel
import com.nlgtuankiet.fera.browsetype.R

class ItemListFragment : Fragment(R.layout.browsetype_itemlist_fragment), MavericksView {

  val viewModel: BrowseTypeViewModel by parentFragmentViewModel()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val args = arguments?.getParcelable("args") as? ItemListFragmentArgs ?: return
    val index = args.index
    println("ItemListFragment onViewCreated ")
    viewModel.onEach(BrowseTypeState::mediaFolders) { folders ->
      val folder = folders[index]
      view.findViewById<TextView>(R.id.text).text = buildString {
        appendLine(folder.name)
        appendLine(folder.items.joinToString("\n") { it.name })
      }.also {
        println("set text: $it")
      }
    }
  }

  override fun invalidate() {
  }
}
