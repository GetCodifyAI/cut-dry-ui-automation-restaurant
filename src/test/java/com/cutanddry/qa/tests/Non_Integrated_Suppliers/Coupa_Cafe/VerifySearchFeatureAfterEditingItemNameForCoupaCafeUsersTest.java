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

import static com.cutanddry.qa.base.TestBase.*;

public class VerifySearchFeatureAfterEditingItemNameForCoupaCafeUsersTest {
    static User user;
    String userName = "jcoupal@coupa";
    String supplierNameOne = "David Rio";
    String supplierNameTwo = "Performance Foodservice";
    String originalItemNameOne = "Chai Latte Mix";
    String editedItemNameOne = "Chai Latte Mix Edited";
    String originalItemNameTwo = "Coffee Creamer";
    String editedItemNameTwo = "Coffee Creamer Edited";

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2771")
    public void VerifySearchFeatureAfterEditingItemNameForCoupaCafeUsers() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);

        Dashboard.selectSupplier(supplierNameOne);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierNameOne), "ERROR in Navigating to David Rio Order Guide");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(), "ERROR in navigating to Order Guide Edit View for David Rio");
        Customer.clickOnItemEditBtn(originalItemNameOne);
        softAssert.assertTrue(Customer.isEditItemPopupDisplayed(), "ERROR in displaying Edit Item popup for David Rio");
        Customer.clearAndEditItemName(editedItemNameOne);
        Customer.clickSaveItemBtnOnEditPopup();
        Customer.closeOrderGuideEditor();
        Customer.searchItemOnOrderGuide(editedItemNameOne);
        softAssert.assertTrue(Customer.getItemNameFirstRow().toLowerCase().contains(editedItemNameOne.toLowerCase()), "ERROR: Edited item name not found in search results for David Rio");
        Customer.clickOnBackBtn();
        Customer.goToEdit();
        Customer.clickOnItemEditBtn(editedItemNameOne);
        Customer.clearAndEditItemName(originalItemNameOne);
        Customer.clickSaveItemBtnOnEditPopup();
        Customer.closeOrderGuideEditor();

        Dashboard.selectSupplier(supplierNameTwo);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierNameTwo), "ERROR in Navigating to Performance Foodservice Order Guide");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(), "ERROR in navigating to Order Guide Edit View for Performance Foodservice");
        Customer.clickOnItemEditBtn(originalItemNameTwo);
        softAssert.assertTrue(Customer.isEditItemPopupDisplayed(), "ERROR in displaying Edit Item popup for Performance Foodservice");
        Customer.clearAndEditItemName(editedItemNameTwo);
        Customer.clickSaveItemBtnOnEditPopup();
        Customer.closeOrderGuideEditor();
        Customer.searchItemOnOrderGuide(editedItemNameTwo);
        softAssert.assertTrue(Customer.getItemNameFirstRow().toLowerCase().contains(editedItemNameTwo.toLowerCase()), "ERROR: Edited item name not found in search results for Performance Foodservice");
        Customer.clickOnBackBtn();
        Customer.goToEdit();
        Customer.clickOnItemEditBtn(editedItemNameTwo);
        Customer.clearAndEditItemName(originalItemNameTwo);
        Customer.clickSaveItemBtnOnEditPopup();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
