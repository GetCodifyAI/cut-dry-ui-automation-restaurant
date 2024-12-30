package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.InternalToolsPage;

public class InternalTools {
    static InternalToolsPage internalToolsPage =  new InternalToolsPage();

    public static void navigateToConfigureSupplier(){
        internalToolsPage.clickConfigureSuppliers();
    }

    public static void navigateToEditDetails(String Distributor){
        internalToolsPage.clickEditDetails(Distributor);
    }

    public static void navigateToPayDetails(){
        internalToolsPage.clickOnPayDetailsSection();
    }

    public static void uncheckFromInternalTools(String Configuration){
        internalToolsPage.clickUncheckFromInternalTools(Configuration);
    }

    public static void saveConfig(){
        internalToolsPage.clickSave();
    }

    public static boolean isSuccessfulOverlayDisplayed(){
        return internalToolsPage.isSuccessOverlayDisplayed();
    }

    public static void clickOkOnSuccessBtn(){
        internalToolsPage.clickOK();
    }


}
