package com.nlgtuankiet.fera.browse

import android.content.Context
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.epoxy.BuildInstruction
import com.nlgtuankiet.fera.core.epoxy.Spacing
import com.nlgtuankiet.fera.core.epoxy.captionTextView
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import com.nlgtuankiet.fera.core.image.RequestOption
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.requestOption
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.core.ktx.second
import com.nlgtuankiet.fera.core.recyclerview.snapCarousel
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType
import javax.inject.Inject
import javax.inject.Provider

@Suppress("NOTHING_TO_INLINE")
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
          when (mediaType) {
            MediaType.Image -> R.drawable.browse_images_with_circle
            MediaType.Audio -> R.drawable.browse_audios_with_circle
            MediaType.Video -> R.drawable.browse_videos_with_circle
          }
        )
        title(
          when (mediaType) {
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
        color(context.colorOf(R.color.browse_color_on_surface_a12))
      }
    }
    return BuildInstruction.Continue
  }

  private inline fun MediaFile.imageSource(): Any {
    return if (type == MediaType.Audio) {
      R.drawable.browse_outline_audiotrack_purple_24
    } else {
      path.toString()
    }
  }

  private inline fun MediaFile.imageOption(): RequestOption? {
    return if (type == MediaType.Audio) {
      requestOption {
        scaleType = ScaleType.CenterInside
      }
    } else {
      null
    }
  }

  private inline fun MediaFile.imageBackgroundColor(): Int {
    return if (type == MediaType.Audio) {
      context.colorOf(R.color.browse_grey_100)
    } else {
      0
    }
  }

  private inline fun MediaFile.playVisible(): Boolean {
    return type == MediaType.Video
  }

  private fun buildRecent(state: BrowseState): BuildInstruction {
    val mediaGroup = state.mediaGroups.invoke().orEmpty()
    val models = mediaGroup.map { group ->
      val firstMedia = group.medias.first()
      val type = when (firstMedia.type) {
        MediaType.Video -> "Videos"
        MediaType.Audio -> "Audio"
        MediaType.Image -> "Images"
      }
      val leftText = group.name
      val rightText = "(${group.total})"
      if (group.medias.size == 1) {
        SingleMediaGroupBindingModel_().apply {
          id(group.hashCode())

          imageSource(firstMedia.imageSource())
          imageOption(firstMedia.imageOption())
          imageBackgroundColor(firstMedia.imageBackgroundColor())
          playIsVisible(firstMedia.playVisible())

          leftText(leftText)
          rightText(rightText)
          type(type)
        }
      } else {
        val secondMedia = group.medias.second()
        PairMediaGroupBindingModel_().apply {
          id(group.hashCode())

          leftImageSource(firstMedia.imageSource())
          leftImageOption(firstMedia.imageOption())
          leftImageBackgroundColor(firstMedia.imageBackgroundColor())
          leftPlayIsVisible(firstMedia.playVisible())

          rightImageSource(secondMedia.imageSource())
          rightImageOption(secondMedia.imageOption())
          rightImageBackgroundColor(secondMedia.imageBackgroundColor())
          rightPlayIsVisible(secondMedia.playVisible())

          leftText(leftText)
          rightText(rightText)
          type(type)
        }
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
