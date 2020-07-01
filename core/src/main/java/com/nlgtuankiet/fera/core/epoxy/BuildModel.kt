package com.nlgtuankiet.fera.core.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.ModelCollector

fun buildSubModels(builder: ModelCollector.() -> Unit): List<EpoxyModel<Any>> {
  val models = mutableListOf<EpoxyModel<*>>()
  val collector = object : ModelCollector {
    override fun add(model: EpoxyModel<*>) {
      models.add(model)
    }
  }
  builder.invoke(collector)
  @Suppress("UNCHECKED_CAST")
  return models as List<EpoxyModel<Any>>
}
