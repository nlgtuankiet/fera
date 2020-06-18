package com.nlgtuankiet.fera.home

import androidx.annotation.Keep
import com.nlgtuankiet.fera.core.CoreComponent
import com.nlgtuankiet.fera.core.FragmentComponent
import com.nlgtuankiet.fera.core.FragmentComponentFactoryProvider
import com.nlgtuankiet.fera.core.Retained
import dagger.Component
import dagger.Module
import dagger.Provides
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
  modules = [
    HomeProvision::class
  ]
)
@Singleton
interface HomeComponent : FragmentComponent<HomeFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<HomeFragment>
}

@Module
object HomeProvision {
  @Provides
  @Retained
  @JvmStatic
  fun viewModel(fragment: HomeFragment): HomeViewModel {
    return fragment.viewModel
  }
}
