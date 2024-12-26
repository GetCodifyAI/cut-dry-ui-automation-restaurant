package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.DraftsPage;

public class Drafts {
    static DraftsPage draftsPage = new DraftsPage();

    public static void selectFirstDraftOrder(String Supplier){
        draftsPage.clickFirstDraftOrder(Supplier);
    }


}
