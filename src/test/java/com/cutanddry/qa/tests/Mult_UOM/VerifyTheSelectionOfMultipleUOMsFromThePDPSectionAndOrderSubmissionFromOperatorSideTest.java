package com.cutanddry.qa.tests.Mult_UOM;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheSelectionOfMultipleUOMsFromThePDPSectionAndOrderSubmissionFromOperatorSideTest extends TestBase {
    static User user;
    SoftAssert softAssert;
    String uom1 = "1";
    String uom2 = "2";
    static double itemPriceUOM1 ,itemPriceUOM2, multiItemPrice, totalHistoryItemPrice, totalHistoryItemCount,totalPDPItemPrice;
    static String singleSearchItemCode, multiItemName, multiSearchItemCode, itemCode;
    String uomDropDownOption = "Multiple Units";




    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-800")
    public void VerifyTheSelectionOfMultipleUOMsFromThePDPSectionAndOrderSubmissionFromOperatorSide() throws InterruptedException {
        softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.sortItemsByCustomOrder();

        multiItemName = Customer.getItemNameFirstMultiOUM();
        multiSearchItemCode = Customer.getItemCodeFirstMultiOUM();
        itemCode = multiSearchItemCode.replaceAll("^[A-Za-z]+", "");
        multiItemPrice = Customer.getActiveItemPriceFirstMultiOUMRowStable();

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(itemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(multiItemName.toLowerCase()), "item not found");
        Catalog.ClickOnMultiUomDropDown(multiItemName);
        Catalog.ClickOnMultiUomDropDownOption(uomDropDownOption);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        itemPriceUOM1 = Catalog.getPDPPriceUOM(uom1);
        itemPriceUOM2 = Catalog.getPDPPriceUOM(uom2);
        Catalog.clickAddToCartPlusIcon(1, uom1);
        Catalog.clickAddToCartPlusIcon(1, uom2);
        totalPDPItemPrice = Customer.getItemPriceOnCheckoutButtonViaPDP();
        softAssert.assertEquals(Math.round(totalPDPItemPrice * 100.0) / 100.0,
                ((Math.round(itemPriceUOM1 * 100.0) / 100.0)+(Math.round(itemPriceUOM2 * 100.0) / 100.0)), "The item has not been selected.");

        Customer.clickCheckOutPDP();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        singleSearchItemCode = Customer.getItemCodeFirstRow().trim();
        softAssert.assertEquals(singleSearchItemCode,multiSearchItemCode,"The product item codes on the 'Review Order' page is not match the item codes of the products added.");

        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickOnFirstItemOfOrderHistory();
        totalHistoryItemPrice = History.getItemPriceOnMultiOUM();
        totalHistoryItemCount = History.getItemCountOnReviewMultiOUM();
        softAssert.assertEquals(Math.round(totalHistoryItemPrice * 100.0) / 100.0,Math.round(totalPDPItemPrice * 100.0) / 100.0,"The product total price on the 'Review Order' page is not matched with the ordered product details under the 'History' page.");
        softAssert.assertEquals(totalHistoryItemCount,2.0,"The product units on the 'Review Order' page should be matched with the ordered product details under the 'History' page.");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
