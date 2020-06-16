#!/bin/bash

# TODO find a better method to version control ffmpeg source + binary

ffmpegSourceDir=$1

#eval "${ffmpegSourceDir}/android.sh ./android.sh -l"
jniLibsDir="app/src/main/jniLibs"

mkdir -p "${jniLibsDir}/armeabi-v7a"
cp "${ffmpegSourceDir}/prebuilt/android-arm/ffmpeg/bin/ffmpeg" "${jniLibsDir}/armeabi-v7a/libffmpeg.so"
cp "${ffmpegSourceDir}/prebuilt/android-arm/ffmpeg/bin/ffprobe" "${jniLibsDir}/armeabi-v7a/libffprobe.so"

mkdir -p "${jniLibsDir}/arm64-v8a"
cp "${ffmpegSourceDir}/prebuilt/android-arm64/ffmpeg/bin/ffmpeg" "${jniLibsDir}/arm64-v8a/libffmpeg.so"
cp "${ffmpegSourceDir}/prebuilt/android-arm64/ffmpeg/bin/ffprobe" "${jniLibsDir}/arm64-v8a/libffprobe.so"

mkdir -p "${jniLibsDir}/x86"
cp "${ffmpegSourceDir}/prebuilt/android-x86/ffmpeg/bin/ffmpeg" "${jniLibsDir}/x86/libffmpeg.so"
cp "${ffmpegSourceDir}/prebuilt/android-x86/ffmpeg/bin/ffprobe" "${jniLibsDir}/x86/libffprobe.so"

mkdir -p "${jniLibsDir}/x86_64"
cp "${ffmpegSourceDir}/prebuilt/android-x86_64/ffmpeg/bin/ffmpeg" "${jniLibsDir}/x86_64/libffmpeg.so"
cp "${ffmpegSourceDir}/prebuilt/android-x86_64/ffmpeg/bin/ffprobe" "${jniLibsDir}/x86_64/libffprobe.so"