plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.hilt)
}

android {
    compileSdk = Config.compileSdkVersion
    buildToolsVersion = Config.buildToolsVersion

    defaultConfig {
        applicationId = Config.applicationId
        minSdk = Config.minSdkVersion
        targetSdk = Config.targetSdkVersion
        versionCode = Config.versionCode
        versionName = Config.versionName

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        // Disable unused AGP features
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders=  false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Compose.version
    }

    packagingOptions {
        // Multiple dependency bring these files in. Exclude them to enable
        // our test APK to build (has no effect on our AARs)
        resources.excludes.add("/META-INF/AL2.0")
        resources.excludes.add("/META-INF/LGPL2.1")
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {

    // android
    implementation(Android.ktx)
    implementation(Android.appCompat)
    implementation(Android.crypto)
    implementation(Android.splashScreen)
    implementation(Android.material3)

    // compose
    implementation(Compose.ui)
    implementation(Compose.material3)
    implementation(Compose.tooling)
    implementation(Compose.activity)

    // lifecycle
    implementation(Lifecycle.runtime)

    // hilt
    implementation(Hilt.dependency)
    kapt(Hilt.compiler)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

    implementation(Accompanist.animation)
    implementation(Navigation.hilt)

    // testing
    testImplementation(Testing.junit)
    androidTestImplementation(Testing.junitAndroid)
    androidTestImplementation(Testing.espresso)
    androidTestImplementation(Testing.junitCompose)

    implementation(project(Modules.core))
    implementation(project(Modules.noteLogin))
    implementation(project(Modules.noteRegister))
    implementation(project(Modules.noteRepos))
    implementation(project(Modules.noteDataSource))

}