package com.nlgtuankiet.fera.image

import android.content.Context
import android.widget.ImageView
import androidx.annotation.Keep
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.nlgtuankiet.fera.core.image.ImageLoader
import com.nlgtuankiet.fera.core.image.RequestOption
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.setImageLoader
import com.nlgtuankiet.fera.domain.Log
import com.nlgtuankiet.fera.image.transformer.ColorFilterTransformer

@Keep
@Suppress("unused")
class GlideInitializer : Function1<Context, Unit>, ImageLoader {
  lateinit var context: Context
  override fun invoke(context: Context) {
    GlideApp.get(context) // init glide and set instance
    setImageLoader(this)
  }

  override fun load(imageView: ImageView, source: Any, requestOption: RequestOption) {
    Log("load $source with $requestOption")
    GlideApp.with(imageView)
      .load(source)
      .apply {
        requestOption.placeholder?.let { placeholder(it) }
        requestOption.errorHolder?.let { error(it) }
        if (requestOption.internalTransformers.isNullOrEmpty()) {
          when (requestOption.scaleType) {
            ScaleType.CenterCrop -> centerCrop()
            ScaleType.CenterInside -> centerInside()
            ScaleType.FitCenter -> fitCenter()
            ScaleType.CircleCrop -> circleCrop()
          }
        } else {
          val scaleTransformer = when (requestOption.scaleType) {
            ScaleType.CenterCrop -> CenterCrop()
            ScaleType.CenterInside -> CenterInside()
            ScaleType.FitCenter -> FitCenter()
            ScaleType.CircleCrop -> CircleCrop()
            else -> null
          }
          val transformers = requestOption.internalTransformers.orEmpty().map {
            when (it) {
              is com.nlgtuankiet.fera.core.image.RoundedCornersTransformer -> {
                RoundedCorners(it.roundingRadius)
              }
              is com.nlgtuankiet.fera.core.image.ColorFilterTransformer -> {
                ColorFilterTransformer(it.color)
              }
            }
          }.toTypedArray()
          if (scaleTransformer != null) {
            transform(scaleTransformer, *transformers)
          } else {
            transform(*transformers)
          }

        }
      }
      .into(imageView)
  }
}
