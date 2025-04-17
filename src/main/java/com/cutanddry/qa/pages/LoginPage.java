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
    //By tbx_operatorSearch = By.xpath("//input[@id='react-select-5-input']");
    By tbx_operatorSearch = By.xpath("//button[contains(text(),'Re-Index')]/following-sibling::*//div/input");
    By txt_joshuaClayton = By.xpath("//div[contains(text(), 'Jonathan Allen - 75761700')]");
    By txt_stephanieCollins = By.xpath("//div[contains(text(), 'Stephanie Collins - 176617582')]");
    By txt_bermudaBiologicalStation= By.xpath("//div[contains(text(), '(explorer) - Bermuda Biological Station -')]");
    By btn_LoginAsClassic = By.xpath("//a[contains(text(), 'Login As (classic)')]");
    By btn_LoginAsWhiteLabel = By.xpath("//a[contains(text(), 'Login As (white-label)')]");
   // By tbx_distributorSearch = By.xpath("//input[@id='react-select-2-input']");
    By tbx_distributorSearch = By.xpath("//h5[contains(text(),'Distributor Portal')]/following-sibling::*//div/input");
    By txt_sunriseFoods = By.xpath("//div[contains(text(), '195998346 - Cut+Dry Agent - Sunrise Food Service Inc')]");
    By btn_LoginAsSupplier = By.xpath("//a[contains(text(), 'Login As (supplier)')]");
    By txt_manager = By.xpath("//div[contains(text(), 'Aselabookkeeper4 - 131583036 - Manager - Restaurant(Test) - asela+bookkeeper4@cutanddry.com - null')]");
    By txt_employee = By.xpath("//div[contains(text(), 'Employee - 274855811 - Employee - Restaurant(Test) - kwu333@gmail.com - null')]");
    String txt_bookkeeper = "(//div[contains(text(), 'BOOKKEEPERNAME')])[last()]";
    String txt_distributor = "(//div[contains(text(), 'DISTRIBUTOR_NAME')])[2]";
    String txt_operator = "((//div[contains(text(), 'OPERATOR_NAME')])[last()])";
    By txt_adminWL = By.xpath("//div[contains(text(), 'Amir IFC WL - 246613671 - Owner - IFC Operator Demo - amir@cutanddry.com - 14082091996')]");
    By txt_bookkeeperWL = By.xpath("//div[contains(text(), 'Brandon IFC White - 170465895 - Owner - IFC Operator Demo - brandon@cutanddry.com - 12345678910')]");
    By txt_employeeWL = By.xpath("//div[contains(text(), 'Hadley Ifc Employee - 274597299 - Employee - IFC Operator Demo - hadley+employee@cutanddry.com - null')]");
    By lbl_activeVV = By.xpath("//tbody/tr[1]/td[3]/ul[2]/li/label/input[@value='active_for_all_vv']");
    By lbl_activeVVChecked = By.xpath("//tbody/tr[1]/td[3]/ul[2]/li/label/input[@value='active_for_all_vv' and @checked]");
    By internalToolsBtn = By.xpath("//a[contains(text(),'Internal Tools') and contains(@href,'/internaltools')]");
    By txt_jenniferBlue = By.xpath("//div[contains(text(), 'Jennifer Blue')]");
    String managerWL = "//div[contains(text(), 'NAME')]";
    By txt_emailOrMobileSaval = By.xpath("//input[@placeholder='Enter your email or mobile number']");
    By txt_passwordSaval = By.xpath("//input[@placeholder='Enter your Password']");
    By btn_signInSaval = By.xpath("//button[@type='submit']");


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
    public void clickOnManager(){
        restaurantUI.click(txt_manager);
    }
    public void clickOnEmployee(){
        restaurantUI.click(txt_employee);
    }
    public void clickOnBookkeeper(String bookKeeper){
        restaurantUI.waitForVisibility(By.xpath(txt_bookkeeper.replace("BOOKKEEPERNAME",bookKeeper)));
        restaurantUI.click(By.xpath(txt_bookkeeper.replace("BOOKKEEPERNAME",bookKeeper)));
    }
    public void clickOnStephanieCollins(){
        restaurantUI.click(txt_stephanieCollins);
    }
    public void clickOnAdminWL(){
        restaurantUI.click(txt_adminWL);
    }
    public void clickOnManagerWL(String name){
        restaurantUI.click(By.xpath(managerWL.replace("NAME",name)));
    }
    public void clickOnEmployeeWL(){
        restaurantUI.click(txt_employeeWL);
    }
    public void clickOnBookkeeperWL(){
        restaurantUI.click(txt_bookkeeperWL);
    }
    public void clickOnLoginAsClassic() throws InterruptedException {
        restaurantUI.click(btn_LoginAsClassic);
//        restaurantUI.closeBrowser();
//        restaurantUI.waitForCustom(4000);
    }

    public void clickOnLoginAsClassicAndSwitchToNewTab() throws InterruptedException {
        restaurantUI.click(btn_LoginAsClassic);
        restaurantUI.switchToNewTab();
        restaurantUI.waitForCustom(3000);
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
    public void clickOnDistributor(String DP_Name){
        restaurantUI.click(By.xpath(txt_distributor.replace("DISTRIBUTOR_NAME",DP_Name)));
    }


    public void clickOnLoginAsSupplier() throws InterruptedException {
        restaurantUI.click(btn_LoginAsSupplier);
//        restaurantUI.closeBrowser();
//        restaurantUI.waitForCustom(4000);
        restaurantUI.switchToNewTab();
    }
    public void navigateToOperator(){
        restaurantUI.openURL(Constants.MAIN_URL);
    }
    public void settingsWLGateKeeper() throws InterruptedException {
        restaurantUI.openURL(Constants.GATE_KEEPER_URL);
        restaurantUI.refreshPage();
        restaurantUI.waitForCustom(1000);
        if (!restaurantUI.isDisplayed(lbl_activeVVChecked)){
            restaurantUI.click(lbl_activeVV);
            restaurantUI.waitForCustom(1000);
        }
    }

    public void clickOperator(String operator){
        restaurantUI.waitForVisibility(By.xpath(txt_operator.replace("OPERATOR_NAME",operator)));
        restaurantUI.click(By.xpath(txt_operator.replace("OPERATOR_NAME",operator)));
    }

    public void clickOnInternalTools(){
        restaurantUI.navigateToURL(Constants.LOGIN_AS_APP_URL);
        restaurantUI.click(internalToolsBtn);
    }
    public void switchIntoNewTab(){
        restaurantUI.switchToNewTab();
    }
    public void closePreviousTab()throws InterruptedException{
        restaurantUI.CloseAllPreviousTabAndSwitchToNew();
    }
    public void navigateSavalFood(){
        restaurantUI.navigateToURL(Constants.SAVAL_FOOD_URL);
    }
    public void typeEmailOrMobileSaval(String emailOrMobile){
        restaurantUI.sendKeys(txt_emailOrMobileSaval,emailOrMobile);
    }
    public void typePasswordSaval(String password){
        restaurantUI.sendKeys(txt_passwordSaval,password);
    }
    public void clickSignInSaval(){
        restaurantUI.click(btn_signInSaval);
    }


}
