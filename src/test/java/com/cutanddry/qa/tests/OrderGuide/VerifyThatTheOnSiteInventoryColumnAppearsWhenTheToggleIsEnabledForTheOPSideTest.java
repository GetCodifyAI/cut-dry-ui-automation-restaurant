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

public class VerifyThatTheOnSiteInventoryColumnAppearsWhenTheToggleIsEnabledForTheOPSideTest extends TestBase {
    static User user;
    static String distributor = "Wilcox Foods";
    static String OperatorName = "384083841";
    static double itemPrice;
    static String orderId;



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1573")
    public void VerifyThatTheOnSiteInventoryColumnAppearsWhenTheToggleIsEnabledForTheOPSide() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();

        InternalTools.manualOrderQuantityCalculationToggle(true);

        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrderGuideCustom();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuideNotIncludeCatalogTag(),"navigation error");

        itemPrice = Customer.getActiveItemPriceFirstRow();

        Customer.editCalculateOrderQty();
        softAssert.assertTrue(Customer.isCalculateOrderQtyDisplayed(),"popup error");
        Customer.enterOnSiteInvValue("2");
        Customer.enterParValue("10");
        softAssert.assertEquals(Customer.getItemPriceTotal(),itemPrice*8,"The item has not been selected par.");
        Customer.clickOnSaveStable();
        softAssert.assertEquals(Customer.getItemQtyFirstRow(),"8", "item count error");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),itemPrice*8,"The item has not been selected.");
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(distributor);
        InternalTools.navigateToOrderingSettingsTab();

        InternalTools.manualOrderQuantityCalculationToggle(false);

        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
