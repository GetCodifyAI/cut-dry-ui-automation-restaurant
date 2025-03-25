package com.cutanddry.qa.tests.Mult_UOM;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyPlaceOrderWithMultiUOMForNonIntegratedTest extends TestBase {
    static User user;
    SoftAssert softAssert;
    String uom1 = "1";
    String uom2 = "2";
    String userName = "jcoupal@coupacafe";
    String supplierName = "David Rio";
    static double itemOGPriceUOM1 ,itemOGPriceUOM2,totalOGItemPrice, multiItemPrice,totalHistoryItemPrice;
    static String multiItemName, multiSearchItemCode, itemCode;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1035")
    public void VerifyPlaceOrderWithMultiUOMForNonIntegrated() throws InterruptedException {
        softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName),"ERROR in Navigating to Suppliers page");
        Customer.sortItemsByCustomOrder();

        multiItemName = Customer.getItemNameFirstMultiOUMCoupa();
        multiSearchItemCode = Customer.getItemCodeFirstMultiOUMCoupa();
        itemCode = multiSearchItemCode.replaceAll("^[A-Za-z]+", "");
        multiItemPrice = Customer.getActiveItemPriceFirstMultiOUMRowStableCoupa();

        Customer.searchItemOnOrderGuide(multiSearchItemCode);
        Customer.ClickOnMultiUomDropDownOG(multiSearchItemCode);
        Customer.clickOGAddToCartPlusIcon(1,multiSearchItemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1,multiSearchItemCode, uom2);
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom1), "1", "item count error in 1st UOM");
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom2), "1", "item count error in 2nd UOM");
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout();
        softAssert.assertEquals(Math.round(totalOGItemPrice * 100.0) / 100.0,
                ((Math.round(itemOGPriceUOM1 * 100.0) / 100.0) + (Math.round(itemOGPriceUOM2 * 100.0) / 100.0)), "The item was not selected properly.");

        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        Customer.clickClose();

        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickOnFirstItemOfOrderHistory();
        totalHistoryItemPrice = History.getItemPriceOnMultiOUM();
        softAssert.assertEquals(Math.round(totalHistoryItemPrice * 100.0) / 100.0,Math.round(totalOGItemPrice * 100.0) / 100.0);

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }

}
