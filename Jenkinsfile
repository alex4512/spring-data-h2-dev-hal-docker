pipeline {
    agent {
    docker {
        image 'maven:3-alpine'
         args '-v $HOME/.m2:/root/.m2'
	 image 'openjdk:8-jdk-alpine'
        }
    }
	stages
	{
        stage('Clean') {
			steps {
				sh 'mvn clean'
			}
        }
		stage('Build & Test') {
			steps {
				sh 'mvn clean install'
			}
		}
		stage('Deploy to test')	{
	
			steps {
				sh 'java -version'
				sh 'ls -a'
			}
		}
    }
}
