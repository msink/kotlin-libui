// SPDX-License-Identifier: MIT OR Apache-2.0

val os by lazy { org.gradle.internal.os.OperatingSystem.current()!! }
val isRunningInIde: Boolean = System.getProperty("idea.active") == "true"
