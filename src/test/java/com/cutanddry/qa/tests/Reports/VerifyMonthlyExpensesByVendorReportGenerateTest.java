package com.cutanddry.qa.tests.Reports;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Reports;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyMonthlyExpensesByVendorReportGenerateTest extends TestBase {
    static User user;
    static String report = "monthly expenses by vendor";
    static String reportName = "Monthly expenses by vendor";
    static String vendorName = "independent foods co";


    @BeforeMethod
    public void setUp(){
        try {
            initializationWithUniqueUserData();
        } catch (Exception e) {
            System.out.println("initializationWithUniqueUserData failed, trying standard initialization: " + e.getMessage());
            try {
                initialization();
            } catch (Exception e2) {
                System.out.println("Standard initialization also failed, trying secInitialization: " + e2.getMessage());
                secInitialization();
            }
        }
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-940")
    public void VerifyMonthlyExpensesByVendorReportGenerate()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToReports();
        softAssert.assertTrue(Reports.disabledGenerateReport(),"error in  generate report button");
        Reports.selectTheReport(report);
        Reports.generateReport();
        softAssert.assertTrue(Reports.isGeneratedReportDisplayed(reportName),"error in  generating table");
        Reports.searchData(vendorName);
        softAssert.assertTrue(Reports.isSearchResultDisplayed(vendorName),"generate report not successfully");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
