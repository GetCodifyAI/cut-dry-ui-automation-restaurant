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
    By txt_invalidEmailOrMobile = By.xpath("//div[text()='Password Reset Request Sent!']");
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
    By txt_key = By.xpath("//input[@name='data_key']");
    By txt_value = By.xpath("//input[@name='data_val']");
    By btn_setData = By.xpath("//button[contains(text(), 'Set data')]");


    public void typeEmailOrMobile(String emailOrMobile){
        getRestaurantUI().sendKeys(txt_emailOrMobile,emailOrMobile);
    }
    public void typePassword(String password){
        getRestaurantUI().sendKeys(txt_password,password);
    }
    public void clickSubmit(){
        getRestaurantUI().click(btn_signIn);
    }
    public void clickForgotPassword(){
        getRestaurantUI().click(btn_forgotPassword);
    }
    public boolean isForgotPasswordPopupDisplayed(){
        return getRestaurantUI().isDisplayed(txt_forgotPassword);
    }
    public void enterEmailOrMobile(String emailOrMobile){
        getRestaurantUI().sendKeys(txt_enterEmailOrMobile,emailOrMobile);
    }
    public void clickRequestPassword() {
        getRestaurantUI().waitForClickability(btn_requestPassword);
        getRestaurantUI().click(btn_requestPassword);
    }
    public boolean validEmailOrMobile() {
        return getRestaurantUI().isDisplayed(txt_validEmailOrMobile);
    }
    public boolean invalidEmailOrMobile() {
        return getRestaurantUI().isDisplayed(txt_invalidEmailOrMobile);
    }
    public void clickOk() {
        getRestaurantUI().waitForVisibility(btn_ok);
        getRestaurantUI().click(btn_ok);
    }
    public void clickTryAgain() {
        getRestaurantUI().waitForVisibility(btn_tryAgain);
        getRestaurantUI().click(btn_tryAgain);
    }
    public void navigateToWhiteLabel() {
        getRestaurantUI().navigateToURL(Constants.WHITELABEL_APP_URL);
    }
    public void navigateToLoginAs() {
        getRestaurantUI().navigateToURL(Constants.LOGIN_AS_APP_URL);
    }

    public void typeToSearchOnOperator(String operator) throws InterruptedException {
        getRestaurantUI().waitForVisibility(tbx_operatorSearch);
        getRestaurantUI().sendKeys(tbx_operatorSearch, operator);
        getRestaurantUI().waitForCustom(4000);
    }
    public void clickOnJoshuaClayton(){
        getRestaurantUI().click(txt_joshuaClayton);
    }
    public void clickOnManager(){
        getRestaurantUI().click(txt_manager);
    }
    public void clickOnEmployee(){
        getRestaurantUI().click(txt_employee);
    }
    public void clickOnBookkeeper(String bookKeeper){
        getRestaurantUI().waitForVisibility(By.xpath(txt_bookkeeper.replace("BOOKKEEPERNAME",bookKeeper)));
        getRestaurantUI().click(By.xpath(txt_bookkeeper.replace("BOOKKEEPERNAME",bookKeeper)));
    }
    public void clickOnStephanieCollins(){
        getRestaurantUI().click(txt_stephanieCollins);
    }
    public void clickOnAdminWL(){
        getRestaurantUI().click(txt_adminWL);
    }
    public void clickOnManagerWL(String name){
        getRestaurantUI().click(By.xpath(managerWL.replace("NAME",name)));
    }
    public void clickOnEmployeeWL(){
        getRestaurantUI().click(txt_employeeWL);
    }
    public void clickOnBookkeeperWL(){
        getRestaurantUI().click(txt_bookkeeperWL);
    }
    public void clickOnLoginAsClassic() throws InterruptedException {
        getRestaurantUI().click(btn_LoginAsClassic);
//        getRestaurantUI().closeBrowser();
//        getRestaurantUI().waitForCustom(4000);
    }

    public void clickOnLoginAsClassicAndSwitchToNewTab() throws InterruptedException {
        getRestaurantUI().click(btn_LoginAsClassic);
        getRestaurantUI().switchToNewTab();
        getRestaurantUI().waitForCustom(3000);
    }

    public void clickOnLoginAsWhiteLabel() throws InterruptedException {
        getRestaurantUI().click(btn_LoginAsWhiteLabel);
//        getRestaurantUI().closeBrowser();
//        getRestaurantUI().waitForCustom(4000);
    }
    public void clickOnBermudaBiologicalStation(){
        getRestaurantUI().click(txt_bermudaBiologicalStation);
    }

    public void typeToSearchOnDistributor(String operator) throws InterruptedException {
        getRestaurantUI().click(tbx_distributorSearch);
        getRestaurantUI().sendKeys(tbx_distributorSearch, operator);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickOnSunriseFood(){
        getRestaurantUI().click(txt_sunriseFoods);
    }
    public void clickOnDistributor(String DP_Name){
        getRestaurantUI().click(By.xpath(txt_distributor.replace("DISTRIBUTOR_NAME",DP_Name)));
    }


    public void clickOnLoginAsSupplier() throws InterruptedException {
        getRestaurantUI().click(btn_LoginAsSupplier);
//        getRestaurantUI().closeBrowser();
//        getRestaurantUI().waitForCustom(4000);
        getRestaurantUI().switchToNewTab();
    }
    public void navigateToOperator(){
        getRestaurantUI().openURL(Constants.MAIN_URL);
    }
    public void settingsWLGateKeeper() throws InterruptedException {
        getRestaurantUI().openURL(Constants.GATE_KEEPER_URL);
        getRestaurantUI().refreshPage();
        getRestaurantUI().waitForVisibility(lbl_activeVVChecked);
        if (!getRestaurantUI().isDisplayed(lbl_activeVVChecked)){
            getRestaurantUI().click(lbl_activeVV);
            getRestaurantUI().waitForCustom(1000);
        }
    }

    public void clickOperator(String operator){
        getRestaurantUI().waitForVisibility(By.xpath(txt_operator.replace("OPERATOR_NAME",operator)));
        getRestaurantUI().click(By.xpath(txt_operator.replace("OPERATOR_NAME",operator)));
    }

    public void clickOnInternalTools(){
        getRestaurantUI().navigateToURL(Constants.LOGIN_AS_APP_URL);
        getRestaurantUI().click(internalToolsBtn);
    }
    public void switchIntoNewTab(){
        getRestaurantUI().switchToNewTab();
    }
    public void closePreviousTab()throws InterruptedException{
        getRestaurantUI().CloseAllPreviousTabAndSwitchToNew();
    }
    public void navigateSavalFood(){
        getRestaurantUI().navigateToURL(Constants.SAVAL_FOOD_URL);
    }
    public void typeEmailOrMobileSaval(String emailOrMobile){
        getRestaurantUI().sendKeys(txt_emailOrMobileSaval,emailOrMobile);
    }
    public void typePasswordSaval(String password){
        getRestaurantUI().sendKeys(txt_passwordSaval,password);
    }
    public void clickSignInSaval(){
        getRestaurantUI().click(btn_signInSaval);
    }
    public void refreshThePage(){
        getRestaurantUI().refreshPage();
    }
    public void clickOnLoginAsWhiteLabelAndSwitchToNewTab() throws InterruptedException {
        getRestaurantUI().click(btn_LoginAsWhiteLabel);
        getRestaurantUI().switchToNewTab();
        getRestaurantUI().waitForCustom(3000);
    }
    public void  openNewTabAndSwitchIt(){
        getRestaurantUI().OpenNewTabAndSwitchToIt();
    }
    public void closeNewTabAndSwitchBack(){
        getRestaurantUI().CloseNewTabAndSwitchToOriginal();
    }
    public void navigateToNode(String Node){
        getRestaurantUI().navigateToURL(Constants.NODE_EXPLORER+ "/node/" + Node);
    }
    public void setValueToNode(String keyName, String valueName) throws InterruptedException {
        getRestaurantUI().sendKeys(txt_key,keyName);
        getRestaurantUI().sendKeys(txt_value,valueName);
        getRestaurantUI().click(btn_setData);
        getRestaurantUI().waitForCustom(2000);
    }


}
