package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CreditRequestsPage;

public class CreditRequests {

    static CreditRequestsPage creditRequestsPage = new CreditRequestsPage();

    public static void changeRequestDate(String time_range) throws InterruptedException {
        creditRequestsPage.clickOnRequestDate();
        creditRequestsPage.selectTimeRange(time_range);
    }

    public static void searchOrderID(String orderID) throws InterruptedException{
        creditRequestsPage.clickOnSearch();
        creditRequestsPage.typeOnSearch(orderID);
    }

    public static boolean checkIfElementVisible(String orderID){
        return creditRequestsPage.checkIfElementVisible(orderID);

    }
}
