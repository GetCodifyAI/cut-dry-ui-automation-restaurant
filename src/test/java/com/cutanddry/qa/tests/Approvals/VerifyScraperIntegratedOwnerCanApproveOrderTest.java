package com.cutanddry.qa.tests.Approvals;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyScraperIntegratedOwnerCanApproveOrderTest extends TestBase {
    static User user;
    String ownerName = "JP Coupa Cafe";
    String searchItemCode = "00166";
    static String referenceNum;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3138")
    public void verifyScraperIntegratedOwnerCanApproveOrder() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(ownerName);

        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyInClassic(1);
        Customer.checkoutItems();
        Customer.submitOrder();

        if (Customer.isSentApprovalDisplayed()) {
            Customer.clickViewOrderInDraft();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "navigation error");
            referenceNum = Drafts.getReferenceNum();
            Login.closePreviousTab();

            Login.navigateToLoginAs();
            Login.logInToOperatorAsWhiteLabel(ownerName);

            Dashboard.navigateToDrafts();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "navigation error");
            softAssert.assertEquals(Drafts.getReferenceNum(), referenceNum, "draft matching error");

            Drafts.clickFirstDraft();

            softAssert.assertTrue(Customer.isApproveButtonDisplayed(), "Approve button is not available for OP Admin");
            softAssert.assertTrue(Customer.isRejectButtonDisplayed(), "Reject button is not available for OP Admin");

            Customer.submitOrder();
            softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
            Customer.clickClose();

            Dashboard.navigateToDrafts();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "navigation error");
            softAssert.assertFalse(Drafts.isReferenceNumberDisplayed(referenceNum), "approve draft not successfully");
        } else {
            softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
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
