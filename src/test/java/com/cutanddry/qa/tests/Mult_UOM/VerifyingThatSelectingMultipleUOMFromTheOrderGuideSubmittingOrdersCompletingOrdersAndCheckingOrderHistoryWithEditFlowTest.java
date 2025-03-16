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

public class VerifyingThatSelectingMultipleUOMFromTheOrderGuideSubmittingOrdersCompletingOrdersAndCheckingOrderHistoryWithEditFlowTest extends TestBase {
    static User user;
    SoftAssert softAssert;
    String uom1 = "1";
    String uom2 = "2";
    static double itemOGPriceUOM1 ,itemOGPriceUOM2,totalOGItemPrice, multiItemPrice,totalHistoryItemPrice;
    static String singleItemName, singleSearchItemCode, multiItemName, multiSearchItemCode, itemCode,singleSearchItemCodeEdit, orderId;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-806")
    public void VerifyingThatSelectingMultipleUOMFromTheOrderGuideSubmittingOrdersCompletingOrdersAndCheckingOrderHistoryWithEditFlow() throws InterruptedException {
        softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.sortItemsByCustomOrder();

        singleItemName = Customer.getItemNameFirstRow();
        singleSearchItemCode = Customer.getItemCodeFirstRow();

        multiItemName = Customer.getItemNameFirstMultiOUM();
        multiSearchItemCode = Customer.getItemCodeFirstMultiOUM();
        itemCode = multiSearchItemCode.replaceAll("^[A-Za-z]+", "");
        multiItemPrice = Customer.getActiveItemPriceFirstMultiOUMRowStable();

        Customer.searchItemOnOrderGuide(multiSearchItemCode);
        Customer.ClickOnMultiUomDropDownOG(itemCode);
        Customer.clickOGAddToCartPlusIcon(1,itemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1,itemCode, uom2);
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom1), "1", "item count error in 1st UOM");
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom2), "1", "item count error in 2nd UOM");
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout();
        softAssert.assertEquals(Math.round(totalOGItemPrice * 100.0) / 100.0,
                ((Math.round(itemOGPriceUOM1 * 100.0) / 100.0) + (Math.round(itemOGPriceUOM2 * 100.0) / 100.0)), "The item was not selected properly.");

        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickOnFirstItemOfOrderHistory();
        totalHistoryItemPrice = History.getItemPriceOnMultiOUM();
        softAssert.assertEquals(Math.round(totalHistoryItemPrice * 100.0) / 100.0,Math.round(totalOGItemPrice * 100.0) / 100.0);
        History.clickEditOrder();
        softAssert.assertTrue(History.isEditOrderPopUpDisplayed(),"Edit order pop up window not display");
        History.clickConfirmEditOrder();
        singleSearchItemCodeEdit = Customer.getItemCodeFirstRow().trim();
        softAssert.assertEquals(singleSearchItemCodeEdit,multiSearchItemCode,"The product item codes on the 'Review Order' page is not match the item codes of the products added.");

        Customer.clickOGAddToCartPlusIcon(2,itemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(2,itemCode, uom2);
        itemOGPriceUOM1 = Customer.getItemPriceReviewCartMultiUOM(uom1);
        itemOGPriceUOM2 = Customer.getItemPriceReviewCartMultiUOM(uom2);
        softAssert.assertEquals(Customer.getItemPriceReviewCart(),totalOGItemPrice*3,"price error after increase");

        Customer.clickAddToCartMinusIcon(1,itemCode, uom1);
        Customer.clickAddToCartMinusIcon(1,itemCode, uom2);
        softAssert.assertEquals(Customer.getItemPriceReviewCart(),totalOGItemPrice*2,"price error after decrease");

        History.clickSubmitEditOrder();
        softAssert.assertTrue(History.isOrderEditRequestPopupDisplayed(),"Order edit request not sent");
        History.clickOkEditOrder();
        softAssert.assertTrue(History.isOrderIdDisplayed(orderId), "The user is unable to navigate back to the submitted order details page.");
        softAssert.assertEquals(History.getItemPriceOnSubmittedOrder(),totalOGItemPrice*2,"price error after decrease");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
