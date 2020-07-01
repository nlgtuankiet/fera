package com.nlgtuankiet.fera.core.view

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView

@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
open class BaseEpoxyRecyclerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : EpoxyRecyclerView(context, attributeSet) {

  override fun createLayoutManager(): LayoutManager {
    val layoutParams = layoutParams
    if (layoutParams.width == LayoutParams.MATCH_PARENT || layoutParams.width == 0) {
      setHasFixedSize(true)
    }
    return LinearLayoutManager(context)
  }

  @ModelProp
  override fun setModels(models: List<EpoxyModel<*>>) {
    super.setModels(models)
  }

  @CallbackProp
  override fun setOnClickListener(l: OnClickListener?) {
    super.setOnClickListener(l)
  }
}
