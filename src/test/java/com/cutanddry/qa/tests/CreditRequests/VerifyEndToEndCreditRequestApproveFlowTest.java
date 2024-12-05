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

public class VerifyEndToEndCreditRequestApproveFlowTest extends TestBase {
    static User user;
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-506")
    public void verifyEndToEndCreditRequestApproveFlow() throws InterruptedException{
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        History.clickClose();

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

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToCreditRequests();
        softAssert.assertTrue(CreditRequests.isCreditRequestSectionDisplay(),"Credit request section not display");
        CreditRequests.clickCreditRequest();
        softAssert.assertTrue(CreditRequests.isOrderCreditRequestSectionDisplay(),"Order Credit request section not display");
        CreditRequests.clickProcessCredit();
        softAssert.assertTrue(CreditRequests.isProcessCreditSectionDisplay(),"Process credit section not display");
        CreditRequests.clickSelectItem();
        CreditRequests.clickApproveCredit();
        softAssert.assertTrue(CreditRequests.isApproveCreditPopUpDisplay(),"Approve credit pop p not display");
        CreditRequests.clickSubmit();
        softAssert.assertTrue(CreditRequests.isConfirmApprovalPopUpDisplay(),"Confirm approval pop up not display");
        CreditRequests.clickConfirm();
        softAssert.assertTrue(CreditRequests.isCreditRequestApprovedPopUpDisplay(),"Credit request approved pop up not display");
        CreditRequests.clickClose();
        softAssert.assertTrue(CreditRequests.isCreditApprovedDisplay(),"credit approved not display");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
