package com.nlgtuankiet.fera.image

import android.graphics.drawable.Drawable
import android.widget.ImageView

lateinit var imageView: ImageView

fun sample() {
  GlideApp.with(imageView)
    .load("")
    .placeholder(1)
    .centerCrop()
    .fitCenter()
    .circleCrop()
    .error(Drawable.createFromPath(""))
    .into(imageView)
}
