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

public class VerifyAddInstructionsPerItemFunctionalityOnReviewOrderScreenTest extends TestBase {
    static User user;
    static String itemCode;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3484")
    public void verifyAddInstructionsPerItemFunctionalityOnReviewOrderScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        String testInstructions = "Please slice thin";
        String updatedInstructions = "Please slice extra thin and remove stems";

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - user not on dashboard");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide failed");

        Customer.increaseFirstRowQtyByOne();
        itemCode = Customer.getItemCodeFirstRow();

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "User is not on Review Order screen");

        softAssert.assertTrue(Customer.isAddInstructionsLinkDisplayed(),
                "Add Instructions link is not displayed for items on Review Order screen");

        Customer.clickAddInstructionsForFirstItem();
        softAssert.assertTrue(Customer.isItemInstructionModalDisplayed(),
                "Item Instruction Modal did not open after clicking Add Instructions");

        Customer.enterItemInstructions(testInstructions);
        Customer.saveItemInstructions();

        Customer.clickAddInstructionsForFirstItem();
        softAssert.assertTrue(Customer.isItemInstructionModalDisplayed(),
                "Item Instruction Modal did not open for editing existing instructions");

        String existingInstructions = Customer.getItemInstructionsText();
        softAssert.assertTrue(existingInstructions.contains(testInstructions) || testInstructions.contains(existingInstructions),
                "Existing instructions not pre-populated in modal. Expected: " + testInstructions + ", Found: " + existingInstructions);

        Customer.enterItemInstructions(updatedInstructions);
        Customer.saveItemInstructions();

        Customer.clickAddInstructionsForFirstItem();
        Customer.clearItemInstructions();
        Customer.saveItemInstructions();

        softAssert.assertTrue(Customer.isAddInstructionsLinkDisplayed(),
                "Add Instructions link not displayed after clearing instructions");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
