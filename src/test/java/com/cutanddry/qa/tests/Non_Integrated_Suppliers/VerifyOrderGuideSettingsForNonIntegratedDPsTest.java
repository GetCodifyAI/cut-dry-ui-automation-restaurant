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

import java.time.LocalDate;

public class VerifyOrderGuideSettingsForNonIntegratedDPsTest extends TestBase {
    static User user;
    String supplierName = "David Rio";
    String userName = "nancy@coupacafe.com";
    static String date = String.valueOf(LocalDate.now().getDayOfMonth());


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
        Dashboard.selectSupplierWithoutClickSpecificCustomer(supplierName);
        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Customer.setOrderMinimum("200");
        Customer.setOrderCaseMinimum("10");
        Customer.removeDeliveryDay("Sunday");
        Customer.clickSaveOrderGuideSettings();
        Thread.sleep(3000);

        Customer.closeEditor();
        Thread.sleep(2000);

        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        Customer.selectDeliveryDateLineStable(date,true);
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "ERROR in navigating to Review Order page");

        Customer.submitOrderMinimum();
        softAssert.assertTrue(Customer.isOrderMinPopupDisplayed(), "Order Minimum popup not displayed");
        Customer.clickBackToCartFromOrderMinimumPopup();
        Customer.ClickSeveralTimesToIncreaseTheQuantity(7);
        Customer. submitOrderWithoutClickPopUpYes();
        softAssert.assertTrue(Customer.isCaseMinPopupDisplayed(), "Case  Minimum popup not displayed");
        Customer.clickYesCaseMinimum();
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