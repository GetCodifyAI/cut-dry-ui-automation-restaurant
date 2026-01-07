package com.cutanddry.qa.tests.Roles;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyUniversalAppBookkeeperRolesTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";
    static String OperatorName = "61714031";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-641")
    public void VerifyUniversalAppBookkeeperRoles() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Login.navigateToLoginAs();
        Login.loginAsBookkeeper(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
    //    Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.clickOnBackBtnInEditOrderGuide();
        Customer.searchItemOnOrderGuide(itemName);
        softAssert.assertTrue(Customer.getItemNameFirstRow().equalsIgnoreCase(itemName),"item mismatch");
        Customer.increaseFirstRowQtyBySixClassic();
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"navigation error");
        Customer.searchItemOnCatalog(itemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().equalsIgnoreCase(itemName), "item not found");
        Customer.increaseCatalogQtyByThree();
        Customer.checkoutItems();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        Customer.clickClose();

        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"navigation to history error");
        Dashboard.navigateToDrafts();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDrafts(),"navigation to drafts error");
        Dashboard.navigateToChats();
        softAssert.assertTrue(Dashboard.isUserNavigatedToChats(),"navigation to chats error");
        Suppliers.goToSuppliers();
        softAssert.assertTrue(Suppliers.isUserNavigatedToSupplier(),"navigation to suppliers error");
        Dashboard.navigateToUsers();
        softAssert.assertTrue(Users.isNavigatedToUserTab(),"navigation to users error");
        Users.clickAddUser();
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Admin"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Manager"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Employee"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Bookkeeper"),"users error");
        Customer.clickClose();

//        Support.goToSupportPage();
//        softAssert.assertTrue(Support.supportCenterHeader(),"support page not loaded");
        Login.navigateToOperator();
        Settings.clickOnProfileUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToProfileSetting(),"navigation to profile settings error");
        Settings.clickOnBusinessUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToRestaurantSettings(),"navigation to restaurant settings error");
        Settings.clickOnLocationsUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToLocationSettings(),"navigation to loc settings error");
        Settings.clickOnAccounting();
        softAssert.assertTrue(Settings.isNavigatedToAccountingCatagoryPage(),"Error in navigating to Account Categories");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsersAtOnce();
    }

}
