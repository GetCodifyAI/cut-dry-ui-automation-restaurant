package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class OrderPage extends LoginPage{
    By btn_addNewSupplier = By.xpath("//span[text()='Add a new supplier']");
    String addedNewSupplier = "//td//div[contains(text(), 'SUPPLIER')]";
    By btn_order = By.xpath("//div[normalize-space(text()) = 'Order']");
    By txt_placeOrder = By.xpath("//div[contains(@class,'py-3') and text()='Place Order']");
    String btn_finishSetup = "//td//div[contains(text(), 'SUPPLIER')]/../../../following-sibling::td//button[contains(text(),'Finish Setup')]";
    By txt_editOrderGuide =By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_uploadFile = By.xpath("//button[contains(text(), 'Upload File')]");
    By btn_next = By.xpath("//button[contains(text(), 'Next')]");
    By btn_confirm = By.xpath("//button[contains(text(), 'Confirm')]");
    By btn_ok = By.xpath("//button[contains(text(), 'OK')]");
    By lbl_itemName = By.xpath("//strong[contains(text(), 'Item Name')]");
    String btn_threeDotDropDown = "//td//div[contains(text(), 'SUPPLIER')]/../../../following-sibling::td//button[contains(@id,'dropdown-basic')]";
    By btn_editSupplierOption = By.xpath("//span[contains(text(), 'Edit Supplier')]");
    By btn_createItems = By.xpath("//button[contains(text(), 'Create Items')]");
    By txt_addItemToOrderGuide = By.xpath("//div[contains(text(), 'Add Item To Order Guide')]");
    By addItemName = By.xpath("//label[contains(text(), 'Item Name')]/following-sibling::input[contains(@id,'AddItemModalName')]");
    By addItemCode = By.xpath("//span[contains(text(), 'Item Code')]/../following-sibling::input[contains(@id,'AddItemModalItemCode')]");
    By addPrice = By.xpath("//span[contains(text(), 'Price')]/../../../following-sibling::tbody//tr//td[1]//input[contains(@id,'AddItemModalPricePar')]");
    By addPar = By.xpath("//span[contains(text(), 'Par')]/../../../following-sibling::tbody//tr//td[2]//input[contains(@id,'AddItemModalPricePar')]");
    By accountingCategoryDropDown = By.xpath("//span[contains(text(), 'Accounting Category')]/../following-sibling::div/div/div/div[contains(text(),'Select...')]");
    By accountingCategoryOption = By.xpath("//div[contains(text(), '5100 - Food Cost')]");
    By btn_saveItem = By.xpath("//button[contains(text(), 'Save Item')]");
    By locationFilter = By.xpath("//div[contains(@class, ' css-2b097c-container')]");
    String locationOption = "//div[contains(@class,'themed_select__option ') and contains(text(), 'LOCATION')]";
    String addedLocation = "//td//span[contains(text(), 'LOCATION')]";
    By btn_checkIn = By.xpath("//button[contains(text(),'Check-In Order')]");
    String checkInTitle = "//h2[contains(text(),'Check-In Order #ORDER_ID')]";
    By btn_checkInAll = By.xpath("//button[contains(text(),'Check-In All')]");
    By lbl_checkInAllPopup = By.xpath("//h2[contains(text(),'Check-in all items?')]");
    String lbl_orderStatus = "//div[contains(text(),'Order Status: STATUS')]";
    By btn_chatSupplierOption = By.xpath("//span[contains(text(), 'Chat')]");
    By areYouSurePopUp = By.xpath("//h2[text() = 'Are you sure?']");
    By btn_yes = By.xpath("//button[contains(text(),'Yes')]");
    By lbl_orderGuideName = By.xpath("//label[contains(text(),'Order Guide Name')]/following-sibling::input");
    By lbl_orderGuideDescription = By.xpath("//label[contains(text(),'Guide Description')]/following-sibling::input");
    By btn_save = By.xpath("//button[normalize-space(text())='Save']");
    String editedOrderGuide =  "//div[contains(text(), 'Order Guide:')]//following::div[contains(text(), 'NAME')]";
    String editedOrderGuideDescription =  "//div[contains(text(), 'NAME')]";
    By lbl_orderGuideLocation = By.xpath("//label[contains(text(),'Locations')]/following-sibling::*//div[text()='Main St']/following-sibling::div");
    By orderGuideLocationDropDown = By.xpath("//label[contains(text(),'Locations')]/following-sibling::div");
    By orderGuideLocationDropDownOption = By.xpath("//label[contains(text(),'Locations')]/following-sibling::*//div[text()='Main St']");



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
    public void clickFinishSetup(String supplier)throws InterruptedException{
        restaurantUI.click(By.xpath(btn_finishSetup.replace("SUPPLIER",supplier)));
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
    public void clickThreeDotDropDown(String supplier)throws InterruptedException{
        restaurantUI.click(By.xpath(btn_threeDotDropDown.replace("SUPPLIER",supplier)));
    }
    public void clickEditSupplierOption()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_editSupplierOption);
        restaurantUI.click(btn_editSupplierOption);
    }
    public void clickCreateItems(){
        restaurantUI.waitForVisibility(btn_createItems);
        restaurantUI.click(btn_createItems);
    }
    public boolean isAddItemToOrderGuidePopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_addItemToOrderGuide);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_addItemToOrderGuide);
    }
    public void addItemName(String itemName) throws InterruptedException {
        restaurantUI.clear(addItemName);
        restaurantUI.sendKeys(addItemName,itemName);
    }
    public void addItemCode(String itemCode) throws InterruptedException {
        restaurantUI.clear(addItemCode);
        restaurantUI.sendKeys(addItemCode,itemCode);
    }
    public void addItemPrice(String itemPrice) throws InterruptedException {
        restaurantUI.clear(addPrice);
        restaurantUI.sendKeys(addPrice,itemPrice);
    }
    public void addItemPar(String itemPar) throws InterruptedException {
        restaurantUI.clear(addPar);
        restaurantUI.sendKeys(addPar,itemPar);
    }
    public void clickAccountingCategoryDropDown()throws InterruptedException {
        restaurantUI.click(accountingCategoryDropDown);
    }
    public void clickAccountingCategoryOption()throws InterruptedException {
        restaurantUI.waitForVisibility(accountingCategoryOption);
        restaurantUI.click(accountingCategoryOption);
    }
    public void clickSaveItem()throws InterruptedException {
        restaurantUI.waitForClickability(btn_saveItem);
        restaurantUI.click(btn_saveItem);
    }
    public void clickLocationFilter(){
        restaurantUI.click(locationFilter);
    }
    public void clickOnLocationOption(String location) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(By.xpath(locationOption.replace("LOCATION",location)));
        restaurantUI.click(By.xpath(locationOption.replace("LOCATION",location)));
    }
    public boolean isLocationFilterWork(String location){
        try {
            restaurantUI.waitForVisibility(By.xpath(addedLocation.replace("LOCATION",location)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(addedLocation.replace("LOCATION",location)));
    }
    public void clickOnCheckIn() {
        restaurantUI.waitForClickability(btn_checkIn);
        restaurantUI.click(btn_checkIn);
    }
    public boolean isCheckInOrderIdDisplayed(String orderId) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(checkInTitle.replace("ORDER_ID", orderId)));
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(By.xpath(checkInTitle.replace("ORDER_ID", orderId)));
    }
    public void clickOnCheckInAll() {
        restaurantUI.waitForClickability(btn_checkInAll);
        restaurantUI.click(btn_checkInAll);
    }
    public boolean isCheckInAllPopupDisplayed() {
        try {
            restaurantUI.waitForVisibility(lbl_checkInAllPopup);
            return restaurantUI.isDisplayed(lbl_checkInAllPopup);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isOrderStatusDisplayed(String status) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(lbl_orderStatus.replace("STATUS", status)));
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(By.xpath(lbl_orderStatus.replace("STATUS", status)));
    }
    public void clickChatSupplierOption()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_chatSupplierOption);
        restaurantUI.click(btn_chatSupplierOption);
    }
    public boolean isChatOptionDisplay(){
        return restaurantUI.isDisplayed(btn_chatSupplierOption);
    }
    public boolean isAreYouSurePopUpDisplayed(){
        return restaurantUI.isDisplayed(areYouSurePopUp);
    }
    public void clickYes(){
        restaurantUI.click(btn_yes);
    }
    public void editOrderGuideName(String name) throws InterruptedException {
        restaurantUI.clear(lbl_orderGuideName);
        restaurantUI.sendKeys(lbl_orderGuideName, name);
        restaurantUI.waitForCustom(1000);
    }
    public void editOrderGuideDescription(String name) throws InterruptedException {
        restaurantUI.clear(lbl_orderGuideDescription);
        restaurantUI.sendKeys(lbl_orderGuideDescription, name);
        restaurantUI.waitForCustom(1000);
    }
    public void clickOnSave(){
        restaurantUI.waitForVisibility(btn_save);
        restaurantUI.clickWithFallback(btn_save);
    }
    public boolean editedOrderGuideNameDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(editedOrderGuide.replace("NAME",name)));
    }
    public boolean editedOrderGuideDescriptionDisplay(String name){
        return restaurantUI.isDisplayed(By.xpath(editedOrderGuideDescription.replace("NAME",name)));
    }
    public void removeOrderGuideLocation()throws InterruptedException{
        restaurantUI.click(lbl_orderGuideLocation);
    }
    public void clickOrderGuideLocationDropDown()throws InterruptedException{
        restaurantUI.click(orderGuideLocationDropDown);
    }
    public void clickOrderGuideLocationDropDownOption()throws InterruptedException{
        restaurantUI.click(orderGuideLocationDropDownOption);
    }





}
