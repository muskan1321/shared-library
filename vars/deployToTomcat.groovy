def call(credentialId, userName, ip, warfileName){
      sshagent([credentialId]) {
        sh "scp -o StrictHostKeyChecking=no target/${warfileName}.war ${userName}@${ip}:/opt/tomcat9/webapps"
        sh "ssh ${userName}@${ip} /opt/tomcat9/bin/shutdown.sh"
        sh "ssh ${userName}@${ip} /opt/tomcat9/bin/startup.sh"
      }
  
}






