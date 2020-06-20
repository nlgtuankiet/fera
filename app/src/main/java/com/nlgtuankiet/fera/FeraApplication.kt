package com.nlgtuankiet.fera

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.nlgtuankiet.fera.core.DataComponent
import com.nlgtuankiet.fera.core.HasCoreComponent
import com.nlgtuankiet.fera.dagger.AppComponent
import com.nlgtuankiet.fera.dagger.DaggerAppComponent
import dagger.android.AndroidInjector

class FeraApplication : Application(), HasCoreComponent, AndroidInjector<MainActivity> {
  private lateinit var appComponent: AppComponent

  override fun onCreate() {
    val dataComponent = Class
      .forName("com.nlgtuankiet.fera.data.DataComponentProvider")
      .newInstance().let { it as DataComponent.DataComponentProvider }
      .get(this)
    appComponent = DaggerAppComponent.factory().create(context = this, dataComponent = dataComponent)
    appComponent.inject(this)
    super.onCreate()
    initialize()
  }

  override fun attachBaseContext(base: Context) {
    super.attachBaseContext(base)
    MultiDex.install(this)
  }

  override val coreComponent: com.nlgtuankiet.fera.core.CoreComponent
    get() = appComponent

  override fun inject(instance: MainActivity) {
    appComponent.inject(instance)
  }

  private fun initialize() {
    setupStrictMode()
  }
}
