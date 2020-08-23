package com.nlgtuankiet.fera.core.databinding

import android.view.View
import android.widget.ImageView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.nlgtuankiet.fera.core.image.RequestOption
import com.nlgtuankiet.fera.core.image.imageLoad

// @
// fun setModels(epoxyRecyclerView: EpoxyRecyclerView, models: List<EpoxyModel<*>>) {
//  epoxyRecyclerView.setModels(models)
// }

@BindingAdapter(value = ["source", "option"], requireAll = false)
fun setSource(imageView: ImageView, source: Any, option: RequestOption? = null) {
  imageView.imageLoad(source, option = option)
}

@BindingAdapter(value = ["isGone"])
fun isGone(view: View, isGone: Boolean) {
  view.isGone = isGone
}

@BindingAdapter(value = ["isVisible"])
fun isVisible(view: View, isVisible: Boolean) {
  view.isVisible = isVisible
}
