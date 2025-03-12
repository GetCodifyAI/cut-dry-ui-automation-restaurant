package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyThePickUpSubmit extends TestBase {
    static User user;
    static String OperatorName = "sunrise Food";
    static String customerId = "6253";
    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-164")
    public void verifyThePickUpSubmit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.goToDistributorSunriseFood(OperatorName);
        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        Customer.clickOnOrderGuide(customerId);
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.increaseFirstRowQtyCustom(2);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isPickUpTextDisplayed(),"Pick up text error");
        Customer.clickOnPickup();
        Customer.submitOrder();
        softAssert.assertFalse(Customer.isSubmittingErrorDisplayed(),"order  pickup Submit error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeMultipleTabs();
    }

}
