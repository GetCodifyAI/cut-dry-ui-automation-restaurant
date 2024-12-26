package com.cutanddry.qa.tests.Non_Integrated_Suppliers.Coupa_Cafe;

import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyCoupaCafeNonIntegratedSupplierOrderSubmissionFromDraftTest {
    static User user;
    String userName = "jcoupal@coupacafe";
    String supplierName = "Fanale Drinks";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-845")
    public void VerifyCoupaCafeNonIntegratedSupplierOrderSubmissionFromDraft() throws InterruptedException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        softAssert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyInClassic(1);
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Dashboard.navigateToDrafts();
        Drafts.selectFirstDraftOrder(supplierName);
        Customer.editOrderFromReviewScreen();
        Customer.increaseFirstRowQtyInClassic(3);
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.increaseFirstRowQtyInClassic(2);
        softAssert.assertEquals(Customer.getItemPriceReviewCart(),Customer.getItemPriceReviewCartFirstRow()*6,"price error after increase");
        Customer.decreaseFirstRowQtyInClassic(2);
        softAssert.assertEquals(Customer.getItemPriceReviewCart(),Customer.getItemPriceReviewCartFirstRow()*4,"price error after decrease");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
