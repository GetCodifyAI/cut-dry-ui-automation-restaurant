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

public class VerifyItemDescriptionTest extends TestBase {
    static User user;
    String ItemName = "Artichoke -24CT";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-298")
    public void VerifyItemDescription() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
//        Dashboard.isUserNavigatedToDashboard();
        Assert.assertFalse(true);
        /*Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        Customer.searchItemOnCatalog(ItemName);
        Customer.clickOnProduct(ItemName);
        softAssert.assertTrue(Customer.isNavigatedToPDP(ItemName),"Error In Navigating to PDP");
        String PDPviewItemName = Customer.pdpViewItemName(ItemName);
        Customer.clickOnBackBtnInEditOrderGuide();
        softAssert.assertEquals(Customer.catalogViewItemName(ItemName),PDPviewItemName,"Item Name Mismatched");*/

        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
