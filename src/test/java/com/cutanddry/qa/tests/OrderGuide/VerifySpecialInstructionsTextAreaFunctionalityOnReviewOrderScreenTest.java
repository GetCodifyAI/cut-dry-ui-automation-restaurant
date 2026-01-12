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

public class VerifySpecialInstructionsTextAreaFunctionalityOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemName;
    static String searchItemCode;
    static String specialInstructionsText = "Please deliver to back door. Call upon arrival.";
    static String longSpecialInstructionsText = "This is a very long special instruction text that spans multiple sentences. Please ensure the delivery is made to the back entrance of the building. The delivery person should call the contact number provided before arriving. If no one is available to receive the delivery, please leave it at the designated safe spot near the loading dock. Thank you for your cooperation.";
    static String specialCharactersText = "Special chars: @#$%^&*()_+-=[]{}|;':\",./<>? Numbers: 12345";
    static String orderId;
    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3485")
    public void verifySpecialInstructionsTextAreaFunctionalityOnReviewOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        double itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyCustom(1);
        double initialCartPrice = Customer.getItemPriceOnCheckoutButton();
        softAssert.assertTrue(initialCartPrice > 0, "The item has not been selected.");

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        boolean isSpecialInstructionsSectionVisible = Customer.isSpecialInstructionsSectionDisplayed();
        if (isSpecialInstructionsSectionVisible) {
            softAssert.assertTrue(Customer.isSpecialInstructionsTextAreaDisplayed(), "Special Instructions text area is not displayed.");

            Customer.typeSpecialInstructions(specialInstructionsText);
            String enteredText = Customer.getSpecialInstructionsText();
            softAssert.assertEquals(enteredText, specialInstructionsText, "Entered special instructions text does not match.");

            Customer.clearSpecialInstructions();
            Customer.typeSpecialInstructions(longSpecialInstructionsText);
            String longText = Customer.getSpecialInstructionsText();
            softAssert.assertEquals(longText, longSpecialInstructionsText, "Long special instructions text was not preserved correctly.");

            Customer.clearSpecialInstructions();
            Customer.typeSpecialInstructions(specialCharactersText);
            String specialCharsText = Customer.getSpecialInstructionsText();
            softAssert.assertEquals(specialCharsText, specialCharactersText, "Special characters in instructions were not handled correctly.");

            Customer.clearSpecialInstructions();
            Customer.typeSpecialInstructions(specialInstructionsText);

            Dashboard.navigateToDrafts();
            Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "navigation to drafts error");
            softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(itemPrice)), "Draft order was not created.");

            Drafts.clickDraft(String.valueOf(itemPrice));
            softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after resuming draft.");

            if (isSpecialInstructionsSectionVisible) {
                String preservedText = Customer.getSpecialInstructionsText();
                softAssert.assertEquals(preservedText, specialInstructionsText, "Special instructions text was not preserved after saving and resuming draft.");
            }

            Customer.submitOrder();
            softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully after resuming draft.");

        }
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(), "History navigation error");

        History.ensureOrderDateSortedDescending();
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the history list.");

        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(), "Order details section not displayed");
        Assert.assertTrue(Customer.isSpecialInstructionDisplay(),"Instructions details section not displayed");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}