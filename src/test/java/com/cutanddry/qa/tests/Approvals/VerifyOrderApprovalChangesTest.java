package com.cutanddry.qa.tests.Approvals;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyOrderApprovalChangesTest extends TestBase {
    static User user;
    static String OperatorName = "Jonathan Allen";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-206")
    public void verifyOrderApprovalChangesTest()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.goToOperatorJoshuaClayton(OperatorName);
        restaurantUI.switchToNewTab();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        softAssert.assertTrue(Dashboard.isApprovalsTabDisplayed(),"approvals tab error");
        Dashboard.navigateToCooksCompanyProduce();
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigation error for edit");
        Customer.expandMoreOptionsDropdown();
        Customer.orderGuideSettings();
        Customer.saveOrderApproval();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
