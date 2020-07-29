package com.nlgtuankiet.fera.selectformat

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.BackgroundColorSpan
import androidx.navigation.findNavController
import com.airbnb.epoxy.AsyncEpoxyController
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.result.SelectFormatResult
import com.nlgtuankiet.fera.core.epoxy.buildSubModels
import com.nlgtuankiet.fera.core.epoxy.headline6TextView
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import com.nlgtuankiet.fera.core.epoxy.spacingOf
import com.nlgtuankiet.fera.core.epoxy.view.cardEpoxyRecyclerView
import com.nlgtuankiet.fera.core.epoxy.view.doubleTextView
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.core.result.ResultManager
import com.nlgtuankiet.fera.core.state
import javax.inject.Inject
import javax.inject.Singleton

@FragmentScope
class SelectFormatController @Inject constructor(
  @Retained
  private val viewModel: SelectFormatViewModel,
  private val resultManager: ResultManager,
  private val args: SelectFormatFragmentArgs,
  private val fragment: SelectFormatFragment,
) : AsyncEpoxyController() {

  private val context: Context
    get() = fragment.requireContext()

  private fun String.withForeground(regex: Regex): CharSequence {
    if (regex.pattern.isBlank()) {
      return this
    }
    val matchResults = regex.findAll(this)
    val resultSpan = SpannableString(this)
    matchResults.forEach { matchResult ->
      resultSpan.setSpan(
        BackgroundColorSpan(Color.YELLOW),
        matchResult.range.first,
        matchResult.range.last + 1,
        Spannable.SPAN_INCLUSIVE_EXCLUSIVE
      )
    }
    return resultSpan
  }

  override fun buildModels() {
    val state: SelectFormatState = viewModel.state
    val spacing16 = spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16)
    val queryRegex = state.query.toLowerCase().toRegex()

    horizontalDividerView {
      id("divider top")
      height(context.pxOf(16))
    }

    state.muxers.forEach { muxer ->
      val hasMatch = if (state.query.isBlank()) {
        true
      } else {
        muxer.code.value.contains(queryRegex)
            || muxer.commonExtension.any { it.value.contains(queryRegex) }
            || muxer.defaultVideoCodec?.value?.contains(queryRegex) == true
            || muxer.defaultAudioCodec?.value?.contains(queryRegex) == true
            || muxer.defaultSubtitleCodec?.value?.contains(queryRegex) == true
      }

      if (!hasMatch) {
        return@forEach
      }

      val models = buildSubModels {
        headline6TextView {
          id(muxer.code.value)
          text(muxer.code.value.withForeground(queryRegex))
          padding(spacing16)
        }

        doubleTextView {
          id("extensions ${muxer.code.value}")
          leftText("Common extensions")
          rightText(
            muxer.commonExtension
              .joinToString(" ") { it.value }
              .withForeground(queryRegex)
          )
          padding(spacing16)
          onClickListener { _ ->
            setResult(
              SelectFormatResult(
                muxer.commonExtension.first(),
                muxer.code
              )
            )
          }
        }

        muxer.defaultVideoCodec?.let { defaultVideoCodec ->
          doubleTextView {
            id("default video codec ${muxer.code.value}")
            leftText("Default video codec")
            rightText(defaultVideoCodec.value.withForeground(queryRegex))
            padding(spacing16)
          }
        }

        muxer.defaultAudioCodec?.let { defaultAudioCodec ->
          doubleTextView {
            id("defaultAudioCodec ${muxer.code.value}")
            leftText("Default video codec")
            rightText(defaultAudioCodec.value.withForeground(queryRegex))
            padding(spacing16)
          }
        }

        muxer.defaultSubtitleCodec?.let { defaultSubtitleCodec ->
          doubleTextView {
            id("defaultSubtitleCodec ${muxer.code.value}")
            leftText("Default video codec")
            rightText(defaultSubtitleCodec.value.withForeground(queryRegex))
            padding(spacing16)
          }
        }
      }

      cardEpoxyRecyclerView {
        id(muxer.code.value)
        models(models)
      }

      horizontalDividerView {
        id("divider $muxer.code.value")
        height(context.pxOf(16))
      }
    }
  }

  private fun setResult(result: SelectFormatResult) {
    // TODO validate
    val controller = fragment.requireView().findNavController()
    resultManager.sendResult(args.requestCode, result)
    controller.popBackStack()
  }
}