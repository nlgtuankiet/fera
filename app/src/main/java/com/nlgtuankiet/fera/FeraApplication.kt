package com.nlgtuankiet.fera

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.nlgtuankiet.fera.dagger.AppComponent
import com.nlgtuankiet.fera.core.CoreComponent
import com.nlgtuankiet.fera.dagger.DaggerAppComponent
import com.nlgtuankiet.fera.core.HasCoreComponent
import dagger.android.AndroidInjector

class FeraApplication : Application(), HasCoreComponent, AndroidInjector<MainActivity> {
  private lateinit var appComponent: AppComponent

  override fun onCreate() {
    appComponent = DaggerAppComponent.factory().create(this)
    appComponent.inject(this)
    super.onCreate()
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
}