def call(credentialId, userName, serverIp, warfileName,   ){
   sshagent([credentialId]) {
   for (serverIp in serverIps){
     // COPY WAR FILE TO TOMCAT
   sh "scp -o StrictHostKeyChecking=no target/${warfileName} ${userName}@${serverIp}:/opt/tomcat9/webapps"
   // Stop tomcat
   sh "ssh ${userName}@${serverIp} /opt/tomcat9/bin/shutdown.sh"
   // start tomcat
   sh "ssh ${userName}@${serverIp} /opt/tomcat9/bin/startup.sh"
 }

}


deployToTomcat("tomcat-dev", "ec2-user", "[172.31.13.20]", "doctor-online.war")
