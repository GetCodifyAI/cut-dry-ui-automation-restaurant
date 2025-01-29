package com.cutanddry.qa.tests.Drafts;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyPendingApprovalsAreClickableTest extends TestBase {
    static User user;
    String OperatorName = "ali+33@cutanddry.com";
    String itemName = "J. Hungerford Smith Chocolate";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-995")
    public void VerifyPendingApprovalsAreClickable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(itemName);
        Customer.increaseFirstRowQtyInClassic(5);
        Customer.checkoutItems();



        softAssert.assertAll();
    }

//    @AfterMethod
//    public void tearDown(ITestResult result) {
//        takeScreenshotOnFailure(result);
//        closeAllBrowsers();
//    }

}
