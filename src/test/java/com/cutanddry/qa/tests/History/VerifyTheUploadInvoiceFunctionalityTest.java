package com.cutanddry.qa.tests.History;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.History;
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

public class VerifyTheUploadInvoiceFunctionalityTest extends TestBase {
    static User user;
    String supplier = "BiRite Foodservice Distributors";
    String location = "Hayes";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }
    @Test(groups = "DOT-TC-951")
    public void VerifyTheUploadInvoiceFunctionality() throws InterruptedException, URISyntaxException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        History.goToHistory();
        Assert.assertTrue(History.isUserNavigatedToHistory(),"History navigation error");
        History.clickUploadInvoices();
        softAssert.assertTrue(History.isUploadInvoicesWindowDisplayed(),"upload invoices pop up not displayed");
        Customer.uploadFile(Paths.get(Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("Invoices/test_Invoice.jpeg")).toURI()).toString());
        History.selectSupplierInvoice(supplier);
        History.selectRestaurantLocation(location);
        History.clickSave();
        softAssert.assertTrue(History.isInvoicesUploadedPopUpDisplayed(),"uploaded invoice pop up not displayed");
        History.clickOkInvoice();
        softAssert.assertTrue(History.isInvoicesUploadedStatusDisplayed(),"invoice uploaded not success");
        softAssert.assertAll();

    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
