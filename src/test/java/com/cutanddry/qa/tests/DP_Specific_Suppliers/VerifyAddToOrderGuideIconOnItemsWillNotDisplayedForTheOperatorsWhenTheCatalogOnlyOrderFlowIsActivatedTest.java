package com.cutanddry.qa.tests.DP_Specific_Suppliers;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddToOrderGuideIconOnItemsWillNotDisplayedForTheOperatorsWhenTheCatalogOnlyOrderFlowIsActivatedTest extends TestBase {
    static User user;
    static String OperatorName = "477551329";
    static String searchItemCode = "00051";
    static String itemName = "101 Ammonia Clear 64OZ";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1496")
    public void VerifyAddToOrderGuideIconOnItemsWillNotDisplayedForTheOperatorsWhenTheCatalogOnlyOrderFlowIsActivated() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        softAssert.assertTrue(Dashboard.isCatalogDataDisplayed(),"parent company catalog data not displayed");

        Customer.clickOnPlaceOrder();
        softAssert.assertFalse(Customer.isCustomerOrderGuideDisplayed(),"order guide displayed");
        softAssert.assertTrue(Customer.isCatalogDisplayed(),"catalog text not displayed");

        Customer.searchItemOnCatalog(searchItemCode);
        Thread.sleep(4000);
        softAssert.assertTrue(Customer.getFirstElementFrmCatalogSearchResults(itemName).contains(itemName.toLowerCase()), "item not found");
        softAssert.assertFalse(Customer.isAddFromCatalogHeartItemDisplay(),"add from catalog heart item display");
        Customer.clickOnPlusIconInCatalogPDP(2, itemName);


        Customer.clickOnProduct(itemName);
        softAssert.assertTrue(Customer.isProductDetailsDisplayed(),"The user is unable to land on the Product Details page.");
        softAssert.assertFalse(Customer.isAddFromCatalogHeartItemDisplay(),"add from catalog heart item display");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
