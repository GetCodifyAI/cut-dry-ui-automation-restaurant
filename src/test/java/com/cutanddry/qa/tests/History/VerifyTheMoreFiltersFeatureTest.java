package com.cutanddry.qa.tests.History;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheMoreFiltersFeatureTest extends TestBase {
    static User user;
    static String location = "Hayes";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-552")
    public void verifyTheMoreFiltersFeature() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickOnMoreFilters();
        softAssert.assertTrue(History.isFilterOrdersPopupDisplayed(),"Filter Orders pop up error");
        History.clickLocation();
        History.clickOption();
        History.clickSave();
        softAssert.assertTrue(History.checkIfFilteredElementVisible(location), "location not found in the table.");
        History.checkIfFilteredElementVisible(location);
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
