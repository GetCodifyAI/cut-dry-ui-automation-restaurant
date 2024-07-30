package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//div[text()='Place Order']");
    By btn_placeOrder = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes = By.xpath("//div[contains(text(), 'Hayes')]");
    By img_independentFoodsCo = By.xpath("//img[@src='https://ordering-supplies-images-1.s3.us-east-2.amazonaws.com/968096f7ee7424c74a7860a7611e8bbf.jpg']\n");


    public boolean isDashboardTextDisplayed(){
        return driver.findElement(txt_dashboard).isDisplayed();
    }
    public void clickOnPlaceOrder() {driver.findElement(btn_placeOrder).click();}
    public void clickOnHayes() {driver.findElement(btn_hayes).click();}
    public boolean isIndependentPopupDisplayed(){
        return driver.findElement(img_independentFoodsCo).isDisplayed();
    }
}
