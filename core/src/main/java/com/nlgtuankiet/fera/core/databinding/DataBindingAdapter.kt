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
    "source",
    "placeholder"
  ],
  requireAll = false
)
fun setSource(imageView: ImageView, source: Any, @DrawableRes placeholder: Int?) {
  imageView.imageLoad(source = source) {
    if (placeholder != null && placeholder != 0) {
      this.placeholder = placeholder
    }
  }
}
