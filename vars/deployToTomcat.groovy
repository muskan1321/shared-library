def call(credentialId, userName, serverIp, warfileName){
   sshagent([credentialId]) {
   for (ip in serverIps) {
    sshagent([credentialId]) {
        sh "scp -o StrictHostKeyChecking=no target/${warfileName} ${userName}@${ip}:/opt/tomcat9/webapps"
        sh "ssh ${userName}@${ip} /opt/tomcat9/bin/shutdown.sh"
        sh "ssh ${userName}@${ip} /opt/tomcat9/bin/startup.sh"
      }
  }
}

// Example usage of the call method
def serverIps = ['172.31.19.102']
def warFileName = 'doctor-online.war'
call("tomcat-dev", "ec2-user", serverIps, warFileName)
   






