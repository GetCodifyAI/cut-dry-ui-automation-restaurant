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

public class VerifyThatDistributionCentreFilterIsFilteringRelevantDistributorCentresForOPSideTest extends TestBase {
    static User user;
    String OperatorName = "196795934";
    static String filter = "Distribution Center";
    static String tag = "Food Service";
    static String itemName = "15  Grain Crunchy";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1396")
    public void VerifyThatDistributionCentreFilterIsFilteringRelevantDistributorCentresForOPSide() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);

        Dashboard.navigateToOrder();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(filter),"catalog filter not display");
        Customer.selectDistributorCenter(tag);
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTag(itemName,tag),"new tag display error");
        Customer.clickCatalogListView();
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTagList(itemName,tag),"new tag display list error");

        Customer.clickOnOrderGuideTab();
        Thread.sleep(3000);

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigation error for edit");
        Customer.createOrderFromCatalog();
        softAssert.assertTrue(Customer.isCatalogFilterDisplayed(filter),"catalog filter not display");
        Customer.selectDistributorCenter(tag);
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTag(itemName,tag),"new tag display error");
        Customer.clickCatalogListView();
        softAssert.assertTrue(Customer.isCatalogFilterDisplayTagList(itemName,tag),"new tag display list error");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
