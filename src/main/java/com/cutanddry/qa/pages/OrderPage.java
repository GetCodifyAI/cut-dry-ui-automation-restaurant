package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class OrderPage extends LoginPage{
    By btn_addNewSupplier = By.xpath("//span[text()='Add a new supplier']");
    String addedNewSupplier = "//td//div[contains(text(), 'SUPPLIER')]";
    By btn_order = By.xpath("(//div[normalize-space(text()) = 'Order'])[1]");
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
    By btn_checkIn = By.xpath("//span[contains(text(),'Check-In Order')]");
    String checkInTitle = "//h2[contains(text(),'Check-In Order #ORDER_ID')]";
    By btn_checkInAll = By.xpath("//button[contains(text(),'Check-In All')]");
    By lbl_checkInAllPopup = By.xpath("//h2[contains(text(),'Check-in all items?')]");
    String lbl_orderStatus = "//span[text()='Status']/following-sibling::span[text()='STATUS']";
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
    By btn_FindMoreInCatalog = By.xpath("//button[text()='Find More in Catalog']");
    By lbl_inactiveItemDetected = By.xpath("//div[normalize-space()='Inactive Items Removed']");
    String threeDotDropDownOption = "//span[contains(text(), 'OPTION')]";
    By btn_editGuideOption = By.xpath("//span[contains(text(), 'Edit Guide')]");
    By selectLocation = By.xpath("//div[contains(text(),'Select Location')]");
    String selectLocationSupplier = "//div[contains(text(),'Select Location')]/following-sibling::div//div[text()='LOCATION']";
    By btn_viewCatalogOption = By.xpath("//span[contains(text(), 'View Catalog')]");




    public void clickAddNewSupplier(){
        getRestaurantUI().click(btn_addNewSupplier);
    }
    public boolean isAddedNewSupplierDisplayed(String supplier)throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForVisibility(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
        return getRestaurantUI().isDisplayed(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickOrder(){
        getRestaurantUI().clickWithFallback(btn_order);
    }
    public boolean isPlaceOrderTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_placeOrder);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_placeOrder);
    }
    public void clickOnOneSupplier(String supplier) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForVisibility(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
        getRestaurantUI().click(By.xpath(addedNewSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickFinishSetup(String supplier)throws InterruptedException{
        getRestaurantUI().click(By.xpath(btn_finishSetup.replace("SUPPLIER",supplier)));
    }
    public boolean isNavigateEditOrderGuide(){
        try {
            getRestaurantUI().waitForVisibility(txt_editOrderGuide);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_editOrderGuide);
    }
    public void clickUploadFile(){
        getRestaurantUI().click(btn_uploadFile);
    }
    public void clickNext(){
        getRestaurantUI().click(btn_next);
    }
    public void clickConfirm(){
        getRestaurantUI().click(btn_confirm);
    }
    public void clickOK()throws InterruptedException{
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().click(btn_ok);
    }
    public boolean isNewlyAddedOrderGuideDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(lbl_itemName);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(lbl_itemName);
    }
    public void clickThreeDotDropDown(String supplier)throws InterruptedException{
        getRestaurantUI().click(By.xpath(btn_threeDotDropDown.replace("SUPPLIER",supplier)));
    }
    public void clickEditSupplierOption()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_editSupplierOption);
        getRestaurantUI().click(btn_editSupplierOption);
    }
    public void clickCreateItems(){
        getRestaurantUI().waitForVisibility(btn_createItems);
        getRestaurantUI().click(btn_createItems);
    }
    public boolean isAddItemToOrderGuidePopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_addItemToOrderGuide);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_addItemToOrderGuide);
    }
    public void addItemName(String itemName) throws InterruptedException {
        getRestaurantUI().clear(addItemName);
        getRestaurantUI().sendKeys(addItemName,itemName);
    }
    public void addItemCode(String itemCode) throws InterruptedException {
        getRestaurantUI().clear(addItemCode);
        getRestaurantUI().sendKeys(addItemCode,itemCode);
    }
    public void addItemPrice(String itemPrice) throws InterruptedException {
        getRestaurantUI().clear(addPrice);
        getRestaurantUI().sendKeys(addPrice,itemPrice);
    }
    public void addItemPar(String itemPar) throws InterruptedException {
        getRestaurantUI().clear(addPar);
        getRestaurantUI().sendKeys(addPar,itemPar);
    }
    public void clickAccountingCategoryDropDown()throws InterruptedException {
        getRestaurantUI().click(accountingCategoryDropDown);
    }
    public void clickAccountingCategoryOption()throws InterruptedException {
        getRestaurantUI().waitForVisibility(accountingCategoryOption);
        getRestaurantUI().click(accountingCategoryOption);
    }
    public void clickSaveItem()throws InterruptedException {
        getRestaurantUI().waitForClickability(btn_saveItem);
        getRestaurantUI().click(btn_saveItem);
    }
    public void clickLocationFilter(){
        getRestaurantUI().click(locationFilter);
    }
    public void clickOnLocationOption(String location) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().waitForVisibility(By.xpath(locationOption.replace("LOCATION",location)));
        getRestaurantUI().click(By.xpath(locationOption.replace("LOCATION",location)));
    }
    public boolean isLocationFilterWork(String location){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(addedLocation.replace("LOCATION",location)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(addedLocation.replace("LOCATION",location)));
    }
    public void clickOnCheckIn() {
        getRestaurantUI().waitForClickability(btn_checkIn);
        getRestaurantUI().click(btn_checkIn);
    }
    public boolean isCheckInOrderIdDisplayed(String orderId) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(checkInTitle.replace("ORDER_ID", orderId)));
        getRestaurantUI().waitForCustom(4000);
        return getRestaurantUI().isDisplayed(By.xpath(checkInTitle.replace("ORDER_ID", orderId)));
    }
    public void clickOnCheckInAll() {
        getRestaurantUI().waitForClickability(btn_checkInAll);
        getRestaurantUI().click(btn_checkInAll);
    }
    public boolean isCheckInAllPopupDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(lbl_checkInAllPopup);
            return getRestaurantUI().isDisplayed(lbl_checkInAllPopup);
        } catch (Exception e) {
            return false;
        }
    }
    public boolean isOrderStatusDisplayed(String status) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(lbl_orderStatus.replace("STATUS", status)));
        getRestaurantUI().waitForCustom(4000);
        return getRestaurantUI().isDisplayed(By.xpath(lbl_orderStatus.replace("STATUS", status)));
    }
    public void clickChatSupplierOption()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_chatSupplierOption);
        getRestaurantUI().click(btn_chatSupplierOption);
    }
    public boolean isChatOptionDisplay(){
        return getRestaurantUI().isDisplayed(btn_chatSupplierOption);
    }
    public boolean isAreYouSurePopUpDisplayed(){
        return getRestaurantUI().isDisplayed(areYouSurePopUp);
    }

    public void clickYes() throws InterruptedException {
        getRestaurantUI().click(btn_yes);
        getRestaurantUI().waitForCustom(1000);
    }
    public void editOrderGuideName(String name) throws InterruptedException {
        getRestaurantUI().clear(lbl_orderGuideName);
        getRestaurantUI().sendKeys(lbl_orderGuideName, name);
        getRestaurantUI().waitForCustom(1000);
    }
    public void editOrderGuideDescription(String name) throws InterruptedException {
        getRestaurantUI().clear(lbl_orderGuideDescription);
        getRestaurantUI().sendKeys(lbl_orderGuideDescription, name);
        getRestaurantUI().waitForCustom(1000);
    }
    public void clickOnSave(){
        getRestaurantUI().waitForVisibility(btn_save);
        getRestaurantUI().clickWithFallback(btn_save);
    }
    public boolean editedOrderGuideNameDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(editedOrderGuide.replace("NAME",name)));
    }
    public boolean editedOrderGuideDescriptionDisplay(String name){
        return getRestaurantUI().isDisplayed(By.xpath(editedOrderGuideDescription.replace("NAME",name)));
    }
    public void removeOrderGuideLocation()throws InterruptedException{
        getRestaurantUI().click(lbl_orderGuideLocation);
    }
    public void clickOrderGuideLocationDropDown()throws InterruptedException{
        getRestaurantUI().click(orderGuideLocationDropDown);
    }
    public void clickOrderGuideLocationDropDownOption()throws InterruptedException{
        getRestaurantUI().click(orderGuideLocationDropDownOption);
    }
    public void  clickFindMoreInCatalog()throws InterruptedException{
        getRestaurantUI().scrollToElement(btn_FindMoreInCatalog);
        getRestaurantUI().click(btn_FindMoreInCatalog);
    }
    public boolean isInactiveItemDetectedPopUpDisplay()throws InterruptedException{
        getRestaurantUI().waitForVisibility(lbl_inactiveItemDetected);
        return getRestaurantUI().isDisplayed(lbl_inactiveItemDetected);
    }
    public boolean isThreeDotDropDownOptionDisplayed(String option)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(threeDotDropDownOption.replace("OPTION",option)));
    }
    public void clickEditGuideOption()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_editGuideOption);
        getRestaurantUI().click(btn_editGuideOption);
    }
    public boolean isSelectLocationPopUpDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(selectLocation);
    }
    public void selectLocationSupplier(String location){
        getRestaurantUI().click(By.xpath(selectLocationSupplier.replace("LOCATION",location)));
    }
    public void clickViewCatalogOption()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_viewCatalogOption);
        getRestaurantUI().click(btn_viewCatalogOption);
    }





}
