package com.cutanddry.qa.tests.Settings.Restaurant;

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
import java.nio.file.Paths;
import java.util.Objects;


public class VerifyRestaurantUpdateTest extends TestBase {
    static User user;
    String originalName = "Restaurant(Test)";
    String restaurantName = "Restaurant(Test)Update";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-324")
    public void VerifyRestaurantUpdate() throws InterruptedException, URISyntaxException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Settings.clickOnBusinessUnderSettings();
        Settings.editNameInRestaurant(restaurantName);
        Settings.saveRestaurantChanges();
        softAssert.assertTrue(Settings.isSuccessfulCompanyDetailsUpdateOverlayDisplayed(),"Error in Saving edited Company name");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertEquals(Settings.getUpdatedRestaurantName(),restaurantName,"Profile name not updated");

        //Verifying the logo Update
        Settings.removeLogo();
        Settings.saveRestaurantChanges();
        softAssert.assertTrue(Settings.isSuccessfulCompanyDetailsUpdateOverlayDisplayed(),"Error in Saving company logo remove");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertFalse(Settings.isRestaurantLogoRemoved(),"Error in Removing Restaurant logo");
        Settings.uploadFile(Paths.get(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("restaurantLogo/Logo.jpg")).toURI()).toString());
        Settings.saveRestaurantChanges();
        softAssert.assertTrue(Settings.isSuccessfulCompanyDetailsUpdateOverlayDisplayed(),"Error in Uploading Restaurant Logo");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertTrue(Settings.isRestaurantLogoAdded(),"Error in Adding Restaurant logo");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        //reverting back the restaurant name
        Settings.editNameInRestaurant(originalName);
        Settings.saveRestaurantChanges();
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
