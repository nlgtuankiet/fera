package com.nlgtuankiet.fera.core.databinding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.nlgtuankiet.fera.core.image.imageLoad

// @
// fun setModels(epoxyRecyclerView: EpoxyRecyclerView, models: List<EpoxyModel<*>>) {
//  epoxyRecyclerView.setModels(models)
// }

@BindingAdapter(
  value = [
    "stringSource",
    "placeholder"
  ],
  requireAll = false
)
fun setImageSource(imageView: ImageView, stringSource: String, @DrawableRes placeholder: Int?) {
  imageView.imageLoad(resource = stringSource) {
    if (placeholder != null && placeholder != 0) {
      this.placeholder = placeholder
    }
  }
}
