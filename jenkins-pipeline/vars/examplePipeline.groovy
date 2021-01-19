#!/usr/bin/env groovy
import org.Helper

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
                    script {
                        echo Helper.staticMethod()

                        echo new Helper().instanceMethod()
                    }

                    echo "Hello ${TEST_VALUE}"
                }
            }
        }
    }
}
