package com.cutanddry.qa.tests.OrderGuide;

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

public class VerifyOrderGuideStepperMaximumQuantityValidationTest extends TestBase {
    static User user;
    static String initialQuantity = "1990";
    static String maxQuantity = "1999";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2248")
    public void VerifyOrderGuideStepperMaximumQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.setItemQuantityFirstRow(initialQuantity);
        String qtyAfterType = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfterType, initialQuantity, "Quantity should display as 1990 after typing");

        for (int i = 0; i < 8; i++) {
            Customer.increaseFirstRowQtyByOne();
        }
        String qtyAfter8Clicks = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfter8Clicks, "1998", "Quantity should be 1998 after 8 increments");

        Customer.increaseFirstRowQtyByOne();
        String qtyAt1999 = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAt1999, maxQuantity, "Quantity should update to 1999");

        softAssert.assertTrue(Customer.isPlusButtonDisabledFirstRow(), "Plus button should be disabled at max quantity 1999");

        Customer.increaseFirstRowQtyByOne();
        softAssert.assertTrue(Customer.isMaxQuantityExceededModalDisplayed(), "Maximum Quantity Exceeded modal should be displayed");

        Customer.clickMaxQuantityModalOk();
        String qtyAfterDismiss = Customer.getItemQtyFirstRow();
        softAssert.assertEquals(qtyAfterDismiss, maxQuantity, "Quantity should remain 1999 after dismissing modal");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
