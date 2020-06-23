package com.nlgtuankiet.fera.core.ktx

import android.content.Context
import android.util.TypedValue
import android.view.ContextThemeWrapper
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import androidx.annotation.StyleRes
import androidx.core.content.ContextCompat

fun Context.wrap(@StyleRes style: Int): Context {
  return ContextThemeWrapper(this, style)
}

fun Context.pxOf(@Dimension(unit = Dimension.DP) value: Int): Int {
  return TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    value.toFloat(),
    resources.displayMetrics
  ).toInt().also {
    println("$value dp is $it px")
  }
}

fun Context.colorOf(@ColorRes value: Int): Int {
  return ContextCompat.getColor(this, value)
}
