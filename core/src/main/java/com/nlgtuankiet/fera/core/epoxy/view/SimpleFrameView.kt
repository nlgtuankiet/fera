package com.nlgtuankiet.fera.core.epoxy.view

import android.content.Context
import android.util.AttributeSet
import com.airbnb.epoxy.AfterPropsSet
import com.airbnb.epoxy.EpoxyRecyclerView
import com.airbnb.epoxy.ModelView
import com.google.android.material.card.MaterialCardView
import com.nlgtuankiet.fera.core.R
import com.nlgtuankiet.fera.core.R2

@ModelView(defaultLayout = R2.layout.core_simple_frame_view)
class SimpleFrameView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : MaterialCardView(context, attributeSet) {
  @AfterPropsSet
  fun setUp() {
    val epoxyRecyclerView = findViewById<EpoxyRecyclerView>(R.id.epoxy_recycler_view)
    epoxyRecyclerView.isLayoutFrozen = true
  }
}