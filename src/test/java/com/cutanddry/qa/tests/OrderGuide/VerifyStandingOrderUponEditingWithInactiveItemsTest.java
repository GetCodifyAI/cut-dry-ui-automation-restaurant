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

public class VerifyStandingOrderUponEditingWithInactiveItemsTest extends TestBase {
    static User user;
    static String Dp_Name = "Independent Foods Co";
    String searchItemCode = "01775";
    static String itemName;
    static double itemPrice;
    String Active = "Active";
    String InActive = "Inactive";
    String All = "All Items";
    static String title = "Test Order";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2675")
    public void VerifyStandingOrderUponEditingWithInactiveItems() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
        softAssert.assertTrue(Customer.isCreateStandingOrdersButtonDisplay(),"Create Standing Orders button display error");
        Customer.clickCreateStandingOrders();


        Customer.searchItemOnOrderGuide(searchItemCode);
        itemPrice = Customer.getActiveItemPriceFirstRow();
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewStandingOrdersDisplayed(),"navigate error review standing order");
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.typeOnStandingOrderTitle(title);
        Customer.selectDeliveryDateAsLastBefore();

        Customer.setStandingOrder();
        softAssert.assertTrue(Customer.isStandingOrderSuccessPopupDisplayed(),"order creating error");
        Customer.clickOK();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");

        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.selectItemStatus(All);
        Catalog.selectItemFromGrid(searchItemCode);
        Catalog.clickEditOnProductCatalogControl();
        Catalog.selectProductActiveInactiveStatus(InActive);
        Catalog.saveChanges();

        Login.navigateToOperator();

        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
        Customer.clickOnStandingOrderEditIcon();

        softAssert.assertTrue(Order.isInactiveItemDetectedPopUpDisplay(),"Inactive Items Detected alert not displayed");
        Customer.clickClose();
        softAssert.assertTrue(Customer.isReviewStandingOrdersDisplayed(),"navigate error review standing order");
        softAssert.assertEquals(Math.round(Catalog.getTotalPriceInReviewOrder() * 100.0) / 100.0,
                0.00, "Total price in review order is not zero after inactive item removal.");

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Login.switchIntoNewTab();
        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(),"navigation error");
        Catalog.selectItemStatus(All);
        Catalog.selectItemFromGrid(searchItemCode);
        Catalog. clickEditOnProductCatalogControl();
        Catalog.selectProductActiveInactiveStatus(Active);
        Catalog.saveChanges();

        Login.navigateToOperator();

        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
        softAssert.assertTrue(Customer.isStandingOrdersDeletedIconDisplay(),"delete error");
        Customer.clickOnStandingOrderDeleteIcon();
        softAssert.assertTrue(Customer.isCreateStandingOrdersButtonDisplay(),"Create Standing Orders button display error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}