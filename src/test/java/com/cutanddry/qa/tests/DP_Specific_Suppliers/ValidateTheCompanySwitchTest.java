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

public class ValidateTheCompanySwitchTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";
    static String companyName = "1932 by Saval";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-331")
    public void ValidateTheCompanySwitch() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        softAssert.assertTrue(Dashboard.isChooseCompanyDisplay(chooseCatalog),"company not display");
        softAssert.assertTrue(Dashboard.isChooseCompanyDisplay(companyName),"company not display");
        Dashboard.chooseProductCatalog(chooseCatalog);

        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home error");
        softAssert.assertTrue(Dashboard.isSwitch1932SavalDisplayed(),"switch 1932 saval not displayed");
        Dashboard.switch1932Saval();

        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval 1932 error");
        softAssert.assertTrue(Dashboard.isSwitchSavalFoodDisplayed(),"switch saval food not displayed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
