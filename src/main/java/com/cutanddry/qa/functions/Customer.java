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
    public static void increaseFirstRowQtyBySixClassic() throws InterruptedException {
        customersPage.clickPlusQryFirstRowClassic();
        customersPage.clickPlusQryFirstRowClassic();
        customersPage.clickPlusQryFirstRowClassic();
        customersPage.clickPlusQryFirstRowClassic();
        customersPage.clickPlusQryFirstRowClassic();
        customersPage.clickPlusQryFirstRowClassic();
    }

    public static void decreaseFirstRowQtyInClassic(int count) throws InterruptedException {
        for(int i=0;i<count;i++){
            customersPage.clickMinusQryFirstRowClassic();
        }
    }

    public static void increaseFirstRowQtyInClassic(int count) throws InterruptedException {
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
        for(int i=0;i<count;i++){
            customersPage.clickPlusQryFirstRowClassic();
        }
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
    public static void checkoutItems()throws InterruptedException{
        customersPage.clickOnCheckoutButton();
        if (customersPage.isSubstitutionTextDisplayed()){
           customersPage.clickDoNotSubstitute();
        }
        Thread.sleep(4000);
    }
    public static boolean isUserNavigatedToCatalog(){return customersPage.isCatalogTextDisplayed();}

    public static void goToCatalog()throws InterruptedException{
        customersPage.clickOnCatalogButton();
    }
    public static void clickOnOrderGuideTab() {
        customersPage.clickOrderGuideTab();
    }
    @SneakyThrows
    public static void searchItemOnCatalog(String item){
        customersPage.typeToSearchOnCatalog(item);
        Thread.sleep(5000);
    }
    public static void searchItemOnOrderGuide(String item) throws InterruptedException {
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
        customersPage.typeToSearchOnOrderGuide(item);
    }
    public static String getFirstElementFrmSearchResults(){return customersPage.getFirstItemNameFrmSearchResults().toLowerCase();}
    public static void addItemToCartCatalog()throws InterruptedException {
        customersPage.clickAddToCartCatalog();
    }
    public static Double getItemPriceCatalogSearch(){return customersPage.getItemPriceCatalogSearch();}
    public static String getItemQtyFirstRow(){
        return customersPage.getItemQtyFirstRow();
    }
    public static String getItemQtyFirstRowClassic(){
        return customersPage.getItemQtyFirstRowClassic();
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
    public static void submitOrder() throws InterruptedException {
        customersPage.submitOrder();
        if (customersPage.caseMinNotMetDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
        Thread.sleep(4000);
        if (customersPage.isDuplicatePopupDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
    }
    public static boolean isThankingForOrderPopupDisplayed(){return customersPage.isThankingForOrderPopupDisplayed();}
    public static void clickClose(){
        customersPage.clickCloseIcon();
    }
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
    public static void addItemFromCatalog()throws InterruptedException{
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

    public static void sortItemsByCustomOrder() throws InterruptedException {
        customersPage.clickOnSortDropdown();
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
        if(customersPage.isDuplicatePopupDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
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

    public static void clickOnPlaceOrder() throws InterruptedException {
        customersPage.clickOnPlaceOrder();
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
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
    public static boolean isOrderCutOffDisplayed(String time){
        return customersPage.isOrderCutOffDisplayed(time);
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

    public static void selectYesOnDeleteConfirmationOverlay() throws InterruptedException {
        customersPage.clickYesOnConfirmationOverlay();
    }

    public static boolean isDeletedSectionNotDisplayed(String sectionName){
        return customersPage.isSectionNotDisplayed(sectionName);
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

    public static void clickOnItemHideConfirmationOverlay() throws InterruptedException {
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

    public static boolean CatalogImagesDisplayed(String img)throws InterruptedException{
        return customersPage.isCatalogPageImagesDisplayed(img);
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

    public static String pdpViewItemCost(String itemName){
        return customersPage.getPDPViewItemPrice(itemName);
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

    public static void addItemFromCatalogIfNotAvailableInOG(String itemName){
        customersPage.clickItemFromCatalogIfNotAvailableInOG(itemName);
    }

    public static void clickAddNewItemFromOrderGuide(){
        customersPage.clickAddNewItem();
    }

    public static boolean isAddItemsToOrderGuideOverlayDisplayed(){
        return customersPage.isAddItemsToOrderGuideDisplayed();
    }

    public static void enterItemName(String itemName){
        customersPage.setItemName(itemName);
    }

    public static void enterItemCode(String itemCode){
        customersPage.setItemCode(itemCode);
    }

    public static void selectUnit(String unit){
        customersPage.setUnits(unit);
    }

    public static void enterPrice(String unit,String Price){
        customersPage.setPrice(unit,Price);
    }

    public static void selectAccountingCategory(String categoryName){
        customersPage.setAccountingCategory(categoryName);
    }

    public static void saveItem(){
        customersPage.clickSaveItemBtn();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }

    public static boolean isAddItemDisplayedInOrderGuide(String itemName){
        return customersPage.isAddItemDisplayed(itemName);
    }

    public static void editOrderFromReviewScreen(){
        customersPage.clickEditOrder();
    }
    public static String getItemCodeFirstRow() throws InterruptedException {
        return customersPage.getItemCodeFirstRow();
    }
    public static double getActiveItemPriceFirstRow() throws InterruptedException {
        return customersPage.getActiveItemPriceFirstRow();
    }
    public static void increaseFirstRowQtyCustom(int count) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.clickPlusQryFirstRow();
        }
    }
    public static boolean isReviewOrderTextDisplayed(){
        return customersPage.isReviewOrderTextDisplayed();
    }
    public static double getItemPriceOnCheckoutButtonViaPDP() throws InterruptedException {
        return customersPage.getItemPriceOnCheckoutButtonViaPDP();
    }
    public static void clickOnPlusIconInCatalogPDP(int count, String name) {
        for (int i=0; i<count;i++){
            customersPage.clickOnPlusIconInCatalogPDP(name);
        }
    }
    public static void clickOnMinusIconInCatalogPDP(int count, String name) {
        for (int i=0; i<count;i++){
            customersPage.clickOnMinusIconInCatalogPDP(name);
        }
    }
    public static String getFirstElementFrmCatalogSearchResults(String name){
        return customersPage.getFirstElementFrmCatalogSearchResults(name);
    }
    public static void clickOnProduct(String name){
        customersPage.clickOnProduct(name);
    }
    public static boolean isProductDetailsDisplayed(){
        return customersPage.isProductDetailsDisplayed();
    }
    public static void clickPlusSearchedSingleItem(int count) {
        for (int i=0; i<count;i++){
            customersPage.clickPlusSearchedSingleItem();
        }
    }
    public static void clickCheckOutPDP(){customersPage.clickCheckOutPDP();}
    public static boolean isDeliveryOptionSelected() {
        return customersPage.isDeliveryOptionSelected();
    }
    public static String getSuccessOrderId() {
        return customersPage.getOrderedId();
    }
    public static boolean isCustomersTextDisplayed(){
        return customersPage.isCustomersTextDisplayed();
    }
    public static boolean isCustomerSearchResultByCodeDisplayed(String code) throws InterruptedException {
        return customersPage.isCustomerSearchResultByCodeDisplayed(code);
    }
    public static String getBusinessNameFromCustomers(String CustomerCode){
        return customersPage.getBusinessName(CustomerCode);
    }
    public static void SelectCustomer(String code){
        customersPage.ClickOnCustomer(code);
    }
    public static boolean isCustomerProfileDisplayed(String CustomerName){
        return customersPage.isCustomerProfileDisplayed(CustomerName);
    }
    public static void clickOnOrdersTab(){
        customersPage.clickOnOrdersTab();
    }
    public static void clickOnSpecificRecord(String orderId) throws InterruptedException {
        customersPage.clickOnSpecificRecord(orderId);

    }
    public static boolean isOrderIdDisplayed(String orderId) throws InterruptedException {
        return customersPage.isOrderIdDisplayed(orderId);
    }
    public static void clickAddToCartPDP(){customersPage.clickAddToCart();}
    public static void selectPickUpWillCall(){
        customersPage.selectPickUpWillCall();
    }
    public static boolean isPickUpOptionSelected() {
        return customersPage.isPickUpOptionSelected();
    }
    public static void selectMailDelivery(){
        customersPage.selectMailDelivery();
    }
    public static boolean isMailDeliveryOptionSelected() {
        return customersPage.isMailDeliveryOptionSelected();
    }
    public static void navigateMontanaOrder() throws InterruptedException{
        customersPage.clickOnMontanaPlaceOrder();
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
    }
    public static void clickViewOrderInDraft(){
        customersPage.clickViewOrderInDraft();
    }
    public static boolean isSentApprovalDisplayed(){
        return customersPage.isSentApprovalDisplayed();
    }
    public static void clickOnPlusIconOrderGuideItem(int count) {
        for (int i=0; i<count;i++){
            customersPage.clickOnPlusIconOrderGuideItem();
        }
    }
    public static boolean isUserNavigatedToChefGlendaCatalog(){return customersPage.isUserNavigatedToChefGlendaCatalog();}
    public static void clickOnPlaceOrderSW() {
        customersPage.clickOnPlaceOrderSW();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickNoBtnOnDraftCheckOverlay();
        }
    }

    public static String getItemNameFirstMultiOUM() throws InterruptedException {
        return customersPage.getItemNameFirstMultiOUM();
    }

    public static String getItemNameFirstMultiOUMLB() throws InterruptedException {
        return customersPage.getItemNameFirstMultiOUMLB();
    }

    public static String getItemCodeFirstMultiOUM() throws InterruptedException {
        return customersPage.getItemCodeFirstMultiOUM();
    }

    public static String getItemCodeFirstMultiOUMLB() throws InterruptedException {
        return customersPage.getItemCodeFirstMultiOUMLB();
    }

    public static double getActiveItemPriceFirstMultiOUMRowStable() throws InterruptedException {
        return customersPage.getActiveItemPriceFirstMultiOUMRowStable();
    }

    public static String getItemUOMQuantity(String code,String uom){
        return customersPage.getItemUOMQuantity(code,uom);
    }

    public static void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        customersPage.ClickOnMultiUomDropDownOG(code);
    }
    public static void clickOGAddToCartPlusIcon(int count,String code, String uom) throws InterruptedException{
        for (int i=0; i<count;i++){
            customersPage.clickOGAddToCartPlusIcon(code,uom);
        }
    }

    public static void clickAddToCartMinusIcon(int count,String code, String uom) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.clickAddToCartMinusIcon(code,uom);
        }
    }

    public static double getActiveItemPriceMultiOUM(String position) throws InterruptedException {
        return customersPage.getActiveItemPriceMultiOUM(position);
    }

    public static double getItemPriceOnMultiOUMCheckout() throws InterruptedException {
        return customersPage.getItemPriceOnMultiOUMCheckout();
    }

    public static double getItemPriceReviewCartMultiUOM(String position) throws InterruptedException {
        return customersPage.getItemPriceReviewCartMultiUOM(position);
    }

}