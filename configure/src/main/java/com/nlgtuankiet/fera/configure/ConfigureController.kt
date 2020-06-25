package com.nlgtuankiet.fera.configure

import com.airbnb.epoxy.AsyncEpoxyController
import com.nlgtuankiet.fera.core.Retained
import javax.inject.Inject
import javax.inject.Provider

class ConfigureController @Inject constructor(
  @Retained private val viewModelProvider: Provider<ConfigureViewModel>
) : AsyncEpoxyController() {

  override fun buildModels() {
  }
}
