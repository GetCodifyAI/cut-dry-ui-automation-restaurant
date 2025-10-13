package com.cutanddry.qa.tests.default_view;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.InternalTools;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyTheDefaultViewIsCorrectlyDisplayingWhenSetUpFromInternalToolsForOperatorTest extends TestBase {
    static User user;
    static String DP = "Hillcrest Foodservice";
    static String OperatorName = "177931291";
    SoftAssert softAssert;
    static String simpleListView = "Enabled on DP Portal & Operator App";
    static String status ="Enabled on DP Portal & Operator App";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-1544")
    public void verifyTheDefaultViewIsCorrectlyDisplayingWhenSetUpFromInternalToolsForDistributor() throws InterruptedException {
        softAssert = new SoftAssert();

        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");

        // Enable Quick Add and Simple List view
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.clickOnQuickAddViewDropDown(status);
        InternalTools.clickOnSimpleListViewDropdown(simpleListView);
        InternalTools.enableDefaultViewPortalAsOrderGuide();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isEditOrderGuideTextCatalogDisplayed(),"Order Guide text is not displayed as expected when default view is set from Config Supplier.");

        // Catalog
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.enableDefaultViewPortalAsCatalog();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();
        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isTopCategoryPicksDisplayed(),"Catalog view is not displayed as expected when default view is set to Catalog from Config Supplier.");

        // Quick Add
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.enableDefaultViewPortalAsQuickAdd();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();
        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isQuickAddViewDisplay(),"Quick Add view is not displayed as expected when default view is set to Quick Add from Config Supplier.");

        // Simple List
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.enableDefaultViewPortalAsSimpleList();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();
        Login.closePreviousTab();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isSimpleListViewTextDisplay(),"Simple List view is not displayed as expected when default view is set to Simple List from Config Supplier.");

        //        TODO: Flow is not implemented in dev end
        // Scan To Order
        /*Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.enableDefaultViewPortalAsScanToOrder();

        Login.navigateToLoginAs();
        Login.logInToOperatorAsWhiteLabel(OperatorName);
        Dashboard.navigateToOrder();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"Catalog view is not displayed as expected when default view is set to Catalog from Config Supplier.");
*/
        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(DP);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.enableDefaultViewPortalAsOrderGuide();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();

        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
