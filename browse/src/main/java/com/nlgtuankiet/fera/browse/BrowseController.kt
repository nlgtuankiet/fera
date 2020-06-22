package com.nlgtuankiet.fera.browse

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.carousel
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.Retained
import javax.inject.Inject
import javax.inject.Provider

class BrowseController @Inject constructor(
  @Retained private val viewModelProvider: Provider<BrowseViewModel>
) : AsyncEpoxyController() {
  private val viewModel: BrowseViewModel
    get() = viewModelProvider.get()

  override fun buildModels() {
    val state = withState(viewModelProvider.get()) { it }
    val mediaGroup = state.mediaGroups.invoke().orEmpty()
    val models = mediaGroup.map { group ->
      PairMediaGroupBindingModel_().apply {
        id(group.hashCode())
        leftImageSource(group.medias.first().path.toString())
        rightImageSource(group.medias.getOrNull(1)?.path?.toString() ?: "")
        leftText(group.name)
        rightText("(${group.total})")
      }
    }
    carousel {
      id("sam sam ")
      models(models)
    }
  }
}
