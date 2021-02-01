#!/usr/bin/env groovy

def call(Map inputArgs) {
    def args = [] << inputArgs

    pipeline {
        agent any

        stages {
            stage('Hello') {
                environment {
                    TEST_VALUE = "${args.testValue && args.testValue != 'null' ? args.testValue : 'World'}"
                }
                steps {
                    echo "Hello ${TEST_VALUE}"

                    dummyStep('World')
                }
            }
        }
    }
}
