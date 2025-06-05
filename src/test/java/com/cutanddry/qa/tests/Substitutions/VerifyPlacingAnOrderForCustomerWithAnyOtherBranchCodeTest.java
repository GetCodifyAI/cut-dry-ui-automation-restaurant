package com.cutanddry.qa.tests.Substitutions;

import com.cutanddry.qa.base.TestBase;
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

public class VerifyPlacingAnOrderForCustomerWithAnyOtherBranchCodeTest extends TestBase {
    static User user;
    String searchItemCode = "99005";
    static String OperatorName = "45808864";
    static double itemPrice;
    static String itemName,orderId;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1201")
    public void VerifyPlacingAnOrderForCustomerWithAnyOtherBranchCode() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.logInToOperator(OperatorName);

        Customer.clickOnPlaceOrderSW();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCode);
        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtySpecificCustomer(15);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice,"The item has not been selected.");
        Customer.checkoutItemsForSubstitute();
        softAssert.assertTrue(Customer.isSubstitutionTextDisplayed(),"Substitution set pop up error");
        Customer.clickSelectSub();
        Customer.clickSaveSelection();
        softAssert.assertFalse(Customer.isDoNotSubstituteTextDisplay(),"Do not Substitution text display");
        softAssert.assertTrue(Customer.isAddSubstitutionTextDisplayed(),"Substitution pop up error");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
