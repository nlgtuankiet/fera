package com.nlgtuankiet.fera.dagger

import android.app.Application
import android.content.Context
import com.nlgtuankiet.fera.FeraApplication
import com.nlgtuankiet.fera.MainActivity
import com.nlgtuankiet.fera.core.DataComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(
  modules = [
    AppProvisionModule::class,
    AppBindingModule::class
  ],
  dependencies = [
    DataComponent::class
  ]
)
@Singleton
interface AppComponent : com.nlgtuankiet.fera.core.CoreComponent {
  fun inject(app: FeraApplication)
  fun inject(activity: MainActivity)

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance app: FeraApplication,
      dataComponent: DataComponent
    ): AppComponent
  }
}

@Module
object AppProvisionModule

@Module
interface AppBindingModule {

  @Binds
  fun context(impl: FeraApplication): Context

  @Binds
  fun application(impl: FeraApplication): Application
}
