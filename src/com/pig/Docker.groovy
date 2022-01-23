#!/usr/bin/env groovy
package com.pig

class Docker implements Serializable {
	
	def script
	
	Docker(script) {
		this.script=script
	}
	
	def buildDockerImage(String imageName) {
		script.echo 'building the docker image... from Docker groovy'
		script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS' , usernameVariable: 'USER')]){
			script.sh "docker build -t $imageName ."
		}
	}
	
	def dockerLogin() {
		script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS' , usernameVariable: 'USER')]){
			script.echo 'Login docker hub... from Docker groovy'
			script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin "
		}
	}
	
	def pushImage(String imageName) {
		script.echo 'pushing docker image from Docker groovy'
		script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS' , usernameVariable: 'USER')]){
			script.sh "docker push $imageName"
		}
	}
}