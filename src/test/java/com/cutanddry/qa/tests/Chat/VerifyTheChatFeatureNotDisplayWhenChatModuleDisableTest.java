package com.cutanddry.qa.tests.Chat;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheChatFeatureNotDisplayWhenChatModuleDisableTest extends TestBase {
    static User user;
    String distributor = "Independent Foods Co";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-1269")
    public void VerifyTheChatFeatureNotDisplayWhenChatModuleDisable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.clickChatCheckbox(false);
        InternalTools.clickSaveChanges();

        Login.navigateToOperator();
        softAssert.assertTrue(Dashboard.isChatSectionDisplay(),"Chat section not display");

        Order.goToOrder();
        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickOnThreeDot(distributor);
        softAssert.assertFalse(Order.isChatOptionDisplay(),"chat option not displayed");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.clickChatCheckbox(true);
        InternalTools.clickSaveChanges();
        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
