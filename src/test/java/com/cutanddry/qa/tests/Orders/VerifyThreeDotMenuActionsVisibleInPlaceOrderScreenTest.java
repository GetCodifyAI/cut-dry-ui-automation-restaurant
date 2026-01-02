package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.functions.Suppliers;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyThreeDotMenuActionsVisibleInPlaceOrderScreenTest extends TestBase {
    static User user;
    static String SupplierName = "Independent Foods Co";
    static String chat = "Chat";
    static String editGuide = "Edit Guide";
    static String editSupplier = "Edit Supplier";
    static String viewCatalog = "View Catalog";
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3463")
    public void VerifyThreeDotMenuActionsVisibleInPlaceOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickOnThreeDot(SupplierName);
        softAssert.assertTrue(Order.isThreeDotDropDownOptionDisplayed(chat),"chat option not display");
        softAssert.assertTrue(Order.isThreeDotDropDownOptionDisplayed(editGuide),"edit guide option not display");
        softAssert.assertTrue(Order.isThreeDotDropDownOptionDisplayed(editSupplier),"edit supplier option not display");
        softAssert.assertTrue(Order.isThreeDotDropDownOptionDisplayed(viewCatalog),"view catalog option not display");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
