package com.cutanddry.qa.tests.Credit_Requests;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.CreditRequests;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class VerifyTheCreditViewTimelineByDistributorTest extends  TestBase{

    static User user;
    String timeRange = "All";

    @BeforeMethod
    public void setUp(){
        secInitialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-495")
    public void VerifyTheCreditViewItemsByDistributor() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDisDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDisDashboard(),"login error");
        Dashboard.navigateToCreditRequests();
        softAssert.assertTrue(CreditRequests.isErrorTextNotDisplayed(),"Error Message Displayed");
        CreditRequests.changeRequestDate(timeRange); //Select the "All" option
        CreditRequests.clickOnFirstItem();
        softAssert.assertTrue(CreditRequests.isErrorTextNotDisplayed(),"Error Message Displayed");
        CreditRequests.clickOnTimeline();
        softAssert.assertTrue(CreditRequests.checkIfTimelineSectionVisible(), "Timeline Section is not visible");
        softAssert.assertTrue(CreditRequests.isErrorTextNotDisplayed(),"Error Message Displayed");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
