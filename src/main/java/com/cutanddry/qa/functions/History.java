package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.HistoryPage;


public class History {

    static HistoryPage historyPage = new HistoryPage();
    public static void clickClose(){
        historyPage.clickClose();
    }

    public static void goToHistory(){
        historyPage.clickHistory();
    }
    public static boolean isUserNavigatedToHistory(){
        return historyPage.isHistoryTextDisplayed();
    }
    public static boolean isOrderSectionDisplayed(){
        return historyPage.isOrderSectionDisplayed();
    }
    public static void searchOrderID(String orderID) throws InterruptedException{
        historyPage.clickOnSearch();
        historyPage.typeOnSearch(orderID);
    }
    public static boolean checkIfSearchedElementVisible(String orderID){
        return historyPage.checkIfSearchedElementVisible(orderID);
    }
    public static boolean checkIfFilteredElementVisible(String location){
        return historyPage.checkIfFilteredElementVisible(location);
    }

    public static void clickOnFirstItemOfOrderHistory(){
        historyPage.clickOnFirstItemOfOrderHistory();
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
    public static void clickOption(){
        historyPage.clickOption();
    }
    public static void clickSave(){
        historyPage.clickSave();
    }
    public static void clickMoreOptions(){
        historyPage.clickMoreOptions();
    }
    public static void clickPrintOrder(){
        historyPage.clickPrintOrder();
    }
    public static void clickAddNotes(){
        historyPage.clickAddNotes();
    }
    public static boolean isAddNotePopUpWindowDisplayed(){
        return historyPage.isAddNotePopUpWindowDisplayed();
    }
    public static void typeOrderNote(String orderNote) throws InterruptedException{
        historyPage.clickTextarea();
        historyPage.typeOrderNote(orderNote);
    }
    public static void clickSaveChanges(){
        historyPage.clickSaveChanges();
    }
    public static boolean checkOrderNoteVisible(String orderNote){
        return historyPage.checkOrderNoteVisible(orderNote);
    }
    public static void clickCheckIn(){
        historyPage.clickCheckIn();
    }
    public static boolean isCheckInOrderSectionDisplayed(){
        return historyPage.isCheckInOrderSectionDisplayed();
    }
    public static void clickCheckInAll(){
        historyPage.clickCheckInAll();
    }
    public static boolean isCheckInAllPopupDisplayed(){
        return historyPage.isCheckInAllPopupDisplayed();
    }
    public static void clickConfirm(){
        historyPage.clickConfirm();
    }
    public static boolean isCheckInOrderStatusDisplayed(){
        return historyPage.isCheckInOrderStatusDisplayed();
    }
    public static void clickCancel(){
        historyPage.clickCancel();
    }
    public static boolean isCancelOrderPopUpDisplayed(){
        return historyPage.isCancelOrderPopUpDisplayed();
    }
    public static void clickConfirmCancelOrder(){
        historyPage.clickConfirmCancelOrder();
    }
    public static void clickEditOrder(){
        historyPage.clickEditOrder();
    }
    public static boolean isEditOrderPopUpDisplayed(){
        return historyPage.isEditOrderPopUpDisplayed();
    }
    public static void clickConfirmEditOrder(){
        historyPage.clickConfirmEditOrder();
    }
    public static boolean isReviewOrderTextDisplayed(){
        return historyPage.isReviewOrderTextDisplayed();
    }
    public static void increaseFirstRowQtyByOne() throws InterruptedException {
        historyPage.increaseFirstRowQtyByOne();
    }
    public static void clickSubmitEditOrder(){
        historyPage.clickSubmitEditOrder();
    }
    public static boolean isOrderEditRequestPopupDisplayed(){
        return historyPage.isOrderEditRequestPopupDisplayed();
    }
    public static void clickOkEditOrder(){
        historyPage.clickOkEditOrder();
    }
    public static void clickRecreateOrder(){
        historyPage.clickRecreateOrder();
    }

}
