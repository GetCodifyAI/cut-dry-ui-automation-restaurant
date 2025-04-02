package com.cutanddry.qa.tests.Pay;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
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

public class VerifyTheDigitalInvoicePDFsAreVisibleTest extends TestBase {
    static User user;
    static String Dp_Name = "96939129 - Cut+Dry Agent - Hillcrest Foodservice";
    static String customerId = "21172";
    String operator = "Marc Glassman ";
    static String digitalInvoiceId = "2814201";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-183")
    public void VerifyTheDigitalInvoicePDFsAreVisible() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
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
        Login.loginAsAdminWL(operator);
        Login.switchIntoNewTab();
        Pay.navigateToPay();
        Assert.assertTrue(Pay.isPaySupplierTextDisplayed(),"error in text display");
        Pay.clickSelectInvoice(digitalInvoiceId);
        softAssert.assertTrue(Pay.isInvoiceIdTextDisplayed(),"error in text display");
        Pay.clickDownloadInvoice();
        Pay.clickPrintInvoice();
        softAssert.assertAll();
    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
