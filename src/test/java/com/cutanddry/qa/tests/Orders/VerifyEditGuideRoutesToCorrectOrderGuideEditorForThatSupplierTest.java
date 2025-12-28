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

public class VerifyEditGuideRoutesToCorrectOrderGuideEditorForThatSupplierTest extends TestBase {
    static User user;
    static String SupplierName = "Independent Foods Co";
    static String location = "Hayes";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3464")
    public void VerifyEditGuideRoutesToCorrectOrderGuideEditorForThatSupplier() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Assert.assertTrue(Order.isPlaceOrderTextDisplayed(),"Order navigation error");
        Order.clickOnThreeDot(SupplierName);
        Order.clickEditGuideOption();
        softAssert.assertTrue(Order.isSelectLocationPopUpDisplayed(),"select location pop up not display");
        Order.selectLocationSupplier(location);
        softAssert.assertTrue(Order.isNavigateEditOrderGuide(),"edit order guide navigate error");
        softAssert.assertTrue(Customer.IsSupplierLocationOrderGuideDisplay(location),"edit order guide location navigate error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
