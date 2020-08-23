package com.nlgtuankiet.fera.home

import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.nlgtuankiet.fera.configure.ConfigureFragmentArgs
import com.nlgtuankiet.fera.core.R
import javax.inject.Inject
import javax.inject.Provider

class HomeNavigator @Inject constructor(
  private val fragment: Provider<HomeFragment>
) {
  private val navController: NavController?
    get() = fragment.get().view?.findNavController()

  fun toConfigure(args: ConfigureFragmentArgs) {
    navController?.navigate(R.id.configure, args.toBundle())
  }

  fun toBrowse() {
    navController?.navigate(R.id.browse)
  }
}
