package com.nlgtuankiet.fera.configure

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import javax.inject.Inject

data class ConfigureState(
  val mediaInfo: Async<MediaInfo> = Uninitialized
) : MvRxState

class ConfigureViewModel @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val fFmpegGateway: FFmpegGateway,
  private val args: ConfigureFragmentArgs
) : BaseMavericksViewModel<ConfigureState>(ConfigureState(), BuildConfig.DEBUG) {

  init {
    suspend {
      getMediaInfo(args.path)
    }.execute(Dispatchers.IO) {
      copy(mediaInfo = it)
    }
  }

  companion object : MvRxViewModelFactory<ConfigureViewModel, ConfigureState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: ConfigureState
    ): ConfigureViewModel? {
      return viewModelContext.fragment<ConfigureFragment>().viewModelFactory.get()
    }
  }
}
