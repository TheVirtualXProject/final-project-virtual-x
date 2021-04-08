pipeline {
    agent any

 
    stages {
        stage('Build') {
            steps {
                sh 'sudo gradle wrapper --gradle-version 6.8.3'
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
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'sudo docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
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