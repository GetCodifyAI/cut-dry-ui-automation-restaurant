package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.ReportsPage;

public class Reports {

    static com.cutanddry.qa.pages.ReportsPage ReportsPage = new ReportsPage();
    public static boolean isUserNavigatedToReports(){
        return ReportsPage.isReportingTextDisplayed();
    }
    public static void generateReport(){
        ReportsPage.clickOnGenerateReports();
    }
    public static boolean disabledGenerateReport(){
        return ReportsPage.isDisabledGenerateReportButtonDisplayed();
    }

    public static void selectMonthlyExpensesByVendor(){
        ReportsPage.clickOnDropdownReportType();
        ReportsPage.clickOnMonthlyExpensesByVendor();
    }
    public static void clickOnDropdownReportType(){
        ReportsPage.clickOnDropdownReportType();
    }
    public static boolean isReportTypeDisplayed(String txt){
        return ReportsPage.isReportTypeDisplayed(txt);
    }
    public static boolean isMonthlyExpensesByVendorDisplayed(){
        return ReportsPage.isMonthlyExpensesByVendorDisplayed();
    }

    public static void selectCsv(){
        ReportsPage.clickOnDropdownTable();
        ReportsPage.clickOnCsv();
    }

    public static boolean isCSVTextDisplayed(){
        return ReportsPage.isCSVTextDisplayed();
    }
}
