pipeline {
    agent any

 
    stages {
        stage('Stop Docker Container') {
            steps {
                sh 'sudo docker stop -t 1 mvcApp'
                sh 'sudo docker container rm $(docker container ls -aq)'
            }
        }
        stage('Build') {
            steps {
                sh 'sudo gradle wrapper --gradle-version 6.8.3 --distribution-type all'
                sh 'sudo ./gradlew assemble'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'sudo ./gradlew docker'
            }
        }
        stage('Push Docker image') {
            environment {
                registry = "=lynxbob/virtualx" 
                registryCredential = 'lynxbob' 
                dockerImage = '' 

            }
            steps {
                sh 'sudo ./gradlew dockerPush'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'sudo ./gradlew dockerRun'
            }
        }
    }
}