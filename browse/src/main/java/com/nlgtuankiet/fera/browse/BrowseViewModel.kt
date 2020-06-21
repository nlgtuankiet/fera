package com.nlgtuankiet.fera.browse

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetRecentMediaFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class HomeState(
  val recentMediaFile: Async<List<MediaFile>> = Uninitialized,
  val a: Int = 0,
) : MvRxState

class BrowseViewModel @Inject constructor(
) : BaseMavericksViewModel<HomeState>(
  initialState = HomeState(),
  debugMode = BuildConfig.DEBUG
) {
  init {
    refresh()
  }

  fun refresh() {
//    viewModelScope.launch(Dispatchers.IO) {
//      getRecentMediaFile.invoke(limit = Int.MAX_VALUE)
//        .execute { async ->
//          copy(recentMediaFile = async)
//        }
//    }
  }

  companion object : MvRxViewModelFactory<BrowseViewModel, HomeState> {
    override fun create(viewModelContext: ViewModelContext, state: HomeState): BrowseViewModel? {
      return viewModelContext.fragment<BrowseFragment>().viewModelFactory.get()
    }
  }
}
