package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2.layout.core_card_epoxy_recycler_view
import com.nlgtuankiet.fera.core.epoxy.OnUnbindHandler
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel
import com.nlgtuankiet.fera.core.ktx.bind

@ModelView(
  defaultLayout = core_card_epoxy_recycler_view,
  baseModelClass = ViewBaseModel::class
)
// TODO find a way to do async diff
// TODO ripple effect on click
class CardEpoxyRecyclerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : MaterialCardView(context, attributeSet), OnUnbindHandler {

  private val epoxyRecyclerView: EpoxyRecyclerView by bind(R.id.epoxy_recycler_view)

  @ModelProp
  fun setModels(models: List<EpoxyModel<*>>) {
    epoxyRecyclerView.setModels(models)
  }

  override fun onUnbind(view: View) {
    epoxyRecyclerView.clear()
  }
}