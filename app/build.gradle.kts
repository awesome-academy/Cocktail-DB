plugins {
    id("com.android.application")
    id("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}
android {
    namespace = "com.sildev.thecocktail"
    defaultConfig {
        applicationId = "com.sildev.thecocktail"
        buildToolsVersion = "33.0.0"
        minSdk = Dependencies.minSdk
        compileSdk = Dependencies.compileSdk
        targetSdk = Dependencies.targetSdk
        versionCode = Dependencies.version
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        kapt {
            arguments {
                arg("room.schemaLocation", "$projectDir/schemas")
            }
        }
    }


    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
            isShrinkResources = false
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions.addAll(listOf("server"))
    productFlavors {
        create("dev") {
            dimension = "server"
            applicationIdSuffix = ".dev"
            buildConfigField("boolean", "MOCK_DATA", "true")
        }
        create("prd") {
            dimension = "server"
            buildConfigField("boolean", "MOCK_DATA", "false")
        }
    }

    applicationVariants.all {
        buildConfigField("String", "BASE_URL", "\"https://www.thecocktaildb.com/api/json/v1/1/\"")
        when (flavorName) {
            "dev" -> {
            }
            "prd" -> {
            }
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }
    kotlinOptions {
        jvmTarget = "11"

    }

    buildFeatures {
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {
    // common
    implementation(Dependencies.appcompat)
    implementation(Dependencies.legacySupport)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.recyclerview)
    implementation(Dependencies.material)
    implementation(Dependencies.reflect)
    implementation(Dependencies.koinCore)
    implementation(Dependencies.koinAndroid)
    implementation(Dependencies.lifecycleViewModelKtx)

    implementation(Dependencies.coreKtx)

    // room
    implementation(Dependencies.roomRuntime)
    kapt(Dependencies.roomCompiler)
    implementation(Dependencies.roomKtx)

    // retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitGson)
    implementation(Dependencies.gson)
    implementation(Dependencies.okLogging)

    // glide
    implementation(Dependencies.glideRuntime)
    kapt(Dependencies.glideCompiler)
    // viewpager2
    implementation(Dependencies.viewpager2)
    //Rounded Image
    implementation(Dependencies.roundedImage)
    //Shimmer
    implementation(Dependencies.shimmer)
}
kapt {
    correctErrorTypes = true
}

