package com.cutanddry.qa.tests.Reports;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Reports;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyExpensesByProductReportGenerateTest extends TestBase {
    static User user;
    static String report = "expenses by product";
    static String reportName = "Expenses by Product";
    static String productCode = "1700";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-944")
    public void VerifyExpensesByProductReportGenerate()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToReports();
        softAssert.assertTrue(Reports.disabledGenerateReport(),"error in  generate report button");
        Reports.selectTheReport(report);
        Reports.generateReport();
        softAssert.assertTrue(Reports.isGeneratedReportDisplayed(reportName),"error in  generating table");
        Reports.searchData(productCode);
        softAssert.assertTrue(Reports.isSearchResultDisplayed(productCode),"generate report not successfully");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}