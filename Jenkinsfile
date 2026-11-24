pipeline {
    agent any

    stages {

        stage('Verificar herramientas') {
            steps {
                bat 'java -version'
                bat 'mvn -version'
                bat 'docker --version'
            }
        }

        stage('Compilar proyecto') {
            steps {
                bat 'mvn -B clean package'
            }
        }

        stage('Construir imagen Docker') {
            steps {
                bat 'docker build -t moda-urbana-app:jenkins .'
            }
        }
    }

    post {
        success {
            echo 'MODA URBANA: Integracion continua exitosa.'
        }

        failure {
            echo 'MODA URBANA: Se produjo un error en el Pipeline.'
        }
    }
}

