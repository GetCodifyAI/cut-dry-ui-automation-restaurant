package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CreditRequestsPage;

public class CreditRequests {

    static CreditRequestsPage creditRequestsPage = new CreditRequestsPage();

    public static void changeRequestDate(String time_range) {
        creditRequestsPage.clickOnRequestDate();
        creditRequestsPage.selectTimeRange(time_range);
    }

    public static void searchOrderID(String orderID) throws InterruptedException{
        creditRequestsPage.clickOnSearch();
        creditRequestsPage.typeOnSearch(orderID);
    }

    public static boolean checkIfSearchedElementVisible(String orderID){
        return creditRequestsPage.checkIfSearchedElementVisible(orderID);
    }

    public static void clickOnFirstItem(){
        creditRequestsPage.clickOnFirstItem();
    }

    public static void clickOnItem(){
        creditRequestsPage.clickOnItems();
    }

    public static boolean checkIfItemSectionVisible(){
        return creditRequestsPage.checkIfItemSectionVisible();
    }

    public static boolean isErrorTextNotDisplayed(){
        return creditRequestsPage.isErrorTextNotDisplayed();
    }
}
