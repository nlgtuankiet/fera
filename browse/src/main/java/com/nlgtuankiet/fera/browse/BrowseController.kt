package com.nlgtuankiet.fera.browse

import android.content.Context
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.browse.view.categoryView
import com.nlgtuankiet.fera.browse.view.pairMediaGroupView
import com.nlgtuankiet.fera.browse.view.singleMediaGroupView
import com.nlgtuankiet.fera.browse.view.storageView
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.epoxy.BuildInstruction
import com.nlgtuankiet.fera.core.epoxy.buildSubModels
import com.nlgtuankiet.fera.core.epoxy.captionTextView
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.core.ktx.second
import com.nlgtuankiet.fera.core.recyclerview.snapCarousel
import com.nlgtuankiet.fera.domain.entity.MediaType
import com.nlgtuankiet.fera.domain.entity.parent
import javax.inject.Inject

@Suppress("NOTHING_TO_INLINE")
@FragmentScope
class BrowseController @Inject constructor(
  @Retained private val viewModel: BrowseViewModel,
  private val fragment: BrowseFragment,
  private val navigator: BrowseNavigator,
  private val context: Context,
) : AsyncEpoxyController() {

  private val blocks = listOf(
    ::buildRecent,
    ::buildCategories,
    ::buildStorage,
  )

  override fun buildModels() {
    val state = withState(viewModel) { it }
    for (block in blocks) {
      val nextInstruction = block.invoke(state)
      when (nextInstruction) {
        BuildInstruction.Stop -> return
        BuildInstruction.Continue -> continue
      }
    }
  }

  private fun buildStorage(state: BrowseState): BuildInstruction {
    val storageList = state.storage.invoke().orEmpty()
    val lastIndex = storageList.lastIndex

    captionTextView {
      id("storage")
      text("STORAGE DEVICES")
    }

    storageList.forEachIndexed { index, storage ->
      storageView {
        id(storage.hashCode())
        title(storage.name)
        subTitle("Free ${storage.availableBytes / 1024 / 1024}Mb")
        icon(R.drawable.browse_phone_android_with_circle)
      }

      if (index != lastIndex) {
        horizontalDividerView {
          id(storage.hashCode())
          height(context.pxOf(1))
        }
      }
    }

    return BuildInstruction.Continue
  }

  private fun buildCategories(state: BrowseState): BuildInstruction {
    captionTextView {
      id("categories caption")
      text("CATEGORIES")
    }
    // todo sort type base on recent type access
    val types = listOf(MediaType.Video, MediaType.Audio, MediaType.Image)
    val lastIndex = types.lastIndex
    types.forEachIndexed { index, mediaType ->
      categoryView {
        id(mediaType.toString())
        icon(
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
        onClickListener { _ ->
          navigator.toBrowseType(mediaType)
        }
      }
      if (index != lastIndex) {
        horizontalDividerView {
          id(mediaType.hashCode())
          height(context.pxOf(1))
        }
      }
    }
    return BuildInstruction.Continue
  }

  private fun buildRecent(state: BrowseState): BuildInstruction {
    val mediaGroup = state.mediaGroups.invoke().orEmpty()
    val models = buildSubModels {
      mediaGroup.forEach { group ->
        val firstMedia = group.medias.first()
        val type = when (firstMedia.type) {
          MediaType.Video -> "Videos"
          MediaType.Audio -> "Audio"
          MediaType.Image -> "Images"
        }
        val leftText = group.name
        val rightText = "(${group.total})"
        if (group.medias.size == 1) {
          singleMediaGroupView {
            id("${group.type.ordinal} ${group.path.value}")
            mediaFile(firstMedia)
            leftText(leftText)
            rightText(rightText)
            type(type)
            onClickListener { _ ->
              navigator.toBrowseType(firstMedia.type, firstMedia.path.parent)
            }
          }
        } else {
          val secondMedia = group.medias.second()
          pairMediaGroupView {
            id("${group.type.ordinal} ${group.path.value}")
            leftMediaFile(firstMedia)
            rightMediaFile(secondMedia)
            leftText(leftText)
            rightText(rightText)
            type(type)
            onClickListener { _ ->
              navigator.toBrowseType(firstMedia.type, firstMedia.path.parent)
            }
          }
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
