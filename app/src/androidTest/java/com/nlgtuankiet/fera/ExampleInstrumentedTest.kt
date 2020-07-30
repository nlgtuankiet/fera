package com.nlgtuankiet.fera

import android.Manifest
import android.os.Environment
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.nlgtuankiet.fera.core.coreComponent
import com.nlgtuankiet.fera.core.ktx.notNull
import com.nlgtuankiet.fera.domain.entity.Codec
import com.nlgtuankiet.fera.domain.entity.CodecType
import com.nlgtuankiet.fera.domain.entity.DecoderCode
import com.nlgtuankiet.fera.domain.entity.EncoderCode
import com.nlgtuankiet.fera.domain.entity.Muxer
import com.nlgtuankiet.fera.domain.entity.codecCodeOf
import com.nlgtuankiet.fera.domain.entity.decoderCodeOf
import com.nlgtuankiet.fera.domain.entity.encoderCodeOf
import com.nlgtuankiet.fera.domain.entity.extensionOf
import com.nlgtuankiet.fera.domain.entity.muxerCodeOf
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File
import java.lang.StringBuilder

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

  @get:Rule
  public var mRuntimePermissionRule: GrantPermissionRule =
    GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE)

  @get:Rule
  public var mRuntimePermissionRule2: GrantPermissionRule =
    GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)

  @Test
  fun generateAllCodec(): Unit = runBlocking {
    val codecs = getAllCodecs()
    writeCodecsFile(codecs)
  }

  private fun writeCodecsFile(codecs: List<Codec>) {
    val Codecs = listOf(
      Codec(
        code = codecCodeOf("a"),
        decoders = listOf(
          decoderCodeOf("a"),
        ),
        encoders = listOf(
          encoderCodeOf("a")
        ),
        canDecode = true,
        canEncode = true,
        type = CodecType.Audio,
        isIntraFrameOnly = true,
        canCompressLossy = false,
        canCompressLossless = true,
      ),
    )
    val fileContent = buildString {
      appendLine("package com.nlgtuankiet.fera.domain.entity")
      appendLine()
      appendLine("val Codecs = listOf(")
      withAppender {
        withIndent {
          codecs.forEach { codec ->
            appendLine("Codec(")
            withIndent {
              appendLine("""code = codecCodeOf("${codec.code.value}"),""")
              if (codec.decoders == null) {
                appendLine("decoders = null,")
              } else {
                appendLine("decoders = listOf(")
                codec.decoders?.forEach { decoderCode ->
                  withIndent {
                    appendLine("""decoderCodeOf("${decoderCode.value}"),""")
                  }
                }
                appendLine("),")
              }
              if (codec.encoders == null) {
                appendLine("encoders = null,")
              } else {
                appendLine("encoders = listOf(")
                codec.encoders?.forEach { encoderCode ->
                  withIndent {
                    appendLine("""encoderCodeOf("${encoderCode.value}"),""")
                  }
                }
                appendLine("),")
              }

              appendLine("""canDecode = ${codec.canDecode},""")
              appendLine("""canEncode = ${codec.canEncode},""")
              appendLine("""type = CodecType.${codec.type},""")
              appendLine("""isIntraFrameOnly = ${codec.isIntraFrameOnly},""")
              appendLine("""canCompressLossy = ${codec.canCompressLossy},""")
              appendLine("""canCompressLossless = ${codec.canCompressLossless},""")
            }
            appendLine("),")
          }
        }
      }

      appendLine(")")
    }

    val storageDir = Environment.getExternalStorageDirectory()
    val outputFile = File(storageDir, "Codecs.kt")
    outputFile.writeText(fileContent)
  }

  private suspend fun getAllCodecs(): List<Codec> {
    val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    val ffmpegGateway = context.coreComponent.ffmpegGateway
    val codecs = mutableListOf<Codec>()

    val rawLines = ffmpegGateway.runRawCommand(" -codecs", true)
      .substringAfter("-------")
      .splitToSequence("\n")
      .map { it.trim() }
      .filter { it.isNotBlank() }
      .also { println("output: ${it.joinToString("\n")}") }
      .toList()


    val lineRegex = """(D|\.)(E|\.)(\w+|\.)(I|\.)(L|\.)(S|\.)\s(\S+)(\s+)?(\(decoders: (\w+\s)+\))?\s?(\(encoders: (\w+\s)+\))?""".toRegex()
    val decoderRegex = """\(decoders: ((\w+\s)+)\)""".toRegex()
    val encoderRegex = """\(encoders: ((\w+\s)+)\)""".toRegex()
    rawLines.forEach { line ->
      val match = lineRegex.matchEntire(line) ?: error("match empty for line: $line")
      val matchResult = match.notNull().groupValues
      val codecCode = codecCodeOf(matchResult[7].trim())

      val canDecode = matchResult[1] == "D"
      val canEncode = matchResult[2] == "E"

      val codeType = when (matchResult[3]) {
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
      decoderRegex.matchEntire(line)?.groupValues?.getOrNull(1)?.let {decodesString  ->
        decodesString.splitToSequence(" ")
          .map { it.trim() }.filter { it.isNotBlank() }
          .forEach { decoders.add(decoderCodeOf(it)) }
      }
      if (decoders.isEmpty() && canDecode) {
        decoders.add(decoderCodeOf(codecCode.value))
      }
      encoderRegex.matchEntire(line)?.groupValues?.getOrNull(1)?.let { encodesString  ->
        encodesString.splitToSequence(" ")
          .map { it.trim() }.filter { it.isNotBlank() }
          .forEach { encoders.add(encoderCodeOf(it)) }
      }
      if (encoders.isEmpty() && canEncode) {
        encoders.add(encoderCodeOf(codecCode.value))
      }

      val codec = Codec(
        code = codecCode,
        encoders = encoders.ifEmpty { null },
        decoders = decoders.ifEmpty { null },
        canDecode = canDecode,
        canEncode = canEncode,
        type = codeType,
        isIntraFrameOnly = matchResult[4] == "I",
        canCompressLossy = matchResult[5] == "L",
        canCompressLossless = matchResult[6] == "S"
      )
      codecs.add(codec)
    }
    return codecs
  }

  /**
   * Codec types: [video, audio, subtitle]
   * Codec mine: [audio, image, video, text, application, multipart]
   */
  fun generateAllFormat(): Unit = runBlocking {
    val context = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext
    val ffmpegGateway = context.coreComponent.ffmpegGateway
    val codecTypes = mutableSetOf<String>()
    val minesType = mutableSetOf<String>()
    val unknownMuxers = mutableSetOf<String>()
    val muxers = mutableListOf<Muxer>()
    val unknownExtensionMuxer = mutableSetOf<String>()
    var muxerCount = 0
    context.coreComponent.ffmpegGateway.runRawCommand(" -muxers")
      .substringAfterLast("--")
      .splitToSequence("\n")
      .map { it.trim() }
      .filter { it.isNotBlank() }
      .toList()
      .map { line ->
        val elements = line.split(" ").filter { it.isNotBlank() }
        val muxerCode = elements[1].trim()
        val canDemuxing = elements[0].contains("D")
        val canMuxing = elements[0].contains("E")
        require(canMuxing)
        val muxerDetailLines = ffmpegGateway.runRawCommand(" -hide_banner -h muxer=$muxerCode")
          .split("\n")
          .map { it.trim() }
        val muxerDetailOutput = muxerDetailLines.joinToString("\n")
        if (muxerDetailOutput.contains("Mime type: application/")) {
          // ignore application
          return@map null
        }
        muxerCount++

        if (!muxerDetailOutput.contains("Unknown format")) {
          println(line)
          println(muxerDetailOutput)
          println("XXXXXXXXXX")
          // have valid muxer
          val commonExtensions = """Common extensions: (\w+(,\w+)*).""".toRegex()
            .find(muxerDetailOutput)
            ?.groupValues
            ?.getOrNull(1)
            ?.split(",")
            ?.map { it.trim() }
            ?.toSet() ?: emptySet()
          if (commonExtensions.isEmpty()) {
            unknownExtensionMuxer.add(muxerCode)
            return@map null
          }

          fun getCodec(type: String, content: String): String? {
            return """Default $type codec: (\w+).""".toRegex()
              .find(content)
              ?.groupValues
              ?.getOrNull(1)
          }

          val videoCodec = getCodec("video", muxerDetailOutput)
          val audioCodec = getCodec("audio", muxerDetailOutput)
          val subtitleCodec = getCodec("subtitle", muxerDetailOutput)

          val muxer = Muxer(
            code = muxerCodeOf(muxerCode),
            canMuxing = canMuxing,
            canDemuxing = canDemuxing,
            commonExtension = commonExtensions.map { extensionOf(it) }.toSet(),
            defaultVideoCodec = videoCodec?.let { codecCodeOf(it) },
            defaultAudioCodec = audioCodec?.let { codecCodeOf(it) },
            defaultSubtitleCodec = subtitleCodec?.let { codecCodeOf(it) },
          )

          muxers.add(muxer)

        } else {
          unknownMuxers.add(muxerCode)
        }
        val codecRegex = """Default (\w+) codec""".toRegex()
        val codecLine = muxerDetailLines.find { it.contains(codecRegex) } ?: ""
        val codecType = codecRegex.find(codecLine)?.groupValues?.getOrNull(1)
        codecTypes.add(codecType ?: "")
        """Mime type: (\w+)/\w+.""".toRegex()
          .find(muxerDetailLines.find { it.contains("Mime type") } ?: "")
          ?.groupValues
          ?.getOrNull(1)
          ?.let { minesType.add(it) }
      }

    println(muxers)
    println("total muxers $muxerCount")
    println("total unknown muxers ${unknownMuxers.count()} $unknownMuxers")
    println("total unknown extension muxers ${unknownExtensionMuxer.count()} $unknownExtensionMuxer")
    println("total success muxer ${muxers.count()}")

    fun Appender.appendFormat(format: Muxer) {
      appendLine("Muxer(")
      withIndent {
        appendLine("""code = MuxerCode(value = "${format.code.value}"),""")
        appendLine("""canMuxing = ${format.canMuxing},""")
        appendLine("""canDemuxing = ${format.canDemuxing},""")
        appendLine("""commonExtension = setOf(""")
        withIndent {
          format.commonExtension.forEach { extension ->
            appendLine("""extensionOf(value = "${extension.value}"),""")
          }
        }
        appendLine("""),""")
        if (format.defaultVideoCodec != null) {
          appendLine("""defaultVideoCodec = codecCodeOf(value = "${format.defaultVideoCodec!!.value}"),""")
        } else {
          appendLine("""defaultVideoCodec = null,""")
        }
        if (format.defaultAudioCodec != null) {
          appendLine("""defaultAudioCodec = codecCodeOf(value = "${format.defaultAudioCodec!!.value}"),""")
        } else {
          appendLine("""defaultAudioCodec = null,""")
        }
        if (format.defaultSubtitleCodec != null) {
          appendLine("""defaultSubtitleCodec = codecCodeOf(value = "${format.defaultSubtitleCodec!!.value}"),""")
        } else {
          appendLine("""defaultSubtitleCodec = null,""")
        }
      }
      appendLine("),")
    }

    val fileContent = buildString {
      withAppender {
        appendLine("package com.nlgtuankiet.fera.domain.entity")
        appendLine("")
        appendLine("val muxers = listOf(")
        withIndent {
          muxers.forEach { format ->
            appendFormat(format)
          }
        }
        appendLine(")")
      }
    }

    val storageDir = Environment.getExternalStorageDirectory()
    val outputFile = File(storageDir, "Muxers.kt")
    outputFile.writeText(fileContent)
    // adb shell cat sdcard/Muxers.kt | pbcopy
  }


  interface Appender {
    fun appendLine(value: String)
  }

  fun StringBuilder.withAppender(builderAction: Appender.() -> Unit) {
    val appender = object : Appender {
      override fun appendLine(value: String) {
        this@withAppender.appendLine(value)
      }
    }
    builderAction.invoke(appender)
  }

  fun Appender.withIndent(noOfIndent: Int = 2, builderAction: Appender.() -> Unit) {
    val indent = buildString { repeat(2) { append(" ") } }
    val appender = object : Appender {
      override fun appendLine(value: String) {
        this@withIndent.appendLine("$indent$value")
      }
    }
    builderAction.invoke(appender)
  }
}
