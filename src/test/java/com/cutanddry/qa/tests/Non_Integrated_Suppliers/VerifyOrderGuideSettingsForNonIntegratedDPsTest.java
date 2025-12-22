package com.cutanddry.qa.tests.Non_Integrated_Suppliers;

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

public class VerifyOrderGuideSettingsForNonIntegratedDPsTest extends TestBase {
    static User user;
    String supplierName = "David Rio";
    String userName = "jcoupal@coupa";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1899")
    public void VerifyOrderGuideSettingsForNonIntegratedDPs() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");

        Customer.clickOnPlaceOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "ERROR in navigating to Order Guide");

        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        softAssert.assertTrue(Customer.isOrderGuideSettingsDisplayed(), "ERROR in navigating to Order Guide Settings");

        softAssert.assertTrue(Customer.isOrderMinimumFieldDisplayed(), "Order Minimum field is not displayed");
        softAssert.assertTrue(Customer.isOrderCaseMinimumFieldDisplayed(), "Order Case Minimum field is not displayed");
        softAssert.assertTrue(Customer.isDeliveryDaysFieldDisplayed(), "Delivery Days field is not displayed");

        Customer.setOrderMinimum("200");
        Customer.setOrderCaseMinimum("5");
        Customer.removeDeliveryDay("Sunday");
        Customer.clickSaveOrderGuideSettings();
        Thread.sleep(3000);

        Customer.closeOrderGuideSettings();
        Thread.sleep(2000);

        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "ERROR in navigating to Review Order page");

        Customer.submitOrderMinimum();
        softAssert.assertTrue(Customer.isOrderMinPopupDisplayed(), "Order Minimum popup not displayed");
        Customer.clickPlaceOrderSoftOrderMinimum();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "Order not completed successfully");
        Customer.clickClose();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
