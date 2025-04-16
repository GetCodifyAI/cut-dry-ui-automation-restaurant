package com.cutanddry.qa.tests.DP_Specific_Suppliers;

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

public class ValidateDraftCreationOfTheSelectedSupplierTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";
    String itemName1,searchItemCode1,itemName2,searchItemCode2,orderId;
    static double itemPrice1,itemPrice2;





    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-128")
    public void ValidateDraftCreationOfTheSelectedSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        Dashboard.chooseProductCatalog(chooseCatalog);
        Customer.clickOnPlaceOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName1 = Customer.getItemNameFirstRow();
        searchItemCode1 = Customer.getItemCodeFirstRow();
        itemPrice1 = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice1,"The item has not been selected.");

        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");

        Dashboard.switch1932Saval();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        Customer.clickOnPlaceOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName2 = Customer.getItemNameFirstRow();
        searchItemCode2 = Customer.getItemCodeFirstRow();
        itemPrice2 = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice2,"The item has not been selected.");

        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");
        Dashboard.switchSavalFood();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval food error");
        Customer.clickOnPlaceOrderSavalDraft();
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice1,"The item has not been selected.");

        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");

        Dashboard.switch1932Saval();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        Customer.clickOnPlaceOrderSavalDraft();
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice2,"The item has not been selected.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
