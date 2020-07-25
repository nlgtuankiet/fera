package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel
import com.nlgtuankiet.fera.core.ktx.bind

@ModelView(defaultLayout = R2.layout.core_card_epoxy_recycler_view)
class CardEpoxyRecyclerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
): MaterialCardView(context, attributeSet) {
  private val epoxyRecyclerView: EpoxyRecyclerView by bind(R.id.epoxy_recycler_view)

  @ModelProp
  fun setModels(models: List<EpoxyModel<*>>) {
    // TODO how to fix wrong models?
    epoxyRecyclerView.clear()
    epoxyRecyclerView.setModels(models)
  }
}