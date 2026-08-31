def call(){
    emailext from: 'rumapdebnath75@gmail.com',
        subject: "Build Failed: Job '${env.JOB_NAME}' [Build #${env.BUILD_NUMBER}]",
        body: "Check the logs at: ${env.BUILD_URL}",
        to: 'rumapdebnath75@gmail.com'
}