 pipeline {
    agent any
     	environment {
        MAVEN_HOME = tool('M3')
    }

	stages {
        stage('Git checkout') {
            steps {
               git credentialsId: 'GitHub', 
               url: 'https://github.com/krishu24/TestPdfProject-master-master.git'   
               }
        }
		stage('Maven Build'){
		steps{
		    sh '${MAVEN_HOME}/bin/mvn -B verify'
           }
			}
			
		stage('JunitTestResults') {
		steps{
	        junit '**/target/surefire-reports/TEST-*.xml'
              archiveArtifacts 'target/*.jar'
			  }
         }
}
}
