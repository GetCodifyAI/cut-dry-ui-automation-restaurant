package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//div[text()='Place Order']");
    By btn_placeOrder = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes = By.xpath("//div[contains(text(), 'Hayes')]");
    By txt_OrderGuide = By.xpath("//div[contains(text(), 'Order Guide')]");
    By btn_TestAutomation = By.xpath("//div[contains(text(), 'Test_Automation') and contains(@class, 'w-100')]");


    public boolean isDashboardTextDisplayed(){
        return driver.findElement(txt_dashboard).isDisplayed();
    }
    public void clickOnPlaceOrder() {driver.findElement(btn_placeOrder).click();}
    public void clickOnHayes() {driver.findElement(btn_hayes).click();}
    public boolean isOrderGuideTextDisplayed(){
        return driver.findElement(txt_OrderGuide).isDisplayed();
    }
    public boolean isTestAutomationPopupDisplayed(){
        try {
            return driver.findElement(btn_TestAutomation).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
    public void clickOnTestAutomationPopup(){
        wait.until(ExpectedConditions.elementToBeClickable(btn_TestAutomation));
        driver.findElement(btn_TestAutomation).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(btn_TestAutomation)));
    }
}
