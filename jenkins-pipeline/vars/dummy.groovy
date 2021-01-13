#!/usr/bin/env groovy

import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def call() {
    echo('hello')
}
