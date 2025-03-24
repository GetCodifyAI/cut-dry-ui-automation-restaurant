package com.cutanddry.qa.tests.CreditRequests;

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

public class VerifyEndToEndCreditRequestDeclineFlowTest extends TestBase {
    static User user;
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";
    static String CreditItemName,itemCode, itemPrice,itemQuantity,itemIssue,itemTotal,itemCredit;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-507")
    public void verifyEndToEndCreditRequestDeclineFlow() throws InterruptedException{
        String itemName;
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
        History.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
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
        CreditItemName = CreditRequests.getCreditItemName();
        itemCode = CreditRequests.getItemCode();
        itemPrice = CreditRequests.getItemPrice();
        itemQuantity = CreditRequests.getItemQuantity();
        itemIssue = CreditRequests.getItemIssue();
        itemTotal = CreditRequests.getItemTotal();
        itemCredit = CreditRequests.getItemCredit();
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
        softAssert.assertEquals(CreditRequests.getCreditItemNameDP(), CreditItemName, "Item name of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemCodeDP(), itemCode, "Item Code of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemPriceDP(), itemPrice, "Item Price of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemQuantityDP(), itemQuantity, "Item Quantity of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemIssueDP(), itemIssue, "Issue of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemTotalDP(), itemTotal, "Total of customer credit request is differance");
        softAssert.assertEquals(CreditRequests.getItemCreditDP(), itemCredit, "Credit of customer credit request is differance");
        CreditRequests.clickProcessCredit();
        softAssert.assertTrue(CreditRequests.isProcessCreditSectionDisplay(),"Process credit section not display");
        CreditRequests.clickSelectItem();
        CreditRequests.clickDeclineCredit();
        softAssert.assertTrue(CreditRequests.isDeclineCreditPopUpDisplay(),"Decline credit pop p not display");
        CreditRequests.clickSubmit();
        softAssert.assertTrue(CreditRequests.isConfirmDeclinePopUpDisplay(),"Confirm decline pop up not display");
        CreditRequests.clickConfirm();
        softAssert.assertTrue(CreditRequests.isCreditRequestDeclinedPopUpDisplay(),"Credit request declined pop up not display");
        CreditRequests.clickClose();
        softAssert.assertTrue(CreditRequests.isCreditDeclinedDisplay(),"credit declined not display");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
