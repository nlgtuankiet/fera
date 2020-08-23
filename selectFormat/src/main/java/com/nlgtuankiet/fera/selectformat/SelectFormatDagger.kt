package com.nlgtuankiet.fera.selectformat

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
class SelectFormatFragmentComponentFactoryProvider : FragmentComponentFactoryProvider {
  override fun get(): FragmentComponent.Factory<*> {
    return DaggerSelectFormatFragmentComponent.factory()
  }
}

@Component(
  dependencies = [
    CoreComponent::class,
  ],
  modules = [
    Provision::class,
  ],
)

@FragmentScope
interface SelectFormatFragmentComponent : FragmentComponent<SelectFormatFragment> {
  @Component.Factory
  interface Factory : FragmentComponent.Factory<SelectFormatFragment>
}

@Module
object Provision {
  @Provides
  fun args(fragment: SelectFormatFragment): SelectFormatFragmentArgs {
    return SelectFormatFragmentArgs.fromBundle(fragment.requireArguments())
  }

  @Provides
  @Retained
  fun viewModel(fragment: SelectFormatFragment): SelectFormatViewModel {
    return fragment.viewModel
  }
}
