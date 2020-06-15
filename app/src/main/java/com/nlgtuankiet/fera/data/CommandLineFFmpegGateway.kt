package com.nlgtuankiet.fera.data

import com.nlgtuankiet.fera.dagger.FFmpegPath
import com.nlgtuankiet.fera.dagger.FFprobePath
import com.nlgtuankiet.fera.data.ffmpeg.model.FFprobeFormatOutput
import com.nlgtuankiet.fera.data.ffmpeg.runCommand
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Stream
import com.nlgtuankiet.fera.domain.gateway.FFmpegGateway
import com.squareup.moshi.Moshi
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class CommandLineFFmpegGateway @Inject constructor(
  @FFmpegPath
  private val ffmpegPathProvider: Provider<String>,
  @FFprobePath
  private val ffprobePathProvider: Provider<String>,
  private val moshi: Moshi
) : FFmpegGateway {
  private val ffmpegPath: String
    get() = ffmpegPathProvider.get()

  private val ffprobePath: String
    get() = ffprobePathProvider.get()

  // for debug only
  suspend fun executeCommand(command: String) {
    runCommand("$ffmpegPath $command") {
      println(it)
    }
  }

  fun executeFfmpeg(command: String) = runBlocking {
    runCommand("$ffmpegPath $command") {
      println(it)
    }
  }


  override suspend fun getMediaInfo(input: String): MediaInfo {
    val jsonResult = buildString {
      runCommand(
        command = "$ffprobePath -v quiet -hide_banner -print_format json -show_format " +
            "-show_streams $input"
      ) { line ->
        append(line)
      }
    }
    println("json result: $jsonResult")

    @Suppress("BlockingMethodInNonBlockingContext")
    val formatOutput = moshi.adapter(FFprobeFormatOutput::class.java).fromJson(jsonResult)
    requireNotNull(formatOutput)
    val streams = formatOutput.streams.map {
      Stream(
        index = it.index,
        codecName = it.codecName,
        codecLongName = it.codecLongName,
        profile = it.profile,
        codecType = it.codecType,
        codecTimeBase = it.codecTimeBase,
        codecTag = it.codecTag,
        codecTagString = it.codecTagString
      )
    }

    return MediaInfo(
      streams = streams
    )
  }
}