package com.cutanddry.qa.tests.Roles;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyWLAppEmployeeRolesTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";
    static String OperatorName = "Hadley Ifc Employee";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-645")
    public void VerifyUniversalAppAdminRoles() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.loginAsEmployeeWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.increaseSecondRowQtyByOne();
        Customer.checkoutItems();
        Customer.submitOrder();
        Customer.clickClose();
        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"navigation to history error");
        Dashboard.navigateToDrafts();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDrafts(),"navigation to drafts error");
        Dashboard.navigateToChats();
        softAssert.assertTrue(Dashboard.isUserNavigatedToChats(),"navigation to chats error");
        Settings.clickOnSettingsBtn();
        softAssert.assertTrue(Settings.isNavigatedToProfileSetting(),"navigation to profile settings error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
