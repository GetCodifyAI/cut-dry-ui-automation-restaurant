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

public class VerifyEditRemovePaymentSettingsTest extends TestBase{
    static User user;
    String NickName = "TestEdit";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-600")
    public void VerifyEditRemovePaymentSettings()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Pay.navigateToPay();
        Pay.paymentSettings();
        Pay.clickOnPaymentSettingsRemoveOption();
        softAssert.assertTrue(Pay.isPaymentSettingsNicknameTextDisplayed(),"error in text display");
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
