#!/usr/bin/env groovy

def call(Map inputArgs) {
    def args = [] << inputArgs

    pipeline {
        agent any

        stages {
            stage('Hello') {
                environment {
                    TEST_VALUE = "${args.testValue && args.testValue != 'null' ? args.testValue : 'Word'}"
                }
                steps {
                    echo "Hello ${env.TEST_VALUE}"
                }
            }
        }
    }
}
