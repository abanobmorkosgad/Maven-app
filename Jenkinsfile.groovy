pipeline{
    agent any
    tools{
        maven "Maven-3.9"
    }
    stages{
        stage("build jar"){
            steps {
                script{
                    echo "building the app..."
                    sh "mvn package"
                }
            }
        }
        stage("build image"){
            steps {
                script{
                    echo "building docker image..."
                    withCredentials([usernamePassword(credentialsId: "Docker-cred", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t abanobmorkos10/myrepo:2.0 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push abanobmorkos10/myrepo:2.0"
                    }
                }
            }
        }
        stage("deploy"){
            steps{
                script{
                    echo "deploying "
                }
            }
        }
    }
}