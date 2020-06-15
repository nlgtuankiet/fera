package com.nlgtuankiet.fera.home

import androidx.annotation.Keep
import androidx.fragment.app.Fragment
import com.nlgtuankiet.fera.core.CoreComponent
import com.nlgtuankiet.fera.core.FragmentComponent
import com.nlgtuankiet.fera.core.FragmentComponentFactoryProvider
import dagger.Component
import javax.inject.Singleton

@Keep
class HomeFragmentComponentFactoryProvider : FragmentComponentFactoryProvider {
  override fun get(): FragmentComponent.Factory<*> {
    return DaggerHomeComponent.factory()
  }
}


@Component(
  dependencies = [
    CoreComponent::class
  ],
  modules = []
)
@Singleton
interface HomeComponent : FragmentComponent<HomeFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<HomeFragment>
}