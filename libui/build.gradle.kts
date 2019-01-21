// SPDX-License-Identifier: MIT

@file:Suppress("SpellCheckingInspection")

import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayUploadTask
import java.util.Date

plugins {
    id("kotlin-multiplatform") version Kotlin.version
    id("de.undercouch.download") version Download.version
    id("maven-publish")
    id("com.jfrog.bintray") version Bintray.version
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
/// println("Publishing artifact '${it.groupId}:${it.artifactId}:${it.version}' from publication '${it.name}'")
    it
}

publishing {
    repositories {
        maven { url = uri("https://bintray.com/${Publish.user}/$BINTRAY_REPO") }
    }
}

/*TODO this does not work:
tasks.withType<BintrayUploadTask>().configureEach {
    dependsOn("publishToMavenLocal")
    setPublications(publications)
}
*/
apply {
    from("publish.gradle")
/*TODO this works, in Groovy DSL:
bintrayUpload {
    dependsOn publishToMavenLocal
    doFirst {
        publications = project.publishing.publications.collect {
            println("Uploading artifact '$it.groupId:$it.artifactId:$it.version' from publication '$it.name'")
            it
        }
    }
}
*/
}

bintray {
    user = Publish.user
    key = System.getenv("BINTRAY_API_KEY")
    override = true // for multi-platform Kotlin/Native publishing
    pkg {
        userOrg = Publish.user
        repo = BINTRAY_REPO
        name = "libui"
        setLicenses("MIT")
        vcsUrl = Publish.pom.url
        version {
            name = project.version.toString()
            vcsTag = project.version.toString()
            released = Date().toString()
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
