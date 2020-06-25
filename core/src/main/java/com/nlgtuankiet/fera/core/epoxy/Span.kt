package com.nlgtuankiet.fera.core.epoxy

import com.airbnb.epoxy.EpoxyModel

val FullSpan =
  EpoxyModel.SpanSizeOverrideCallback { totalSpanCount, _, _ -> totalSpanCount }
