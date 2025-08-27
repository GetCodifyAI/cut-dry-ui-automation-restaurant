package com.cutanddry.qa.tests.Non_Integrated_Suppliers.Coupa_Cafe;

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

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyCoupaCafeNonIntegratedSupplierOrderEditTest {
    static User user;
    String userName = "jcoupal@coupacafe";
    String supplierName = "David Rio";
    String orderId;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-847")
    public void VerifyCoupaCafeNonIntegratedSupplierOrderEdit() throws InterruptedException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");

        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyInClassic(1);
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.increaseFirstRowQtyInClassic(2);
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(),"Order section not display");
        History.clickEditOrder();
        softAssert.assertTrue(History.isEditOrderPopUpDisplayed(),"Edit order pop up window not display");
        History.clickConfirmEditOrder();
        Customer.increaseFirstRowQtyInClassic(3);
        Customer.checkoutItems();
        softAssert.assertTrue(History.isReviewOrderTextDisplayed(),"Review order section not display");
        History.clickSubmitEditOrder();
        softAssert.assertTrue(History.isOrderEditRequestPopupDisplayed(),"Order edit request not sent");
        softAssert.assertAll();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
