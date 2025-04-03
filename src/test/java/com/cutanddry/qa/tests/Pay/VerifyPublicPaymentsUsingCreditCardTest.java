package com.cutanddry.qa.tests.Pay;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Pay;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyPublicPaymentsUsingCreditCardTest extends TestBase {
    static User user;
    static String cardNumber = "4111111111111111";
    static String cvv = "999";
    static String expDate = "10/25";
    static String zipCode = "11500";
    String distributor = "Independent Foods Co";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-457")
    public void VerifyPublicPaymentsUsingCreditCard() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Pay.navigateToPublicPayView();
        Assert.assertTrue(Pay.isNavigatedToPublicPayView(),"navigation error");
        Pay.openUnpaidInvoice();
        Pay.clickOnCardOption();
        Pay.enterCardNumber(cardNumber);
        Pay.enterExpirationDate(expDate);
        Pay.enterCVV(cvv);
        Pay.enterZipCode(zipCode);
        Pay.clickOnPublicPay();
        softAssert.assertTrue(Pay.isTransactionRejectedPopUpDisplayed(),"Transaction error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
