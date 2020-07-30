package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel
import com.nlgtuankiet.fera.core.ktx.bind

@ModelView(defaultLayout = R2.layout.core_double_text_view, baseModelClass = ViewBaseModel::class)
class DoubleTextView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
): ConstraintLayout(context, attributeSet) {
  private val leftTextView: TextView by bind(R.id.left_text_view)
  private val rightTextView: TextView by bind(R.id.right_text_view)

  @ModelProp
  fun setLeftText(value: CharSequence) {
    leftTextView.text = value
  }

  @ModelProp
  fun setRightText(value: CharSequence) {
    rightTextView.text = value
  }
}