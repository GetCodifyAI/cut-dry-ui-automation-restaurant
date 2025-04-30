package com.cutanddry.qa.tests.Rewards;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Rewards;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyFilterOptionOfTheRewardStatusTest extends TestBase {
    static User user;
    String dropDown = "Reward Status";
    String dropDownOption = "Reward Granted";
    String status = "Reward Granted";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-962")
    public void VerifyFilterOptionOfTheRewardStatus()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToRewards();
        softAssert.assertTrue(Rewards.isRewardsTextDisplayed(),"Rewards section navigation error");
        Rewards.selectAllDateRange();
        Rewards.clickAllDateRange();
        Rewards.selectRewardsFilter(dropDown,dropDownOption);
        softAssert.assertTrue(Rewards.isRewardsStatusDisplayed(status),"drop down filter error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
