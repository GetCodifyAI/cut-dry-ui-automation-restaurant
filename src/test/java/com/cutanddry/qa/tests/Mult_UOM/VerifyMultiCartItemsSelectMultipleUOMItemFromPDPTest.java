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

public class VerifyMultiCartItemsSelectMultipleUOMItemFromPDPTest extends TestBase {
    static User user;
    String searchItemCode = "27457";
    String itemName = "A/P Deo Men Adventure";
    String itemName2 = "Hacomat Season";

    String uom1 = "1";
    String uom2 = "2";
    static double item2PriceUOM1 ,item2PriceUOM2,itemPriceUOM1,itemPriceUOM2,totalItemPrice1,totalItemPrice2;
    static String OperatorName = "(explorer) - Bermuda Biological Station";
    String orderId1,orderId2;



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-804")
    public void VerifyMultiCartItemsSelectMultipleUOMItemFromPDP() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToLoginAs();
        Login.goToOperatorBermudaBiologicalStation(OperatorName);
        restaurantUI.switchToNewTab();
        Customer.clickOnPlaceOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.clickOnProduct(itemName);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalItemPrice1 =Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalItemPrice1 * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)), "The Retail items have not been selected.");
        Catalog.clickBack();

        Customer.clickOnProduct(itemName2);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        item2PriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        item2PriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalItemPrice2 =Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalItemPrice2 * 100.0) / 100.0,
                ((Math.round(item2PriceUOM1 * 100.0) / 100.0)+(Math.round(item2PriceUOM2 * 100.0) / 100.0)+(Math.round(totalItemPrice1 * 100.0) / 100.0)), "The Food Service items have not been selected.");

        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertTrue(Customer.isMultiDistCentersDisplayed(),"multi cart error");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId1 = Catalog.getMultiOrderedId(uom1);
        orderId2 = Catalog.getMultiOrderedId(uom2);
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId1);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId1), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
