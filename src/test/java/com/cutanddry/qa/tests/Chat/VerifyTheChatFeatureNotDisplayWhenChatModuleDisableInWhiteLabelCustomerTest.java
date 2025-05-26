package com.cutanddry.qa.tests.Chat;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.InternalTools;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheChatFeatureNotDisplayWhenChatModuleDisableInWhiteLabelCustomerTest extends TestBase {
    static User user;
    String distributor = "Independent Foods Co";
    String OperatorName = "Amir IFC WL";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-975")
    public void VerifyTheChatFeatureNotDisplayWhenChatModuleDisableInWhiteLabelCustomer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.clickChatCheckbox(false);
        InternalTools.clickSaveChanges();

        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();

        softAssert.assertFalse(Dashboard.isChatSectionDisplay(),"Chat section not display");
        softAssert.assertFalse(Dashboard.isChatWithUsDisplay(),"chat with us button display error");
        Login.closePreviousTab();

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.clickChatCheckbox(true);
        InternalTools.clickSaveChanges();

        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();

        softAssert.assertTrue(Dashboard.isChatSectionDisplay(),"Chat section not display");
        softAssert.assertTrue(Dashboard.isChatWithUsDisplay(),"chat with us button display error");
        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
