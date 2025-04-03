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
    public static void navigateToOrderingSettingsTab(){
        internalToolsPage.clickOnOrderingSettings();
    }
    public static void TurnOnOrderMinimumGloballyToggle(boolean status){
        internalToolsPage.clickTurnOnOrderMinimumGloballyToggle(status);
    }
    public static void clickOnOrderMinimumDropdown(String type){
        internalToolsPage.clickOnOrderMinimumDropdown(type);
    }
    public static void enterOrderMinimum(String min){
        internalToolsPage.enterOrderMinimum(min);
    }
    public static void clickSave(){
        internalToolsPage.clickSaveBtn();
    }
    public static void clickCreditMemoCheckbox(boolean status){
        internalToolsPage.clickCreditMemoCheckbox(status);
    }


}
