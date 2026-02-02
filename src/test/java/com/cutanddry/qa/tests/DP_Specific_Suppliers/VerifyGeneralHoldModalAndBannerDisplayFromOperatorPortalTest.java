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

public class VerifyGeneralHoldModalAndBannerDisplayFromOperatorPortalTest extends TestBase {
    static User user;
    static String Dp_Name = "Independent Foods Co";
    static String customerId = "30275";
    static String OperatorName = "372460856";
    static String generalHoldMessage = "Your order has been successfully sent to your supplier. However, it has been noted your account is on hold by your supplier. Please get in touch with your supplier to resolve it.";
    String itemName, searchItemCode;
    static String accHoldMessage = "Your account is currently on hold. Order submission and processing may be impacted. Please review details.";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2181")
    public void VerifyGeneralHoldModalAndBannerDisplayFromOperatorPortal() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(), "login error");

        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        softAssert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId), "search error");
        Customer.clickOnCustomerCode(customerId);
        Customer.clickOnEditAccHolds();
        Customer.clickOnAccDropdown();
        Customer.clickOnGeneralHold();
        Customer.clickOnSaveDP();
        softAssert.assertTrue(Customer.isGeneralHoldSelected(), "general hold select error");

        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isAccountHoldPopUpDisplay(), "account hold modal not displayed");
        softAssert.assertTrue(Customer.isContactSupplierButtonDisplayed(), "Contact Supplier button not displayed");

        Customer.ClickContactSupplier();
        softAssert.assertTrue(Customer.isChatWindowDisplay(), "Chat window is not displayed");
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage), "account hold banner not displayed on order guide");
        softAssert.assertTrue(Customer.isViewDetailsButtonDisplayed(), "View Details button not displayed on banner");

        Customer.clickViewDetailsButton();
        softAssert.assertTrue(Customer.isAccountHoldPopUpDisplay(), "modal did not reopen after clicking View Details");
        Dashboard.clickCloseHardHoldPopup();

        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        Customer.increaseFirstRowQtySpecificCustomer(15);

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage), "account hold banner not displayed on Catalog");
        Customer.checkoutItems();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertTrue(Customer.isAccountHoldBannerDisplay(accHoldMessage), "account hold banner not displayed on review page");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isAccountHoldPopUpDisplay(), "account hold modal not displayed after order submission");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}