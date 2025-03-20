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

public class VerifyTheAddingSubstituteItemForMultipleUOMDraftAndEditOrderTest extends TestBase {
    static User user;
    String searchItemName = "Beef - Striploin Creekstone Masterchef 0X1";
    String searchItemCde = "00132";
    String searchItemCode = "01409";
    String uomDropDownOption = "Multiple Units";
    String uom1 = "1";
    String uom2 = "2";
    String uom3 = "3";
    static double itemPriceUOM1 ,itemPriceUOM2,itemOGPriceUOM1,itemOGPriceUOM2,totalOGItemPrice, totalItemPrice,totalItemPriceReviewOrder;
    static String totalItemQuantityReviewOrder,orderId;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1092")
    public void VerifyTheAddingSubstituteItemForMultipleUOMDraftAndEditOrder() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCde);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(searchItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(searchItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom3);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(Customer.getItemPriceOnCheckoutButtonViaPDP() * 100.0) / 100.0,(Math.round((itemPriceUOM1 + itemPriceUOM2) * 100.0) / 100.0), "The item has not been selected.");
        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isSetSubstitutionTextDisplayed(),"Substitution pop up error");

        Customer.clickEditSub();
        Customer.clickRemovePreviousSub();
        Customer.clickSaveSelection();

        Customer.clickChooseSub();
        Customer.clickSelectSub();
        Customer.clickSaveSelection();
        Customer.clickCloseSub();

        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();

        Dashboard.navigateToDrafts();
        softAssert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(totalItemPriceReviewOrder)),"draft creating error");
        Drafts.clickDraft(String.valueOf(totalItemPriceReviewOrder));
        softAssert.assertTrue(Customer.isSetSubstitutionTextDisplayed(),"Substitution pop up error");
        Customer.clickCloseSub();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Drafts.clickEditOrder();

        // Added Multi OUM Item OG
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.ClickOnMultiUomDropDownOG(searchItemCode);
        Customer.clickOGAddToCartPlusIcon(1, searchItemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1, searchItemCode, uom2);
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout();
        softAssert.assertEquals(totalOGItemPrice, itemOGPriceUOM1 + itemOGPriceUOM2 + totalItemPriceReviewOrder, "The item was not selected properly.");
        Customer.clickCheckOutPDP();

        softAssert.assertTrue(Customer.isSetSubstitutionTextDisplayed(),"Substitution pop up error");
        Customer.clickCloseSub();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
        totalItemQuantityReviewOrder = Catalog.getTotalQuantityInReviewOrder();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
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
