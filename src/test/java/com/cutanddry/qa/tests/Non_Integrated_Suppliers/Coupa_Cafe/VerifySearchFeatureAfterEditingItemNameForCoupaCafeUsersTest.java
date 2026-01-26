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
    String originalItemNameOne;
    String originalItemNameTwo;
    String editedItemNameOne;
    String editedItemNameTwo;
    String itemCodeOne;
    String itemCodeTwo;

    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2771")
    public void VerifySearchFeatureAfterEditingItemNameForCoupaCafeUsers() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");
        Login.navigateToLoginAs();
        Login.logInToOperator(userName);

        Dashboard.selectSupplier(supplierNameOne);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierNameOne), "ERROR in Navigating to David Rio Order Guide");

        originalItemNameOne = Customer.getItemNameFirstRow();
        itemCodeOne = Customer.getItemCodeFirstRow();
        editedItemNameOne = "EditedItem_" + System.currentTimeMillis();

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(), "ERROR in navigating to Order Guide Edit View for David Rio");
        Customer.clickOnItemEditBtn(itemCodeOne);
        Customer.updateItemName(editedItemNameOne);
        Customer.clickSaveItemBtnWithoutRefresh();
        Customer.clickOnBackBtnInEditOrderGuide();

        Customer.searchItemOnOrderGuide(editedItemNameOne);
        String searchResultOne = Customer.getFirstItemNameFrmSearchResults();
        softAssert.assertTrue(searchResultOne.contains(editedItemNameOne) || editedItemNameOne.contains(searchResultOne),
                "Search result does not contain the edited item name for David Rio. Expected: " + editedItemNameOne + ", Found: " + searchResultOne);

        Customer.goToEdit();
        Customer.clickOnItemEditBtn(itemCodeOne);
        Customer.updateItemName(originalItemNameOne);
        Customer.clickSaveItemBtnWithoutRefresh();
        Customer.clickOnBackBtnInEditOrderGuide();

        Dashboard.selectSupplier(supplierNameTwo);
        Assert.assertTrue(Dashboard.isNavigatedToOperatorOrderGuide(supplierNameTwo), "ERROR in Navigating to Performance Foodservice Order Guide");

        originalItemNameTwo = Customer.getItemNameFirstRow();
        itemCodeTwo = Customer.getItemCodeFirstRow();
        editedItemNameTwo = "EditedItem_" + System.currentTimeMillis();

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(), "ERROR in navigating to Order Guide Edit View for Performance Foodservice");
        Customer.clickOnItemEditBtn(itemCodeTwo);
        Customer.updateItemName(editedItemNameTwo);
        Customer.clickSaveItemBtnWithoutRefresh();
        Customer.clickOnBackBtnInEditOrderGuide();

        Customer.searchItemOnOrderGuide(editedItemNameTwo);
        String searchResultTwo = Customer.getFirstItemNameFrmSearchResults();
        softAssert.assertTrue(searchResultTwo.contains(editedItemNameTwo) || editedItemNameTwo.contains(searchResultTwo),
                "Search result does not contain the edited item name for Performance Foodservice. Expected: " + editedItemNameTwo + ", Found: " + searchResultTwo);

        Customer.goToEdit();
        Customer.clickOnItemEditBtn(itemCodeTwo);
        Customer.updateItemName(originalItemNameTwo);
        Customer.clickSaveItemBtnWithoutRefresh();
        Customer.clickOnBackBtnInEditOrderGuide();

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
