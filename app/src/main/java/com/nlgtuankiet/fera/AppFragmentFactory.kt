package com.nlgtuankiet.fera

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.nlgtuankiet.fera.home.HomeFragment
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class AppFragmentFactory @Inject constructor(
  private val homeFragment: Provider<HomeFragment>
): FragmentFactory() {
  override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
    return when(loadFragmentClass(classLoader, className)) {
      HomeFragment::class.java -> homeFragment.get()
      else -> super.instantiate(classLoader, className)
    }
  }
}