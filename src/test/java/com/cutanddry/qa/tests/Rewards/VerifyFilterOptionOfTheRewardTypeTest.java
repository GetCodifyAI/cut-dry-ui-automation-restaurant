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

public class VerifyFilterOptionOfTheRewardTypeTest extends TestBase {
    static User user;
    String dropDown = "Reward Type";
    String dropDownOption = "Dining Alliance Rebate";
    String result = "Dining Alliance Rebate";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-961")
    public void VerifyFilterOptionOfTheRewardType()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToRewards();
        softAssert.assertTrue(Rewards.isRewardsTextDisplayed(),"Rewards section navigation error");
        Rewards.clickOnExternalReward();
        Rewards.selectAllDateRange();
        Rewards.clickAllDateRange();
        Rewards.selectRewardsFilter(dropDown,dropDownOption);
        softAssert.assertTrue(Rewards.isResultDisplayed(result),"drop down filter error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
