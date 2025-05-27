package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheSortOptionsTest extends TestBase {
    static User user;
    static String itemName = "A";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-64")
    public void verifyTheSortOptions() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.sortByItemCategory();
        softAssert.assertTrue(Customer.isSeaFoodTextDisplayed(),"sort error for item category");
        Customer.sortByAlphabet();
        System.out.println(Customer.getItemNameFirstRow().toLowerCase());
        System.out.println(itemName.toLowerCase());
        softAssert.assertTrue(Customer.getItemNameFirstRow().toLowerCase().contains(itemName.toLowerCase()),"sort error for alphabet");
        Customer.sortByCustomOrder();
// TODO: Invalid check
//        softAssert.assertTrue(Customer.getItemNameFirstRow().toLowerCase().contains(itemName.toLowerCase()),"sort error for custom order");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
