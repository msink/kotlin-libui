val os = org.gradle.internal.os.OperatingSystem.current()!!

kotlin {
    if (os.isWindows) sourceSets["windowsMain"]?.apply {
        kotlin.srcDir("src/nativeMain/resources")
    }
    if (os.isLinux) sourceSets["linuxMain"]?.apply {
        kotlin.srcDir("src/nativeMain/resources")
    }
    if (os.isMacOsX) sourceSets["macosxMain"]?.apply {
        kotlin.srcDir("src/nativeMain/resources")
    }
}
