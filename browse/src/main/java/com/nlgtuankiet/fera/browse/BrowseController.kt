package com.nlgtuankiet.fera.browse

import android.view.View
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.domain.entity.MediaType
import javax.inject.Inject
import javax.inject.Provider

class BrowseController @Inject constructor(
  @Retained private val viewModelProvider: Provider<BrowseViewModel>
) : AsyncEpoxyController() {
  private val viewModel: BrowseViewModel
    get() = viewModelProvider.get()

  override fun buildModels() {
    val state = withState(viewModelProvider.get()) { it }

  }
}
