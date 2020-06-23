package com.nlgtuankiet.fera.core.image

import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.Px
import com.nlgtuankiet.fera.core.R

val DefaultRequestOption = RequestOption()

enum class ScaleType {
  CenterCrop,
  CenterInside,
  FitCenter,
  CircleCrop,
}

data class RequestOption(
  @DrawableRes
  var placeholder: Int? = R.drawable.ic_placeholder,
  @DrawableRes
  var errorHolder: Int? = R.drawable.ic_load_image_failed,
  var scaleType: ScaleType = ScaleType.CenterCrop,
  var internalTransformers: List<Transformer>? = null,
) {

  fun addTransformer(transformer: Transformer) {
    if (internalTransformers == null) {
      internalTransformers = emptyList()
    }
    internalTransformers = internalTransformers?.plus(transformer)
  }
}

interface ImageLoader {
  fun load(imageView: ImageView, source: Any, requestOption: RequestOption)
}

private lateinit var imageLoader: ImageLoader

fun setImageLoader(loader: ImageLoader) {
  imageLoader = loader
}

fun ImageView.imageLoad(
  source: Any,
  requestOptionApplier: (RequestOption.() -> Unit)? = null
) {
  val option = if (requestOptionApplier == null) {
    DefaultRequestOption
  } else {
    RequestOption().apply(requestOptionApplier)
  }
  imageLoader.load(this, source, option)
}

sealed class Transformer

class RoundedCornersTransformer(
  @Px val roundingRadius: Int
) : Transformer()

class ColorFilterTransformer(
  @ColorInt val color: Int
) : Transformer()
