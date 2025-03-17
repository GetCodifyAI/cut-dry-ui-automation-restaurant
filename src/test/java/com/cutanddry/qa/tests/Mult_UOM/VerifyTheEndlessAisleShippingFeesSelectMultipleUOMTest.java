package com.cutanddry.qa.tests.Mult_UOM;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheEndlessAisleShippingFeesSelectMultipleUOMTest extends TestBase {
    static User user;
    String searchItemName = "Chewable Tablets Original Flavor 30/Box";
    String searchItemCde = "PGC03977BX";
    static String orderId;
    String userName = "email@1sttreatyogurt";
    static double totalEndlessAislePriceReviewOrder,subTotalEndlessAislePriceReviewOrder;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1074")
    public void VerifyTheEndlessAisleShippingFeesSelectMultipleUOM() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);

        Customer.clickOnPlaceOrderSW();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCde);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(searchItemName.toLowerCase()), "item not found");
        Customer.clickOnPlusIconInCatalogPDP(1, searchItemCde);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalEndlessAislePriceReviewOrder = Catalog.getTotalEndlessAislePriceInReviewOrder();
        subTotalEndlessAislePriceReviewOrder = Catalog.getTotalEndlessAisleSubTotalPriceInReviewOrder();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertEquals(Catalog.getSubTotalPriceInOrder(),subTotalEndlessAislePriceReviewOrder,"order not successfully submitted");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
