package com.nlgtuankiet.fera.core.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.Px
import androidx.core.view.updateLayoutParams
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2

@ModelView(defaultLayout = R2.layout.horizontal_divider_view)
class HorizontalDividerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : FrameLayout(context, attributeSet) {

  private lateinit var divider: View

  override fun onFinishInflate() {
    super.onFinishInflate()
    divider = findViewById(R.id.divider)
  }

  @ModelProp
  @JvmOverloads
  fun setHeight(@Px px: Int = ViewGroup.LayoutParams.WRAP_CONTENT) {
    divider.updateLayoutParams<ViewGroup.LayoutParams> {
      height = px
    }
  }
}
