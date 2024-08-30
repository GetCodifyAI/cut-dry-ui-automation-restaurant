package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    By txt_emailOrMobile = By.xpath("//input[@placeholder='Email or mobile']");
    By txt_password = By.xpath("//input[@placeholder='Password']");
    By btn_signIn = By.xpath("//button[@type='submit']");
    By btn_forgotPassword = By.xpath("//div[text()='Forgot Password?']");
    By txt_forgotPassword = By.xpath("//div[text()='Forgot Password']");
    By btn_requestPassword = By.xpath("//button[text()='Request Password']");
    By txt_enterEmailOrMobile = By.xpath("//input[@placeholder='Enter email or phone number']");
    By txt_validEmailOrMobile = By.xpath("//div[text()='Password Reset Request Sent!']");
    By txt_invalidEmailOrMobile = By.xpath("//div[text()='Error']");
    By btn_ok = By.xpath("//button[text()='Ok']");
    By btn_tryAgain = By.xpath("//button[text()='Try Again']");

    public void typeEmailOrMobile(String emailOrMobile){
        restaurantUI.sendKeys(txt_emailOrMobile,emailOrMobile);
    }
    public void typePassword(String password){
        restaurantUI.sendKeys(txt_password,password);
    }
    public void clickSubmit(){
        restaurantUI.click(btn_signIn);
    }
    public void clickForgotPassword(){
        restaurantUI.click(btn_forgotPassword);
    }
    public boolean isForgotPasswordPopupDisplayed(){
        return restaurantUI.isDisplayed(txt_forgotPassword);
    }
    public void enterEmailOrMobile(String emailOrMobile){
        restaurantUI.sendKeys(txt_enterEmailOrMobile,emailOrMobile);
    }
    public void clickRequestPassword() {
        restaurantUI.waitForClickability(btn_requestPassword);
        restaurantUI.click(btn_requestPassword);
    }
    public boolean validEmailOrMobile() {
        return restaurantUI.isDisplayed(txt_validEmailOrMobile);
    }
    public boolean invalidEmailOrMobile() {
        return restaurantUI.isDisplayed(txt_invalidEmailOrMobile);
    }
    public void clickOk() {
        restaurantUI.waitForVisibility(btn_ok);
        restaurantUI.click(btn_ok);
    }
    public void clickTryAgain() {
        restaurantUI.waitForVisibility(btn_tryAgain);
        restaurantUI.click(btn_tryAgain);
    }
}
