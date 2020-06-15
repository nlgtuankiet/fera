plugins {
  id("com.android.dynamic-feature")
  kotlin("android")
  kotlin("kapt")
}

android {
  compileSdkVersion(29)
  buildToolsVersion("29.0.3")
  defaultConfig {
    minSdkVersion(14)
    targetSdkVersion(29)
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
}

addDynamicDependencies()
