package com.cutanddry.qa.tests.Catalog;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyCatalogGridViewStepperMaxQuantityValidationTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyCatalogGridViewStepperMaxQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"navigation to catalog error");

        Customer.searchItemOnCatalog(itemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found in catalog");

        Customer.clickOnPlusIconInCatalogPDP(1998, itemName);

        Customer.clickOnPlusIconInCatalogPDP(1, itemName);

        Customer.clickOnPlusIconInCatalogPDP(1, itemName);

        softAssert.assertTrue(Customer.isMaxQuantityExceededModalDisplayed(), "Maximum Quantity Exceeded modal should be displayed in Catalog Grid View");
        softAssert.assertTrue(Customer.isMaxQuantityExceededMessageDisplayed(), "Maximum quantity message should be displayed in Catalog Grid View");

        Customer.clickMaxQuantityModalOk();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
