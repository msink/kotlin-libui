// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://dl.bintray.com/kotlin/kotlin-dev")
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
