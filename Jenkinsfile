pipeline {
	agent any
	tools {
		maven 'MAVEN'
	}
	stages {
		stage('Download the git repo') {
			steps {
				checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/akshathkaushal/SPE-MiniProject.git']]])
			}
		}
		stage('Build and Test maven') {
			steps {
				script {
					sh 'mvn -Dmaven.test.failure.ignore=true clean package'
				}
			}
			post {
				success {
					junit '**/target/surefire-reports/TEST-*.xml'
					archiveArtifacts 'target/*.jar '
				}
			}
		}
		stage('Build docker image') {
			steps {
				script {
					sh 'docker build -t akshathkaushal7/spe-miniproject .'
				}
			}
		}
		stage('Push docker image to Dockerhub') {
			steps {
				script {
					withCredentials([string(credentialsId: 'a33b090a-d58b-4ebf-a74d-662f5ee612d7', variable: 'dockerhubpwd')]) {
						sh 'docker login -u akshathkaushal7 -p ${dockerhubpwd}'
						sh 'docker push akshathkaushal7/spe-miniproject'
					}
				}
			}
		}
		stage('Remove the local docker image') {
			steps {
				script {
					sh 'docker rmi akshathkaushal7/spe-miniproject'
				}
			}
		}
		stage('Deploy using Ansible') {
			steps {
				ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking:true, installation: 'ansibleenv', inventory: 'deploy-docker/inventory', playbook: 'deploy-docker/deploy-image.yml', sudoUser:null
			}
		}
	}
}
