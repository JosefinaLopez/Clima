plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.clima"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.clima"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //Activarlo para acceder directamente a las propiedades de lo layout o activitys
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    //Librerias Importantes
    implementation ("com.github.kittinunf.fuel:fuel:2.3.1") //Core package"
    implementation ("com.github.kittinunf.fuel:fuel-android:2.3.1") //Android
    implementation ("com.github.kittinunf.fuel:fuel-gson:2.3.1") //Fuel Gson
    implementation ("com.google.code.gson:gson:2.10") //Gson
    implementation ("com.github.kittinunf.fuel:fuel-coroutines:2.3.1")
    //CardView Redondeada alv
    implementation ("androidx.cardview:cardview:1.0.0")
    implementation ("com.squareup.picasso:picasso:2.71828")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}