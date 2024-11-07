package com.cutanddry.qa.tests.Settings.Accounting;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.functions.Settings;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyEditingAccountCategoryTest extends TestBase {
    static User user;
    String CategoryCode ="1000";
    String CategoryName = "Test Category";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-319")
    public void VerifyEditingAccountCategory() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Settings.clickOnAccounting();
        softAssert.assertTrue(Settings.isNavigatedToAccountingCatagoryPage(),"Error in navigating to Account Categories");
        Settings.clickOnCreatedCategoryCodeInGrid();
        Settings.fillCategoryItemCode(CategoryCode);
        Settings.saveCreatedCategoryItemCodeOrName();
        softAssert.assertTrue(Settings.isCreatedCategoryItemCodeDisplayed(CategoryCode),"Error in creating Category Code");
        Settings.clickOnCreatedCategoryNameInGrid();
        Settings.fillCategoryItemName(CategoryName);
        Settings.saveCreatedCategoryItemCodeOrName();
        softAssert.assertTrue(Settings.isCreatedCategoryItemNameDisplayed(CategoryName),"Error in creating Category Name");

        softAssert.assertAll();
    }


    @AfterMethod
    public void tearDown(ITestResult result){
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }

}
