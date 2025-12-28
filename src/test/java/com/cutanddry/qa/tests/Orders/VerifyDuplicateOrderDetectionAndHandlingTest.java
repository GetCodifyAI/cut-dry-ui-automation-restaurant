package com.cutanddry.qa.tests.Orders;
import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyDuplicateOrderDetectionAndHandlingTest extends TestBase {
    static User user;
    static String itemName;
    static String firstOrderId;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3554")
    public void verifyDuplicateOrderDetectionAndHandling() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Failed to navigate to Order Guide");

        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Failed to navigate to Review Order page");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "First order submission failed");
        firstOrderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Failed to navigate to Order Guide for second order");

        Customer.searchItemOnOrderGuide(itemName);
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Failed to navigate to Review Order page for second order");

        Customer.submitOrderOnly();
        softAssert.assertTrue(Customer.isDuplicateOrderPopupDisplayed(), "Duplicate order warning popup not displayed");

        Customer.clickYesOnDuplicateOrderPopup();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "Second order submission failed after confirming duplicate");
        Customer.clickClose();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}