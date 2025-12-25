package com.cutanddry.qa.tests.OrderGuide;

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

public class VerifyPriceDisclaimerTextOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemName;
    static String searchItemCode;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3487")
    public void verifyPriceDisclaimerTextOnReviewOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertTrue(Customer.getItemPriceOnCheckoutButton() > 0, "The item has not been selected.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");

        softAssert.assertTrue(Customer.isPriceDisclaimerTextDisplayed(), "Price disclaimer text is not displayed on the Review Order screen.");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}