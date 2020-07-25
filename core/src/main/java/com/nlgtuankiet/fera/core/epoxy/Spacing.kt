package com.nlgtuankiet.fera.core.epoxy

import android.content.Context
import androidx.annotation.Px
import com.nlgtuankiet.fera.core.ktx.pxOf

data class Spacing(
  val start: Int = 0,
  val top: Int = 0,
  val end: Int = 0,
  val bottom: Int = 0
)

fun spacingOf(@Px value: Int): Spacing = Spacing(
  start = value,
  top = value,
  end = value,
  bottom = value
)

fun spacingOf(
  context: Context,
  @Px start: Int,
  @Px top: Int,
  @Px end: Int,
  @Px bottom: Int
): Spacing {
  return Spacing(
    start = context.pxOf(start),
    top = context.pxOf(top),
    end = context.pxOf(end),
    bottom = context.pxOf(bottom),
  )
}


