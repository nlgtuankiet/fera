package com.nlgtuankiet.fera.home

import com.airbnb.mvrx.*
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetRecentMediaFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
  private val recentMediaFile: Async<List<MediaFile>> = Uninitialized,
  private val a: Int = 0,
) : MvRxState

class HomeViewModel @Inject constructor(
  private val getRecentMediaFile: GetRecentMediaFile,
  private val fFmpegGateway: FFmpegGateway,
) : BaseMavericksViewModel<HomeState>(
  initialState = HomeState(),
  debugMode = BuildConfig.DEBUG
) {
  init {
    refresh()
  }

  fun refresh() {
    viewModelScope.launch(Dispatchers.IO) {
      getRecentMediaFile.invoke()
        .execute {
          copy(recentMediaFile = it)
        }
    }
  }


  companion object : MvRxViewModelFactory<HomeViewModel, HomeState> {
    override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
      return viewModelContext.fragment<HomeFragment>().viewModelFactory.get()
    }
  }
}