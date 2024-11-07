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

public class VerifyEditLocationTest extends TestBase {
    static User user;
    String testLocation = "Test Location";
    String UpdatedLocation = "Test Location Updated";
    String updatedStreet = "Test Street Updated";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-316")
    public void VerifyEditLocation() throws InterruptedException{
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Settings.clickOnLocationsUnderSettings();
        Settings.clickOnLocationInGrid(testLocation);
        softAssert.assertTrue(Settings.isEditLocationOverlayDisplayed(),"Error in displaying edit location overlay");
        Settings.enterLocationName(UpdatedLocation);
        Settings.enterStreetAddress(updatedStreet);
        Settings.saveChanges();
        softAssert.assertTrue(Settings.isSuccessOverlayDisplayed(),"Error in displaying success overlay");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertTrue(Settings.isEditedLocationDisplayedInLocations(UpdatedLocation),"Edited Location not displayed");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
