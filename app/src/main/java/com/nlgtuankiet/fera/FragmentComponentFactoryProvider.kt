package com.nlgtuankiet.fera

import androidx.fragment.app.Fragment
import com.nlgtuankiet.fera.dagger.CoreComponent

interface FragmentComponentFactoryProvider {
  fun get(): FragmentComponent.Factory<*>
}

interface FragmentComponent<T: Fragment> {
  fun fragment(): T

  interface Factory<T : Fragment> {
    fun create(coreComponent: CoreComponent): FragmentComponent<T>
  }
}