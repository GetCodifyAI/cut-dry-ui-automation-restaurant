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

public class ValidateTheWLUserNavigatedToTheParentSupplierTest extends TestBase {
    static User user;
    static String EmailOrMobile = "faizul+west@cutanddry.com";
    static String Password = "12345678";
    static String chooseCatalog = "Saval Foodservice";
    static String parentDpName = "49 West Coffee House";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-116")
    public void ValidateTheWLUserNavigatedToTheParentSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Assert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error");
        Dashboard.chooseProductCatalog(chooseCatalog);
        softAssert.assertTrue(Dashboard.isUserNavigateHome(),"user navigate home saval food home error");
        softAssert.assertTrue(Dashboard.isSavalFoodServiceBannerDisplayed(),"saval food service banner not displayed");
        softAssert.assertTrue(Dashboard.isParentDpNameDisplayed(parentDpName),"parent dp name not display");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
