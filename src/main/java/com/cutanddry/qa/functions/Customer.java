package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CustomersPage;
import com.cutanddry.qa.pages.DashboardPage;
import lombok.SneakyThrows;


public class Customer {
    static CustomersPage customersPage = new CustomersPage();
    static DashboardPage dashboardPage = new DashboardPage();
    public static void increaseFirstRowQtyByOne() throws InterruptedException {
        customersPage.clickPlusQryFirstRow();
    }
    public static void increaseSecondRowQtyByOne() throws InterruptedException {customersPage.clickPlusQrySecondRow();}
    public static void decreaseFirstRowQtyByOne() throws InterruptedException {
        customersPage.clickMinusQryFirstRow();
    }
    public static void decreaseSecondRowQtyByOne() throws InterruptedException {
        customersPage.clickMinusQrySecondRow();
    }
    public static void increaseFirstRowQtyByThree() throws InterruptedException {
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
    }
    public static void decreaseFirstRowQtyByThree() throws InterruptedException {
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
    }
    @SneakyThrows
    public static void increaseCatalogQtyByThree(){
        customersPage.clickPlusCatalog();
        customersPage.clickPlusCatalog();
        Thread.sleep(4000);

    }
    @SneakyThrows
    public static void decreaseCatalogQtyByThree(){
        customersPage.clickMinusCatalog();
        customersPage.clickMinusCatalog();
        customersPage.clickMinusCatalog();
        Thread.sleep(4000);

    }

    public static void increaseReviewCartQtyByThree(){
        customersPage.clickPlusReviewCart();
        customersPage.clickPlusReviewCart();
    }
    public static void decreaseReviewCartQtyByThree(){
        customersPage.clickMinusReviewCart();
        customersPage.clickMinusReviewCart();
        customersPage.clickMinusReviewCart();
    }

    public static String getItemNameFirstRow(){
        return customersPage.getItemNameFirstRow();
    }
    public static String getItemNameSecondRow(){return customersPage.getItemNameSecondRow();}
    @SneakyThrows
    public static void checkoutItems(){
        customersPage.clickOnCheckoutButton();
        Thread.sleep(4000);
    }
    public static boolean isUserNavigatedToCatalog(){return customersPage.isCatalogTextDisplayed();}

    public static void goToCatalog(){
        customersPage.clickOnCatalogButton();
    }
    @SneakyThrows
    public static void searchItemOnCatalog(String item){
        customersPage.typeToSearchOnCatalog(item);
        Thread.sleep(4000);
    }
    public static void searchItemOnOrderGuide(String item) throws InterruptedException {
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
        customersPage.typeToSearchOnOrderGuide(item);
    }
    public static String getFirstElementFrmSearchResults(){return customersPage.getFirstItemNameFrmSearchResults();}
    public static void addItemToCartCatalog()throws InterruptedException {
        customersPage.clickAddToCartCatalog();
    }
    public static Double getItemPriceCatalogSearch(){return customersPage.getItemPriceCatalogSearch();}
    public static String getItemQtyFirstRow(){
        return customersPage.getItemQtyFirstRow();
    }
    public static String getItemQtyCatalog(){
        return customersPage.getItemQtyCatalog();
    }
    public static double getItemPriceFirstRow(){
        return customersPage.getItemPriceFirstRow();
    }
    public static double getItemPriceOnCheckoutButton(){
        return customersPage.getItemPriceOnCheckoutButton();
    }
    public static boolean isAddToCartTextDisplayed(){return customersPage.isAddToCartTextDisplayed();}
    public static double getItemPriceReviewCart(){return customersPage.getItemPriceReviewCart();}
    public static String getItemQtyReviewCart(){
        return customersPage.getItemQtyReviewCart();
    }
    public static double getItemPriceReviewCartFirstRow(){
        return customersPage.getItemPriceReviewCartFirstRow();
    }
    public static void submitOrder(){customersPage.submitOrder();if (customersPage.isDuplicatePopupDisplayed()){customersPage.clickYesDuplicatePopup();}}
    public static boolean isThankingForOrderPopupDisplayed(){return customersPage.isThankingForOrderPopupDisplayed();}
    public static void clickCompanyDropdown(){
        customersPage.clickCompanyDropdown();
    }
    public static boolean isCompanyDropdownTextDisplayed(){return customersPage.isCompanyDropdownTextDisplayed();}
    public static void clickOnPrint(){
        customersPage.clickOnPrint();
    }
    public static void printOrderGuide(){
        customersPage.clickOnDownloadOrderGuide();
    }
    public static boolean isPrintFriendlyPopupDisplayed(){return customersPage.isPrintFriendlyPopupDisplayed();}
    public static void goToEdit(){
        customersPage.clickOnEdit();
    }
    public static boolean isEditOrderGuideTextDisplayed(){return customersPage.isEditOrderGuideTextDisplayed();}
    public static void expandMoreOptionsDropdown(){
        customersPage.clickOnMoreOptions();
    }
    public static void exportOrderGuide(){
        customersPage.clickOnExportOrderGuide();
    }
    public static void importOrderGuide(){
        customersPage.clickOnImportOrderGuide();
    }
    public static void uploadToOrder(){
        customersPage.clickOnUploadToOrder();
    }
    public static void goToCreatePopup(){
        customersPage.clickOnCreate();
    }
    public static void createOrderGuide(String orderGuideName){
        customersPage.typeOrderGuideName(orderGuideName);
        customersPage.clickSubmitOrderGuide();
    }
    public static void createOrderFromCatalog(){
        customersPage.clickOnAddFromCatalog();
    }
    public static void addItemFromCatalog(){
        customersPage.clickOnAddTOOrderGuide();
    }
    public static void closeEditor(){
        customersPage.clickOnCloseEditor();
        if (dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }
    public static void removeItemFromCatalog()throws InterruptedException{
        customersPage.clickOnRemoveFromOrderGuide();
    }

    public static void sortByItemCategory() throws InterruptedException {
        customersPage.clickDropDownCustomerOrder();
        customersPage.selectDropDownItemCategory();
    }
    public static void sortByAlphabet() throws InterruptedException {
        customersPage.clickDropDownItemCategory();
        customersPage.selectDropDownAlphabetical();
    }
    public static void sortByCustomOrder() throws InterruptedException {
        customersPage.clickDropDownAlphabetical();
        customersPage.selectDropDownCustomerOrder();
    }
    public static boolean isSeaFoodTextDisplayed(){return customersPage.isSeaFoodTextDisplayed();}
    public static void clickOnUploadFile(){
        customersPage.clickOnUploadFile();
    }

    public static void clickOnNext(){
        customersPage.clickOnNext();
    }
    public static void clickOnConfirm(){
        customersPage.clickOnConfirm();
    }
    public static boolean isOrderGuideSuccessfulTextDisplayed(){return customersPage.isOrderGuideSuccessfulTextDisplayed();}
    public static boolean isSubstitutionTextDisplayed(){return customersPage.isSubstitutionTextDisplayed();}
    public static void uploadFile(String path) {
        customersPage.fileUpload(path);
    }
    public static boolean isInvalidDeliveryTextDisplayed(){return customersPage.isInvalidDeliveryTextDisplayed();}
    public static void closeDeliveryPopup()throws InterruptedException{
        customersPage.clickOnClose();
    }

    @SneakyThrows
    public static void submitOrderAfterDeliveryTime(){
        Thread.sleep(240000);
        customersPage.submitOrder();
    }

    public static void selectDeliveryDateFirstLine()throws InterruptedException{
        customersPage.clickOnDeliveryDate();
        customersPage.selectDeliveryDateFirstLine();

    }
    public static void selectDeliveryDateSecondLine() throws InterruptedException {
        customersPage.clickOnDeliveryDate();
        customersPage.selectDeliveryDateSecondLine();
    }

    public static void orderGuideSettings(){
        customersPage.clickOnOrderGuideSettings();
    }

    public static void saveOrderApproval() throws InterruptedException {
        customersPage.clickOnOrderApproval();
        customersPage.clickOnSave();
    }

    public static void clickOnPlaceOrder() {
        customersPage.clickOnPlaceOrder();
    }

    public static void increaseFirstRowQtyByOneInWL() throws InterruptedException {
        customersPage.clickPlusQryFirstRowInWL();
    }

    public static boolean isMultiDistCentersDisplayed(){
        return customersPage.isMultiDistCentersDisplayed();
    }
    public static int getOrderCount(int num){
        return customersPage.getOrderCount(num);
    }
    public static String getItemNameFirstRowWL() throws InterruptedException {
        return customersPage.getItemNameFirstRowWL();
    }
    public static void searchCustomerByCode(String code) throws InterruptedException {
        customersPage.clickOnSearchCustomers();
        customersPage.typeOnSearchCustomers(code);
    }
    public static void clickOnOrderGuide(String code) throws InterruptedException {
        customersPage.clickOnOrderGuide(code);
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
    }
    public static void increaseFirstRowQtyCustomDis(int count) throws InterruptedException {
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
        for (int i=0; i<count;i++){
            customersPage.clickPlusQryFirstRowDis();
        }
    }
    public static void clickOnPickup() throws InterruptedException {
        customersPage.clickOnPickUp();
    }
    public static boolean isPickUpTextDisplayed(){
        return customersPage.isPickupTextDisplayed();
    }
    public static boolean isOrderCutOffDisplayed(){
        return customersPage.isOrderCutOffDisplayed();
    }
    public static boolean isSubmittingErrorDisplayed(){
        return customersPage.isSubmittingErrorDisplayed();
    }

    public static void clickDeleteItemOnCart(){
        customersPage.clickOnDeleteItemInCart();
    }

    public static double isCartTotalZero(){
        return customersPage.isCartTotalBecomsZero();
    }

    public static void selectAddSectionFromMoreOptionsDropdown(){
        customersPage.clickAddSectionFromMoreOptionsDropdown();
    }


    public static void addSectionName(String sectionName){
        customersPage.TypeSectionName(sectionName);
    }

    public static void clickSaveSection(){
        customersPage.clickOnSaveBtn();
    }

    public static boolean isAddedSectionDisplayed(String sectionName){
        return customersPage.isSectionDisplayed(sectionName);
    }

    public static void DragSectionToUP(){
        customersPage.dragSectionToHigher();
    }

    public static void clickOnBackBtnInEditOrderGuide() throws InterruptedException {
        customersPage.clickOnBackBtn();
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
    }

    public static void editsection(String sectionName){
        customersPage.clickOnEditSection(sectionName);
    }

    public static void editSectionName(String sectionName){
        customersPage.TypeSectionName(sectionName);
    }

    public static void deleteSection(){
        customersPage.clickOnDeleteBtn();
    }

    public static void selectYesOnDeleteConfirmationOverlay(){
        customersPage.clickYesOnConfirmationOverlay();
    }

    public static boolean isDeletedSectionNotDisplayed(String sectionName){
        return customersPage.isSectionDisplayed(sectionName);
    }

    public static void selectPkgFromUnitSelectionDropdown(){
        customersPage.clickPkgOption();
    }

    public static String isUnitChangedToPkg(){
        return customersPage.isUnitChangedToPkg();
    }

    public static void selectCaseFromUnitSelectionDropdown(){
        customersPage.clickCaseOption();
    }

    public static String isUnitChangedToCase(){
        return customersPage.isUnitChangedToCase();
    }

    public static void clickOnItemEditBtn(String ItemName){
        customersPage.clickEditItemBtn(ItemName);

    }

    public static void clickOnItemHideBtn(){
        customersPage.clickOnHideBtn();
    }

    public static void clickOnItemHideConfirmationOverlay(){
        customersPage.clickYesOnConfirmationOverlay();
    }

    public static boolean isHiddenItemDisplayedOnGrid(String itemName){
        return customersPage.isHiddenItemDisplayed(itemName);
    }

    public static void selectActiveAndHiddenItems(){
        customersPage.clickShowActiveAndHiddenItems();
    }

    public static void clickSaveAndUnhide(){
        customersPage.clickSaveAndUnhideBtn();
    }

    public static void selectOnlyActiveItems(){
        customersPage.clickShowOnlyActiveItems();
    }

    public static boolean CatalogImagesDisplayed(){
        return customersPage.isCatalogPageImagesDisplayed();
    }

    public static void ClickOnItem(String itemName){
        customersPage.clickItemOnCatalog(itemName);
    }

    public static boolean isNavigatedToPDP(String itemName){
        return customersPage.isPDPViewItemNameDisplayed(itemName);
    }

    public static String pdpViewItemName(String itemName){
        return customersPage.getPDPViewItemName(itemName);
    }

    public static String catalogViewItemName(String itemName){
        return customersPage.getCatalogViewItemName(itemName);
    }

    public static String pdpViewItemCost(){
        return customersPage.getPDPViewItemPrice();
    }

    public static String catalogViewItemPrice(String itemName){
        return customersPage.getCatalogViewItemPrice(itemName);
    }

    public static void selectCustomer(String customerCode){
        customersPage.clickOnCustomer(customerCode);

    }
    public static String getDeliveryDateOnReviewCart(){
        return customersPage.getDeliveryDateReviewCart();
    }

    public static String isNavigatedToProfile(String customerCode){
        return customersPage.isCustomerCodeDisplayed(customerCode);
    }

    public static void editDeliveryDate(){
        customersPage.clickOnEditDeliveryDate();
    }

    public static void clickOnPreviousDateDropdow(String date){
        customersPage.clickOnpreviousDateDropdow(date);
    }

    public static void selectTodayFromDropdownAsCutOff(String date){
        customersPage.clickTodayONDropDown(date);
    }

    public static void selectCutOffTime(String date , String time){
        customersPage.typeCutOffTime(date,time);
    }

    public static void saveChangesInCutOffTimeOverlay(){
        customersPage.saveChangesBtn();
    }

    public static String getOrderCutOffOnReviewCart(){
        return customersPage.getCutOffTimeFromReviewCart();
    }

    public static void clearDeliveryDate(String date){
        customersPage.clickOnClearDeliveryDateBtn(date);
    }

    public static void waitPastCutOffTime(){
        customersPage.waitForCutOffTimeToBeOver();
    }

}