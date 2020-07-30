package com.nlgtuankiet.fera.core.epoxy

import android.view.View
import android.view.ViewGroup
import androidx.core.view.updateLayoutParams
import androidx.core.view.updateMargins
import androidx.core.view.updatePadding
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel

abstract class ViewBaseModel<T : View> : EpoxyModel<T>() {
  @EpoxyAttribute
  var padding: Spacing? = null

  @EpoxyAttribute
  var margin: Spacing? = null

  @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
  var onClickListener: View.OnClickListener? = null

  override fun bind(view: T) {
    super.bind(view)
    setPadding(view)
    setMargin(view)
    setOnClickListener(view)
  }

  @Suppress("UNCHECKED_CAST")
  override fun bind(view: T, previouslyBoundModel: EpoxyModel<*>) {
    super.bind(view, previouslyBoundModel)
    val that: ViewBaseModel<T> = previouslyBoundModel as ViewBaseModel<T>
    if (padding != that.padding) {
      setPadding(view)
    }
    if (margin != that.margin) {
      setMargin(view)
    }
    setOnClickListener(view)
  }

  private fun setOnClickListener(view: T) {
    view.setOnClickListener(onClickListener)
  }

  private fun setMargin(view: T) {
    val newMargin = margin ?: Spacing()
    view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
      updateMargins(
        left = newMargin.start,
        top = newMargin.top,
        right = newMargin.end,
        bottom = newMargin.bottom
      )
    }
  }

  private fun setPadding(view: T) {
    val newPadding = padding ?: Spacing()
    view.updatePadding(
      left = newPadding.start,
      right = newPadding.end,
      top = newPadding.top,
      bottom = newPadding.bottom
    )
  }

  override fun unbind(view: T) {
    super.unbind(view)
    if (view is OnUnbindHandler) {
      view.onUnbind(view)
    }
  }
}