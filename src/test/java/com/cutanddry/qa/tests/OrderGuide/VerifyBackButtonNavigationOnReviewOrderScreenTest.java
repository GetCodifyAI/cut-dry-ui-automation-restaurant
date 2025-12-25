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

public class VerifyBackButtonNavigationOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemName;
    static String searchItemCode;
    static double initialCartPrice;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3486")
    public void verifyBackButtonNavigationOnReviewOrderScreen() throws InterruptedException {
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
        initialCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(initialCartPrice > 0, "The item has not been selected.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");

        Customer.editOrderFromReviewScreen();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Back navigation failed - user is not on Order Guide screen.");

        Customer.searchItemOnOrderGuide(searchItemCode);
        double cartPriceAfterBack = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertEquals(cartPriceAfterBack, initialCartPrice, "Cart contents were not preserved after back navigation.");

        Customer.increaseFirstRowQtyCustom(1);
        double updatedCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(updatedCartPrice > initialCartPrice, "Unable to modify quantity after back navigation.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after modifying quantities.");

        Customer.editOrderFromReviewScreen();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Second back navigation failed - user is not on Order Guide screen.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to return to Review Order page after multiple back navigations.");

        Customer.decreaseReviewQtyStable(searchItemCode, 2);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
