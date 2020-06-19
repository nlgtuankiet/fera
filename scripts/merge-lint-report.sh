#!/bin/bash

mkdir -p ./build/reports/lint
find . -type f -regex ".*/build/reports/.*xml" -exec cp --parents {} ./build/reports/lint/ \;
./scripts/merge_report_files.rb ./build/reports/lint/ issue ./build/reports/lint/lint-report.xml