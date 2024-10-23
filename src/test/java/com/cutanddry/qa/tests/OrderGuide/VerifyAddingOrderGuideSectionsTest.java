package com.cutanddry.qa.tests.OrderGuide;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class VerifyAddingOrderGuideSectionsTest extends TestBase {
    static User user;
    String SectionName = "Diary";

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-285")
    public void VerifyAddingOrderGuideSections() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.goToEdit();
        softAssert.assertTrue(Customer.isEditOrderGuideTextDisplayed(),"ERROR in navigating to Order Guide Edit View");
        Customer.expandMoreOptionsDropdown();
        Customer.selectAddSectionFromMoreOptionsDropdown();
        Customer.addSectionName(SectionName);
        Customer.clickSaveSection();
        softAssert.assertTrue(Customer.isAddedSectionDisplayed(SectionName),"ERROR in displaying the Section in order Guide order Guide added View");
        //Customer.DragSectionToUP();   //fix the drag function
        Customer.clickOnBackBtnInEditOrderGuide();
        //softAssert.assertTrue(Customer.isAddedSectionDisplayed(SectionName),"ERROR in displaying the Section in order Guide");

        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
