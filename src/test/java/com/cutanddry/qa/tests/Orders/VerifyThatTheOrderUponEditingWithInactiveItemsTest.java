package com.cutanddry.qa.tests.Orders;

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

public class VerifyThatTheOrderUponEditingWithInactiveItemsTest extends TestBase {
    static User user;
    static String Dp_Name = "46505655 - Kevin - Independent Foods Co";
    String searchItemCode = "01775";
    static String itemName, orderId;
    static double itemPrice;
    String Active = "Active";
    String InActive = "Inactive";
    String All = "All";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2538")
    public void VerifyThatTheOrderUponEditingWithInactiveItems() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
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
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.selectItemStatus(All);
        Catalog.searchItemInCatalog(searchItemCode);
        Catalog.selectItemFromGrid(searchItemCode);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(),searchItemCode,"Error in getting Item Code");
        Catalog.selectEditFromProductConfig();
        Catalog.selectProductActiveInactiveStatus(InActive);
        Catalog.saveChanges();

        Login.navigateToOperator();

        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.ensureOrderDateSortedDescending();
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        History.clickEditOrder();
        softAssert.assertTrue(History.isEditOrderPopUpDisplayed(),"Edit order pop up window not display");
        History.clickConfirmEditOrder();

        softAssert.assertTrue(Order.isInactiveItemDetectedPopUpDisplay(),"item not inactive");
        Customer.clickOK();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Math.round(Catalog.getTotalPriceInReviewOrder() * 100.0) / 100.0,
                0.00, "Total price in review order is not zero.");

        // Distributor Flows
        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Login.switchIntoNewTab();
        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.selectItemStatus(All);
        Catalog.searchItemInCatalog(searchItemCode);
        Catalog.selectItemFromGrid(searchItemCode);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(),searchItemCode,"Error in getting Item Code");
        Catalog.selectEditFromProductConfig();
        Catalog.selectProductActiveInactiveStatus(Active);
        Catalog.saveChanges();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
