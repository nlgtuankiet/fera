#!/bin/bash

# TODO find a better method to version control ffmpeg source + binary

copySo() {
  # $1 ffmpegSourceDir
  # $2 arch folder
  # $3 des arch folder
  archFolder=$2
  desArchFolder=$3
  find "${ffmpegSourceDir}/prebuilt/${archFolder}/" -type f -name "*.so" -exec cp {}  "data/src/main/jniLibs/${desArchFolder}" \;
}

copyFfmpeg() {
  ffmpegSourceDir=$1
  #eval "${ffmpegSourceDir}/android.sh ./android.sh -l"
  jniLibsDir="data/src/main/jniLibs"
  echo "copy ffmpeg from $1 to $jniLibsDir"

  mkdir -p "${jniLibsDir}/armeabi-v7a"
  cp "${ffmpegSourceDir}/prebuilt/android-arm/ffmpeg/bin/ffmpeg" "${jniLibsDir}/armeabi-v7a/libffmpeg.so"
  cp "${ffmpegSourceDir}/prebuilt/android-arm/ffmpeg/bin/ffprobe" "${jniLibsDir}/armeabi-v7a/libffprobe.so"
  rm -rf "${ffmpegSourceDir}/prebuilt/android-arm/neon"
  copySo "$ffmpegSourceDir" "android-arm" "armeabi-v7a"
  cp "${ffmpegSourceDir}/android/libs/armeabi-v7a/libcpufeatures.so" "${jniLibsDir}/armeabi-v7a/libcpufeatures.so"

  mkdir -p "${jniLibsDir}/arm64-v8a"
  cp "${ffmpegSourceDir}/prebuilt/android-arm64/ffmpeg/bin/ffmpeg" "${jniLibsDir}/arm64-v8a/libffmpeg.so"
  cp "${ffmpegSourceDir}/prebuilt/android-arm64/ffmpeg/bin/ffprobe" "${jniLibsDir}/arm64-v8a/libffprobe.so"
  copySo "$ffmpegSourceDir" "android-arm64" "arm64-v8a"
  cp "${ffmpegSourceDir}/android/libs/arm64-v8a/libcpufeatures.so" "${jniLibsDir}/arm64-v8a/libcpufeatures.so"

  mkdir -p "${jniLibsDir}/x86"
  cp "${ffmpegSourceDir}/prebuilt/android-x86/ffmpeg/bin/ffmpeg" "${jniLibsDir}/x86/libffmpeg.so"
  cp "${ffmpegSourceDir}/prebuilt/android-x86/ffmpeg/bin/ffprobe" "${jniLibsDir}/x86/libffprobe.so"
  copySo "$ffmpegSourceDir" "android-x86" "x86"
  cp "${ffmpegSourceDir}/android/libs/x86/libcpufeatures.so" "${jniLibsDir}/x86/libcpufeatures.so"

  mkdir -p "${jniLibsDir}/x86_64"
  cp "${ffmpegSourceDir}/prebuilt/android-x86_64/ffmpeg/bin/ffmpeg" "${jniLibsDir}/x86_64/libffmpeg.so"
  cp "${ffmpegSourceDir}/prebuilt/android-x86_64/ffmpeg/bin/ffprobe" "${jniLibsDir}/x86_64/libffprobe.so"
  copySo "$ffmpegSourceDir" "android-x86_64" "x86_64"
  cp "${ffmpegSourceDir}/android/libs/x86_64/libcpufeatures.so" "${jniLibsDir}/x86_64/libcpufeatures.so"

  ls -lha data/src/main/jniLibs/arm64-v8a
}

$1 $2

