package com.nlgtuankiet.fera.configure.select.format

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.addCallback
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.parentFragmentViewModel
import com.nlgtuankiet.fera.configure.ConfigureViewModel
import com.nlgtuankiet.fera.configure.R
import com.nlgtuankiet.fera.core.ktx.addOnScrollStateChangeListener
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
import com.nlgtuankiet.fera.core.ktx.showKeyboard

class SelectFormatFragment : Fragment(R.layout.select_format_fragment), MavericksView {

  private val configureViewModel: ConfigureViewModel by parentFragmentViewModel()
  private val viewModel: SelectFormatViewModel by fragmentViewModel()
  private val controller: SelectFormatController by lazy {
    SelectFormatController(
      configureViewModel,
      viewModel,
      this,
    )
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val epoxyRecyclerView = view.findViewById<EpoxyRecyclerView>(R.id.epoxy_recycler_view)
    epoxyRecyclerView.setController(controller)
    val queryEditText = view.findViewById<EditText>(R.id.query_edit_text)
    val cancelButton = view.findViewById<ImageView>(R.id.cancel_button)
    cancelButton.setOnClickListener {
      viewModel.setQuery("")
    }

    val backButton = view.findViewById<ImageView>(R.id.back_button)
    backButton.setOnClickListener {
      parentFragment?.childFragmentManager?.popBackStack()
    }
    queryEditText.doOnTextChanged { text, _, _, _ ->
      val realText = text?.toString() ?: ""
      viewModel.setQuery(realText)
      cancelButton.isInvisible = realText.isBlank()
    }
    epoxyRecyclerView.addOnScrollStateChangeListener { newState ->
      if (newState != RecyclerView.SCROLL_STATE_IDLE) {
        view.hideKeyboard()
        queryEditText.clearFocus()
      }
    }
    viewModel.onEach(SelectFormatState::query) {
      queryEditText.setText(it)
      if (it.isNotEmpty()) {
        queryEditText.setSelection(it.length)
      }
    }
  }

  override fun invalidate() {
    controller.requestModelBuild()
  }
}