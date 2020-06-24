package com.nlgtuankiet.fera.browse

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.browse.model.MediaGroup
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.core.map
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.Storage
import com.nlgtuankiet.fera.domain.interactor.GetRecentMediaFile
import com.nlgtuankiet.fera.domain.interactor.GetStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class BrowseState(
  val mediaGroups: Async<List<MediaGroup>> = Uninitialized,
  val storage: Async<List<Storage>> = Uninitialized,
  val a: Int = 0,
) : MvRxState

class BrowseViewModel @Inject constructor(
  private val getRecentMediaFile: GetRecentMediaFile,
  private val getStorage: GetStorage,
) : BaseMavericksViewModel<BrowseState>(
  initialState = BrowseState(),
  debugMode = BuildConfig.DEBUG
) {
  init {
    refresh()
  }

  fun refresh() {
    viewModelScope.launch(Dispatchers.IO) {
      getRecentMediaFile.invoke(limit = Int.MAX_VALUE)
        .execute { async ->
          copy(mediaGroups = async.map { parseMediaGroups(it) })
        }

      getStorage.invoke()
        .execute {
          copy(storage = it)
        }
    }
  }

  private fun parseMediaGroups(medias: List<MediaFile>): List<MediaGroup> {
    // group by folder
    val result = mutableListOf<MediaGroup>()
    val filesByPath = medias.groupBy {
      it.path.parent
    }
    filesByPath.forEach { folderEntry ->
      folderEntry.value.groupBy { it.type }.forEach { typeEntry ->
        result.add(
          MediaGroup(
            name = folderEntry.key.fileName.toString().removePrefix("/"),
            path = folderEntry.key,
            total = typeEntry.value.size,
            type = typeEntry.key,
            medias = typeEntry.value
          )
        )
      }
    }

    return result.sortedByDescending { it.medias.first().date }
  }

  companion object : MvRxViewModelFactory<BrowseViewModel, BrowseState> {
    override fun create(viewModelContext: ViewModelContext, state: BrowseState): BrowseViewModel? {
      return viewModelContext.fragment<BrowseFragment>().viewModelFactory.get()
    }
  }
}
