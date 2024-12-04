plugins {
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlin.android)
  id("androidx.navigation.safeargs.kotlin")  // Đảm bảo Safe Args Plugin đã được thêm vào
}

android {
  namespace = "vn.edu.hust.studentman"
  compileSdk = 35

  defaultConfig {
    applicationId = "vn.edu.hust.studentman"
    minSdk = 24
    targetSdk = 34
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = "11"
  }
}

dependencies {
  implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
  implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
  implementation("androidx.navigation:navigation-safe-args-ktx:2.6.0")
  implementation("androidx.fragment:fragment-ktx:1.5.3")
  implementation("com.google.android.material:material:1.6.0")
  implementation("androidx.appcompat:appcompat:1.5.1")

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.constraintlayout)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)
}
