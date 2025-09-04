package com.cutanddry.qa.tests.OrderGuide;

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

public class ValidatePONumberLengthForOperatorTest extends TestBase {
    static User user;
    String OperatorName = "286512123";
    String itemName,searchItemCode;
    static double itemPrice;
    static String poNumber = "24444444444444444444423232232323232"+generateDynamicValue();
    static String poNumberError = "Please try another PO number, the current one exceeds the 20 character limit";
    static String poNumber2 = "24444";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1441")
    public void ValidatePONumberLengthForOperator() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        // Added Multi OUM Item OG
        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.increaseFirstRowQtySpecificCustomer(15);
        Customer.checkoutItems();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.typePONumber(poNumber);
        Thread.sleep(3000);
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isPONumberErrorDisplay(poNumberError),"PO number too long");
        Customer.clickOK();
        Customer.typePONumber(poNumber2);
        Thread.sleep(3000);
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
