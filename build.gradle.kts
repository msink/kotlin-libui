// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

plugins {
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.download) apply false
    alias(libs.plugins.dokka)
}

allprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    }
}

apply {
    from("dokka.gradle")
}
