package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.HistoryPage;


public class History {

    static HistoryPage historyPage = new HistoryPage();

    public static void goToHistory(){
        historyPage.clickHistory();
    }
    public static boolean isUserNavigatedToHistory(){
        return historyPage.isHistoryTextDisplayed();
    }
    public static void searchOrderID(String orderID) throws InterruptedException{
        historyPage.clickOnSearch();
        historyPage.typeOnSearch(orderID);
    }
    public static boolean checkIfSearchedElementVisible(String orderID){
        return historyPage.checkIfSearchedElementVisible(orderID);
    }
    public static void clickOnFirstItemOfOrderHistory(){
        historyPage.clickOnFirstItemOfOrderHistory();
    }
    public static boolean isErrorTextNotDisplayed(){
        return historyPage.isErrorTextNotDisplayed();
    }
    public static void clickOnItems(){
        historyPage.clickOnItems();
    }
    public static boolean checkIfItemSectionVisible(){
        return historyPage.checkIfItemSectionVisible();
    }
    public static void clickOnTimeline(){
        historyPage.clickOnTimeline();
    }
    public static boolean checkIfTimelineSectionVisible(){
        return historyPage.checkIfTimelineSectionVisible();

    }
    public static void clickOnMoreFilters(){
         historyPage.clickOnMoreFilters();
    }
    public static boolean isFilterOrdersPopupDisplayed() {
        return historyPage.isFilterOrdersPopupDisplayed();
    }
    public static void clickLocation(){
        historyPage.clickLocation();
    }

}
