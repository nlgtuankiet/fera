package com.nlgtuankiet.fera.browsetype.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.browsetype.R
import com.nlgtuankiet.fera.core.image.imageLoad
import com.nlgtuankiet.fera.core.ktx.bind
import com.nlgtuankiet.fera.core.ktx.inflate
import com.nlgtuankiet.fera.domain.entity.MediaFile

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class ImageMediaView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : ConstraintLayout(context, attributeSet) {
  private val image by bind<ImageView>(R.id.image)

  init {
    inflate(R.layout.browse_type_image_media_view)
  }

  @ModelProp
  fun setMediaFile(mediaFile: MediaFile) {
    image.imageLoad(mediaFile.path.value) {
    }
  }

  @CallbackProp
  override fun setOnClickListener(l: OnClickListener?) {
    super.setOnClickListener(l)
  }
}
