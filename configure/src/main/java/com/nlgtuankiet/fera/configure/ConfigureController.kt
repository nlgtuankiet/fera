package com.nlgtuankiet.fera.configure

import android.content.Context
import android.view.inputmethod.EditorInfo
import androidx.core.util.rangeTo
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.mvrx.Fail
import com.airbnb.mvrx.withState
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.OneGbps
import com.nlgtuankiet.fera.core.OneKbps
import com.nlgtuankiet.fera.core.OneMbps
import com.nlgtuankiet.fera.core.Retained
import com.nlgtuankiet.fera.core.epoxy.body1TextView
import com.nlgtuankiet.fera.core.epoxy.buildSubModels
import com.nlgtuankiet.fera.core.epoxy.headline6TextView
import com.nlgtuankiet.fera.core.epoxy.horizontalDividerView
import com.nlgtuankiet.fera.core.epoxy.spacingOf
import com.nlgtuankiet.fera.core.epoxy.subtitle1TextView
import com.nlgtuankiet.fera.core.epoxy.view.button
import com.nlgtuankiet.fera.core.epoxy.view.cardEpoxyRecyclerView
import com.nlgtuankiet.fera.core.epoxy.view.doubleTextView
import com.nlgtuankiet.fera.core.epoxy.view.editText
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.core.ktx.hideKeyboard
import com.nlgtuankiet.fera.core.ktx.notNull
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.domain.entity.AudioStream
import com.nlgtuankiet.fera.domain.entity.Codecs
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.VideoStream
import com.nlgtuankiet.fera.domain.entity.VideoStreamOption
import com.nlgtuankiet.fera.domain.entity.extension
import com.nlgtuankiet.fera.domain.entity.name
import javax.inject.Inject

@FragmentScope
class ConfigureController @Inject constructor(
  @Retained private val viewModel: ConfigureViewModel,
  private val args: ConfigureFragmentArgs,
  private val fragment: ConfigureFragment,
  private val navigator: ConfigureNavigator,
) : AsyncEpoxyController() {
  private val context: Context
    get() = fragment.requireContext()

  private fun buildContainer(state: ConfigureState, mediaInfo: MediaInfo) {
    horizontalDividerView {
      id("top")
      height(context.pxOf(24))
    }

    val containerModels = buildSubModels {
      headline6TextView {
        id("container")
        text("Container")
        padding(spacingOf(context.pxOf(16)))
      }

      doubleTextView {
        id("format")
        leftText("Format")
        val formatSelected = state.selectedFormat != null
        val rightText = if (state.selectedFormat != null) {
          if (state.selectedExtensionHasManyMuxer) {
            "${state.selectedFormat.extension.value} (using ${state.selectedFormat.muxerCode.value})"
          } else {
            state.selectedFormat.extension.value
          }
        } else {
          mediaInfo.format.name
        }
        rightText(rightText)
        backColor(if (formatSelected) context.colorOf(android.R.color.holo_orange_light) else 0)
        padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        onClickListener { _ ->
          navigator.toSelectFormat()
        }
      }
    }
    cardEpoxyRecyclerView {
      id("container for ${mediaInfo.hashCode()}")
      models(containerModels)
    }
  }

  private fun getBitRateText(rate: Long): String {
    return when (rate) {
      in 0 until OneKbps -> "$rate bps"
      OneKbps -> "1 Kbps"
      in OneKbps until OneMbps -> "%.1f Kbps".format(rate.toDouble() / OneKbps)
      OneMbps -> "1 Mbps"
      in OneMbps until OneGbps -> "%.1f Mbps".format(rate.toDouble() / OneMbps)
      OneGbps -> "1 Gbps"
      else -> "%.2f Gbps".format(rate.toDouble() / OneGbps)
    }
  }

  private fun buildVideoStreams(state: ConfigureState, mediaInfo: MediaInfo) {
    val yellowColor = context.colorOf(android.R.color.holo_orange_light)
    mediaInfo.streams.mapNotNull { it as? VideoStream }.forEachIndexed { index, stream ->
      val streamIndex = stream.index
      horizontalDividerView {
        id("divider stream $streamIndex")
        height(100)
      }

      val models = buildSubModels {
        headline6TextView {
          id("title $streamIndex")
          text("Video track #${index + 1}")
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        // codec
        val selectedOption = state.streamOptions[streamIndex] as? VideoStreamOption
        val selectedEncoder = selectedOption?.encoderCode

        doubleTextView {
          id("codec $streamIndex")
          leftText("Codec")
          if (selectedEncoder != null) {
            val selectedCodec = Codecs.first { it.encoders?.contains(selectedEncoder) == true }
            if (selectedCodec.encoders.notNull().size > 1) {
              rightText("${selectedCodec.code.value} (using ${selectedEncoder.value})")
            } else {
              rightText(selectedEncoder.value)
            }
          } else {
            rightText(stream.codec.code.value)
          }

          backColor(if (selectedEncoder != null) yellowColor else 0)

          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
          onClickListener { _ ->
            navigator.toSelectVideoEncoder(videoStreamIndex = stream.index)
          }
        }

        // size
        doubleTextView {
          id("size $streamIndex")
          leftText("Size")
          rightText("${stream.size.width}x${stream.size.height} (${stream.ratio})")
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        // frame rate
        doubleTextView {
          id("frame rate $streamIndex")
          leftText("Frame rate")
          rightText("%.2f fps".format(stream.frameRate))
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        // bit rate
        doubleTextView {
          id("bit rate $streamIndex")
          leftText("Bitrate")
          rightText(getBitRateText(stream.bitRate))
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }
      }

      cardEpoxyRecyclerView {
        id("video container for $streamIndex")
        models(models)
      }
    }
  }

  private fun buildAudioStreams(state: ConfigureState, mediaInfo: MediaInfo) {
    mediaInfo.streams.mapNotNull { it as? AudioStream }.forEachIndexed { index, stream ->
      val streamIndex = stream.index
      horizontalDividerView {
        id("divider stream $streamIndex")
        height(context.pxOf(16))
      }

      val models = buildSubModels {
        headline6TextView {
          id("title $streamIndex")
          text("Audio track #${index + 1}")
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        // codec
        doubleTextView {
          id("codec of $streamIndex}")
          leftText("Codec")
          rightText(stream.codec.code.value)
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        doubleTextView {
          id("sample rate of $streamIndex}")
          leftText("Sample rate")
          // TODO improve KHz
          rightText("${stream.sampleRate} Hz")
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        doubleTextView {
          id("channels of $streamIndex}")
          leftText("Channels")
          rightText(stream.channels.toString())
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }

        doubleTextView {
          id("bitrate of $streamIndex}")
          leftText("Bitrate")
          rightText(getBitRateText(stream.bitRate))
          padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
        }
      }

      cardEpoxyRecyclerView {
        id("audio container for $streamIndex")
        models(models)
      }
    }
  }

  // TODO improve replaceableFilePath on error
  private fun buildOutput(state: ConfigureState) {

    val lastOutputFileName = state.lastOutputFileName
    if (lastOutputFileName == null) {
      return
    }

    val spacing16 = spacingOf(context, 16, 16, 16, 16)
    val models = buildSubModels {
      headline6TextView {
        id("output title")
        text("Output")
        padding(spacing16)
      }

      subtitle1TextView {
        id("where")
        text("Where")
        padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 4))
      }

      body1TextView {
        id("same")
        text("Same as input")
        padding(spacing16)
      }

      subtitle1TextView {
        id("save as")
        text("Save as")
        padding(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 4))
      }

      // TODO edit text not size after set multiple line text, force single line for now
      editText {
        id("file name")
        content(lastOutputFileName)
        padding(spacing16)
        onBind { _, view, _ ->
          requestLoseOutputNameFocus = {
            view.clearFocus()
          }
        }
        onUnbind { _, _ ->
          requestLoseOutputNameFocus = null
        }
        onTextChangeWithFocusListener { value ->
          viewModel.onNewOutputFileName(value)
        }
        imeOption(EditorInfo.IME_ACTION_DONE)
        onEditorActionListener { v, actionId, _ ->
          if (actionId == EditorInfo.IME_ACTION_DONE) {
            requestLoseOutputNameFocus?.invoke()
            v.hideKeyboard()
            true
          } else {
            false
          }
        }
      }
    }

    horizontalDividerView {
      id("divider file name")
      height(context.pxOf(16))
    }

    cardEpoxyRecyclerView {
      id("card file name")
      models(models)
    }
  }

  override fun buildModels() {
    val state = withState(viewModel) { it }
    (state.mediaInfo as? Fail)?.let { throw it.error }
    val mediaInfo = state.mediaInfo.invoke() ?: return

    buildContainer(state, mediaInfo)
    buildVideoStreams(state, mediaInfo)
    buildAudioStreams(state, mediaInfo)
    buildOutput(state)
    buildConvert(state)
    horizontalDividerView {
      id("last divider")
      height(context.pxOf(24))
    }
  }

  private fun buildConvert(state: ConfigureState) {
    button {
      id("convert")
      content("Convert!")
      margin(spacingOf(context = context, start = 16, top = 16, end = 16, bottom = 16))
      onClickListener { _ ->
        viewModel.onConvertClick()
      }
    }
  }

  private var requestLoseOutputNameFocus: (() -> Unit)? = null

  fun onScroll() {
    requestLoseOutputNameFocus?.invoke()
  }
}
