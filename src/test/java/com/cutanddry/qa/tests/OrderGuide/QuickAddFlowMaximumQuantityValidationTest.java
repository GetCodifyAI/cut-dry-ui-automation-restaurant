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

public class QuickAddFlowMaximumQuantityValidationTest extends TestBase {
    static User user;
    String distributor = "Independent Foods Co";
    static String simpleListView = "Enabled on DP Portal & Operator App";
    static String status ="Enabled on DP Portal & Operator App";
    static String itemQuantity = "3000" ;
    static String itemQuantityReenter = "800" ;
    static String itemCode = "02345";
    static String itemDescription = "Lemons 115 CT";
    static String searchItemCode = "01700";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-2251")
    public void QuickAddFlowMaximumQuantityValidationTest () throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.clickOnQuickAddViewDropDown(status);
        InternalTools.clickOnSimpleListViewDropdown(simpleListView);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToOperator();
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isQuickAddOptionDisplay(),"quick add option display error");
        Customer.clickQuickAdd();
        softAssert.assertTrue(Customer.isQuickAddViewDisplay(),"quick add view page display error");
        Customer.enterItemCodeQuickAdd(itemCode);
        Customer.enterItemQuantity(itemQuantity);
        Customer.clickVerifyItem();
        softAssert.assertTrue(Customer.isItemVerifiedFailedPopUpDisplay(),"item verified failed pop up not display");
        Customer.clickClosePopUpButton();
        softAssert.assertTrue(Customer.isMaxQuantityExceededErrorMsg(),"item max quantity exceeded error message not display");
        Customer.enterItemQuantityWithClear(itemQuantityReenter);
        Customer.clickVerifyItem();
        softAssert.assertTrue(Customer.isItemVerifiedPopUpDisplay(),"item verified pop up not display");
        Customer.clickClosePopUpButton();
        Customer.clickSaveAndReview();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemNameFirstRow(), itemDescription, "The item selected by the user is different from what is shown on the order review page.");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
