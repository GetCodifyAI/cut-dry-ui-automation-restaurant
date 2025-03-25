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

public class VerifyEditRemovePaymentSettingsTest extends TestBase{
    static User user;
    String NickName = "TestEdit";
    static String accountNumber = "2222220";
    static String routeNumber = "321081669";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-600")
    public void VerifyEditRemovePaymentSettings()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Pay.navigateToPay();

        //Adding payment method before removing
        Pay.paymentSettings();
        Pay.addPaymentMethod();
        softAssert.assertTrue(Pay.isAddPaymentMethodTextDisplayed(),"error in payment method title");
        Pay.bankAccountOption();
        softAssert.assertTrue(Pay.isAddBankAccountTextDisplayed(),"error in add bank account title");
        Pay.addAccountNumber(accountNumber);
        Pay.addRouteNumber(routeNumber);
        Pay.selectAccountTypeOption();
        Pay.addNickname(NickName);
        softAssert.assertTrue(Pay.isPaymentMethodSuccessfullyAddedTxtDisplayed(),"Payment method not successfully added");
        Pay.clickOkAndCloseAddPaymentMethodOverlay();

        //Removing the payment method
        Pay.paymentSettings();
        Pay.clickOnPaymentSettingsRemoveOption(NickName);
        softAssert.assertTrue(Pay.isPaymentSettingsNicknameTextDisplayed(NickName),"error in text display");
        Pay.clickOnRemovePaymentOption();
        softAssert.assertTrue(Pay.isRemoveConfirmationMessageDisplayed(),"error in text display");
        Pay.clickOnRemoveOption();
        softAssert.assertTrue(Pay.isRemoveSuccessMessageDisplayed(),"error in text display");
        Pay.clickOnOkOption();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }



}
