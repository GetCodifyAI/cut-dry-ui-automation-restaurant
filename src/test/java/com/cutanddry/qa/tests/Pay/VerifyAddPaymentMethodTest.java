package com.cutanddry.qa.tests.Pay;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.InternalTools;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Pay;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddPaymentMethodTest extends TestBase {
    static User user;
    static String accountNumber = "2222220";
    static String routeNumber = "321081669";
    static String nickName = "TestKaty";
    String distributor = "What Chefs Want - Rockies";
    String payConfigs = "Enable FTNI Payment Gateway";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-561")
    public void VerifyAddPaymentMethod()throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToPayDetails();
        InternalTools.uncheckFromInternalTools(payConfigs);
        InternalTools.saveConfig();
        softAssert.assertTrue(InternalTools.isSuccessfulOverlayDisplayed(),"ERROR in saving the configs");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToOperator();
        Pay.navigateToPay();
        softAssert.assertTrue(Pay.isPaySupplierTextDisplayed(),"error in text display");
        Pay.payOption();
        softAssert.assertTrue(Pay.isInvoiceIDNoDisplayed(),"error in invoice ID number");
        Pay.addPaymentMethod();
        softAssert.assertTrue(Pay.isAddPaymentMethodTextDisplayed(),"error in payment method title");
        Pay.bankAccountOption();
        softAssert.assertTrue(Pay.isAddBankAccountTextDisplayed(),"error in add bank account title");
        Pay.addAccountNumber(accountNumber);
        Pay.addRouteNumber(routeNumber);
        Pay.selectAccountTypeOption();
        Pay.addNickname(nickName);
        softAssert.assertTrue(Pay.isPaymentMethodSuccessfullyAddedTxtDisplayed(),"Payment method not successfully added");
        Pay.clickOkAndCloseAddPaymentMethodOverlay();
        Pay.paymentSettings();
        Pay.removePaymentSettings();
        softAssert.assertTrue(Pay.isNicknameTextDisplayed(),"error in text display");
        Pay.clickOnRemovePaymentOption();
        softAssert.assertTrue(Pay.isRemoveConfirmationMessageDisplayed(),"error in text display");
        Pay.clickOnRemoveOption();
        softAssert.assertTrue(Pay.isRemoveSuccessMessageDisplayed(),"error in text display");
        Pay.clickOnOkOption();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
    
}
