package com.nlgtuankiet.fera.initializer

import android.os.StrictMode
import com.nlgtuankiet.fera.BuildConfig
import com.nlgtuankiet.fera.domain.Log
import java.lang.reflect.Field
import java.lang.reflect.Modifier

fun setupStrictMode() {
  if (!BuildConfig.DEBUG) {
    return
  }

  val threadPolicy = StrictMode.ThreadPolicy.Builder().apply {
    detectAll()
    penaltyLog()
    penaltyDeath()
  }.build()
  StrictMode.setThreadPolicy(threadPolicy)

  val vmPolicy = StrictMode.VmPolicy.Builder().apply {
    detectAll()
    penaltyLog()
    penaltyDeath()
  }.build()

  StrictMode.setVmPolicy(vmPolicy)
  addWhitelistStrictMode()
}

@Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
fun addWhitelistStrictMode() {
  val whitelists = listOf(

    // This violation is related to Dex Loading optimization on Snapdragon devices.
    "android.util.BoostFramework.<init>",

    // TODO not sure what is the reason for this?
    "android.content.Context.getDrawable",
    "android.graphics.",
    "com.samsung.android.knox.",
    "android.content.res.TypedArray.getDrawable",
    // https://bumptech.github.io/glide/doc/placeholders.html#are-placeholders-loaded-asynchronously
    "com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat.getDrawable",
  )

  fun getStacktraceOf(element: Object): String {
    return element::class.java.getDeclaredMethod("getStackTrace").invoke(element) as String
  }

  class StrictModeHackArrayList : ArrayList<Object>() {
    override fun add(element: Object): Boolean {
      val stacktrace = runCatching { getStacktraceOf(element) }.getOrNull() ?: return false
      for (whitelisted in whitelists) {
        if (stacktrace.contains(whitelisted)) {
          Log.w("Skipping whitelisted StrictMode violation: $whitelisted")
          return false
        }
      }
      // call super to continue with standard violation reporting
      return super.add(element)
    }
  }

  // add whitelist
  val field = StrictMode::class.java.getDeclaredField("violationsBeingTimed")
  field.isAccessible = true // Suppress Java language access checking
  // Remove "final" modifier
  val modifiersField = Field::class.java.getDeclaredField("accessFlags")
  modifiersField.isAccessible = true
  modifiersField.setInt(field, field.modifiers and Modifier.FINAL.inv())
  field.set(
    null,
    object : ThreadLocal<ArrayList<out Object>>() {
      override fun get(): ArrayList<out Object> {
        return StrictModeHackArrayList()
      }
    }
  )
}
