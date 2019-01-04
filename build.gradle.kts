// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

plugins {
    id("org.jetbrains.dokka") version Dokka.version
}

allprojects {
    repositories {
        if (Kotlin.repo.isNotEmpty()) maven { url = uri(Kotlin.repo) }
        mavenCentral()
        jcenter()
    }
}

apply {
    from("dokka.gradle")
}
