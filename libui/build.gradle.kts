// SPDX-License-Identifier: MIT

@file:Suppress("SpellCheckingInspection")

import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayUploadTask
import java.util.Date

plugins {
    id("kotlin-multiplatform")
    id("de.undercouch.download")
    id("maven-publish")
    id("com.jfrog.bintray")
}

val GROUP: String by project
val VERSION_NAME: String by project
val VERSION_SUFFIX: String by project
val LIBUI_REPO: String by project
val LIBUI_VERSION: String by project

val os = org.gradle.internal.os.OperatingSystem.current()!!

group = GROUP
version = "$VERSION_NAME$VERSION_SUFFIX"

val downloadArchiveDest = File(buildDir, "libui-$LIBUI_VERSION.${if (os.isWindows) "zip" else "tgz"}")
val downloadArchive by tasks.registering(de.undercouch.gradle.tasks.download.Download::class) {
    val release = "$LIBUI_REPO/releases/download/$LIBUI_VERSION/libui-$LIBUI_VERSION"
    when {
        os.isWindows -> src("$release-windows-amd64-mingw-static.zip")
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

    if (os.isWindows || publishModeEnabled) mingwX64("windows") {
        sourceSets["windowsMain"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
        compilations["main"].cinterops.create("libui") {
            includeDirs(buildDir)
        }
    }

    if (os.isLinux || publishModeEnabled) linuxX64("linux") {
        sourceSets["linuxMain"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
        compilations["main"].cinterops.create("libui") {
            includeDirs(buildDir)
        }
    }

    if (os.isMacOsX || publishModeEnabled) macosX64("macosx") {
        sourceSets["macosxMain"].apply {
            kotlin.srcDir("src/nativeMain/kotlin")
        }
        compilations["main"].cinterops.create("libui") {
            includeDirs(buildDir)
        }
    }
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.CInteropProcess::class).all {
    dependsOn(unpackArchive)
}

/*
 * Publishing
 */
val POM_SCM_URL: String by project
val POM_SCM_CONNECTION: String by project
val POM_SCM_DEV_CONNECTION: String by project
val BINTRAY_USER: String by project
val BINTRAY_REPO: String by project

val publications = project.publishing.publications.withType(MavenPublication::class.java).map {
    with(it.pom) {
        withXml {
            val root = asNode()
            root.appendNode("name", "libui")
            root.appendNode("description", "Kotlin/Native interop to libui: a portable GUI library")
            root.appendNode("url", POM_SCM_URL)
        }
        licenses {
            license {
                name.set("MIT License")
                url.set(POM_SCM_URL)
                distribution.set("repo")
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
            url.set(POM_SCM_URL)
            connection.set(POM_SCM_CONNECTION)
            developerConnection.set(POM_SCM_DEV_CONNECTION)
        }
    }
    println("Publishing artifact '${it.groupId}:${it.artifactId}:${it.version}' from publication '${it.name}'")
    it
}

publishing {
    repositories {
        maven { url = uri("https://bintray.com/$BINTRAY_USER/$BINTRAY_REPO") }
    }
}

tasks.withType<BintrayUploadTask>().configureEach {
    dependsOn("publishToMavenLocal")
    setPublications(publications)
}

bintray {
    user = BINTRAY_USER
    key = System.getenv("BINTRAY_API_KEY")
    override = true // for multi-platform Kotlin/Native publishing
    pkg(delegateClosureOf<BintrayExtension.PackageConfig> {
        userOrg = BINTRAY_USER
        repo = BINTRAY_REPO
        name = "libui"
        setLicenses("MIT")
        vcsUrl = POM_SCM_URL
        version(delegateClosureOf<BintrayExtension.VersionConfig> {
            name = project.version.toString()
            vcsTag = project.version.toString()
            released = Date().toString()
        })
    })
}
