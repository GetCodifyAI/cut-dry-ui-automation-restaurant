package com.cutanddry.qa.tests.Credit_Requests;

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

public class VerifyTheCreditReqSearchByDistributorTest extends TestBase {
    static User user;
    static String Dp_Name = "Independent Foods Co";
    String orderId;
    String itemName;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-493")
    public void VerifyTheCreditReqSearchByDistributor() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyInClassic(1);
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
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

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToCreditRequests();
        Assert.assertTrue(CreditRequests.isCreditRequestSectionDisplay(),"Credit request section not display");
        CreditRequests.clickCreditRequest();
        softAssert.assertTrue(CreditRequests.isOrderCreditRequestSectionDisplay(),"Order Credit request section not display");
    }



    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
