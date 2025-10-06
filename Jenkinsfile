pipeline {
    agent { label 'ec2-fleet' }
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['uat'],
            description: 'Select the test environment'
        )
        choice(
            name: 'SUITE_SELECTION',
            choices: ['All'],
            description: 'Select suite type: All (runs 11 regression XMLs in parallel) or Smoke (runs only smoke tests)'
        )
        booleanParam(
            name: 'CLEANUP_AFTER_EXECUTION',
            defaultValue: true,
            description: 'Clean up temporary files after execution to save disk space'
        )
        booleanParam(
            name: 'CREATE_CYCLE',
            defaultValue: false,
            description: 'Create test cycle in AIO for test execution tracking and reporting'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        TEST_ENV = "${params.TEST_ENVIRONMENT}"
        RUN_HEADLESS = 'true'
        BROWSER_VERSION = 'latest'
        WORKSPACE_CLEANUP = "${params.CLEANUP_AFTER_EXECUTION}"
        SUITE_TYPE = "${params.SUITE_SELECTION}"
        CREATE_CYCLE = "${params.CREATE_CYCLE}"
    }
    
    stages {
        stage('Setup Environment') {
            steps {
                script {
                    setupEnvironment()
                }
            }
        }
        
        stage('Execute All Regression Tests') {
            when {
                expression { params.SUITE_SELECTION == 'All' }
            }
            parallel {
                stage('Restaurant Regression 1 - Order Guide Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-1.xml', 'Restaurant_Part_One', '1')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('1', 'Restaurant Regression 1 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 2 - Catalog Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-2.xml', 'Restaurant_Part_Two', '2')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('2', 'Restaurant Regression 2 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 3 - Settings Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-3.xml', 'Restaurant_Part_Three', '3')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('3', 'Restaurant Regression 3 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 4 - History Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-4.xml', 'Restaurant_Part_Four', '4')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('4', 'Restaurant Regression 4 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 5 - SignIn Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-5.xml', 'Restaurant_Part_Five', '5')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('5', 'Restaurant Regression 5 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 6 - Users Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-6.xml', 'Restaurant_Part_Six', '6')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('6', 'Restaurant Regression 6 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 7 - Support Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-7.xml', 'Restaurant_Part_Seven', '7')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('7', 'Restaurant Regression 7 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 8 - History Advanced Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-8.xml', 'Restaurant_Part_Eight', '8')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('8', 'Restaurant Regression 8 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 9 - Rewards Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-9.xml', 'Restaurant_Part_Nine', '9')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('9', 'Restaurant Regression 9 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 10 - Orders Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-10.xml', 'Restaurant_Part_Ten', '10')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('10', 'Restaurant Regression 10 Test Report')
                            }
                        }
                    }
                }
                
                stage('Restaurant Regression 11 - Multi-UOM Tests') {
                    agent { label 'built-in' }
                    steps {
                        checkout scm
                        script {
                            runTestSuiteWithCleanup('Restaurant-Regression-11.xml', 'Restaurant_Part_Eleven', '11')
                        }
                    }
                    post {
                        always {
                            script {
                                archiveAndCleanup('11', 'Restaurant Regression 11 Test Report')
                            }
                        }
                    }
                }
            }
        }
        
        stage('Execute Smoke Tests') {
            when {
                expression { params.SUITE_SELECTION == 'Smoke' }
            }
            steps {
                script {
                    echo "Running Restaurant Smoke Tests (Restaurant-Smoke.xml)"
                    runTestSuiteWithCleanup('Restaurant-Smoke.xml', 'Restaurant_Smoke', 'Smoke')
                }
            }
            post {
                always {
                    script {
                        archiveAndCleanup('Smoke', 'Restaurant Smoke Test Report')
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
    echo "Setting up test environment..."
    sh '''
        # Clean up any existing temporary files
        rm -rf /tmp/chrome_* /tmp/.org.chromium.* || true
        
        # Set JAVA_HOME to the correct OpenJDK path for Ubuntu
        export JAVA_HOME='/usr/lib/jvm/java-21-openjdk-amd64'
        echo "Set JAVA_HOME to: $JAVA_HOME"
        
        # Use existing Java installation
        echo "Current Java version:"
        java -version
        
        # Check if Maven is available with JAVA_HOME set
        if command -v mvn &> /dev/null; then
            echo "Maven version:"
            mvn -version
        else
            echo "ERROR: Maven not found in Jenkins environment"
            echo "Please ensure Maven is installed on the Jenkins node"
            exit 1
        fi
        
        # Check for browser availability (Chrome, Chromium, or Firefox)
        if command -v google-chrome &> /dev/null; then
            echo "Chrome version:"
            google-chrome --version
        elif command -v chromium-browser &> /dev/null; then
            echo "Chromium version:"
            chromium-browser --version
        elif command -v firefox &> /dev/null; then
            echo "Firefox version:"
            firefox --version
        else
            echo "WARNING: No browser found for headless testing"
            echo "Tests requiring browser automation may fail"
        fi
        
        # Set up workspace
        echo "Setting up workspace..."
        mkdir -p target/surefire-reports
        
        # Display available disk space
        df -h
        
        echo "Environment setup complete"
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
                -Dcreate.cycle=${env.CREATE_CYCLE} \\
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
Suite Selection: ${params.SUITE_SELECTION}
Cycle Creation: ${params.CREATE_CYCLE}
Cleanup Enabled: ${params.CLEANUP_AFTER_EXECUTION}
Duration: ${currentBuild.durationString}
🔗 View Results: ${env.BUILD_URL}
    """
    
    // Slack notification would be configured here
    echo "Slack notification: ${message}"
}
