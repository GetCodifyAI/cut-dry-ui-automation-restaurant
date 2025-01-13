package com.cutanddry.qa.tests.Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Suppliers;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddingMultipleSupplierTest extends TestBase {
    static User user;
    static String SupplierName2 = "TestSupplier2";
    static String SupplierName = "TestSupplier1";
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-955")
    public void VerifyAddingMultipleSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Suppliers.goToSuppliers();
        softAssert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");
        Suppliers.clickAddSupplier();
        softAssert.assertTrue(Suppliers.isAddSuppliersPopUpDisplayed(),"Add supplier pop up window not displayed");
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.enterSupplier2(SupplierName2);
        Suppliers.clickContinue();
        Suppliers.clickOk();
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier creation");
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(SupplierName2),"error in supplier creation");
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();
        softAssert.assertFalse(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier delete");
        Suppliers.selectOneSupplier(SupplierName2);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();
        softAssert.assertFalse(Suppliers.isSupplierDisplayed(SupplierName2),"error in supplier delete");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
