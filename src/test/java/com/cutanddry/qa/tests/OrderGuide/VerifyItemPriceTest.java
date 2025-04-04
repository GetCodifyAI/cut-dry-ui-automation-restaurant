package com.cutanddry.qa.tests.OrderGuide;

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

public class VerifyItemPriceTest extends TestBase {
    static User user;
    String ItemName = "Artichoke -24CT";
    static String PDPViewItemPrice;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }


    @Test(groups = "DOT-TC-299")
    public void VerifyItemPrice() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        Customer.searchItemOnCatalog(ItemName);
        Customer.clickOnProduct(ItemName);
        softAssert.assertTrue(Customer.isNavigatedToPDP(ItemName),"Error In Navigating to PDP");
        PDPViewItemPrice = Customer.pdpViewItemCost(ItemName);
        Customer.clickOnBackBtnInEditOrderGuide();
        softAssert.assertEquals(Customer.catalogViewItemPrice(ItemName),PDPViewItemPrice,"Item Prices Mismatched");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
