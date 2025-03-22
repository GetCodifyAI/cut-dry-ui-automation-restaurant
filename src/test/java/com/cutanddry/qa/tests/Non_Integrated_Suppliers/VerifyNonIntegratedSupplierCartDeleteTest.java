package com.cutanddry.qa.tests.Non_Integrated_Suppliers;

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

public class VerifyNonIntegratedSupplierCartDeleteTest extends TestBase {
    static User user;
    String supplierName = "Maxies SL";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-279")
    public void VerifyNonIntegratedSupplierCartDelete() throws InterruptedException {
        String itemName;

        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.selectSupplier(supplierName);
        softAssert.assertTrue(Dashboard.isNavigatedToMaxiesSLPage(),"ERROR in Navigating to Maxies SL Page");
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.clickDeleteItemOnCart();
        softAssert.assertEquals(Customer.isCartTotalZero(),0.0,"ERROR in Deleting Item From Cart");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
