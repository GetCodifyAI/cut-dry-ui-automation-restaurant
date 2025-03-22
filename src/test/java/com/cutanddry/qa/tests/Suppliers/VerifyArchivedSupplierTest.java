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

public class VerifyArchivedSupplierTest extends TestBase {
    static User user;
    static String SupplierName = "TestSupplier07";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-958")
    public void VerifyArchivedSupplier () throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Suppliers.goToSuppliers();
        Assert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");
        //add supplier
        Suppliers.clickAddSupplier();
        softAssert.assertTrue(Suppliers.isAddSuppliersPopUpDisplayed(),"Add supplier pop up window not displayed");
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.clickContinue();
        Suppliers.clickSave();
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier creation");

        //Archived supplier
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.clickOnArchived();
        Suppliers.clickViewArchived();
        softAssert.assertTrue(Suppliers.isArchivedSupplierPopUpDisplayed(),"Archived supplier pop up window not displayed");
        softAssert.assertTrue(Suppliers.isArchivedSupplierDisplayed(SupplierName),"Archived supplier not displayed");
        Suppliers.clickCloseArchived();
        softAssert.assertFalse(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier");

        //Delete supplier
        Suppliers.clickViewArchived();
        softAssert.assertTrue(Suppliers.isArchivedSupplierPopUpDisplayed(),"Archived supplier pop up window not displayed");
        Suppliers.clickUnarchived(SupplierName);
        Suppliers.clickCloseArchived();
        softAssert.assertTrue(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier unarchived");

        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();
        softAssert.assertFalse(Suppliers.isSupplierDisplayed(SupplierName),"error in supplier delete");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
