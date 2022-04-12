pipeline {
	agent any
	tools {
		maven 'MAVEN'
	}
	stages {
		stage('Build') {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/akshathkaushal/SPE-MiniProject.git']]])
				sh "mvn -Dmaven.test.failure.ignore=true clean package"
			}
			post {
				success {
					junit '**/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar'
				}
			}
		}
	}
	
}
