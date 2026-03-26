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

public class VerifyTheAvailabilityFilterIsVisibleInCatalogForLipariOPsTest extends TestBase {
    static User user;
    static String availabilityFilter = "Availability";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1408")
    public void VerifyTheAvailabilityFilterIsVisibleInCatalogForLipariOPs() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(availabilityFilter),"Availability filter not displayed in catalog");
        Customer.clickOnOrderGuideTab();

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigation error for edit");
        Customer.createOrderFromCatalog();
        softAssert.assertTrue(Customer.isEditOrderGuideTextCatalogDisplayed(),"navigation error for edit order guide catalog");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(availabilityFilter),"Availability filter not displayed in edit order guide catalog");
        Customer.closeEditor();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
