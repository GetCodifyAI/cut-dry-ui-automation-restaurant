package com.cutanddry.qa.tests.Drafts;

import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyDraftRetentionPeriodTest {
    static User user;
    static String operatorName = "373999623";
    static String draftRetentionDefaultMessage = "Drafts older than 30 days will be deleted automatically.";
    static String draftRetentionUpdatedMessage = "Drafts older than 45 days will be deleted automatically.";
    static String verifiedVendor = "120984264";
    static String draftRetentionKey = "draftAllowedRetentionDays";
    static String draftDefaultRetentionDaysValue = "30";
    static String draftRetentionDaysValue = "45";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1280")
    public void VerifySubmitDraftOrderByAddingItemsFromCatalog() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();

        Login.navigateToLoginAs();
        Login.logInToOperator(operatorName);
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"Draft navigation error");

        softAssert.assertTrue(Drafts.isDraftRetentionMessageDisplayed(draftRetentionDefaultMessage),"Draft retention message is not displayed");

        Login.openNewTabAndSwitchIt();
        Login.navigateToNode(verifiedVendor);
        Login.setValueToNode(draftRetentionKey,draftRetentionDaysValue);
        Login.closeNewTabAndSwitchBack();

        Login.refreshThePage();
        softAssert.assertTrue(Drafts.isDraftRetentionMessageDisplayed(draftRetentionUpdatedMessage),"Draft retention message is not displayed");

        Login.openNewTabAndSwitchIt();
        Login.navigateToNode(verifiedVendor);
        Login.setValueToNode(draftRetentionKey,draftDefaultRetentionDaysValue);
        Login.closeNewTabAndSwitchBack();

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
