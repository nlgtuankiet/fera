package com.nlgtuankiet.fera.configure

import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.epoxy.buildSubModels
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import javax.inject.Inject
import javax.inject.Provider

class ConfigureController @Inject constructor(
  @Retained private val viewModelProvider: Provider<ConfigureViewModel>
) : AsyncEpoxyController() {

  override fun buildModels() {
    val state = withState(viewModelProvider.get()) { it }
    println("$state")
    val mediaInfo = state.mediaInfo.invoke() ?: return
    horizontalDividerView {
      id("top")
      height(100)
    }

    mediaInfo.streams.forEach { stream ->
      val models = buildSubModels {

        spec {
          id("codec")
          icon(android.R.drawable.ic_dialog_alert)
          specName("Codec")
          specValue(stream.codecName ?: "")
        }

        spec {
          id("codec type")
          icon(android.R.drawable.ic_delete)
          specName("Codec type")
          specValue(stream.codecType ?: "")
        }
      }

      cardEpoxyRecyclerView {
        id(stream.hashCode())
        models(models)
      }
    }
  }
}
