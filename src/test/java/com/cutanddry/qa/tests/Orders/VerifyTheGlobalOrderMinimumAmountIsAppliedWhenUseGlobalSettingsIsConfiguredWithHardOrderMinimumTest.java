package com.cutanddry.qa.tests.Orders;

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

public class VerifyTheGlobalOrderMinimumAmountIsAppliedWhenUseGlobalSettingsIsConfiguredWithHardOrderMinimumTest extends TestBase {
    static User user;
    static String OperatorName = "188445316";
    static String defaultOrderMin = "0";
    static String orderMinimumType = "Hard Order Minimum";
    static String orderMinInternal = "50000";
    String distributor = "Independent Foods Co";
    static String Dp_Name = "Independent Foods Co";
    static String orderMinimumSetting = "Use Global Settings";
    static String customerId = "17143";


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-1640")
    public void VerifyTheGlobalOrderMinimumAmountIsAppliedWhenUseGlobalSettingsIsConfiguredWithHardOrderMinimum() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.TurnOnOrderMinimumGloballyToggle(true);
        InternalTools.clickOnOrderMinimumDropdown(orderMinimumType);
        InternalTools.enterOrderMinimumAmount(orderMinInternal);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        //set hard hold minimum
        Dashboard.navigateToOrderSettings();
        softAssert.assertTrue(Settings.isOrderSettingsTextDisplayed(),"navigation error");
        Settings.selectOrderMinimum(false);
        Settings.clickOnSaveChanges();

        //set global order minimum from the profile
        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        softAssert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId), "Unable to find the customer Id");
        Customer.SelectCustomer(customerId);
        Customer.SelectOrderMinimumFromProfile(orderMinimumSetting);
        Customer.ifHasHoldsRemoveHoldsFromCustomer();
        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        Customer.increaseFirstRowQtyCustom(1);
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        softAssert.assertTrue(Customer.isMinOrderBannerDisplayed(),"banner not appearing error");
        Customer.submitOrderMinimum();
        softAssert.assertTrue(Customer.isOrderMinPopupDisplayed(),"popup display error");

        Login.closePreviousTab();

        //Distributor flow
        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToOrderSettings();
        softAssert.assertTrue(Settings.isOrderSettingsTextDisplayed(),"navigation error");
        Settings.enterOrderMinimum(defaultOrderMin);
        Settings.selectOrderMinimum(true);
        Settings.clickOnSaveChanges();

        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
