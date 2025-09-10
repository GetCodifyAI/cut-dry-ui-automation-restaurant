pipeline {
    agent { label 'built-in' }
    
    options {
        timeout(time: 4, unit: 'HOURS')
        parallelsAlwaysFailFast()
        buildDiscarder(logRotator(numToKeepStr: '10'))
        skipDefaultCheckout()
    }
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['uat', 'staging', 'prod'],
            description: 'Target environment for testing'
        )
        booleanParam(
            name: 'RUN_SMOKE_ONLY',
            defaultValue: false,
            description: 'Run only smoke tests'
        )
        string(
            name: 'REGRESSION_SUITES',
            defaultValue: '1,2,3,4,5,6,7,8,9,10,11',
            description: 'Comma-separated list of regression suite numbers'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-22-openjdk-amd64'
        TEST_ENV = "${params.TEST_ENVIRONMENT}"
        RUN_HEADLESS = 'true'
        BROWSER_VERSION = 'latest'
    }
    
    triggers {
        // Nightly tests: Monday-Friday at 22:00 UTC (6:00 PM EST)
        // Daily tests: Monday-Friday at 04:00 UTC (12:00 AM EST)  
        cron('H 22 * * 1-5\nH 4 * * 1-5')
    }
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Environment Setup') {
            steps {
                script {
                    setupEnvironment()
                }
            }
        }
        
        stage('Parallel Regression Tests') {
            parallel {
                stage('Regression 1 - Order Guide Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression1.xml', 'Part_One')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-1'
                        }
                    }
                }
                
                stage('Regression 2 - Catalog Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression2.xml', 'Part_Two')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-2'
                        }
                    }
                }
                
                stage('Regression 3 - Payment Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression3.xml', 'Part_Three')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-3'
                        }
                    }
                }
                
                stage('Regression 4 - History Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression4.xml', 'Part_Four')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-4'
                        }
                    }
                }
                
                stage('Regression 5 - Settings Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression5.xml', 'Part_Five')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-5'
                        }
                    }
                }
                
                stage('Regression 6 - Credit Requests Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression6.xml', 'Part_Six')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-6'
                        }
                    }
                }
                
                stage('Regression 7 - Reports Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression7.xml', 'Part_Seven')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-7'
                        }
                    }
                }
                
                stage('Regression 8 - Role Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression8.xml', 'Part_Eight')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-8'
                        }
                    }
                }
                
                stage('Regression 9 - Additional Role Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression9.xml', 'Part_Nine')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-9'
                        }
                    }
                }
                
                stage('Regression 10 - Extended Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression10.xml', 'Part_Ten')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-10'
                        }
                    }
                }
                
                stage('Regression 11 - Multi-UOM Tests') {
                    agent { label 'built-in' }
                    steps {
                        script {
                            runTestSuite('regression11.xml', 'Part_Eleven')
                        }
                    }
                    post {
                        always {
                            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                            stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-11'
                        }
                    }
                }
            }
        }
        
        stage('Aggregate Test Results') {
            steps {
                script {
                    aggregateTestResults()
                }
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'target/surefire-reports/TEST-*.xml'
                    archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
                }
            }
        }
        
        stage('Calculate Pass/Fail Rate') {
            steps {
                script {
                    calculatePassFailRate()
                }
            }
        }
    }
    
    post {
        always {
            script {
                sendSlackNotification(currentBuild.result ?: 'SUCCESS')
            }
        }
        failure {
            script {
                createJiraIssue()
            }
        }
    }
}

// Helper function to set up the test environment
def setupEnvironment() {
    echo "Setting up test environment..."
    
    // Install Java 22
    sh '''
        sudo apt-get update && sudo apt-get install -y wget
        if [ ! -d "/usr/lib/jvm/java-22-openjdk-amd64" ]; then
            wget https://download.java.net/java/GA/jdk22/830ec9fcccef480bb3e73fb7ecafe059/36/GPL/openjdk-22_linux-x64_bin.tar.gz
            sudo mkdir -p /usr/lib/jvm
            sudo tar zxvf openjdk-22_linux-x64_bin.tar.gz -C /usr/lib/jvm
            sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-22/bin/java 2200
        fi
        java -version
    '''
    
    // Install Maven
    sh '''
        sudo apt-get install -y maven
        mvn -version
    '''
    
    // Install Chrome
    sh '''
        wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | sudo apt-key add -
        sudo sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list'
        sudo apt-get update
        sudo apt-get install -y google-chrome-stable
        google-chrome --version
    '''
    
    echo "Environment setup completed successfully"
}

// Helper function to run a test suite
def runTestSuite(String suiteXml, String partName) {
    echo "Running test suite: ${suiteXml} (${partName})"
    
    try {
        sh """
            mvn clean test \\
                -Dsurefire.suiteXmlFiles=${suiteXml} \\
                -Drun.headless=${env.RUN_HEADLESS} \\
                -Dtest.env=${env.TEST_ENV} \\
                || true
        """
        
        // Verify test results exist
        sh 'ls -R target/surefire-reports || echo "Test results missing for ${partName}!"'
        
        // Copy test results with part name prefix
        sh """
            mkdir -p ~/workspace
            for file in target/surefire-reports/TEST-*.xml; do
                [ -f "\$file" ] && cp "\$file" ~/workspace/${partName}_\$(basename "\$file")
            done
        """
        
    } catch (Exception e) {
        echo "Test suite ${suiteXml} failed with error: ${e.getMessage()}"
        currentBuild.result = 'UNSTABLE'
    }
}

// Helper function to aggregate test results from all parallel stages
def aggregateTestResults() {
    echo "Aggregating test results from all parallel stages..."
    
    // Unstash all test results
    for (int i = 1; i <= 11; i++) {
        try {
            unstash "test-results-${i}"
            echo "Successfully unstashed test-results-${i}"
        } catch (Exception e) {
            echo "Failed to unstash test-results-${i}: ${e.getMessage()}"
        }
    }
    
    // Combine all test results
    sh '''
        mkdir -p target/surefire-reports
        find . -name "TEST-*.xml" -not -path "./target/*" -exec cp {} target/surefire-reports/ \\;
        echo "Combined test results:"
        ls -la target/surefire-reports/
    '''
}

// Helper function to calculate pass/fail rate
def calculatePassFailRate() {
    echo "Calculating pass/fail rate..."
    
    script {
        def testResults = [:]
        
        try {
            // Parse test results
            def testResultFiles = sh(
                script: 'find target/surefire-reports -name "TEST-*.xml" | wc -l',
                returnStdout: true
            ).trim()
            
            def totalTests = sh(
                script: 'grep -h "tests=" target/surefire-reports/TEST-*.xml | sed \'s/.*tests="\\([0-9]*\\)".*/\\1/\' | awk \'{sum += $1} END {print sum}\'',
                returnStdout: true
            ).trim()
            
            def failedTests = sh(
                script: 'grep -h "failures=" target/surefire-reports/TEST-*.xml | sed \'s/.*failures="\\([0-9]*\\)".*/\\1/\' | awk \'{sum += $1} END {print sum}\'',
                returnStdout: true
            ).trim()
            
            def errorTests = sh(
                script: 'grep -h "errors=" target/surefire-reports/TEST-*.xml | sed \'s/.*errors="\\([0-9]*\\)".*/\\1/\' | awk \'{sum += $1} END {print sum}\'',
                returnStdout: true
            ).trim()
            
            testResults.TOTAL_TESTS = totalTests ?: '0'
            testResults.FAILED_TESTS = (failedTests?.toInteger() ?: 0) + (errorTests?.toInteger() ?: 0)
            testResults.PASSED_TESTS = (totalTests?.toInteger() ?: 0) - testResults.FAILED_TESTS
            testResults.PASS_RATE = totalTests?.toInteger() > 0 ? 
                Math.round((testResults.PASSED_TESTS / totalTests.toInteger()) * 100) : 0
            
            echo """
            Test Results Summary:
            Total Tests: ${testResults.TOTAL_TESTS}
            Passed Tests: ${testResults.PASSED_TESTS}
            Failed Tests: ${testResults.FAILED_TESTS}
            Pass Rate: ${testResults.PASS_RATE}%
            """
            
            // Set build result based on pass rate
            if (testResults.PASS_RATE < 80) {
                currentBuild.result = 'UNSTABLE'
                echo "Pass rate below 80% - marking build as UNSTABLE"
            }
            
        } catch (Exception e) {
            echo "Error calculating pass/fail rate: ${e.getMessage()}"
            currentBuild.result = 'UNSTABLE'
        }
    }
}

// Helper function to send Slack notifications
def sendSlackNotification(String status) {
    echo "Sending Slack notification for build status: ${status}"
    
    try {
        def color = status == 'SUCCESS' ? 'good' : 'danger'
        def message = """
*Cut+Dry Restaurant Automation Test Results*
*Build:* ${env.BUILD_NUMBER}
*Status:* ${status}
*Branch:* ${env.BRANCH_NAME}
*Environment:* ${env.TEST_ENV}
*Build URL:* ${env.BUILD_URL}
        """
        
        // Note: Slack integration requires Slack plugin configuration
        // slackSend(
        //     channel: '#qa-automation',
        //     color: color,
        //     message: message
        // )
        
        echo "Slack notification prepared: ${message}"
        
    } catch (Exception e) {
        echo "Failed to send Slack notification: ${e.getMessage()}"
    }
}

// Helper function to create JIRA issues for failures
def createJiraIssue() {
    echo "Creating JIRA issue for build failure..."
    
    try {
        // Note: JIRA integration requires JIRA plugin configuration
        // jiraCreateIssue(
        //     site: 'your-jira-site',
        //     issue: [
        //         fields: [
        //             project: [key: 'QA'],
        //             summary: "Restaurant Build ${env.BUILD_NUMBER} failed",
        //             description: "Automated restaurant test build failed on ${env.BRANCH_NAME}",
        //             issuetype: [name: 'Bug']
        //         ]
        //     ]
        // )
        
        echo "JIRA issue creation prepared for build ${env.BUILD_NUMBER}"
        
    } catch (Exception e) {
        echo "Failed to create JIRA issue: ${e.getMessage()}"
    }
}
