package com.nlgtuankiet.fera.configure

import androidx.navigation.findNavController
import com.nlgtuankiet.fera.selectformat.SelectFormatFragmentArgs
import javax.inject.Inject

class ConfigureNavigator @Inject constructor(
  private val fragment: ConfigureFragment,
  private val viewModel: ConfigureViewModel,
) {

  fun toSelectFormat(args: SelectFormatFragmentArgs) {
    fragment.requireView().findNavController()
      .navigate(com.nlgtuankiet.fera.core.R.id.select_format, args.toBundle())
    viewModel.onRequestFormat(args.requestCode)
  }
}