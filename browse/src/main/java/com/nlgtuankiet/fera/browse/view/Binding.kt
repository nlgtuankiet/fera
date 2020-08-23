package com.nlgtuankiet.fera.browse.view

import android.content.Context
import android.widget.ImageView
import androidx.core.view.isGone
import com.nlgtuankiet.fera.browse.R
import com.nlgtuankiet.fera.core.image.RequestOption
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.imageLoad
import com.nlgtuankiet.fera.core.image.requestOption
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.domain.entity.MediaFile
import com.nlgtuankiet.fera.domain.entity.MediaType

fun MediaFile.imageSource(): Any {
  return if (type == MediaType.Audio) {
    R.drawable.browse_outline_audiotrack_purple_24
  } else {
    path.value
  }
}

fun MediaFile.imageOption(): RequestOption? {
  return if (type == MediaType.Audio) {
    requestOption {
      scaleType = ScaleType.CenterInside
    }
  } else {
    null
  }
}

fun MediaFile.imageBackgroundColor(context: Context): Int {
  return if (type == MediaType.Audio) {
    context.colorOf(R.color.browse_grey_100)
  } else {
    0
  }
}

fun MediaFile.playVisible(): Boolean {
  return type == MediaType.Video
}

fun MediaFile.bindTo(imageView: ImageView, playIcon: ImageView) {
  imageView.setBackgroundColor(imageBackgroundColor(imageView.context))
  imageView.imageLoad(source = imageSource(), option = imageOption())
  playIcon.isGone = !playVisible()
}