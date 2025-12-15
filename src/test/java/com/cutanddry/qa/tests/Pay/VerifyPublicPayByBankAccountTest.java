package com.cutanddry.qa.tests.Pay;

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

public class VerifyPublicPayByBankAccountTest extends TestBase {
    static User user;
    static String Distributor = "Independent Foods Co";
    static SoftAssert softAssert = new SoftAssert();
    static String CompanyName = "Cut + Dry Testing";
    static String ToggleName = "Guest Pay (Public Pay) enabled:";
    static String accountNumber = "2222220";
    static String routingNumber = "321081669";
    static String operatorUser = "65436339";
    static String vendorID = "63168995";
    static String Dp_Name = "46505655 - Kevin - Independent Foods Co";
    static String customerId = "44939";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-556")
    public static void VerifyPublicPayByBankAccount() throws InterruptedException {
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(Distributor);
        InternalTools.navigateToPayDetails();
        InternalTools.enableDisableToggle(ToggleName,true);
        InternalTools.clickSave();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        softAssert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId), "Unable to find the customer Id");
        Customer.SelectCustomer(customerId);
        Customer.clickOnInvoice();
        Pay.clickCutAndDryPayToggle(true);
        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperator(operatorUser);
        Pay.navigateToPublicPayView(vendorID);
        softAssert.assertTrue(Pay.isNavigatedToPublicPayView(),"navigation error");
        Pay.openUnpaidInvoice();
        softAssert.assertTrue(Pay.isNavigatedToInvoiceView(),"Navigated to Invoice View");
        Pay.addAccountNumber(accountNumber);
        Pay.addRouteNumber(routingNumber);
        Pay.selectAccountTypeOption();
        Pay.clickOnPublicPay();
        softAssert.assertTrue(Pay.isTransactionSuccessOverlayDisplayed(),"Transaction success message displayed");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
