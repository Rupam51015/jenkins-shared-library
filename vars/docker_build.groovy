def call(Map config = [:]){
    def imageTag = config.imageTag ?: 'latest',
    def imageName = config.imageName ?: error("Image Tag is required"),
    def fileName = config.fileName ?: 'Dockerfile',
    def context = config.context ?: '.'

    echo "${imageName}:${imageTag} Image is built"
    sh "docker build --no-cache -f ${fileName} -t ${imageName}:${imageTag} ${context}"
}