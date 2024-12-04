buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:7.4.2")  // Android Gradle Plugin
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")  // Kotlin Plugin
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")  // Safe Args Plugin
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}
