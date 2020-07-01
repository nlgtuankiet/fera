package com.nlgtuankiet.fera.data

import com.nlgtuankiet.fera.core.FFmpegPath
import com.nlgtuankiet.fera.core.FFprobePath
import com.nlgtuankiet.fera.data.ffmpeg.model.FFprobeFormatOutput
import com.nlgtuankiet.fera.data.ffmpeg.runCommand
import com.nlgtuankiet.fera.data.ffmpeg.runCommandToString
import com.nlgtuankiet.fera.domain.entity.Codec
import com.nlgtuankiet.fera.domain.entity.CodecCode
import com.nlgtuankiet.fera.domain.entity.CodecType
import com.nlgtuankiet.fera.domain.entity.DecoderCode
import com.nlgtuankiet.fera.domain.entity.EncoderCode
import com.nlgtuankiet.fera.domain.entity.MediaInfo
import com.nlgtuankiet.fera.domain.entity.Stream
import com.nlgtuankiet.fera.domain.entity.asCodecCode
import com.nlgtuankiet.fera.domain.entity.asDecoderCode
import com.nlgtuankiet.fera.domain.entity.asEncoderCode
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

  private val codecs: List<Codec> by lazy {
    getAllCodecs()
  }

  private val codecsByCode by lazy {
    codecs.associateBy { it.code }
  }

  private fun getAllCodecs(): List<Codec> {
    assertNotMainThread()
    val codecLineRegex: Regex =
      // 0 D..... = Decoding supported
      // 1 .E.... = Encoding supported
      // 2 ..V... = Video codec
      //   ..A... = Audio codec
      //   ..S... = Subtitle codec
      // 3 ...I.. = Intra frame-only codec
      // 4 ....L. = Lossy compression
      // 5 .....S = Lossless compression
      // 6 code
      // 7 description
      // 0      1      2      3      4      5       6      7
      """(\w|\.)(\w|\.)(\w|\.)(\w|\.)(\w|\.)(\w|\.) (.+? +)(.*)""".toRegex()
    val codecs = mutableListOf<Codec>()

    val rawLines = runBlocking {
      runCommandToString("${ffmpegPathProvider.get()} -codecs")
    }
      .substringAfter("-------")
      .splitToSequence("\n")
      .map { it.trim() }
      .filter { it.isNotBlank() }

    fun String.parseDecoders(): List<DecoderCode> {
      return replace("(", "")
        .replace(")", "")
        .replace("decoders:", "")
        .split(" ")
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map { it.asDecoderCode() }
    }

    fun String.parseEncoders(): List<EncoderCode> {
      return replace("(", "")
        .replace(")", "")
        .replace("encoders:", "")
        .split(" ")
        .map { it.trim() }
        .filter { it.isNotEmpty() }
        .map { it.asEncoderCode() }
    }

    rawLines.forEach { line ->
      val groups = codecLineRegex.find(line)?.run {
        groupValues.drop(1)
      } ?: return@forEach
      val codeType = when (groups[2]) {
        "V" -> CodecType.Video
        "A" -> CodecType.Audio
        "S" -> CodecType.Subtitle
        "D" -> CodecType.Data
        else -> {
          error("Unknown codec: $line")
        }
      }

      val decoders = mutableListOf<DecoderCode>()
      val encoders = mutableListOf<EncoderCode>()
      if (groups.getOrNull(8) != null) {
        val deen = groups[8]
        if (deen.contains("decoders") && deen.contains("encoders")) {
          deen.substringBefore(") (")
            .parseDecoders()
            .let { decoders.addAll(it) }

          deen.substringAfter(") (")
            .parseEncoders()
            .let { encoders.addAll(it) }
        } else if (deen.contains("decoders")) {
          deen.substringBefore(") (")
            .parseDecoders()
            .let { decoders.addAll(it) }
        } else if (deen.contains("encoders")) {
          deen.substringAfter(") (")
            .parseEncoders()
            .let { encoders.addAll(it) }
        }
      }

      val codec = Codec(
        code = CodecCode(groups[6].trim()),
        encoder = encoders.ifEmpty { null },
        decoder = decoders.ifEmpty { null },
        description = groups[7].trim(),
        canDecode = groups[0] == "D",
        canEncode = groups[1] == "E",
        type = codeType,
        isIntraFrameOnly = groups[3] == "I",
        canCompressLossy = groups[4] == "L",
        canCompressLossless = groups[5] == "S"
      )
      codecs.add(codec)
    }
    return codecs
  }

  override suspend fun getMediaInfo(input: String): MediaInfo {
    val jsonResult = buildString {
      runCommand(
        command =
          """$ffprobePath -v quiet -hide_banner -print_format json -show_format -show_streams $input"""
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
        codec = codecsByCode.getValue(requireNotNull(it.codecName).asCodecCode()),
        codecLongName = it.codecLongName,
        profile = it.profile,
        codecTimeBase = it.codecTimeBase,
        codecTag = it.codecTag,
        codecTagString = it.codecTagString
      )
    }

    return MediaInfo(
      streams = streams
    )
  }

  // for debug only
  override suspend fun test(command: String, useFfmpeg: Boolean) {
    val program = if (useFfmpeg) {
      ffmpegPath
    } else {
      ffprobePath
    }
    runCommand("$program $command") {
      println(it)
    }
  }
}
