pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
			args '-p 8091:8091 -p 8092:8092 -p 50000:50000'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
	    
	    
        stage('Deploy - Staging') {
            steps {
                sh './jenkins/scripts/deliver.sh'
		
            }
        }
    }
}
