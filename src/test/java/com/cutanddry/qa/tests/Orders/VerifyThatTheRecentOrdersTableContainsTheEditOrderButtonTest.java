package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyThatTheRecentOrdersTableContainsTheEditOrderButtonTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";
    static String OperatorName = "Amir IFC WL";
    static String orderId ,orderId2;
    static double itemPrice;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1558")
    public void VerifyThatTheRecentOrdersTableContainsTheEditOrderButton() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.settingsWLGateKeeper();
        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.searchItemOnOrderGuide(itemName);
        softAssert.assertTrue(Customer.getItemNameFirstRow().equalsIgnoreCase(itemName),"item mismatch");
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(1);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        Dashboard.navigateToHome();
        softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(),"recent order text display");
        Customer.clickRecentSubmitOrder(orderId);
        softAssert.assertTrue(History.isEditOrderPopUpDisplayed(),"Edit order pop up window not display");
        History.clickConfirmEditOrder();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.increaseFirstRowQtyCustom(1);

        Customer.submitOrder();
        softAssert.assertTrue(History.isOrderEditRequestPopupDisplayed(),"Order edit request not sent");
        orderId2 = Customer.getSuccessOrderId();
        Customer.clickClose();

        Dashboard.navigateToHome();
        softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(),"recent order text display");
        softAssert.assertTrue(Customer.isRecentSubmitOrderDisplay(orderId2),"edit order display error");
        softAssert.assertTrue(Customer.isRecentSubmitOrderQuantityDisplay(orderId2,"2"),"edit order quantity error");
        softAssert.assertEquals(Customer.getRecentItemPrice(orderId2),itemPrice*2,"edit price error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }

}
