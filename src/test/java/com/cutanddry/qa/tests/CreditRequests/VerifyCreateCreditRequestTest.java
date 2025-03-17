package com.cutanddry.qa.tests.CreditRequests;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyCreateCreditRequestTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-505")
    public void verifyCreateCreditRequest() throws InterruptedException{
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyInClassic(1);
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(),"Order section not display");
        History.clickCheckIn();
        softAssert.assertTrue(History.isCheckInOrderSectionDisplayed(),"Check In order section not display");
        CreditRequests.clickReportIssue();
        softAssert.assertTrue(CreditRequests.isReportIssueSectionDisplayed(),"Credit report issue section not display");
        CreditRequests.clickOneItem();
        softAssert.assertTrue(CreditRequests.isIssuePopUpDisplayed(),"Issue pop up not display");
        CreditRequests.clickIssueOption();
        CreditRequests.clickContinue();
        softAssert.assertTrue(CreditRequests.isIssuePopUpDisplayed(),"Issue pop up not display");
        CreditRequests.clickContinue();
        softAssert.assertTrue(CreditRequests.isIssuePopUpDisplayed(),"Issue pop up not display");
        CreditRequests.clickContinue();
        softAssert.assertTrue(CreditRequests.isCreditRequestedDisplayed(),"Credit requested not display");
        CreditRequests.clickSaveCheckIn();
        softAssert.assertTrue(CreditRequests.isSubmitCreditRequestPopupDisplayed(),"Submit credit request pop up not display");
        CreditRequests.clickYes();
        softAssert.assertTrue(CreditRequests.isCreditRequestSentPopupDisplayed(),"Credit request sent pop up not display");
        CreditRequests.clickClose();
        softAssert.assertTrue(CreditRequests.isCreditStatusRequestedDisplay(),"Credit status : Requested not display");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
