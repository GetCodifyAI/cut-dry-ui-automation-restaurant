package com.cutanddry.qa.tests.DP_Specific_Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateTheSupplierLogoWithSwitchFlowTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-119")
    public void ValidateTheSupplierLogoWithSwitchFlow() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        Dashboard.chooseProductCatalog(chooseCatalog);
        softAssert.assertTrue(Dashboard.isSavalFoodServiceLogoDisplayed(),"saval food service logo not displayed");

        Dashboard.switch1932Saval();
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        softAssert.assertTrue(Dashboard.isSavalFoodServiceLogoDisplayed(),"1932 by saval logo not displayed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
