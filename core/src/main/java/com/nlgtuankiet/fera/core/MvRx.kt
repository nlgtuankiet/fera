package com.nlgtuankiet.fera.core

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized

fun <T, R> Async<T>.map(success: (T) -> R): Async<R> {
  return when (this) {
    is Success -> Success(success.invoke(this.invoke()))
    is Loading -> Loading()
    is Fail -> Fail(this.error)
    Uninitialized -> Uninitialized
  }
}

val <T : MvRxState> BaseMavericksViewModel<T>.state: T
  get() = com.airbnb.mvrx.withState(this) { it }
