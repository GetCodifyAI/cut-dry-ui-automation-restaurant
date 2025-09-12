pipeline {
    agent any
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['stag', 'uat', 'staging', 'prod'],
            description: 'Select the test environment'
        )
        string(
            name: 'TEST_STAG',
            defaultValue: 'mfg2640',
            description: 'TEST_STAG parameter value (used when environment is stag)'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '${WORKSPACE}/tools/java/java-22-openjdk-amd64'
        TEST_ENV = "${params.TEST_ENVIRONMENT}"
        RUN_HEADLESS = 'true'
        BROWSER_VERSION = 'latest'
        TEST_STAG_VALUE = "${params.TEST_STAG}"
    }
    
    stages {
        stage('Setup Environment') {
            steps {
                script {
                    setupEnvironment()
                }
            }
        }
        
        stage('Sanity Tests - stag_sanity1') {
            steps {
                script {
                    runTestSuite('stag_sanity1.xml', 'Sanity_Check')
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                    stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-sanity'
                }
            }
        }
        
        stage('Aggregate Results') {
            steps {
                script {
                    unstash 'test-results-sanity'
                    publishTestResults testResultsPattern: 'target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
        success {
            echo 'Sanity tests completed successfully!'
        }
        failure {
            echo 'Sanity tests failed!'
        }
    }
}

def setupEnvironment() {
    sh '''
        # Create workspace directories
        mkdir -p $WORKSPACE/tools/java
        mkdir -p $WORKSPACE/tools/maven
        
        # Install Java 22 in workspace
        echo "Installing Java 22 in workspace..."
        wget -O /tmp/openjdk-22_linux-x64_bin.tar.gz https://download.java.net/java/GA/jdk22.0.1/c7ec1332f7bb44aeba2eb341ae18aca4/8/GPL/openjdk-22.0.1_linux-x64_bin.tar.gz
        tar -xzf /tmp/openjdk-22_linux-x64_bin.tar.gz -C $WORKSPACE/tools/java/
        mv $WORKSPACE/tools/java/jdk-22.0.1 $WORKSPACE/tools/java/java-22-openjdk-amd64
        
        # Install Maven in workspace
        echo "Installing Maven in workspace..."
        wget -O /tmp/apache-maven-3.8.7-bin.tar.gz https://archive.apache.org/dist/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz
        tar -xzf /tmp/apache-maven-3.8.7-bin.tar.gz -C $WORKSPACE/tools/maven/
        mv $WORKSPACE/tools/maven/apache-maven-3.8.7 $WORKSPACE/tools/maven/maven
        
        # Set environment variables for workspace tools
        export JAVA_HOME=$WORKSPACE/tools/java/java-22-openjdk-amd64
        export PATH=$JAVA_HOME/bin:$PATH
        export MAVEN_HOME=$WORKSPACE/tools/maven/maven
        export PATH=$MAVEN_HOME/bin:$PATH
        
        # Verify installations
        echo "Verifying installations..."
        java -version
        mvn -version
        
        echo "Environment setup completed"
    '''
}

def runTestSuite(String suiteFile, String partName) {
    sh """
        export JAVA_HOME=\$WORKSPACE/tools/java/java-22-openjdk-amd64
        export PATH=\$JAVA_HOME/bin:\$PATH
        export MAVEN_HOME=\$WORKSPACE/tools/maven/maven
        export PATH=\$MAVEN_HOME/bin:\$PATH
        
        mvn clean test \\
            -Dsurefire.suiteXmlFiles=${suiteFile} \\
            -Drun.headless=true \\
            -Dtest.env=${TEST_ENV} \\
            -DTEST_STAG=${TEST_STAG_VALUE} \\
            -Dcreate.cycle=true \\
            -Dpart=${partName}
    """
}
