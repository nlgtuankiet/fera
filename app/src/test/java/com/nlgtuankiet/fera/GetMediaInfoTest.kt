package com.nlgtuankiet.fera

import com.nlgtuankiet.fera.share.testComponent
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetMediaInfoTest {
  private val getMediaInfo = testComponent().getMediaInfo()

  @Test
  fun `invoke correct`() = runBlocking {
  }
}
