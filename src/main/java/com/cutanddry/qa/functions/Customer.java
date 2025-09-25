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
    public static void decreaseReviewCartQtyByThree() throws InterruptedException {
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
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
           customersPage.clickSaveSelection();
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
    public static double getItemPriceReviewCart(){
        if (customersPage.isEditOrderTextDisplayed()) {
            try {
                return customersPage.getItemPriceOnMultiOUMCheckout();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            return customersPage.getItemPriceReviewCart();
        }
        }
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
        customersPage.clickOnMoreOptions();
        customersPage.clickOnPrint();
    }
    public static void printOrderGuide(){
        customersPage.clickOnDownloadOrderGuide();
    }
    public static boolean isPrintFriendlyPopupDisplayed(){return customersPage.isPrintFriendlyPopupDisplayed();}
    public static void goToEdit(){
        customersPage.clickOnMoreOptions();
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
        customersPage.clickOnMoreOptions();
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
    public static void closeEditor() throws InterruptedException {
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
    public static void selectDeliveryDateLine(String date)throws InterruptedException{
        customersPage.clickOnDeliveryDate();
        customersPage.selectDeliveryDateLine(date);

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
        Thread.sleep(3000);
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

    public static void clickOnItemEditBtn(String ItemName) throws InterruptedException {
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
    public static void clickCheckOutPDP(){
        customersPage.clickCheckOutPDP();
        try {
            if(customersPage.isSetSubstitutionTextDisplayed()){
                customersPage.clickCloseSub();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
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
//        return customersPage.isCustomerSearchResultByCodeDisplayed(code);
        if (customersPage.isCustomerSearchResultByCodeDisplayed(code)) {
            return true;
        } else {
            customersPage.refreshCustomersPage();
            customersPage.clickOnSearchCustomers();
            customersPage.typeOnSearchCustomers(code);
            return customersPage.isCustomerSearchResultByCodeDisplayed(code);
        }
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
        if (customersPage.isEditOrderTextDisplayed()) {
            return customersPage.getActiveItemPriceMultiOUM(position);
        }else {
            return customersPage.getItemPriceReviewCartMultiUOM(position);
        }
    }
    public static void submitOrderRebate() throws InterruptedException {
        customersPage.submitOrder();
        if (customersPage.caseMinNotMetDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
        if (customersPage.isDuplicatePopupDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
        Thread.sleep(4000);
        if (customersPage.isCombinedPopupDisplayed()){
            customersPage.clickContinueCombined();
        }
    }
    public static boolean isSetSubstitutionPopUPDisplayed()throws InterruptedException{
        return customersPage.isSetSubstitutionPopUpDisplayed();
    }
    public static void clickChooseSub(){
        customersPage.clickChooseSub();
    }
    public static void clickSelectSub(){
        customersPage.clickSelectSub();
    }
    public static void clickCloseSub(){
        customersPage.clickCloseSub();
    }
    public static void clickEditSub(){
        customersPage.clickEditSub();
    }
    public static void clickRemovePreviousSub(){
        customersPage.clickRemovePreviousSub();
    }
    public static void clickSaveSelection(){
        customersPage.clickSaveSelection();
    }
    public static boolean isTopCategoryPicksDisplayed(){
        return customersPage.isTopCategoryPicksDisplayed();
    }
    public static boolean isCompareSimilarItemsDisplayed(){
        return customersPage.isCompareSimilarItemsDisplayed();
    }
    public static boolean isRecommendedForYouItemNameDisplayed(String code){
        return customersPage.isRecommendedForYouItemNameDisplayed(code);
    }
    public static boolean isRecommendedBySalesRepDisplayed(String code){
        return customersPage.isRecommendedBySalesRepDisplayed(code);
    }
    public static boolean isDontForgetToOrderDisplayed(){
        return customersPage.isDontForgetToOrderDisplayed();
    }
    public static boolean isMoreFromThisBrandDisplayed(){
        return customersPage.isMoreFromThisBrandDisplayed();
    }
    public static String getItemNameFirstMultiOUMCoupa() throws InterruptedException {
        return customersPage.getItemNameFirstMultiOUMCoupa();
    }


    public static String getItemCodeFirstMultiOUMCoupa() throws InterruptedException {
        return customersPage.getItemCodeFirstMultiOUMCoupa();
    }


    public static double getActiveItemPriceFirstMultiOUMRowStableCoupa() throws InterruptedException {
        return customersPage.getActiveItemPriceFirstMultiOUMRowStableCoupa();
    }

    public static String getFirstElementFrmCatalogSearchResults(){return customersPage.getFirstItemNameFrmSearchResults();}

    public static boolean isAddSubstitutionTextDisplayed() throws InterruptedException {
        return customersPage.isAddSubstitutionTextDisplayed();
    }
    public static void clickSubstitution()throws InterruptedException{
        customersPage.clickSubstitution();
    }
    public static boolean isSetSubstitutionTextDisplayed() throws InterruptedException {
        return customersPage.isSetSubstitutionTextDisplayed();
    }

    public static String IsCustomOrderTextDisplayed() throws InterruptedException {
        return customersPage.IsCustomOrderTextDisplayed();
    }
    public static void submitOrderMinimum(){
        customersPage.submitOrder();
    }
    public static boolean isOrderMinPopupDisplayed(){
        return customersPage.isOrderMinPopupDisplayed();
    }
    public static boolean isMinOrderBannerDisplayed(){
        return customersPage.isMinOrderBannerDisplayed();
    }
    public static void clickOkOrderMinimum() throws InterruptedException {
        customersPage.clickOK();
        if (customersPage.isDuplicatePopupDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
    }
    public static void clickYesOrderMinimum() throws InterruptedException {
        customersPage.clickOnYes();
        if (customersPage.isDuplicatePopupDisplayed()){
            customersPage.clickYesDuplicatePopup();
        }
    }
    public static void clickOnInvoice(){
        customersPage.clickonInvoice();
        customersPage.isFirstRecordDisplayed();
    }
    public static void editStatusSubstitutionsAccess(String status){
        customersPage.clickEditSubstitutionsAccess();
        customersPage.editSubstitutionStatus(status);
        customersPage.saveCatalogAccessChanges();
    }
    public static double catalogItemPrice(String itemName) throws InterruptedException {
        return customersPage.getCatalogItemPrice(itemName);
    }
    public static boolean isRecentOrderDisplayed(String id)throws InterruptedException{
        return customersPage.isRecentOrderDisplayed(id);
    }
    public static void clickOnPlaceOrderSavalDraft() throws InterruptedException {
        customersPage.clickOnPlaceOrder();
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.isPreviousDraftOrderYesDisplayed();
        }
        Thread.sleep(3000);
    }
    public static void removeItemFromCatalogStable(String name)throws InterruptedException{
        customersPage.clickOnRemoveFromOrderGuideStable(name);
    }
    public static void searchItemOnHome(String item) throws InterruptedException {
        customersPage.typeToSearchOnHome(item);
        customersPage.clickSearchHome();
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
        Thread.sleep(5000);
    }
    public static boolean isEditItemPopupDisplayed(){
        return customersPage.isEditItemPopupDisplayed();
    }
    public static void clickOnCaseUnit() throws InterruptedException {
        customersPage.clickOnCaseUnit();
    }
    public static boolean isMultiUomDropDownDisplayed(String code)throws InterruptedException{
        return customersPage.isMultiUomDropDownDisplayed(code);
    }
    public static void closeOrderGuideEditor() throws InterruptedException {
        customersPage.clickOnCloseOrderGuideEditor();
        if (dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }
    public static void clickSaveOnUOMEditor() throws InterruptedException{
        customersPage.clickSaveOnUOMEditor();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }
    public static boolean isRecentOrderTextDisplayed()throws InterruptedException{
        return customersPage.isRecentOrderTextDisplayed();
    }
    public static boolean isDoNotSubstituteTextDisplay()throws InterruptedException{
        return customersPage.isDoNotSubstituteTextDisplay();
    }

    public static void clickOnEditOrderInReviewStable() throws InterruptedException {
        if (customersPage.isReviewOrderTextDisplayed()) {
            customersPage.clickEditOrder();
        }
    }
    public static void clickClosePopUp(){
        customersPage.clickClosePopUp();
    }
    public static boolean isLastColumnDisplay(String column) throws InterruptedException {
        return customersPage.isLastColumnDisplay(column);
    }
    public static void clickOnCustomerCode(String code){
        customersPage.clickOnCustomerCode(code);
    }
    public static void clickOnEditAccHolds(){
        customersPage.clickOnEditAccHolds();
    }
    public static void clickOnAccDropdown(){
        customersPage.clickOnAccDropdown();
    }
    public static void clickOnHardHold(){
        customersPage.clickOnHardHold();
    }
    public static void clickOnSaveDP(){
        customersPage.clickOnSaveDP();
    }
    public static boolean isHardHoldSelected(){
        return customersPage.isHardHoldSelected();
    }
    public static boolean isAccountHoldPopUpDisplay() throws InterruptedException {
        return customersPage.isAccountHoldPopUpDisplay();
    }
    public static boolean isAccountHoldMessageDisplay(String message) throws InterruptedException {
        return customersPage.isAccountHoldMessageDisplay(message);
    }
    public static void increaseFirstRowQtySpecificCustomer(int count) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.increaseFirstRowQtySpecificCustomer();
        }
    }
    public static void selectDeliveryDateLineStable(String day, boolean isNextMonth)throws InterruptedException{
        customersPage.clickOnDeliveryDate();
        customersPage.selectDeliveryDateLineStable(day, isNextMonth);
    }
    public static boolean isDeliveryDateOrderHistoryDisplayed(String id,String date){
        return customersPage.isDeliveryDateOrderHistoryDisplayed(id,date);
    }
    public static void selectPickUpDateLineStable(String day, boolean isNextMonth)throws InterruptedException{
        customersPage.clickOnPickUpDateStable();
        customersPage.selectDeliveryDateLineStable(day, isNextMonth);
    }
    public static boolean isFulfilmentTypeOrderHistoryDisplayed(String id,String type){
        return customersPage.isFulfilmentTypeOrderHistoryDisplayed(id,type);
    }
    public static void selectMailDeliveryDateLineStable(String day, boolean isNextMonth) throws InterruptedException {
        customersPage.clickOnDeliveryDate();
        customersPage.selectDeliveryDateLineStable(day, isNextMonth);
    }
    public static boolean isReviewOrderFulfilmentTypeDisplayed(String type){
        return customersPage.isReviewOrderFulfilmentTypeDisplayed(type);
    }
    public static void clickOnMoreOptionOG(){
        customersPage.clickOnMoreOptions();
    }
    public static boolean isEditOrderGuideOptionDisplay() throws InterruptedException {
        return customersPage.isEditOrderGuideOptionDisplay();
    }
    public static boolean isAddFromCatalogHeartItemDisplay(){
        return customersPage.isAddFromCatalogHeartItemDisplay();
    }
    public static void clickEditOrderGuideOption(){
        customersPage.clickOnEdit();
    }
    public static void clickOnDeleteOrderGuide(){
        customersPage.clickOnDeleteOrderGuide();
    }
    public static void checkoutItemsForSubstitute()throws InterruptedException{
        customersPage.clickOnCheckoutButton();
    }
    public static boolean isPurchaseHistoryDisplay(){
        return customersPage.isPurchaseHistoryDisplay();
    }
    public static boolean isLastOrderDisplay(String order){
        return customersPage.isLastOrderDisplay(order);
    }
    public static void clickLastOrderDetailsCatalog(String name)throws InterruptedException{
        customersPage.clickLastOrderDetailsCatalog(name);
    }
    public static void clickLastOrderOG(String code) throws InterruptedException {
        customersPage.clickLastOrderOG(code);
    }
    public static boolean isSpecialOrderNoteDisplay(String note) throws InterruptedException {
        return customersPage.isSpecialOrderNoteDisplay(note);
    }
    public static void clickOGDropdown(){
        customersPage.clickOGDropdown();
    }
    public static void selectOrderGuide(String name){
        customersPage.selectOrderGuide(name);
    }
    public static void clickCatalogListView(){
        customersPage.clickCatalogListView();
    }
    public static boolean isAddToOrderGuideListViewDisplay(){
        return customersPage.isAddToOrderGuideListViewDisplay();
    }
    public static void clickLocationGuide(){
        customersPage.clickLocationGuide();
    }
    public static boolean IsLocationOrderGuideDisplay(String name){
        return customersPage.IsLocationOrderGuideDisplay(name);
    }
    public static void disableCatalogAccess(){
        customersPage.clickEditCatalogAccess();
        customersPage.clickOnDisableCatalogAccessOption();
        customersPage.saveCatalogAccessChanges();
    }
    public static void enableCatalogAccess(){
        if (!customersPage.isCatalogAccessEnableDisplayed()) {
            customersPage.clickEditCatalogAccess();
            customersPage.clickOnEnableCatalogAccessOption();
            customersPage.saveCatalogAccessChanges();
        }
    }
    public static boolean catalogAccessDisabled(){
        return customersPage.isCatalogAccessDisabled();
    }
    public static boolean isCatalogButtonDisplay(){
        return customersPage.isCatalogButtonDisplay();
    }
    public static void typePONumber(String poNumber) throws InterruptedException {
        customersPage.typePONumber(poNumber);
    }
    public static void clickOK(){
        customersPage.clickOK();
    }
    public static boolean isPONumberErrorDisplay(String code){
        return customersPage.isPONumberErrorDisplay(code);
    }
    public static boolean isCatalogFilterDisplayed(String filter){
        return customersPage.isCatalogFilterDisplayed(filter);
    }
    public static void clickCatalogFilter(String filter)throws InterruptedException{
        customersPage.clickCatalogFilter(filter);
    }
    public static boolean isCatalogFilterTagDisplayed(String tag){
        return customersPage.isCatalogFilterTagDisplayed(tag);
    }
    public static boolean isEditOrderGuideTextCatalogDisplayed(){
        return customersPage.isEditOrderGuideTextCatalogDisplayed();
    }
    public static boolean isCatalogNewArrivalFilterTagDisplayed(String tag){
        return customersPage.isCatalogNewArrivalFilterTagDisplayed(tag);
    }
    public static boolean isCatalogFilterDisplayTag(String name,String tag){
        return customersPage.isCatalogFilterDisplayTag(name,tag);
    }
    public static boolean isOrderGuideItemTagDisplayTag(String name,String tag){
        return customersPage.isOrderGuideItemTagDisplayTag(name,tag);
    }
    public static boolean isPDPItemDisplayTag(String name,String tag){
        return customersPage.isPDPItemDisplayTag(name,tag);
    }
    public static boolean isCatalogSearchItemCodeDisplay(String code){
        return customersPage.isCatalogSearchItemCodeDisplay(code);
    }
    public static void clickCartSummery() throws InterruptedException {
        customersPage.clickCartSummery();
    }
    public static boolean isCartSummaryDisplay(String count){
        return customersPage.isCartSummaryDisplay(count);
    }
    public static boolean isCartSummaryValueDisplay(String name){
        return customersPage.isCartSummaryValueDisplay(name);
    }
    public static void clickMenu()throws InterruptedException{
        customersPage.clickMenu();
    }
    public static boolean isUserNameDisplay(String name){
        return customersPage.isUserNameDisplay(name);
    }
    public static boolean isDistributorNameDisplay(String name){
        return customersPage.isDistributorNameDisplay(name);
    }
    public static void clickCloseMenu() throws InterruptedException {
        customersPage.clickCloseMenu();
    }
    public static void clickOnPlusIconInCatalogStable(int count, String name) {
        for (int i=0; i<count;i++){
            customersPage.clickOnPlusIconInCatalogStable(name);
        }
    }
    public static void clickSendToERP() throws InterruptedException {
        customersPage.clickSendToERP();
    }
    public static boolean isSendToERPButtonDisplayed() throws InterruptedException {
        return customersPage.isSendToERPButtonDisplayed();
    }
    public static boolean isNotesToCustomerDisplayed(String note){
        return customersPage.isNotesToCustomerDisplayed(note);
    }
    public static boolean isSubmitERPPopUpDisplayed() throws InterruptedException {
        return customersPage.isSubmitERPPopUpDisplayed();
    }
    public static boolean isOrderSentERPPopUpDisplayed() throws InterruptedException {
        return customersPage.isOrderSentERPPopUpDisplayed();
    }
    public static boolean isOrderSubmissionStepDisplayed(String step){
        return customersPage.isOrderSubmissionStepDisplayed(step);
    }
    public static void clickOnTimeline(){
        customersPage.clickOnTimeline();
    }
    public static void clickConfirm(){customersPage.clickConfirm();}
    public static void clickSubmittedOrder(String id){
        customersPage.clickSubmittedOrder(id);
    }
    public static void clickSimpleListView(){
        customersPage.clickSimpleListView();
    }
    public static boolean isSimpleListViewTextDisplay()throws InterruptedException{
        return customersPage.isSimpleListViewTextDisplay();
    }
    public static void clickSortOptionOG(String option)throws InterruptedException{
        customersPage.clickSortOptionOG(option);
    }
    public static boolean isSortOptionDisplay(String option)throws InterruptedException{
        return customersPage.isSortOptionDisplay(option);
    }
    public static void clickSortOptionsDropdown(){
        customersPage.selectSortOptions();
    }
    public static void clickOnProductStable(String name){
        customersPage.clickOnProductStable(name);
    }
    public static void clickOnPlusIconCatalogStable(int count, String name) {
        for (int i=0; i<count;i++){
            customersPage.clickOnPlusIconCatalogStable(name);
        }
    }
    public static void uploadOrder(){
        customersPage.clickOnUploadOrder();
    }
    public static boolean isUploadToOrderTextDisplay()throws InterruptedException{
        return customersPage.isUploadToOrderTextDisplay();
    }
    public static String getItemQuantity(String code){
        return customersPage.getItemQuantity(code);
    }
    public static void clickRecentSubmitOrder(String id)throws InterruptedException{
        customersPage.clickRecentSubmitOrder(id);
    }
    public static boolean isRecentSubmitOrderDisplay(String id)throws InterruptedException{
        return customersPage.isRecentSubmitOrderDisplay(id);
    }
    public static boolean isRecentSubmitOrderQuantityDisplay(String id,String quantity)throws InterruptedException{
        return customersPage.isRecentSubmitOrderQuantityDisplay(id,quantity);
    }
    public static double getRecentItemPrice(String id) throws InterruptedException {
        return customersPage.getRecentItemPrice(id);
    }
    public static void clickQuickAdd()throws InterruptedException{
        customersPage.clickQuickAdd();
    }
    public static boolean isQuickAddViewDisplay()throws InterruptedException{
        return customersPage.isQuickAddViewDisplay();
    }
    public static boolean isQuickAddOptionDisplay()throws InterruptedException{
        return customersPage.isQuickAddOptionDisplay();
    }
    public static void enterItemCodeQuickAdd(String code)throws InterruptedException{
        customersPage.enterItemCodeQuickAdd(code);
    }
    public static void enterItemQuantity(String code)throws InterruptedException{
        customersPage.enterItemQuantity(code);
    }
    public static void clickVerifyItem()throws InterruptedException{
        customersPage.clickVerifyItem();
    }
    public static void clickSaveAndReview()throws InterruptedException{
        customersPage.clickSaveAndReview();
        if (customersPage.isPreviousDraftOrderNoDisplayedSub()){
            customersPage.clickPreviousDraftOrderNo();
        }
    }
    public static String getItemQuantityReviewPage(String code) throws InterruptedException {
        return customersPage.getItemQuantityReviewPage(code);
    }
    public static void clickOrderGuideView(){
        customersPage.clickOrderGuideView();
    }
    public static String getItemQuantitySimpleListView(String code) throws InterruptedException {
        return customersPage.getItemQuantitySimpleListView(code);
    }
    public static void clearSearchField()throws InterruptedException{
        customersPage.clearSearchField();
    }
    public static boolean isItemVerifiedPopUpDisplay()throws InterruptedException{
        return customersPage.isItemVerifiedPopUpDisplay();
    }
    public static void clickClosePopUpButton() throws InterruptedException {
        customersPage.clickOnClose();
    }
    public static void increaseFirstRowQtyStable(int count) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.clickPlusQryFirstRowStable();
        }
    }
    public static boolean isManageStandingOrdersDisplay()throws InterruptedException{
        return customersPage.isManageStandingOrdersDisplay();
    }
    public static void clickManageStandingOrders()throws InterruptedException{
        customersPage.clickManageStandingOrders();
    }
    public static boolean isManageStandingOrdersPopUpDisplay()throws InterruptedException{
        return customersPage.isManageStandingOrdersPopUpDisplay();
    }
    public static boolean isCreateStandingOrdersButtonDisplay()throws InterruptedException{
        return customersPage.isCreateStandingOrdersButtonDisplay();
    }
    public static void clickCreateStandingOrders()throws InterruptedException{
        customersPage.clickCreateStandingOrders();
    }
    public static void selectDeliveryDate(String day){
        customersPage.clickOnRemoveDelivery();
        customersPage.clickOnDropdownDelivery();
        customersPage.clickOnDeliveryDateStanding(day);
    }
    public static void selectDeliveryDateAsLastBefore(){
        customersPage.clickOnRemoveDelivery();
        customersPage.clickOnDropdownDelivery();
        customersPage.clickOnDeliveryDateAsLastBefore();
    }
    public static void setStandingOrder(){
        customersPage.setStandingOrder();
    }
    public static boolean isStandingOrderSuccessPopupDisplayed(){
        return customersPage.isStandingOrderSuccessPopupDisplayed();
    }
    public static boolean isReviewStandingOrdersDisplayed(){
        return customersPage.isReviewStandingOrdersDisplayed();
    }
    public static void clickOnStandingOrderEditIcon() throws InterruptedException {
        customersPage.clickOnStandingOrderEditIcon();
    }
    public static void clickOnStandingOrderDeleteIcon() throws InterruptedException {
        customersPage.clickOnStandingOrderDeleteIcon();
    }
    public static boolean isStandingOrdersDeletedIconDisplay(){
        return customersPage.isStandingOrdersDeletedIconDisplay();
    }
    public static boolean isSubmittedStandingOrderDisplayed(String quantity ,String price){
        return  customersPage.isSubmittedStandingOrderDisplayed(quantity,price);
    }
    public static void clickOnStandingOrderPauseIcon() throws InterruptedException {
        customersPage.clickOnStandingOrderPauseIcon();
    }
    public static boolean isStandingOrdersPaused(){
        return customersPage.isStandingOrdersPaused();
    }
    public static void clickOnStandingOrderResumeIcon() throws InterruptedException {
        customersPage.clickOnStandingOrderResumeIcon();
    }
    public static void clickAddToRecentSubmitOrder(String id)throws InterruptedException{
        customersPage.clickAddToRecentSubmitOrder(id);
    }
    public static void increaseReviewQtyStable(String code,int count) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.increaseReviewQtyStable(code);
        }
    }
    public static void decreaseReviewQtyStable(String code,int count) throws InterruptedException {
        for (int i=0; i<count;i++){
            customersPage.decreaseReviewQtyStable(code);
        }
    }
    public static boolean isTrashCanReviewPage(String code)throws InterruptedException{
        return customersPage.isTrashCanReviewPage(code);
    }
    public static boolean isRecentAddedOrderDisplay(String id)throws InterruptedException{
        return customersPage.isRecentAddedOrderDisplay(id);
    }
    public static void editCalculateOrderQty(){
        customersPage.editCalculateOrderQty();
    }
    public static boolean isCalculateOrderQtyDisplayed(){
        return customersPage.isCalculateOrderQtyDisplayed();
    }
    public static void enterParValue(String val) throws InterruptedException {
        customersPage.enterParValue(val);
    }
    public static void enterOnSiteInvValue(String val) throws InterruptedException {
        customersPage.enterOnSiteInvValue(val);
    }
    public static double getItemPriceTotal() throws InterruptedException {
        return customersPage.getItemPriceTotal();
    }
    public static void clickOnSaveStable(){
        customersPage.saveCatalogAccessChanges();
    }
    public static void clickClearAll()throws InterruptedException{
        customersPage.clickClearAll();
    }
    public static String getCartSummeryValue (String option) throws InterruptedException {
        return customersPage.getCartSummeryValue(option);
    }
    public static double getOrderMinimumValueStable(String option) throws InterruptedException {
        return customersPage.getOrderMinimumValueStable(option);
    }
    public static boolean isPreAuthorizationTextDisplay(String message)throws InterruptedException{
        return customersPage.isPreAuthorizationTextDisplay(message);
    }
    public static boolean isConfirmPaymentTextDisplay()throws InterruptedException{
        return customersPage.isConfirmPaymentTextDisplay();
    }
    public static void clickContinue(){customersPage.clickContinue();}
    public static void clickSortOptionsOG(String option)throws InterruptedException{
        customersPage.clickSortOptionsOG(option);
    }
    
    public static void clickCartSummaryExpanded() throws InterruptedException {
        customersPage.clickCartSummaryExpanded();
    }
    
    public static String getCartSummaryExpandedValue(String option) throws InterruptedException {
        return customersPage.getCartSummaryExpandedValue(option);
    }
    
    public static double getOrderMinimumValueExpandedStable(String option) throws InterruptedException {
        return customersPage.getOrderMinimumValueExpandedStable(option);
    }
    
    public static boolean isCartSummaryExpandedDisplay(String count) {
        return customersPage.isCartSummaryExpandedDisplay(count);
    }



}
