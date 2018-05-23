@echo off

if not exist build\libui\out\libui.a (
  set "PATH=C:\msys64\mingw64\bin;%PATH%"
  git submodule update --init
  md build\libui
  cd build\libui
  cmake -G "MinGW Makefiles" -DBUILD_SHARED_LIBS=OFF ..\..\libui
  mingw32-make -j 4 tester examples
  cd ..\..
)

gradlew build
