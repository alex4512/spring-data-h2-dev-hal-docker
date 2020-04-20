pipeline {
    agent none 
    stages {
        stage('Example Build') {
            agent { docker 'maven:3-alpine' } 
            steps {
                echo 'Hello, Maven'
                sh 'mvn --version'
            }
        }
        stage('Example Test') {
            agent { dockerfile true } 
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
            }
        }
    }
}
