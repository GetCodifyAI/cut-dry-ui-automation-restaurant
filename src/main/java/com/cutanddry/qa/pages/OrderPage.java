package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class OrderPage extends LoginPage{
    By btn_addNewSupplier = By.xpath("//span[text()='Add a new supplier']");
    String addedNewSupplier = "//td//div[contains(text(), 'SUPPLIER')]";
    By btn_order = By.xpath("//div[normalize-space(text()) = 'Order']");
    By txt_placeOrder = By.xpath("//div[contains(@class,'py-3') and text()='Place Order']");
    By btn_finishSetup = By.xpath("//td//div[contains(text(), 'TestSupplier3')]/../../../following-sibling::td//button[contains(text(),'Finish Setup')]");
    By txt_editOrderGuide =By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_uploadFile = By.xpath("//button[contains(text(), 'Upload File')]");
    By btn_next = By.xpath("//button[contains(text(), 'Next')]");
    By btn_confirm = By.xpath("//button[contains(text(), 'Confirm')]");
    By btn_ok = By.xpath("//button[contains(text(), 'OK')]");
    By lbl_itemName = By.xpath("//strong[contains(text(), 'Item Name')]");
    By btn_threeDotDropDown =  By.xpath("//td//div[contains(text(), 'TestSupplier3')]/../../../following-sibling::td//button[contains(@id,'dropdown-basic')]");
    By btn_editSupplierOption = By.xpath("//span[contains(text(), 'Edit Supplier')]");

    public void clickAddNewSupplier(){
        restaurantUI.click(btn_addNewSupplier);
    }
    public boolean isAddedNewSupplierDisplayed(String supplier)throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
        return restaurantUI.isDisplayed(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickOrder(){
        restaurantUI.click(btn_order);
    }
    public boolean isPlaceOrderTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_placeOrder);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_placeOrder);
    }
    public void clickOnOneSupplier(String supplier) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
        restaurantUI.click(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickFinishSetup(){
        restaurantUI.click(btn_finishSetup);
    }
    public boolean isNavigateEditOrderGuide(){
        try {
            restaurantUI.waitForVisibility(txt_editOrderGuide);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_editOrderGuide);
    }
    public void clickUploadFile(){
        restaurantUI.click(btn_uploadFile);
    }
    public void clickNext(){
        restaurantUI.click(btn_next);
    }
    public void clickConfirm(){
        restaurantUI.click(btn_confirm);
    }
    public void clickOK()throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        restaurantUI.click(btn_ok);
    }
    public boolean isNewlyAddedOrderGuideDisplayed(){
        try {
            restaurantUI.waitForVisibility(lbl_itemName);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(lbl_itemName);
    }
    public void clickThreeDotDropDown(){
        restaurantUI.click(btn_threeDotDropDown);
    }
    public void clickEditSupplierOption()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_editSupplierOption);
        restaurantUI.click(btn_editSupplierOption);
    }




}
