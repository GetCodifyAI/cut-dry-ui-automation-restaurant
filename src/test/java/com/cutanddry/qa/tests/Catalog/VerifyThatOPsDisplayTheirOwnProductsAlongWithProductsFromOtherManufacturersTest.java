package com.cutanddry.qa.tests.Catalog;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Catalog;
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

public class VerifyThatOPsDisplayTheirOwnProductsAlongWithProductsFromOtherManufacturersTest extends TestBase {
    static User user;
    String userName = "70351601";
    static String endlessAisle = "Endless Aisle";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1410")
    public void VerifyThatOPsDisplayTheirOwnProductsAlongWithProductsFromOtherManufacturers() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);

        Customer.clickOnPlaceOrderSW();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(endlessAisle),"catalog filter not display");

        Customer.clickOnOrderGuideTab();
        Customer.clearSearchField();
        Thread.sleep(3000);

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigation error for edit");
        Customer.createOrderFromCatalog();
        softAssert.assertTrue(Customer.isEditOrderGuideTextCatalogDisplayed(),"navigation error for edit order guide catalog");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(endlessAisle),"catalog filter not display");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
