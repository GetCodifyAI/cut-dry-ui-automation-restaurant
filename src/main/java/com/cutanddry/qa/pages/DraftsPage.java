package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class DraftsPage extends LoginPage{
    String firstDraftOrder = "(//td[contains(text(),'SUPPLIER')]/parent::tr[contains(@href,'/place-order')])[1]";
    By txt_drafts = By.xpath("//li[contains(text(),'Drafts')]");
    String txt_lastDraft = "(//tbody/tr[contains(@href, 'place-order') and contains(@href, 'draftId')]//td[contains(text(), 'TOTAL')])[1]";
    By btn_editOrder = By.xpath("//a[contains(text(),'Edit Order')]");
    By referenceNum = By.xpath("(//tbody/tr[contains(@href, 'place-order') and contains(@href, 'draftId')]//td[3])[1]");
    By btn_trash = By.xpath("(//button[@type='button']//*[local-name()='svg' and @data-icon='cdTrash'])[1]");
    By txt_delete = By.xpath("//h2[contains(text(),'Delete Draft Permanently?')]");
    String confirmationModel = "//div[contains(text(),'TEXT')]";
    By btn_yes = By.xpath("//button[contains(text(),'Yes')]");
    String txt_reference = "//td[text()='NUMBER']";
    String txt_lastDraftDisplay = "(//tbody/tr[contains(@href, '/place-order/') and contains(@href, 'draftId')]/td[contains(text(), 'TOTAL')])[1]/../td[1]/div[contains(text(),'DATE')]";
    String draftRetentionMsg = "//div[contains(text(),'DRAFTMSG')]";



    public void clickFirstDraftOrder(String SupplierName){
        getRestaurantUI().click(By.xpath(firstDraftOrder.replace("SUPPLIER",SupplierName)));
    }
    public boolean isDraftsTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_drafts);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_drafts);
    }
    public boolean isLastDraftDisplayed(String total){
        getRestaurantUI().waitForVisibility(By.xpath(txt_lastDraft.replace("TOTAL", total)));
        return getRestaurantUI().isDisplayed(By.xpath(txt_lastDraft.replace("TOTAL", total)));
    }
    public void clickDraft(String total){
        getRestaurantUI().click(By.xpath(txt_lastDraft.replace("TOTAL", total)));
    }
    public void clickEditOrder(){
        getRestaurantUI().click(btn_editOrder);
    }
    public String getReferenceNum() throws InterruptedException {
        getRestaurantUI().waitForVisibility(referenceNum);
        getRestaurantUI().waitForCustom(3000);
        String referenceNumOP = getRestaurantUI().getText(referenceNum);
        return referenceNumOP.substring(1);
    }
    public void clickTrashIcon()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_trash);
        getRestaurantUI().click(btn_trash);
    }
    public boolean isDraftsDeleteTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_delete);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_delete);
    }
    public void clickYesButton()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_yes);
        getRestaurantUI().click(btn_yes);
    }
    public boolean isDraftDeleteConfirmationDisplayed(String text){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(confirmationModel.replace("TEXT", text)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(confirmationModel.replace("TEXT", text)));
    }
    public boolean isReferenceNumberDisplayed(String number){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(txt_reference.replace("TEXT", number)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(txt_reference.replace("NUMBER", number)));
    }
    public void clickFirstDraft()throws InterruptedException{
        getRestaurantUI().waitForVisibility(referenceNum);
        getRestaurantUI().click(referenceNum);
    }
    public boolean isLastDraftStatusDisplayed(String total,String date){
        getRestaurantUI().waitForVisibility(By.xpath(txt_lastDraftDisplay.replace("TOTAL", total).replace("DATE",date)));
        return getRestaurantUI().isDisplayed(By.xpath(txt_lastDraftDisplay.replace("TOTAL", total).replace("DATE",date)));
    }
    public boolean isDraftRetentionMessageDisplayed(String message) {
        getRestaurantUI().waitForVisibility(By.xpath(draftRetentionMsg.replace("DRAFTMSG", message)));
        return getRestaurantUI().isDisplayed(By.xpath(draftRetentionMsg.replace("DRAFTMSG", message)));
    }
}
