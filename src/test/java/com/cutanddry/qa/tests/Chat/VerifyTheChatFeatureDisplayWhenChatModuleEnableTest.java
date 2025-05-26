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

public class VerifyTheChatFeatureDisplayWhenChatModuleEnableTest extends TestBase {
    static User user;
    String distributor = "Independent Foods Co";
    static String restaurantMessage = "Test Message Restaurant";



    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-975")
    public void VerifyTheChatFeatureDisplayWhenChatModuleEnable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.clickChatCheckbox(true);
        InternalTools.clickSaveChanges();

        Login.navigateToOperator();
        Dashboard.navigateToChats();
        softAssert.assertTrue(Dashboard.isUserNavigatedToChats(),"navigation to chats error");
        Chat.clickOnRestaurantChat();
        Chat.sendRestaurantMessage(restaurantMessage);
        softAssert.assertEquals(Chat.getLastMessageDisplayed(restaurantMessage), restaurantMessage,"messaging sending error");

        Order.goToOrder();
        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickChatSupplier(distributor);
        Chat.sendRestaurantMessage(restaurantMessage);
        softAssert.assertEquals(Chat.getLastMessageDisplayed(restaurantMessage), restaurantMessage,"messaging sending error");
        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
