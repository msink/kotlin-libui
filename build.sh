#!/usr/bin/env bash

mkdir -p build/libui
pushd build/libui
cmake -G "Unix Makefiles" -DBUILD_SHARED_LIBS=OFF ../../libui
make tester examples
popd

./gradlew build
