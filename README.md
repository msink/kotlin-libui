kotlin-libui
============

[![Build status](https://ci.appveyor.com/api/projects/status/github/msink/kotlin-libui?svg=true)](https://ci.appveyor.com/project/msink/kotlin-libui)
[![Build Status](https://travis-ci.org/msink/kotlin-libui.svg?branch=master)](https://travis-ci.org/msink/kotlin-libui)

[Kotlin/Native](https://github.com/JetBrains/kotlin-native) bindings to the
[libui](https://github.com/andlabs/libui.git) C library

libui is a C lightweight multi-platform UI library using native widgets on Linux (Gtk3), macOS, and Windows.
Using this bindings you can develop cross-platform but native-looking GUI programs, written in Kotlin,
and compiled to small native executable file.

**Work in progress!**

Cross-platform build is automated using [Travis](https://travis-ci.org) for Linux and macOS targets, and
[AppVeyor](https://ci.appveyor.com) for Windows targets. Just create release on GitHub, and executable files
for all 3 major desktop platforms will be compiled and attached to release.

For local build use `.\build.sh` on Linux or macOS, or `build.bat` on Windows.
In this case only one - native for your platform - file will be built.

## Screenshots

![Windows](samples/hello/hello-windows.png)

![Unix](samples/hello/hello-linux.png)

![OS X](samples/hello/hello-osx.png)
