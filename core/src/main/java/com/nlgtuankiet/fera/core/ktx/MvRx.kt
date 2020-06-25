package com.nlgtuankiet.fera.core.ktx

import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState

val <S : MvRxState> BaseMavericksViewModel<S>.state: S
  get() = com.airbnb.mvrx.withState(this) { it }
