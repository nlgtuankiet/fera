package com.nlgtuankiet.fera.configure

import com.nlgtuankiet.fera.configure.select.format.SelectFormatFragment
import javax.inject.Inject
import javax.inject.Provider

class ConfigureNavigator @Inject constructor(
  private val fragmentProvider: Provider<ConfigureFragment>
) {
  fun toSelectFormat() {
    fragmentProvider.get().childFragmentManager
      .beginTransaction()
      .add(R.id.dialog_fragment_container, SelectFormatFragment())
      .addToBackStack(SelectFormatFragment::class.java.name)
      .commit()
  }
}