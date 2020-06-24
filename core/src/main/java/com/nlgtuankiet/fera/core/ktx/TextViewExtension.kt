package com.nlgtuankiet.fera.core.ktx

import android.widget.TextView
import androidx.annotation.StyleRes
import androidx.core.widget.TextViewCompat

@Suppress("NOTHING_TO_INLINE")
inline fun TextView.setTextAppearanceCompat(@StyleRes style: Int) {
  if (style != 0) {
    TextViewCompat.setTextAppearance(this, style)
  }
}
