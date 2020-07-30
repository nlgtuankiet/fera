package com.nlgtuankiet.fera.core.ktx

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.ContextThemeWrapper
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import androidx.annotation.DrawableRes
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

fun Context.drawableOf(@DrawableRes value: Int): Drawable {
  return ContextCompat.getDrawable(this, value).notNull()
}

fun Context.selectableItemBackground(): Drawable {
  val outValue = TypedValue()
  theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
  return drawableOf(outValue.resourceId)
}

inline fun <reified T> Context.requireService(): T {
  return requireNotNull(ContextCompat.getSystemService(this, T::class.java))
}
