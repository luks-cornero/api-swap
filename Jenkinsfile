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
 /*
    currentBuild: Hace referencia a la compilación actualmente en ejecución. 
    currentBuild.result: normalmente SUCCESS, UNSTABLE o FAILURE ( puede ser nulo para una compilación en curso)
*/
            if (currentBuild.result == 'UNSTABLE')
                currentBuild.result = 'FAILURE'
            
            throw err
        }
    }

    stage('Instalar'){
        bat "echo Estamos haciendo la instalacion"
        bat 'mvn install -Dmaven.test.skip=true'
   }

    stage('Archivar'){
        bat "echo Vamos a archivar el jar"
        step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
   }

    
}