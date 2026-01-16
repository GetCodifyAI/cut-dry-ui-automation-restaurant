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

    public static void enableReportIssueOptionToggle(boolean status){
        internalToolsPage.enableReportIssueOptionToggle(status);
    }
    public static void disableHideCheckInOptionToggle(boolean status){
        internalToolsPage.disableHideCheckInOptionToggle(status);
    }
    public static boolean isSuccessPopUpDisplayed(){
        return internalToolsPage.isSuccessPopUpDisplayed();
    }
    public static void clickPayEnabledToggle(boolean status){
        internalToolsPage.clickPayEnabledToggle(status);
    }
    public static void addCustomerToPayDisable(String name) throws InterruptedException {
        internalToolsPage.addCustomerToPayDisable(name);
    }
    public static void enableWillCallPickUpToggle(boolean status){
        internalToolsPage.enableWillCallPickUpToggle(status);
    }

    public static void enableDisableToggle(String ToggleName, boolean enableStatus){
        internalToolsPage.enableDisableToggle(ToggleName,enableStatus);
    }
    public static void clickChatCheckbox(boolean status){
        internalToolsPage.clickChatCheckbox(status);
    }
    public static void clickSaveChanges() throws InterruptedException {
        internalToolsPage.clickSaveChanges();
    }
    public static void displayPurchaseHistoryToggle(boolean status){
        internalToolsPage.displayPurchaseHistoryToggle(status);
    }
    public static void displayPurchasePriceOnOperatorToggle(boolean status){
        internalToolsPage.displayPurchasePriceOnOperatorToggle(status);
    }
    public static void clickEnableFTNIPaymentGatewayCheckbox(boolean status)throws InterruptedException{
        internalToolsPage.clickEnableFTNIPaymentGatewayCheckbox(status);
    }
    public static void clickHideZeroStockLabelToggle(boolean status){
        internalToolsPage.clickHideZeroStockLabelToggle(status);
    }
    public static void clickOnSimpleListViewDropdown(String type){
        internalToolsPage.clickOnSimpleListViewDropdown(type);
    }
    public static void clickOnQuickAddViewDropDown(String type){
        internalToolsPage.clickOnQuickAddViewDropDown(type);
    }
    public static void caseMinimumGloballyToggle(boolean status){
        internalToolsPage.caseMinimumGloballyToggle(status);
    }

    public static void enableDefaultViewPortalAsSimpleList() throws InterruptedException {
        if (!internalToolsPage.isDefaultViewPortalAsSimpleListDisplayed()) {
            internalToolsPage.clickOnDefaultViewPortalAsSimpleList();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableDefaultViewPortalAsQuickAdd() throws InterruptedException {
        if (!internalToolsPage.isDefaultViewPortalAsQuickAddDisplayed()) {
            internalToolsPage.clickOnDefaultViewPortalAsQuickAdd();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableDefaultViewPortalAsOrderGuide() throws InterruptedException {
        if (!internalToolsPage.isDefaultViewPortalAsOrderGuideDisplayed()) {
            internalToolsPage.clickOnDefaultViewPortalAsOrderGuide();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableDefaultViewPortalAsCatalog() throws InterruptedException {
        if (!internalToolsPage.isDefaultViewPortalAsCatalogDisplayed()) {
            internalToolsPage.clickOnDefaultViewPortalAsCatalog();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableDefaultViewPortalAsScanToOrder() throws InterruptedException {
        if (!internalToolsPage.isDefaultViewPortalAsScanToOrderDisplayed()) {
            internalToolsPage.clickOnDefaultViewPortalAsScanToOrder();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableQuickAdd() throws InterruptedException {
        if (!internalToolsPage.isDefaultQuickAddDisplayed()) {
            internalToolsPage.clickOnDefaultQuickAdd();
            internalToolsPage.clickSaveBtn();
        }
    }

    public static void enableSimpleList() throws InterruptedException {
        if (!internalToolsPage.isDefaultSimpleListDisplayed()) {
            internalToolsPage.clickOnDefaultSimpleList();
            internalToolsPage.clickSaveBtn();
        }
    }
    public static void manualOrderQuantityCalculationToggle(boolean status){
        internalToolsPage.manualOrderQuantityCalculationToggle(status);
    }
    public static void enterOrderMinimumAmount(String min){
        internalToolsPage.enterOrderMinimumAmount(min);
    }
    public static void TurnOnAllowSupplierToSetMinimumToggle(boolean status){
        internalToolsPage.TurnOnAllowSupplierToSetMinimumToggle(status);
    }

}
