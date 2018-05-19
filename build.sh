#!/usr/bin/env bash

if [[ ! -f build/libui/out/libui.a ]]; then
  git submodule update --init
  mkdir -p build/libui
  pushd build/libui
  cmake -G "Unix Makefiles" -DBUILD_SHARED_LIBS=OFF ../../libui
  make -j 4 tester examples
  popd
fi

./gradlew build
