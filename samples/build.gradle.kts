// SPDX-License-Identifier: MIT

@file:Suppress("SpellCheckingInspection")

plugins {
    id("kotlin-multiplatform") version Kotlin.version
}

val samplesResourcesDir = "$projectDir/resources"

subprojects {
    apply(plugin = "kotlin-multiplatform")

    val samplesResource = "${project.buildDir}/konan/resources/samples.res"

    val compileWindowsResources by tasks.registering(Exec::class) {
        onlyIf { os.isWindows }

        val konanUserDir = System.getenv("KONAN_DATA_DIR") ?: "${System.getProperty("user.home")}/.konan"
        val konanLlvmDir = "$konanUserDir/dependencies/msys2-mingw-w64-x86_64-gcc-7.3.0-clang-llvm-lld-6.0.1/bin"
        val rcFile = file("$samplesResourcesDir/samples.rc")

        inputs.file(rcFile)
        outputs.file(file(samplesResource))
        commandLine("cmd", "/c", "windres", rcFile, "-O", "coff", "-o", samplesResource)
        environment("PATH", "c:/msys64/mingw64/bin;$konanLlvmDir;${System.getenv("PATH")}")
    }

    kotlin {
        if (os.isWindows) mingwX64("windows") {
            sourceSets["windowsMain"].apply {
                kotlin.srcDir("src/nativeMain/kotlin")
                dependencies {
                    implementation(project(":libui"))
                }
            }
            binaries {
                executable(listOf(RELEASE)) {
                    tasks.named("compileKotlinWindows") { dependsOn(compileWindowsResources) }
                    linkerOpts(samplesResource, "-mwindows")
                }
            }
        }

        if (os.isLinux) linuxX64("linux") {
            sourceSets["linuxMain"].apply {
                kotlin.srcDir("src/nativeMain/kotlin")
                dependencies {
                    implementation(project(":libui"))
                }
            }
            binaries {
                executable(listOf(RELEASE))
            }
        }

        if (os.isMacOsX) macosX64("macosx") {
            sourceSets["macosxMain"].apply {
                kotlin.srcDir("src/nativeMain/kotlin")
                dependencies {
                    implementation(project(":libui"))
                }
            }
            binaries {
                executable(listOf(RELEASE))
            }
        }
    }
}
