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

public class VerifyTheAddingSubstituteItemForMultipleUOMDraftAndEditOrderTest extends TestBase {
    static User user;
    String searchItemName = "Organic Bananas - 2 LB";
    String searchItemCde = "00529";
    String searchItemCode = "01409";
    String substituteItemCode = "01922";
    String uomDropDownOption = "Multiple Units";
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";
    String uom1 = "1";
    String uom2 = "2";
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

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        // Add substitute
        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.searchItemInCatalog(searchItemCde);
        Catalog.selectItemFromGrid(searchItemCde);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(),searchItemCde,"Error in getting Item Code");
        Catalog.navigateToSubstituteTab();
        Catalog.removeExistingItem(searchItemCde);
        Catalog.addSubstitutions();
        String SubstituteItemName = Catalog.getSubstituteItemName(substituteItemCode);
        Catalog.searchAndAddSubstituteItem(substituteItemCode);
        Catalog.saveChanges();
        softAssert.assertTrue(Catalog.successOverlayDisplayed(),"Error in saving the changes after adding  substitute");
        softAssert.assertTrue(Catalog.isAddedSubstituteItemDisplayedInPage(SubstituteItemName),"Error in adding substitute items");


        Login.navigateToOperator();
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
        totalItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(Customer.getItemPriceOnCheckoutButtonViaPDP() * 100.0) / 100.0,(Math.round((itemPriceUOM1 + itemPriceUOM2) * 100.0) / 100.0), "The item has not been selected.");
        Customer.clickCheckOutPDP();

        Customer.clickSubstitution();
        softAssert.assertTrue(Customer.isSetSubstitutionPopUPDisplayed(),"Substitution set pop up error1");
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
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(totalItemPriceReviewOrder)),"draft creating error");
        Drafts.clickDraft(String.valueOf(totalItemPriceReviewOrder));
        softAssert.assertTrue(Customer.isSetSubstitutionTextDisplayed(),"Substitution pop up error2");
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


        Customer.clickCloseSub();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        totalItemPriceReviewOrder = Catalog.getTotalPriceInReviewOrder();
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
        softAssert.assertEquals(Catalog.getTotalPriceInOrder(),totalItemPriceReviewOrder,"order not successfully submitted");

        // Distributor Flows
        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Login.switchIntoNewTab();
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.searchItemInCatalog(searchItemCde);
        Catalog.selectItemFromGrid(searchItemCde);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(),searchItemCde,"Error in getting Item Code");
        Catalog.navigateToSubstituteTab();
        Catalog.deleteSubstitute();
        Catalog.saveChanges();
        softAssert.assertTrue(Catalog.successOverlayDisplayed(),"Error in Removing substitute item");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
