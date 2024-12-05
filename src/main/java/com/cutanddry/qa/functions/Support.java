package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SupportPage;

public class Support {

    static SupportPage supportPage = new SupportPage();

    public static void goToSupportPage() throws InterruptedException {
        supportPage.clickOnSupport();
    }
    public static boolean supportCenterHeader(){
        return supportPage.isSupportCenterHeaderDisplayed();
    }
}
