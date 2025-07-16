package com.cutanddry.qa.tests.Orders;

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

public class VerifyThatTheSendToERPButtonIsNotAvailableForScheduledJITOrdersTest extends TestBase {
    static User user;
    static String Dp_Name = "174874582 - Cut+Dry Agent - Carmela Foods Inc";
    static String customerId = "2419";
    static String OperatorName = "324221501";
    static String searchItemCode = "2930";
    static String itemName = "1/2 Ham Spiral Sliced, Dearborn";
    static String orderId;
    static String note = "Scheduled to push to the ERP";
    static String step1 = "Submitted";
    static String step3 = "Order pushed to ERP";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1486")
    public void VerifyThatTheSendToERPButtonIsNotAvailableForScheduledJITOrders() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Customer.clickOnPlusIconInCatalogStable(10, itemName);

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertFalse(Customer.isSendToERPButtonDisplayed(), "Send to ERP button not display");
        Assert.assertTrue(Customer.isNotesToCustomerDisplayed(note), "customer notes not display");

        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        Assert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId), "Unable to find the customer Id");
        Customer.SelectCustomer(customerId);
        Customer.clickOnOrdersTab();
        Customer.clickSubmittedOrder(orderId);

        Assert.assertTrue(Customer.isSendToERPButtonDisplayed(), "Send to ERP button not display");
        Assert.assertTrue(Customer.isNotesToCustomerDisplayed(note), "customer notes not display");
        Customer.clickSendToERP();
        softAssert.assertTrue(Customer.isSubmitERPPopUpDisplayed(), "submit order to ERP pop up not display");
        Customer.clickConfirm();
        softAssert.assertTrue(Customer.isOrderSentERPPopUpDisplayed(), "order sent to ERP pop up not display");
        Customer.clickOK();
        Thread.sleep(3000);
        softAssert.assertFalse(Customer.isSendToERPButtonDisplayed(), "Send to ERP button display");
        softAssert.assertFalse(Customer.isNotesToCustomerDisplayed(note), "customer notes display");

        Customer.clickOnTimeline();
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(step1), "order submission step not display");
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(note), "order submission step not display");
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(step3), "order submission step not display");

        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the table.");
        History.clickOnFirstItemOfOrderHistory();
        Assert.assertFalse(Customer.isSendToERPButtonDisplayed(), "Send to ERP button not display");
        Assert.assertFalse(Customer.isNotesToCustomerDisplayed(note), "customer notes not display");

        Customer.clickOnTimeline();
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(step1), "order submission step not display");
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(note), "order submission step not display");
        softAssert.assertTrue(Customer.isOrderSubmissionStepDisplayed(step3), "order submission step not display");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
