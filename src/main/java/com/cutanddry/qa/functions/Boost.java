package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.BoostPage;


public class Boost {
    static BoostPage boostPage = new BoostPage();

    public static void navigateToBoost() {
        boostPage.clickOnBoost();
    }
    public static boolean isUserNavigatedToBoost(){
        return boostPage.isBoostTextDisplayed();
    }
    public static void clickSuggestiveSales(){
        boostPage.clickSuggestiveSales();
    }
    public static boolean isSuggestiveTabDisplayed(){
        return boostPage.isSuggestiveTabDisplayed();
    }
    public static void clickTopCategoryPicksConfig(){
        boostPage.clickTopCategoryPicksConfig();
    }
    public static boolean isTopCategoryPopupDisplayed(){
        return boostPage.isTopCategoryPopupDisplayed();
    }
    public static void ensureTopCategoryPicksDisplayStatus(boolean status) throws InterruptedException {
        boostPage.ensureTopCategoryPicksDisplayStatus(status);
    }
    public static void clickAllItemsConfig(){
        boostPage.clickAllItemsConfig();
    }
    public static void clickClose() throws InterruptedException {
        boostPage.clickClose();
    }
    public static boolean checkInactiveState(String type) throws InterruptedException {
        return boostPage.checkInactive(type);
    }
    public static void clickCompareSimilarItemsConfig(){
        boostPage.clickCompareSimilarItemsConfig();
    }
    public static boolean isCompareSimilarPopupDisplayed(){
        return boostPage.isCompareSimilarPopupDisplayed();
    }
    public static void toggleOnCarouselDisplayStatus(boolean inactive) throws InterruptedException {
        boostPage.toggleOnCarouselDisplayStatus(inactive);
    }
    public static void toggleOffCarouselDisplayStatus(){
        boostPage.toggleOffCarouselDisplayStatus();
    }
    public static void clickRecommendForCustomerConfig(){
        boostPage.clickRecommendForCustomerConfig();
    }
    public static boolean isRecommendForCustomerPopupDisplayed(){
        return boostPage.isRecommendForCustomerPopupDisplayed();
    }
    public static void clickRecommendBySalesRepConfig(){
        boostPage.clickRecommendBySalesRepConfig();
    }
    public static boolean isRecommendBySalesRepPopupDisplayed(){
        return boostPage.isRecommendBySalesRepPopupDisplayed();
    }
    public static void clickSalesRepConfig(String name){
        boostPage.clickSalesRepConfig(name);
    }
    public static boolean isSalesRepConfigPopupDisplayed(){
        return boostPage.isSalesRepConfigPopupDisplayed();
    }
    public static void clickAddItems(){
        boostPage.clickAddItems();
    }
    public static void addItem(String code){
        boostPage.addItem(code);
        boostPage.clickAdd();
    }
    public static boolean isItemAdded(String code){
        return boostPage.isItemAdded(code);
    }
    public static void removeItem(String code){
        boostPage.removeItem(code);
    }
    public static boolean isItemInCarouselPreview(String code){
        return boostPage.isItemInCarouselPreview(code);
    }
    public static void ensureCarouselDisplayStatus(boolean status) throws InterruptedException {
        boostPage.ensureCarouselDisplayStatus(status);
    }
    public static void ensureDoNotForgetCarouselDisplayStatus(boolean status) throws InterruptedException {
        boostPage.clickOnBoost();
        boostPage.clickSuggestiveSales();
        boostPage.clickDontForgetToOrderConfig();
        boostPage.ensureCarouselDisplayStatus(status);
        boostPage.clickClose();
    }
    public static void ensureMoreFromThisBrandCarouselDisplayStatus(boolean status) throws InterruptedException {
        boostPage.clickOnBoost();
        boostPage.clickSuggestiveSales();
        boostPage.clickMoreFromThisConfig();
        boostPage.ensureCarouselDisplayStatus(status);
        boostPage.clickClose();
    }
    public static void ensureRecommendedForCustomerCarouselDisplayStatus(boolean status) throws InterruptedException {
        boostPage.clickOnBoost();
        boostPage.clickSuggestiveSales();
        boostPage.clickRecommendForCustomerConfig();
        boostPage.ensureCarouselDisplayStatus(status);
        boostPage.clickClose();
    }
    public static void ensureCompareSimilarItemsCarouselDisplayStatus(boolean status) throws InterruptedException {
        boostPage.clickOnBoost();
        boostPage.clickSuggestiveSales();
        boostPage.clickCompareSimilarItemsConfig();
        boostPage.ensureCarouselDisplayStatus(status);
        boostPage.clickClose();
    }

}
