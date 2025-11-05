package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyThatTheOrderGuideLocationInOrderGuideSettingsTest extends TestBase {
    static User user;
    String OperatorName = "131583036";
    static String location1 = "Test_Automation (Hayes)";
    static String location2 = "Test_Automation (Hayes, Main St)";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2566")
    public void VerifyThatTheOrderGuideLocationInOrderGuideSettings() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.loginAsManager(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Order.removeOrderGuideLocation();
        Order.clickOnSave();
        Thread.sleep(5000);

        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        softAssert.assertTrue(Customer.IsChangeLocationOrderGuideDisplay(location1),"Display edit order guide location ");

        Customer.closeEditor();
        Thread.sleep(10000);

        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Order.addOrderGuideLocation();
        Order.clickOnSave();
        Thread.sleep(5000);

        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        softAssert.assertTrue(Customer.IsChangeLocationOrderGuideDisplay(location2),"Display edit order guide location ");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
