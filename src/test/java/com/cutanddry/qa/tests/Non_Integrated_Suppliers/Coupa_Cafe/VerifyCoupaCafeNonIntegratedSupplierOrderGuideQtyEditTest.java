package com.cutanddry.qa.tests.Non_Integrated_Suppliers.Coupa_Cafe;

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

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyCoupaCafeNonIntegratedSupplierOrderGuideQtyEditTest {
    static User user;
    String userName = "jcoupal@coupacafe.com";
    String supplierName = "David Rio";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-842")
    public void VerifyCoupaCafeNonIntegratedSupplierOrderGuideQtyEdit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");
        Customer.increaseFirstRowQtyInClassic(3);
        softAssert.assertEquals(Customer.getItemQtyFirstRowClassic(),"3");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*3, "price error after increase");
        Customer.decreaseFirstRowQtyInClassic(3);
        softAssert.assertEquals(Customer.getItemQtyFirstRowClassic(),"0");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*0, "price error after decrease");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}