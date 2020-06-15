plugins {
  id("application")
  id("kotlin")
}

application {
  // Define the main class for the application.
  mainClassName = "com.nlgtuankiet.fera.codegen.MainKt"
}
dependencies {
  kotlin()
  exec()
}