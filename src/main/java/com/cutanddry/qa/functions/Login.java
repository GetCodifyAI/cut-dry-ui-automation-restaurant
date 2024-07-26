package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.LoginPage;

public class Login {

    static LoginPage loginPage = new LoginPage();

    public static void loginAsDistributor(String emailOrMobile, String password){
        loginPage.typeEmailOrMobile(emailOrMobile);
        loginPage.typePassword(password);
        loginPage.clickSubmit();
    }
}
