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

public class VerifyWLAppManagerRolesTest extends TestBase {
    static User user;
    static String item = "Lettuce - Spring Mix Sweet";
    static String itemName = "Arugula Baby";
    static String OperatorName = "CHEF GLENDA";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-646")
    public void VerifyUniversalAppAdminRoles() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.isUserNavigatedToDashboard();
        Login.navigateToLoginAs();
        Login.loginAsManagerWL(OperatorName);
        restaurantUI.switchToNewTab();
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"navigating to order guide edit error");
        Customer.clickOnBackBtnInEditOrderGuide();
        Customer.searchItemOnOrderGuide(item);
        Customer.increaseFirstRowQtyByOne();
        Customer.goToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"navigation error");
        Customer.searchItemOnCatalog(itemName);
        Customer.addItemFromCatalog();
        Customer.increaseCatalogQtyByThree();
        Customer.checkoutItems();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"order not completed");
        Customer.clickClose();
        History.goToHistory();
        softAssert.assertTrue(History.isUserNavigatedToHistory(),"navigation to history error");
        Dashboard.navigateToApprovals();
        softAssert.assertTrue(Dashboard.isApprovalsTabDisplayed(),"navigation to approval error");
        Dashboard.navigateToDrafts();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDrafts(),"navigation to drafts error");
        Dashboard.navigateToChats();
        softAssert.assertTrue(Dashboard.isUserNavigatedToChats(),"navigation to chats error");
        Settings.clickOnProfileUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToProfileSetting(),"navigation to profile settings error");
        Settings.clickOnRestaurantUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToRestaurantSettings(),"navigation to restaurant settings error");
        Settings.clickOnLocationsUnderSettings();
        softAssert.assertTrue(Settings.isNavigatedToLocationSettings(),"navigation to loc settings error");
        restaurantUI.switchToNewTab();
        restaurantUI.switchToNewTab();
        Dashboard.navigateToUsers();
        softAssert.assertTrue(Users.isNavigatedToUserTab(),"navigation to users error");
        Users.clickAddUser();
        softAssert.assertFalse(Users.selectEmployeeFromDropDown("Admin"),"users error");
        softAssert.assertFalse(Users.selectEmployeeFromDropDown("Manager"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Employee"),"users error");
        softAssert.assertTrue(Users.selectEmployeeFromDropDown("Bookkeeper"),"users error");
        Customer.clickClose();
        Dashboard.navigateToReports();
        softAssert.assertTrue(Reports.disabledGenerateReport(),"error in  generate report button");
        Reports.generateReport();
        Reports.clickOnDropdownReportType();
        softAssert.assertTrue(Reports.isReportTypeDisplayed("monthly expenses by vendor"),"report type error");
        softAssert.assertTrue(Reports.isReportTypeDisplayed("monthly expenses by location"),"report type error");
        softAssert.assertTrue(Reports.isReportTypeDisplayed("expenses by product"),"report type error");
        softAssert.assertTrue(Reports.isReportTypeDisplayed("expenses by employee"),"report type error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
