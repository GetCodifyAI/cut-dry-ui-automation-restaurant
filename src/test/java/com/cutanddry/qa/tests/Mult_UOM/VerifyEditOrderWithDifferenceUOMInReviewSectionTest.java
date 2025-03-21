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

public class VerifyEditOrderWithDifferenceUOMInReviewSectionTest extends TestBase {
    static User user;
    String searchItemName = "Organic Bananas - 2 LB";
    String searchItemCde = "00529";
    String uomDropDownOption = "Multiple Units";
    String uom1 = "1";
    String uom2 = "2";
    static double itemPriceUOM1 ,itemPriceUOM2,totalPrice1,totalItemPriceReviewOrder;
    String orderId,totalItemQuantityReviewOrder;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1051")
    public void VerifyEditOrderWithDifferenceUOMInReviewSection() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCde);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(searchItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(searchItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalPrice1 = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalPrice1 * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)), "The item has not been selected.");
        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        Drafts.clickEditOrder();
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        softAssert.assertEquals(Math.round(Customer.getItemPriceOnCheckoutButtonViaPDP() * 100.0) / 100.0,
                ((Math.round(totalPrice1 * 100.0) / 100.0)*2), "The item has not been selected.");

        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();
        softAssert.assertEquals(Catalog.getTotalItemCount(),"4","item count not equal");
        softAssert.assertEquals(Math.round(Catalog.getTotalPriceUOM() * 100.0) / 100.0,
                ((Math.round(totalPrice1 * 100.0) / 100.0)*2), "Total price not correct");

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
        softAssert.assertEquals(Catalog.getTotalPriceInOrder(),totalItemPriceReviewOrder,"order not successfully submitted");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
