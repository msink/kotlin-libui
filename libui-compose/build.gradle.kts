import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version "1.2.1"
}

val os = org.gradle.internal.os.OperatingSystem.current()!!
val isRunningInIde: Boolean = System.getProperty("idea.active") == "true"

kotlin {
    if (os.isWindows) mingwX64("windows")
    if (os.isLinux) linuxX64("linux")
    if (os.isMacOsX) macosX64("macosx")

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(compose.runtime)
            }
        }
        commonTest {
            kotlin.srcDir("src/unitTest/kotlin")
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    targets.withType<KotlinNativeTarget> {
        sourceSets["${targetName}Main"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
            dependencies {
                api(project(":libui"))
            }
        }

        binaries {
            executable(listOf(RELEASE)) {
            }
        }
    }
}
