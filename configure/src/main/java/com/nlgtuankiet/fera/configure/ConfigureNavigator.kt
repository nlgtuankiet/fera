package com.nlgtuankiet.fera.configure

import androidx.navigation.findNavController
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
import com.nlgtuankiet.fera.core.result.SelectType
import com.nlgtuankiet.fera.core.result.createNewRequestCode
import com.nlgtuankiet.fera.selectformat.SelectFormatFragmentArgs
import javax.inject.Inject

class ConfigureNavigator @Inject constructor(
  private val fragment: ConfigureFragment,
  @Retained
  private val viewModel: ConfigureViewModel,
) {

  fun toSelectVideoEncoder(videoStreamIndex: Int) {
    onNavigate()
    val args = SelectFormatFragmentArgs(createNewRequestCode(), SelectType.VideoEncoder)
    fragment.requireView().findNavController()
      .navigate(com.nlgtuankiet.fera.core.R.id.select_format, args.toBundle())
    viewModel.onRequestVideoEncoder(
      videoStreamIndex = videoStreamIndex,
      requestCode = args.requestCode
    )
  }

  fun toSelectFormat() {
    onNavigate()
    val args = SelectFormatFragmentArgs(createNewRequestCode())
    fragment.requireView().findNavController()
      .navigate(com.nlgtuankiet.fera.core.R.id.select_format, args.toBundle())
    viewModel.onRequestFormat(args.requestCode)
  }

  private fun onNavigate() {
    fragment.requireView().hideKeyboard()
  }
}