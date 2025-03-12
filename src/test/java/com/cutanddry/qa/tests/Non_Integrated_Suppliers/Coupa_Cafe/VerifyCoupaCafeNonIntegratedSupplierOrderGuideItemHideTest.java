package com.cutanddry.qa.tests.Non_Integrated_Suppliers.Coupa_Cafe;

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

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyCoupaCafeNonIntegratedSupplierOrderGuideItemHideTest {
    static User user;
    String userName = "jcoupal@coupacafe";
    String supplierName = "David Rio";
    String itemName,itemCode;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-846")
    public void VerifyCoupaCafeNonIntegratedSupplierOrderGuideItemHide() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        softAssert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");
        itemName = Customer.getItemNameFirstRow();
        itemCode = Customer.getItemCodeFirstRow();

        //Hiding the Item
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.clickOnItemEditBtn(itemCode);
        Customer.clickOnItemHideBtn();
        Customer.clickOnItemHideConfirmationOverlay();
        softAssert.assertFalse(Customer.isHiddenItemDisplayedOnGrid(itemCode),"ERROR in hiding the Item");

        //UnHiding the Item
        Customer.selectActiveAndHiddenItems();
        softAssert.assertTrue(Customer.isHiddenItemDisplayedOnGrid(itemCode),"ERROR in hidden Item");
        Customer.clickOnItemEditBtn(itemCode);
        Customer.clickSaveAndUnhide();
        Customer.selectOnlyActiveItems();
        Customer.clickOnBackBtnInEditOrderGuide();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");

        softAssert.assertAll();
}

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
