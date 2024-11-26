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


}
