package com.cutanddry.qa.tests.Non_Integrated_Suppliers;

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

public class VerifyNonIntegratedSupplierOrderGuideEditTest extends TestBase {
    static User user;
    String supplierName = "Maxies SL";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-277")
    public void VerifyNonIntegratedSupplierOrderGuideEdit() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.selectSupplier(supplierName);
        softAssert.assertTrue(Dashboard.isNavigatedToMaxiesSLPage(),"ERROR in Navigating to Maxies SL Page");
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.increaseFirstRowQtyByThree();
        softAssert.assertEquals(Customer.getItemQtyFirstRow(),"3");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*3, "price error after increase");
        Customer.decreaseFirstRowQtyByThree();
        softAssert.assertEquals(Customer.getItemQtyFirstRow(),"0");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*0, "price error after decrease");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}