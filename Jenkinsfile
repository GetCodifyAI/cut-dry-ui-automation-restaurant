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
                    branches: [[name: 'sanity_check_suite']],
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
        # Install Java 21
        sudo apt-get update && sudo apt-get install -y wget
        if [ ! -d "/usr/lib/jvm/java-21-openjdk-amd64" ]; then
            sudo apt-get install -y openjdk-21-jdk
        fi
        
        # Install Maven
        if ! command -v mvn &> /dev/null; then
            sudo apt-get install -y maven
        fi
        
        # Install Chrome
        if ! command -v google-chrome &> /dev/null; then
            wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
            sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
            sudo apt-get update
            sudo apt-get install -y google-chrome-stable
        fi
        
        java -version
        mvn -version
        google-chrome --version
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
