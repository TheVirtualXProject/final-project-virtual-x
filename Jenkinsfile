pipeline {
    agent any

 
    stages {
        stage('Build') {
            steps {
                sh 'sudo gradle wrapper'
                sh 'sudo gradle assemble'
            }
        }
        stage('Build Docker image') {
            steps {
                sh 'sudo gradle docker'
            }
        }
        stage('Push Docker image') {
            environment {
                DOCKER_HUB_LOGIN = credentials('docker-hub')
            }
            steps {
                sh 'sudo docker login --username=$DOCKER_HUB_LOGIN_USR --password=$DOCKER_HUB_LOGIN_PSW'
                sh 'sudo gradle dockerPush'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'sudo gradle dockerRun'
            }
        }
    }
}