object Dependencies {
    const val minSdk = 26
    const val compileSdk = 33
    const val targetSdk = 33
    const val version = 1

    // Support libs
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.0-alpha1"
    const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
    const val material = "com.google.android.material:material:1.3.0-alpha04"
    const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect:1.7.10"

    // List of KTX extensions
    // https://developer.android.com/kotlin/ktx/extensions-list
    const val coreKtx = "androidx.core:core-ktx:1.9.0"
    const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"


    // room
    // https://developer.android.com/topic/libraries/architecture/room
    const val roomRuntime = "androidx.room:room-runtime:2.4.3"
    const val roomCompiler = "androidx.room:room-compiler:2.4.3"
    // Kotlin Extensions and Coroutines support for Room
    const val roomKtx = "androidx.room:room-ktx:2.4.3"


    // gson
    // https://github.com/google/gson
    const val gson = "com.google.code.gson:gson:2.8.6"

    // retrofit
    // https://github.com/square/retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val okLogging = "com.squareup.okhttp3:logging-interceptor:4.7.2"


    // glide
    // https://github.com/bumptech/glide
    private const val glideVersion = "4.11.0"
    const val glideRuntime = "com.github.bumptech.glide:glide:$glideVersion"
    const val glideCompiler = "com.github.bumptech.glide:compiler:$glideVersion"

    // koin
    // https://github.com/InsertKoinIO/koin
    private const val koin = "3.2.0"
    const val koinCore = "io.insert-koin:koin-core:$koin"
    const val koinAndroid = "io.insert-koin:koin-android:$koin"

    const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"

    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"
    const val roundedImage = "com.makeramen:roundedimageview:2.3.0"
}
