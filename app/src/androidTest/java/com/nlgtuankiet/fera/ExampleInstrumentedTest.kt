package com.nlgtuankiet.fera

import android.Manifest
import android.os.Environment
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.nlgtuankiet.fera.data.ffmpeg.runCommand
import com.nlgtuankiet.fera.share.testComponent
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.File

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

  private val getMediaInfo = testComponent().getMediaInfo()

  @get:Rule
  public var mRuntimePermissionRule: GrantPermissionRule =
    GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE)

  @get:Rule
  public var mRuntimePermissionRule2: GrantPermissionRule =
    GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE)

  @Test
  fun useAppContext() = runBlocking {
    val filePath = getFilePath("bunny_720.mp4")
    println(filePath)
    val result = getMediaInfo.invoke(filePath)
    println(result)
  }

  private fun getFilePath(name: String): String {
    return File("${Environment.getExternalStorageDirectory()}/fera_test_resources/$name")
      .absolutePath
  }



}