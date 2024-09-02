package com.cutanddry.qa.tests.SignIn;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.ForgotPasswordUser;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyForgotPasswordUnauthorizedTest extends TestBase {
    static ForgotPasswordUser user;
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readForgotPasswordUserLogin();
    }

    @Test(groups = "DOT-TC-105")
    public void verifyForgotPasswordUnauthorizedEmail() {
        SoftAssert softAssert = new SoftAssert();
        Login.forgotPassword();
        softAssert.assertTrue(Login.forgotPassword(),"forgot password navigation error");
        Login.passwordResetRequest(user.getEmail_unauthorized());
        softAssert.assertTrue(Login.invalidEmailOrMobileForgotPassword(),"unauthorized email pop up error");
        Login.clickTryAgain();
        Login.forgotPassword();
        softAssert.assertTrue(Login.forgotPassword(),"forgot password navigation error");
        Login.passwordResetRequest(user.getMobile_unauthorized());
        softAssert.assertTrue(Login.invalidEmailOrMobileForgotPassword(),"unauthorized email pop up error");
        Login.clickTryAgain();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
