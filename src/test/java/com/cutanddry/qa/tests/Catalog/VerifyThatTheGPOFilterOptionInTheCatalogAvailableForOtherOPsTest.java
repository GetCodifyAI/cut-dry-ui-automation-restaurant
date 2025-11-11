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

public class VerifyThatTheGPOFilterOptionInTheCatalogAvailableForOtherOPsTest extends TestBase {
    static User user;
    String OperatorName = "274671749";
    static String deals = "Deals";
    static String itemName = "Towel Roll Hand 2Ply White Premium";
    static String tag = "GPO";
    static String itemCode = "207329";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1416")
    public void VerifyThatTheGPOFilterOptionInTheCatalogAvailableForOtherOPs() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);

        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"ERROR in navigating to catalog page");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(deals),"catalog filter not display");
        Catalog.clickDealsType();
        softAssert.assertTrue(Catalog.isGPOContractedDisplay(),"GPO contracted option filter display error");
        Customer.searchItemOnCatalog(itemCode);
        Thread.sleep(5000);
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTag(itemName,tag),"tag display catalog error");


        Customer.clickOnOrderGuideTab();
        Customer.clearSearchField();
        Thread.sleep(3000);

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigation error for edit");
        Customer.createOrderFromCatalog();
        softAssert.assertTrue(Customer.isEditOrderGuideTextCatalogDisplayed(),"navigation error for edit order guide catalog");
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(deals),"catalog filter not display");
        Catalog.clickDealsType();
        softAssert.assertTrue(Catalog.isGPOContractedDisplay(),"GPO contracted option filter display error");
        Customer.searchItemOnCatalog(itemCode);
        Thread.sleep(5000);
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTag(itemName,tag),"tag display catalog error");

        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
