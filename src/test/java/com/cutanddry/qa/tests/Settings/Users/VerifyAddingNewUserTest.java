package com.cutanddry.qa.tests.Settings.Users;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Users;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddingNewUserTest extends TestBase {
    static User user;
    String UserName = "Test";
    String UserEmail = "Test@test.com";
    String LocationName = "Hayes";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-312")
    public void VerifyAddingNewUser() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Dashboard.navigateToUsers();
        softAssert.assertTrue(Users.isNavigatedToUserTab(),"ERROR navigating to Users Page");
        Users.clickAddUser();
        Users.typeUserName(UserName);
        Users.typeUserEmail(UserEmail);
        Users.selectLocationFromDropDown(LocationName);
        Users.AddUser();
        softAssert.assertTrue(Users.isUserCreationSuccessfulOverlayDisplayed(),"Error in user creation");
        Users.clickOnOkBtnInSuccessOverlay();
        softAssert.assertTrue(Users.isUserDisplayedInGrid(UserName),"User not Displayed in Grid");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
