package com.nlgtuankiet.fera.home.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.nlgtuankiet.fera.core.image.ColorFilterTransformer
import com.nlgtuankiet.fera.core.image.RoundedCornersTransformer
import com.nlgtuankiet.fera.core.image.ScaleType
import com.nlgtuankiet.fera.core.image.imageLoad
import com.nlgtuankiet.fera.core.ktx.bind
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.core.ktx.inflate
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.home.R

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class SquareMediaView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : ConstraintLayout(context, attributeSet) {

  private val content by bind<ImageView>(R.id.content)
  private val moreOverlay by bind<TextView>(R.id.more_overlay)

  init {
    inflate(R.layout.home_square_media_view)
  }

  data class ImageData(
    val resource: String,
    val whiteOverlay: Boolean
  )

  @ModelProp
  fun setImageData(data: ImageData) {
    content.imageLoad(data.resource) {
      scaleType = ScaleType.CenterCrop
      // TODO ui 12dp?
      addTransformer(RoundedCornersTransformer(roundingRadius = content.context.pxOf(8)))
      if (data.whiteOverlay) {
        addTransformer(
          ColorFilterTransformer(color = context.colorOf(R.color.home_square_media_more_overlay))
        )
      }
    }
  }

  @TextProp
  fun setMoreText(value: CharSequence) {
    moreOverlay.isGone = value.isBlank()
    if (value.isNotBlank()) {
      moreOverlay.text = value
    }
  }

  @CallbackProp
  override fun setOnClickListener(l: OnClickListener?) {
    super.setOnClickListener(l)
  }
}