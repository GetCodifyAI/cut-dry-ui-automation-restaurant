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

}
