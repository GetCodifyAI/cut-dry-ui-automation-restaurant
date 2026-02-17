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

public class VerifyPlacingAnOrderForChainCustomersWithProprietaryItemsTest extends TestBase {
    static User user;
    String searchItemCode = "91196";
    static String OperatorName = "61233053";
    static double itemPrice;
    static String itemName,orderId;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1198")
    public void VerifyPlacingAnOrderForChainCustomersWithProprietaryItems() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.logInToOperator(OperatorName);

        Customer.clickOnPlaceOrderSW();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuideNotIncludeCatalogTag(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCode);
        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice,"The item has not been selected.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

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
