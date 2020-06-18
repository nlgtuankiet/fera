package com.nlgtuankiet.fera.codegen

import org.zeroturnaround.exec.ProcessExecutor
import java.io.File

suspend fun main(args: Array<String>) {
  testCoroutine()
}

inline class CodecCode(val value: String)

enum class CodecType {
  Video,
  Audio,
  Subtitle,
  Data,
}

open class SampleCodec(
  val code: CodecCode,
  val description: String,
  val canDecode: Boolean,
  val canEncode: Boolean,
  val type: CodecType,
  val isIntraFrameOnly: Boolean,
  val canCompressLossy: Boolean,
  val canCompressLossless: Boolean
)

val codecsMapping = mapOf(
  "" to SampleCodec(
    code = CodecCode(value = "012v"),
    description = "Uncompressed 4:2:2 10-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  )
)

fun genCodec() {
  var codecLineRegex: Regex
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
  """(\w|\.)(\w|\.)(\w|\.)(\w|\.)(\w|\.)(\w|\.) (.+? +)(.*)"""
    .let { codecLineRegex = it.toRegex() }

  val wordRegex =
    """_(\w)""".toRegex()
  val codecs = mutableListOf<SampleCodec>()
  val rawLines = ProcessExecutor()
    .readOutput(true)
    .command("ffmpeg", "-codecs")
    .execute()
    .outputString()
    .substringAfter("-------").also { println("after: $it") }
    .splitToSequence("\n")
    .map { it.trim() }
    .filter { it.isNotBlank() }
  rawLines.forEach { line ->
    val values = codecLineRegex.find(line)?.run {
      groupValues.drop(1)
    } ?: return@forEach
    val codeType = when (values[2]) {
      "V" -> CodecType.Video
      "A" -> CodecType.Audio
      "S" -> CodecType.Subtitle
      "D" -> CodecType.Data
      else -> {
        println(values)
        error("What? ${values[2]}")
      }
    }
    val codec = SampleCodec(
      code = CodecCode(values[6].trim()),
      description = values[7].trim(),
      canDecode = values[0] == "D",
      canEncode = values[1] == "E",
      type = codeType,
      isIntraFrameOnly = values[3] == "I",
      canCompressLossy = values[4] == "L",
      canCompressLossless = values[5] == "S"
    )
    codecs.add(codec)
  }

  val buildFolder = File("./build")
  val codecGenFile = File(buildFolder, "Codec.kt")

  val indent = "  "
  buildString {
    appendln(
      """
      package com.nlgtuankiet.fera.domain.domain.entity
      
      inline class CodecCode(val value: String)

      enum class CodecType {
        Video,
        Audio,
        Subtitle,
        Data,
      }
      """.trimIndent()
    )
    appendln()
    appendln(
      """
      class Codec(
        val code: CodecCode,
        val description: String,
        val canDecode: Boolean,
        val canEncode: Boolean,
        val type: CodecType,
        val isIntraFrameOnly: Boolean,
        val canCompressLossy: Boolean,
        val canCompressLossless: Boolean
      )
      """.trimIndent()
    )
    appendln()
    appendln("val codecsMapping = mapOf(")
    val lastIndex = codecs.lastIndex
    withIndent(indent) {
      codecs.forEachIndexed { index, codec ->
        val clazzName: String = run {
          val code = codec.code.value
          when {
            code[0].isDigit() -> when {
              code.startsWith("0") -> "Zero${code.drop(1)}"
              code.startsWith("4") -> "Four${code.drop(1)}"
              code.startsWith("8") -> "Eight${code.drop(1)}"
              else -> error("What? $code")
            }
            else -> code.capitalize()
          }
        }.replace(wordRegex) { it.groupValues[1].capitalize() }
        appendln(""""${codec.code.value}" to Codec(""")
        withIndent(indent) {
          appendln("""code = CodecCode(value = "${codec.code.value}"),""")
          appendln("""description = "${codec.description}",""")
          appendln("canDecode = ${codec.canDecode},")
          appendln("canEncode = ${codec.canEncode},")
          appendln("type = CodecType.${codec.type.name},")
          appendln("isIntraFrameOnly = ${codec.isIntraFrameOnly},")
          appendln("canCompressLossy = ${codec.canCompressLossy},")
          appendln("canCompressLossless = ${codec.canCompressLossless}")
        }
        if (index != lastIndex) {
          appendln("),")
        } else {
          appendln(")")
        }
      }
    }
    appendln(")")
  }.let { codecGenFile.writeText(it) }
}

fun Appendable.withIndent(indent: String, block: Appendable.() -> Unit) {
  val thisBuilder = this
  val appendable = object : Appendable {
    override fun append(csq: CharSequence?): Appendable {
      return thisBuilder.append("$indent$csq")
    }

    override fun append(csq: CharSequence?, start: Int, end: Int): Appendable {
      error("")
    }

    override fun append(c: Char): Appendable {
      error("")
    }
  }
  block.invoke(appendable)
}
