package com.cutanddry.qa.tests.Purchase_History;

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

public class VerifyPurchaseHistoryInOrderGuideTest extends TestBase {
    static User user;
    String searchItemCode = "01409";
    static String multiUOMType1 = "1 CS";
    static String multiUOMType2 = "1 EA";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1033")
    public void VerifyPurchaseHistoryInOrderGuide() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.clickLastOrderOG(searchItemCode);
        softAssert.assertTrue(Customer.isPurchaseHistoryDisplay(),"Purchase history window display error");
        softAssert.assertTrue(Customer.isLastOrderDisplay(multiUOMType1),"last order multi uom quantity error");
        softAssert.assertTrue(Customer.isLastOrderDisplay(multiUOMType2),"last order multi uom quantity error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
