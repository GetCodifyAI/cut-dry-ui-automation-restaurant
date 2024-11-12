package com.cutanddry.qa.tests.Credit_Requests;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.CreditRequests;
import com.cutanddry.qa.pages.CreditRequestsPage;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class verifyTheCreditReqSearchByDistributorTest extends TestBase {
    static User user;
    String timeRange = "All";
    String orderID = "316727041";

    @BeforeMethod
    public void setUp(){
        secInitialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-326")
    public void verifyTheCreditReqSearchByDistributor() throws InterruptedException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDisDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDisDashboard(),"login error");
        Dashboard.navigateToCreditRequests();
        CreditRequests.changeRequestDate(timeRange); //Select the "All" option
        CreditRequests.searchOrderID(orderID);
        softAssert.assertTrue(CreditRequests.checkIfElementVisible(orderID), "Order ID not found in the table.");
        CreditRequests.checkIfElementVisible(orderID);
        softAssert.assertAll();
    }
}
