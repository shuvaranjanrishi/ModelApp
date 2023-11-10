plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.blooddonor"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.blooddonor"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Dependencies.coreKtx)
    implementation(Dependencies.appcompat)
    implementation(Dependencies.lifecycleRuntimeKtx)
    implementation(Dependencies.activityCompose)
    implementation(Dependencies.composeBom)
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiPreview)
    implementation(Dependencies.material3)
    implementation(Dependencies.materialExtended)
    implementation(Dependencies.junit)
    implementation(Dependencies.testJunit)
    implementation(Dependencies.espressoCore)
    implementation(Dependencies.navigationCompose)
    implementation(Dependencies.composeTestJunit4)
    implementation(Dependencies.composeUiTool)
    implementation(Dependencies.composeManifest)
    implementation(Dependencies.lifecycleViewModelKtx)
    implementation(Dependencies.hiltAndroid)
    implementation(Dependencies.hiltNavigationCompose)
    kapt(Dependencies.hiltCompiler)
    kapt(Dependencies.hiltAndroidCompiler)
    implementation(project(Modules.utilities))
    //network
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.gsonConverter)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
    //coroutine
    implementation(Dependencies.coroutinesCore)
    implementation(Dependencies.coroutinesAndroid)
    //splashscreen
    implementation(Dependencies.splashScreen)
}

kapt {
    correctErrorTypes = true
}