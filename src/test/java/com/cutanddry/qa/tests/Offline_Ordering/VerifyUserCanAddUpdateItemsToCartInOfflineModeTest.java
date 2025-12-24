package com.cutanddry.qa.tests.Offline_Ordering;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;

public class VerifyUserCanAddUpdateItemsToCartInOfflineModeTest extends TestBase {
    static User user;
    String itemName;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1244")
    public void VerifyUserCanAddUpdateItemsToCartInOfflineMode() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide failed");

        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        double initialPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(initialPrice > 0, "Item was not added to cart before going offline");

        ChromiumDriver chromiumDriver = (ChromiumDriver) driver;
        Map<String, Object> offlineParams = new HashMap<>();
        offlineParams.put("offline", true);
        offlineParams.put("latency", 0);
        offlineParams.put("downloadThroughput", 0);
        offlineParams.put("uploadThroughput", 0);
        chromiumDriver.executeCdpCommand("Network.enable", new HashMap<>());
        chromiumDriver.executeCdpCommand("Network.emulateNetworkConditions", offlineParams);

        Thread.sleep(2000);

        Customer.increaseFirstRowQtyByOne();
        Thread.sleep(1000);

        String qtyAfterFirstIncrease = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfterFirstIncrease, "2", "Quantity was not updated to 2 in offline mode");

        Customer.increaseFirstRowQtyByOne();
        Thread.sleep(1000);

        String qtyAfterSecondIncrease = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfterSecondIncrease, "3", "Quantity was not updated to 3 in offline mode");

        Customer.decreaseFirstRowQtyByOne();
        Thread.sleep(1000);

        String qtyAfterDecrease = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfterDecrease, "2", "Quantity was not updated to 2 after decrease in offline mode");

        Map<String, Object> onlineParams = new HashMap<>();
        onlineParams.put("offline", false);
        onlineParams.put("latency", 0);
        onlineParams.put("downloadThroughput", -1);
        onlineParams.put("uploadThroughput", -1);
        chromiumDriver.executeCdpCommand("Network.emulateNetworkConditions", onlineParams);

        Thread.sleep(3000);

        String finalQty = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(finalQty, "2", "Quantity did not persist after coming back online");

        double finalPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(finalPrice > 0, "Cart price is not displayed after coming back online");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (driver != null) {
            try {
                ChromiumDriver chromiumDriver = (ChromiumDriver) driver;
                Map<String, Object> onlineParams = new HashMap<>();
                onlineParams.put("offline", false);
                onlineParams.put("latency", 0);
                onlineParams.put("downloadThroughput", -1);
                onlineParams.put("uploadThroughput", -1);
                chromiumDriver.executeCdpCommand("Network.emulateNetworkConditions", onlineParams);
            } catch (Exception e) {
                // Ignore cleanup errors
            }
        }
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
