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

public class VerifyAddInstructionsPerItemFunctionalityOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemCode;
    static double itemPrice;
    static String orderId;

    String testInstructions = "Please slice thin";
    String updatedInstructions = "Check max character count with typing le";
    String maxCharacterLengthInstructions  = "Check max character count with typing letters";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3484")
    public void verifyAddInstructionsPerItemFunctionalityOnReviewOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();


        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - user not on dashboard");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();


        Customer.increaseFirstRowQtyByOne();
        itemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "User is not on Review Order screen");

        softAssert.assertTrue(Customer.isAddInstructionsLinkDisplayed(),
                "Add Instructions link is not displayed for items on Review Order screen");

        Customer.clickAddInstructionsForFirstItem();
        softAssert.assertTrue(Customer.isItemInstructionModalDisplayed(),
                "Item Instruction Modal did not open after clicking Add Instructions");

        Customer.enterItemInstructions(testInstructions);
        Customer.saveItemInstructions();
        Customer.clickEditInstructionsForFirstItem();
        String existingInstructions = Customer.getItemInstructionsText();
        softAssert.assertTrue(existingInstructions.contains(testInstructions) || testInstructions.contains(existingInstructions),
                "Existing instructions not pre-populated in modal. Expected: " + testInstructions + ", Found: " + existingInstructions);

        Customer.saveItemInstructions();
        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(itemPrice)),"draft creating error");
        Drafts.clickDraft(String.valueOf(itemPrice));
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.clickEditInstructionsForFirstItem();
        softAssert.assertTrue(existingInstructions.contains(testInstructions) || testInstructions.contains(existingInstructions),
                "Existing instructions not pre-populated in modal. Expected: " + testInstructions + ", Found: " + existingInstructions);

        Customer.enterItemInstructions(maxCharacterLengthInstructions);
        Customer.saveItemInstructions();
        Customer.clickEditInstructionsForFirstItem();
        existingInstructions = Customer.getItemInstructionsText();
        softAssert.assertTrue(existingInstructions.contains(updatedInstructions) || testInstructions.contains(existingInstructions),
                "Existing instructions not Exceed the max character length. Expected: " + updatedInstructions + ", Found: " + maxCharacterLengthInstructions);
        Customer.saveItemInstructions();

        Customer.clickEditInstructionsForFirstItem();
        Customer.clearItemInstructions();
        Customer.saveItemInstructions();

        softAssert.assertTrue(Customer.isAddInstructionsLinkDisplayed(),
                "Add Instructions link not displayed after clearing instructions");

        Customer.clickEditInstructionsForFirstItem();
        Customer.enterItemInstructions(testInstructions);
        Customer.saveItemInstructions();

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(), "History navigation error");

        History.ensureOrderDateSortedDescending();
        History.searchOrderID(orderId);
        softAssert.assertTrue(History.checkIfSearchedElementVisible(orderId), "Order ID not found in the history list.");

        History.clickOnFirstItemOfOrderHistory();
        softAssert.assertTrue(History.isOrderSectionDisplayed(), "Order details section not displayed");
        Assert.assertTrue(Customer.isHistoryInstructionDisplayed(),"Instructions details section not displayed");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}