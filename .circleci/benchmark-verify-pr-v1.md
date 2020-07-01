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
  compare-apk:
    executor: android_executor
    steps:
      - init
      - run:
          name: Build release apk
          command: sh ./scripts/build_release_apk.sh
          no_output_timeout: 10m
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
  lint:
    executor: android_executor
    steps:
      - init
      - run:
          name: Lint
          command: ./gradlew :app:lintDebug
          no_output_timeout: 10m
      - run:
          name: Danger lint
          command: bundle install && bundle exec danger --new-comment --dangerfile=lint.danger
      - store_artifacts:
          path: app/build/reports/lint-results-debug.html
          destination: app-lint-results-debug.html
      - store_artifacts:
          path: core/build/reports/lint-results-debug.html
          destination: core-lint-results-debug.html
      - store_artifacts:
          path: home/build/reports/lint-results-debug.html
          destination: home-lint-results-debug.html
  test-spotless:
    executor: android_executor
    steps:
      - init
      - run:
          name: Test spotless
          command: ./gradlew testDebugUnitTest spotlessCheck
          no_output_timeout: 10m
  dynamic-build:
    executor: android_executor
    steps:
      - init
      - run:
          name: Dynamic build include all modules
          command: ./gradlew :app:bundleDebug -Pdynamic
          no_output_timeout: 10m
      - run:
          name: Dynamic build exclude all modules
          command: ./gradlew :app:bundleDebug -Pdynamic -Pexclude=".*"
          no_output_timeout: 10m

workflows:
  version: 2
  benchmark-verify-pull-request-v6:
    triggers:
      - schedule:
          cron: "0,10,20,30,40,50 * * * *"
          filters:
            branches:
              only:
                - benchmark
    jobs:
      - compare-apk:
          filters:
            branches:
              ignore:
                - master
      - lint:
          filters:
            branches:
              ignore:
                - master
      - test-spotless:
          filters:
            branches:
              ignore:
                - master
      - dynamic-build:
          filters:
            branches:
              ignore:
                - master

```

```
timeTp95: 190.0 seconds (3.17 minutes)
timeMin: 168 seconds (2.80 minutes)
timeMax: 2034 seconds (33.90 minutes)
timeAverage: 262.75580221997984 seconds (4.38 minutes)

creditTp95: 96.5
creditMin: 80
creditMax: 443
creditAverage: 110.63168516649849

success rate: 95.84%
total: 1034
total success : 991
total fail : 43
```