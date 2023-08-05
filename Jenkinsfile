#!groovy

pipeline {
  agent none 
  stages {
    stage('Build') {
      agent {
        docker {
          image 'maven:3.6.3-jdk-11'
        }
      }
      steps {
        sh 'mvn clean install'
      }
    }

    stage('Test') {
      agent {
        docker {
          image 'maven:3.6.3-jdk-11'
        }
      }
      steps {
        sh 'mvn test'
      }
    }

    stage('package') {
      agent any
      steps {
          sh 'docker image build -t gitlab.abidjan.lan:5050/moses/spring-actuator-test-main .'
      }
    }

    stage('Push Image') {
      agent any
      steps {
          sh 'docker image push gitlab.abidjan.lan:5050/moses/spring-actuator-test-main:latest'
      }
    }
    

    stage('Deploy') {
      agent any
      steps {
          sh 'docker container rm -f spring-actuator-test-staging || true'
          sh 'docker image pull gitlab.abidjan.lan:5050/moses/spring-actuator-test-main:latest'
          sh 'docker container run -d -p 30001:8093 --name spring-actuator-test-staging gitlab.abidjan.lan:5050/moses/spring-actuator-test-main:latest'
      }
    }  
  }
}