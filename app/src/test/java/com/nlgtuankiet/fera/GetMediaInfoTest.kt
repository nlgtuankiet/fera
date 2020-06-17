package com.nlgtuankiet.fera

import com.nlgtuankiet.fera.share.testComponent
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetMediaInfoTest {
  private val getMediaInfo = testComponent().getMediaInfo()

  @Test
  fun `invoke correct`() = runBlocking {
    val result = getMediaInfo.invoke("/Users/lap00984/Desktop/Screen Recording 2020-06-14 at 11.58.01.mov")
    println(result)
  }
}
