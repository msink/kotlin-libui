// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

plugins {
    id("org.jetbrains.dokka") version Dokka.version
}

allprojects {
    repositories {
        maven { url = uri(Kotlin.repo) }
        mavenCentral()
    }
}

apply {
    from("dokka.gradle")
}
