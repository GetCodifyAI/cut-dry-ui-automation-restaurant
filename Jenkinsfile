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
            defaultValue: 'mfg2640',
            description: 'TEST_STAG parameter value'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-22-openjdk-amd64'
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
        # Install Java 22
        echo "Installing Java 22..."
        wget -O /tmp/openjdk-22_linux-x64_bin.tar.gz https://download.java.net/java/GA/jdk22.0.1/c7ec1332f7bb44aeba2eb341ae18aca4/8/GPL/openjdk-22.0.1_linux-x64_bin.tar.gz
        tar -xzf /tmp/openjdk-22_linux-x64_bin.tar.gz -C /tmp/
        mkdir -p /usr/lib/jvm/
        mv /tmp/jdk-22.0.1 /usr/lib/jvm/java-22-openjdk-amd64
        update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-22-openjdk-amd64/bin/java 1
        update-alternatives --install /usr/bin/javac javac /usr/lib/jvm/java-22-openjdk-amd64/bin/javac 1
        
        # Install Maven
        echo "Installing Maven..."
        wget -O /tmp/apache-maven-3.8.7-bin.tar.gz https://archive.apache.org/dist/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz
        tar -xzf /tmp/apache-maven-3.8.7-bin.tar.gz -C /tmp/
        mv /tmp/apache-maven-3.8.7 /opt/maven
        ln -sf /opt/maven/bin/mvn /usr/bin/mvn
        
        # Install Chrome
        echo "Installing Chrome..."
        wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add -
        echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list
        apt-get update
        apt-get install -y google-chrome-stable
        
        # Set environment variables
        export JAVA_HOME=/usr/lib/jvm/java-22-openjdk-amd64
        export PATH=$JAVA_HOME/bin:$PATH
        export MAVEN_HOME=/opt/maven
        export PATH=$MAVEN_HOME/bin:$PATH
        
        # Verify installations
        echo "Verifying installations..."
        java -version
        mvn -version
        google-chrome --version
        
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
