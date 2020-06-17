package com.nlgtuankiet.fera.core

import androidx.fragment.app.Fragment

interface FragmentComponentFactoryProvider {
  fun get(): FragmentComponent.Factory<*>
}

interface FragmentComponent<T : Fragment> {
  fun fragment(): T

  interface Factory<T : Fragment> {
    fun create(coreComponent: CoreComponent): FragmentComponent<T>
  }
}
