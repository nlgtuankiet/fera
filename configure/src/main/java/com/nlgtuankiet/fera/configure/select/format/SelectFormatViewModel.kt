package com.nlgtuankiet.fera.configure.select.format

import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.nlgtuankiet.fera.configure.BuildConfig
import com.nlgtuankiet.fera.domain.entity.Muxer
import com.nlgtuankiet.fera.domain.entity.Muxers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SelectFormatState(
  val muxers: List<Muxer> = Muxers,
  val isTyping: Boolean = false,
  val query: String = ""
) : MvRxState

class SelectFormatViewModel @Inject constructor(
  private val initialState: SelectFormatState,
) : BaseMavericksViewModel<SelectFormatState>(
  initialState = initialState,
  debugMode = BuildConfig.DEBUG
) {

  private var setQueryJob: Job? = null

  fun onBackPress() = withState { state ->
    if (state.isTyping) {
      setState { copy(isTyping = false) }
    }
  }

  fun setQuery(value: String) {
    setQueryJob?.cancel()
    setQueryJob = viewModelScope.launch(Dispatchers.IO) {
      delay(300)
      setState {
        copy(query = value.trim())
      }
    }
  }
}