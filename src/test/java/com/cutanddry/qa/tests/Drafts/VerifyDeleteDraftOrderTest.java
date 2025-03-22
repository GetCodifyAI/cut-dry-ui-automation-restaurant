package com.cutanddry.qa.tests.Drafts;

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

public class VerifyDeleteDraftOrderTest extends TestBase {
    static User user;
    static String itemName, searchItemCode,referenceNum;
    static double itemPrice;
    static String draftConfirmation ="This draft was created by Mashan. Deleting it will remove it permanently, and it cannot be restored.";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-986")
    public void VerifyDeleteDraftOrder() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        searchItemCode = Customer.getItemCodeFirstRow();
        itemPrice = Customer.getActiveItemPriceFirstRow();
        Customer.searchItemOnOrderGuide(searchItemCode);
        Customer.increaseFirstRowQtyCustom(1);
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice,"The item has not been selected.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemName, "The item selected by the user is different from what is shown on the order review page.");

        Dashboard.navigateToDrafts();
        Assert.assertTrue(Drafts.isUserNavigatedToDrafts(),"navigation error");
        referenceNum = Drafts.getReferenceNum();
        softAssert.assertTrue(Drafts.isLastDraftDisplayed(String.valueOf(itemPrice)),"draft creating error");

        referenceNum = Drafts.getReferenceNum();
        Drafts.clickTrashIcon();
        softAssert.assertTrue(Drafts.isDraftsDeleteTextDisplayed(),"delete draft pop up not display");
        softAssert.assertTrue(Drafts.isDraftDeleteConfirmationDisplayed(draftConfirmation),"draft confirmation not display");
        Drafts.clickYesButton();
        softAssert.assertFalse(Drafts.isReferenceNumberDisplayed(referenceNum),"delete draft not successfully ");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
