package com.cutanddry.qa.tests.Settings.Location;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Settings;
import com.cutanddry.qa.functions.Users;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyDeleteLocationTest extends TestBase {
    static User user;
    String testLocation = "Test Location Updated";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-317")
    public void VerifyDeleteLocation() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Settings.clickOnLocationsUnderSettings();
        Settings.clickOnLocationInGrid(testLocation);
        softAssert.assertTrue(Settings.isEditLocationOverlayDisplayed(),"Error in displaying edit location overlay");
        Settings.DeleteLocation();
        softAssert.assertTrue(Settings.isDeleteLocationOverlayDisplayed(),"Error in displaying delete location overlay");
        Settings.clickYesOnDeleteLocationOverlay();
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertFalse(Settings.isEditedLocationDisplayedInLocations(testLocation),"Location not deleted");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
