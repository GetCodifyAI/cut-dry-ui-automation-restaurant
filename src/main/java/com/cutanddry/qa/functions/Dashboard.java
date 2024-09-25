package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DashboardPage;


public class Dashboard {
    static DashboardPage dashboardPage = new DashboardPage();

    public static boolean isUserNavigatedToDashboard(){
        return dashboardPage.isDashboardTextDisplayed();
    }
    public static void navigateToIndependentFoodsCo() {
        dashboardPage.clickOnPlaceOrder();
    }
    public static void navigateToOrderGuide(){
        dashboardPage.clickOnHayes();
        if (dashboardPage.isTestAutomationPopupDisplayed()){
            dashboardPage.clickOnTestAutomationPopup();
        }
        if (dashboardPage.isDraftOrderPopUpDisplayed()){
            dashboardPage.clickOnNoDraftOrder();
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
}
