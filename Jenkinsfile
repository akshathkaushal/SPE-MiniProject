pipeline {
	agent any
	tools {
		maven 'maven-3.6.3'
	}
	stages {
		stage(Build) {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/akshathkaushal/SPE-MiniProject.git']]])
				sh "mvn -Dmaven.test.failure.ignore=true clean package"
			}
		}
	}
}
