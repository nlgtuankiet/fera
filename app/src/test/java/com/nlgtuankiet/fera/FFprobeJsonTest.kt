package com.nlgtuankiet.fera

import com.nlgtuankiet.fera.data.ffmpeg.model.FFprobeFormatOutput
import com.nlgtuankiet.fera.share.moshi
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FFprobeJsonTest {

  private val moshi = moshi()

  @Test
  fun `parse json`() {
    val json =
      """
      {
          "streams": [
              {
                  "index": 0,
                  "codec_name": "h264",
                  "codec_long_name": "H.264 / AVC / MPEG-4 AVC / MPEG-4 part 10",
                  "profile": "Main",
                  "codec_type": "video",
                  "codec_time_base": "1/120",
                  "codec_tag_string": "avc1",
                  "codec_tag": "0x31637661",
                  "width": 1396,
                  "height": 1138,
                  "coded_width": 1408,
                  "coded_height": 1152,
                  "has_b_frames": 1,
                  "sample_aspect_ratio": "1:1",
                  "display_aspect_ratio": "698:569",
                  "pix_fmt": "yuv420p",
                  "level": 42,
                  "color_range": "tv",
                  "color_space": "bt709",
                  "color_transfer": "bt709",
                  "color_primaries": "bt709",
                  "chroma_location": "bottom",
                  "refs": 1,
                  "is_avc": "true",
                  "nal_length_size": "4",
                  "r_frame_rate": "60/1",
                  "avg_frame_rate": "60/1",
                  "time_base": "1/6000",
                  "start_pts": 0,
                  "start_time": "0.000000",
                  "duration_ts": 2900,
                  "duration": "0.483333",
                  "bit_rate": "5206991",
                  "bits_per_raw_sample": "8",
                  "nb_frames": "89",
                  "disposition": {
                      "default": 1,
                      "dub": 0,
                      "original": 0,
                      "comment": 0,
                      "lyrics": 0,
                      "karaoke": 0,
                      "forced": 0,
                      "hearing_impaired": 0,
                      "visual_impaired": 0,
                      "clean_effects": 0,
                      "attached_pic": 0,
                      "timed_thumbnails": 0
                  },
                  "tags": {
                      "creation_time": "2020-06-14T04:58:03.000000Z",
                      "language": "und",
                      "handler_name": "Core Media Video",
                      "encoder": "H.264"
                  }
              },
              {
                  "index": 1,
                  "codec_name": "aac",
                  "codec_long_name": "AAC (Advanced Audio Coding)",
                  "profile": "LC",
                  "codec_type": "audio",
                  "codec_time_base": "1/44100",
                  "codec_tag_string": "mp4a",
                  "codec_tag": "0x6134706d",
                  "sample_fmt": "fltp",
                  "sample_rate": "44100",
                  "channels": 1,
                  "channel_layout": "mono",
                  "bits_per_sample": 0,
                  "r_frame_rate": "0/0",
                  "avg_frame_rate": "0/0",
                  "time_base": "1/44100",
                  "start_pts": 0,
                  "start_time": "0.000000",
                  "duration_ts": 21315,
                  "duration": "0.483333",
                  "bit_rate": "119225",
                  "max_bit_rate": "128000",
                  "nb_frames": "59",
                  "disposition": {
                      "default": 1,
                      "dub": 0,
                      "original": 0,
                      "comment": 0,
                      "lyrics": 0,
                      "karaoke": 0,
                      "forced": 0,
                      "hearing_impaired": 0,
                      "visual_impaired": 0,
                      "clean_effects": 0,
                      "attached_pic": 0,
                      "timed_thumbnails": 0
                  },
                  "tags": {
                      "creation_time": "2020-06-14T04:58:03.000000Z",
                      "language": "und",
                      "handler_name": "Core Media Audio"
                  }
              }
          ],
          "format": {
              "filename": "/Users/lap00984/Desktop/Screen Recording 2020-06-14 at 11.58.01.mov",
              "nb_streams": 2,
              "nb_programs": 0,
              "format_name": "mov,mp4,m4a,3gp,3g2,mj2",
              "format_long_name": "QuickTime / MOV",
              "start_time": "0.000000",
              "duration": "0.483333",
              "size": "1008606",
              "bit_rate": "16694179",
              "probe_score": 100,
              "tags": {
                  "major_brand": "qt  ",
                  "minor_version": "0",
                  "compatible_brands": "qt  ",
                  "creation_time": "2020-06-14T04:58:03.000000Z",
                  "com.apple.quicktime.make": "Apple",
                  "com.apple.quicktime.model": "MacBookPro15,1",
                  "com.apple.quicktime.software": "Mac OS X 10.15.4 (19E287)",
                  "com.apple.quicktime.creationdate": "2020-06-14T11:58:01+0700"
              }
          }
      }
      """.trimIndent()
    val adapter = moshi.adapter(FFprobeFormatOutput::class.java)
    val result = adapter.fromJson(json)
    println(result)
  }
}
