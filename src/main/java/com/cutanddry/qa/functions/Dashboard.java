package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DashboardPage;

public class Dashboard {
    static DashboardPage dashboardPage = new DashboardPage();

    public static boolean isUserNavigatedToDashboard(){
        return dashboardPage.isDashboardTextDisplayed();
    }

    public static void navigateToCustomers() {
        dashboardPage.clickOnCustomers();
    }

}
