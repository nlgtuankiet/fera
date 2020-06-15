package com.nlgtuankiet.fera

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.nlgtuankiet.fera.core.coreComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppFragmentFactory @Inject constructor(
  private val context: Context
): FragmentFactory() {
  private val nameMapping = mapOf(
    "com.nlgtuankiet.fera.home.HomeFragment" to "com.nlgtuankiet.fera.home.HomeFragmentComponentFactoryProvider"
  )
  private val providerCache = mutableMapOf<String, FragmentComponentFactoryProvider>()

  override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
    val factoryProviderName = nameMapping[className]
      ?: return super.instantiate(classLoader, className)
    val cache = providerCache[className]
    return if (cache != null) {
      cache.get().create(context.coreComponent).fragment()
    } else {
      val instance = Class.forName(factoryProviderName).newInstance() as FragmentComponentFactoryProvider
      providerCache[className] = instance
      instance.get().create(context.coreComponent).fragment()
    }
  }
}