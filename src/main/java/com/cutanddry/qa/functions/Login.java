package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.LoginPage;

public class Login {

    static LoginPage loginPage = new LoginPage();

    public static void loginAsRestaurant(String emailOrMobile, String password){
        loginPage.typeEmailOrMobile(emailOrMobile);
        loginPage.typePassword(password);
        loginPage.clickSubmit();
    }
    public static boolean forgotPassword(){
        loginPage.clickForgotPassword();
        return loginPage.isForgotPasswordPopupDisplayed();
    }
    public static void passwordResetRequest(String emailOrMobile){
        loginPage.enterEmailOrMobile(emailOrMobile);
        loginPage.clickRequestPassword();
    }
    public static boolean validEmailOrMobileForgotPassword(){
        return loginPage.validEmailOrMobile();
    }
    public static boolean invalidEmailOrMobileForgotPassword(){
        return loginPage.invalidEmailOrMobile();
    }
    public static void clickOk(){
        loginPage.clickOk();
    }
    public static void clickTryAgain(){
        loginPage.clickTryAgain();
    }
    public static void navigateToWhiteLabel() {
        loginPage.navigateToWhiteLabel();
    }
    public static void navigateToLoginAs() {
        loginPage.navigateToLoginAs();
    }
    public static void goToOperatorJoshuaClayton(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnJoshuaClayton();
        loginPage.clickOnLoginAsClassic();
    }
    public static void goToOperatorStephanieCollins(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnStephanieCollins();
        loginPage.clickOnLoginAsWhiteLabel();
    }
    public static void goToOperatorBermudaBiologicalStation(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnBermudaBiologicalStation();
        loginPage.clickOnLoginAsWhiteLabel();
    }

    public static void goToDistributorSunriseFood(String distributor) throws InterruptedException {
        loginPage.typeToSearchOnDistributor(distributor);
        loginPage.clickOnSunriseFood();
        loginPage.clickOnLoginAsSupplier();
    }
    public static void navigateToOperator(){
        loginPage.navigateToOperator();
    }
    public static void loginAsManager(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnManager();
        loginPage.clickOnLoginAsClassic();
    }
    public static void loginAsEmployee(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnEmployee();
        loginPage.clickOnLoginAsClassic();
    }
    public static void loginAsBookkeeper(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnBookkeeper(operator);
        loginPage.clickOnLoginAsClassic();
    }
    public static void goToDistributor(String distributor) throws InterruptedException {
        loginPage.typeToSearchOnDistributor(distributor);
        loginPage.clickOnDistributor(distributor);
        loginPage.clickOnLoginAsSupplier();
    }
    public static void loginAsAdminWL(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnAdminWL();
        loginPage.clickOnLoginAsWhiteLabel();
    }
    public static void loginAsManagerWL(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnManagerWL();
        loginPage.clickOnLoginAsWhiteLabel();
    }
    public static void loginAsEmployeeWL(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnEmployeeWL();
        loginPage.clickOnLoginAsWhiteLabel();
    }
    public static void loginAsBookkeeperWL(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOnBookkeeperWL();
        loginPage.clickOnLoginAsWhiteLabel();
    }
    public static void settingsWLGateKeeper() throws InterruptedException {
        loginPage.settingsWLGateKeeper();
    }

    public static void logInToOperator(String operator) throws InterruptedException {
        loginPage.typeToSearchOnOperator(operator);
        loginPage.clickOperator(operator);
        loginPage.clickOnLoginAsClassicAndSwitchToNewTab();
    }

    public static void navigateToInternalTools(){
        loginPage.clickOnInternalTools();
    }

}
