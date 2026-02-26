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

public class VerifyMaxQuantityStepperValidationTest extends TestBase {
    static User user;
    static String itemCode;
    static final String ITEM_NAME = "Artichoke -24ct";
    static final String MAX_QTY = "1999";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    private void loginAndNavigateToSupplier() throws InterruptedException {
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Dashboard.navigateToIndependentFoodsCo();
    }

    private void verifyMaxQuantityModalAndDismiss(SoftAssert softAssert) throws InterruptedException {
        softAssert.assertTrue(Customer.isMaxQuantityExceededModalDisplayed(), "Maximum Quantity Exceeded modal should be displayed");
        softAssert.assertTrue(Customer.isMaxQuantityExceededMessageDisplayed(), "Maximum quantity message should be displayed");
        Customer.clickMaxQuantityModalOk();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityOrderGuide() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        itemCode = Customer.getItemCodeFirstRow();

        Customer.setItemQuantityByCode(itemCode, "1998");
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1998", "Quantity should be 1998");

        Customer.increaseFirstRowQtyByOne();
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), MAX_QTY, "Quantity should be 1999 after increment");

        Customer.increaseFirstRowQtyByOne();

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), MAX_QTY, "Quantity should remain 1999 after dismissing modal");

        softAssert.assertAll();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityPDP() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "navigation to catalog error");

        Customer.searchItemOnCatalog(ITEM_NAME);
        Customer.clickOnProduct(ITEM_NAME);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(), "PDP should be displayed");

        Customer.clickOnPlusIconInCatalogPDP(1998, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertAll();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityCarousels() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "navigation to catalog error");

        Customer.searchItemOnCatalog(ITEM_NAME);
        Customer.clickOnProduct(ITEM_NAME);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(), "PDP should be displayed");

        Customer.clickOnPlusIconInCatalogPDP(1998, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertAll();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityCatalogGridView() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "navigation to catalog error");

        Customer.searchItemOnCatalog(ITEM_NAME);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(ITEM_NAME.toLowerCase()), "item not found in catalog");

        Customer.clickOnPlusIconInCatalogPDP(1998, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertAll();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityCatalogListView() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "navigation to catalog error");

        Customer.clickOnListView();

        Customer.searchItemOnCatalog(ITEM_NAME);

        Customer.clickOnPlusIconInCatalogPDP(1998, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);
        Customer.clickOnPlusIconInCatalogPDP(1, ITEM_NAME);

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertAll();
    }

    @Test(groups = "DOT-TC-2248")
    public void verifyMaxQuantityReviewScreen() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        loginAndNavigateToSupplier();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        itemCode = Customer.getItemCodeFirstRow();

        Customer.increaseFirstRowQtyByOne();

        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "Review Order screen should be displayed");

        Customer.setItemQuantityByCode(itemCode, "1998");
        softAssert.assertEquals(Customer.getItemQuantityByCode(itemCode), "1998", "Quantity should be 1998 in Review Screen");

        Customer.increaseReviewCartQtyByThree();

        verifyMaxQuantityModalAndDismiss(softAssert);

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
