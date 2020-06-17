package com.nlgtuankiet.fera.home

import com.airbnb.epoxy.AsyncEpoxyController
import javax.inject.Inject
import javax.inject.Provider

class HomeController @Inject constructor(
  private val viewModelProvider: Provider<HomeViewModel>
) : AsyncEpoxyController() {
  private val viewModel: HomeViewModel
    get() = viewModelProvider.get()

  override fun buildModels() {
  }
}
