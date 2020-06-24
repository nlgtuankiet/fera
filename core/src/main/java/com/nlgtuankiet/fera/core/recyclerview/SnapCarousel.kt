package com.nlgtuankiet.fera.core.recyclerview

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.core.R

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SnapCarousel @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : Carousel(context, attributeSet) {
  private var snapHelper: GravitySnapHelper? = null

  init {
    val ta = context.theme.obtainStyledAttributes(
      attributeSet,
      R.styleable.SnapCarousel,
      0,
      0
    )
    val snapGravity: Int
    var snapToEnd: Boolean = true
    try {
      snapGravity = when (ta.getInt(R.styleable.SnapCarousel_snapGravity, 0)) {
        0 -> Gravity.START
        1 -> Gravity.TOP
        2 -> Gravity.END
        3 -> Gravity.BOTTOM
        4 -> Gravity.CENTER
        else -> throw IllegalArgumentException(
          """Invalid gravity value. Use START | END | BOTTOM | TOP | CENTER constants"""
        )
      }
      snapToEnd = ta.getBoolean(R.styleable.SnapCarousel_snapLastItem, true)
    } finally {
      ta.recycle()
    }

    setSnapInternal(snapGravity)
    setSnapLastItem(snapToEnd)
  }

  override fun getSnapHelperFactory(): SnapHelperFactory? {
    return null
  }

  @ModelProp
  @JvmOverloads
  fun setSnapGravity(gravity: Int? = null) {
    setSnapInternal(gravity)
  }

  @ModelProp
  @JvmOverloads
  fun setSnapLastItem(snapLastItem: Boolean = true) {
    setSnapLastItemInternal(snapLastItem)
  }

  private fun setSnapLastItemInternal(snapLastItem: Boolean) {
    snapHelper?.enableSnapLastItem = snapLastItem
    snapHelper?.updateSnap(smooth = true, checkEdgeOfList = true)
  }

  private fun setSnapInternal(gravity: Int?) {
    if (gravity == null) {
      snapHelper?.attachToRecyclerView(null)
    } else {
      snapHelper?.attachToRecyclerView(null)
      snapHelper = GravitySnapHelper(gravity, true)
      snapHelper?.attachToRecyclerView(this)
    }
  }
}
