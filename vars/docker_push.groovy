def call(String CredentialsId, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: "${CredentialsId}",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
        echo "Logging into Docker Hub..."
        sh "echo '${dockerHubPass}' | docker login -u '${dockerHubUser}' --password-stdin"
        
        echo "Tagging local image [ ${imageName}:latest ] to match registry namespace..."
        sh "docker tag ${imageName}:latest ${dockerHubUser}/${imageName}:latest"
        
        echo "Pushing image to Docker Hub repository..."
        sh "docker push ${dockerHubUser}/${imageName}:latest"
    }
}
