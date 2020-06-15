buildscript {

  repositories {
    google()
    jcenter()
    maven { url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots") }
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:4.0.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")

    // TODO refactor
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-rc01")
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven { url = java.net.URI("https://oss.sonatype.org/content/repositories/snapshots") }
    mavenCentral()
  }
}


