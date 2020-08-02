package com.nlgtuankiet.fera.configure

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.BaseMavericksViewModel
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.Uninitialized
import com.airbnb.mvrx.ViewModelContext
import com.nlgtuankiet.fera.core.fragment
import com.nlgtuankiet.fera.core.ktx.copy
import com.nlgtuankiet.fera.core.ktx.launchIO
import com.nlgtuankiet.fera.core.result.ResultManager
import com.nlgtuankiet.fera.core.result.SelectFormatResult
import com.nlgtuankiet.fera.core.result.SelectVideoEncoderResult
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Muxers
import com.nlgtuankiet.fera.domain.entity.Path
import com.nlgtuankiet.fera.domain.entity.StreamOption
import com.nlgtuankiet.fera.domain.entity.VideoStreamOption
import com.nlgtuankiet.fera.domain.entity.append
import com.nlgtuankiet.fera.domain.entity.name
import com.nlgtuankiet.fera.domain.entity.parent
import com.nlgtuankiet.fera.domain.entity.pathOf
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.nlgtuankiet.fera.domain.interactor.GetMediaInfo
import com.nlgtuankiet.fera.domain.interactor.GetReplaceableFilePath
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ConfigureState(
  val mediaInfo: Async<MediaInfo> = Uninitialized,
  val selectedFormat: SelectFormatResult? = null,
  val selectedExtensionHasManyMuxer: Boolean = false,
  val streamOptions: Map<Int, StreamOption> = emptyMap(),
  val outputFilePath: Async<Path> = Uninitialized,
  val lastOutputFileName: String? = null,
  val userInputtedFilename: Boolean = false,
) : MvRxState

class ConfigureViewModel @Inject constructor(
  private val getMediaInfo: GetMediaInfo,
  private val resultManager: ResultManager,
  private val fFmpegGateway: FFmpegGateway,
  private val getReplaceableFilePath: GetReplaceableFilePath,
  private val args: ConfigureFragmentArgs,
) : BaseMavericksViewModel<ConfigureState>(ConfigureState(), BuildConfig.DEBUG) {
  private var getReplaceableFilePathJob: Job? = null

  init {
    suspend {
      getMediaInfo(args.path)
    }.execute(Dispatchers.IO) {
      copy(mediaInfo = it)
    }

    guestOutputFileName()
  }

  private fun guestOutputFileName() = withState { state ->
    getReplaceableFilePathJob?.cancel()
    if (state.userInputtedFilename) {
      // no need to guest file name when user already input file name
      getReplaceableFilePathJob = null
      return@withState
    }
    getReplaceableFilePathJob = suspend {
      getReplaceableFilePath.invoke(pathOf(args.path), state.selectedFormat?.extension)
    }.execute(Dispatchers.IO) { async ->
      if (userInputtedFilename) {
        this
      } else {
        val lastResult = if (async is Success)
          async.invoke().name
        else
          lastOutputFileName
        copy(
          outputFilePath = async,
          lastOutputFileName = lastResult
        )
      }
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
          },
        )
      }
    }
  }

  private var requestFormatJob: Job? = null

  fun onRequestFormat(requestCode: String) {
    requestFormatJob?.cancel()
    requestFormatJob = viewModelScope.launchIO {
      val result = resultManager.getResult<SelectFormatResult>(requestCode)
      val hasManyMuxer = Muxers.filter { it.commonExtension.contains(result.extension) }.count() > 1
      setState {
        copy(selectedFormat = result, selectedExtensionHasManyMuxer = hasManyMuxer)
      }
      guestOutputFileName()
    }
  }

  fun onNewOutputFileName(name: String) {
    setState {
      val newOutputFilePath = pathOf(args.path).parent.append(name)
      copy(
        outputFilePath = Success(newOutputFilePath),
        userInputtedFilename = true,
        lastOutputFileName = newOutputFilePath.name,
      )
    }
  }

  companion object : MvRxViewModelFactory<ConfigureViewModel, ConfigureState> {
    override fun create(
      viewModelContext: ViewModelContext,
      state: ConfigureState
    ): ConfigureViewModel? {
      return viewModelContext.fragment<ConfigureFragment>().viewModelFactory.get()
    }

    override fun initialState(viewModelContext: ViewModelContext): ConfigureState? {
      return ConfigureState()
    }
  }
}
