package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.common.Constants;
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
    By tbx_operatorSearch = By.xpath("//input[@id='react-select-5-input']");
    By txt_joshuaClayton = By.xpath("//div[contains(text(), 'Jonathan Allen - 75761700')]");
    By txt_stephanieCollins = By.xpath("//div[contains(text(), 'Stephanie Collins - 176617582')]");
    By txt_bermudaBiologicalStation= By.xpath("//div[contains(text(), '(explorer) - Bermuda Biological Station - 196795960')]");
    By btn_LoginAsClassic = By.xpath("//a[contains(text(), 'Login As (classic)')]");
    By btn_LoginAsWhiteLabel = By.xpath("//a[contains(text(), 'Login As (white-label)')]");
    By tbx_distributorSearch = By.xpath("//input[@id='react-select-2-input']");
    By txt_sunriseFoods = By.xpath("//div[contains(text(), '195998346 - Cut+Dry Agent - Sunrise Food Service Inc')]");
    By btn_LoginAsSupplier = By.xpath("//a[contains(text(), 'Login As (supplier)')]");





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
    public void navigateToWhiteLabel() {
        restaurantUI.navigateToURL(Constants.WHITELABEL_APP_URL);
    }
    public void navigateToLoginAs() {
        restaurantUI.navigateToURL(Constants.LOGIN_AS_APP_URL);
    }

    public void typeToSearchOnOperator(String operator) throws InterruptedException {
        restaurantUI.sendKeys(tbx_operatorSearch, operator);
        restaurantUI.waitForCustom(4000);
    }
    public void clickOnJoshuaClayton(){
        restaurantUI.click(txt_joshuaClayton);
    }

    public void clickOnStephanieCollins(){
        restaurantUI.click(txt_stephanieCollins);
    }

    public void clickOnLoginAsClassic() throws InterruptedException {
        restaurantUI.click(btn_LoginAsClassic);
//        restaurantUI.closeBrowser();
//        restaurantUI.waitForCustom(4000);
    }

    public void clickOnLoginAsWhiteLabel() throws InterruptedException {
        restaurantUI.click(btn_LoginAsWhiteLabel);
//        restaurantUI.closeBrowser();
//        restaurantUI.waitForCustom(4000);
    }
    public void clickOnBermudaBiologicalStation(){
        restaurantUI.click(txt_bermudaBiologicalStation);
    }

    public void typeToSearchOnDistributor(String operator) throws InterruptedException {
        restaurantUI.click(tbx_distributorSearch);
        restaurantUI.sendKeys(tbx_distributorSearch, operator);
        restaurantUI.waitForCustom(4000);
    }

    public void clickOnSunriseFood(){
        restaurantUI.click(txt_sunriseFoods);
    }

    public void clickOnLoginAsSupplier() throws InterruptedException {
        restaurantUI.click(btn_LoginAsSupplier);
//        restaurantUI.closeBrowser();
//        restaurantUI.waitForCustom(4000);
    }
}
