package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.google.android.material.button.MaterialButton
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel

@ModelView(
  autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT,
  baseModelClass = ViewBaseModel::class
)
class Button @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : MaterialButton(context, attributeSet) {

  @ModelProp
  fun setContent(value: String) {
    text = value
  }
}
