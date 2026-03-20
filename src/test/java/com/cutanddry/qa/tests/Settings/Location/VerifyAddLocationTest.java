package com.cutanddry.qa.tests.Settings.Location;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Settings;
import com.cutanddry.qa.functions.Users;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.URISyntaxException;

public class VerifyAddLocationTest extends TestBase {
    static User user;
    String testLocation = "Test Location";
    String streetAddress = "Test Address";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-315")
    public void VerifyAddLocation() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Settings.clickOnLocationsUnderSettings();
        Settings.AddLocation();
        softAssert.assertTrue(Settings.isAddLocationOverlayDisplayed(),"Error in displaying add location overlay");
        Settings.enterLocationName(testLocation);
        Settings.enterStreetAddress(streetAddress);
        Settings.clickAddLocationBtnInOverlay();
        softAssert.assertTrue(Settings.isSuccessOverlayDisplayed(),"Error in displaying success overlay");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertTrue(Settings.isAddedLocationDisplayedInLocations(testLocation),"Added Location not displayed");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
