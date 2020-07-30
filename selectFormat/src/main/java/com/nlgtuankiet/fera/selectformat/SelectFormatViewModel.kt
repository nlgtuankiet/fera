package com.nlgtuankiet.fera.selectformat

import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.core.result.ResultManager
import com.nlgtuankiet.fera.domain.entity.Extension
import com.nlgtuankiet.fera.domain.entity.Muxer
import com.nlgtuankiet.fera.domain.entity.Muxers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

val ExtensionsWithMuxers: List<ExtensionAndMuxer> = run {
  val extensions = mutableMapOf<Extension, MutableSet<Muxer>>()
  Muxers.forEach { muxer ->
    muxer.commonExtension.forEach { extension ->
      val exitingSet = extensions[extension] ?: mutableSetOf()
      exitingSet.add(muxer)
      extensions[extension] = exitingSet
    }
  }
  extensions.entries.map { ExtensionAndMuxer(it.key, it.value.toList()) }
    .sortedBy { it.extension.value }
}

data class ExtensionAndMuxer(
  val extension: Extension,
  val muxers: List<Muxer>,
)

data class SelectFormatState(
  val extensionWithMuxers: List<ExtensionAndMuxer> = ExtensionsWithMuxers,
  val isTyping: Boolean = false,
  val query: String = ""
) : MvRxState

class SelectFormatViewModel @Inject constructor(
  private val resultManager: ResultManager,
  private val args: SelectFormatFragmentArgs
) : BaseMavericksViewModel<SelectFormatState>(
  initialState = SelectFormatState(),
  debugMode = BuildConfig.DEBUG
) {

  private var setQueryJob: Job? = null

  fun setQuery(value: String) {
    setQueryJob?.cancel()
    setQueryJob = viewModelScope.launch(Dispatchers.IO) {
      delay(300)
      setState {
        copy(query = value.trim())
      }
    }
  }

  override fun onCleared() {
    super.onCleared()
    resultManager.cancel(requestCode = args.requestCode)
  }

  companion object : MvRxViewModelFactory<SelectFormatViewModel, SelectFormatState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: SelectFormatState
    ): SelectFormatViewModel? {
      return viewModelContext.fragment<SelectFormatFragment>().viewModelFactory.get()
    }
  }
}