package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.functions.Suppliers;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddNewSupplierFlowWithMultipleSupplierTest extends TestBase {
    static User user;
    static String SupplierName = "TestSupplier1";
    static String SupplierName2 = "TestSupplier2";
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-935")
    public void VerifyAddNewSupplierFlowWithMultipleSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickAddNewSupplier();
        softAssert.assertTrue(Suppliers.isAddSuppliersPopUpDisplayed(),"Add supplier pop up window not displayed");
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.enterSupplier2(SupplierName2);
        Suppliers.clickContinue();
        Suppliers.clickOk();
        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertTrue(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");
        softAssert.assertTrue(Order.isAddedNewSupplierDisplayed(SupplierName2),"error in supplier creation");

        //delete supplier
        Suppliers.goToSuppliers();
        softAssert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();
        Suppliers.selectOneSupplier(SupplierName2);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();

        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertFalse(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");
        softAssert.assertFalse(Order.isAddedNewSupplierDisplayed(SupplierName2),"error in supplier creation");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
