package com.nlgtuankiet.fera.core

import androidx.fragment.app.Fragment
import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.ViewModelContext


fun <F: Fragment> ViewModelContext.fragment(): F {
  return let { it as FragmentViewModelContext }
    .let { it.fragment() }
}
