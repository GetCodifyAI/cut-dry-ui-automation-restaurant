package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CatalogPage;

public class Catalog {
    static CatalogPage catalogPage = new CatalogPage();

    public static void ClickOnMultiUomDropDown(String name)throws InterruptedException{
        catalogPage.ClickOnMultiUomDropDown(name);
    }
    public static void ClickOnMultiUomDropDownOption(String option)throws InterruptedException{
        catalogPage.ClickOnMultiUomDropDownOption(option);
    }
    public static void clickAddToCartPlusIcon(int count, String uom) throws InterruptedException{
        for (int i=0; i<count;i++){
            catalogPage.clickAddToCartPlusIcon(uom);
        }
    }
    public static void clickAddToCartMinusIcon(int count, String name) throws InterruptedException {
        for (int i=0; i<count;i++){
            catalogPage.clickAddToCartMinusIcon(name);
        }
    }
    public static boolean isEditQuantitiesButtonDisplayed(String name){
        return catalogPage.isEditQuantitiesButtonDisplayed(name);
    }
    public static void ClickOnEditQuantities(String name)throws InterruptedException{
        catalogPage.ClickOnEditQuantities(name);
    }
    public static boolean isAddToCartButtonDisplayed(){
        return catalogPage.isAddToCartButtonDisplayed();
    }
    public static double getPDPPriceUOM(String uom) throws InterruptedException {
        return catalogPage.getPDPPriceUOM(uom);
    }
    public static void clickBack(){
        catalogPage.clickOnBackToCatalog();
    }
    public static void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        catalogPage.ClickOnMultiUomDropDownOG(code);
    }
    public static void clickOGAddToCartPlusIcon(int count,String code, String uom) throws InterruptedException{
        for (int i=0; i<count;i++){
            catalogPage.clickOGAddToCartPlusIcon(code,uom);
        }
    }
    public static double getOGPriceUOM(String code,String uom) throws InterruptedException {
        return catalogPage.getOGPriceUOM(code,uom);
    }
    public static String getMultiOrderedId(String uom) {
        return catalogPage.getMultiOrderedId(uom);
    }
    public static double getTotalPriceUOM() throws InterruptedException {
        return catalogPage.getTotalPriceUOM();
    }
    public static String getTotalItemCount() throws InterruptedException {
        return catalogPage.getTotalItemCount();
    }
    public static double getTotalEndlessAislePriceInReviewOrder() throws InterruptedException {
        return catalogPage.getTotalEndlessAislePriceInReviewOrder();
    }
    public static double getTotalEndlessAisleSubTotalPriceInReviewOrder() throws InterruptedException {
        return catalogPage.getTotalEndlessAisleSubTotalPriceInReviewOrder();
    }
    public static double getSubTotalPriceInOrder() throws InterruptedException {
        return catalogPage.getSubTotalPriceInOrder();
    }
    public static double getTotalPriceInReviewOrder() throws InterruptedException {
        return catalogPage.getTotalPriceInReviewOrder();
    }
    public static String getTotalQuantityInReviewOrder(){
        return catalogPage.getTotalQuantityInReviewOrder();
    }
    public static double getDeliveryFeesPriceInReviewOrder() throws InterruptedException {
        return catalogPage.getDeliveryFeesPriceInReviewOrder();
    }
    public static String getTotalQuantityInOrder(){
        return catalogPage.getTotalQuantityInOrder();
    }
    public static double getTotalPriceInOrder() throws InterruptedException {
        return catalogPage.getTotalPriceInOrder();
    }
    public static void clickItemType()throws InterruptedException{catalogPage.clickItemType();}
    public static boolean isUserNavigatedToCatalog(){
        return catalogPage.isCatalogTextDisplayed();
    }
    public static void searchItemInCatalog(String itemName){
        catalogPage.clickSearchItemInCatalog(itemName);
    }
    public static void selectItemFromGrid(String itemCode){
        catalogPage.clickonItemOnCatalogPage(itemCode);
    }
    public static String getItemcodeInCatalogData(){
        return catalogPage.getItemCodeFromCatalogDataPage();
    }
    public static void navigateToSubstituteTab(){
        catalogPage.clickOnSubstituteTab();
    }
    public static void removeExistingItem(String ItemCode){
        if (catalogPage.isDeleteSubstituteItemDisplayed(ItemCode)) {
            catalogPage.clickOnDeleteSubstituteItemBtn(ItemCode);
            catalogPage.clickOnSaveChangesBtn();
        }

    }
    public static void addSubstitutions(){
        catalogPage.clickAddSubstitutionBtn();
    }
    public static String getSubstituteItemName(String ItemCode){
        return catalogPage.getSubstituteItemName(ItemCode);
    }
    public static void searchAndAddSubstituteItem(String ItemCode){
        catalogPage.searchSubstituteItem(ItemCode);
        catalogPage.addSubstitutionsBtn();
    }
    public static void saveChanges(){
        catalogPage.clickOnSaveChangesBtn();
    }
    public static boolean successOverlayDisplayed(){
        return catalogPage.isSuccessOverlayDisplayed();
    }
    public static boolean isAddedSubstituteItemDisplayedInPage(String ItemCode){
        return catalogPage.isSubstituteItemDisplayed(ItemCode);
    }
    public static void deleteSubstitute(){
        catalogPage.deleteSubstitute();
    }
    public static double getPDPPriceUOMJIT(String uom) throws InterruptedException {
        return catalogPage.getPDPPriceUOMJIT(uom);
    }
    public static boolean isCategoryDisplayed()throws InterruptedException{
        return catalogPage.isCategoryDisplayed();
    }
    public static void clickPurchaseHistory(){
        catalogPage.clickPurchaseHistory();
    }
    public static boolean isPriceColumnDisplay(String price){
        return catalogPage.isPriceColumnDisplay(price);
    }
    public static boolean isLastOrderPriceDisplay(String price){
        return catalogPage.isLastOrderPriceDisplay(price);
    }
}
