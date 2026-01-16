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

public class VerifyOrderGuideManualEntryMaxQuantityValidationTest extends TestBase {
    static User user;
    static String validMaxQuantity = "1999";
    static String invalidQuantity = "2000";
    static String catalogItemCode = "29763";
    static String pdpItemCode = "02092";
    static String pdpItemName = "Fuji Apples 125 CT";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2249")
    public void verifyOrderGuideManualEntryMaxQuantityValidation() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

//        Customer.expandMoreOptionsDropdown();
//        Customer.clickSimpleListView();
//        softAssert.assertTrue(Customer.isSimpleListViewTextDisplay(), "Simple list view section not displayed");

        Customer.enterQuantitySimpleListViewByIndex(1, validMaxQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Reached popup should display for valid quantity 1999");
        Customer.clickErrorModalOkButton();
        String qty1 = Customer.getQuantitySimpleListViewByIndex(1);
        softAssert.assertEquals(qty1, validMaxQuantity, "Valid quantity 1999 should be accepted and displayed");

        Customer.enterQuantitySimpleListViewByIndex(1, invalidQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Exceeded popup should display for invalid quantity 2000");
        Customer.clickErrorModalOkButton();
        String qtyAfterError = Customer.getQuantitySimpleListViewByIndex(1);
        softAssert.assertEquals(qtyAfterError, validMaxQuantity, "Quantity field should be auto-corrected to 1999 after exceeding max");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "navigation to catalog error");

        Customer.searchItemOnCatalog(catalogItemCode);
        softAssert.assertTrue(Customer.isCatalogSearchItemCodeDisplay(catalogItemCode), "Catalog item not found");
        Customer.addItemToCartCatalog();

        Customer.setItemQuantityByCode(catalogItemCode, validMaxQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Reached popup should display for catalog item with quantity 1999");
        Customer.clickErrorModalOkButton();
        String catalogQty1 = Customer.getItemQuantityByCode(catalogItemCode);
        softAssert.assertEquals(catalogQty1, validMaxQuantity, "Catalog item quantity 1999 should be accepted");

        Customer.setItemQuantityByCode(catalogItemCode, invalidQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Exceeded popup should display for catalog item with quantity 2000");
        Customer.clickErrorModalOkButton();
        String catalogQtyAfterError = Customer.getItemQuantityByCode(catalogItemCode);
        softAssert.assertEquals(catalogQtyAfterError, validMaxQuantity, "Catalog item quantity should be auto-corrected to 1999");

        Customer.searchItemOnCatalog(pdpItemCode);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(pdpItemName.toLowerCase()), "PDP item not found in catalog");
        Customer.clickOnProductStable(pdpItemName);
        Customer.clickAddToCartPDP();

        Customer.setCatalogPdpItemCount(validMaxQuantity, pdpItemName);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Reached popup should display for PDP item with quantity 1999");
        Customer.clickErrorModalOkButton();

        Customer.setCatalogPdpItemCount(invalidQuantity, pdpItemName);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Exceeded popup should display for PDP item with quantity 2000");
        Customer.clickErrorModalOkButton();

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");

        Customer.setItemQuantityByCode(catalogItemCode, validMaxQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Reached popup should display on review screen for quantity 1999");
        Customer.clickErrorModalOkButton();

        Customer.setItemQuantityByCode(catalogItemCode, invalidQuantity);
        Customer.tabAwayFromQuantityField();
        softAssert.assertTrue(Customer.isMaxQuantityErrorModalDisplayed(), "Maximum Quantity Exceeded popup should display on review screen for quantity 2000");
        Customer.clickErrorModalOkButton();
        String reviewQtyAfterError = Customer.getItemQuantityByCode(catalogItemCode);
        softAssert.assertEquals(reviewQtyAfterError, validMaxQuantity, "Review screen quantity should be auto-corrected to 1999");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
