package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

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
    By btn_approvals = By.xpath("//a[contains(@data-tip, 'Approvals')]");
    By btn_drafts = By.xpath("//a[contains(@data-tip, 'View Drafts')]");
    By btn_chats = By.xpath("//a[contains(@data-tip, 'Supplier Chat')]");
    By btn_pay = By.xpath("//a[contains(@data-tip, 'View Invoices')]");
    By txt_drafts = By.xpath("//div[contains(text(), 'Drafts')]");
    By txt_chats = By.xpath("//li[contains(text(), 'Your Suppliers')]");
    By txt_pay = By.xpath("//h2[contains(text(), 'Pay Suppliers')]");
    By btn_customers = By.xpath("//a[@data-tip='Customers']");
    String supplierTxt = "//tr[@class='_du1frc _14u3xd3 py-3']//div[text()='SUPPLIERNAME']";
    By MaxiesSLTxt = By.xpath("//div[@class='_hp19hv mx-3 aling-items-center d-flex']//span[@data-tip='Maxies SL']//div[text()='Maxies SL']");
    By users = By.xpath("//div[contains(text(),'Users')]");

    public boolean isDashboardTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_dashboard);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_dashboard);
    }
    public boolean isChatTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_chats);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_chats);
    }
    public boolean isDraftsTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_drafts);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_drafts);
    }
    public boolean isUsersTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_chats);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_chats);
    }
    public boolean isPayTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_pay);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_pay);
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

    public void clickOnDrafts() {
        restaurantUI.click(btn_drafts);}
    public void clickOnChats() {
        restaurantUI.click(btn_chats);}
    public void clickOnReports() {
        restaurantUI.click(btn_Reports);}
    public void clickOnPay() {
        restaurantUI.click(btn_pay);}
    public void clickOnApprovals() {
        restaurantUI.click(btn_approvals);}
    public void clickOnCustomers(){
        restaurantUI.click(btn_customers);
    }

    public void clickOnSupplier(String supplierName){
        restaurantUI.waitForVisibility(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
        restaurantUI.click(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
    }

    public boolean isNavigatedToMaxiesSLOrderGuide() throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(MaxiesSLTxt);
    }

    public void clickOnUsers(){
        restaurantUI.click(users);
    }

}
