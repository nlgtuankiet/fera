package com.nlgtuankiet.fera.browse.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.doOnLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.browse.R
import com.nlgtuankiet.fera.core.ktx.bind
import com.nlgtuankiet.fera.core.ktx.colorOf
import com.nlgtuankiet.fera.core.ktx.inflate
import com.nlgtuankiet.fera.core.ktx.pxOf
import com.nlgtuankiet.fera.domain.entity.MediaFile

@ModelView(autoLayout = ModelView.Size.WRAP_WIDTH_WRAP_HEIGHT)
class SingleMediaGroupView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : MaterialCardView(context, attributeSet) {

  private val leftImage by bind<ImageView>(R.id.left_image)
  private val leftPlay by bind<ImageView>(R.id.left_play)
  private val type by bind<TextView>(R.id.type)

  private val nameAndCount by bind<LeftEllipsizePairTextView>(R.id.name_and_count)

  init {
    inflate(R.layout.browse_single_media_group_view)
    doOnLayout {
      radius = context.pxOf(8).toFloat()
      cardElevation = 0f
      strokeColor = context.colorOf(R.color.media_group_stroke_color)
      strokeWidth = context.pxOf(1)
    }
  }

  @ModelProp
  fun setMediaFile(file: MediaFile) {
    file.bindTo(leftImage, leftPlay)
  }

  @TextProp
  fun setType(value: CharSequence) {
    type.text = value
  }

  @TextProp
  fun setLeftText(value: CharSequence) {
    nameAndCount.setLeftText(value)
  }

  @TextProp
  fun setRightText(value: CharSequence) {
    nameAndCount.setRightText(value)
  }

  @CallbackProp
  override fun setOnClickListener(l: OnClickListener?) {
    super.setOnClickListener(l)
  }

}