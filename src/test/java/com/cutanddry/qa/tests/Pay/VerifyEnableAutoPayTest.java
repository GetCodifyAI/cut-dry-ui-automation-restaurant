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

public class VerifyEnableAutoPayTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-568")
    public void VerifyEnableAutoPay() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Pay.navigateToPay();
        softAssert.assertTrue(Pay.isPaySupplierTextDisplayed(),"error in text display");
        Pay.clickAutoPay();
        softAssert.assertTrue(Pay.isPaymentSettingsDisplayed(),"payment setting window not display");
        softAssert.assertTrue(Pay.isAutoPaySettingsHighlighted(),"Auto Pay settings not highlighted");
        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
