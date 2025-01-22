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

    public static void selectTheReport(String report){
        ReportsPage.clickOnDropdownReportType();
        ReportsPage.clickOnReportTypeOption(report);
    }
    public static void clickOnDropdownReportType(){
        ReportsPage.clickOnDropdownReportType();
    }
    public static boolean isReportTypeDisplayed(String txt){
        return ReportsPage.isReportTypeDisplayed(txt);
    }
    public static boolean isGeneratedReportDisplayed(String report){
        return ReportsPage.isGeneratedReportDisplayed(report);
    }

    public static void selectCsv(){
        ReportsPage.clickOnDropdownTable();
        ReportsPage.clickOnCsv();
    }

    public static boolean isCSVTextDisplayed(){
        return ReportsPage.isCSVTextDisplayed();
    }

    public static void turnOnReportsForWhiteLabelCustomersFromGateKeeperIfNotEnabled(){
        ReportsPage.turnOnReportsForWhiteLabelCustomers();
    }
    public static void searchData(String text){
        ReportsPage.searchData(text);
    }
    public static boolean isSearchResultDisplayed(String result){
        return ReportsPage.isSearchResultDisplayed(result);
    }
}
