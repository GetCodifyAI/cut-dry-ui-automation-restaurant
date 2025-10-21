package com.cutanddry.qa.tests.DP_Specific_Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyGenericAccountHoldMessageIsDisplayedOnOrderSubmissionTest extends TestBase {
    static User user;
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";
    static String customerId = "30275";
    static String OperatorName = "372460856";
    static String holdMessage = "Your account is on hold by your supplier. Your order could not be submitted, but has been saved as a Draft. Please contact your supplier about your account status and resubmit your order.";
    String itemName,searchItemCode;
    static String preAuthMessage = "Pre-authorization Required";
    static String accHoldMessage = "Your account is currently on hold. Order submission and processing may be impacted. Please review details.";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-533")
    public void VerifyGenericAccountHoldMessageIsDisplayedOnOrderSubmission() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        softAssert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId),"search error");
        Customer.clickOnCustomerCode(customerId);
        Customer.clickOnEditAccHolds();
        Customer.clickOnAccDropdown();
        Customer.clickOnHardHold();
        Customer.clickOnSaveDP();
        softAssert.assertTrue(Customer.isHardHoldSelected(),"acc select error");

        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isAccountHoldPopUpDisplay(),"account not hold");
        Dashboard.clickCloseHardHoldPopup();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage),"account hold banner not display og");


        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        Customer.increaseFirstRowQtySpecificCustomer(15);

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage),"account hold banner not display Catalog");
        Customer.checkoutItems();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage),"account hold banner not display review page");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isAccountHoldPopUpDisplay(),"account not hold");
        softAssert.assertTrue(Customer.isAccountHoldMessageDisplay(holdMessage),"account hold message not display");
        softAssert.assertAll();

//        softAssert.assertTrue(Customer.isPreAuthorizationTextDisplay(preAuthMessage),"pre auth pop up display error");
//        Customer.clickContinue();
//        softAssert.assertTrue(Customer.isConfirmPaymentTextDisplay(),"confirm payment text error");
//        Customer.clickConfirm();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
