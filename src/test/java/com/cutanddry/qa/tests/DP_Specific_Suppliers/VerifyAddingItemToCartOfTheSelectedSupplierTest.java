package com.cutanddry.qa.tests.DP_Specific_Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Catalog;
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

public class VerifyAddingItemToCartOfTheSelectedSupplierTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";
    static String searchItemCode = "22399";
    static String itemName = "Spinach Baby";
    static double catalogItemPrice;




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-126")
    public void VerifyAddingItemToCartOfTheSelectedSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        Dashboard.chooseProductCatalog(chooseCatalog);
        Dashboard.clickCategory();
        softAssert.assertTrue(Catalog.isCategoryDisplayed(),"category not display");
        Customer.searchItemOnCatalog(searchItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Customer.clickOnPlusIconInCatalogPDP(5, itemName);
        catalogItemPrice = Customer.catalogItemPrice(itemName);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),catalogItemPrice*5,0.1,"The item has not been selected.");


        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");

        Dashboard.switch1932Saval();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        Dashboard.clickCategory();
        softAssert.assertTrue(Catalog.isCategoryDisplayed(),"category not display");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),0.0,"The item has not been selected.");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
