package com.nlgtuankiet.fera.core

import android.content.Context

interface CoreComponent : DataComponent {
  val context: Context
}

interface HasCoreComponent {
  val coreComponent: CoreComponent
}

val Context.coreComponent: CoreComponent
  get() = (this.applicationContext as HasCoreComponent).coreComponent
