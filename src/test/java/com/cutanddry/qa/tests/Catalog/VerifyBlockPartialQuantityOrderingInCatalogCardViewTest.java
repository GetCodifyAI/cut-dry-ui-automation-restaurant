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

public class VerifyBlockPartialQuantityOrderingInCatalogCardViewTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24CT";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2952")
    public void verifyBlockPartialQuantityOrderingInCatalogCardView() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "Login failed - user not navigated to dashboard");

        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(), "Navigation to order guide failed");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(), "Navigation to catalog failed");

        Customer.searchItemOnCatalog(itemName);

        String initialQty = Customer.getItemQtyCatalog();
        softAssert.assertNotNull(initialQty, "Initial quantity should be displayed");

        Customer.increaseCatalogQtyByThree();
        String qtyAfterIncrease = Customer.getItemQtyCatalog();
        softAssert.assertTrue(isWholeNumber(qtyAfterIncrease), "Quantity after increase should be a whole number");

        Customer.decreaseCatalogQtyByThree();
        String qtyAfterDecrease = Customer.getItemQtyCatalog();
        softAssert.assertTrue(isWholeNumber(qtyAfterDecrease), "Quantity after decrease should be a whole number");

        softAssert.assertAll();
    }

    private boolean isWholeNumber(String quantity) {
        if (quantity == null || quantity.isEmpty()) {
            return false;
        }
        try {
            double value = Double.parseDouble(quantity);
            return value == Math.floor(value);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
