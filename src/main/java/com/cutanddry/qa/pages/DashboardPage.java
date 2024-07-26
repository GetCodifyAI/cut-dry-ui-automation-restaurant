package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//h3[text()='Dashboard']");
    By btn_customers = By.xpath("//a[@data-tip='Customers']");


    public boolean isDashboardTextDisplayed(){
        return driver.findElement(txt_dashboard).isDisplayed();
    }
    public void clickOnCustomers(){
        driver.findElement(btn_customers).click();
    }
}
