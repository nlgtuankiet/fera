package com.nlgtuankiet.fera.browse

import androidx.annotation.Keep
import com.nlgtuankiet.fera.core.CoreComponent
import com.nlgtuankiet.fera.core.FragmentComponent
import com.nlgtuankiet.fera.core.FragmentComponentFactoryProvider
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.Retained
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Keep
@Suppress("unused")
class BrowseFragmentComponentFactoryProvider : FragmentComponentFactoryProvider {
  override fun get(): FragmentComponent.Factory<*> {
    return DaggerBrowseComponent.factory()
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
@FragmentScope
interface BrowseComponent : FragmentComponent<BrowseFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<BrowseFragment>
}

@Module
object HomeProvision {
  @Provides
  @Retained
  fun viewModel(fragment: BrowseFragment): BrowseViewModel {
    return fragment.viewModel
  }
}
