package com.cutanddry.qa.tests.Orders;

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

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class VerifyUserCanOrderItemsBeforeCutOffTest extends TestBase {
    static User user;
    String customerId = "21259";

    @BeforeMethod
    public void setUp(){
        secInitialization();
        user = JsonUtil.readUserLogin();
    }

    @Test(groups = "DOT-TC-326")
    public void VerifyUserCanOrderItemsBeforeCutOff() throws InterruptedException {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDisDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDisDashboard(),"login error");
        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        Customer.selectCustomer(customerId);
        softAssert.assertEquals(Customer.isNavigatedToProfile(customerId),customerId,"Error in navigating to Profile page");
        Customer.editDeliveryDate();

        //Date getting the dates and times
        ZonedDateTime tomorrowDate = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC).plusDays(1);
        ZonedDateTime todayDate = ZonedDateTime.now().withZoneSameInstant(ZoneOffset.UTC);
        DateTimeFormatter fullDayInTextFormat = DateTimeFormatter.ofPattern("EEEE");
        String formattedTomorrowDate = tomorrowDate.format(fullDayInTextFormat);
        String formattedTodayDate = todayDate.format(fullDayInTextFormat);


        //Getting the order cut off time
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        ZonedDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(4));
        DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");
        String cutoffTimeStr = cutoffTime.format(timeformatter);

        Customer.clickOnPreviousDateDropdow(formattedTomorrowDate);
        Customer.selectTodayFromDropdownAsCutOff(formattedTodayDate);
        Customer.selectCutOffTime(formattedTomorrowDate,cutoffTimeStr);
        Customer.saveChangesInCutOffTimeOverlay();
        closeAllBrowsers();
        initialization();


        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToOrderGuide(),"navigation error");
        itemName = Customer.getItemNameFirstRow();
        Customer.increaseFirstRowQtyByOne();
        Customer.checkoutItems();
        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");

        //getting the delivery date and asserting
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("EEE, MMM dd");
        String formattedDeliveryDate = tomorrowDate.format(dateFormatter);
        softAssert.assertEquals(Customer.getDeliveryDateOnReviewCart(),formattedDeliveryDate,"Delivery date mismatch");

        //getting the Order Cut Off Time in review cart and asserting
        ZonedDateTime convertedTime = currentTime.withZoneSameInstant(ZoneId.of("GMT+05:30")).plusMinutes(4);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM d, h:mma 'GMT'XXX");
        String cutOffTimeInReviewCart = convertedTime.format(dateTimeFormatter).replace("AM", "am").replace("PM", "pm");
        cutOffTimeInReviewCart = cutOffTimeInReviewCart.replace("+05:30", "+5:30");
        softAssert.assertEquals(Customer.getOrderCutOffOnReviewCart(),cutOffTimeInReviewCart,"Cutoff time mismatch");

        Customer.submitOrderAfterDeliveryTime();
        softAssert.assertTrue(Customer.isInvalidDeliveryTextDisplayed(),"Delivery time error");
        Customer.closeDeliveryPopup();
        Customer.selectDeliveryDateSecondLine();
        Customer.submitOrder();
        softAssert.assertTrue(Customer.isThankingForOrderPopupDisplayed(),"Error in order submit");
        closeAllBrowsers();


        //clearing the added delivery date and cut off time
        secInitialization();
        user = JsonUtil.readUserLogin();
        Login.loginAsRestaurant(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDisDashboard();
        Dashboard.navigateToCustomers();
        Customer.searchCustomerByCode(customerId);
        Customer.selectCustomer(customerId);
        Customer.editDeliveryDate();
        Customer.clearDeliveryDate(formattedTomorrowDate);
        Customer.saveChangesInCutOffTimeOverlay();


        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException {
        takeScreenshotOnFailure(result);
        closeAllBrowsers();
    }



}
