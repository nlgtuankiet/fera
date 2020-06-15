import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent.*

//import fera.build.share

plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
}

tasks.withType(Test::class.java) {
  testLogging {
    events = setOf(FAILED, PASSED, SKIPPED, STANDARD_OUT, STANDARD_ERROR)
    outputs.upToDateWhen { false }
    showStandardStreams = true
    showExceptions = true
    exceptionFormat = TestExceptionFormat.FULL
  }

}
android {
  compileSdkVersion(29)
  buildToolsVersion = "29.0.3"
  defaultConfig {
    applicationId = "com.nlgtuankiet.fera"
    minSdkVersion(14)
    targetSdkVersion(28)
    versionCode = 1
    versionName = "1.0"
    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        File("proguard-rules.pro")
      )
    }
  }
  sourceSets {
    getByName("androidTest") {
      java.srcDirs(
        File("src/test/java/com/nlgtuankiet/fera/share")
      )
    }
  }
}

dependencies {
  moshi()
  dagger()
  exec()
  ffmpeg()
  kotlin()

  implementation("androidx.core:core-ktx:1.3.0")
  implementation("androidx.appcompat:appcompat:1.1.0")
  implementation("androidx.constraintlayout:constraintlayout:1.1.3")
  testImplementation("junit:junit:4.12")
  androidTestImplementation("androidx.test.ext:junit:1.1.1")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}

configurations.all {
  resolutionStrategy {
    eachDependency {
      if (requested.group == "org.bytedeco"
        && requested.name != "ffmpeg-platform"
        && !requested.name.contains("javacpp")
      ) {
        useVersion("4.2.2-1.5.3")
      }
    }
  }
}
