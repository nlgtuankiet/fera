package com.nlgtuankiet.fera.browsetype.itemlist

import com.airbnb.epoxy.AsyncEpoxyController
import com.nlgtuankiet.fera.browsetype.BrowseTypeViewModel
import com.nlgtuankiet.fera.browsetype.gridImageMedia
import com.nlgtuankiet.fera.core.epoxy.FullSpan
import com.nlgtuankiet.fera.core.epoxy.body1TextView
import com.nlgtuankiet.fera.core.ktx.state
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.gateway.TimeGateway
import org.threeten.bp.LocalDateTime

class ItemListController constructor(
  private val viewModel: BrowseTypeViewModel,
  private val args: ItemListFragmentArgs,
  private val timeGateway: TimeGateway
) : AsyncEpoxyController() {
  override fun buildModels() {
    val items: List<MediaFile> = viewModel.state.mediaFolders
      .getOrNull(args.index)?.items ?: return
    buildItemGroupByTime(items)
  }

  private fun buildItemGroupByTime(items: List<MediaFile>) {
    val grouped = items.groupBy {
      it.dateModified.let { LocalDateTime.ofEpochSecond(it, 0, timeGateway.zoneOffset()) }
        .dayOfYear
    }.toList().sortedByDescending { it.first }

    grouped.forEach { (dayInYear, items) ->
      body1TextView {
        id("title $dayInYear")
        text("Day $dayInYear")
        spanSizeOverride(FullSpan)
      }
      items.forEach {
        gridImageMedia {
          id(it.hashCode())
          imageSource(it.path.value)
        }
      }
    }
  }
}
