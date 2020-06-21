package com.nlgtuankiet.fera.browse

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.nlgtuankiet.fera.core.image.ColorFilterTransformer
import com.nlgtuankiet.fera.core.image.RoundedCornersTransformer
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.imageLoad
import com.nlgtuankiet.fera.core.pxOf

//@BindingAdapter("resource", "whiteOverlay")
//fun mediaImage(imageView: ImageView, resource: String, whiteOverlay: Boolean) {
//  imageView.imageLoad(resource) {
//    scaleType = ScaleType.CenterCrop
//    // TODO ui 12dp?
//    addTransformer(RoundedCornersTransformer(roundingRadius = imageView.context.pxOf(8)))
//    if (whiteOverlay) {
//      addTransformer(ColorFilterTransformer(color = ContextCompat.getColor(imageView.context, R.color.home_square_media_more_overlay)))
//    }
//  }
//}