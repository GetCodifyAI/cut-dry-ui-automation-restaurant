package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class VerifyUploadOrderGuideItemListTest extends TestBase {
    static User user;
    static String SupplierName = "TestSupplier3"+generateDynamicValue();
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-939")
    public void VerifyUploadOrderGuideItemList() throws InterruptedException, URISyntaxException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Order.goToOrder();
        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickAddNewSupplier();
        softAssert.assertTrue(Suppliers.isAddSuppliersPopUpDisplayed(),"Add supplier pop up window not displayed");
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.clickContinue();
        Suppliers.clickSave();

        Order.goToOrder();
        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertTrue(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");
        Order.clickFinishSetup(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.clickSave();
        softAssert.assertTrue(Order.isNavigateEditOrderGuide(),"edit order guide navigate error");
        Order.clickUploadFile();
        Customer.uploadFile(Paths.get(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("excelFiles/TestSupplier_Template.xlsx")).toURI()).toString());
        Order.clickNext();
        Order.clickConfirm();
        Order.clickOK();
        Order.clickOK();
        softAssert.assertTrue(Order.isNavigateEditOrderGuide(),"edit order guide navigate error");
        softAssert.assertTrue(Order.isNewlyAddedOrderGuideDisplayed()," order guide added error");

        //delete supplier
        Suppliers.goToSuppliers();
        Assert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();

        Order.goToOrder();
        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertFalse(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
