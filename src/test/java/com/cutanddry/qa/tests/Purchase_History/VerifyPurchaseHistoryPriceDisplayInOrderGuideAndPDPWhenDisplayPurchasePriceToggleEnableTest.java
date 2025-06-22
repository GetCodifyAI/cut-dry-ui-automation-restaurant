package com.cutanddry.qa.tests.Purchase_History;

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

public class VerifyPurchaseHistoryPriceDisplayInOrderGuideAndPDPWhenDisplayPurchasePriceToggleEnableTest extends TestBase {
    static User user;
    String searchItemName = "Carrot - Baby Peeled - 1 LB";
    String searchItemCode = "01409";
    String uomDropDownOption = "Multiple Units";
    static String distributor = "Independent Foods Co";
    String uom1 = "1";
    String uom2 = "2";
    static double itemOGPriceUOM1 ,itemOGPriceUOM2;
    static String priceColumn = "Price";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1432")
    public void VerifyPurchaseHistoryPriceDisplayInOrderGuideAndPDPWhenDisplayPurchasePriceToggleEnable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.displayPurchaseHistoryToggle(true);
        InternalTools.displayPurchasePriceOnOperatorToggle(true);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToOperator();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.ClickOnMultiUomDropDownOG(searchItemCode);
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        Customer.clickLastOrderOG(searchItemCode);
        softAssert.assertTrue(Customer.isPurchaseHistoryDisplay(),"Purchase history window display error");
        softAssert.assertTrue(Catalog.isPriceColumnDisplay(priceColumn),"price column not display");
        softAssert.assertTrue(Catalog.isLastOrderPriceDisplay(String.valueOf(itemOGPriceUOM1)),"PDP last order price not display");
        softAssert.assertTrue(Catalog.isLastOrderPriceDisplay(String.valueOf(itemOGPriceUOM2)),"PDP last order price not display");
        Customer.clickClose();

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(searchItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(searchItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        Catalog.clickPurchaseHistory();
        softAssert.assertTrue(Customer.isPurchaseHistoryDisplay(),"Purchase history window display error");
        softAssert.assertTrue(Catalog.isPriceColumnDisplay(priceColumn),"price column not display");
        softAssert.assertTrue(Catalog.isLastOrderPriceDisplay(String.valueOf(itemOGPriceUOM1)),"PDP last order price not display");
        softAssert.assertTrue(Catalog.isLastOrderPriceDisplay(String.valueOf(itemOGPriceUOM2)),"PDP last order price not display");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
