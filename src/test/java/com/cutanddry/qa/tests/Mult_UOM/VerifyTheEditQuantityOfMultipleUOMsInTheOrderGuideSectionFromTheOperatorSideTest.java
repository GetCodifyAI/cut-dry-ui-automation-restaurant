package com.cutanddry.qa.tests.Mult_UOM;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Catalog;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheEditQuantityOfMultipleUOMsInTheOrderGuideSectionFromTheOperatorSideTest extends TestBase {
    static User user;
    SoftAssert softAssert;
    String uom1 = "1";
    String uom2 = "2";
    static double itemOGPriceUOM1 ,itemOGPriceUOM2,totalOGItemPrice, multiItemPrice;
    static String singleItemName, singleSearchItemCode, multiItemName, multiSearchItemCode, itemCode;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-789")
    public void VerifyTheEditQuantityOfMultipleUOMsInTheOrderGuideSectionFromTheOperatorSide() throws InterruptedException {
        softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.sortItemsByCustomOrder();

        singleItemName = Customer.getItemNameFirstRow();
        singleSearchItemCode = Customer.getItemCodeFirstRow();

        multiItemName = Customer.getItemNameFirstMultiOUM();
        multiSearchItemCode = Customer.getItemCodeFirstMultiOUM();
        itemCode = multiSearchItemCode.replaceAll("^[A-Za-z]+", "");
        multiItemPrice = Customer.getActiveItemPriceFirstMultiOUMRowStable();

        Customer.searchItemOnOrderGuide(multiSearchItemCode);
        Customer.ClickOnMultiUomDropDownOG(itemCode);
        Customer.clickOGAddToCartPlusIcon(1,itemCode, uom1);
        Customer.clickOGAddToCartPlusIcon(1,itemCode, uom2);
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom1), "1", "item count error in 1st UOM");
        softAssert.assertEquals(Customer.getItemUOMQuantity(multiSearchItemCode, uom2), "1", "item count error in 2nd UOM");
        itemOGPriceUOM1 = Customer.getActiveItemPriceMultiOUM(uom1);
        itemOGPriceUOM2 = Customer.getActiveItemPriceMultiOUM(uom2);
        totalOGItemPrice = Customer.getItemPriceOnMultiOUMCheckout();
        softAssert.assertEquals(Math.round(totalOGItemPrice * 100.0) / 100.0,
                ((Math.round(itemOGPriceUOM1 * 100.0) / 100.0) + (Math.round(itemOGPriceUOM2 * 100.0) / 100.0)), "The item was not selected properly.");

        Customer.clickAddToCartMinusIcon(1,itemCode, uom1);
        Customer.clickAddToCartMinusIcon(1,itemCode, uom2);
        softAssert.assertEquals(Math.round(Customer.getItemPriceOnCheckoutButton() * 100.0) / 100.0, 0.00, "The item price is not $0.00.");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
