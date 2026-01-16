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

public class VerifyOrderGuideSettingsForScrapperIntegratedDPsTest extends TestBase {
    static User user;
    String supplierName = "Performance Ledyard";
    String userName = "nancy@coupacafe.com";
    static String Date = "29";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1900")
    public void VerifyOrderGuideSettingsForNonIntegratedDPs() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Customer.clickOnBtnForRamona();
        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Assert.assertTrue(Customer.isDisplayedMinOrderAmountLabel(),
                "Min Order Amount label is NOT displayed"
        );

        Assert.assertTrue(
                Customer.isDisplayedMinOrderCaseLabel(),
                "Min Order Case label is NOT displayed"
        );

        Assert.assertTrue(
                Customer.isDisplayedDeliveryDaysLabel(),
                "Delivery Days label is NOT displayed"
        );
        Customer.setOrderMinimum("200");
        Customer.clickSaveOrderGuideSettings();
        Thread.sleep(3000);

        Customer.closeEditor();
        Thread.sleep(2000);

        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "ERROR in navigating to Review Order page");

        Customer.submitOrderMinimum();
        softAssert.assertTrue(Customer.isOrderMinPopupDisplayed(), "Order Minimum popup not displayed");
        Customer.clickBackToCartFromOrderMinimumPopup();
        Customer.ClickSeveralTimesToIncreaseTheQuantity(15);
        Customer.submitOrderMinimum();
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