// SPDX-License-Identifier: Apache-2.0

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    if (os.isWindows) mingwX64("windows")
    if (os.isLinux) linuxX64("linux")
    if (os.isMacOsX) macosX64("macosx")

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    targets.withType<KotlinNativeTarget> {
        sourceSets["${targetName}Main"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
    }
}
