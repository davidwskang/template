plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kotlin.kapt)
	alias(libs.plugins.hilt)
	alias(libs.plugins.realm)
}

android {
	namespace = "com.davidwskang.${rootProject.name}"
	compileSdk = 33

	defaultConfig {
		applicationId = "com.davidwskang.${rootProject.name}"
		minSdk = 23
		targetSdk = 33
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		vectorDrawables {
			useSupportLibrary = true
		}
	}

	buildTypes {
		named("release") {
			isMinifyEnabled = false
			setProguardFiles(
				listOf(
					getDefaultProguardFile("proguard-android-optimize.txt"),
					"proguard-rules.pro"
				)
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
	buildFeatures {
		compose = true
	}
	composeOptions {
		kotlinCompilerExtensionVersion = libs.versions.composecompiler.get()
	}

	packagingOptions {
		resources {
			excludes += "/META-INF/{AL2.0,LGPL2.1}"
		}
	}
}

dependencies {
	implementation(libs.androidx.lifecycle.viewmodel.ktx)

	implementation(libs.androidx.activity.compose)

	implementation(libs.androidx.navigation.compose)

	implementation(libs.androidx.emoji)

	implementation(platform(libs.compose.bom))
	implementation(libs.compose.foundation.foundation)
	implementation(libs.compose.foundation.layout)
	implementation(libs.compose.material.material)
	implementation(libs.compose.material.iconsext)
	implementation(libs.compose.animation.animation)
	implementation(libs.compose.ui.tooling)

	implementation(libs.accompanist.navigation.animation)
	implementation(libs.accompanist.navigation.material)

	implementation(libs.threeTenAbp)

	implementation(libs.timber)

	implementation(libs.kotlin.coroutines.android)
	implementation(libs.kotlin.coroutines.core)
	implementation(libs.kotlin.coroutines.core.mt)

	implementation(libs.realm)

	implementation(libs.ktor.core)
	implementation(libs.ktor.okhttp)

	implementation(libs.okhttp.loggingInterceptor)

	implementation(libs.hilt.library)
	implementation(libs.hilt.compose)
	kapt(libs.hilt.compiler)

	implementation(libs.koin.core)
	implementation(libs.koin.android)

	testImplementation(libs.junit)
	testImplementation(libs.robolectric)
	testImplementation(libs.androidx.test.core)
	testImplementation(libs.androidx.test.rules)
}
