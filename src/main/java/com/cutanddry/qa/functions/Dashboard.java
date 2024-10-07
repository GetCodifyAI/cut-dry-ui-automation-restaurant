package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DashboardPage;

import static com.cutanddry.qa.functions.Customer.customersPage;


public class Dashboard {
    static DashboardPage dashboardPage = new DashboardPage();

    public static boolean isUserNavigatedToDashboard(){
        return dashboardPage.isDashboardTextDisplayed();
    }
    public static void navigateToIndependentFoodsCo() {
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
    }
    public static boolean isUserNavigatedToOrderGuide(){
        return dashboardPage.isOrderGuideTextDisplayed();
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

    public static void navigateToReports() {
        dashboardPage.clickOnReports();
    }
    public static void navigateToCustomers() {
        dashboardPage.clickOnCustomers();
    }

    public static void selectSupplier(String supplierName){
        dashboardPage.clickOnSupplier(supplierName);
        dashboardPage.clickOnHayes();
        if(dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
        }
    }

    public static boolean isNavigatedToMaxiesSLPage() throws InterruptedException {
        return dashboardPage.isNavigatedToMaxiesSLOrderGuide();
    }


}
