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

public class VerifyProductWithDifferentCombinationsOfUOMsCanBeAddedFromCatalogInOrderReviewSectionTest extends TestBase {
    static User user;
    SoftAssert softAssert;
    String uom1 = "1";
    String uom2 = "2";
    static double itemPriceUOM1 ,itemPriceUOM2, totalHistoryItemPrice, totalHistoryItemCount,totalPDPItemPrice,subTotalPDPItemPrice;
    static String singleSearchItemCode, multiCatalogItemName, orderId;
    String uomDropDownOption = "Multiple Units";
    static String catalogItem = "01762";// 32120
    static String multiItemName= "Carrot - Baby Peeled - 1 LB";
    static String itemCode = "01409";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1049")
    public void VerifyProductWithDifferentCombinationsOfUOMsCanBeAddedFromCatalogInOrderReviewSection() throws InterruptedException {
        softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(itemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(multiItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(multiItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        subTotalPDPItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        System.out.println(subTotalPDPItemPrice);
        System.out.println(((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)));
        softAssert.assertEquals(Math.round(subTotalPDPItemPrice * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)), "The item has not been selected at 1st item.");

        Catalog.clickBack();
        Customer.searchItemOnCatalog(catalogItem);
        multiCatalogItemName = Customer.getFirstElementFrmCatalogSearchResults();
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(multiCatalogItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(multiCatalogItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalPDPItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        System.out.println(totalPDPItemPrice);
        System.out.println(((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)+Math.round(subTotalPDPItemPrice * 100.0) / 100.0));
        softAssert.assertEquals(Math.round(totalPDPItemPrice * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)+Math.round(subTotalPDPItemPrice * 100.0) / 100.0), "The item has not been selected at 2nd item.");


        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        singleSearchItemCode = Customer.getItemCodeFirstRow().trim();
//        softAssert.assertEquals(singleSearchItemCode,multiSearchItemCode,"The product item codes on the 'Review Order' page is not match the item codes of the products added.");
        softAssert.assertTrue(singleSearchItemCode.equals(itemCode) || singleSearchItemCode.equals(catalogItem), "The product item codes on the 'Review Order' page do not match the expected item codes.");

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
        totalHistoryItemPrice = History.getItemPriceOnMultiOUM();
        totalHistoryItemCount = History.getItemCountOnReviewMultiOUM();
        softAssert.assertEquals(Math.round(totalHistoryItemPrice * 100.0) / 100.0,Math.round(totalPDPItemPrice * 100.0) / 100.0,"The product total price on the 'Review Order' page is not matched with the ordered product details under the 'History' page.");
        softAssert.assertEquals(totalHistoryItemCount,4.0,"The product units on the 'Review Order' page should be matched with the ordered product details under the 'History' page.");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }

}
