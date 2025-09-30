package com.cutanddry.qa.tests.Drafts;

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

public class VerifyPendingApprovalsAreClickableTest extends TestBase {
    static User user;
    String OperatorName = "429739320";
    String AdminName = "Brandon IFC White";
    static String referenceNum;
    String searchItemCode = "01700";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-995")
    public void VerifyPendingApprovalsAreClickable() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.settingsWLGateKeeper();
        Login.navigateToLoginAs();
        Login.loginAsAdminWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.searchItemOnOrderGuide(searchItemCode);

        Customer.increaseFirstRowQtyInClassic(3);
        Customer.checkoutItems();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isSentApprovalDisplayed(),"sent approval pop up not display");
        Customer.clickViewOrderInDraft();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        referenceNum = Drafts.getReferenceNum();
        Login.closePreviousTab();

        //Login as Admin
        Login.navigateToLoginAs();
        Login.loginAsAdminWL(AdminName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertEquals(Drafts.getReferenceNum(),referenceNum,"draft matching error");
        Drafts.clickFirstDraft();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        Customer.clickClose();

        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertFalse(Drafts.isReferenceNumberDisplayed(referenceNum),"approve draft not successfully ");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
