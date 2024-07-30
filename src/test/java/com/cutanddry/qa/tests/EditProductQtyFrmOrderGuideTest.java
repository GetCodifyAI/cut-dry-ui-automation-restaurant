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

import java.util.Optional;

public class EditProductQtyFrmOrderGuideTest extends TestBase {
    static User user;

    @BeforeMethod
    public void setUp(){
        initialization();
        user = JsonUtil.readUserLogin();
    }

    @Test
    public static void editProductQtyFrmOrderGuide() {
        SoftAssert softAssert = new SoftAssert();
        Login.loginAsDistributor(user.getEmailOrMobile(), user.getPassword());
        Dashboard.isUserNavigatedToDashboard();
        softAssert.assertTrue(Dashboard.isUserNavigatedToDashboard(),"login error");
        Dashboard.navigateToIndependentFoodsCo();
        Dashboard.navigateToOrderGuide();
        softAssert.assertTrue(Dashboard.isUserNavigatedToIndependentPopup(),"navigation error");
        Customer.increaseFirstRowQtyByThree();
        softAssert.assertEquals(Customer.getItemQtyFirstRow(),"3");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*3, "price error");
        Customer.decreaseFirstRowQtyByThree();
        softAssert.assertEquals(Customer.getItemQtyFirstRow(),"0");
        softAssert.assertEquals(Customer.getItemPriceOnCheckoutButton(),Customer.getItemPriceFirstRow()*0, "price error");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        closeAllBrowsers();
    }

}
