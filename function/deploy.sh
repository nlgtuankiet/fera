#!/bin/bash
set -e

gradle :function:shadowJar

gcloud functions deploy uploadApk \
    --runtime java11 \
    --allow-unauthenticated \
    --trigger-http \
    --entry-point com.nlgtuankiet.fera.function.UploadApk \
    --set-env-vars=FERA_AED_SA_B64="$FERA_AED_SA_B64" \
    --source function/build/libs
