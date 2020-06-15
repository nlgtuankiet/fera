import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
  add("implementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
  add("kapt", dependencyNotation)

fun DependencyHandler.kaptTest(dependencyNotation: Any): Dependency? =
  add("kaptTest", dependencyNotation)

fun DependencyHandler.kaptAndroidTest(dependencyNotation: Any): Dependency? =
  add("kaptAndroidTest", dependencyNotation)

fun DependencyHandler.moshi() {
  implementation("com.squareup.moshi:moshi-kotlin:1.9.3")
  kapt("com.squareup.moshi:moshi-kotlin-codegen:1.9.3")
}

fun DependencyHandler.dagger() {
  val daggerVersion = "2.28"
  implementation("com.google.dagger:dagger:$daggerVersion")
  kapt("com.google.dagger:dagger-compiler:$daggerVersion")
  kaptTest("com.google.dagger:dagger-compiler:$daggerVersion")
  kaptAndroidTest("com.google.dagger:dagger-compiler:$daggerVersion")
  implementation("com.google.dagger:dagger-android:$daggerVersion")
  implementation("com.google.dagger:dagger-android-support:$daggerVersion")
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
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.7")
}

