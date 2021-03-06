package com.nlgtuankiet.fera.configure

import androidx.annotation.Keep
import com.nlgtuankiet.fera.core.CoreComponent
import com.nlgtuankiet.fera.core.FragmentComponent
import com.nlgtuankiet.fera.core.FragmentComponentFactoryProvider
import com.nlgtuankiet.fera.core.FragmentScope
import com.nlgtuankiet.fera.core.Retained
import dagger.Component
import dagger.Module
import dagger.Provides

@Keep
@Suppress("unused")
class ConfigureFragmentComponentFactoryProvider : FragmentComponentFactoryProvider {
  override fun get(): FragmentComponent.Factory<*> {
    return DaggerConfigureComponent.factory()
  }
}

@Component(
  dependencies = [
    CoreComponent::class
  ],
  modules = [
    ConfigureProvision::class
  ]
)
@FragmentScope
interface ConfigureComponent : FragmentComponent<ConfigureFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<ConfigureFragment>
}

@Module
object ConfigureProvision {
  @Provides
  @Retained
  fun viewModel(fragment: ConfigureFragment): ConfigureViewModel {
    return fragment.viewModel
  }

  @Provides
  fun args(fragment: ConfigureFragment): ConfigureFragmentArgs {
    return ConfigureFragmentArgs.fromBundle(fragment.requireArguments())
  }
}
