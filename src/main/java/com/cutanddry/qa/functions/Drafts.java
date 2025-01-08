package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DraftsPage;

public class Drafts {
    static DraftsPage draftsPage = new DraftsPage();

    public static void selectFirstDraftOrder(String Supplier){
        draftsPage.clickFirstDraftOrder(Supplier);
    }
    public static boolean isUserNavigatedToDrafts(){
        return draftsPage.isDraftsTextDisplayed();
    }
    public static boolean isLastDraftDisplayed(String total){
        return draftsPage.isLastDraftDisplayed(total);
    }
    public static void clickDraft(String total){
        draftsPage.clickDraft(total);
    }
    public static void clickEditOrder(){
        draftsPage.clickEditOrder();
    }


}
