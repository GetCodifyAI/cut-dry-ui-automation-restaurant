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

public class VerifyThatTheOrderGuideNameAndDescriptionInOrderGuideSettingsTest extends TestBase {
    static User user;
    String OperatorName = "62459183";
    static String OrderGuideName = "Test_Automation";
    static String NewOrderGuideName = "Test Foods OG";
    static String OrderGuideDescription = "Test Description";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2565")
    public void VerifyThatTheOrderGuideNameAndDescriptionInOrderGuideSettings() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToLoginAs();
        Login.logInToOperator(OperatorName);
        Dashboard.navigateToOrderGuideStable();

        Customer.clickOGDropdown();
        Customer.selectOrderGuide(OrderGuideName);
        Thread.sleep(6000);
        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Order.editOrderGuideName(NewOrderGuideName);
        Order.editOrderGuideDescription(OrderGuideDescription);
        Order.clickOnSave();
        Thread.sleep(5000);

        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.clickLocationGuide();
        softAssert.assertTrue(Customer.IsLocationOrderGuideDisplay(NewOrderGuideName),"Display edit order guide ");

        Customer.closeEditor();
        Thread.sleep(10000);
        softAssert.assertTrue(Order.editedOrderGuideNameDisplay(NewOrderGuideName),"order guide name edit error");
        softAssert.assertTrue(Order.editedOrderGuideDescriptionDisplay(OrderGuideDescription),"order guide Description edit error");

        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Order.editOrderGuideName(OrderGuideName);
        Order.editOrderGuideDescription("");
        Order.clickOnSave();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
