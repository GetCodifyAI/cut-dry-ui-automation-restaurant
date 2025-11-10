package com.cutanddry.qa.tests.Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Suppliers;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyEditingSupplierTest extends TestBase {
    static User user;
    static String SupplierName = "TestSupplier"+generateDynamicValue();
    static String editSupplierName = "TestSupplierEdited"+generateDynamicValue();

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-260")
    public void verifyEditingSupplierTest () throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Suppliers.goToSuppliers();
        Assert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");

        // Pre-Request
        Suppliers.clickAddSupplier();
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.clickContinue();
        Suppliers.clickSave();
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier creation");

        // Test
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.editSupplierName(editSupplierName);
        Suppliers.clickSave();
        Login.refreshThePage();
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(editSupplierName),"error in supplier edit");

        // Post request
        Suppliers.selectOneSupplier(editSupplierName);
        Suppliers.deleteSupplier();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
