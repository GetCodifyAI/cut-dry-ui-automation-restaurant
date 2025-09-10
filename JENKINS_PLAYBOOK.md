# Jenkins Pipeline Management Playbook for Restaurant

## Overview
This playbook provides comprehensive instructions for managing the Cut+Dry Jenkins parallel test execution pipeline for the Restaurant automation framework. The Jenkins instance is configured to run 11 parallel regression test suites for comprehensive quality assurance of restaurant-facing functionality.

## Quick Reference

### Access Information
- **Jenkins URL**: http://jenkins-qa.codify.ai/
- **Username**: cut-dry-qa
- **Password**: admin@qa123
- **Job Name**: `Cut-Dry-Restaurant-Parallel-Tests`

### Pipeline Overview
- **Parallel Stages**: 11 regression test suites
- **Execution Time**: ~30-45 minutes for full run
- **Test Environment**: UAT (User Acceptance Testing)
- **Browser**: Chrome headless mode
- **Java Version**: Java 21
- **Build Tool**: Maven
- **Repository**: `GetCodifyAI/cut-dry-ui-automation-restaurant`

---

## 1. Build Configuration Management

### 1.1 Modifying Test Suites

#### Adding New Regression Test Suites
To add a new regression XML file to the parallel execution:

1. **Create New Regression XML**:
   - Add new `regressionX.xml` file to repository root
   - Follow existing TestNG suite structure with parallel execution and retry listeners:
   ```xml
   <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
   <suite name="regression suit" parallel="tests" thread-count="2">
       <listeners>
           <listener class-name="com.cutanddry.qa.utils.RetryTransformer"/>
           <listener class-name="com.cutanddry.qa.utils.TestNGListener"/>
           <listener class-name="com.cutanddry.qa.utils.AIOSampleUIMethodListener"/>
       </listeners>
       <test name="operator tests">
           <parameter name="PART" value="Part X" />
           <classes>
               <!-- Add test classes here -->
           </classes>
       </test>
   </suite>
   ```

2. **Update Jenkinsfile**:
   - Navigate to repository: `GetCodifyAI/cut-dry-ui-automation-restaurant`
   - Edit `Jenkinsfile` in the root directory
   - Add new stage in the parallel block:
   ```groovy
   stage('Regression X - Description') {
       agent { label 'built-in' }
       steps {
           checkout scm
           script {
               runTestSuite('regressionX.xml', 'Part_X')
           }
       }
       post {
           always {
               archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
               stash includes: 'target/surefire-reports/TEST-*.xml', name: 'test-results-X'
           }
       }
   }
   ```

3. **Update Result Aggregation**:
   - Modify the aggregation loop in Jenkinsfile:
   ```groovy
   for (int i = 1; i <= X; i++) {  // Update X to new total (currently 11)
       unstash "test-results-${i}"
   }
   ```

#### Current Regression Test Suites
The restaurant framework includes the following regression suites:

1. **regression1.xml** - Order Guide Tests (Part One)
2. **regression2.xml** - Catalog Tests (Part Two)
3. **regression3.xml** - Payment Tests (Part Three)
4. **regression4.xml** - History Tests (Part Four)
5. **regression5.xml** - Settings Tests (Part Five)
6. **regression6.xml** - Credit Requests Tests (Part Six)
7. **regression7.xml** - Reports Tests (Part Seven)
8. **regression8.xml** - Role Tests (Part Eight)
9. **regression9.xml** - Additional Role Tests (Part Nine)
10. **regression10.xml** - Extended Tests (Part Ten)
11. **regression11.xml** - Multi-UOM Tests (Part Eleven)

#### Removing Test Suites
1. **Remove Stage**: Delete the corresponding stage block from Jenkinsfile
2. **Update Loop**: Adjust the aggregation loop counter from 11 to new total
3. **Archive Old XML**: Move unused regression XML files to archive folder

#### Modifying Existing Test Suites
1. **Edit Regression XML**: Update test class inclusions/exclusions
2. **Test Locally**: Verify changes with `mvn test -Dsurefire.suiteXmlFiles=regressionX.xml`
3. **Commit Changes**: Push updates to trigger new build

### 1.2 Environment Configuration Changes

#### Updating Test Environment URLs
1. **Locate Configuration**:
   - File: `src/main/java/com/cutanddry/qa/common/Constants.java`
   - Environment URLs defined here

2. **Modify Environment Variables**:
   - Edit Jenkinsfile environment section:
   ```groovy
   environment {
       MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
       JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
       TEST_ENV = 'uat'  // Change to 'staging', 'prod', etc.
       RUN_HEADLESS = 'true'
   }
   ```

3. **Test Environment Validation**:
   - Verify environment accessibility
   - Update access information if needed
   - Test connectivity before full deployment

#### Browser Configuration Changes
1. **Chrome Options**: Modify browser setup in test base classes
2. **Headless Mode**: Toggle via `RUN_HEADLESS` environment variable
3. **Browser Version**: Update Chrome installation in environment setup

---

## 2. Running Tests

### 2.1 Manual Test Execution

#### Triggering a Build
1. **Access Jenkins**:
   - Navigate to: http://jenkins-qa.codify.ai/
   - Login with credentials: cut-dry-qa / admin@qa123

2. **Navigate to Job**:
   - Click on `Cut-Dry-Restaurant-Parallel-Tests`
   - Click "Build with Parameters"

3. **Configure Parameters**:
   - **TEST_ENVIRONMENT**: Select from dropdown (uat, staging, prod)
   - **REGRESSION_SUITES**: Enter comma-separated suite numbers (e.g., "1,2,3" or "all")
   - Click "Build"

#### Monitoring Build Progress
1. **Build Queue**: Check build queue for pending jobs
2. **Console Output**: Click build number → "Console Output"
3. **Stage View**: Monitor parallel stage execution
4. **Artifacts**: Access test reports after completion

### 2.2 Build Parameters

#### TEST_ENVIRONMENT Options
- **uat**: User Acceptance Testing environment (default)
- **staging**: Staging environment for pre-production testing
- **prod**: Production environment (use with caution)

#### REGRESSION_SUITES Options
- **all**: Run all 11 regression suites (default)
- **1,2,3**: Run specific suites by number
- **1-5**: Run range of suites
- **critical**: Run only critical test suites (if configured)

---

## 3. Monitoring and Troubleshooting

### 3.1 Common Issues and Solutions

#### Build Failures

**Java Version Issues**:
- **Symptom**: "error: invalid target release: 22"
- **Solution**: Verify Java 21 configuration in both Jenkinsfile and pom.xml
- **Check**: Environment variables and JAVA_HOME setting

**Maven Issues**:
- **Symptom**: "mvn: command not found"
- **Solution**: Verify Maven installation in setupEnvironment() function
- **Check**: PATH configuration and Maven availability

**Workspace Issues**:
- **Symptom**: "No such file or directory" or "no POM"
- **Solution**: Ensure `checkout scm` is present in all parallel stages
- **Check**: Git checkout logs in console output

#### Test Execution Issues

**Browser Issues**:
- **Symptom**: WebDriver initialization failures
- **Solution**: Check Chrome installation and headless configuration
- **Check**: Browser version compatibility

**Environment Access**:
- **Symptom**: Connection timeouts or 404 errors
- **Solution**: Verify test environment URLs and accessibility
- **Check**: Network connectivity and environment status

**Test Data Issues**:
- **Symptom**: Login failures or data not found
- **Solution**: Verify test data setup and user credentials
- **Check**: Database connectivity and test user accounts

### 3.2 Performance Monitoring

#### Build Performance Metrics
- **Total Execution Time**: Target 30-45 minutes
- **Parallel Efficiency**: All 11 stages should run simultaneously
- **Resource Usage**: Monitor CPU and memory consumption
- **Queue Time**: Minimize build queue delays

#### Test Performance Indicators
- **Pass Rate**: Target >90% for stable builds
- **Execution Time per Suite**: Monitor for performance degradation
- **Flaky Tests**: Identify and address unstable tests
- **Coverage Metrics**: Track test coverage across modules

---

## 4. Maintenance Procedures

### 4.1 Regular Maintenance Tasks

#### Weekly Tasks
1. **Review Build History**: Check for patterns in failures
2. **Update Test Data**: Refresh test accounts and data sets
3. **Monitor Performance**: Track execution time trends
4. **Clean Workspace**: Remove old build artifacts

#### Monthly Tasks
1. **Update Dependencies**: Review and update Maven dependencies
2. **Browser Updates**: Verify Chrome version compatibility
3. **Environment Health**: Check test environment status
4. **Documentation Review**: Update playbook with new procedures

#### Quarterly Tasks
1. **Performance Review**: Analyze build performance trends
2. **Test Suite Optimization**: Review and optimize test coverage
3. **Infrastructure Updates**: Plan system upgrades
4. **Training Updates**: Update team training materials

### 4.2 Backup and Recovery

#### Configuration Backup
1. **Jenkinsfile**: Version controlled in Git repository
2. **Job Configuration**: Export Jenkins job configuration
3. **Test Data**: Backup test data and user accounts
4. **Environment Settings**: Document environment configurations

#### Recovery Procedures
1. **Job Recreation**: Steps to recreate Jenkins job from scratch
2. **Environment Restoration**: Restore test environment access
3. **Data Recovery**: Restore test data from backups
4. **Configuration Rollback**: Revert to previous working configuration

---

## 5. Integration and Notifications

### 5.1 Slack Integration

#### Configuration
- **Webhook URL**: Configured in Jenkins credentials
- **Channels**: #qa-automation, #restaurant-team
- **Notifications**: Build start, completion, failures

#### Message Format
```
🚀 Restaurant Tests Started - Build #123
📊 Restaurant Tests Completed - Build #123
   ✅ Passed: 85% (170/200 tests)
   ❌ Failed: 15% (30/200 tests)
   ⏱️ Duration: 42 minutes
🔗 View Results: [Jenkins Link]
```

### 5.2 JIRA Integration

#### Automatic Issue Creation
- **Trigger**: Build failure with >20% test failures
- **Project**: Restaurant QA (RQA)
- **Issue Type**: Bug
- **Priority**: Based on failure percentage

#### Issue Details
- **Summary**: "Restaurant Automation Build Failure - Build #XXX"
- **Description**: Failure summary and console output
- **Labels**: automation, restaurant, jenkins
- **Assignee**: QA team lead

---

## 6. Security and Access Management

### 6.1 Access Control

#### User Roles
- **Admin**: Full Jenkins access and configuration
- **Developer**: Build triggering and monitoring
- **QA**: Test execution and result analysis
- **Viewer**: Read-only access to build results

#### Credential Management
- **Jenkins Credentials**: Stored in Jenkins credential store
- **Test Accounts**: Managed separately for each environment
- **API Keys**: Secured and rotated regularly
- **Database Access**: Limited to test environments only

### 6.2 Security Best Practices

#### Pipeline Security
1. **Credential Isolation**: No hardcoded credentials in Jenkinsfile
2. **Environment Separation**: Isolated test environments
3. **Access Logging**: Monitor and log all access attempts
4. **Regular Audits**: Review access permissions quarterly

#### Data Protection
1. **Test Data Anonymization**: Use anonymized production data
2. **Secure Transmission**: HTTPS for all communications
3. **Data Retention**: Automatic cleanup of old test data
4. **Compliance**: Follow company data protection policies

---

## 7. Reporting and Analytics

### 7.1 Test Reports

#### Available Reports
- **TestNG Reports**: Detailed test execution results
- **Surefire Reports**: Maven test execution summaries
- **Trend Analysis**: Historical pass/fail trends
- **Performance Reports**: Execution time analysis

#### Report Access
1. **Jenkins Artifacts**: Download from build artifacts
2. **Email Reports**: Automated email summaries
3. **Dashboard**: Real-time test execution dashboard
4. **API Access**: Programmatic access to test results

### 7.2 Metrics and KPIs

#### Key Performance Indicators
- **Build Success Rate**: Percentage of successful builds
- **Test Pass Rate**: Percentage of passing tests
- **Mean Time to Recovery**: Average time to fix failures
- **Build Frequency**: Number of builds per day/week

#### Trend Analysis
- **Weekly Reports**: Build and test trends
- **Monthly Summaries**: Performance and reliability metrics
- **Quarterly Reviews**: Strategic planning and improvements
- **Annual Assessment**: Infrastructure and process evaluation

---

## 8. Troubleshooting Guide

### 8.1 Quick Diagnostics

#### Build Won't Start
1. Check Jenkins service status
2. Verify job configuration
3. Check build queue and executors
4. Review system logs

#### Tests Not Running
1. Verify environment connectivity
2. Check test data availability
3. Review browser configuration
4. Validate user credentials

#### Slow Performance
1. Monitor system resources
2. Check parallel execution
3. Review test efficiency
4. Analyze network latency

### 8.2 Advanced Troubleshooting

#### Log Analysis
- **Jenkins Logs**: System and job execution logs
- **Console Output**: Detailed build execution logs
- **Application Logs**: Test application server logs
- **Browser Logs**: WebDriver and browser console logs

#### Performance Profiling
- **Build Timeline**: Analyze stage execution times
- **Resource Usage**: Monitor CPU, memory, and disk usage
- **Network Analysis**: Check connectivity and latency
- **Database Performance**: Monitor test database queries

---

## 9. Contact Information

### 9.1 Support Contacts

#### Primary Contacts
- **QA Team Lead**: [Contact Information]
- **DevOps Engineer**: [Contact Information]
- **Jenkins Administrator**: [Contact Information]
- **Restaurant Team Lead**: [Contact Information]

#### Escalation Path
1. **Level 1**: QA Team Member
2. **Level 2**: QA Team Lead
3. **Level 3**: DevOps Engineer
4. **Level 4**: Engineering Manager

### 9.2 Emergency Procedures

#### Critical Issues
- **Production Impact**: Immediate escalation to Level 3
- **Security Incidents**: Contact security team immediately
- **Data Loss**: Follow data recovery procedures
- **System Outage**: Activate incident response plan

#### Communication Channels
- **Slack**: #qa-automation (normal issues)
- **Slack**: #incidents (critical issues)
- **Email**: qa-team@cutanddry.com
- **Phone**: Emergency contact list

---

## 10. Appendices

### 10.1 Configuration Templates

#### Jenkinsfile Template
```groovy
pipeline {
    agent any
    
    parameters {
        choice(
            name: 'TEST_ENVIRONMENT',
            choices: ['uat', 'staging', 'prod'],
            description: 'Select the test environment'
        )
        string(
            name: 'REGRESSION_SUITES',
            defaultValue: 'all',
            description: 'Comma-separated list of regression suite numbers'
        )
    }
    
    environment {
        MAVEN_OPTS = '-Xmx2048m -XX:MaxMetaspaceSize=512m'
        JAVA_HOME = '/usr/lib/jvm/java-21-openjdk-amd64'
        TEST_ENV = "${params.TEST_ENVIRONMENT}"
        RUN_HEADLESS = 'true'
        BROWSER_VERSION = 'latest'
    }
    
    stages {
        // Pipeline stages here
    }
}
```

#### Regression XML Template
```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="regression suit" parallel="tests" thread-count="2">
    <listeners>
        <listener class-name="com.cutanddry.qa.utils.RetryTransformer"/>
        <listener class-name="com.cutanddry.qa.utils.TestNGListener"/>
        <listener class-name="com.cutanddry.qa.utils.AIOSampleUIMethodListener"/>
    </listeners>
    <test name="operator tests">
        <parameter name="PART" value="Part X" />
        <classes>
            <!-- Test classes here -->
        </classes>
    </test>
</suite>
```

### 10.2 Command Reference

#### Maven Commands
```bash
# Run specific regression suite
mvn clean test -Dsurefire.suiteXmlFiles=regression1.xml

# Run with specific environment
mvn clean test -Dtest.env=uat -Drun.headless=true

# Generate reports
mvn surefire-report:report

# Clean workspace
mvn clean
```

#### Git Commands
```bash
# Create feature branch
git checkout -b feature/new-tests

# Commit changes
git add . && git commit -m "Add new test suite"

# Push changes
git push origin feature/new-tests
```

### 10.3 Environment URLs

#### Test Environments
- **UAT**: https://app-uat.staging.cutanddry.com/
- **Staging**: https://app-staging.cutanddry.com/
- **Production**: https://app.cutanddry.com/

#### API Endpoints
- **UAT API**: https://api-uat.staging.cutanddry.com/
- **Staging API**: https://api-staging.cutanddry.com/
- **Production API**: https://api.cutanddry.com/

---

*This playbook is maintained by the QA team and updated regularly. For suggestions or corrections, please contact the QA team lead.*

**Last Updated**: September 2025
**Version**: 1.0
**Maintained By**: Cut+Dry QA Team
