package com.cutanddry.qa.tests.Orders;

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

public class VerifyThatPrimaryOrderGuideDisabledForEditingTest extends TestBase {
    static User user;
    String OperatorName = "475793657";
    static String OrderGuideName = "Wagner Foodservice";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1325")
    public void VerifyThatPrimaryOrderGuideDisabledForEditing() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);

        Dashboard.navigateToOrder();
        Customer.clickOGDropdown();
        Customer.selectOrderGuide(OrderGuideName);
        Customer.clickOnMoreOptionOG();
        softAssert.assertFalse(Customer.isEditOrderGuideOptionDisplay(),"Edit order guide option display");

        Customer.goToCatalog();
        softAssert.assertFalse(Customer.isAddFromCatalogHeartItemDisplay(),"add from catalog heart item display");
        Customer.clickCatalogListView();
        softAssert.assertFalse(Customer.isAddToOrderGuideListViewDisplay(),"catalog list view add to order guide heart icon display");
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
