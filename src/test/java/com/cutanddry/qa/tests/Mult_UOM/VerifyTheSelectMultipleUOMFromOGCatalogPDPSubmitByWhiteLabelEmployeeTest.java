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

public class VerifyTheSelectMultipleUOMFromOGCatalogPDPSubmitByWhiteLabelEmployeeTest extends TestBase {
    static User user;
    String searchItemName2 = "Carrot - Baby Peeled - 1 LB";
    String searchItemCode2 = "01409";
    String searchItemCode = "00529";
    String OperatorName = "429739320";
    String uomDropDownOption = "Multiple Units";
    String uom1 = "1";
    String uom2 = "2";
    static double itemPriceUOM1 ,itemPriceUOM2,totalPDPItemPrice,totalItemPriceReviewOrder;
    static double itemOGPriceUOM1,itemOGPriceUOM2,totalOGItemPrice;
    String totalItemQuantityReviewOrder;
    static String referenceNum;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1020")
    public void VerifyTheSelectMultipleUOMFromOGCatalogPDPSubmitByWhiteLabelEmployee() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.settingsWLGateKeeper();
        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        // Added Multi OUM Item OG
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.ClickOnMultiUomDropDownOG(searchItemCode);
        Customer.clickOGAddToCartPlusIcon(1, searchItemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1, searchItemCode, uom2);
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout();
        softAssert.assertEquals(totalOGItemPrice, itemOGPriceUOM1 + itemOGPriceUOM2, "The item was not selected properly.");
        Customer.goToCatalog();

        // Added Multi OUM Item PDP
        Customer.searchItemOnCatalog(searchItemCode2);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(searchItemName2.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(searchItemName2);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalPDPItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalPDPItemPrice * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)+(Math.round(totalOGItemPrice * 100.0) / 100.0)), "The item has not been selected.");
        Customer.clickCheckOutPDP();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isSentApprovalDisplayed(),"sent approval pop up not display");
        Customer.clickViewOrderInDraft();
        softAssert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        referenceNum = Drafts.getReferenceNum();
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(totalItemPriceReviewOrder)),"draft creating error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
