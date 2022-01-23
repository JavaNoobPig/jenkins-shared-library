#!/usr/bin/env groovy
import com.pig.Docker

def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)
}