node{

    stage('Compilacion'){

        bat "echo Hacemos la compilacion"

        bat 'mvn clean compile'
    }
    
    stage('Test'){
       try{
            bat "echo Ejecutamos los tests"

            bat 'mvn verify'

            //Guardo los resultados de los test
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

    stage('Instalacion'){
        
        bat "echo Hacemos la instalacion"

        bat 'mvn install -Dmaven.test.skip=true'
   }

    stage('Archivar'){
        
        bat "echo Archivamos el jar"
        
        step([$class: 'ArtifactArchiver', artifacts: '**/target/*.jar, **/target/*.war', fingerprint: true])
   }
   
}