// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin-multiplatform") {
                useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:${requested.version}")
            }
        }
    }

    repositories {
        if (Kotlin.repo.isNotEmpty()) maven { url = uri(Kotlin.repo) }
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
    }
}

enableFeaturePreview("GRADLE_METADATA")

include(":libui")

include(":samples:controlgallery")
include(":samples:datetime")
include(":samples:drawtext")
include(":samples:form")
include(":samples:hello")
include(":samples:hello-ktx")
include(":samples:histogram")
include(":samples:logo")
include(":samples:table")
include(":samples:timer")
