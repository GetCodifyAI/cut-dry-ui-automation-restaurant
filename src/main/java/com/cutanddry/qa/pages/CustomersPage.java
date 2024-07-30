package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CustomersPage extends LoginPage {

    By lbl_itemNameList = By.xpath("//td//span/div[@data-tip='View Item Details']");
    By btn_increaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[3]");
    By btn_increaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[3]");
    By btn_checkout = By.xpath("//button[@data-tip='Click here to checkout']");
    By btn_catalog = By.xpath("//button[@data-tip='Click here to checkout']");
    By txt_catalog = By.xpath("//div[text()='All Items']/text()");


    public String getItemNameFirstRow(){
        return driver.findElements(lbl_itemNameList).getFirst().getText();
    }
    public void clickPlusQryFirstRow(){
        driver.findElement(btn_increaseQtyFirstRow).click();
    }
    public String getItemNameSecondRow(){return driver.findElements(lbl_itemNameList).get(1).getText();}
    public void clickPlusQrySecondRow(){driver.findElement(btn_increaseQtySecondRow).click();}
    public void clickOnCheckoutButton(){
        driver.findElement(btn_checkout).click();
    }
    public void clickCatalogButton(){
        driver.findElement(btn_catalog).click();
    }
    public boolean isCatalogTextDisplayed(){
        return driver.findElement(txt_catalog).isDisplayed();
    }}