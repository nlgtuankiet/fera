#!/bin/bash

run() {
  masterCommit=$(git log -n 1 --pretty=format:%H HEAD~0)
  gsutil cp ./build/universal.apk "gs://nlgtuankiet-fera/apk/$masterCommit.apk"
}

run
