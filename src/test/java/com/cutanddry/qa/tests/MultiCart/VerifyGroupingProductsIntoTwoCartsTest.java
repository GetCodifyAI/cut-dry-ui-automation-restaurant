package com.cutanddry.qa.tests.MultiCart;
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


public class VerifyGroupingProductsIntoTwoCartsTest extends TestBase{
    static User user;
    static String OperatorName = "(explorer) - Bermuda Biological Station";
    static String itemName_1 = "Beef Bouillon Cubes";
    static String itemName_2 = "All Purpose Flour";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-137")
    public void verifyGroupingProductsIntoTwoCarts() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.goToOperatorBermudaBiologicalStation(OperatorName);
        restaurantUI.switchToNewTab();
        Customer.clickOnPlaceOrder();
        Customer.searchItemOnOrderGuide(itemName_1);
        Customer.addItemFromCatalogIfNotAvailableInOG(itemName_1);
        softAssert.assertTrue(Customer.getItemNameFirstRowWL().contains(itemName_1), "item 1 mismatch");
        Customer.increaseFirstRowQtyByOneInWL();
        Customer.searchItemOnOrderGuide(itemName_2);
        Customer.addItemFromCatalogIfNotAvailableInOG(itemName_2);
        softAssert.assertTrue(Customer.getItemNameFirstRowWL().contains(itemName_2), "item 2 mismatch");
        Customer.increaseFirstRowQtyByOneInWL();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isMultiDistCentersDisplayed(),"multi cart error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
