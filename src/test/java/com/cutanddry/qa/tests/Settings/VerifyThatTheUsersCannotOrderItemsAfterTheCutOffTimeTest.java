package com.cutanddry.qa.tests.Settings;
import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.common.Constants;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Settings;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class VerifyThatTheUsersCannotOrderItemsAfterTheCutOffTimeTest extends TestBase {
    static User user;
    static String expectedDate;
    static String todayDate;


    @BeforeMethod
    public void setUp(){
        secInitialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-73")
    public void verifyThatTheUsersCannotOrderItemsAfterTheCutOffTime()throws InterruptedException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDisDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDisDashboard(),"login error");
        Settings.goToOrderSettings();
        Settings.setAfterCutOffTime();
        Settings.saveChanges();
        closeAllBrowsers();
        initialization();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        expectedDate = generateUTCTomorrowDateFormatted();
        todayDate = generateUTCTodayDateFormatted();

        Customer.selectDeliveryDateLine(todayDate);
        Customer.submitOrderAfterDeliveryTime();
        softAssert.assertTrue(Customer.isInvalidDeliveryTextDisplayed(),"Delivery time error");
        Customer.closeDeliveryPopup();
        Customer.selectDeliveryDateLine(expectedDate);
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
