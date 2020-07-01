package com.nlgtuankiet.fera.browsetype

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.asMediaType
import com.nlgtuankiet.fera.domain.entity.name
import com.nlgtuankiet.fera.domain.entity.parent
import com.nlgtuankiet.fera.domain.interactor.GetMediaFiles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

data class MediaFolder(
  val name: String,
  val items: List<MediaFile>
)

enum class SortBy {
  Newest,
  Oldest
}

data class BrowseTypeState(
  val mediaFiles: Async<List<MediaFile>> = Uninitialized,
  val mediaFolders: List<MediaFolder> = emptyList(),
  val sortBy: SortBy = SortBy.Newest,
  val pageCount: Int = 0,
  val selectedIndex: Int = 0,
  val a: Int = 0,
) : MvRxState

class BrowseTypeViewModel @Inject constructor(
  private val getMediaFiles: GetMediaFiles,
  private val args: BrowseTypeFragmentArgs,
) : BaseMavericksViewModel<BrowseTypeState>(
  initialState = BrowseTypeState(),
  debugMode = BuildConfig.DEBUG
) {
  init {
    refresh()
  }

  fun List<MediaFile>.sortBy(by: SortBy): List<MediaFile> {
    return when (by) {
      SortBy.Newest -> sortedByDescending { it.dateModified }
      SortBy.Oldest -> sortedBy { it.dateModified }
    }
  }

  fun refresh() {
    val type = args.type.asMediaType()
    getMediaFiles.invoke(type = type)
      .flowOn(Dispatchers.IO)
      .execute { async ->
        if (async is Success) {
          val mediaFiles = async.invoke()
          val mediaFolders = mutableListOf<MediaFolder>()
          mediaFiles.groupBy { it.path.parent }
            .forEach { (path: Path, mediaFiles: List<MediaFile>) ->
              val mediaFolder = MediaFolder(
                name = path.name,
                items = mediaFiles.sortBy(sortBy)
              )
              mediaFolders.add(mediaFolder)
            }
          val allFolder = MediaFolder(
            name = "All",
            items = mediaFiles.sortBy(sortBy)
          )
          mediaFolders.sortByDescending { it.items.first().dateModified }
          val finalList: List<MediaFolder> = listOf(allFolder) + mediaFolders
          copy(
            mediaFiles = async,
            mediaFolders = finalList,
            pageCount = finalList.size
          )
        } else {
          copy(mediaFiles = async)
        }
      }
  }

  companion object : MvRxViewModelFactory<BrowseTypeViewModel, BrowseTypeState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: BrowseTypeState
    ): BrowseTypeViewModel? {
      return viewModelContext.fragment<BrowseTypeFragment>().viewModelFactory.get()
    }
  }
}
