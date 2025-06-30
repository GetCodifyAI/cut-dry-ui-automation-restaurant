package com.cutanddry.qa.tests.DP_Specific_Suppliers;

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

public class VerifyTheAlternateCollapsedMenuOnDesktopForWLAppTest extends TestBase {
    static User user;
    static String OperatorName = "477538372";
    static String userName = "Jim Beacom Jr";
    static String DPName = "380 Auction380 Discount Warehouse";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1452")
    public void VerifyTheAlternateCollapsedMenuOnDesktopForWLApp() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        softAssert.assertTrue(Dashboard.isCatalogDataDisplayed(),"parent company catalog data not displayed");

        Customer.clickMenu();
        softAssert.assertTrue(Customer.isUserNameDisplay(userName),"user name display error");
        softAssert.assertTrue(Customer.isDistributorNameDisplay(DPName),"distributor name error");
        Customer.clickCloseMenu();
        softAssert.assertTrue(Dashboard.isCatalogDataDisplayed(),"parent company catalog data not displayed");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
