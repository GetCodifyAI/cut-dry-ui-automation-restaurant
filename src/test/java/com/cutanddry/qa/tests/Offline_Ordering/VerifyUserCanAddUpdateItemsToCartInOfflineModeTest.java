package com.cutanddry.qa.tests.Offline_Ordering;

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

public class VerifyUserCanAddUpdateItemsToCartInOfflineModeTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1244")
    public void verifyUserCanAddUpdateItemsToCartInOfflineMode() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - user not navigated to dashboard");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to order guide failed");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isSwitchToOfflineModeOptionDisplayed(), "Switch to Offline Mode option is not displayed in More Options dropdown");

        Customer.switchToOfflineMode();
        softAssert.assertTrue(Customer.isOfflineModeActive(), "Offline mode is not active after activation");

        String initialQty = Customer.getItemQtyFirstRow();
        double initialCheckoutPrice = Customer.getItemPriceOnCheckoutButton();

        Customer.increaseFirstRowQtyByOne();
        Thread.sleep(1000);
        String qtyAfterIncrease = Customer.getItemQtyFirstRow();
        double checkoutPriceAfterIncrease = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertNotEquals(qtyAfterIncrease, initialQty, "Item quantity did not increase after clicking plus icon");
        softAssert.assertTrue(checkoutPriceAfterIncrease > initialCheckoutPrice, "Checkout total did not increase after adding item");

        Customer.decreaseFirstRowQtyByOne();
        Thread.sleep(1000);
        String qtyAfterDecrease = Customer.getItemQtyFirstRow();
        double checkoutPriceAfterDecrease = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertEquals(qtyAfterDecrease, initialQty, "Item quantity did not decrease after clicking minus icon");
        softAssert.assertEquals(checkoutPriceAfterDecrease, initialCheckoutPrice, "Checkout total did not decrease after removing item");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}