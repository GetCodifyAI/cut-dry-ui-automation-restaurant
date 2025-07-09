package com.cutanddry.qa.tests.Catalog;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.InternalTools;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheOutOfStockLabelsDisplayWhenHideZeroStockLabelOnOperatorAppToggleEnabledTest extends TestBase {
    static User user;
    static String OperatorName ="517030659";
    static String CompanyName = "Lombardi";
    static String itemCode = "7002700";
    static String itemName = "Oyster 12OZ Sel";
    static String itemCodeOG = "2205700";
    static String itemNameOG = "Seabass Portions 8OZ San Isidro";
    static String tag = "Out of stock";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1476")
    public void VerifyTheOutOfStockLabelsDisplayWhenHideZeroStockLabelOnOperatorAppToggleEnabled() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(CompanyName);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.clickHideZeroStockLabelToggle(true);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(itemCodeOG);
        softAssert.assertTrue(Customer.isOrderGuideItemTagDisplayTag(itemNameOG,tag),"tag display og error");

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(itemCode);
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTag(itemName,tag),"tag display catalog error");
        Customer.clickOnPlusIconInCatalogPDP(1, itemName);
        softAssert.assertFalse(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        Customer.clickOnProduct(itemName);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        softAssert.assertTrue(Customer.isPDPItemDisplayTag(itemName,tag),"tag display PDP error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
