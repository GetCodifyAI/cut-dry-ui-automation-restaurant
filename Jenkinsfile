pipeline {
    agent any
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['uat', 'staging', 'prod'],
            description: 'Select the test environment'
        )
        string(
            name: 'TEST_STAG',
            defaultValue: 'dds-45',
            description: 'TEST_STAG parameter value'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
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
            agent { label 'built-in' }
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'devin/1757651232-jenkins-stag-sanity1-job']],
                    userRemoteConfigs: [[url: env.GIT_URL]]
                ])
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
        # Check available tools
        echo "Checking available tools..."
        java -version || echo "Java not found"
        mvn -version || echo "Maven not found"
        google-chrome --version || echo "Chrome not found"
        
        # Set JAVA_HOME if not set
        if [ -z "$JAVA_HOME" ]; then
            export JAVA_HOME=/usr/lib/jvm/default-java
        fi
        
        echo "Environment setup completed"
    '''
}

def runTestSuite(String suiteFile, String partName) {
    sh """
        mvn clean test \\
            -Dsurefire.suiteXmlFiles=${suiteFile} \\
            -Drun.headless=true \\
            -Dtest.env=${TEST_ENV} \\
            -DTEST_STAG=${TEST_STAG_VALUE}
    """
}
