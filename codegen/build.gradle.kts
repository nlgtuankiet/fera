plugins {
  id("application")
  id("kotlin")
}

application {
  // Define the main class for the application.
  mainClassName = "com.nlgtuankiet.fera.codegen.MainKt"
}
dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4-M2")
  implementation("org.zeroturnaround:zt-exec:1.11")
}