package com.nlgtuankiet.fera.configure

import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import javax.inject.Inject

data class ConfigureState(
  val a: Int = 0,
) : MvRxState

class ConfigureViewModel @Inject constructor() : BaseMavericksViewModel<ConfigureState>(
  initialState = ConfigureState(),
  debugMode = BuildConfig.DEBUG
) {

  companion object : MvRxViewModelFactory<ConfigureViewModel, ConfigureState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: ConfigureState
    ): ConfigureViewModel? {
      return viewModelContext.fragment<ConfigureFragment>().viewModelFactory.get()
    }
  }
}
