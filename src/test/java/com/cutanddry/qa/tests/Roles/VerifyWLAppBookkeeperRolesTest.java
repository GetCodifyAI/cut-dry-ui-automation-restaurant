package com.cutanddry.qa.tests.Roles;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.*;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyWLAppBookkeeperRolesTest extends TestBase {
    static User user;
    static String itemName = "Artichoke -24ct";
    static String OperatorName = "Brandon IFC White";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-644")
    public void VerifyWLAppBookkeeperRoles() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.loginAsBookkeeperWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigating to order guide edit error");
        Customer.clickOnBackBtnInEditOrderGuide();
        Customer.searchItemOnOrderGuide(itemName);
        softAssert.assertTrue(Customer.getItemNameFirstRow().contains(itemName),"item mismatch");
        Customer.increaseFirstRowQtyByThree();
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"navigation error");
        Customer.searchItemOnCatalog(itemName);
        softAssert.assertTrue(Customer.getFirstElementFrmSearchResults().contains(itemName), "item not found");
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
        Dashboard.navigateToPay();
        softAssert.assertTrue(Dashboard.isUserNavigatedToPay(),"navigation to pay error");
        Dashboard.navigateToUsers();
        softAssert.assertTrue(Users.isNavigatedToUserTab(),"navigation to users error");
        Users.clickAddUser();
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Admin"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Manager"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Employee"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Bookkeeper"),"users error");
        Customer.clickClose();
        Settings.clickOnProfileUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToProfileSetting(),"navigation to profile settings error");
        Settings.clickOnRestaurantUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToRestaurantSettings(),"navigation to restaurant settings error");
        Settings.clickOnLocationsUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToLocationSettings(),"navigation to loc settings error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
