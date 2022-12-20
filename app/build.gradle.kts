plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
    id("com.google.devtools.ksp") version "1.6.21-1.0.6"
}
kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.chillmax"
        minSdk = 28
        targetSdk = 32
        versionCode = 1
        versionName  = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
           isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        val compose_version = "1.2.0-beta01"
        kotlinCompilerExtensionVersion = compose_version
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    namespace = "com.example.chillmax"
}

dependencies {

    implementation("androidx.test:core-ktx:1.5.0")
    // A. Dependency Versions
    // 1. Core
    val kotlin_version = "1.5.31"
    val core_ktx = "1.5.0"
    val kotlin_serialization = "1.2.2"

    // 2. UI
    val compose_version = "1.2.0-beta01"
    val accompanist_version = "0.21.2-beta"
    val activity_compose = "1.3.1"
    val compose_navigation = "2.5.2"
    val lifecycle_runtime = "2.3.1"
    val paging_compose = "1.0.0-alpha14"
    val coil_compose = "1.3.2"
    val palette = "1.0.0"
    val ramacosta_navigation = "1.6.15-beta"

    // 3. Database
    val android_room = "2.3.0"
    val android_datastore = "1.0.0"

    // 4. Network
    val retrofit = "2.9.0"
    val retrofit_ktx_serialization = "0.8.0"

    // 5. Dagger Hilt
    val dagger_hilt = "2.38.1"
    val android_hilt_compiler = "1.0.0"
    val hilt_nav_compose = "1.0.0-alpha03"
    val hilt_android_compiler = "2.43.2"
    val hilt_android_testing = "2.42"

    // B. Test Dependency versions
    val junit = "4.13.2"
    val junit_ext = "1.1.3"
    val espresso_core = "3.4.0"
    val test_runner = "1.5.1"
    val kotlinx_coroutines_test ="1.6.4"
    val core_testing = "2.1.0"
    val truth= "1.1.3"
    val mock_webserver = "4.9.1"
    val mockito_android = "3.10.0"
    val mockito_inline = "3.11.2"
    val mockito_kotlin = "3.2.0"
    val mockk = "1.12.7"
    val mockito_core = "3.11.2"
    val robolectric = "4.8.1"

    implementation("androidx.core:core-ktx:$core_ktx")
    implementation("androidx.compose.ui:ui:$compose_version")
    implementation("androidx.compose.material:material:$compose_version")
    implementation("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_runtime")
    implementation("androidx.activity:activity-compose:$activity_compose")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:$junit_ext")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espresso_core")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$compose_version")

    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:$compose_navigation")

    // Room components
    implementation("androidx.room:room-runtime:$android_room")
    kapt("androidx.room:room-compiler:$android_room")
    implementation("androidx.room:room-ktx:$android_room")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:$retrofit_ktx_serialization")

    // Paging 3.0
    implementation("androidx.paging:paging-compose:$paging_compose")

    // KotlinX Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$kotlin_serialization")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:$android_datastore")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$dagger_hilt")
    kapt("com.google.dagger:hilt-android-compiler:$dagger_hilt")
    kapt("androidx.hilt:hilt-compiler:$android_hilt_compiler")
    implementation("androidx.hilt:hilt-navigation-compose:$hilt_nav_compose")

    // Coil
    implementation("io.coil-kt:coil-compose:$coil_compose")

    // Horizontal Pager and Indicators - Accompanist
    implementation("com.google.accompanist:accompanist-pager:$accompanist_version")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanist_version")

    implementation("com.google.accompanist:accompanist-flowlayout:$accompanist_version")

    // Swipe to Refresh - Accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanist_version")

    // System UI Controller - Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanist_version")

    // Palette API
    implementation("androidx.palette:palette-ktx:$palette")

    // Testing
    androidTestImplementation ("junit:junit:$junit")
    androidTestImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinx_coroutines_test")
    androidTestImplementation ("androidx.arch.core:core-testing:$core_testing")
    androidTestImplementation ("com.google.truth:truth:$truth")
    androidTestImplementation ("androidx.test:core-ktx:$core_ktx")
    androidTestImplementation ("com.squareUp.okhttp3:mockWebserver:$mock_webserver")
    testImplementation ("org.mockito:mockito-android:$mockito_android")
    testImplementation ("org.mockito:mockito-inline:$mockito_inline")
    testImplementation ("org.mockito.kotlin:mockito-kotlin:$mockito_kotlin")
    testImplementation ("io.mockk:mockk:$mockk")
    testImplementation ("org.mockito:mockito-core:$mockito_core")
    androidTestImplementation ("org.mockito:mockito-android:$mockito_android")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:$hilt_android_testing")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:$hilt_android_compiler")
    testImplementation ("junit:junit:$junit")
    testImplementation ("androidx.test:runner:$test_runner")
    testImplementation ("com.google.truth:truth:$truth")
    testImplementation ("androidx.test:core-ktx:$core_ktx")
    testImplementation ("org.robolectric:robolectric:$robolectric")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$kotlinx_coroutines_test")
    testImplementation ("androidx.arch.core:core-testing:$core_testing")
    androidTestImplementation ("androidx.test.ext:junit:$junit")
    androidTestImplementation ("androidx.test.espresso:espresso-core:$espresso_core")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:$compose_version")

    // RamaCosta Navigation
    implementation("io.github.raamcosta.compose-destinations:animations-core:$ramacosta_navigation")
    ksp("io.github.raamcosta.compose-destinations:ksp:$ramacosta_navigation")
}