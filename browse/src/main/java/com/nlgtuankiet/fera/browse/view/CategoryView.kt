package com.nlgtuankiet.fera.browse.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updatePadding
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.nlgtuankiet.fera.browse.R
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.imageLoad
import com.nlgtuankiet.fera.core.ktx.bind
import com.nlgtuankiet.fera.core.ktx.inflate
import com.nlgtuankiet.fera.core.ktx.pxOf

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CategoryView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
): ConstraintLayout(context, attributeSet) {
  private val icon by bind<ImageView>(R.id.icon)
  private val title by bind<TextView>(R.id.title)

  init {
    inflate(R.layout.browse_category_view)
    val padding = context.pxOf(16)
    updatePadding(padding, padding, padding, padding)
  }

  @TextProp
  fun setTitle(value: CharSequence) {
    title.text = value
  }

  @ModelProp
  fun setIcon(value: Int) {
    icon.imageLoad(value) {
      scaleType = ScaleType.FitCenter
    }
  }

  @CallbackProp
  override fun setOnClickListener(l: OnClickListener?) {
    super.setOnClickListener(l)
  }
}