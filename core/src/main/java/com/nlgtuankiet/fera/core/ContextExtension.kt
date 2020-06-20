package com.nlgtuankiet.fera.core

import android.content.Context
import android.util.TypedValue
import androidx.annotation.Dimension

fun Context.pxOf(@Dimension(unit = Dimension.DP) value: Int): Int {
  return TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    value.toFloat(),
    resources.displayMetrics
  ).toInt().also {
    println("$value dp is $it px")
  }
}