package com.cutanddry.qa.tests;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class DistributorLoginTest extends TestBase {
    static User user;
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public static void loginAsDistributor() {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsDistributor(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        closeAllBrowsers();
    }
}
