package com.cutanddry.qa.tests.Approvals;

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

public class VerifyEmployeeOrderEditRestrictionAfterApprovalTest extends TestBase {
    static User user;
    String employeeOperatorName = "274855811";
    String adminOperatorName = "Brandon IFC White";
    static String orderId;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2004")
    public void verifyEmployeeOrderEditRestrictionAfterApproval() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login error - user not navigated to dashboard");

        Login.navigateToLoginAs();
        Login.loginAsEmployee(employeeOperatorName);
        restaurantUI.switchToNewTab();

        Dashboard.navigateToOrder();
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation error - Order Guide page not displayed");

        Customer.increaseFirstRowQtyInClassic(1);
        softAssert.assertTrue(Integer.parseInt(Customer.getItemQtyFirstRowClassic()) > 0, "Product quantity not increased");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Review order page not displayed");

        Customer.submitOrder();

        if (Customer.isSentApprovalDisplayed()) {
            Customer.clickViewOrderInDraft();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "Navigation error - Drafts page not displayed");
            orderId = Drafts.getReferenceNum();
            Login.closePreviousTab();

            Login.navigateToLoginAs();
            Login.loginAsManager(adminOperatorName);
            restaurantUI.switchToNewTab();

            Dashboard.navigateToDrafts();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "Navigation error - Drafts page not displayed for Admin");
            softAssert.assertEquals(Drafts.getReferenceNum(), orderId, "Draft order reference number mismatch");

            Drafts.clickFirstDraft();
            Customer.submitOrder();
            softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "Order was not approved successfully - Thank you popup not displayed");
            Customer.clickClose();

            Dashboard.navigateToHome();
            softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(), "Recent Orders section not displayed on Home page");
            softAssert.assertTrue(Customer.isRecentSubmitOrderDisplay(orderId), "Edit Order button not displayed for Admin in Recent Orders");
            softAssert.assertTrue(Customer.isRecentAddedOrderDisplay(orderId), "Add to Order button not displayed for Admin in Recent Orders");

            Customer.clickRecentSubmitOrder(orderId);
            softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Admin unable to access Edit Order functionality");
            Customer.clickOnBackBtn();

            Dashboard.navigateToHome();
            Customer.clickAddToRecentSubmitOrder(orderId);
            softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Admin unable to access Add to Order functionality");

            Login.closePreviousTab();

            Login.navigateToLoginAs();
            Login.loginAsEmployee(employeeOperatorName);
            restaurantUI.switchToNewTab();

            Dashboard.navigateToHome();
            softAssert.assertTrue(Customer.isRecentOrderTextDisplayed(), "Recent Orders section not displayed for Employee on Home page");
            softAssert.assertFalse(Customer.isRecentSubmitOrderDisplay(orderId), "Edit Order button should be disabled for Employee after Admin approval");
            softAssert.assertFalse(Customer.isRecentAddedOrderDisplay(orderId), "Add to Order button should be disabled for Employee after Admin approval");
        } else {
            softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "Order was not completed successfully");
            Customer.clickClose();
        }

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
