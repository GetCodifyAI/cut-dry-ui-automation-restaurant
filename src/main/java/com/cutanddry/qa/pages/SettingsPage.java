package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class SettingsPage extends LoginPage{

    By btn_settings = By.xpath("//a[contains(text(), 'Settings')]");
    By btn_orders = By.xpath("(//a[@href='/settings/orders'])[2]");
    By tbx_cutOffTime = By.xpath("//input[@type='time']");
    By btn_saveChanges = By.xpath("//button[text()='Save Changes']");
    By profileBtn = By.xpath("//div[@class='fade _1v9d984k mt-5 show']//a[contains(text(),'Profile')]");
    By profileTextField = By.xpath("//label[contains(text(),'Name')]/following-sibling::div//input[@type='text']");
    By saveBtn = By.xpath("//button[contains(text(),'Save')]");
    By profileUpdateSuccessOverlay = By.xpath("//h2[contains(@class,'swal2-title') and contains(text(),'Profile updated successfully')]");
    By businessBtn = By.xpath("//div[@class='fade _1v9d984k mt-5 show']//a[contains(text(),'Business')]");
    By restaurantNameTextField = By.xpath("//label[contains(text(),'Name')]/following-sibling::div//input[@class='form-control']");
    By companyDetailsUpdateSuccessOverlay = By.xpath("//h2[contains(@class,'swal2-title') and contains(text(),'Company details successfully edited.')]");
    By removeLogoBtn = By.xpath("//button[@class='mt-2 btn btn-link' and contains(text(),'Remove')]");
    By logoImage = By.xpath("//img[contains(@src,'ordering-supplies-images')]");
    By BrowseImgBtn = By.xpath("//*/input[@type='file']");
    By locationsBtn = By.xpath("//div[@class='fade _1v9d984k mt-5 show']//a[contains(text(),'Locations')]");
    By addLocationBtn = By.xpath("//button[@class='px-4 btn btn-primary' and contains(text(),'Add Location')]");
    By locationNameTextField = By.xpath("//label[contains(text(),'Location Name')]/following-sibling::input[@type='text']");
    By addLocationTxt = By.xpath("//div[text()='Add Location']");
    By editLocationTxt = By.xpath("//div[text()='Edit Location']");
    By streetAddressTextField = By.xpath("//label[contains(text(),'Street Address')]/following-sibling::input[@type='text']");
    By getAddLocationBtnInOverlay = By.xpath("//button[@class='btn btn-primary btn-block' and contains(text(),'Add Location')]");
    By successOverlayDisplayed = By.xpath("//h2[@id='swal2-title' and contains(text(),'Success')]");
    String locationName = "//tr[@class='_13xlah4']/td[text()='LOCATIONNAME']";
    By deleteLocationBtn = By.xpath("//button[@class='btn btn-link' and contains(text(),'Delete Location')]");
    By deleteLocationOverlay = By.xpath("//h2[@id='swal2-title' and contains(text(),'Are you sure you want to delete this location?')]");
    By yesBtnInDeleteLocationOverlay = By.xpath("//button[@class='swal2-confirm _1fmw5qi order-2 swal2-styled' and contains(text(),'Yes')]");
    By accountingBtn = By.xpath("//div[@class='fade _1v9d984k mt-5 show']//a[contains(text(),'Accounting')]");
    By accountCatagory = By.xpath("//h5[text()='Accounting Categories']");
    By numberOfRows = By.xpath("//table[@class='table table-striped']/tbody/tr");
    By createCategoryBtn = By.xpath("//button[@class='btn btn-success' and contains(text(),'Create Category')]");
    By categoryCodeEmpty = By.xpath("(//table[@class='table table-striped']//tbody//tr//td//a[contains(text(),'Empty')])[1]");
    By categoryNameEmpty = By.xpath("(//a[@data-name='name' and text()='Empty'])[1]");
    By typeCategoryCode = By.xpath("//table[@class='table table-striped']//tbody//tr//td//form[@class='form-inline editableform']//input[@type='text']");
    By saveCreatedCategoryCode = By.xpath("//button[@type='submit' and contains(@class, 'editable-submit')]");
    String addedCategoryCodeOrName = "//table[@class='table table-striped']//tbody//tr//td//a[contains(text(),'CATEGORYCODE')]";
    String CategoryDeleteBtn = "//a[contains(text(),'CATEGORYNAME')]/parent::td/following-sibling::td//button[contains(@class, 'js_are_you_sure')]";
    By txt_profile = By.xpath("//h2[text()='Profile']");
    By txt_restaurant = By.xpath("//h2[text()='Company Settings']");
    By txt_locations = By.xpath("//h2[text()='Locations']");
    By btn_settings_ = By.xpath("//a[contains(@data-tip, 'Settings')]");
    By exportBtn = By.xpath("//div[@class='fade _1v9d984k mt-5 show']//a[contains(text(),'Export')]");
    By txt_exportData = By.xpath("//h2[text()='Export Data']");
    By selectExportTypeDropDown = By.xpath("//span[text()='Select Export Type']");
    String exportTypeOption = "//a[text()='TYPE']";
    By btn_generateExport = By.xpath("//button[text()='Generate Export']");
    By txt_orderSettings = By.xpath("//li[contains(text(),'Order Settings')]");
    By tbx_orderMinimum = By.xpath("//label[text()='Order Minimum ($)']/following-sibling::div//input");
    By sel_OrderMinimums = By.xpath("//span[text()='Order Minimums']/preceding-sibling::div/div[@class='react-switch-handle']");
    By orderMinimumToggleOrderSettingStable = By.xpath("//span[text()='Order Minimums']/preceding-sibling::div/div[@class='react-switch-handle']");
    By orderMinimumToggleOrderSettingStable1 = By.xpath("//span[text()='Order Minimums']/preceding-sibling::div/div[@class='react-switch-handle']/parent::div/div[1]");





    public void clickOnSettings(){
        restaurantUI.click(btn_settings);
    }
    public void clickOnSettingsBtn(){
        restaurantUI.click(btn_settings_);
    }
    public void clickOnOrders(){
        restaurantUI.click(btn_orders);
    }

    public void setTime(String time)throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.sendKeys(tbx_cutOffTime,time);
        restaurantUI.waitForCustom(4000);
    }

    public void clickOnSaveChanges()throws InterruptedException{
        restaurantUI.click(btn_saveChanges);
        restaurantUI.waitForCustom(4000);
    }

    public void clickOnProfile() throws InterruptedException {
        restaurantUI.click(profileBtn);
        restaurantUI.waitForCustom(3000);
    }

    public void editNameInProfile(String profileName){
        restaurantUI.sendKeys(profileTextField,profileName);
    }

    public void clickOnSave(){
        restaurantUI.click(saveBtn);
    }

    public boolean isProfileUpdateSuccessMessageDisplayed(){
        return restaurantUI.isDisplayed(profileUpdateSuccessOverlay);
    }


    public String getUpdateName(){
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.getAttributeValue(profileTextField,"value");
    }

    public void clickOnBusiness() throws InterruptedException {
        restaurantUI.click(businessBtn);
        restaurantUI.waitForCustom(1000);
    }

    public void editNameInRestaurant(String restaurantName){
        restaurantUI.sendKeys(restaurantNameTextField,restaurantName);
    }

    public boolean isCompanyDetailsUpdateSuccessMessageDisplayed(){
        return restaurantUI.isDisplayed(companyDetailsUpdateSuccessOverlay);
    }

    public String getUpdateRestName(){
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.getAttributeValue(restaurantNameTextField,"value");
    }

    public void clickOnRemoveLogoBtn(){
        restaurantUI.click(removeLogoBtn);
    }

    public boolean isLogoAvailable(){
        return restaurantUI.isDisplayed(logoImage);
    }

    public void fileUpload(String path) {
        restaurantUI.sendKeysHiddenElements(BrowseImgBtn, path);
    }

    public void clickOnLocationsBtn() throws InterruptedException {
        restaurantUI.click(locationsBtn);
        restaurantUI.waitForCustom(1000);
    }

    public void clickOnAddLocation(){
        restaurantUI.click(addLocationBtn);
    }

    public boolean isAddLocationOverlayDisplayed(){
        return restaurantUI.isDisplayed(addLocationTxt);
    }

    public boolean isEditLocationOverlayDisplayed(){
        return restaurantUI.isDisplayed(editLocationTxt);
    }

    public void typeLocationName(String locationName){
        restaurantUI.sendKeys(locationNameTextField,locationName);
    }

    public void typeStreetAddress(String streetAddress){
        restaurantUI.sendKeys(streetAddressTextField,streetAddress);
    }

    public void clickOnAddLocationOnOverlay(){
        restaurantUI.click(getAddLocationBtnInOverlay);
    }

    public boolean isSuccessOverlayDisplayed(){
        return restaurantUI.isDisplayed(successOverlayDisplayed);
    }

    public boolean isAddedLocationDisplayed(String location){
        return restaurantUI.isDisplayed(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public boolean isEditedLocationDisplayed(String location){
        return restaurantUI.isDisplayed(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public void clickTheLocationOnGrid(String location){
        restaurantUI.click(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public void clickOnDeleteLocation(){
        restaurantUI.click(deleteLocationBtn);
    }

    public boolean isDeleteLocationOverlayDisplayed(){
        return restaurantUI.isDisplayed(deleteLocationOverlay);
    }

    public void clickOnYesBtn(){
        restaurantUI.click(yesBtnInDeleteLocationOverlay);
    }

    public void clickOnAccountingBtn(){
        restaurantUI.click(btn_settings);
        restaurantUI.click(accountingBtn);
    }
    public boolean isNavigatedToAccountingCatagory(){
        return restaurantUI.isDisplayed(accountCatagory);
    }
    public boolean isNavigatedToProfileSetting() throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        return restaurantUI.isDisplayed(txt_profile);
    }
    public boolean isNavigatedToRestaurantSettings(){
        return restaurantUI.isDisplayed(txt_restaurant);
    }
    public boolean isNavigatedToLocationSettings(){
        return restaurantUI.isDisplayed(txt_locations);
    }
    public int getRowCount(){
        return restaurantUI.countElements(numberOfRows);
    }

    public void clickCreateCatagory(){
        restaurantUI.click(createCategoryBtn);
    }

    public void clickOnCreatedCategoryCode(){
        restaurantUI.click(categoryCodeEmpty);
    }

    public void clickOnCreatedCategoryName(){
        restaurantUI.click(categoryNameEmpty);
    }

    public void typeCategoryItemCode(String categoryCode){
        restaurantUI.sendKeys(typeCategoryCode,categoryCode);
    }

    public void typeCategoryItemName(String categoryName){
        restaurantUI.sendKeys(typeCategoryCode,categoryName);
    }

    public void saveCreatedCategoryCodeOrName(){
        restaurantUI.click(saveCreatedCategoryCode);
    }

    public boolean isCategoryItemCodeAdded(String categoryCode){
        return restaurantUI.isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryCode)));
    }

    public boolean isCategoryItemNameAdded(String categoryCode){
        return restaurantUI.isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryCode)));
    }

    public void clickOnCategoryDeleteBtn(String categoryName){
        restaurantUI.click(By.xpath(CategoryDeleteBtn.replace("CATEGORYNAME",categoryName)));
        restaurantUI.acceptAlert();
    }

    public boolean isCategoryDeleted(String categoryName){
       return restaurantUI.isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryName)));
    }
    public void clickOnExportBtn() throws InterruptedException {
        restaurantUI.click(exportBtn);
        restaurantUI.waitForCustom(1000);
    }
    public boolean isExportDataTextDisplayed()throws InterruptedException{
        try {
            restaurantUI.waitForVisibility(txt_exportData);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_exportData);
    }
    public void clickExportTypeDropDown()throws InterruptedException{
        restaurantUI.click(selectExportTypeDropDown);
    }
    public void clickExportTypeOption(String type)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(exportTypeOption.replace("TYPE",type)));
        restaurantUI.click(By.xpath(exportTypeOption.replace("TYPE",type)));
    }
    public void clickGenerateExport()throws InterruptedException{
        restaurantUI.click(btn_generateExport);
    }
    public boolean isOrderSettingsTextDisplayed() throws InterruptedException {
        try {
            restaurantUI.waitForVisibility(txt_orderSettings);
        } catch (Exception e){
            return false;
        }
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(txt_orderSettings);
    }
    public void enterOrderMinimum(String amount) throws InterruptedException {
        restaurantUI.clear(tbx_orderMinimum);
        restaurantUI.waitForCustom(1000);
        restaurantUI.sendKeys(tbx_orderMinimum, amount);
        restaurantUI.waitForCustom(3000);
    }
    public void setOrderMinimums(boolean enable) {
        restaurantUI.waitForVisibility(sel_OrderMinimums);
        if (restaurantUI.isCheckboxOrRadioBtnSelected(sel_OrderMinimums ) != enable){
            restaurantUI.click(sel_OrderMinimums);
        }
    }
    public void selectOrderMinimum(boolean enable) {

        String handlePosition = restaurantUI.getElement(orderMinimumToggleOrderSettingStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(19px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(orderMinimumToggleOrderSettingStable1);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(orderMinimumToggleOrderSettingStable1);
        }
    }


}
