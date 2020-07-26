package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.AsyncEpoxyController
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.OnViewRecycled
import com.airbnb.epoxy.SimpleEpoxyController
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2
import com.nlgtuankiet.fera.core.epoxy.OnUnbindHandler
import com.nlgtuankiet.fera.core.epoxy.ViewBaseModel
import com.nlgtuankiet.fera.core.ktx.bind

@ModelView(
  defaultLayout = R2.layout.core_card_epoxy_recycler_view,
  baseModelClass = ViewBaseModel::class
)
// TODO find a way to do async diff
class CardEpoxyRecyclerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
): MaterialCardView(context, attributeSet), OnUnbindHandler {

  private class SimpleAsyncEpoxyController : AsyncEpoxyController() {

    private lateinit var models: List<EpoxyModel<*>>

    fun setModels(models: List<EpoxyModel<*>>) {
      this.models = models
      requestModelBuild()
    }

    override fun buildModels() {
      add(models)
    }
  }

  private val controller = SimpleAsyncEpoxyController()

  private val epoxyRecyclerView: EpoxyRecyclerView by bind(R.id.epoxy_recycler_view)
  private var setup = false

  @ModelProp
  fun setModels(models: List<EpoxyModel<*>>) {
    println("setModels size: ${models.size}")
//    if (!setup) {
//      setup = true
//      epoxyRecyclerView.setController(controller)
//    }
    epoxyRecyclerView.setModels(models)
  }

  override fun onUnbind(view: View) {
    println("onUnbind invoked")
    epoxyRecyclerView.clear()
//    setup = false
  }
}