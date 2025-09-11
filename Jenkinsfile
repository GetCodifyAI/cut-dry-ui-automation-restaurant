pipeline {
    agent any
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['uat', 'staging', 'prod'],
            description: 'Select the test environment'
        )
        choice(
            name: 'REGRESSION_SUITE',
            choices: ['all', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11'],
            description: 'Select specific regression suite to run (or all for parallel execution)'
        )
        booleanParam(
            name: 'CLEANUP_AFTER_EXECUTION',
            defaultValue: true,
            description: 'Clean up temporary files after execution to save disk space'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        TEST_ENV = "${params.TEST_ENVIRONMENT}"
        RUN_HEADLESS = 'true'
        BROWSER_VERSION = 'latest'
        WORKSPACE_CLEANUP = "${params.CLEANUP_AFTER_EXECUTION}"
    }
    
    stages {
        stage('Setup Environment') {
            steps {
                script {
                    setupEnvironment()
                }
            }
        }
        
        stage('Execute Tests') {
            when {
                expression { params.REGRESSION_SUITE == 'all' }
            }
            parallel {
                stage('Regression 1 - Order Guide Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression1.xml', 'Part_One', '1')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('1', 'Regression 1 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 2 - Catalog Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression2.xml', 'Part_Two', '2')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('2', 'Regression 2 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 3 - Payment Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression3.xml', 'Part_Three', '3')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('3', 'Regression 3 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 4 - History Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression4.xml', 'Part_Four', '4')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('4', 'Regression 4 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 5 - Settings Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression5.xml', 'Part_Five', '5')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('5', 'Regression 5 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 6 - Credit Requests Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression6.xml', 'Part_Six', '6')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('6', 'Regression 6 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 7 - Reports Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression7.xml', 'Part_Seven', '7')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('7', 'Regression 7 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 8 - Role Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression8.xml', 'Part_Eight', '8')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('8', 'Regression 8 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 9 - Additional Role Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression9.xml', 'Part_Nine', '9')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('9', 'Regression 9 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 10 - Extended Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression10.xml', 'Part_Ten', '10')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('10', 'Regression 10 Test Report')
                            }
                        }
                    }
                }
                
                stage('Regression 11 - Multi-UOM Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('regression11.xml', 'Part_Eleven', '11')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('11', 'Regression 11 Test Report')
                            }
                        }
                    }
                }
            }
        }
        
        stage('Execute Single Suite') {
            when {
                expression { params.REGRESSION_SUITE != 'all' }
            }
            steps {
                script {
                    def suiteNumber = params.REGRESSION_SUITE
                    def suiteMap = [
                        '1': ['regression1.xml', 'Part_One', 'Order Guide Tests'],
                        '2': ['regression2.xml', 'Part_Two', 'Catalog Tests'],
                        '3': ['regression3.xml', 'Part_Three', 'Payment Tests'],
                        '4': ['regression4.xml', 'Part_Four', 'History Tests'],
                        '5': ['regression5.xml', 'Part_Five', 'Settings Tests'],
                        '6': ['regression6.xml', 'Part_Six', 'Credit Requests Tests'],
                        '7': ['regression7.xml', 'Part_Seven', 'Reports Tests'],
                        '8': ['regression8.xml', 'Part_Eight', 'Role Tests'],
                        '9': ['regression9.xml', 'Part_Nine', 'Additional Role Tests'],
                        '10': ['regression10.xml', 'Part_Ten', 'Extended Tests'],
                        '11': ['regression11.xml', 'Part_Eleven', 'Multi-UOM Tests']
                    ]
                    
                    def suiteInfo = suiteMap[suiteNumber]
                    if (suiteInfo) {
                        echo "Running ${suiteInfo[2]} (${suiteInfo[0]})"
                        runTestSuiteWithCleanup(suiteInfo[0], suiteInfo[1], suiteNumber)
                    } else {
                        error "Invalid regression suite number: ${suiteNumber}"
                    }
                }
            }
            post {
                always {
                    script {
                        archiveAndCleanup(params.REGRESSION_SUITE, "Regression ${params.REGRESSION_SUITE} Test Report")
                    }
                }
            }
        }
        
        stage('Final Cleanup') {
            when {
                expression { params.CLEANUP_AFTER_EXECUTION }
            }
            steps {
                script {
                    performFinalCleanup()
                }
            }
        }
    }
    
    post {
        always {
            script {
                sendSlackNotification()
                if (params.CLEANUP_AFTER_EXECUTION) {
                    performWorkspaceCleanup()
                }
            }
        }
    }
}

def setupEnvironment() {
    echo "Setting up test environment with space optimization..."
    sh '''
        # Clean up any existing temporary files
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true
        
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
        
        # Clean Maven cache to free space
        mvn dependency:purge-local-repository -DmanualInclude="com.cutanddry" || true
        
        # Verify installations
        java -version
        mvn -version
        google-chrome --version
        
        # Display available disk space
        df -h
    '''
}

def runTestSuiteWithCleanup(xmlFile, partName, suiteNumber) {
    echo "Running test suite: ${xmlFile} (${partName}) with cleanup optimization"
    
    // Pre-execution cleanup
    sh '''
        # Clean up any existing test artifacts
        rm -rf target/surefire-reports* || true
        rm -rf target/screenshots* || true
        rm -rf target/test-output* || true
        
        # Clean browser cache and temp files
        rm -rf ~/.cache/google-chrome* || true
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true
        
        # Display disk usage before test
        echo "Disk usage before test execution:"
        df -h
    '''
    
    try {
        sh """
            mvn clean test \\
                -Dsurefire.suiteXmlFiles=${xmlFile} \\
                -Drun.headless=${env.RUN_HEADLESS} \\
                -Dtest.env=${env.TEST_ENV} \\
                -Dmaven.test.failure.ignore=true \\
                -Dmaven.repo.local=\${WORKSPACE}/.m2/repository
        """
    } catch (Exception e) {
        echo "Test execution completed with some failures: ${e.getMessage()}"
    }
    
    // Verify test results exist and create compressed archives
    sh """
        # Verify test results exist
        ls -R target/surefire-reports || echo "Test results missing!"
        
        # Create part-specific directory for screenshots and reports
        if [ -d "target/surefire-reports" ]; then
            mkdir -p "target/surefire-reports-${partName}"
            cp -r target/surefire-reports/* "target/surefire-reports-${partName}/" || true
            
            # Compress screenshots to save space
            if [ -d "target/surefire-reports-${partName}/screenshots" ]; then
                cd "target/surefire-reports-${partName}"
                tar -czf "screenshots-${partName}-${suiteNumber}.tar.gz" screenshots/ || true
                rm -rf screenshots/ || true
                cd -
            fi
            
            # Create summary report
            echo "Test Suite: ${xmlFile}" > "target/surefire-reports-${partName}/suite-info.txt"
            echo "Part Name: ${partName}" >> "target/surefire-reports-${partName}/suite-info.txt"
            echo "Suite Number: ${suiteNumber}" >> "target/surefire-reports-${partName}/suite-info.txt"
            echo "Execution Time: \$(date)" >> "target/surefire-reports-${partName}/suite-info.txt"
        fi
        
        # Display disk usage after test
        echo "Disk usage after test execution:"
        df -h
    """
}

def archiveAndCleanup(suiteNumber, reportName) {
    echo "Archiving artifacts and performing cleanup for suite ${suiteNumber}"
    
    // Archive artifacts with compression
    archiveArtifacts artifacts: 'target/surefire-reports*/**/*', allowEmptyArchive: true, fingerprint: true
    
    // Publish HTML reports
    publishHTML([
        allowMissing: false,
        alwaysLinkToLastBuild: true,
        keepAll: true,
        reportDir: 'target/surefire-reports',
        reportFiles: 'index.html',
        reportName: reportName
    ])
    
    // Stash test results for potential aggregation
    stash includes: 'target/surefire-reports/TEST-*.xml', name: "test-results-${suiteNumber}", allowEmpty: true
    
    // Cleanup if enabled
    if (env.WORKSPACE_CLEANUP == 'true') {
        sh """
            # Clean up large temporary files but keep archived artifacts
            rm -rf target/classes || true
            rm -rf target/test-classes || true
            rm -rf target/maven-* || true
            
            # Clean browser temp files
            rm -rf ~/.cache/google-chrome* || true
            rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true
            
            # Clean Maven temp files
            rm -rf ~/.m2/repository/com/cutanddry/*/target || true
            
            echo "Cleanup completed for suite ${suiteNumber}"
            df -h
        """
    }
}

def performFinalCleanup() {
    echo "Performing final workspace cleanup..."
    sh '''
        # Clean up all temporary Maven files
        rm -rf target/maven-archiver || true
        rm -rf target/maven-status || true
        rm -rf .m2/repository/com/cutanddry || true
        
        # Clean up browser and system temp files
        rm -rf ~/.cache/* || true
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true
        rm -rf /var/tmp/chrome_* || true
        
        # Clean up old log files
        find . -name "*.log" -type f -mtime +1 -delete || true
        
        # Display final disk usage
        echo "Final disk usage after cleanup:"
        df -h
        
        # Display workspace size
        echo "Workspace size:"
        du -sh . || true
    '''
}

def performWorkspaceCleanup() {
    echo "Performing post-build workspace cleanup..."
    sh '''
        # Keep only essential files and archived artifacts
        find . -type f -name "*.class" -delete || true
        find . -type f -name "*.jar" -not -path "./target/surefire-reports*" -delete || true
        
        # Clean up Maven local repository
        rm -rf .m2 || true
        
        echo "Post-build cleanup completed"
        df -h
    '''
}

def sendSlackNotification() {
    def buildStatus = currentBuild.result ?: 'SUCCESS'
    def color = buildStatus == 'SUCCESS' ? 'good' : 'danger'
    def emoji = buildStatus == 'SUCCESS' ? '✅' : '❌'
    
    def message = """
${emoji} Restaurant Tests ${buildStatus} - Build #${env.BUILD_NUMBER}
Environment: ${env.TEST_ENV}
Suite: ${params.REGRESSION_SUITE}
Cleanup Enabled: ${params.CLEANUP_AFTER_EXECUTION}
Duration: ${currentBuild.durationString}
🔗 View Results: ${env.BUILD_URL}
    """
    
    // Slack notification would be configured here
    echo "Slack notification: ${message}"
}
