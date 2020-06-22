package com.nlgtuankiet.fera.home

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetRecentMediaFile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.file.Path
import javax.inject.Inject

data class HomeState(
  val recentMediaFile: Async<List<MediaFile>> = Uninitialized,
  val a: Int = 0,
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
      getRecentMediaFile.invoke(limit = Int.MAX_VALUE)
        .execute { async ->
          if (async is Success) {
            tryParse(async.invoke())
          }
          copy(recentMediaFile = async)
        }
    }
  }

  private fun tryParse(medias: List<MediaFile>) {
    // group by folder
    val result = mutableListOf<MediaFolder>()
    val filesByPath = medias.groupBy {
      it.path.parent
    }
    filesByPath.forEach { folderEntry ->
      folderEntry.value.groupBy { it.type }.forEach { typeEntry ->
        result.add(
          MediaFolder(
            name = folderEntry.key.fileName.toString().removePrefix("/"),
            path = folderEntry.key,
            total = typeEntry.value.size,
            type = typeEntry.key,
            medias = typeEntry.value
          )
        )
      }
    }

    val sortedResult = result.sortedByDescending { it.medias.first().date }
    println(sortedResult)
  }

  companion object : MvRxViewModelFactory<HomeViewModel, HomeState> {
    override fun create(viewModelContext: ViewModelContext, state: HomeState): HomeViewModel? {
      return viewModelContext.fragment<HomeFragment>().viewModelFactory.get()
    }
  }
}

data class MediaFolder(
  val name: String,
  val path: Path,
  val total: Int,
  val type: MediaType,
  val medias: List<MediaFile>
) {
  init {
    require(medias.isNotEmpty())
  }
}
