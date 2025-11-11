package com.cutanddry.qa.tests.Non_Integrated_Suppliers.Coupa_Cafe;

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

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;

import static com.cutanddry.qa.base.TestBase.*;

public class VerifyTheBehaviourWhenAddingAnOrderFromTheUploadToOrderFeatureTest {
    static User user;
    String userName = "jcoupal@coupa";
    String supplierName = "David Rio";
    static String orderId;
    static String itemCode1 = "EV4B";
    static String itemCode2 = "OS4B";


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1527")
    public void VerifyTheBehaviourWhenAddingAnOrderFromTheUploadToOrderFeature() throws InterruptedException, URISyntaxException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);
        Dashboard.selectSupplier(supplierName);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierName), "ERROR in Navigating to Suppliers page");
        Customer.uploadOrder();
        softAssert.assertTrue(Customer.isUploadToOrderTextDisplay(),"upload to order text not display");
        Customer.uploadFile(Paths.get(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("excelFiles/Non_Integrated_Template.xlsx")).toURI()).toString());
        Customer.clickOnNext();
        Customer.clickOnConfirm();

        softAssert.assertTrue(Customer.isReviewOrderTextDisplayed(), "The user is unable to land on the Review Order page.");
        softAssert.assertEquals(Customer.getItemQuantity(itemCode1), "4", "item count error in 1st item");
        softAssert.assertEquals(Customer.getItemQuantity(itemCode2), "2", "item count error in 2nd item");
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(), "The order was not completed successfully.");
        orderId = Customer.getSuccessOrderId();
        Customer.clickClose();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
