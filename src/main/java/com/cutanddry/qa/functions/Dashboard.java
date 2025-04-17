package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DashboardPage;

import static com.cutanddry.qa.functions.Customer.*;


public class Dashboard {
    static DashboardPage dashboardPage = new DashboardPage();

    public static boolean isUserNavigatedToDashboard(){
        return dashboardPage.isDashboardTextDisplayed();
    }
    public static void navigateToIndependentFoodsCo() throws InterruptedException{
        dashboardPage.clickLocationFilter();
        dashboardPage.clickOnLocationOption();
        dashboardPage.clickOnPlaceOrder();
    }
    public static void navigateToOrderGuide() throws InterruptedException {
        dashboardPage.clickOnHayes();
        if (dashboardPage.isTestAutomationPopupDisplayed()){
            dashboardPage.clickOnTestAutomationPopup();
        }
        if (customersPage.isPreviousDraftOrderNoDisplayed()){
            customersPage.clickPreviousDraftOrderNo();
        }
        if (customersPage.isRatingOverlayDisplayed()){
            customersPage.clickCloseRatingOverlay();
        }
    }
    public static boolean isUserNavigatedToOrderGuide(){
        return dashboardPage.isOrderGuideTextDisplayed();
    }
    public static boolean isUserNavigatedToOrderGuideMaxies(){
        return dashboardPage.isMaxiesOrderGuideTextDisplayed();
    }

    public static boolean isUserNavigatedToDisDashboard(){
        return dashboardPage.isDisDashboardTextDisplayed();
    }
    public static void navigateToCooksCompanyProduce() {
        dashboardPage.clickOnCooksCompanyProduce();
    }
    public static boolean isApprovalsTabDisplayed(){
        return dashboardPage.isApprovalsTabDisplayed();
    }
    public static boolean isUserNavigatedToDrafts(){
        return dashboardPage.isDraftsTextDisplayed();
    }
    public static boolean isUserNavigatedToChats(){
        return dashboardPage.isChatTextDisplayed();
    }
    public static boolean isUserNavigatedToPay(){
        return dashboardPage.isPayTextDisplayed();
    }
    public static void navigateToReports() {
        dashboardPage.clickOnReports();
    }
    public static void navigateToCustomers() {
        dashboardPage.clickOnCustomers();
    }
    public static void navigateToOrder() throws InterruptedException {
        dashboardPage.clickOnOrder();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }
    public static void selectSupplier(String supplierName){
        dashboardPage.clickOnSupplier(supplierName);
        dashboardPage.clickOnHayes();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickNoBtnOnDraftCheckOverlay();
        }
    }

    public static boolean isNavigatedToMaxiesSLPage() throws InterruptedException {
        return dashboardPage.isNavigatedToMaxiesSLOrderGuide();
    }
    public static void navigateToDrafts(){
        dashboardPage.clickOnDrafts();
    }
    public static void navigateToChats(){
        dashboardPage.clickOnChats();
    }
    public static void navigateToPay(){
        dashboardPage.clickOnPay();
    }
    public static void navigateToUsers(){
        dashboardPage.clickOnUsers();
    }
    public static void navigateToApprovals(){
        dashboardPage.clickOnApprovals();
    }

    public static void navigateToRewards() {
        dashboardPage.clickOnRewards();
    }

    public static boolean isUserNavigatedToDistributorDashboard(){
        return dashboardPage.isDistributorDashboardTextDisplayed();
    }
    public static void navigateToCreditRequests(){
        dashboardPage.clickOnCreditRequests();
    }

    public static boolean isNavigatedToOperatorOrderGuide(String supplier) throws InterruptedException {
        return dashboardPage.isNavigatedToOrderGuide(supplier);
    }
    public static void navigateToCatalog() {
        dashboardPage.clickOnCatalog();
    }
    public static void navigateToOrderSettings() {
        dashboardPage.clickOnOrderSettings();
    }
    public static boolean isChooseProductCatalogDisplayed()throws InterruptedException{
        return dashboardPage.isChooseProductCatalogDisplayed();
    }
    public static void chooseProductCatalog(String name)throws InterruptedException{
        dashboardPage.chooseProductCatalog(name);
    }
    public static void navigateToHome() throws InterruptedException {
        dashboardPage.clickOnHome();
    }
    public static boolean isUserNavigateHome()throws InterruptedException{
        return dashboardPage.isUserNavigateHome();
    }
    public static void switch1932Saval()throws InterruptedException{
        dashboardPage.switch1932Saval();
    }
    public static void clickCategory()throws InterruptedException{
        dashboardPage.clickCategory();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickNoBtnOnDraftCheckOverlayCatalog();
        }
    }
    public static void switchSavalFood()throws InterruptedException{
        dashboardPage.switchSavalFood();
    }
    public static boolean isCatalogDataDisplayed()throws InterruptedException{
        return dashboardPage.isCatalogDataDisplayed();
    }
    public static boolean isSavalFoodServiceLogoDisplayed()throws InterruptedException{
        return  dashboardPage.isSavalFoodServiceLogoDisplayed();
    }
    public static boolean isSavalFoodServiceBannerDisplayed()throws InterruptedException{
        return  dashboardPage.isSavalFoodServiceBannerDisplayed();
    }
}
