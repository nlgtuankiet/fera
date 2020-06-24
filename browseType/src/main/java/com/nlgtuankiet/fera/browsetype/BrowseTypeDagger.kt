package com.nlgtuankiet.fera.browsetype

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
@Suppress("unused")
class BrowseTypeFragmentComponentFactoryProvider : FragmentComponentFactoryProvider {
  override fun get(): FragmentComponent.Factory<*> {
    return DaggerBrowseTypeComponent.factory()
  }
}

@Component(
  dependencies = [
    CoreComponent::class
  ],
  modules = [
    BrowseTypeProvision::class
  ]
)
@Singleton
interface BrowseTypeComponent : FragmentComponent<BrowseTypeFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<BrowseTypeFragment>
}

@Module
object BrowseTypeProvision {
  @Provides
  @Retained
  fun viewModel(fragment: BrowseTypeFragment): BrowseTypeViewModel {
    println("init request BrowseTypeViewModel from BrowseTypeProvision")
    return fragment.viewModel
  }

  @Provides
  fun args(fragment: BrowseTypeFragment): BrowseTypeFragmentArgs {
    return BrowseTypeFragmentArgs.fromBundle(fragment.requireArguments())
  }
}
