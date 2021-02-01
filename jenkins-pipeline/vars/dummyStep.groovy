#!/usr/bin/env groovy
import org.DummyStep

def call(String greet) {
    echo "Hello $greet from DummyStep script!"

    new DummyStep(this).greet(greet)
}
