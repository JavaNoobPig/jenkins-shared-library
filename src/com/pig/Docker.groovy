#!/usr/bin/env groovy
package com.pig

class Docker implements Serializable {
	
	def script
	
	Docker(script) {
		this.script=script
	}
	
	def buildAndPishImage(String imageName) {
		script.echo 'building the docker image...And...Push from Docker groovy'
		script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS' , usernameVariable: 'USER')]){
			script.sh "docker build -t $imageName ."
			script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin "
			script.sh "docker push $imageName"
		}
	}
}