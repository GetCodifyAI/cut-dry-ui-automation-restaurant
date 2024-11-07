package com.cutanddry.qa.tests.Settings.Profile;

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

public class VerifyProfileUpdateTest extends TestBase {
    static User user;
    String OriginalProfileName = "Mashan";
    String editedProfileName = "MashanTest";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-323")
    public void VerifyProfileUpdate() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Settings.clickOnProfileUnderSettings();
        Settings.editNameInProfile(editedProfileName);
        Settings.saveProfileChanges();
        softAssert.assertTrue(Settings.isSuccessfulUserProfileUpdateOverlayDisplayed(),"Error in updating the name in user Profile");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertEquals(Settings.getUpdatedProfileName(), editedProfileName,"Profile name not updated");

        //Changing the name Back
        Settings.editNameInProfile(OriginalProfileName);
        Settings.saveProfileChanges();
        softAssert.assertTrue(Settings.isSuccessfulUserProfileUpdateOverlayDisplayed(),"Error in updating the name in user Profile");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertEquals(Settings.getUpdatedProfileName(), OriginalProfileName,"Profile name not updated");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
