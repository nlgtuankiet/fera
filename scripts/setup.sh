#!/bin/bash
set -e
source ./scripts/copy_ffmpeg.sh

systemInfo() {
  echo "check system info"

  if lscpu; then
    lscpu
  else
    echo lscpu not exits
  fi

  if cat /proc/meminfo; then
    cat /proc/meminfo
  else
    echo "/proc/meminfo not exits"
  fi

  echo "check ram"
  cat /sys/fs/cgroup/memory/memory.usage_in_bytes
}

setupMvRx() {
  echo "setup mvrx"
  mkdir -p ~/.m2/repository/com/airbnb/android/mvrx

  wget https://storage.googleapis.com/fera-verto.appspot.com/m2/mvrx.zip \
    -O ~/.m2/repository/com/airbnb/android/mvrx.zip

  unzip ~/.m2/repository/com/airbnb/android/mvrx.zip -d ~/.m2/repository/com/airbnb/android/mvrx
}

setupCiGradleProperty() {
  # TODO only copy on ci
  echo "setup ci gradle property"
  echo "copy .circleci/gradle.properties to ~/.gradle/gradle.properties"
  mkdir -p ~/.gradle/
  cp .circleci/gradle.properties ~/.gradle/gradle.properties
}

setupFfmpeg() {
  echo "setup ffmpeg"
  mkdir -p ../mobile-ffmpeg/prebuilt/

  wget https://storage.googleapis.com/fera-verto.appspot.com/ffmpeg/prebuilt1.zip \
    -O ../mobile-ffmpeg/prebuilt.zip

  unzip ../mobile-ffmpeg/prebuilt.zip -d ../mobile-ffmpeg/
  ls -lha ../mobile-ffmpeg/prebuilt/

  copyFfmpeg "../mobile-ffmpeg"
}

setupGcloud() {
  echo "$FERA_CI_SA_B64" | base64 -d >> ci_sa.json
  gcloud auth activate-service-account --key-file=ci_sa.json
}

systemInfo
setupMvRx
setupCiGradleProperty
setupFfmpeg
setupGcloud
