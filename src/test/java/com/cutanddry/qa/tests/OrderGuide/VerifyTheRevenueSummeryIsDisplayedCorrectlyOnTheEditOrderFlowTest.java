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

public class VerifyTheRevenueSummeryIsDisplayedCorrectlyOnTheEditOrderFlowTest extends TestBase {
    static User user;
    static String itemName,orderId;
    static double itemPrice,totalOrderMinimum;
    static String searchItemCode = "01700";
    static String totalLineValue,totalQuantityValue,marginValue;
    static String orderSummary = "Order Summary";
    static String totalLine = "Line Items";
    static String totalQuantity = "Quantity";
    static String orderMinimum = "Order Minimum";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1505")
    public void VerifyTheRevenueSummeryIsDisplayedCorrectlyOnTheEditOrderFlow() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        // Restaurant Flows
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.searchItemOnOrderGuide(searchItemCode);
        itemName = Customer.getItemNameFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice,"The item has not been selected.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");
        softAssert.assertTrue(Customer.isDeliveryOptionSelected(), "The expected fulfillment type is not selected.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.ensureOrderDateSortedDescending();
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        History.clickEditOrder();
        softAssert.assertTrue(History.isEditOrderPopUpDisplayed(),"Edit order pop up window not display");
        History.clickConfirmEditOrder();

        Customer.clickCartSummery();
        totalLineValue = Customer.getCartSummeryValue(totalLine);
        totalQuantityValue = Customer.getCartSummeryValue(totalQuantity);
        totalOrderMinimum = Customer.getOrderMinimumValueStable(orderMinimum);

        softAssert.assertTrue(Customer.isCartSummaryDisplay(orderSummary),"cart summary display error");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalLine),totalLineValue,"cart summary value display error");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalQuantity),totalQuantityValue,"cart summary value display error");
        softAssert.assertEquals(Customer.getOrderMinimumValueStable(orderMinimum),totalOrderMinimum,"cart summary value display error");


        Customer.clickOnEditOrderInReviewStable();
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyCustom(1);

        Customer.clickCartSummery();
        softAssert.assertTrue(Customer.isCartSummaryDisplay(orderSummary),"cart summary display error OG");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalLine),totalLineValue,"cart summary value display error OG");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalQuantity),"2","cart summary value display error OG");
        softAssert.assertEquals(Customer.getOrderMinimumValueStable(orderMinimum),totalOrderMinimum*2,"cart summary value display error OG");

        // Add the product via Catalog
        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCode);
        Customer.clickOnPlusIconInCatalogPDP(1, itemName);

        Customer.clickCartSummery();
        softAssert.assertTrue(Customer.isCartSummaryDisplay(orderSummary),"cart summary display error Catalog");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalLine),totalLineValue,"cart summary value display error Catalog");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalQuantity),"3","cart summary value display error Catalog");
        softAssert.assertEquals(Customer.getOrderMinimumValueStable(orderMinimum),totalOrderMinimum*3,"cart summary value display error Catalog");

        // Add the product via PDP
        Customer.clickOnProduct(itemName);
        Thread.sleep(10000);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        Customer.clickOnPlusIconInCatalogPDP(1, itemName);
        Customer.clickCheckOutPDP();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.clickCartSummery();
        softAssert.assertTrue(Customer.isCartSummaryDisplay(orderSummary),"cart summary display error");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalLine),totalLineValue,"cart summary value display error");
        softAssert.assertEquals(Customer.getCartSummeryValue(totalQuantity),"4","cart summary value display error");
        softAssert.assertEquals(Customer.getOrderMinimumValueStable(orderMinimum),totalOrderMinimum*4,"cart summary value display error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
