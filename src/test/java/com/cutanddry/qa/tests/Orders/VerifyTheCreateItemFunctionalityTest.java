package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

public class VerifyTheCreateItemFunctionalityTest extends TestBase {
    static User user;
    static String SupplierName = "TestNovaShop";
    static String addItemName = "Chicken Soup";
    static String addItemCode = "254254";
    static String addItemPrice = "$50";
    static String addItemPar = "5";
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-941")
    public void VerifyTheCreateItemFunctionality() throws InterruptedException, URISyntaxException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickAddNewSupplier();
        softAssert.assertTrue(Suppliers.isAddSuppliersPopUpDisplayed(),"Add supplier pop up window not displayed");
        Suppliers.clickContinue();
        Suppliers.enterSupplier(SupplierName);
        Suppliers.clickContinue();
        Suppliers.clickSave();
        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertTrue(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");

        Order.clickFinishSetup(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.clickSave();
        softAssert.assertTrue(Order.isNavigateEditOrderGuide(),"edit order guide navigate error");
        Order.clickCreateItems();
        softAssert.assertTrue(Order.isAddItemToOrderGuidePopUpDisplayed(),"Add item to order guide pop up not displayed");
        Order.addItemName(addItemName);
        Order.addItemCode(addItemCode);
        Order.addItemPrice(addItemPrice);
        Order.addItemPar(addItemPar);
        Order.clickAccountingCategory();
        Order.clickSaveItem();
        softAssert.assertTrue(Order.isNavigateEditOrderGuide(),"edit order guide navigate error");
        softAssert.assertTrue(Order.isNewlyAddedOrderGuideDisplayed()," order guide added error");

        //delete supplier
        Suppliers.goToSuppliers();
        softAssert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"Supplier navigation error");
        Suppliers.selectOneSupplier(SupplierName);
        softAssert.assertTrue(Suppliers.isEditSuppliersPopUpDisplayed(),"Edit supplier pop up window not displayed");
        Suppliers.deleteSupplier();

        Order.goToOrder();
        softAssert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        softAssert.assertFalse(Order.isAddedNewSupplierDisplayed(SupplierName),"error in supplier creation");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
