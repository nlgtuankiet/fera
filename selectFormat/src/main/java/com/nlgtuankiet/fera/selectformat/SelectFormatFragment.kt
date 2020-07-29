package com.nlgtuankiet.fera.selectformat

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isInvisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.fragmentViewModel
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.ktx.addOnScrollStateChangeListener
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
import com.nlgtuankiet.fera.core.result.ResultManager
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@FragmentScope
class SelectFormatFragment @Inject constructor(
  private val controllerProvider: Provider<SelectFormatController>,
  val viewModelFactory: Provider<SelectFormatViewModel>,
) : Fragment(R.layout.select_format_fragment), MavericksView {

  val viewModel: SelectFormatViewModel by fragmentViewModel()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val epoxyRecyclerView = view.findViewById<EpoxyRecyclerView>(R.id.epoxy_recycler_view)
    epoxyRecyclerView.setController(controllerProvider.get())
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
    controllerProvider.get().requestModelBuild()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    controllerProvider.get().cancelPendingModelBuild()
  }
}