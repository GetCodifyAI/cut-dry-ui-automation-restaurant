package com.cutanddry.qa.tests.OrderGuide;


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

public class VerifyTheSearchFeatureAfterEditingAnItemNameTest extends TestBase {
    static User user;
    String originalItemName = "Asparagus 11 LB";
    String editedItemName = "Asparagus 11 LB Edited";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-2769")
    public void VerifyTheSearchFeatureAfterEditingAnItemName() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.clickOnItemEditBtn(originalItemName);
        softAssert.assertTrue(Customer.isEditItemPopupDisplayed(),"ERROR in displaying Edit Item popup");
        Customer.clearAndEditItemName(editedItemName);
        Customer.clickSaveItemBtnOnEditPopup();
        Customer.closeOrderGuideEditor();
        Customer.searchItemOnOrderGuide(editedItemName);
        softAssert.assertTrue(Customer.getItemNameFirstRow().toLowerCase().contains(editedItemName.toLowerCase()),"ERROR: Edited item name not found in search results");
        Customer.clickOnBackBtn();
        Customer.goToEdit();
        Customer.clickOnItemEditBtn(editedItemName);
        Customer.clearAndEditItemName(originalItemName);
        Customer.clickSaveItemBtnOnEditPopup();
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}