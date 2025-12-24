package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifySimpleListViewMaximumQuantityValidationTest extends TestBase {
    static User user;
    static String validQuantity1 = "1999";
    static String invalidQuantity = "2000";
    static String correctedQuantity = "1200";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2252")
    public void VerifySimpleListViewMaximumQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.expandMoreOptionsDropdown();
        Customer.clickSimpleListView();
        softAssert.assertTrue(Customer.isSimpleListViewTextDisplay(), "Simple list view section not displayed");

        Customer.enterQuantitySimpleListViewByIndex(1, validQuantity1);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Error modal should not display for valid quantity 1999");
        String qty1 = Customer.getQuantitySimpleListViewByIndex(1);
        softAssert.assertEquals(qty1, validQuantity1, "Valid quantity 1999 should be accepted");

        Customer.enterQuantitySimpleListViewByIndex(2, invalidQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Error modal should display for invalid quantity 2000");
        Customer.clickErrorModalOkButton();
        String qty2AfterError = Customer.getQuantitySimpleListViewByIndex(2);
        softAssert.assertEquals(qty2AfterError, "1999", "Quantity field should be cleared to 0 after error");

        Customer.enterQuantitySimpleListViewByIndex(2, correctedQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertFalse(Customer.isMaxQuantityErrorModalDisplayed(), "Error modal should not display for corrected quantity 1200");
        String qty2Corrected = Customer.getQuantitySimpleListViewByIndex(2);
        softAssert.assertEquals(qty2Corrected, correctedQuantity, "Corrected quantity 1200 should be accepted");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}