package com.cutanddry.qa.tests.Pay;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Pay;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyPaymentSettingsAddPaymentMethodTest extends TestBase {
    static User user;
    static String accountNumber = "2222220";
    static String routeNumber = "321081669";
    static String nickName = "TestKaty01";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-569")
    public void VerifyPaymentSettingsAddPaymentMethod()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Pay.navigateToPay();
        softAssert.assertTrue(Pay.isPaySupplierTextDisplayed(),"error in text display");
        Pay.paymentSettings();
        softAssert.assertTrue(Pay.isPaymentSettingsDisplayed(),"payment setting window not display");
        Pay.addPaymentMethod();
        softAssert.assertTrue(Pay.isAddPaymentMethodTextDisplayed(),"error in payment method title");
        Pay.bankAccountOption();
        softAssert.assertTrue(Pay.isAddBankAccountTextDisplayed(),"error in add bank account title");
        Pay.addAccountNumber(accountNumber);
        Pay.addRouteNumber(routeNumber);
        Pay.selectAccountTypeOption();
        Pay.addNickname(nickName);
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
    
}
