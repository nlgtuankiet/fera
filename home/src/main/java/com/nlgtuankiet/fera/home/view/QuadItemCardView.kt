package com.nlgtuankiet.fera.home.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.core.view.updateMargins
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.core.ktx.bind
import com.nlgtuankiet.fera.core.ktx.inflate
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.home.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class QuadItemCardView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : MaterialCardView(context, attributeSet) {

  private val title by bind<TextView>(R.id.title)
  private val items by bind<Carousel>(R.id.items) {
    it.numViewsToShowOnScreen = 4f
    it.setPaddingDp(4)
  }
  private val action by bind<View>(R.id.action)

  init {
    inflate(R.layout.home_quad_item_card_view)
    doOnLayout {
      updateLayoutParams<MarginLayoutParams> {
        updateMargins(
          left = context.pxOf(8),
          top = context.pxOf(4),
          right = context.pxOf(8),
          bottom = context.pxOf(4),
        )
      }
      radius = context.pxOf(8).toFloat()
      cardElevation = context.pxOf(4).toFloat()
    }
  }

  @TextProp
  fun setTitle(value: CharSequence) {
    title.text = value
  }

  @ModelProp
  fun setItems(value: List<EpoxyModel<*>>) {
    items.setModels(value)
  }

  @CallbackProp
  fun setOnViewMoreClickListener(l: View.OnClickListener?) {
    action.setOnClickListener(l)
  }
}
