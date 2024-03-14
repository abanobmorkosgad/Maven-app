pipeline {
    agent any
    tools {
        maven "Maven-3.9"
    }
    stages {
        stage("test") {
            steps {
                script {
                    echo "testing..."
                    echo "executing pipe for $BRANCH_NAME"
                }
            }
        }
        stage("build image") {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    echo "building..."
                }
            }
        }
        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    echo "deploying "
                }
            }
        }
    }
}
