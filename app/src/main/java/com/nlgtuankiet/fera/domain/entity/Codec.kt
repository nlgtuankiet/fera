package com.nlgtuankiet.fera.domain.entity

inline class CodecCode(val value: String)

enum class CodecType {
  Video,
  Audio,
  Subtitle,
  Data,
}

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

val codecsMapping = mapOf(
  "012v" to Codec(
    code = CodecCode(value = "012v"),
    description = "Uncompressed 4:2:2 10-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "4xm" to Codec(
    code = CodecCode(value = "4xm"),
    description = "4X Movie",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "8bps" to Codec(
    code = CodecCode(value = "8bps"),
    description = "QuickTime 8BPS video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "a64_multi" to Codec(
    code = CodecCode(value = "a64_multi"),
    description = "Multicolor charset for Commodore 64 (encoders: a64multi )",
    canDecode = false,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "a64_multi5" to Codec(
    code = CodecCode(value = "a64_multi5"),
    description = "Multicolor charset for Commodore 64, extended with 5th color (colram) (encoders: a64multi5 )",
    canDecode = false,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aasc" to Codec(
    code = CodecCode(value = "aasc"),
    description = "Autodesk RLE",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "agm" to Codec(
    code = CodecCode(value = "agm"),
    description = "Amuse Graphics Movie",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aic" to Codec(
    code = CodecCode(value = "aic"),
    description = "Apple Intermediate Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "alias_pix" to Codec(
    code = CodecCode(value = "alias_pix"),
    description = "Alias/Wavefront PIX image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "amv" to Codec(
    code = CodecCode(value = "amv"),
    description = "AMV Video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "anm" to Codec(
    code = CodecCode(value = "anm"),
    description = "Deluxe Paint Animation",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ansi" to Codec(
    code = CodecCode(value = "ansi"),
    description = "ASCII/ANSI art",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "apng" to Codec(
    code = CodecCode(value = "apng"),
    description = "APNG (Animated Portable Network Graphics) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "arbc" to Codec(
    code = CodecCode(value = "arbc"),
    description = "Gryphon's Anim Compressor",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "asv1" to Codec(
    code = CodecCode(value = "asv1"),
    description = "ASUS V1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "asv2" to Codec(
    code = CodecCode(value = "asv2"),
    description = "ASUS V2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aura" to Codec(
    code = CodecCode(value = "aura"),
    description = "Auravision AURA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aura2" to Codec(
    code = CodecCode(value = "aura2"),
    description = "Auravision Aura 2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "av1" to Codec(
    code = CodecCode(value = "av1"),
    description = "Alliance for Open Media AV1 (decoders: libaom-av1 libdav1d ) (encoders: libaom-av1 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "avrn" to Codec(
    code = CodecCode(value = "avrn"),
    description = "Avid AVI Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "avrp" to Codec(
    code = CodecCode(value = "avrp"),
    description = "Avid 1:1 10-bit RGB Packer",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "avs" to Codec(
    code = CodecCode(value = "avs"),
    description = "AVS (Audio Video Standard) video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "avs2" to Codec(
    code = CodecCode(value = "avs2"),
    description = "AVS2-P2/IEEE1857.4",
    canDecode = false,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "avui" to Codec(
    code = CodecCode(value = "avui"),
    description = "Avid Meridien Uncompressed",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ayuv" to Codec(
    code = CodecCode(value = "ayuv"),
    description = "Uncompressed packed MS 4:4:4:4",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "bethsoftvid" to Codec(
    code = CodecCode(value = "bethsoftvid"),
    description = "Bethesda VID video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "bfi" to Codec(
    code = CodecCode(value = "bfi"),
    description = "Brute Force & Ignorance",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "binkvideo" to Codec(
    code = CodecCode(value = "binkvideo"),
    description = "Bink video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "bintext" to Codec(
    code = CodecCode(value = "bintext"),
    description = "Binary text",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "bitpacked" to Codec(
    code = CodecCode(value = "bitpacked"),
    description = "Bitpacked",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "bmp" to Codec(
    code = CodecCode(value = "bmp"),
    description = "BMP (Windows and OS/2 bitmap)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "bmv_video" to Codec(
    code = CodecCode(value = "bmv_video"),
    description = "Discworld II BMV video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "brender_pix" to Codec(
    code = CodecCode(value = "brender_pix"),
    description = "BRender PIX image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "c93" to Codec(
    code = CodecCode(value = "c93"),
    description = "Interplay C93",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cavs" to Codec(
    code = CodecCode(value = "cavs"),
    description = "Chinese AVS (Audio Video Standard) (AVS1-P2, JiZhun profile)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cdgraphics" to Codec(
    code = CodecCode(value = "cdgraphics"),
    description = "CD Graphics video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cdxl" to Codec(
    code = CodecCode(value = "cdxl"),
    description = "Commodore CDXL video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cfhd" to Codec(
    code = CodecCode(value = "cfhd"),
    description = "Cineform HD",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cinepak" to Codec(
    code = CodecCode(value = "cinepak"),
    description = "Cinepak",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "clearvideo" to Codec(
    code = CodecCode(value = "clearvideo"),
    description = "Iterated Systems ClearVideo",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cljr" to Codec(
    code = CodecCode(value = "cljr"),
    description = "Cirrus Logic AccuPak",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cllc" to Codec(
    code = CodecCode(value = "cllc"),
    description = "Canopus Lossless Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "cmv" to Codec(
    code = CodecCode(value = "cmv"),
    description = "Electronic Arts CMV video (decoders: eacmv )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cpia" to Codec(
    code = CodecCode(value = "cpia"),
    description = "CPiA video format",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "cscd" to Codec(
    code = CodecCode(value = "cscd"),
    description = "CamStudio (decoders: camstudio )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "cyuv" to Codec(
    code = CodecCode(value = "cyuv"),
    description = "Creative YUV (CYUV)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "daala" to Codec(
    code = CodecCode(value = "daala"),
    description = "Daala",
    canDecode = false,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "dds" to Codec(
    code = CodecCode(value = "dds"),
    description = "DirectDraw Surface image decoder",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "dfa" to Codec(
    code = CodecCode(value = "dfa"),
    description = "Chronomaster DFA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dirac" to Codec(
    code = CodecCode(value = "dirac"),
    description = "Dirac (encoders: vc2 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "dnxhd" to Codec(
    code = CodecCode(value = "dnxhd"),
    description = "VC3/DNxHD",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dpx" to Codec(
    code = CodecCode(value = "dpx"),
    description = "DPX (Digital Picture Exchange) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "dsicinvideo" to Codec(
    code = CodecCode(value = "dsicinvideo"),
    description = "Delphine Software International CIN video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dvvideo" to Codec(
    code = CodecCode(value = "dvvideo"),
    description = "DV (Digital Video)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dxa" to Codec(
    code = CodecCode(value = "dxa"),
    description = "Feeble Files/ScummVM DXA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "dxtory" to Codec(
    code = CodecCode(value = "dxtory"),
    description = "Dxtory",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "dxv" to Codec(
    code = CodecCode(value = "dxv"),
    description = "Resolume DXV",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "escape124" to Codec(
    code = CodecCode(value = "escape124"),
    description = "Escape 124",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "escape130" to Codec(
    code = CodecCode(value = "escape130"),
    description = "Escape 130",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "exr" to Codec(
    code = CodecCode(value = "exr"),
    description = "OpenEXR image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "ffv1" to Codec(
    code = CodecCode(value = "ffv1"),
    description = "FFmpeg video codec #1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ffvhuff" to Codec(
    code = CodecCode(value = "ffvhuff"),
    description = "Huffyuv FFmpeg variant",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "fic" to Codec(
    code = CodecCode(value = "fic"),
    description = "Mirillis FIC",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "fits" to Codec(
    code = CodecCode(value = "fits"),
    description = "FITS (Flexible Image Transport System)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "flashsv" to Codec(
    code = CodecCode(value = "flashsv"),
    description = "Flash Screen Video v1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "flashsv2" to Codec(
    code = CodecCode(value = "flashsv2"),
    description = "Flash Screen Video v2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "flic" to Codec(
    code = CodecCode(value = "flic"),
    description = "Autodesk Animator Flic video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "flv1" to Codec(
    code = CodecCode(value = "flv1"),
    description = "FLV / Sorenson Spark / Sorenson H.263 (Flash Video) (decoders: flv ) (encoders: flv )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "fmvc" to Codec(
    code = CodecCode(value = "fmvc"),
    description = "FM Screen Capture Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "fraps" to Codec(
    code = CodecCode(value = "fraps"),
    description = "Fraps",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "frwu" to Codec(
    code = CodecCode(value = "frwu"),
    description = "Forward Uncompressed",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "g2m" to Codec(
    code = CodecCode(value = "g2m"),
    description = "Go2Meeting",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "gdv" to Codec(
    code = CodecCode(value = "gdv"),
    description = "Gremlin Digital Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "gif" to Codec(
    code = CodecCode(value = "gif"),
    description = "CompuServe GIF (Graphics Interchange Format)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "h261" to Codec(
    code = CodecCode(value = "h261"),
    description = "H.261",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "h263" to Codec(
    code = CodecCode(value = "h263"),
    description = "H.263 / H.263-1996, H.263+ / H.263-1998 / H.263 version 2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "h263i" to Codec(
    code = CodecCode(value = "h263i"),
    description = "Intel H.263",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "h263p" to Codec(
    code = CodecCode(value = "h263p"),
    description = "H.263+ / H.263-1998 / H.263 version 2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "h264" to Codec(
    code = CodecCode(value = "h264"),
    description = "H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10 (encoders: libx264 libx264rgb h264_videotoolbox )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "hap" to Codec(
    code = CodecCode(value = "hap"),
    description = "Vidvox Hap",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "hevc" to Codec(
    code = CodecCode(value = "hevc"),
    description = "H.265 / HEVC (High Efficiency Video Coding) (encoders: libx265 hevc_videotoolbox )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "hnm4video" to Codec(
    code = CodecCode(value = "hnm4video"),
    description = "HNM 4 video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "hq_hqa" to Codec(
    code = CodecCode(value = "hq_hqa"),
    description = "Canopus HQ/HQA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "hqx" to Codec(
    code = CodecCode(value = "hqx"),
    description = "Canopus HQX",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "huffyuv" to Codec(
    code = CodecCode(value = "huffyuv"),
    description = "HuffYUV",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "hymt" to Codec(
    code = CodecCode(value = "hymt"),
    description = "HuffYUV MT",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "idcin" to Codec(
    code = CodecCode(value = "idcin"),
    description = "id Quake II CIN video (decoders: idcinvideo )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "idf" to Codec(
    code = CodecCode(value = "idf"),
    description = "iCEDraw text",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "iff_ilbm" to Codec(
    code = CodecCode(value = "iff_ilbm"),
    description = "IFF ACBM/ANIM/DEEP/ILBM/PBM/RGB8/RGBN (decoders: iff )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "imm4" to Codec(
    code = CodecCode(value = "imm4"),
    description = "Infinity IMM4",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "indeo2" to Codec(
    code = CodecCode(value = "indeo2"),
    description = "Intel Indeo 2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "indeo3" to Codec(
    code = CodecCode(value = "indeo3"),
    description = "Intel Indeo 3",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "indeo4" to Codec(
    code = CodecCode(value = "indeo4"),
    description = "Intel Indeo Video Interactive 4",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "indeo5" to Codec(
    code = CodecCode(value = "indeo5"),
    description = "Intel Indeo Video Interactive 5",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "interplayvideo" to Codec(
    code = CodecCode(value = "interplayvideo"),
    description = "Interplay MVE video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "jpeg2000" to Codec(
    code = CodecCode(value = "jpeg2000"),
    description = "JPEG 2000 (decoders: jpeg2000 libopenjpeg ) (encoders: jpeg2000 libopenjpeg )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "jpegls" to Codec(
    code = CodecCode(value = "jpegls"),
    description = "JPEG-LS",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "jv" to Codec(
    code = CodecCode(value = "jv"),
    description = "Bitmap Brothers JV video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "kgv1" to Codec(
    code = CodecCode(value = "kgv1"),
    description = "Kega Game Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "kmvc" to Codec(
    code = CodecCode(value = "kmvc"),
    description = "Karl Morton's video codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "lagarith" to Codec(
    code = CodecCode(value = "lagarith"),
    description = "Lagarith lossless",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ljpeg" to Codec(
    code = CodecCode(value = "ljpeg"),
    description = "Lossless JPEG",
    canDecode = false,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "loco" to Codec(
    code = CodecCode(value = "loco"),
    description = "LOCO",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "lscr" to Codec(
    code = CodecCode(value = "lscr"),
    description = "LEAD Screen Capture",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "m101" to Codec(
    code = CodecCode(value = "m101"),
    description = "Matrox Uncompressed SD",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mad" to Codec(
    code = CodecCode(value = "mad"),
    description = "Electronic Arts Madcow Video (decoders: eamad )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "magicyuv" to Codec(
    code = CodecCode(value = "magicyuv"),
    description = "MagicYUV video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mdec" to Codec(
    code = CodecCode(value = "mdec"),
    description = "Sony PlayStation MDEC (Motion DECoder)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mimic" to Codec(
    code = CodecCode(value = "mimic"),
    description = "Mimic",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mjpeg" to Codec(
    code = CodecCode(value = "mjpeg"),
    description = "Motion JPEG",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mjpegb" to Codec(
    code = CodecCode(value = "mjpegb"),
    description = "Apple MJPEG-B",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mmvideo" to Codec(
    code = CodecCode(value = "mmvideo"),
    description = "American Laser Games MM Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "motionpixels" to Codec(
    code = CodecCode(value = "motionpixels"),
    description = "Motion Pixels video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mpeg1video" to Codec(
    code = CodecCode(value = "mpeg1video"),
    description = "MPEG-1 video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mpeg2video" to Codec(
    code = CodecCode(value = "mpeg2video"),
    description = "MPEG-2 video (decoders: mpeg2video mpegvideo )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mpeg4" to Codec(
    code = CodecCode(value = "mpeg4"),
    description = "MPEG-4 part 2 (encoders: mpeg4 libxvid )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "msa1" to Codec(
    code = CodecCode(value = "msa1"),
    description = "MS ATC Screen",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mscc" to Codec(
    code = CodecCode(value = "mscc"),
    description = "Mandsoft Screen Capture Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "msmpeg4v1" to Codec(
    code = CodecCode(value = "msmpeg4v1"),
    description = "MPEG-4 part 2 Microsoft variant version 1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "msmpeg4v2" to Codec(
    code = CodecCode(value = "msmpeg4v2"),
    description = "MPEG-4 part 2 Microsoft variant version 2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "msmpeg4v3" to Codec(
    code = CodecCode(value = "msmpeg4v3"),
    description = "MPEG-4 part 2 Microsoft variant version 3 (decoders: msmpeg4 ) (encoders: msmpeg4 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "msrle" to Codec(
    code = CodecCode(value = "msrle"),
    description = "Microsoft RLE",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mss1" to Codec(
    code = CodecCode(value = "mss1"),
    description = "MS Screen 1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mss2" to Codec(
    code = CodecCode(value = "mss2"),
    description = "MS Windows Media Video V9 Screen",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "msvideo1" to Codec(
    code = CodecCode(value = "msvideo1"),
    description = "Microsoft Video 1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mszh" to Codec(
    code = CodecCode(value = "mszh"),
    description = "LCL (LossLess Codec Library) MSZH",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mts2" to Codec(
    code = CodecCode(value = "mts2"),
    description = "MS Expression Encoder Screen",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mvc1" to Codec(
    code = CodecCode(value = "mvc1"),
    description = "Silicon Graphics Motion Video Compressor 1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mvc2" to Codec(
    code = CodecCode(value = "mvc2"),
    description = "Silicon Graphics Motion Video Compressor 2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mwsc" to Codec(
    code = CodecCode(value = "mwsc"),
    description = "MatchWare Screen Capture Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mxpeg" to Codec(
    code = CodecCode(value = "mxpeg"),
    description = "Mobotix MxPEG video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "nuv" to Codec(
    code = CodecCode(value = "nuv"),
    description = "NuppelVideo/RTJPEG",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "paf_video" to Codec(
    code = CodecCode(value = "paf_video"),
    description = "Amazing Studio Packed Animation File Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pam" to Codec(
    code = CodecCode(value = "pam"),
    description = "PAM (Portable AnyMap) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pbm" to Codec(
    code = CodecCode(value = "pbm"),
    description = "PBM (Portable BitMap) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcx" to Codec(
    code = CodecCode(value = "pcx"),
    description = "PC Paintbrush PCX image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pgm" to Codec(
    code = CodecCode(value = "pgm"),
    description = "PGM (Portable GrayMap) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pgmyuv" to Codec(
    code = CodecCode(value = "pgmyuv"),
    description = "PGMYUV (Portable GrayMap YUV) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pictor" to Codec(
    code = CodecCode(value = "pictor"),
    description = "Pictor/PC Paint",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pixlet" to Codec(
    code = CodecCode(value = "pixlet"),
    description = "Apple Pixlet",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "png" to Codec(
    code = CodecCode(value = "png"),
    description = "PNG (Portable Network Graphics) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ppm" to Codec(
    code = CodecCode(value = "ppm"),
    description = "PPM (Portable PixelMap) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "prores" to Codec(
    code = CodecCode(value = "prores"),
    description = "Apple ProRes (iCodec Pro) (encoders: prores prores_aw prores_ks )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "prosumer" to Codec(
    code = CodecCode(value = "prosumer"),
    description = "Brooktree ProSumer Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "psd" to Codec(
    code = CodecCode(value = "psd"),
    description = "Photoshop PSD file",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ptx" to Codec(
    code = CodecCode(value = "ptx"),
    description = "V.Flash PTX image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "qdraw" to Codec(
    code = CodecCode(value = "qdraw"),
    description = "Apple QuickDraw",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "qpeg" to Codec(
    code = CodecCode(value = "qpeg"),
    description = "Q-team QPEG",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "qtrle" to Codec(
    code = CodecCode(value = "qtrle"),
    description = "QuickTime Animation (RLE) video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "r10k" to Codec(
    code = CodecCode(value = "r10k"),
    description = "AJA Kona 10-bit RGB Codec",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "r210" to Codec(
    code = CodecCode(value = "r210"),
    description = "Uncompressed RGB 10-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "rasc" to Codec(
    code = CodecCode(value = "rasc"),
    description = "RemotelyAnywhere Screen Capture",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rawvideo" to Codec(
    code = CodecCode(value = "rawvideo"),
    description = "raw video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "rl2" to Codec(
    code = CodecCode(value = "rl2"),
    description = "RL2 video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "roq" to Codec(
    code = CodecCode(value = "roq"),
    description = "id RoQ video (decoders: roqvideo ) (encoders: roqvideo )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rpza" to Codec(
    code = CodecCode(value = "rpza"),
    description = "QuickTime video (RPZA)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rscc" to Codec(
    code = CodecCode(value = "rscc"),
    description = "innoHeim/Rsupport Screen Capture Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "rv10" to Codec(
    code = CodecCode(value = "rv10"),
    description = "RealVideo 1.0",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rv20" to Codec(
    code = CodecCode(value = "rv20"),
    description = "RealVideo 2.0",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rv30" to Codec(
    code = CodecCode(value = "rv30"),
    description = "RealVideo 3.0",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "rv40" to Codec(
    code = CodecCode(value = "rv40"),
    description = "RealVideo 4.0",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "sanm" to Codec(
    code = CodecCode(value = "sanm"),
    description = "LucasArts SANM/SMUSH video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "scpr" to Codec(
    code = CodecCode(value = "scpr"),
    description = "ScreenPressor",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "screenpresso" to Codec(
    code = CodecCode(value = "screenpresso"),
    description = "Screenpresso",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sgi" to Codec(
    code = CodecCode(value = "sgi"),
    description = "SGI image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sgirle" to Codec(
    code = CodecCode(value = "sgirle"),
    description = "SGI RLE 8-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sheervideo" to Codec(
    code = CodecCode(value = "sheervideo"),
    description = "BitJazz SheerVideo",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "smackvideo" to Codec(
    code = CodecCode(value = "smackvideo"),
    description = "Smacker video (decoders: smackvid )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "smc" to Codec(
    code = CodecCode(value = "smc"),
    description = "QuickTime Graphics (SMC)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "smvjpeg" to Codec(
    code = CodecCode(value = "smvjpeg"),
    description = "Sigmatel Motion Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "snow" to Codec(
    code = CodecCode(value = "snow"),
    description = "Snow",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "sp5x" to Codec(
    code = CodecCode(value = "sp5x"),
    description = "Sunplus JPEG (SP5X)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "speedhq" to Codec(
    code = CodecCode(value = "speedhq"),
    description = "NewTek SpeedHQ",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "srgc" to Codec(
    code = CodecCode(value = "srgc"),
    description = "Screen Recorder Gold Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sunrast" to Codec(
    code = CodecCode(value = "sunrast"),
    description = "Sun Rasterfile image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "svg" to Codec(
    code = CodecCode(value = "svg"),
    description = "Scalable Vector Graphics",
    canDecode = false,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "svq1" to Codec(
    code = CodecCode(value = "svq1"),
    description = "Sorenson Vector Quantizer 1 / Sorenson Video 1 / SVQ1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "svq3" to Codec(
    code = CodecCode(value = "svq3"),
    description = "Sorenson Vector Quantizer 3 / Sorenson Video 3 / SVQ3",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "targa" to Codec(
    code = CodecCode(value = "targa"),
    description = "Truevision Targa image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "targa_y216" to Codec(
    code = CodecCode(value = "targa_y216"),
    description = "Pinnacle TARGA CineWave YUV16",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "tdsc" to Codec(
    code = CodecCode(value = "tdsc"),
    description = "TDSC",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tgq" to Codec(
    code = CodecCode(value = "tgq"),
    description = "Electronic Arts TGQ video (decoders: eatgq )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tgv" to Codec(
    code = CodecCode(value = "tgv"),
    description = "Electronic Arts TGV video (decoders: eatgv )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "theora" to Codec(
    code = CodecCode(value = "theora"),
    description = "Theora (encoders: libtheora )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "thp" to Codec(
    code = CodecCode(value = "thp"),
    description = "Nintendo Gamecube THP video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tiertexseqvideo" to Codec(
    code = CodecCode(value = "tiertexseqvideo"),
    description = "Tiertex Limited SEQ video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tiff" to Codec(
    code = CodecCode(value = "tiff"),
    description = "TIFF image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "tmv" to Codec(
    code = CodecCode(value = "tmv"),
    description = "8088flex TMV",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tqi" to Codec(
    code = CodecCode(value = "tqi"),
    description = "Electronic Arts TQI video (decoders: eatqi )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "truemotion1" to Codec(
    code = CodecCode(value = "truemotion1"),
    description = "Duck TrueMotion 1.0",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "truemotion2" to Codec(
    code = CodecCode(value = "truemotion2"),
    description = "Duck TrueMotion 2.0",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "truemotion2rt" to Codec(
    code = CodecCode(value = "truemotion2rt"),
    description = "Duck TrueMotion 2.0 Real Time",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tscc" to Codec(
    code = CodecCode(value = "tscc"),
    description = "TechSmith Screen Capture Codec (decoders: camtasia )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "tscc2" to Codec(
    code = CodecCode(value = "tscc2"),
    description = "TechSmith Screen Codec 2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "txd" to Codec(
    code = CodecCode(value = "txd"),
    description = "Renderware TXD (TeXture Dictionary) image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ulti" to Codec(
    code = CodecCode(value = "ulti"),
    description = "IBM UltiMotion (decoders: ultimotion )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "utvideo" to Codec(
    code = CodecCode(value = "utvideo"),
    description = "Ut Video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "v210" to Codec(
    code = CodecCode(value = "v210"),
    description = "Uncompressed 4:2:2 10-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "v210x" to Codec(
    code = CodecCode(value = "v210x"),
    description = "Uncompressed 4:2:2 10-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "v308" to Codec(
    code = CodecCode(value = "v308"),
    description = "Uncompressed packed 4:4:4",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "v408" to Codec(
    code = CodecCode(value = "v408"),
    description = "Uncompressed packed QT 4:4:4:4",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "v410" to Codec(
    code = CodecCode(value = "v410"),
    description = "Uncompressed 4:4:4 10-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "vb" to Codec(
    code = CodecCode(value = "vb"),
    description = "Beam Software VB",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vble" to Codec(
    code = CodecCode(value = "vble"),
    description = "VBLE Lossless Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "vc1" to Codec(
    code = CodecCode(value = "vc1"),
    description = "SMPTE VC-1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vc1image" to Codec(
    code = CodecCode(value = "vc1image"),
    description = "Windows Media Video 9 Image v2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vcr1" to Codec(
    code = CodecCode(value = "vcr1"),
    description = "ATI VCR1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vixl" to Codec(
    code = CodecCode(value = "vixl"),
    description = "Miro VideoXL (decoders: xl )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vmdvideo" to Codec(
    code = CodecCode(value = "vmdvideo"),
    description = "Sierra VMD video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vmnc" to Codec(
    code = CodecCode(value = "vmnc"),
    description = "VMware Screen Codec / VMware Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "vp3" to Codec(
    code = CodecCode(value = "vp3"),
    description = "On2 VP3",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp4" to Codec(
    code = CodecCode(value = "vp4"),
    description = "On2 VP4",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp5" to Codec(
    code = CodecCode(value = "vp5"),
    description = "On2 VP5",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp6" to Codec(
    code = CodecCode(value = "vp6"),
    description = "On2 VP6",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp6a" to Codec(
    code = CodecCode(value = "vp6a"),
    description = "On2 VP6 (Flash version, with alpha channel)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp6f" to Codec(
    code = CodecCode(value = "vp6f"),
    description = "On2 VP6 (Flash version)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp7" to Codec(
    code = CodecCode(value = "vp7"),
    description = "On2 VP7",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp8" to Codec(
    code = CodecCode(value = "vp8"),
    description = "On2 VP8 (decoders: vp8 libvpx ) (encoders: libvpx )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vp9" to Codec(
    code = CodecCode(value = "vp9"),
    description = "Google VP9 (decoders: vp9 libvpx-vp9 ) (encoders: libvpx-vp9 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wcmv" to Codec(
    code = CodecCode(value = "wcmv"),
    description = "WinCAM Motion Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "webp" to Codec(
    code = CodecCode(value = "webp"),
    description = "WebP (encoders: libwebp_anim libwebp )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "wmv1" to Codec(
    code = CodecCode(value = "wmv1"),
    description = "Windows Media Video 7",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmv2" to Codec(
    code = CodecCode(value = "wmv2"),
    description = "Windows Media Video 8",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmv3" to Codec(
    code = CodecCode(value = "wmv3"),
    description = "Windows Media Video 9",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmv3image" to Codec(
    code = CodecCode(value = "wmv3image"),
    description = "Windows Media Video 9 Image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wnv1" to Codec(
    code = CodecCode(value = "wnv1"),
    description = "Winnov WNV1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wrapped_avframe" to Codec(
    code = CodecCode(value = "wrapped_avframe"),
    description = "AVFrame to AVPacket passthrough",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ws_vqa" to Codec(
    code = CodecCode(value = "ws_vqa"),
    description = "Westwood Studios VQA (Vector Quantized Animation) video (decoders: vqavideo )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xan_wc3" to Codec(
    code = CodecCode(value = "xan_wc3"),
    description = "Wing Commander III / Xan",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xan_wc4" to Codec(
    code = CodecCode(value = "xan_wc4"),
    description = "Wing Commander IV / Xxan",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xbin" to Codec(
    code = CodecCode(value = "xbin"),
    description = "eXtended BINary text",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "xbm" to Codec(
    code = CodecCode(value = "xbm"),
    description = "XBM (X BitMap) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "xface" to Codec(
    code = CodecCode(value = "xface"),
    description = "X-face image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xpm" to Codec(
    code = CodecCode(value = "xpm"),
    description = "XPM (X PixMap) image",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "xwd" to Codec(
    code = CodecCode(value = "xwd"),
    description = "XWD (X Window Dump) image",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "y41p" to Codec(
    code = CodecCode(value = "y41p"),
    description = "Uncompressed YUV 4:1:1 12-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "ylc" to Codec(
    code = CodecCode(value = "ylc"),
    description = "YUY2 Lossless Codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "yop" to Codec(
    code = CodecCode(value = "yop"),
    description = "Psygnosis YOP Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "yuv4" to Codec(
    code = CodecCode(value = "yuv4"),
    description = "Uncompressed packed 4:2:0",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "zerocodec" to Codec(
    code = CodecCode(value = "zerocodec"),
    description = "ZeroCodec Lossless Video",
    canDecode = true,
    canEncode = false,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "zlib" to Codec(
    code = CodecCode(value = "zlib"),
    description = "LCL (LossLess Codec Library) ZLIB",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "zmbv" to Codec(
    code = CodecCode(value = "zmbv"),
    description = "Zip Motion Blocks Video",
    canDecode = true,
    canEncode = true,
    type = CodecType.Video,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "4gv" to Codec(
    code = CodecCode(value = "4gv"),
    description = "4GV (Fourth Generation Vocoder)",
    canDecode = false,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "8svx_exp" to Codec(
    code = CodecCode(value = "8svx_exp"),
    description = "8SVX exponential",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "8svx_fib" to Codec(
    code = CodecCode(value = "8svx_fib"),
    description = "8SVX fibonacci",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aac" to Codec(
    code = CodecCode(value = "aac"),
    description = "AAC (Advanced Audio Coding) (decoders: aac aac_fixed aac_at ) (encoders: aac aac_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aac_latm" to Codec(
    code = CodecCode(value = "aac_latm"),
    description = "AAC LATM (Advanced Audio Coding LATM syntax)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ac3" to Codec(
    code = CodecCode(value = "ac3"),
    description = "ATSC A/52A (AC-3) (decoders: ac3 ac3_fixed ac3_at ) (encoders: ac3 ac3_fixed )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_4xm" to Codec(
    code = CodecCode(value = "adpcm_4xm"),
    description = "ADPCM 4X Movie",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_adx" to Codec(
    code = CodecCode(value = "adpcm_adx"),
    description = "SEGA CRI ADX ADPCM",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_afc" to Codec(
    code = CodecCode(value = "adpcm_afc"),
    description = "ADPCM Nintendo Gamecube AFC",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_agm" to Codec(
    code = CodecCode(value = "adpcm_agm"),
    description = "ADPCM AmuseGraphics Movie AGM",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_aica" to Codec(
    code = CodecCode(value = "adpcm_aica"),
    description = "ADPCM Yamaha AICA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ct" to Codec(
    code = CodecCode(value = "adpcm_ct"),
    description = "ADPCM Creative Technology",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_dtk" to Codec(
    code = CodecCode(value = "adpcm_dtk"),
    description = "ADPCM Nintendo Gamecube DTK",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea" to Codec(
    code = CodecCode(value = "adpcm_ea"),
    description = "ADPCM Electronic Arts",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea_maxis_xa" to Codec(
    code = CodecCode(value = "adpcm_ea_maxis_xa"),
    description = "ADPCM Electronic Arts Maxis CDROM XA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea_r1" to Codec(
    code = CodecCode(value = "adpcm_ea_r1"),
    description = "ADPCM Electronic Arts R1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea_r2" to Codec(
    code = CodecCode(value = "adpcm_ea_r2"),
    description = "ADPCM Electronic Arts R2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea_r3" to Codec(
    code = CodecCode(value = "adpcm_ea_r3"),
    description = "ADPCM Electronic Arts R3",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ea_xas" to Codec(
    code = CodecCode(value = "adpcm_ea_xas"),
    description = "ADPCM Electronic Arts XAS",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_g722" to Codec(
    code = CodecCode(value = "adpcm_g722"),
    description = "G.722 ADPCM (decoders: g722 ) (encoders: g722 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_g726" to Codec(
    code = CodecCode(value = "adpcm_g726"),
    description = "G.726 ADPCM (decoders: g726 ) (encoders: g726 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_g726le" to Codec(
    code = CodecCode(value = "adpcm_g726le"),
    description = "G.726 ADPCM little-endian (decoders: g726le ) (encoders: g726le )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_amv" to Codec(
    code = CodecCode(value = "adpcm_ima_amv"),
    description = "ADPCM IMA AMV",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_apc" to Codec(
    code = CodecCode(value = "adpcm_ima_apc"),
    description = "ADPCM IMA CRYO APC",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_dat4" to Codec(
    code = CodecCode(value = "adpcm_ima_dat4"),
    description = "ADPCM IMA Eurocom DAT4",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_dk3" to Codec(
    code = CodecCode(value = "adpcm_ima_dk3"),
    description = "ADPCM IMA Duck DK3",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_dk4" to Codec(
    code = CodecCode(value = "adpcm_ima_dk4"),
    description = "ADPCM IMA Duck DK4",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_ea_eacs" to Codec(
    code = CodecCode(value = "adpcm_ima_ea_eacs"),
    description = "ADPCM IMA Electronic Arts EACS",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_ea_sead" to Codec(
    code = CodecCode(value = "adpcm_ima_ea_sead"),
    description = "ADPCM IMA Electronic Arts SEAD",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_iss" to Codec(
    code = CodecCode(value = "adpcm_ima_iss"),
    description = "ADPCM IMA Funcom ISS",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_oki" to Codec(
    code = CodecCode(value = "adpcm_ima_oki"),
    description = "ADPCM IMA Dialogic OKI",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_qt" to Codec(
    code = CodecCode(value = "adpcm_ima_qt"),
    description = "ADPCM IMA QuickTime (decoders: adpcm_ima_qt adpcm_ima_qt_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_rad" to Codec(
    code = CodecCode(value = "adpcm_ima_rad"),
    description = "ADPCM IMA Radical",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_smjpeg" to Codec(
    code = CodecCode(value = "adpcm_ima_smjpeg"),
    description = "ADPCM IMA Loki SDL MJPEG",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_wav" to Codec(
    code = CodecCode(value = "adpcm_ima_wav"),
    description = "ADPCM IMA WAV",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ima_ws" to Codec(
    code = CodecCode(value = "adpcm_ima_ws"),
    description = "ADPCM IMA Westwood",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_ms" to Codec(
    code = CodecCode(value = "adpcm_ms"),
    description = "ADPCM Microsoft",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_mtaf" to Codec(
    code = CodecCode(value = "adpcm_mtaf"),
    description = "ADPCM MTAF",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_psx" to Codec(
    code = CodecCode(value = "adpcm_psx"),
    description = "ADPCM Playstation",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_sbpro_2" to Codec(
    code = CodecCode(value = "adpcm_sbpro_2"),
    description = "ADPCM Sound Blaster Pro 2-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_sbpro_3" to Codec(
    code = CodecCode(value = "adpcm_sbpro_3"),
    description = "ADPCM Sound Blaster Pro 2.6-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_sbpro_4" to Codec(
    code = CodecCode(value = "adpcm_sbpro_4"),
    description = "ADPCM Sound Blaster Pro 4-bit",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_swf" to Codec(
    code = CodecCode(value = "adpcm_swf"),
    description = "ADPCM Shockwave Flash",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_thp" to Codec(
    code = CodecCode(value = "adpcm_thp"),
    description = "ADPCM Nintendo THP",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_thp_le" to Codec(
    code = CodecCode(value = "adpcm_thp_le"),
    description = "ADPCM Nintendo THP (Little-Endian)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_vima" to Codec(
    code = CodecCode(value = "adpcm_vima"),
    description = "LucasArts VIMA audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_xa" to Codec(
    code = CodecCode(value = "adpcm_xa"),
    description = "ADPCM CDROM XA",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "adpcm_yamaha" to Codec(
    code = CodecCode(value = "adpcm_yamaha"),
    description = "ADPCM Yamaha",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "alac" to Codec(
    code = CodecCode(value = "alac"),
    description = "ALAC (Apple Lossless Audio Codec) (decoders: alac alac_at ) (encoders: alac alac_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "amr_nb" to Codec(
    code = CodecCode(value = "amr_nb"),
    description = "AMR-NB (Adaptive Multi-Rate NarrowBand) (decoders: amrnb amr_nb_at libopencore_amrnb ) (encoders: libopencore_amrnb )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "amr_wb" to Codec(
    code = CodecCode(value = "amr_wb"),
    description = "AMR-WB (Adaptive Multi-Rate WideBand) (decoders: amrwb libopencore_amrwb )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ape" to Codec(
    code = CodecCode(value = "ape"),
    description = "Monkey's Audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "aptx" to Codec(
    code = CodecCode(value = "aptx"),
    description = "aptX (Audio Processing Technology for Bluetooth)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "aptx_hd" to Codec(
    code = CodecCode(value = "aptx_hd"),
    description = "aptX HD (Audio Processing Technology for Bluetooth)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "atrac1" to Codec(
    code = CodecCode(value = "atrac1"),
    description = "ATRAC1 (Adaptive TRansform Acoustic Coding)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "atrac3" to Codec(
    code = CodecCode(value = "atrac3"),
    description = "ATRAC3 (Adaptive TRansform Acoustic Coding 3)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "atrac3al" to Codec(
    code = CodecCode(value = "atrac3al"),
    description = "ATRAC3 AL (Adaptive TRansform Acoustic Coding 3 Advanced Lossless)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "atrac3p" to Codec(
    code = CodecCode(value = "atrac3p"),
    description = "ATRAC3+ (Adaptive TRansform Acoustic Coding 3+) (decoders: atrac3plus )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "atrac3pal" to Codec(
    code = CodecCode(value = "atrac3pal"),
    description = "ATRAC3+ AL (Adaptive TRansform Acoustic Coding 3+ Advanced Lossless) (decoders: atrac3plusal )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "atrac9" to Codec(
    code = CodecCode(value = "atrac9"),
    description = "ATRAC9 (Adaptive TRansform Acoustic Coding 9)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "avc" to Codec(
    code = CodecCode(value = "avc"),
    description = "On2 Audio for Video Codec (decoders: on2avc )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "binkaudio_dct" to Codec(
    code = CodecCode(value = "binkaudio_dct"),
    description = "Bink Audio (DCT)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "binkaudio_rdft" to Codec(
    code = CodecCode(value = "binkaudio_rdft"),
    description = "Bink Audio (RDFT)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "bmv_audio" to Codec(
    code = CodecCode(value = "bmv_audio"),
    description = "Discworld II BMV audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "celt" to Codec(
    code = CodecCode(value = "celt"),
    description = "Constrained Energy Lapped Transform (CELT)",
    canDecode = false,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "codec2" to Codec(
    code = CodecCode(value = "codec2"),
    description = "codec2 (very low bitrate speech codec)",
    canDecode = false,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "comfortnoise" to Codec(
    code = CodecCode(value = "comfortnoise"),
    description = "RFC 3389 Comfort Noise",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "cook" to Codec(
    code = CodecCode(value = "cook"),
    description = "Cook / Cooker / Gecko (RealAudio G2)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dolby_e" to Codec(
    code = CodecCode(value = "dolby_e"),
    description = "Dolby E",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dsd_lsbf" to Codec(
    code = CodecCode(value = "dsd_lsbf"),
    description = "DSD (Direct Stream Digital), least significant bit first",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dsd_lsbf_planar" to Codec(
    code = CodecCode(value = "dsd_lsbf_planar"),
    description = "DSD (Direct Stream Digital), least significant bit first, planar",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dsd_msbf" to Codec(
    code = CodecCode(value = "dsd_msbf"),
    description = "DSD (Direct Stream Digital), most significant bit first",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dsd_msbf_planar" to Codec(
    code = CodecCode(value = "dsd_msbf_planar"),
    description = "DSD (Direct Stream Digital), most significant bit first, planar",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dsicinaudio" to Codec(
    code = CodecCode(value = "dsicinaudio"),
    description = "Delphine Software International CIN audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dss_sp" to Codec(
    code = CodecCode(value = "dss_sp"),
    description = "Digital Speech Standard - Standard Play mode (DSS SP)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "dst" to Codec(
    code = CodecCode(value = "dst"),
    description = "DST (Direct Stream Transfer)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "dts" to Codec(
    code = CodecCode(value = "dts"),
    description = "DCA (DTS Coherent Acoustics) (decoders: dca ) (encoders: dca )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "dvaudio" to Codec(
    code = CodecCode(value = "dvaudio"),
    description = "DV audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "eac3" to Codec(
    code = CodecCode(value = "eac3"),
    description = "ATSC A/52B (AC-3, E-AC-3) (decoders: eac3 eac3_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "evrc" to Codec(
    code = CodecCode(value = "evrc"),
    description = "EVRC (Enhanced Variable Rate Codec)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "flac" to Codec(
    code = CodecCode(value = "flac"),
    description = "FLAC (Free Lossless Audio Codec)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "g723_1" to Codec(
    code = CodecCode(value = "g723_1"),
    description = "G.723.1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "g729" to Codec(
    code = CodecCode(value = "g729"),
    description = "G.729",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "gremlin_dpcm" to Codec(
    code = CodecCode(value = "gremlin_dpcm"),
    description = "DPCM Gremlin",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "gsm" to Codec(
    code = CodecCode(value = "gsm"),
    description = "GSM",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "gsm_ms" to Codec(
    code = CodecCode(value = "gsm_ms"),
    description = "GSM Microsoft variant (decoders: gsm_ms gsm_ms_at )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "hcom" to Codec(
    code = CodecCode(value = "hcom"),
    description = "HCOM Audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "iac" to Codec(
    code = CodecCode(value = "iac"),
    description = "IAC (Indeo Audio Coder)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ilbc" to Codec(
    code = CodecCode(value = "ilbc"),
    description = "iLBC (Internet Low Bitrate Codec) (decoders: ilbc ilbc_at ) (encoders: ilbc_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "imc" to Codec(
    code = CodecCode(value = "imc"),
    description = "IMC (Intel Music Coder)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "interplay_dpcm" to Codec(
    code = CodecCode(value = "interplay_dpcm"),
    description = "DPCM Interplay",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "interplayacm" to Codec(
    code = CodecCode(value = "interplayacm"),
    description = "Interplay ACM",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mace3" to Codec(
    code = CodecCode(value = "mace3"),
    description = "MACE (Macintosh Audio Compression/Expansion) 3:1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mace6" to Codec(
    code = CodecCode(value = "mace6"),
    description = "MACE (Macintosh Audio Compression/Expansion) 6:1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "metasound" to Codec(
    code = CodecCode(value = "metasound"),
    description = "Voxware MetaSound",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mlp" to Codec(
    code = CodecCode(value = "mlp"),
    description = "MLP (Meridian Lossless Packing)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "mp1" to Codec(
    code = CodecCode(value = "mp1"),
    description = "MP1 (MPEG audio layer 1) (decoders: mp1 mp1float mp1_at )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mp2" to Codec(
    code = CodecCode(value = "mp2"),
    description = "MP2 (MPEG audio layer 2) (decoders: mp2 mp2float mp2_at ) (encoders: mp2 mp2fixed )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mp3" to Codec(
    code = CodecCode(value = "mp3"),
    description = "MP3 (MPEG audio layer 3) (decoders: mp3float mp3 mp3_at ) (encoders: libmp3lame )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mp3adu" to Codec(
    code = CodecCode(value = "mp3adu"),
    description = "ADU (Application Data Unit) MP3 (MPEG audio layer 3) (decoders: mp3adufloat mp3adu )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mp3on4" to Codec(
    code = CodecCode(value = "mp3on4"),
    description = "MP3onMP4 (decoders: mp3on4float mp3on4 )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "mp4als" to Codec(
    code = CodecCode(value = "mp4als"),
    description = "MPEG-4 Audio Lossless Coding (ALS) (decoders: als )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "musepack7" to Codec(
    code = CodecCode(value = "musepack7"),
    description = "Musepack SV7 (decoders: mpc7 )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "musepack8" to Codec(
    code = CodecCode(value = "musepack8"),
    description = "Musepack SV8 (decoders: mpc8 )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "nellymoser" to Codec(
    code = CodecCode(value = "nellymoser"),
    description = "Nellymoser Asao",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "opus" to Codec(
    code = CodecCode(value = "opus"),
    description = "Opus (Opus Interactive Audio Codec) (decoders: opus libopus ) (encoders: opus libopus )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "paf_audio" to Codec(
    code = CodecCode(value = "paf_audio"),
    description = "Amazing Studio Packed Animation File Audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pcm_alaw" to Codec(
    code = CodecCode(value = "pcm_alaw"),
    description = "PCM A-law / G.711 A-law (decoders: pcm_alaw pcm_alaw_at ) (encoders: pcm_alaw pcm_alaw_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pcm_bluray" to Codec(
    code = CodecCode(value = "pcm_bluray"),
    description = "PCM signed 16|20|24-bit big-endian for Blu-ray media",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_dvd" to Codec(
    code = CodecCode(value = "pcm_dvd"),
    description = "PCM signed 20|24-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f16le" to Codec(
    code = CodecCode(value = "pcm_f16le"),
    description = "PCM 16.8 floating point little-endian",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f24le" to Codec(
    code = CodecCode(value = "pcm_f24le"),
    description = "PCM 24.0 floating point little-endian",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f32be" to Codec(
    code = CodecCode(value = "pcm_f32be"),
    description = "PCM 32-bit floating point big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f32le" to Codec(
    code = CodecCode(value = "pcm_f32le"),
    description = "PCM 32-bit floating point little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f64be" to Codec(
    code = CodecCode(value = "pcm_f64be"),
    description = "PCM 64-bit floating point big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_f64le" to Codec(
    code = CodecCode(value = "pcm_f64le"),
    description = "PCM 64-bit floating point little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_lxf" to Codec(
    code = CodecCode(value = "pcm_lxf"),
    description = "PCM signed 20-bit little-endian planar",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_mulaw" to Codec(
    code = CodecCode(value = "pcm_mulaw"),
    description = "PCM mu-law / G.711 mu-law (decoders: pcm_mulaw pcm_mulaw_at ) (encoders: pcm_mulaw pcm_mulaw_at )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pcm_s16be" to Codec(
    code = CodecCode(value = "pcm_s16be"),
    description = "PCM signed 16-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s16be_planar" to Codec(
    code = CodecCode(value = "pcm_s16be_planar"),
    description = "PCM signed 16-bit big-endian planar",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s16le" to Codec(
    code = CodecCode(value = "pcm_s16le"),
    description = "PCM signed 16-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s16le_planar" to Codec(
    code = CodecCode(value = "pcm_s16le_planar"),
    description = "PCM signed 16-bit little-endian planar",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s24be" to Codec(
    code = CodecCode(value = "pcm_s24be"),
    description = "PCM signed 24-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s24daud" to Codec(
    code = CodecCode(value = "pcm_s24daud"),
    description = "PCM D-Cinema audio signed 24-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s24le" to Codec(
    code = CodecCode(value = "pcm_s24le"),
    description = "PCM signed 24-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s24le_planar" to Codec(
    code = CodecCode(value = "pcm_s24le_planar"),
    description = "PCM signed 24-bit little-endian planar",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s32be" to Codec(
    code = CodecCode(value = "pcm_s32be"),
    description = "PCM signed 32-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s32le" to Codec(
    code = CodecCode(value = "pcm_s32le"),
    description = "PCM signed 32-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s32le_planar" to Codec(
    code = CodecCode(value = "pcm_s32le_planar"),
    description = "PCM signed 32-bit little-endian planar",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s64be" to Codec(
    code = CodecCode(value = "pcm_s64be"),
    description = "PCM signed 64-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s64le" to Codec(
    code = CodecCode(value = "pcm_s64le"),
    description = "PCM signed 64-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s8" to Codec(
    code = CodecCode(value = "pcm_s8"),
    description = "PCM signed 8-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_s8_planar" to Codec(
    code = CodecCode(value = "pcm_s8_planar"),
    description = "PCM signed 8-bit planar",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u16be" to Codec(
    code = CodecCode(value = "pcm_u16be"),
    description = "PCM unsigned 16-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u16le" to Codec(
    code = CodecCode(value = "pcm_u16le"),
    description = "PCM unsigned 16-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u24be" to Codec(
    code = CodecCode(value = "pcm_u24be"),
    description = "PCM unsigned 24-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u24le" to Codec(
    code = CodecCode(value = "pcm_u24le"),
    description = "PCM unsigned 24-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u32be" to Codec(
    code = CodecCode(value = "pcm_u32be"),
    description = "PCM unsigned 32-bit big-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u32le" to Codec(
    code = CodecCode(value = "pcm_u32le"),
    description = "PCM unsigned 32-bit little-endian",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_u8" to Codec(
    code = CodecCode(value = "pcm_u8"),
    description = "PCM unsigned 8-bit",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "pcm_vidc" to Codec(
    code = CodecCode(value = "pcm_vidc"),
    description = "PCM Archimedes VIDC",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "pcm_zork" to Codec(
    code = CodecCode(value = "pcm_zork"),
    description = "PCM Zork",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "qcelp" to Codec(
    code = CodecCode(value = "qcelp"),
    description = "QCELP / PureVoice",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "qdm2" to Codec(
    code = CodecCode(value = "qdm2"),
    description = "QDesign Music Codec 2 (decoders: qdm2 qdm2_at )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "qdmc" to Codec(
    code = CodecCode(value = "qdmc"),
    description = "QDesign Music (decoders: qdmc qdmc_at )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ra_144" to Codec(
    code = CodecCode(value = "ra_144"),
    description = "RealAudio 1.0 (14.4K) (decoders: real_144 ) (encoders: real_144 )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ra_288" to Codec(
    code = CodecCode(value = "ra_288"),
    description = "RealAudio 2.0 (28.8K) (decoders: real_288 )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "ralf" to Codec(
    code = CodecCode(value = "ralf"),
    description = "RealAudio Lossless",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "roq_dpcm" to Codec(
    code = CodecCode(value = "roq_dpcm"),
    description = "DPCM id RoQ",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "s302m" to Codec(
    code = CodecCode(value = "s302m"),
    description = "SMPTE 302M",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sbc" to Codec(
    code = CodecCode(value = "sbc"),
    description = "SBC (low-complexity subband codec)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "sdx2_dpcm" to Codec(
    code = CodecCode(value = "sdx2_dpcm"),
    description = "DPCM Squareroot-Delta-Exact",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "shorten" to Codec(
    code = CodecCode(value = "shorten"),
    description = "Shorten",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "sipr" to Codec(
    code = CodecCode(value = "sipr"),
    description = "RealAudio SIPR / ACELP.NET",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "smackaudio" to Codec(
    code = CodecCode(value = "smackaudio"),
    description = "Smacker audio (decoders: smackaud )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "smv" to Codec(
    code = CodecCode(value = "smv"),
    description = "SMV (Selectable Mode Vocoder)",
    canDecode = false,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "sol_dpcm" to Codec(
    code = CodecCode(value = "sol_dpcm"),
    description = "DPCM Sol",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "sonic" to Codec(
    code = CodecCode(value = "sonic"),
    description = "Sonic",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "sonicls" to Codec(
    code = CodecCode(value = "sonicls"),
    description = "Sonic lossless",
    canDecode = false,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "speex" to Codec(
    code = CodecCode(value = "speex"),
    description = "Speex (decoders: libspeex ) (encoders: libspeex )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tak" to Codec(
    code = CodecCode(value = "tak"),
    description = "TAK (Tom's lossless Audio Kompressor)",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "truehd" to Codec(
    code = CodecCode(value = "truehd"),
    description = "TrueHD",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "truespeech" to Codec(
    code = CodecCode(value = "truespeech"),
    description = "DSP Group TrueSpeech",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "tta" to Codec(
    code = CodecCode(value = "tta"),
    description = "TTA (True Audio)",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = true,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "twinvq" to Codec(
    code = CodecCode(value = "twinvq"),
    description = "VQF TwinVQ",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vmdaudio" to Codec(
    code = CodecCode(value = "vmdaudio"),
    description = "Sierra VMD audio",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "vorbis" to Codec(
    code = CodecCode(value = "vorbis"),
    description = "Vorbis (decoders: vorbis libvorbis ) (encoders: vorbis libvorbis )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wavesynth" to Codec(
    code = CodecCode(value = "wavesynth"),
    description = "Wave synthesis pseudo-codec",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "wavpack" to Codec(
    code = CodecCode(value = "wavpack"),
    description = "WavPack",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = true,
    canCompressLossy = true,
    canCompressLossless = true
  ),
  "westwood_snd1" to Codec(
    code = CodecCode(value = "westwood_snd1"),
    description = "Westwood Audio (SND1) (decoders: ws_snd1 )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmalossless" to Codec(
    code = CodecCode(value = "wmalossless"),
    description = "Windows Media Audio Lossless",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = true
  ),
  "wmapro" to Codec(
    code = CodecCode(value = "wmapro"),
    description = "Windows Media Audio 9 Professional",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmav1" to Codec(
    code = CodecCode(value = "wmav1"),
    description = "Windows Media Audio 1",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmav2" to Codec(
    code = CodecCode(value = "wmav2"),
    description = "Windows Media Audio 2",
    canDecode = true,
    canEncode = true,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "wmavoice" to Codec(
    code = CodecCode(value = "wmavoice"),
    description = "Windows Media Audio Voice",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xan_dpcm" to Codec(
    code = CodecCode(value = "xan_dpcm"),
    description = "DPCM Xan",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xma1" to Codec(
    code = CodecCode(value = "xma1"),
    description = "Xbox Media Audio 1",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "xma2" to Codec(
    code = CodecCode(value = "xma2"),
    description = "Xbox Media Audio 2",
    canDecode = true,
    canEncode = false,
    type = CodecType.Audio,
    isIntraFrameOnly = false,
    canCompressLossy = true,
    canCompressLossless = false
  ),
  "bin_data" to Codec(
    code = CodecCode(value = "bin_data"),
    description = "binary data",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "dvd_nav_packet" to Codec(
    code = CodecCode(value = "dvd_nav_packet"),
    description = "DVD Nav packet",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "klv" to Codec(
    code = CodecCode(value = "klv"),
    description = "SMPTE 336M Key-Length-Value (KLV) metadata",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "otf" to Codec(
    code = CodecCode(value = "otf"),
    description = "OpenType font",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "scte_35" to Codec(
    code = CodecCode(value = "scte_35"),
    description = "SCTE 35 Message Queue",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "timed_id3" to Codec(
    code = CodecCode(value = "timed_id3"),
    description = "timed ID3 metadata",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "ttf" to Codec(
    code = CodecCode(value = "ttf"),
    description = "TrueType font",
    canDecode = false,
    canEncode = false,
    type = CodecType.Data,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "arib_caption" to Codec(
    code = CodecCode(value = "arib_caption"),
    description = "ARIB STD-B24 caption",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "ass" to Codec(
    code = CodecCode(value = "ass"),
    description = "ASS (Advanced SSA) subtitle (decoders: ssa ass ) (encoders: ssa ass )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "dvb_subtitle" to Codec(
    code = CodecCode(value = "dvb_subtitle"),
    description = "DVB subtitles (decoders: dvbsub ) (encoders: dvbsub )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "dvb_teletext" to Codec(
    code = CodecCode(value = "dvb_teletext"),
    description = "DVB teletext",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "dvd_subtitle" to Codec(
    code = CodecCode(value = "dvd_subtitle"),
    description = "DVD subtitles (decoders: dvdsub ) (encoders: dvdsub )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "eia_608" to Codec(
    code = CodecCode(value = "eia_608"),
    description = "EIA-608 closed captions (decoders: cc_dec )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "hdmv_pgs_subtitle" to Codec(
    code = CodecCode(value = "hdmv_pgs_subtitle"),
    description = "HDMV Presentation Graphic Stream subtitles (decoders: pgssub )",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "hdmv_text_subtitle" to Codec(
    code = CodecCode(value = "hdmv_text_subtitle"),
    description = "HDMV Text subtitle",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "jacosub" to Codec(
    code = CodecCode(value = "jacosub"),
    description = "JACOsub subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "microdvd" to Codec(
    code = CodecCode(value = "microdvd"),
    description = "MicroDVD subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "mov_text" to Codec(
    code = CodecCode(value = "mov_text"),
    description = "MOV text",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "mpl2" to Codec(
    code = CodecCode(value = "mpl2"),
    description = "MPL2 subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "pjs" to Codec(
    code = CodecCode(value = "pjs"),
    description = "PJS (Phoenix Japanimation Society) subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "realtext" to Codec(
    code = CodecCode(value = "realtext"),
    description = "RealText subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "sami" to Codec(
    code = CodecCode(value = "sami"),
    description = "SAMI subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "srt" to Codec(
    code = CodecCode(value = "srt"),
    description = "SubRip subtitle with embedded timing",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "ssa" to Codec(
    code = CodecCode(value = "ssa"),
    description = "SSA (SubStation Alpha) subtitle",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "stl" to Codec(
    code = CodecCode(value = "stl"),
    description = "Spruce subtitle format",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "subrip" to Codec(
    code = CodecCode(value = "subrip"),
    description = "SubRip subtitle (decoders: srt subrip ) (encoders: srt subrip )",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "subviewer" to Codec(
    code = CodecCode(value = "subviewer"),
    description = "SubViewer subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "subviewer1" to Codec(
    code = CodecCode(value = "subviewer1"),
    description = "SubViewer v1 subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "text" to Codec(
    code = CodecCode(value = "text"),
    description = "raw UTF-8 text",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "ttml" to Codec(
    code = CodecCode(value = "ttml"),
    description = "Timed Text Markup Language",
    canDecode = false,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "vplayer" to Codec(
    code = CodecCode(value = "vplayer"),
    description = "VPlayer subtitle",
    canDecode = true,
    canEncode = false,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "webvtt" to Codec(
    code = CodecCode(value = "webvtt"),
    description = "WebVTT subtitle",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  ),
  "xsub" to Codec(
    code = CodecCode(value = "xsub"),
    description = "XSUB",
    canDecode = true,
    canEncode = true,
    type = CodecType.Subtitle,
    isIntraFrameOnly = false,
    canCompressLossy = false,
    canCompressLossless = false
  )
)
