package com.cutanddry.qa.tests.OrderGuide;



import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Drafts;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifySaveDraftFunctionalityInMoreOptionsMenuTest extends TestBase {
    static User user;
    static String itemName, searchItemCode;
    static double itemPrice;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-3466")
    public void verifySaveDraftFunctionalityInMoreOptionsMenu() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        itemName = Customer.getItemNameFirstRow();

        Customer.expandMoreOptionsDropdown();
        softAssert.assertFalse(Customer.isSaveDraftOptionDisplayed(), "Save Draft option is visible in More Options dropdown when order has no items.");
        Customer.expandMoreOptionsDropdown();

        Customer.expandMoreOptionsDropdown();
        Customer.clickEditOrderGuideOption();
        Customer.expandMoreOptionsDropdown();
        softAssert.assertFalse(Customer.isSaveDraftOptionDisplayed(), "Save Draft option is visible in More Options dropdown when edit the order guide.");

        Customer.closeEditor();

        itemPrice = Customer.getActiveItemPriceFirstRow() * 8;

        Customer.increaseFirstRowQtyCustom(8);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(), itemPrice, "The item has not been selected.");
        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isSaveDraftOptionDisplayed(), "Save Draft option is not visible in More Options dropdown when order has items.");

        Customer.clickSaveDraft();

        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(), "User was not navigated to Drafts page after clicking Save Draft.");

        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(itemPrice)), "The saved draft is not displayed in the drafts list.");

        Drafts.clickDraft(String.valueOf(itemPrice));
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page after clicking on the draft.");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}