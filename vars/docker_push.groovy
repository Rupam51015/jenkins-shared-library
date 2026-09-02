def call(String credId, String imageName){
    withCredentials([usernamePassword(
        credentialsId: "${credId}",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
    sh "echo '${dockerHubPass}' | docker login -u '${dockerHubUser}' --password-stdin"
    sh "docker tag ${imageName}:latest ${env.dockerHubUser}/${imageName}"
    sh "docker push ${env.dockerHubUser}/${imageName}:latest"
    }
}