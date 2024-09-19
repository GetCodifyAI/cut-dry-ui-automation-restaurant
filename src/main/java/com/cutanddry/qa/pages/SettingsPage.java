package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SettingsPage extends LoginPage{

    By btn_settings = By.xpath("//a[contains(text(), 'Settings')]");
    By btn_orders = By.xpath("(//a[@href='/settings/orders'])[2]");
    By tbx_cutOffTime = By.xpath("//input[@type='time']");
    By btn_saveChanges = By.xpath("//button[text()='Save Changes']");

    public void clickOnSettings(){
        restaurantUI.click(btn_settings);
    }

    public void clickOnOrders(){
        restaurantUI.click(btn_orders);
    }

    public void setTime(String time)throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.sendKeys(tbx_cutOffTime,time);
        restaurantUI.waitForCustom(4000);
    }

    public void clickOnSaveChanges()throws InterruptedException{
        restaurantUI.click(btn_saveChanges);
        restaurantUI.waitForCustom(4000);
    }

}
