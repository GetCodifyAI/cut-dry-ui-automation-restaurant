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

public class VerifyThatTheRecentOrdersTableContainsTheAddToOrderButtonTest extends TestBase {
    static User user;
    static String itemCode = "08111";
    static String OperatorName = "236140414";
    static String orderId ,orderId2,itemCode2,totalItemQuantityReviewOrder;
    static double itemPrice,totalItemPriceReviewOrder;
    static String distributor = "Carpe Diem Specialty Foods";
    String vvv;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1559")
    public void VerifyThatTheRecentOrdersTableContainsTheAddToOrderButton() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.TurnOnOrderMinimumGloballyToggle(false);
        InternalTools.caseMinimumGloballyToggle(false);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrderGuideCustom();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.searchItemOnOrderGuide(itemCode);
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(16);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrderRebate();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        Dashboard.navigateToHome();
        softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(),"recent order text display");
        Customer.clickAddToRecentSubmitOrder(orderId);
        softAssert.assertTrue(History.isAddToOrderPopUpDisplayed(),"Add to order pop up window not display");
        History.clickConfirmEditOrder();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.decreaseReviewQtyStable(itemCode,1);
        softAssert.assertEquals(Customer.getItemQuantityReviewPage(itemCode),"16","item quantity not equal");
        softAssert.assertFalse(Customer.isTrashCanReviewPage(itemCode),"trash can display item");

        Drafts.clickEditOrder();

        itemCode2 = Customer.getItemCodeFirstRow();
        Customer.increaseFirstRowQtyCustom(2);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.decreaseReviewQtyStable(itemCode2,1);
        softAssert.assertEquals(Customer.getItemQuantityReviewPage(itemCode2),"1","item quantity not equal");
        softAssert.assertTrue(Customer.isTrashCanReviewPage(itemCode2),"trash can not display second item");
        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();

        Customer.submitOrder();
        softAssert.assertTrue(History.isOrderEditRequestPopupDisplayed(),"Order edit request not sent");
        orderId2 = Customer.getSuccessOrderId();
        Customer.clickClose();

        Dashboard.navigateToHome();
        softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(),"recent order text display");
        softAssert.assertTrue(Customer.isRecentAddedOrderDisplay(orderId2),"edit order display error");
        softAssert.assertTrue(Customer.isRecentSubmitOrderQuantityDisplay(orderId2,totalItemQuantityReviewOrder),"edit order quantity error");
        softAssert.assertEquals(Customer.getRecentItemPrice(orderId2),totalItemPriceReviewOrder,"edit price error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }

}
