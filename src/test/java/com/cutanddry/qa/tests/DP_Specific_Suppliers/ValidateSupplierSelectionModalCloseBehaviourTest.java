package com.cutanddry.qa.tests.DP_Specific_Suppliers;

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

public class ValidateSupplierSelectionModalCloseBehaviourTest extends TestBase {
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

    @Test(groups = "DOT-TC-391")
    public void ValidateSupplierSelectionModalCloseBehaviour() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Login.loginAsSavalFoodRestaurant(EmailOrMobile,Password);
        Dashboard.clickOutsideModal();

        softAssert.assertFalse(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error1");
        Login.refreshThePage();

        softAssert.assertTrue(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error2");
        softAssert.assertTrue(Dashboard.isChooseCompanyDisplay(chooseCatalog),"company not display");
        softAssert.assertTrue(Dashboard.isChooseCompanyDisplay(companyName),"company not display");
        Customer.clickClosePopUp();

        softAssert.assertFalse(Dashboard.isChooseProductCatalogDisplayed(),"navigate to choose product catalog error3");
        softAssert.assertTrue(Dashboard.isSwitch1932SavalDisplayed(),"switch 1932 saval not displayed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
