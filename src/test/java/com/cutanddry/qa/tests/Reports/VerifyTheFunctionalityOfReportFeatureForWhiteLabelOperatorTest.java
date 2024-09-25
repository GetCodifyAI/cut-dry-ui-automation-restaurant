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

public class VerifyTheFunctionalityOfReportFeatureForWhiteLabelOperatorTest extends TestBase {
    static User user;
    static String OperatorName = "Stephanie Collins";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-172")
    public void verifyReportFeatureForClassicOperatorTest()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.goToOperatorStephanieCollins(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToReports();
        softAssert.assertTrue(Reports.disabledGenerateReport(),"error in  generate report button");
        Reports.selectMonthlyExpensesByVendor();
        Reports.generateReport();
        softAssert.assertTrue(Reports.isMonthlyExpensesByVendorDisplayed(),"error in  generating table");
        Reports.selectCsv();
        softAssert.assertTrue(Reports.isCSVTextDisplayed(),"error in selecting csv file");
        Reports.generateReport();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
