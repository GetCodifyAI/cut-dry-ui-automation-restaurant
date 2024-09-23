package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CustomersPage;
import com.cutanddry.qa.pages.DashboardPage;
import lombok.SneakyThrows;


public class Customer {
    static CustomersPage customersPage = new CustomersPage();
    static DashboardPage dashboardPage = new DashboardPage();
    public static void increaseFirstRowQtyByOne(){
        customersPage.clickPlusQryFirstRow();
    }
    public static void increaseSecondRowQtyByOne(){customersPage.clickPlusQrySecondRow();}
    public static void decreaseFirstRowQtyByOne(){
        customersPage.clickMinusQryFirstRow();
    }
    public static void decreaseSecondRowQtyByOne(){
        customersPage.clickMinusQrySecondRow();
    }
    public static void increaseFirstRowQtyByThree(){
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
    }
    public static void decreaseFirstRowQtyByThree(){
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
    public static void searchItemOnOrderGuide(String item){
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

    public static void sortByItemCategory(){
        customersPage.clickDropDownCustomerOrder();
        customersPage.selectDropDownItemCategory();
    }
    public static void sortByAlphabet(){
        customersPage.clickDropDownItemCategory();
        customersPage.selectDropDownAlphabetical();
    }
    public static void sortByCustomOrder(){
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
}