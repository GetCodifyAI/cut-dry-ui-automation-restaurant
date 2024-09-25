package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//div[text()='Place Order']");
    By btn_placeOrder = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes = By.xpath("//div[contains(text(), 'Hayes')]");
    By txt_OrderGuide = By.xpath("//div[contains(text(), 'Order Guide')]");
    By btn_TestAutomation = By.xpath("//div[contains(text(), 'Test_Automation') and contains(@class, 'w-100')]");
    By txt_draftOrder = By.xpath("//div[contains(@class, 'text-center') and contains(text(), 'continue your previous draft order')]");
    By btn_noDraftOrder = By.xpath("//span[text()='×']");
    By txt_disDashboard = By.xpath("//li[contains(text(),'Dashboard')]");
    By btn_cooksCompanyProduce = By.xpath("//div[contains(text(), 'Cooks Company Produce')]");
    By txt_approvals = By.xpath("//div[contains(text(), 'Approvals')]");
    By btn_Reports = By.xpath("//a[contains(@data-tip, 'Reports')]");


    public boolean isDashboardTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_dashboard);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_dashboard);
    }
    public boolean isApprovalsTabDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_approvals);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_approvals);
    }
    public void clickOnPlaceOrder() {
        restaurantUI.click(btn_placeOrder);}
    public void clickOnHayes() {
        restaurantUI.click(btn_hayes);}
    public boolean isOrderGuideTextDisplayed(){
        return restaurantUI.isDisplayed(txt_OrderGuide);
    }
    public boolean isTestAutomationPopupDisplayed(){
        try {
            return restaurantUI.isDisplayed(btn_TestAutomation);
        } catch (Exception e){
            return false;
        }
    }
    public void clickOnTestAutomationPopup(){
        restaurantUI.waitForClickability(btn_TestAutomation);
        restaurantUI.click(btn_TestAutomation);
        restaurantUI.waitForInvisibility(btn_TestAutomation);
    }
    public boolean isDraftOrderPopUpDisplayed(){
        try {
            return restaurantUI.isDisplayed(txt_draftOrder);
        } catch (Exception e){
            return false;
        }
    }
    public void clickOnNoDraftOrder(){
        restaurantUI.click(btn_noDraftOrder);
    }

    public boolean isDisDashboardTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_disDashboard);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_disDashboard);
    }
    public void clickOnCooksCompanyProduce() {
        restaurantUI.click(btn_cooksCompanyProduce);}

    public void clickOnReports() {
        restaurantUI.click(btn_Reports);}
}
