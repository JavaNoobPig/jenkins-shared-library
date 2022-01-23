#!/usr/bin/env groovy

def call() {
	echo "building application for $BRANCH_NAME"
	sh 'mvn package'
}