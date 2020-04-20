pipeline {
    agent {
    docker {
        image 'maven:3-alpine'
         args '-v $HOME/.m2:/root/.m2'      
        }
    }
	stages
	{
        stage('Build ') {
            agent { dockerfile true } 
            steps {
                echo 'Hello, JDK'
                sh 'java -version'
                sh 'mvn -version'
            }
        }
    }
}
