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
version = "${VERSION_NAME}${VERSION_SUFFIX}"

val downloadArchive_dest = File(buildDir, "libui-$LIBUI_VERSION.${if (os.isWindows) "zip" else "tgz"}")
val downloadArchive by tasks.registering(de.undercouch.gradle.tasks.download.Download::class) {
    val release = "$LIBUI_REPO/releases/download/$LIBUI_VERSION/libui-$LIBUI_VERSION"
    if (os.isWindows) {
        src("$release-windows-amd64-mingw-static.zip")
    } else if (os.isLinux) {
        src("$release-linux-amd64-static.tgz")
    } else if (os.isMacOsX) {
        src("$release-darwin-amd64-static.tgz")
    }
    dest(downloadArchive_dest)
    overwrite(false)
}

val unpackArchive by tasks.registering(Copy::class) {
    if (os.isWindows) {
        from(zipTree(downloadArchive_dest))
    } else {
        from(tarTree(resources.gzip(downloadArchive_dest)))
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

apply {
    from("publish.gradle")
}
