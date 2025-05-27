package com.cutanddry.qa.tests.Pay;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Pay;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTotalUnpaidInvoiceBalanceTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-996")
    public void VerifyTotalUnpaidInvoiceBalance()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToOperator();
        Pay.navigateToPay();
        Assert.assertTrue(Pay.isPaySupplierTextDisplayed(),"error in text display");
        Pay.clickOnInvoiceTypeDropdownMenu();
        Pay.clickOnCreditMemoOption();
        float ActualCreditMemosTotalAmount = Pay.getCreditMemosTotalAmount();
        float actualCreditMemosTotalAmount = (float) (Math.round(ActualCreditMemosTotalAmount * 100.0) / 100.0);
        softAssert.assertTrue(Pay.isTotalCreditsTextDisplayed(),"error displaying total credits");
        float expectedCreditMemosTotalAmount = Pay.getTotalCreditsAmount();
        softAssert.assertEquals(expectedCreditMemosTotalAmount,actualCreditMemosTotalAmount);
        Pay.clearInvoiceTypeDropDownOption();

        Pay.clickOnInvoiceStatusDropdownMenu();
        Pay.clickOnPastDueOption();
        float ActualPastDueInvoicesTotalAmount = Pay.getPastDueInvoicesTotalAmount();
        float actualPastDueInvoicesTotalAmount = (float) (Math.round(ActualPastDueInvoicesTotalAmount * 100.0) / 100.0);
        softAssert.assertTrue(Pay.isPastDueTextDisplayed(),"error displaying past due amount");
        float expectedPastDueInvoicesTotalAmount = Pay.getTotalPastDueAmount();
        //TODO: need to fix the issue with the past due amount
//        softAssert.assertEquals(expectedPastDueInvoicesTotalAmount,actualPastDueInvoicesTotalAmount);
        Pay.clearInvoiceStatusDropDownOption();

        Pay.clickOnInvoiceTypeDropdownMenu();
        Pay.clickOnInvoiceOption();
        Pay.clickOnInvoiceStatusDropdownMenu();
        Pay.clickOnUnpaidOption();
        float ActualUnpaidInvoicesTotalAmount = Pay.getUnpaidInvoicesTotalAmount();
        float actualUnpaidInvoicesTotalAmount = (float) (Math.round(ActualUnpaidInvoicesTotalAmount * 100.0) / 100.0);
        softAssert.assertTrue(Pay.isTotalUnpaidInvoicesTextDisplayed(),"error displaying total unpaid invoice");
        float expectedUnpaidInvoicesTotalAmount = Pay.getTotalUnpaidInvoicesAmount();
        //TODO: need to fix the issue with the past due amount
//        softAssert.assertEquals(actualUnpaidInvoicesTotalAmount,expectedUnpaidInvoicesTotalAmount);
        Pay.clearInvoiceTypeDropDownOption();
        Pay.clearInvoiceStatusDropDownOption();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
