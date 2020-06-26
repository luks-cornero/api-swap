node{
    stage('Compilacion'){
        checkout scm
        bat 'mvn clean compile'
    }
    
    stage('Test'){
       try{
        bat 'mvn verify'
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
       }catch(err) {
        step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
        if (currentBuild.result == 'UNSTABLE')
         currentBuild.result = 'FAILURE'
        throw err
        }
    }

   stage('Instalar'){
    bat 'mvn install -Dmaven.test.skip=true'
   }

   stage('Archivar'){
    step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
   }

    
}