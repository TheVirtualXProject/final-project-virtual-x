pipeline {
    agent any

 
    stages {
        stage('Build') {
            steps {
                sh 'sudo gradle wrapper'
                sh 'sudo ./gradlew assemble'
            }
        }
        stage('Build Docker image') {
            steps {
                sh './gradlew docker'
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh './gradlew dockerPush'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh './gradlew dockerRun'
            }
        }
    }
}