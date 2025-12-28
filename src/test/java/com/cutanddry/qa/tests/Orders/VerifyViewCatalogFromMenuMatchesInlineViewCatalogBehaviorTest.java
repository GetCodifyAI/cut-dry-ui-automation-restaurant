package com.cutanddry.qa.tests.Orders;

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

public class VerifyViewCatalogFromMenuMatchesInlineViewCatalogBehaviorTest extends TestBase {
    static User user;
    static String SupplierName = "Independent Foods Co";
    static String location = "Hayes";
    static String itemName = "Artichoke -24CT";
    static String searchItemCode = "01700";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3465")
    public void VerifyViewCatalogFromMenuMatchesInlineViewCatalogBehavior() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickOnThreeDot(SupplierName);
        Order.clickViewCatalogOption();
        softAssert.assertTrue(Order.isSelectLocationPopUpDisplayed(),"select location pop up not display");
        Order.selectLocationSupplier(location);
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        Customer.searchItemOnCatalog(searchItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
