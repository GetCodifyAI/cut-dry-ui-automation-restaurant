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

public class VerifyOrderGuideHeaderIndicatorsUpdateCorrectlyTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3480")
    public void verifyOrderGuideHeaderIndicatorsUpdateCorrectly() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - user not navigated to dashboard");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide failed");

        String initialCartTotal = Customer.getHeaderCartTotal();
        String initialLineItems = Customer.getHeaderLineItemsCount();
        String initialQuantity = Customer.getHeaderQuantityCount();

        softAssert.assertTrue(initialCartTotal.contains("$"), "Initial cart total should display currency symbol");

        Customer.increaseFirstRowQtyByOne();
        Thread.sleep(2000);

        String lineItemsAfterFirstAdd = Customer.getHeaderLineItemsCount();
        String quantityAfterFirstAdd = Customer.getHeaderQuantityCount();

        softAssert.assertNotEquals(lineItemsAfterFirstAdd, "0", "Line items count should update after adding first item");
        softAssert.assertNotEquals(quantityAfterFirstAdd, "0", "Quantity count should update after adding first item");

        Customer.increaseFirstRowQtyByThree();
        Thread.sleep(2000);

        String quantityAfterIncrease = Customer.getHeaderQuantityCount();
        softAssert.assertNotEquals(quantityAfterIncrease, quantityAfterFirstAdd, "Quantity count should increase when adding more of same item");

        Customer.increaseSecondRowQtyByOne();
        Thread.sleep(2000);

        String lineItemsAfterSecondAdd = Customer.getHeaderLineItemsCount();
        String quantityAfterSecondAdd = Customer.getHeaderQuantityCount();

        int lineItemsCountAfterFirst = parseCount(lineItemsAfterFirstAdd);
        int lineItemsCountAfterSecond = parseCount(lineItemsAfterSecondAdd);
        softAssert.assertTrue(lineItemsCountAfterSecond > lineItemsCountAfterFirst, "Line items count should increment when adding a different item");

        String cartTotalAfterAdding = Customer.getHeaderCartTotal();
        softAssert.assertTrue(cartTotalAfterAdding.contains("$"), "Cart total should display currency symbol after adding items");

        Customer.decreaseFirstRowQtyByOne();
        Thread.sleep(2000);

        String quantityAfterDecrease = Customer.getHeaderQuantityCount();
        int qtyAfterSecondAdd = parseCount(quantityAfterSecondAdd);
        int qtyAfterDecrease = parseCount(quantityAfterDecrease);
        softAssert.assertTrue(qtyAfterDecrease < qtyAfterSecondAdd, "Quantity count should decrease when reducing item quantity");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "Navigation to Catalog failed");

        Customer.clickOnOrderGuideTab();
        Thread.sleep(2000);

        String lineItemsAfterNavigation = Customer.getHeaderLineItemsCount();
        String quantityAfterNavigation = Customer.getHeaderQuantityCount();

        softAssert.assertEquals(lineItemsAfterNavigation, lineItemsAfterSecondAdd, "Line items count should persist after navigation");

        softAssert.assertAll();
    }

    private int parseCount(String countStr) {
        try {
            return Integer.parseInt(countStr.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
