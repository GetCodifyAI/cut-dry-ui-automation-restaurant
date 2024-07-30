package com.cutanddry.qa.tests;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.data.models.User;
import com.cutanddry.qa.functions.Customer;
import com.cutanddry.qa.functions.Dashboard;
import com.cutanddry.qa.functions.Login;
import com.cutanddry.qa.utils.JsonUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddProductsFromCatalogTest extends TestBase {
    static User user;


    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public static void loginAsDistributor() {
        String itemName;
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsDistributor(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"error");
        Dashboard.navigateToIndependentFoodsCo();
        softAssert.assertTrue(Dashboard.isUserNavigatedToIndependentPopup(),"error");
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToIndependentPopup(),"error");
        Customer.NavigateToCatalog();
        softAssert.assertTrue(Customer.isUserNavigatedToCatalog(),"error");
//        itemName = Customer.getItemNameFirstRow();
//        Customer.increaseFirstRowQtyByOne();
//        Customer.checkoutItems();
//        softAssert.assertEquals(Customer.getItemNameFirstRow(),itemName,"item mismatch");
//        softAssert.assertAll();

    }

    @AfterMethod
    public void tearDown(){
        closeAllBrowsers();
    }

}
