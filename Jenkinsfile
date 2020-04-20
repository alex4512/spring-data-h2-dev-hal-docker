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
         sh 'ls -a'
      }
    }

  }
}
