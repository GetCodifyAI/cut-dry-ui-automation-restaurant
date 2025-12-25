package com.cutanddry.qa.tests.OrderGuide;

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

public class VerifyBackButtonNavigationOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemName;
    static String searchItemCode;
    static double initialCartPrice;
    static String specialInstructionsText = "Please deliver to back door. Call upon arrival.";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3486")
    public void verifyBackButtonNavigationOnReviewOrderScreen() throws InterruptedException {
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
        Customer.typeSpecialInstructions(specialInstructionsText);
        String enteredText = Customer.getSpecialInstructionsText();
        softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match.");

        //Customer.editOrderFromReviewScreen();
        Customer.clickOnBackBtn();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Back navigation failed - user is not on Order Guide screen.");

        Customer.searchItemOnOrderGuide(searchItemCode);
        double cartPriceAfterBack = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertEquals(cartPriceAfterBack, initialCartPrice, "Cart contents were not preserved after back navigation.");

        Customer.increaseFirstRowQtyCustom(1);
        double updatedCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(updatedCartPrice > initialCartPrice, "Unable to modify quantity after back navigation.");
        double newCartPrice = Customer.getItemPriceOnCheckoutButton();
        Customer.checkoutItems();

        enteredText = Customer.getSpecialInstructionsText();
        softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match.");
        softAssert.assertEquals(updatedCartPrice, newCartPrice, "Cart contents were not preserved after back navigation.");
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after modifying quantities.");

        Customer.createOrderFromCatalog();
        Customer.clickOnBackBtn();
        enteredText = Customer.getSpecialInstructionsText();
        softAssert.assertEquals(updatedCartPrice, newCartPrice, "Cart contents were not preserved after back navigation.");
        softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match after back from catalog page.");
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after back from catalog page.");

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(), "History navigation error");
        Customer.clickBrowserNativeBackButton();
        enteredText = Customer.getSpecialInstructionsText();
        softAssert.assertEquals(updatedCartPrice, newCartPrice, "Cart contents were not preserved after back navigation.");
        softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match after back from history page.");
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after back from history page.");

        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "navigation to drafts error");
        Customer.clickBrowserNativeBackButton();
        enteredText = Customer.getSpecialInstructionsText();
        softAssert.assertEquals(updatedCartPrice, newCartPrice, "Cart contents were not preserved after back navigation.");
        softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match after back from draft page.");
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after back from draft page.");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
