package com.cutanddry.qa.tests.Orders;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Order;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyThatManuallyOrderGuideCanEditTest extends TestBase {
    static User user;
    String OperatorName = "Tro DerSarkissian";
    static String OrderGuideName = "Test_OG";
    static String itemName ="Capers Surfine 32 OZ";



    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1282")
    public void VerifyThatManuallyOrderGuideCanEdit() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);

        Dashboard.navigateToOrderGuideCustom();
        Customer.goToCreatePopup();
        Customer.createOrderGuide(OrderGuideName);
        Customer.createOrderFromCatalog();
        Customer.searchItemOnCatalog(itemName);
        Customer.addItemFromCatalog();
        Customer.closeEditor();

        Customer.clickOnMoreOptionOG();
        Customer.clickOnDeleteOrderGuide();
        softAssert.assertTrue(Order.isAreYouSurePopUpDisplayed(),"Are you sure pop up not displayed");
        Order.clickYes();
        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
