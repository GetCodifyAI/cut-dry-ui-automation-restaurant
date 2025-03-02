package com.cutanddry.qa.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CSVGenerator implements ITestListener {
    private static final String CSV_FILE_PATH = "test_result.csv";

    private static int totalTestCases = 0;
    private static int passedTestCases = 0;
    private static int failedTestCases = 0;


    private static final List<TestResultData> testResults = new ArrayList<>();
    private final Set<String> processedTests = new HashSet<>();
    private static final Set<String> passedTestCasesSet = new HashSet<>();
    private static final Set<String> failedTestCasesSet = new HashSet<>();

    @Override
    public void onTestStart(ITestResult result){
        String testName = result.getMethod().getMethodName();

        if (!processedTests.contains(testName)) {
            totalTestCases++;
        }
    }

    @Override
    public void onTestSuccess(ITestResult result){
        String testName = result.getMethod().getMethodName();


        failedTestCasesSet.remove(testName);


        if (!passedTestCasesSet.contains(testName)) {
            passedTestCases++;
            passedTestCasesSet.add(testName);
        }


        processedTests.add(testName);
    }

    @Override
    public void onTestFailure(ITestResult result){
        String testName = result.getMethod().getMethodName();

        if (passedTestCasesSet.contains(testName)) {
            return;
        }

        IRetryAnalyzer retryAnalyzer = result.getMethod().getRetryAnalyzer(result);
        if (retryAnalyzer != null && retryAnalyzer.retry(result)) {
            return;
        }

        if (!failedTestCasesSet.contains(testName)) {
            failedTestCases++;
            failedTestCasesSet.add(testName);
        }

        processedTests.add(testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        failedTestCasesSet.remove(testName);

        if (!processedTests.contains(testName)) {
            processedTests.add(testName);
        }
    }

    @Override
    public void onFinish(ITestContext context){
        String SuiteName = context.getName();
        String partName  = context.getCurrentXmlTest().getParameter("PART");

        String failedTestCaseNames = String.join("\n", failedTestCasesSet);

        testResults.add(new TestResultData(SuiteName,partName,totalTestCases,passedTestCases,failedTestCases,failedTestCaseNames));

        updateGlobalCounts();

        generateFinalCSVReport();

    }


    private void generateFinalCSVReport(){
        boolean isNewFile = !new File(CSV_FILE_PATH).exists();

        try(FileWriter writer = new FileWriter(CSV_FILE_PATH,false)){
            writer.append("Execution Date,Execution Time,Suite Name,Part,Total Test Cases,Passed Count,Failed Count,Failed TCs\n");

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
            String executionDate = dateFormat.format(new Date());

            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Colombo"));
            String executionTime = timeFormat.format(new Date());


            for(TestResultData result : testResults){
                String failedTestCaseNames = result.failedTestNames;
                writer.append(String.format("%s,%s,%s,%s,%d,%d,%d,%s\n",
                        executionDate,executionTime,result.suiteName,result.partName,result.totalTests,result.passedTests,result.failedTests,failedTestCaseNames));
            }


            int totalTests = 0;
            int totalPassed = 0;
            int totalFailed = 0;

            // Calculate the totals
            for (TestResultData result : testResults) {
                totalTests += result.totalTests;
                totalPassed += result.passedTests;
                totalFailed += result.failedTests;
            }

            // Calculate the pass percentage
            double passPercentage = (totalTests == 0) ? 0 : ((double) totalPassed / totalTests) * 100;
            double failPercentage = 100 - passPercentage;

            // Write the summary row (Total)
            writer.append(String.format("Total, , , ,%d,%d,%d,N/A\n",
                    totalTests, totalPassed, totalFailed));

            // Write the percentage row (Pass & Fail Percentage)
            writer.append(String.format("Percentage, , , , ,%.2f%%,%.2f%%,N/A\n",
                    passPercentage, failPercentage));

            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private void updateGlobalCounts(){
        totalTestCases = 0;
        passedTestCases = 0;
        failedTestCases = 0;
        passedTestCasesSet.clear();
        failedTestCasesSet.clear();
    }

    public static class TestResultData{
        String suiteName;
        String partName;
        String failedTestNames;
        int totalTests;
        int passedTests;
        int failedTests;

        public TestResultData(String SuiteName,String PartName,int TotalTestCases, int PassedTestCases, int FailedTestCases,String FailedTestCaseNames ){
            this.suiteName = SuiteName;
            this.partName = PartName;
            this.totalTests = TotalTestCases;
            this.passedTests = PassedTestCases;
            this.failedTests = FailedTestCases;
            this.failedTestNames = FailedTestCaseNames;
        }

    }


}

