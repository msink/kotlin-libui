// SPDX-License-Identifier: MIT OR Apache-2.0
@file:Suppress("SpellCheckingInspection")

import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

val os = org.gradle.internal.os.OperatingSystem.current()!!
val isRunningInIde: Boolean = System.getProperty("idea.active") == "true"

val samplesResourcesDir = "$projectDir/resources"

subprojects {
    apply(plugin = "kotlin-multiplatform")

    configure<KotlinMultiplatformExtension> {
        if (os.isWindows) {
            mingwX64("windows64")
            if (!isRunningInIde) {
                mingwX86("windows")
            }
        }
        if (os.isLinux) {
            linuxX64("linux")
        }
        if (os.isMacOsX) {
            macosX64("macosx")
        }

        fun org.jetbrains.kotlin.gradle.plugin.mpp.Executable.windowsResources(rcFileName: String) {
            val taskName = linkTaskName.replaceFirst("link", "windres")
            val inFile = File(rcFileName)
            val outFile = buildDir.resolve("processedResources/$taskName.res")

            val windresTask = tasks.create<Exec>(taskName) {
                val mingwRoot = File(System.getenv("MSYS2_ROOT") ?: "C:/msys64/")
                val mingwBin = when (target.konanTarget.architecture.bitness) {
                    32 -> mingwRoot.resolve("mingw32/bin")
                    64 -> mingwRoot.resolve("mingw64/bin")
                    else -> error("Unsupported architecture")
                }

                inputs.file(inFile)
                outputs.file(outFile)
                commandLine("$mingwBin/windres", inFile, "-D_${buildType.name}", "-O", "coff", "-o", outFile)
                environment("PATH", "$mingwBin;${System.getenv("PATH")}")

                dependsOn(compilation.compileKotlinTask)
            }

            linkTask.dependsOn(windresTask)
            linkerOpts(outFile.toString())
        }

        targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
            sourceSets["${targetName}Main"].apply {
                kotlin.srcDir("src/nativeMain/kotlin")
                dependencies {
                    implementation(project(":libui"))
                }
            }
            binaries {
                executable(listOf(RELEASE)) {
                    if (konanTarget.family == org.jetbrains.kotlin.konan.target.Family.MINGW) {
                        windowsResources("${rootProject.rootDir}/samples/resources/samples.rc")
                    }
                }
            }
        }
    }
}
