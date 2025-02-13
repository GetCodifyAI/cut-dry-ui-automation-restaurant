package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProductQtyFrmCatalogTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-58")
    public void editProductQtyFrmCatalog() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"navigation error");
        Customer.searchItemOnCatalog(itemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Customer.clickOnPlusIconInCatalogPDP(3, itemName);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceCatalogSearch()*3,"price error after increase");
        Customer.clickOnMinusIconInCatalogPDP(3, itemName);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),0.0,"price error after decrease");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
