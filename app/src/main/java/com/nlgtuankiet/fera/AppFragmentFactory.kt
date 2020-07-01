package com.nlgtuankiet.fera

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.nlgtuankiet.fera.core.FragmentComponentFactoryProvider
import com.nlgtuankiet.fera.core.coreComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppFragmentFactory @Inject constructor(
  private val context: Context
) : FragmentFactory() {
  private val nameMapping = mapOf(
    "com.nlgtuankiet.fera.home.HomeFragment"
      to "com.nlgtuankiet.fera.home.HomeFragmentComponentFactoryProvider",
    "com.nlgtuankiet.fera.browse.BrowseFragment"
      to "com.nlgtuankiet.fera.browse.BrowseFragmentComponentFactoryProvider",
    "com.nlgtuankiet.fera.browsetype.BrowseTypeFragment"
      to "com.nlgtuankiet.fera.browsetype.BrowseTypeFragmentComponentFactoryProvider"
  )
  private val providerCache = mutableMapOf<String, FragmentComponentFactoryProvider>()

  override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
    return createFromCache(classLoader, className)
      ?: createFromMapping(classLoader, className)
      ?: createFromFragmentName(classLoader, className)
      ?: super.instantiate(classLoader, className)
  }

  private fun createFromCache(classLoader: ClassLoader, className: String): Fragment? {
    val cache = providerCache[className] ?: return null
    return cache.get().create(context.coreComponent).fragment()
  }

  private fun createFromFragmentName(classLoader: ClassLoader, className: String): Fragment? {
    val providerName = "${className}ComponentFactoryProvider"
    return try {
      val provider = Class.forName(providerName).newInstance()
        as FragmentComponentFactoryProvider
      providerCache[className] = provider
      provider.get().create(context.coreComponent).fragment()
    } catch (ignored: Exception) {
      null
    }
  }

  private fun createFromMapping(classLoader: ClassLoader, className: String): Fragment? {
    val factoryProviderName = nameMapping[className] ?: return null
    val instance =
      Class.forName(factoryProviderName).newInstance() as FragmentComponentFactoryProvider
    providerCache[className] = instance
    return instance.get().create(context.coreComponent).fragment()
  }
}
