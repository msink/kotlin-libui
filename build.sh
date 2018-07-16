#!/usr/bin/env bash

if [[ ! -f libui/build/out/libui.a ]]; then
  git submodule update --init
  mkdir -p libui/build
  pushd libui/build
  cmake -G "Unix Makefiles" -DBUILD_SHARED_LIBS=OFF ../src
  make -j 4 tester examples
  popd
fi

./gradlew build
