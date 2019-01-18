// Top-level build file where you can add configuration options common to all sub-projects/modules.
// SPDX-License-Identifier: MIT

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
