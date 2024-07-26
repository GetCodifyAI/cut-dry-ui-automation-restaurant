package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CustomersPage extends LoginPage {
    By tbx_searchCustomers = By.xpath("//input[@placeholder='Search Customers']");
    String btnOrderGuide = "//td[text()='CODE']/../td[8]//button";
    By lbl_itemNameList = By.xpath("//td//span/div[@data-tip='View Item Details']");
    By btn_increaseQtyFirstRow = By.xpath("//tr[1]/td[8]/div/div/div/div[3]");
    By btn_increaseQtySecondRow = By.xpath("//tr[2]/td[8]/div/div/div/div[3]");
    By btn_checkout = By.xpath("//button[@data-tip='Click here to checkout']");

    public void clickOnSearchCustomers(){
        driver.findElement(tbx_searchCustomers);
    }
    public void typeOnSearchCustomers(String code){
        driver.findElement(tbx_searchCustomers).sendKeys(code);
    }
    public boolean isCustomerSearchResultByCodeDisplayed(String code){
        return driver.findElement(By.xpath(btnOrderGuide.replace("CODE", code))).isDisplayed();
    }
    public void clickOnOrderGuide(String code) {
        driver.findElement(By.xpath(btnOrderGuide.replace("CODE", code))).click();
    }
    public String getItemNameFirstRow(){
        return driver.findElements(lbl_itemNameList).getFirst().getText();
    }
    public void clickPlusQryFirstRow(){
        driver.findElement(btn_increaseQtyFirstRow).click();
    }
    public String getItemNameSecondRow(){
        return driver.findElements(lbl_itemNameList).get(1).getText();
    }
    public void clickPlusQrySecondRow(){
        driver.findElement(btn_increaseQtySecondRow).click();
    }
    public void clickOnCheckoutButton(){
        driver.findElement(btn_checkout).click();
    }
}
