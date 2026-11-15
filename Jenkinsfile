pipeline {
    agent any
    tools { maven 'Maven3'; jdk 'JDK21' }

    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Build') {
            steps { bat 'mvn -B clean compile' }
        }
        stage('Test') {
            steps { bat 'mvn -B test -Dmaven.test.failure.ignore=true' }
            post { always { junit 'target/surefire-reports/*.xml' } }
        }
        stage('Cobertura') {
            steps {
                recordCoverage(
                    tools: [[parser: 'JACOCO']],
                    sourceCodeRetention: 'EVERY_BUILD'
                )
            }
        }
    }
}