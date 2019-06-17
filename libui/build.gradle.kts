// SPDX-License-Identifier: MIT OR Apache-2.0

@file:Suppress("SpellCheckingInspection")

import com.jfrog.bintray.gradle.BintrayExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.CInteropProcess
import java.util.Date

plugins {
    kotlin("multiplatform")
    id("de.undercouch.download")
    id("maven-publish")
    id("com.jfrog.bintray")
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

    targets.withType(KotlinNativeTarget::class.java) {
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

tasks.withType(CInteropProcess::class).all {
    dependsOn(unpackArchive)
}

/*
 * Publishing
 */
publishing {
    repositories {
        maven { url = uri("https://bintray.com/${Publish.user}/$BINTRAY_REPO") }
    }
}

val publications = project.publishing.publications.withType(MavenPublication::class.java).map {
    with(it.pom) {
        withXml {
            val root = asNode()
            root.appendNode("name", "libui")
            root.appendNode("description", "Kotlin/Native interop to libui: a portable GUI library")
            root.appendNode("url", Publish.pom.url)
        }
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

bintray {
    user = Publish.user
    key = System.getenv("BINTRAY_API_KEY")
    override = true // for multi-platform Kotlin/Native publishing
    pkg {
        userOrg = Publish.user
        repo = BINTRAY_REPO
        name = "libui"
        setLicenses("MIT", "Apache-2.0")
        vcsUrl = Publish.pom.url
        version {
            name = project.version.toString()
            vcsTag = project.version.toString()
            released = Date().toString()
        }
    }
    project.publishing.publications.all {
        if ((name != "windows" || os.isWindows) &&
            (name != "macosx" || os.isMacOsX) &&
            (name != "linux" || os.isLinux)
        ) {
            // Bintray DSL doesn't allow writing just `publication += name` :(
            this@bintray.setPublications(*publications, name)
        }
    }
}

/*
 * Workarounds
 */
fun BintrayExtension.pkg(configure: BintrayExtension.PackageConfig.() -> Unit): Any? {
    return pkg(delegateClosureOf(configure))
}

fun BintrayExtension.PackageConfig.version(configure: BintrayExtension.VersionConfig.() -> Unit): Any? {
    return version(delegateClosureOf(configure))
}
