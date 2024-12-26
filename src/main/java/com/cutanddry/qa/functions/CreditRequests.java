package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CreditRequestsPage;

public class CreditRequests {
    static CreditRequestsPage creditRequestsPage = new CreditRequestsPage();

    public static void clickReportIssue(){
        creditRequestsPage.clickReportIssue();
    }
    public static boolean isReportIssueSectionDisplayed(){
        return creditRequestsPage.isReportIssueSectionDisplayed();
    }
    public static void clickOneItem(){
        creditRequestsPage.clickOneItem();
    }
    public static boolean isIssuePopUpDisplayed(){
        return creditRequestsPage.isIssuePopUpDisplayed();
    }
    public static void clickIssueOption() throws InterruptedException{
        creditRequestsPage.clickIssueOption();
    }
    public static void clickContinue(){
        creditRequestsPage.clickContinue();
    }
    public static boolean isCreditRequestedDisplayed(){
        return creditRequestsPage.isCreditRequestedDisplayed();
    }
    public static void clickSaveCheckIn(){
        creditRequestsPage.clickSaveCheckIn();
    }
    public static boolean isSubmitCreditRequestPopupDisplayed(){
        return creditRequestsPage.isSubmitCreditRequestPopupDisplayed();
    }
    public static void clickYes(){
        creditRequestsPage.clickYes();
    }
    public static boolean isCreditRequestSentPopupDisplayed(){
        return creditRequestsPage.isCreditRequestSentPopupDisplayed();
    }
    public static void clickClose(){
        creditRequestsPage.clickClose();
    }
    public static boolean isCreditStatusRequestedDisplay(){
        return creditRequestsPage.isCreditStatusRequestedDisplay();
    }
    //--------------
    public static boolean isCreditRequestSectionDisplay(){
        return creditRequestsPage.isCreditRequestSectionDisplay();
    }
    public static void clickCreditRequest(){creditRequestsPage.clickCreditRequest();}
    public static boolean isOrderCreditRequestSectionDisplay(){
        return creditRequestsPage.isOrderCreditRequestSectionDisplay();
    }
    public static void clickProcessCredit(){creditRequestsPage.clickProcessCredit();}
    public static boolean isProcessCreditSectionDisplay(){
        return creditRequestsPage.isProcessCreditSectionDisplay();
    }
    public static void clickSelectItem(){creditRequestsPage.clickSelectItem();}
    public static void clickApproveCredit(){creditRequestsPage.clickApproveCredit();}
    public static boolean isApproveCreditPopUpDisplay(){
        return creditRequestsPage.isApproveCreditPopUpDisplay();
    }
    public static void clickSubmit(){creditRequestsPage.clickSubmit();}
    public static boolean isConfirmApprovalPopUpDisplay(){
        return creditRequestsPage.isConfirmApprovalPopUpDisplay();
    }
    public static void clickConfirm(){creditRequestsPage.clickConfirm();}
    public static boolean isCreditRequestApprovedPopUpDisplay(){
        return creditRequestsPage.isCreditRequestApprovedPopUpDisplay();
    }
    public static boolean isCreditApprovedDisplay(){
        return creditRequestsPage.isCreditApprovedDisplay();
    }

    public static void clickDeclineCredit(){creditRequestsPage.clickDeclineCredit();}
    public static boolean isDeclineCreditPopUpDisplay(){
        return creditRequestsPage.isDeclineCreditPopUpDisplay();
    }
    public static boolean isConfirmDeclinePopUpDisplay(){
        return creditRequestsPage.isConfirmDeclinePopUpDisplay();
    }
    public static boolean isCreditRequestDeclinedPopUpDisplay(){
        return creditRequestsPage.isCreditRequestDeclinedPopUpDisplay();
    }
    public static boolean isCreditDeclinedDisplay(){
        return creditRequestsPage.isCreditDeclinedDisplay();
    }
   public static String getCreditItemName() throws InterruptedException {
        return creditRequestsPage.getCreditItemName();
    }
    public static String getItemCode() throws InterruptedException {
        return creditRequestsPage.getItemCode();
    }
    public static String getItemPrice() throws InterruptedException {
        return creditRequestsPage.getItemPrice();
    }
    public static String getItemQuantity() throws InterruptedException {
        return creditRequestsPage.getItemQuantity();
    }
    public static String getItemIssue() throws InterruptedException {
        return creditRequestsPage.getItemIssue();
    }
    public static String getItemTotal() throws InterruptedException {
        return creditRequestsPage.getItemTotal();
    }
    public static String getItemCredit() throws InterruptedException {
        return creditRequestsPage.getItemCredit();
    }

    public static String getCreditItemNameDP() throws InterruptedException {
        return creditRequestsPage.getCreditItemNameDP();
    }
    public static String getItemCodeDP() throws InterruptedException {
        return creditRequestsPage.getItemCodeDP();
    }
    public static String getItemPriceDP() throws InterruptedException {
        return creditRequestsPage.getItemPriceDP();
    }
    public static String getItemQuantityDP() throws InterruptedException {
        return creditRequestsPage.getItemQuantityDP();
    }
    public static String getItemIssueDP() throws InterruptedException {
        return creditRequestsPage.getItemIssueDP();
    }
    public static String getItemTotalDP() throws InterruptedException {
        return creditRequestsPage.getItemTotalDP();
    }
    public static String getItemCreditDP() throws InterruptedException {
        return creditRequestsPage.getItemCreditDP();
    }



}
