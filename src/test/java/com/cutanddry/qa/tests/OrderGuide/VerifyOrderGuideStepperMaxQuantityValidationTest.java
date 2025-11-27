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

public class VerifyOrderGuideStepperMaxQuantityValidationTest extends TestBase {
    static User user;
    static String itemCode;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyOrderGuideStepperMaxQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        itemCode = Customer.getItemCodeFirstRow();

        Customer.setItemQuantityByCode(itemCode, "1998");
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1998", "Quantity should be 1998");

        Customer.increaseFirstRowQtyByOne();
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1999", "Quantity should be 1999 after increment");

        Customer.increaseFirstRowQtyByOne();

        softAssert.assertTrue(Customer.isMaxQuantityExceededModalDisplayed(), "Maximum Quantity Exceeded modal should be displayed");
        softAssert.assertTrue(Customer.isMaxQuantityExceededMessageDisplayed(), "Maximum quantity message should be displayed");

        Customer.clickMaxQuantityModalOk();

        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1999", "Quantity should remain 1999 after dismissing modal");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
