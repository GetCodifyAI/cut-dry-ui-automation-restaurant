package com.cutanddry.qa.tests.Catalog;

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

public class VerifyOperatorPortalBrandColumnDisplayInCatalogListViewTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2936")
    public void verifyOperatorPortalBrandColumnDisplayInCatalogListView() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - Dashboard not displayed");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to Order Guide failed");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "Navigation to Catalog failed");

        Customer.clickCatalogListView();
        softAssert.assertTrue(Customer.isCatalogListViewTableDisplayed(), "Catalog list view table not displayed");

        softAssert.assertTrue(Customer.isBrandColumnHeaderDisplayed(), "Brand column header is not displayed in the catalog list view");

        softAssert.assertTrue(Customer.isBrandDataDisplayedInListView(), "Brand data is not displayed in the Brand column");

        String itemName = Customer.getFirstItemNameInListView();
        String brandName = Customer.getFirstItemBrandInListView();
        softAssert.assertFalse(itemName.contains(brandName), "Brand name should not be displayed under the item name - brand name found in item name column");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
