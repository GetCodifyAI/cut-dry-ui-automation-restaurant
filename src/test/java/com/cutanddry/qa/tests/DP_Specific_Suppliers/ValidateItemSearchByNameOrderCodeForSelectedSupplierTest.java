package com.cutanddry.qa.tests.DP_Specific_Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateItemSearchByNameOrderCodeForSelectedSupplierTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";
    static String itemName = "Spinach Baby";
    static String itemName2 = "Asparagus Large";
    static String itemCode = "22399";
    static String itemCode2 = "54826";
    

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-123")
    public void ValidateItemSearchByNameOrderCodeForSelectedSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        Dashboard.chooseProductCatalog(chooseCatalog);
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        Customer.searchItemOnHome(itemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");
        Customer.searchItemOnHome(itemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");

        Dashboard.switch1932Saval();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        Customer.searchItemOnHome(itemName2);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName2.toLowerCase()), "item not found");
        Dashboard.navigateToHome();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");
        Customer.searchItemOnHome(itemCode2);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName2.toLowerCase()), "item not found");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
