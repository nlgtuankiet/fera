package com.nlgtuankiet.fera.configure.view

import android.content.Context
import android.util.AttributeSet
import com.airbnb.epoxy.ModelView
import com.nlgtuankiet.fera.core.view.BaseEpoxyRecyclerView
@ModelView(saveViewState = true, autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class CardEpoxyRecyclerView @JvmOverloads constructor(
  context: Context,
  attributeSet: AttributeSet? = null
) : BaseEpoxyRecyclerView(context, attributeSet)
