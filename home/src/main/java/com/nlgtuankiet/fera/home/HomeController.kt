package com.nlgtuankiet.fera.home

import android.view.View
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.configure.ConfigureFragmentArgs
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.domain.entity.MediaType
import javax.inject.Inject
import javax.inject.Provider

class HomeController @Inject constructor(
  @Retained private val viewModelProvider: Provider<HomeViewModel>,
  private val navigator: HomeNavigator,
) : AsyncEpoxyController() {
  private val viewModel: HomeViewModel
    get() = viewModelProvider.get()

  override fun buildModels() {
    val state = withState(viewModel) { it }
    if (state.recentMediaFile.invoke().isNullOrEmpty()) {
      return
    }
    quadItemCard {
      id("123")
      title("MediaConverterPro media")
      val numberOfItem = 4
      val mediaList = state.recentMediaFile.invoke().orEmpty()
        .filter { it.type == MediaType.Video || it.type == MediaType.Image }
      val canViewMore = mediaList.size > numberOfItem
      val viewMoreIndex = if (canViewMore) { numberOfItem - 1 } else { -1 }
      val viewMoreText = "+${(mediaList.size - numberOfItem + 1).coerceAtMost(999)}"
      val models = mediaList
        .take(numberOfItem)
        .mapIndexed { index, it ->
          SquareMediaBindingModel_().apply {
            val isViewMoreItem = canViewMore && index == viewMoreIndex
            id(it.hashCode())
            moreText(if (isViewMoreItem) { viewMoreText } else { null })
            moreVisibility(if (isViewMoreItem) { View.VISIBLE } else { View.GONE })
            contentResource(it.path.value)
            contentWhiteOverlay(isViewMoreItem)
            onClick { _ ->
              navigator.toConfigure(ConfigureFragmentArgs(path = it.path.value))
            }
          }
        }
      models(models as List<EpoxyModel<Any>>)
      onViewMoreClick { _ ->
      }
    }
  }
}
