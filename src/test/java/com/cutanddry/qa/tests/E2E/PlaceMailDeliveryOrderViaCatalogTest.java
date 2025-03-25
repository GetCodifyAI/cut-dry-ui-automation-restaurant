package com.cutanddry.qa.tests.E2E;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PlaceMailDeliveryOrderViaCatalogTest extends TestBase {
    static User user;
    String itemName,searchItemCode,orderId;
    static double itemPrice;
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";
    String customerCode = "21259";
    String checkingStatus = "Checked In";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-929")
    public void PlaceMailDeliveryOrderViaCatalog() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        // Restaurant Flows
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.goToCatalog();
        Customer.searchItemOnCatalog(searchItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName.toLowerCase()), "item not found");
        Customer.clickOnPlusIconInCatalogPDP(1, itemName);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice,"The item has not been selected.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");
        Customer.selectMailDelivery();
        softAssert.assertTrue(Customer.isMailDeliveryOptionSelected(), "The expected fulfillment type is not selected.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        // Distributor Flows
        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToCustomers();
        Assert.assertTrue(Customer.isCustomersTextDisplayed(),"customer section not display");
        Customer.searchCustomerByCode(customerCode);
        softAssert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerCode),"customer not found");
        String BusinessName = Customer.getBusinessNameFromCustomers(customerCode);
        Customer.SelectCustomer(customerCode);
        softAssert.assertTrue(Customer.isCustomerProfileDisplayed(BusinessName),"customer profile not display ");
        Customer.clickOnOrdersTab();
        Customer.clickOnSpecificRecord(orderId);
        softAssert.assertTrue(Customer.isOrderIdDisplayed(orderId), "The newly added order ID does not match the order reference number on the Order order page.");
        Order.clickOnCheckIn();

        softAssert.assertTrue(Order.isCheckInOrderIdDisplayed(orderId), "The user is unable to land on the Check In page.");
        Order.clickOnCheckInAll();
        softAssert.assertTrue(Order.isCheckInAllPopupDisplayed(), "The Check In all confirmation popup message is not displayed as expected.");
        Order.clickConfirm();

        softAssert.assertTrue(Customer.isOrderIdDisplayed(orderId), "The user is unable to navigate back to the Order Details page.");
        softAssert.assertTrue(Order.isOrderStatusDisplayed(checkingStatus), "The user is unable to navigate back to the Order Details page.");
        Login.closePreviousTab();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
