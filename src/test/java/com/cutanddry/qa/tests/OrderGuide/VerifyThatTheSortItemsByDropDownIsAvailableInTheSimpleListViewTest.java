package com.cutanddry.qa.tests.OrderGuide;

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

import java.util.LinkedHashMap;
import java.util.Map;

public class VerifyThatTheSortItemsByDropDownIsAvailableInTheSimpleListViewTest extends TestBase {
    static User user;
    static String CompanyName = "Independent Foods Co";
    static String simpleListView = "Enabled on DP Portal & Operator App";

    Map<String, String> sortOptionsMap = new LinkedHashMap<>() {{
        put("Item Code", "00036");
        put("UPC", "041560102827");
        put("Brand", "Aesops Bagels");
        put("Description", "Bagel - Cinnamon Raisin Frothy Monkey");
        put("Pack Size", "1 Lb");
    }};


    @BeforeMethod
    public void setUp() {
        initialization();
        user = JsonUtil.readUserLogin();

    }

    @Test(groups = "DOT-TC-1526")
    public void VerifyThatTheSortItemsByDropDownIsAvailableInTheSimpleListView() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(), "login error");

        Login.navigateToInternalTools();
        InternalTools.navigateToConfigureSupplier();
        InternalTools.navigateToEditDetails(CompanyName);
        InternalTools.navigateToOrderingSettingsTab();
        InternalTools.clickOnSimpleListViewDropdown(simpleListView);
        InternalTools.clickSave();
        softAssert.assertTrue(InternalTools.isSuccessPopUpDisplayed(),"change not save");
        InternalTools.clickOkOnSuccessBtn();


        Login.navigateToOperator();
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        Customer.clickSimpleListView();
        softAssert.assertTrue(Customer.isSimpleListViewTextDisplay(),"simple list view section not display");
        Customer.clickSortOptionsDropdown();
        for (Map.Entry<String, String> entry : sortOptionsMap.entrySet()) {
            String sortOption = entry.getKey();
            String expectedSortResult = entry.getValue();

            Customer.clickSortOptionsOG(sortOption);
            softAssert.assertTrue(Customer.isSortOptionDisplay(expectedSortResult),
                    "Sort option: " + sortOption + " - Expected result: " + expectedSortResult + " is displayed");
        }
        softAssert.assertAll();

    }
    
    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }
}
