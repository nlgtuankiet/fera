package com.nlgtuankiet.fera.browse

import android.content.Context
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.epoxy.BuildInstruction
import com.nlgtuankiet.fera.core.epoxy.Spacing
import com.nlgtuankiet.fera.core.epoxy.captionTextView
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import com.nlgtuankiet.fera.core.epoxy.overlineTextView
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.core.recyclerview.snapCarousel
import com.nlgtuankiet.fera.domain.entity.MediaType
import javax.inject.Inject
import javax.inject.Provider

class BrowseController @Inject constructor(
  @Retained private val viewModelProvider: Provider<BrowseViewModel>,
  private val context: Context
) : AsyncEpoxyController() {
  private val viewModel: BrowseViewModel
    get() = viewModelProvider.get()

  private val blocks = listOf(
    ::buildRecent,
    ::buildCategories,
  )

  override fun buildModels() {
    val state = withState(viewModelProvider.get()) { it }
    for (block in blocks) {
      val nextInstruction = block.invoke(state)
      when (nextInstruction) {
        BuildInstruction.Stop -> return
        BuildInstruction.Continue -> continue
      }
    }
  }

  private fun buildCategories(state: BrowseState): BuildInstruction {
    captionTextView {
      id("categories caption")
      text("CATEGORIES")
    }

    listOf(
      MediaType.Video,
      MediaType.Audio,
      MediaType.Image,
    ).forEach { mediaType ->
      category {
        id(mediaType.toString())
        drawableRes(
          when(mediaType) {
            MediaType.Image -> R.drawable.browse_ic_images
            MediaType.Audio -> R.drawable.browse_ic_audios
            MediaType.Video -> R.drawable.browse_ic_videos
          }
        )
        title(
          when(mediaType) {
            MediaType.Image -> "Images"
            MediaType.Audio -> "Audio"
            MediaType.Video -> "Videos"
          }
        )
      }
      horizontalDividerView {
        id(mediaType.hashCode())
        padding(Spacing(start = context.pxOf(16 + 24 + 16)))
        height(context.pxOf(1))
        color(context.colorOf(android.R.color.darker_gray))
      }
    }
    return BuildInstruction.Continue
  }

  private fun buildRecent(state: BrowseState): BuildInstruction {
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

    captionTextView {
      id("recent caption")
      text("RECENT")
    }
    snapCarousel {
      id("sam sam ")
      models(models)
    }

    return BuildInstruction.Continue
  }
}
