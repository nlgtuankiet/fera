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
import com.nlgtuankiet.fera.core.result.SelectType
import com.nlgtuankiet.fera.core.state
import javax.inject.Inject

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

  private fun buildMuxers(state: SelectFormatState) {
    val spacing16 = spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16)
    val queryRegex = state.query.toLowerCase().toRegex()

    horizontalDividerView {
      id("divider top")
      height(context.pxOf(16))
    }

    state.extensionWithMuxers.forEach { entry ->
      val isSingleMuxer = entry.muxers.size == 1

      val hasMatch = if (state.query.isBlank()) {
        true
      } else {
        if (isSingleMuxer) {
          entry.extension.value.contains(queryRegex)
        } else {
          entry.extension.value.contains(queryRegex)
              || entry.muxers.any { it.code.value.contains(queryRegex) }
        }
      }

      if (!hasMatch) {
        return@forEach
      }

      val models = buildSubModels {
        headline6TextView {
          id("extension ${entry.extension.value}")
          text(entry.extension.value.withForeground(queryRegex))
          padding(spacing16)
          onClickListener { _ ->
            setResult(SelectFormatResult(entry.extension, entry.muxers.first().code))
          }
        }
        if (!isSingleMuxer) {
          entry.muxers.forEach { muxer ->
            doubleTextView {
              val muxerCode = muxer.code.value
              id("muxer ${muxer.code.value} $muxerCode")
              leftText("Muxer")
              rightText(muxerCode.withForeground(queryRegex))
              padding(spacing16)
              onClickListener { _ ->
                setResult(SelectFormatResult(entry.extension, muxer.code))
              }
            }
          }
        }
      }

      cardEpoxyRecyclerView {
        id(entry.extension.value)
        models(models)
        onClickListener { _ ->

        }
      }

      horizontalDividerView {
        id("divider ${entry.extension.value}")
        height(context.pxOf(16))
      }
    }
  }

  private fun buildVideoDecoder(state: SelectFormatState) {

  }

  override fun buildModels() {
    val state: SelectFormatState = viewModel.state
    when(args.type) {
      SelectType.VideoDecoder -> buildVideoDecoder(state)
      SelectType.Muxer -> buildMuxers(state)
    }
  }

  private fun setResult(result: SelectFormatResult) {
    val controller = fragment.requireView().findNavController()
    resultManager.sendResult(args.requestCode, result)
    controller.popBackStack()
  }
}