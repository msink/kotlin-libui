// SPDX-License-Identifier: MIT OR Apache-2.0

@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess

plugins {
    kotlin("multiplatform")
    id("de.undercouch.download")
    id("maven-publish")
}

val VERSION_NAME: String by project
val VERSION_SUFFIX: String by project
val BINTRAY_REPO: String by project

group = Publish.group
version = "$VERSION_NAME$VERSION_SUFFIX"

val downloadArchiveDest = File(buildDir, "libui-${Libui.version}.${if (os.isWindows) "zip" else "tgz"}")
val downloadArchive by tasks.registering(de.undercouch.gradle.tasks.download.Download::class) {
    val release = "${Libui.repo}/releases/download/${Libui.version}/libui-${Libui.version}"
    when {
        os.isWindows -> src("$release-windows-386-mingw-static.zip")
        os.isLinux -> src("$release-linux-amd64-static.tgz")
        os.isMacOsX -> src("$release-darwin-amd64-static.tgz")
    }
    dest(downloadArchiveDest)
    overwrite(false)
}

val unpackArchive by tasks.registering(Copy::class) {
    if (os.isWindows) {
        from(zipTree(downloadArchiveDest))
    } else {
        from(tarTree(resources.gzip(downloadArchiveDest)))
    }
    into(buildDir)
    dependsOn(downloadArchive)
}

kotlin {
    val publishModeEnabled = rootProject.hasProperty("publishMode")
    println("publishModeEnabled: $publishModeEnabled")

    if (publishModeEnabled || os.isWindows) mingwX86("windows")
    if (publishModeEnabled || os.isLinux) linuxX64("linux")
    if (publishModeEnabled || os.isMacOsX) macosX64("macosx")

    targets.withType<KotlinNativeTarget> {
        sourceSets["${targetName}Main"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
        compilations["main"].apply {
            cinterops.create("libui") {
                includeDirs(buildDir)
            }
            kotlinOptions.freeCompilerArgs = listOf(
                "-include-binary", "$buildDir/libui.a"
            )
        }
    }
}

tasks.withType<CInteropProcess> {
    dependsOn(unpackArchive)
}

publishing {
    publications.withType<MavenPublication> {
        pom {
            name.set("libui")
            description.set("Kotlin/Native interop to libui: a portable GUI library")
            url.set(Publish.pom.url)
            licenses {
                license {
                    name.set("MIT License")
                    url.set(Publish.pom.url)
                    distribution.set("repo")
                }
                license {
                    name.set("The Apache License, Version 2.0")
                    url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                }
            }
            developers {
                developer {
                    id.set("msink")
                    name.set("Mike Sinkovsky")
                    email.set("msink@permonline.ru")
                }
            }
            scm {
                url.set(Publish.pom.url)
                connection.set(Publish.pom.connection)
                developerConnection.set(Publish.pom.devConnection)
            }
        }
    }

    repositories {
        maven("https://api.bintray.com/maven/${Publish.user}/$BINTRAY_REPO/libui/;publish=0;override=1") {
            credentials {
                username = Publish.user
                password = System.getenv("BINTRAY_API_KEY")
            }
        }
    }
}

tasks.withType<AbstractPublishToMaven> {
    onlyIf { !name.startsWith("publishWindows") || os.isWindows }
    onlyIf { !name.startsWith("publishMacosx") || os.isMacOsX }
    onlyIf { !name.startsWith("publishLinux") || os.isLinux }
}
