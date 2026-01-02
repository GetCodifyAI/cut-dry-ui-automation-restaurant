package com.cutanddry.qa.tests.OrderGuide;


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

public class VerifyDeleteOrderGuideFunctionalityInMoreOptionsMenuTest extends TestBase {
    static User user;
    static String orderGuideName = "Test_Delete_OG";
    static String itemName = "Artichoke -24CT";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3468")
    public void VerifyDeleteOrderGuideFunctionalityInMoreOptionsMenu() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide error");

        Customer.goToCreatePopup();
        Customer.createOrderGuide(orderGuideName);
        Customer.createOrderFromCatalog();
        Customer.searchItemOnCatalog(itemName);
        Customer.addItemFromCatalog();
        Customer.closeEditor();

        Customer.clickOGDropdown();
        Customer.selectOrderGuide(orderGuideName);

        Customer.clickOnMoreOptionOG();
        softAssert.assertTrue(Customer.isDeleteOrderGuideOptionDisplayed(), "Delete Order Guide option is not visible in More Options menu");

        Customer.clickOnDeleteOrderGuide();
        softAssert.assertTrue(Order.isAreYouSurePopUpDisplayed(), "Confirmation dialog 'Are you sure?' is not displayed");

        Order.clickYes();

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide error");
        Customer.clickOGDropdown();
        softAssert.assertFalse(Customer.isOrderGuidePresentInDropdown(orderGuideName), "The order guide was not deleted successfully and is still present in the dropdown");

        Dashboard.navigateToOrder();
        Dashboard.clickOnPlaceOrder_Cashback_Foods();
        Customer.clickOnMoreOptionOG();
        softAssert.assertFalse(Customer.isDeleteOrderGuideOptionDisplayed(), "Delete Order Guide option is visible in More Options menu when no order guide is selected");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}