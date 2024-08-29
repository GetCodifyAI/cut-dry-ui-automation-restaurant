package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SupportPage;

public class Support {

    static SupportPage supportPage = new SupportPage();

    public static void goToSupportPage(){
        supportPage.clickIcon();
    }
    public static boolean supportCenterHeader(){
        return supportPage.isSupportCenterHeaderDisplayed();
    }
}
