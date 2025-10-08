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

import java.util.Random;

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyCoupaCafeNonIntegratedSupplierOrderSubmissionTest {
    static User user;
    String userName = "jcoupal@coupacafe.com";
    String supplierName = "David Rio";
    String itemNameNew = "Banana";
    String itemCode ;
    String UOM_Each = "Each";
    String UOM_Case = "Case";
    String Case_Price = "10.00";
    String UOM_Pound = "Pound";
    String Pound_Price = "15.00";
    String Each_Price = "12.00";
    String accountingCategoryName = "5100 - Food Cost";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-841")
    public void VerifyCoupaCafeNonIntegratedSupplierOrderSubmission() throws InterruptedException {
        String itemName;

        Random random = new Random();
        int ItemCodeInt = random.nextInt(10000);
        String itemCode = String.valueOf(ItemCodeInt);

        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName),"ERROR in Navigating to Suppliers page");

        Customer.clickAddNewItemFromOrderGuide();
        softAssert.assertTrue(Customer.isAddItemsToOrderGuideOverlayDisplayed(),"Error in displaying add items to order guide overlay");
        Customer.enterItemName(itemNameNew);
        Customer.enterItemCode(itemCode);
        Customer.selectUnit(UOM_Case);
        Customer.selectUnit(UOM_Pound);
        Customer.enterPrice(UOM_Each,Each_Price);
        Customer.enterPrice(UOM_Case,Case_Price);
        Customer.enterPrice(UOM_Pound,Pound_Price);
        Customer.selectAccountingCategory(accountingCategoryName);
        Customer.saveItem();
        Thread.sleep(4000);
        Customer.searchItemOnOrderGuide(itemCode);
        softAssert.assertTrue(Customer.isAddItemDisplayedInOrderGuide(itemCode),"Item not displayed");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyBySixClassic();
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        Customer.clickClose();

        Dashboard.selectSupplier(supplierName);
        Customer.goToEdit();
        Thread.sleep(4000);
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.clickOnItemEditBtn(itemCode);
        Customer.clickOnItemHideBtn();
        Customer.clickOnItemHideConfirmationOverlay();
        softAssert.assertFalse(Customer.isHiddenItemDisplayedOnGrid(itemCode),"ERROR in hiding the Item");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }


}
