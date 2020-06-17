import com.android.build.gradle.AppExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.KotlinBuildScript
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

fun KotlinBuildScript.configDynamicPlugin() {
  this.plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
  }
}

fun AppExtension.configDynamicModule() {
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

fun Project.addDynamicDependencies() {
  this.dependencies(
    configuration = {
      implementation(project(":app"))
      kapt("com.google.dagger:dagger-compiler:$daggerVersion")
    }
  )
}
