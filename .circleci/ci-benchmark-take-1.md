Config
```yml
version: 2.1

executors:
  android_executor:
    docker:
      - image: circleci/android:api-29
    working_directory: ~/fera

commands:
  init:
    description: "Initialize project"
    steps:
      - checkout
      - run:
          name: Initialize
          command: bash ./scripts/setup.sh

jobs:
  verify-pull-request:
    executor: android_executor
    steps:
      - init
      - run:
          name: Build release apk
          command: sh ./scripts/build_release_apk.sh
          no_output_timeout: 25m
      - run:
          name: Download master apk
          command: bash ./scripts/download_master_apk.sh
      - store_artifacts:
          path: build/universal.apk
          destination: universal.apk
      - store_artifacts:
          path: build/master.apk
          destination: master.apk
      - run:
          name: Danger apk compare
          command: bundle install && bundle exec danger --new-comment --dangerfile=compare-apk.danger
      - run:
          name: Lint test spotless
          command: ./gradlew testDebugUnitTest lintDebug spotlessCheck
          no_output_timeout: 25m
      - run:
          name: Danger lint
          command: bundle exec danger --new-comment --dangerfile=lint.danger
      - store_artifacts:
          path: app/build/reports/lint-results-debug.html
          destination: app-lint-results-debug.html
      - store_artifacts:
          path: core/build/reports/lint-results-debug.html
          destination: core-lint-results-debug.html
      - store_artifacts:
          path: home/build/reports/lint-results-debug.html
          destination: home-lint-results-debug.html
      - run:
          name: Dynamic build include all modules
          command: ./gradlew :app:bundleDebug -Pdynamic --offline
          no_output_timeout: 25m
      - run:
          name: Dynamic build exclude all modules
          command: ./gradlew :app:bundleDebug -Pdynamic -Pexclude=".*" --offline
          no_output_timeout: 25m
  upload-apk:
    executor: android_executor
    steps:
      - checkout
      - run:
          name: Initialize
          command: bash ./scripts/setup.sh
      - run:
          name: Build release apk
          command: sh ./scripts/build_release_apk.sh
          no_output_timeout: 30m
      - run:
          name: Upload apk
          command: bash ./scripts/upload_master_apk.sh
      - store_artifacts:
          path: ./build/universal.apk
          destination: universal.apk

workflows:
  version: 2
  pull-request-flow:
    jobs:
      - verify-pull-request:
          filters:
            branches:
              ignore:
                - master

  master-flow:
    jobs:
      - upload-apk:
          filters:
            branches:
              only:
                - master
  benchmark-verify-pull-request-v3:
    triggers:
      - schedule:
          cron: "0,10,20,30,40,50 * * * *"
          filters:
            branches:
              only:
                - benchmark
    jobs:
      - verify-pull-request
```

Result:
```
gradle :function:run --args="insightOf benchmark-verify-pull-request-v3 benchmark"

--- time
timeTp95: 421.5 seconds (7.03 minutes)
timeMin: 236 seconds (3.93 minutes)
timeMax: 738 seconds (12.30 minutes)
timeAverage: 427.32 seconds (7.12 minutes)
---

--- credit
creditTp95: 70.5
creditMin: 39
creditMax: 123
creditAverage: 70.216
---

--- stats
success rate: 97.66%
total: 128
total success : 125
total fail : 3
---
```
