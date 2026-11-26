pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Verificar Docker') {
            steps {
                bat 'docker --version'
                bat 'docker compose version'
            }
        }
        stage('Build (container 1)') {
            steps {
                bat 'docker compose -f docker-compose.build.yml up --force-recreate --exit-code-from build --no-color'
            }
        }
        stage('Test (container 2)') {
            steps {
                bat 'docker compose -f docker-compose.test.yml up --force-recreate --exit-code-from test --no-color'
            }
            post {
                always { junit 'target/surefire-reports/*.xml' }
            }
        }
    }
    post {
        always {
            bat 'docker ps -a --filter "name=conversor-" --format "{{.Names}} - {{.Status}}"'
        }
    }
}