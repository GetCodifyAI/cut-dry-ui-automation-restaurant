package com.cutanddry.qa.tests.History;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheFilteringOrdersByOrderDateTest extends TestBase {
    static User user;
    String date = "Last 7 Days";
    static String expectedDate;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-945")
    public void VerifyTheFilteringOrdersByOrderDate() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        expectedDate = History.getLastWorkingDate();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.selectOrderDate(date);
        softAssert.assertTrue(History.isOrderDateChanged(date),"dropdown error");
        softAssert.assertTrue(History.validateFilteredOrders(expectedDate),"Error in filtering order dates");
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
