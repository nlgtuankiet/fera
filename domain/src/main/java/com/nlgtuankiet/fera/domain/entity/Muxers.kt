package com.nlgtuankiet.fera.domain.entity

val Muxers = listOf(
  Muxer(
    code = MuxerCode(value = "3g2"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "3g2"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h263"),
    defaultAudioCodec = codecCodeOf(value = "amr_nb"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "3gp"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "3gp"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h263"),
    defaultAudioCodec = codecCodeOf(value = "amr_nb"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "a64"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "a64"),
    ),
    defaultVideoCodec = codecCodeOf(value = "a64_multi"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ac3"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ac3"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "ac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "adts"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "aac"),
      extensionOf(value = "adts"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "adx"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "adx"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "adpcm_adx"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "aiff"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "aif"),
      extensionOf(value = "aiff"),
      extensionOf(value = "afc"),
      extensionOf(value = "aifc"),
    ),
    defaultVideoCodec = codecCodeOf(value = "png"),
    defaultAudioCodec = codecCodeOf(value = "pcm_s16be"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "alaw"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "al"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_alaw"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "amr"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "amr"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "amr_nb"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "apng"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "apng"),
    ),
    defaultVideoCodec = codecCodeOf(value = "apng"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "aptx"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "aptx"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "aptx"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "aptx_hd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "aptxhd"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "aptx_hd"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "asf"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "asf"),
      extensionOf(value = "wmv"),
      extensionOf(value = "wma"),
    ),
    defaultVideoCodec = codecCodeOf(value = "msmpeg4v3"),
    defaultAudioCodec = codecCodeOf(value = "wmav2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "asf_stream"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "asf"),
      extensionOf(value = "wmv"),
      extensionOf(value = "wma"),
    ),
    defaultVideoCodec = codecCodeOf(value = "msmpeg4v3"),
    defaultAudioCodec = codecCodeOf(value = "wmav2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ass"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ass"),
      extensionOf(value = "ssa"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "ass"),
  ),
  Muxer(
    code = MuxerCode(value = "ast"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ast"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16be_planar"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "au"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "au"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16be"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "avi"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "avi"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "ac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "avs2"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "avs"),
      extensionOf(value = "avs2"),
    ),
    defaultVideoCodec = codecCodeOf(value = "avs2"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "bit"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "bit"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "g729"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "caf"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "caf"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16be"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "cavsvideo"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "cavs"),
    ),
    defaultVideoCodec = codecCodeOf(value = "cavs"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "codec2"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "c2"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "codec2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dash"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mpd"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h264"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "daud"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "302"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s24daud"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dirac"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "drc"),
      extensionOf(value = "vc2"),
    ),
    defaultVideoCodec = codecCodeOf(value = "dirac"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dnxhd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "dnxhd"),
      extensionOf(value = "dnxhr"),
    ),
    defaultVideoCodec = codecCodeOf(value = "dnxhd"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dts"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "dts"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "dts"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "dv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "dvvideo"),
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "dvd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "dvd"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "eac3"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "eac3"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "eac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ffmetadata"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ffmeta"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "film_cpk"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "cpk"),
    ),
    defaultVideoCodec = codecCodeOf(value = "cinepak"),
    defaultAudioCodec = codecCodeOf(value = "pcm_s16be_planar"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "filmstrip"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "flm"),
    ),
    defaultVideoCodec = codecCodeOf(value = "rawvideo"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "fits"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "fits"),
    ),
    defaultVideoCodec = codecCodeOf(value = "fits"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "flac"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "flac"),
    ),
    defaultVideoCodec = codecCodeOf(value = "png"),
    defaultAudioCodec = codecCodeOf(value = "flac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "flv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "flv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "flv1"),
    defaultAudioCodec = codecCodeOf(value = "adpcm_swf"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "g722"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "g722"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "adpcm_g722"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "g723_1"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "tco"),
      extensionOf(value = "rco"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "g723_1"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "gif"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "gif"),
    ),
    defaultVideoCodec = codecCodeOf(value = "gif"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "gsm"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "gsm"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "gsm"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "gxf"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "gxf"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "h261"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "h261"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h261"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "h263"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "h263"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h263"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "h264"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "h264"),
      extensionOf(value = "264"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h264"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "hevc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "hevc"),
      extensionOf(value = "h265"),
      extensionOf(value = "265"),
    ),
    defaultVideoCodec = codecCodeOf(value = "hevc"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "hls"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "m3u8"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h264"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = codecCodeOf(value = "webvtt"),
  ),
  Muxer(
    code = MuxerCode(value = "ico"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ico"),
    ),
    defaultVideoCodec = codecCodeOf(value = "bmp"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ilbc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "lbc"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "ilbc"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "image2"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "bmp"),
      extensionOf(value = "dpx"),
      extensionOf(value = "jls"),
      extensionOf(value = "jpeg"),
      extensionOf(value = "jpg"),
      extensionOf(value = "ljpg"),
      extensionOf(value = "pam"),
      extensionOf(value = "pbm"),
      extensionOf(value = "pcx"),
      extensionOf(value = "pgm"),
      extensionOf(value = "pgmyuv"),
      extensionOf(value = "png"),
      extensionOf(value = "ppm"),
      extensionOf(value = "sgi"),
      extensionOf(value = "tga"),
      extensionOf(value = "tif"),
      extensionOf(value = "tiff"),
      extensionOf(value = "jp2"),
      extensionOf(value = "j2c"),
      extensionOf(value = "j2k"),
      extensionOf(value = "xwd"),
      extensionOf(value = "sun"),
      extensionOf(value = "ras"),
      extensionOf(value = "rs"),
      extensionOf(value = "im1"),
      extensionOf(value = "im8"),
      extensionOf(value = "im24"),
      extensionOf(value = "sunras"),
      extensionOf(value = "xbm"),
      extensionOf(value = "xface"),
      extensionOf(value = "pix"),
      extensionOf(value = "y"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mjpeg"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ipod"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "m4v"),
      extensionOf(value = "m4a"),
      extensionOf(value = "m4b"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h264"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ircam"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sf"),
      extensionOf(value = "ircam"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ismv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ismv"),
      extensionOf(value = "isma"),
    ),
    defaultVideoCodec = codecCodeOf(value = "h264"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ivf"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ivf"),
    ),
    defaultVideoCodec = codecCodeOf(value = "vp8"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "jacosub"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "jss"),
      extensionOf(value = "js"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "jacosub"),
  ),
  Muxer(
    code = MuxerCode(value = "latm"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "latm"),
      extensionOf(value = "loas"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "lrc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "lrc"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "subrip"),
  ),
  Muxer(
    code = MuxerCode(value = "m4v"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "m4v"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "matroska"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mkv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "ac3"),
    defaultSubtitleCodec = codecCodeOf(value = "ass"),
  ),
  Muxer(
    code = MuxerCode(value = "microdvd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sub"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "microdvd"),
  ),
  Muxer(
    code = MuxerCode(value = "mjpeg"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mjpg"),
      extensionOf(value = "mjpeg"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mjpeg"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mlp"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mlp"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "mlp"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mov"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mov"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mp2"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mp2"),
      extensionOf(value = "m2a"),
      extensionOf(value = "mpa"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mp3"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mp3"),
    ),
    defaultVideoCodec = codecCodeOf(value = "png"),
    defaultAudioCodec = codecCodeOf(value = "mp3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mp4"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mp4"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mpeg"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mpg"),
      extensionOf(value = "mpeg"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg1video"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mpeg1video"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mpg"),
      extensionOf(value = "mpeg"),
      extensionOf(value = "m1v"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg1video"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mpeg2video"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "m2v"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mpegts"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ts"),
      extensionOf(value = "m2t"),
      extensionOf(value = "m2ts"),
      extensionOf(value = "mts"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mpjpeg"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mjpg"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mjpeg"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "mulaw"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ul"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_mulaw"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "nut"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "nut"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "oga"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "oga"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "flac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "ogv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ogv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "vp8"),
    defaultAudioCodec = codecCodeOf(value = "flac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "oma"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "oma"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "atrac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "opus"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "opus"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "opus"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "psp"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "mp4"),
      extensionOf(value = "psp"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg4"),
    defaultAudioCodec = codecCodeOf(value = "aac"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "rawvideo"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "yuv"),
      extensionOf(value = "rgb"),
    ),
    defaultVideoCodec = codecCodeOf(value = "rawvideo"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "roq"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "roq"),
    ),
    defaultVideoCodec = codecCodeOf(value = "roq"),
    defaultAudioCodec = codecCodeOf(value = "roq_dpcm"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "rso"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "rso"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_u8"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "s16le"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sw"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "s8"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sb"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s8"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "sbc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sbc"),
      extensionOf(value = "msbc"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "sbc"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "scc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "scc"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "eia_608"),
  ),
  Muxer(
    code = MuxerCode(value = "sox"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "sox"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s32le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "spdif"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "spdif"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "ac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "spx"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "spx"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "speex"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "svcd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "vob"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "truehd"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "thd"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "truehd"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "tta"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "tta"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "tta"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "u16le"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "uw"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_u16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "u8"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "ub"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_u8"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "vc1"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "vc1"),
    ),
    defaultVideoCodec = codecCodeOf(value = "vc1"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "vc1test"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "rcv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "wmv3"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "vob"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "vob"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "mp2"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "voc"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "voc"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "w64"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "w64"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "wav"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "wav"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "pcm_s16le"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "webm"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "webm"),
    ),
    defaultVideoCodec = codecCodeOf(value = "vp8"),
    defaultAudioCodec = codecCodeOf(value = "vorbis"),
    defaultSubtitleCodec = codecCodeOf(value = "webvtt"),
  ),
  Muxer(
    code = MuxerCode(value = "webm_chunk"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "chk"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "webp"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "webp"),
    ),
    defaultVideoCodec = codecCodeOf(value = "webp"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "webvtt"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "vtt"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = null,
    defaultSubtitleCodec = codecCodeOf(value = "webvtt"),
  ),
  Muxer(
    code = MuxerCode(value = "wtv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "wtv"),
    ),
    defaultVideoCodec = codecCodeOf(value = "mpeg2video"),
    defaultAudioCodec = codecCodeOf(value = "ac3"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "wv"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "wv"),
    ),
    defaultVideoCodec = null,
    defaultAudioCodec = codecCodeOf(value = "wavpack"),
    defaultSubtitleCodec = null,
  ),
  Muxer(
    code = MuxerCode(value = "yuv4mpegpipe"),
    canMuxing = true,
    canDemuxing = false,
    commonExtension = setOf(
      extensionOf(value = "y4m"),
    ),
    defaultVideoCodec = codecCodeOf(value = "wrapped_avframe"),
    defaultAudioCodec = null,
    defaultSubtitleCodec = null,
  ),
)
