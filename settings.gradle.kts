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
        mavenCentral()
        maven { url = uri("https://plugins.gradle.org/m2/") }
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-dev") }
    }
}

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
