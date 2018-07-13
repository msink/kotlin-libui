@echo off

if not exist libui-ktx\build\libui\out\libui.a (
  set "PATH=C:\msys64\mingw64\bin;%PATH%"
  git submodule update --init
  md libui-ktx\build\libui
  cd libui-ktx\build\libui
  cmake -G "MinGW Makefiles" -DBUILD_SHARED_LIBS=OFF ..\..\..\libui
  mingw32-make -j 4 tester examples
  cd ..\..\..
)

gradlew build
