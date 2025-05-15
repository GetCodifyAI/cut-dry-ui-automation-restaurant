package com.cutanddry.qa.tests.History;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheInvoiceDownloadAndPrintFeatureTest extends TestBase {
    static User user;
    static String orderID = "410201444";
    String date = "Last 60 Days";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-178")
    public void VerifyTheInvoiceDownloadAndPrintFeature() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.selectOrderDate(date);
        History.searchOrderID(orderID);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderID), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(),"Order section not display");
        History.clickOnInvoiceTab();
        History.clickOnDownloadInvoice();
        History.clickOnPrintInvoice();
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
