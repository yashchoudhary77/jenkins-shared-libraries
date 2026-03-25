def call(String Project, String ImageTag, String DockerHubUser){
  withCredentials([usernamePassword(
      credentialsId: 'DockerHubCred',
      passwordVariable: 'DOCKER_PASS',
      usernameVariable: 'DOCKER_USER'
  )]) {
      sh "echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin"
      sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
  }
}
