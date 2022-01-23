#!/usr/bin/env groovy
import com.pig.Docker

def call() {
    return new Docker(this).dockerLogin()
}