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

public class VerifyTheManageStandingOrdersCTAFunctionalityInOrderGuideTest extends TestBase {
    static User user;
    static String itemName,StandingPrice,totalQuantity;
    static String itemCode = "01700";
    static String customerId = "21259";
    static String Dp_Name = "47837013 - Brandon IFC Cut+Dry Agent - Independent Foods Co";
    static double itemPrice;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }


    @Test(groups = "DOT-TC-1563")
    public void VerifyTheManageStandingOrdersCTAFunctionalityInOrderGuide() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
       // softAssert.assertTrue(Customer.isManageStandingOrdersPopUpDisplay(),"Manage Standing Orders pop up display error");
        softAssert.assertTrue(Customer.isCreateStandingOrdersButtonDisplay()," Create Standing Orders button display error");
        Customer.clickCreateStandingOrders();

        Customer.selectDeliveryDateAsLastBefore();
        Customer.searchItemOnOrderGuide(itemCode);
        itemPrice = Customer.getActiveItemPriceFirstRow();
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertTrue(Customer.isReviewStandingOrdersDisplayed(),"navigate error review standing order");
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
        Customer.setStandingOrder();
        softAssert.assertTrue(Customer.isStandingOrderSuccessPopupDisplayed(),"order creating error");
        Customer.clickOK();

        // Edit the standing order
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();

        // softAssert.assertTrue(Customer.isManageStandingOrdersPopUpDisplay(),"Manage Standing Orders pop up display error");
        Customer.clickOnStandingOrderPauseIcon();
        softAssert.assertTrue(Order.isAreYouSurePopUpDisplayed(),"Are you sure pop up not displayed");
        Order.clickYes();
        Customer.clickOnStandingOrderEditIcon();
        softAssert.assertTrue(Customer.isReviewStandingOrdersDisplayed(),"navigate error review standing order");
        Customer.increaseFirstRowQtyByOne();
        totalQuantity = Catalog.getTotalQuantityInReviewOrder();
        Customer.setStandingOrder();
        softAssert.assertTrue(Customer.isStandingOrderSuccessPopupDisplayed(),"order creating error");
        Customer.clickOK();

        Login.navigateToLoginAs();
        Login.goToDistributor(Dp_Name);
        Dashboard.isUserNavigatedToDistributorDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDistributorDashboard(),"login error");
        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        Assert.assertTrue(Customer.isCustomerSearchResultByCodeDisplayed(customerId), "Unable to find the customer Id");
        Customer.SelectCustomer(customerId);
        Customer.clickOnOrdersTab();
        StandingPrice = String.valueOf((int) itemPrice*2);
        softAssert.assertTrue(Customer.isStandingOrdersPaused(),"standing orders not paused");
        softAssert.assertTrue(Customer.isSubmittedStandingOrderDisplayed(totalQuantity,StandingPrice),"standing order submit error");

        Login.navigateToOperator();

        Dashboard.isUserNavigatedToDashboard();
        Assert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        Assert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");

        Customer.expandMoreOptionsDropdown();
        softAssert.assertTrue(Customer.isManageStandingOrdersDisplay(),"Manage Standing Orders option display error");
        Customer.clickManageStandingOrders();
//        softAssert.assertTrue(Customer.isManageStandingOrdersPopupDisplayed()," add section popup error");
        Customer.clickOnStandingOrderResumeIcon();
        softAssert.assertTrue(Order.isAreYouSurePopUpDisplayed(),"Are you sure pop up not displayed");
        Order.clickYes();
        Customer.clickOnStandingOrderDeleteIcon();
        softAssert.assertFalse(Customer.isStandingOrdersDeletedIconDisplay(),"delete error");


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }


}
