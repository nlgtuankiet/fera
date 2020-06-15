import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
  add("implementation", dependencyNotation)

fun DependencyHandler.api(dependencyNotation: Any): Dependency? =
  add("api", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
  add("kapt", dependencyNotation)

fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
  add("kaptTest", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
  add("kaptAndroidTest", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
  add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.moshi() {
  implementation("com.squareup.moshi:moshi-kotlin:1.9.3")
  kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
}

const val daggerVersion = "2.28"

fun DependencyHandler.dagger() {
  api("com.google.dagger:dagger:$daggerVersion")
  kapt("com.google.dagger:dagger-compiler:$daggerVersion")
  kaptTest("com.google.dagger:dagger-compiler:$daggerVersion")
  kaptAndroidTest("com.google.dagger:dagger-compiler:$daggerVersion")
  api("com.google.dagger:dagger-android:$daggerVersion")
  api("com.google.dagger:dagger-android-support:$daggerVersion")
  kapt("com.google.dagger:dagger-android-processor:$daggerVersion")
  kaptTest("com.google.dagger:dagger-android-processor:$daggerVersion")
  kaptAndroidTest("com.google.dagger:dagger-android-processor:$daggerVersion")
}

fun DependencyHandler.exec() {
  implementation("org.zeroturnaround:zt-exec:1.11")
  implementation("org.zeroturnaround:zt-process-killer:1.10")
}

fun DependencyHandler.ffmpeg() {
  implementation("org.bytedeco:ffmpeg-platform:4.2.3-1.5.4-SNAPSHOT")
}

fun DependencyHandler.kotlin() {
  api("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
  api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
}

fun DependencyHandler.appCompat() {
  api("androidx.appcompat:appcompat:1.1.0")
}

fun DependencyHandler.fragment() {
  api("androidx.fragment:fragment-ktx:1.3.0-alpha06")
}

fun DependencyHandler.inject() {
  api("javax.inject:javax.inject:1")
}

fun DependencyHandler.constraintLayout() {
  api("androidx.constraintlayout:constraintlayout:1.1.3")
}

fun DependencyHandler.navigation() {
  val varsion = "2.3.0-rc01"
  api("androidx.navigation:navigation-fragment-ktx:$varsion")
  api("androidx.navigation:navigation-ui-ktx:$varsion")
  api("androidx.navigation:navigation-dynamic-features-fragment:$varsion")
  androidTestImplementation("androidx.navigation:navigation-testing:$varsion")
}

