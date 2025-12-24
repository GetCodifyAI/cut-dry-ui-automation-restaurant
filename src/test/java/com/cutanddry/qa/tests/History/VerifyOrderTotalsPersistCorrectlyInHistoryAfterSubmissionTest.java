package com.cutanddry.qa.tests.History;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyOrderTotalsPersistCorrectlyInHistoryAfterSubmissionTest extends TestBase {
    static User user;
    static String orderId;
    static double cartTotalOnOrderGuide;
    static double totalOnReviewOrder;
    static double totalInHistory;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3491")
    public void verifyOrderTotalsPersistCorrectlyInHistoryAfterSubmission() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.increaseFirstRowQtyByOne();
        Customer.increaseSecondRowQtyByOne();
        cartTotalOnOrderGuide = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(cartTotalOnOrderGuide > 0, "Cart total should be greater than 0 after adding items");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        totalOnReviewOrder = Customer.getItemPriceReviewCart();
        softAssert.assertEquals(Math.round(totalOnReviewOrder * 100.0) / 100.0,
                Math.round(cartTotalOnOrderGuide * 100.0) / 100.0,
                "Review Order total should match the cart total from Order Guide");

        softAssert.assertTrue(Customer.isDeliveryOptionSelected(), "Delivery option should be selected by default");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(), "History navigation error");

        History.ensureOrderDateSortedDescending();
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the history list.");

        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(), "Order details section not displayed");


        totalInHistory = History.getItemPriceOnMultiOUM();
        softAssert.assertEquals(Math.round(totalInHistory * 100.0) / 100.0,
                Math.round(totalOnReviewOrder * 100.0) / 100.0,
                "Order total in History should match the total from Review Order screen");

        History.clickOnItems();
        softAssert.assertTrue(History.checkIfItemSectionVisible(), "Items section should be visible in order details");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}