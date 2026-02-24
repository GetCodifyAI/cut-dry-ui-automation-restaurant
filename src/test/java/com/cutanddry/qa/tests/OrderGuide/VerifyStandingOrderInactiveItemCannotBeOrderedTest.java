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

public class VerifyStandingOrderInactiveItemCannotBeOrderedTest extends TestBase {
    static User user;
    static String itemCode = "01775";
    static String Dp_Name = "Independent Foods Co";
    String Active = "Active";
    String InActive = "Inactive";
    String All = "All";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2119")
    public void VerifyStandingOrderInactiveItemCannotBeOrdered() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(), "login error");

        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(), "navigation error");
        Catalog.selectItemStatus(All);
        Catalog.searchItemInCatalog(itemCode);
        Catalog.selectItemFromGrid(itemCode);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(), itemCode, "Error in getting Item Code");
        Catalog.selectEditFromProductConfig();
        Catalog.selectProductActiveInactiveStatus(InActive);
        Catalog.saveChanges();

        Login.navigateToOperator();

        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(), "Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
        softAssert.assertTrue(Customer.isCreateStandingOrdersButtonDisplay(), "Create Standing Orders button display error");
        Customer.clickCreateStandingOrders();

       // Customer.selectDeliveryDateAsLastBefore();
        Customer.searchItemOnOrderGuide(itemCode);

        softAssert.assertTrue(Customer.isItemRowDisplayedByCode(itemCode), "Inactive item should be visible in Standing Order flow");
        softAssert.assertTrue(Customer.isPlusButtonDisabledFirstRow(), "Plus button should be disabled for inactive item in Standing Order flow");

        Customer.goToCatalog();
        Customer.searchItemOnCatalog(itemCode);
        boolean itemNotVisibleInCatalog = Customer.isNoItemsFoundInCatalog() || !Customer.isItemRowDisplayedByCode(itemCode);
        softAssert.assertTrue(itemNotVisibleInCatalog, "Inactive item should not be visible in catalog");

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Login.switchIntoNewTab();
        Dashboard.navigateToCatalog();
        softAssert.assertTrue(Catalog.isUserNavigatedToCatalog(), "navigation error");
        Catalog.selectItemStatus(All);
        Catalog.searchItemInCatalog(itemCode);
        Catalog.selectItemFromGrid(itemCode);
        softAssert.assertEquals(Catalog.getItemcodeInCatalogData(), itemCode, "Error in getting Item Code");
        Catalog.selectEditFromProductConfig();
        Catalog.selectProductActiveInactiveStatus(Active);
        Catalog.saveChanges();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
