package com.nlgtuankiet.fera.configure

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.core.ktx.copy
import com.nlgtuankiet.fera.core.result.ResultManager
import com.nlgtuankiet.fera.core.result.SelectFormatResult
import com.nlgtuankiet.fera.core.result.SelectVideoEncoderResult
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Muxers
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.StreamOption
import com.nlgtuankiet.fera.domain.entity.VideoStreamOption
import com.nlgtuankiet.fera.domain.entity.pathOf
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ConfigureState(
  val mediaInfo: Async<MediaInfo> = Uninitialized,
  val selectedFormat: SelectFormatResult? = null,
  val selectedExtensionHasManyMuxer: Boolean = false,
  val streamOptions: Map<Int, StreamOption> = emptyMap(),
  val outputFileName: String? = null,
  ) : MvRxState

class ConfigureViewModel @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val resultManager: ResultManager,
  private val fFmpegGateway: FFmpegGateway,
  private val args: ConfigureFragmentArgs,
) : BaseMavericksViewModel<ConfigureState>(ConfigureState(), BuildConfig.DEBUG) {

  init {
    suspend {
      getMediaInfo(args.path)
    }.execute(Dispatchers.IO) {
      copy(mediaInfo = it)
    }
  }

  fun onRequestVideoEncoder(videoStreamIndex: Int, requestCode: String) {
    viewModelScope.launch {
      val result = resultManager.getResult<SelectVideoEncoderResult>(requestCode)
      setState {
        copy(
          streamOptions = streamOptions.copy {
            val currentOption = get(videoStreamIndex) as? VideoStreamOption ?: VideoStreamOption()
            put(videoStreamIndex, currentOption.copy(encoderCode = result.encoderCode))
          }
        )
      }
    }
  }

  fun onRequestFormat(requestCode: String) {
    viewModelScope.launch {
      val result = resultManager.getResult<SelectFormatResult>(requestCode)
      val hasManyMuxer = Muxers.filter { it.commonExtension.contains(result.extension) }.count() > 1
      setState {
        copy(selectedFormat = result, selectedExtensionHasManyMuxer = hasManyMuxer)
      }
    }
  }

  fun onNewOutputFileName(name: String) {
    setState { copy(outputFileName = name) }
  }

  companion object : MvRxViewModelFactory<ConfigureViewModel, ConfigureState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: ConfigureState
    ): ConfigureViewModel? {
      return viewModelContext.fragment<ConfigureFragment>().viewModelFactory.get()
    }
  }
}
