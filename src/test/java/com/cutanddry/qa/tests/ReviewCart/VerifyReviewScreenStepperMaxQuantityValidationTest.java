package com.cutanddry.qa.tests.ReviewCart;

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

public class VerifyReviewScreenStepperMaxQuantityValidationTest extends TestBase {
    static User user;
    static String itemCode;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyReviewScreenStepperMaxQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        itemCode = Customer.getItemCodeFirstRow();

        Customer.increaseFirstRowQtyByOne();

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Review Order screen should be displayed");

        Customer.setItemQuantityByCode(itemCode, "1998");
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1998", "Quantity should be 1998 in Review Screen");

        Customer.increaseReviewCartQtyByThree();

        softAssert.assertTrue(Customer.isMaxQuantityExceededModalDisplayed(), "Maximum Quantity Exceeded modal should be displayed in Review Screen");
        softAssert.assertTrue(Customer.isMaxQuantityExceededMessageDisplayed(), "Maximum quantity message should be displayed in Review Screen");

        Customer.clickMaxQuantityModalOk();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
