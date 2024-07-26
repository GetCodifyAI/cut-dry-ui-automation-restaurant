package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    By txt_emailOrMobile = By.xpath("//input[@placeholder='Email or mobile']");
    By txt_password = By.xpath("//input[@placeholder='Password']");
    By btn_signIn = By.xpath("//button[@type='submit']");

    public void typeEmailOrMobile(String emailOrMobile){
        driver.findElement(txt_emailOrMobile).sendKeys(emailOrMobile);
    }
    public void typePassword(String password){
        driver.findElement(txt_password).sendKeys(password);
    }
    public void clickSubmit(){
        driver.findElement(btn_signIn).click();
    }

}
