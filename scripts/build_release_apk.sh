#!/bin/bash

# build universal apk from app bundle to ./build/universal.apk

buildBundle() {
  ./gradlew bundleRelease
}

extractApk() {
  if test -f "bundletool.jar"; then
    echo "bundletool.jar exists."
  else
    # https://github.com/google/bundletool
    # download bundle tool
    bundleToolVersion=0.13.4
    bundleToolUrl=https://github.com/google/bundletool/releases/download/$bundleToolVersion/bundletool-all.jar
    wget $bundleToolUrl -O bundletool.jar
  fi

  # create universal apk at ./universal.apk
  java -jar bundletool.jar build-apks \
    --bundle "./app/build/outputs/bundle/release/app-release.aab" \
    --output "./app.apks" \
    --mode=universal \
    --overwrite \
    --ks="./.circleci/keystore.jks" \
    --ks-pass=pass:"123456" \
    --ks-key-alias="DEFAULT" \
    --key-pass=pass:"123456"

  # unzip apk to: ./universal.apk
  unzip -o "./app.apks" -d "./"
  mv ./universal.apk ./build/universal.apk
  ls -l ./build/universal.apk
}
pwd
ls -lha
buildBundle && extractApk
