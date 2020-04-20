Pipelines
Executors
Administration
Logout
Cancel
Clean & BuildRunStart
Pipeline Settings
Agent
docker
Image*
maven:3-alpine
Args
-v $HOME/.m2:/root/.m2
Environment
Name	Value	
Pipeline Script
pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/.m2:/root/.m2'
    }

  }
  stages {
    stage('Clean & Build') {
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Run') {
      steps {
        dockerNode(image: 'openjdk:8-jdk-alpine') {
          sh 'java -version'
	  sh 'ls -a'
        }

      }
    }

  }
}
