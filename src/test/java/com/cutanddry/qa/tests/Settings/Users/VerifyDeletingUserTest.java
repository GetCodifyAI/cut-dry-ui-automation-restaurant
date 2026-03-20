package com.cutanddry.qa.tests.Settings.Users;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Users;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyDeletingUserTest extends TestBase {
    static User user;
    String EditedUserName = "Testedit";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-314")
    public void VerifyDeletingUser() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToUsers();
        softAssert.assertTrue(Users.isNavigatedToUserTab(),"ERROR navigating to Users Page");
        Users.selectUserFromUsersGrid(EditedUserName);
        Users.removeUser();
        softAssert.assertTrue(Users.removeConfirmationOverlayDisplayed(),"Error in user remove displayed");
        Customer.selectYesOnDeleteConfirmationOverlay();
        softAssert.assertTrue(Users.isUserDeletionSuccessfulOverlayDisplayed(),"Error in user creation");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertFalse(Users.isUserDisplayedInGrid(EditedUserName),"User deletion error");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
