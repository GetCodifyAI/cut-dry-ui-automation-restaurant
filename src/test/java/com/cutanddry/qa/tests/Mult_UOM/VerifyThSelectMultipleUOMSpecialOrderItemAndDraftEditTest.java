package com.cutanddry.qa.tests.Mult_UOM;

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

public class VerifyThSelectMultipleUOMSpecialOrderItemAndDraftEditTest extends TestBase {
    static User user;
    String searchItemName = "S/O Sauce Chili Oil";
    String searchItemCde = "0005";
    String multiSearchItemCode = "2969";
    String OperatorName = "katdmejia2@gmail.com";
    String uomDropDownOption = "Multiple Units";
    String uom1 = "1";
    String uom2 = "2";
    static double itemPriceUOM1 ,itemPriceUOM2,totalPDPItemPrice;
    static double itemOGPriceUOM1,itemOGPriceUOM2,totalOGItemPrice;
    String orderId,totalItemQuantityReviewOrder;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1088")
    public void VerifyThSelectMultipleUOMSpecialOrderItemAndDraftEdit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();

        Customer.clickOnPlaceOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCde);
        Customer.goToCatalog();

        Catalog.clickItemType();

        Catalog.ClickOnMultiUomDropDown(searchItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalPDPItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalPDPItemPrice * 10.0) / 10.0,
                (Math.round((itemPriceUOM1 + itemPriceUOM2) * 10.0) / 10.0), "The item has not been selected.");
        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(totalPDPItemPrice)),"draft creating error");
        Drafts.clickDraft(String.valueOf(totalPDPItemPrice));
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        Drafts.clickEditOrder();
        // Added Multi OUM Item
        Customer.searchItemOnOrderGuide(multiSearchItemCode);
        //Customer.ClickOnMultiUomDropDownOG(multiSearchItemCode);
        Customer.clickOGAddToCartPlusIcon(1, multiSearchItemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1, multiSearchItemCode, uom2);
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout(); //Customer.getItemPriceOnCheckoutButton();
        softAssert.assertEquals(totalOGItemPrice, itemOGPriceUOM1 + itemOGPriceUOM2 + totalPDPItemPrice, 0.001, "The item was not selected properly.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertEquals(Catalog.getTotalQuantityInOrder(),totalItemQuantityReviewOrder,"order quantity not successfully submitted");
        softAssert.assertEquals(Catalog.getTotalPriceInOrder(),totalOGItemPrice, 0.01,"order not successfully submitted");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
