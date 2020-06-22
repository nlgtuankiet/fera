package com.nlgtuankiet.fera

import android.content.Context
import android.os.StrictMode
import com.nlgtuankiet.fera.domain.Log
import java.lang.reflect.Field
import java.lang.reflect.Modifier

fun initialize(context: Context) {
  setupStrictMode()
  initializeGlide(context)
}

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
    "android.graphics.",
  )

  fun getStacktraceOf(element: Object): String {
    return element::class.java.getDeclaredMethod("getStackTrace").invoke(element) as String
  }

  class StrictModeHackArrayList : ArrayList<Object>() {
    override fun add(element: Object): Boolean {
      val stacktrace = getStacktraceOf(element)
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

fun initializeGlide(context: Context) {
  Class.forName("com.nlgtuankiet.fera.image.GlideInitializer")
    .newInstance().let {
      @Suppress("UNCHECKED_CAST")
      it as Function1<Context, Unit>
    }
    .invoke(context)
}
