package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DraftsPage extends LoginPage{
    String firstDraftOrder = "(//td[contains(text(),'SUPPLIER')]/parent::tr[contains(@href,'/place-order')])[1]";
    By txt_drafts = By.xpath("//li[contains(text(),'Drafts')]");
    String txt_lastDraft = "(//tbody/tr[contains(@href, 'place-order') and contains(@href, 'draftId')]/td[9][contains(text(), 'TOTAL')])[1]";
    By btn_editOrder = By.xpath("//a[contains(text(),'Edit Order')]");


    public void clickFirstDraftOrder(String SupplierName){
        restaurantUI.click(By.xpath(firstDraftOrder.replace("SUPPLIER",SupplierName)));
    }
    public boolean isDraftsTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_drafts);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_drafts);
    }
    public boolean isLastDraftDisplayed(String total){
        restaurantUI.waitForVisibility(By.xpath(txt_lastDraft.replace("TOTAL", total)));
        return restaurantUI.isDisplayed(By.xpath(txt_lastDraft.replace("TOTAL", total)));
    }
    public void clickDraft(String total){
        restaurantUI.click(By.xpath(txt_lastDraft.replace("TOTAL", total)));
    }
    public void clickEditOrder(){
        restaurantUI.click(btn_editOrder);
    }

}
