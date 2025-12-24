package com.cutanddry.qa.tests.OrderGuide;

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

public class VerifyAddFromCatalogButtonFunctionalityOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemName;
    static String searchItemCode;
    static String catalogItemName = "Artichoke -24ct";
    static double initialCartPrice;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3483")
    public void verifyAddFromCatalogButtonFunctionalityOnReviewOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyCustom(1);
        initialCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(initialCartPrice > 0, "The item has not been selected.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");
        Customer.decreaseReviewQtyStable(searchItemCode,1);
        Customer.createOrderFromCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "The user is unable to navigate to Catalog from Review Order screen.");

        Customer.searchItemOnCatalog(catalogItemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(catalogItemName.toLowerCase()), "Catalog item not found.");

        Customer.clickOnPlusIconInCatalogPDP(2, catalogItemName);
        double updatedCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(updatedCartPrice > initialCartPrice, "The item from Catalog has not been added to the cart.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after adding item from Catalog.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}