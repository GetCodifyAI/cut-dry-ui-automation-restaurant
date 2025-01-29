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
    public String getReferenceNum() throws InterruptedException {
        restaurantUI.waitForVisibility(referenceNum);
        restaurantUI.waitForCustom(3000);
        String referenceNumOP = restaurantUI.getText(referenceNum);
        return referenceNumOP.substring(1);
    }
    public void clickTrashIcon()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_trash);
        restaurantUI.click(btn_trash);
    }
    public boolean isDraftsDeleteTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_delete);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_delete);
    }
    public void clickYesButton()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_yes);
        restaurantUI.click(btn_yes);
    }
    public boolean isDraftDeleteConfirmationDisplayed(String text){
        try {
            restaurantUI.waitForVisibility(By.xpath(confirmationModel.replace("TEXT", text)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(confirmationModel.replace("TEXT", text)));
    }
    public boolean isReferenceNumberDisplayed(String number){
        try {
            restaurantUI.waitForVisibility(By.xpath(txt_reference.replace("TEXT", number)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(txt_reference.replace("NUMBER", number)));
    }

}
