package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class SettingsPage extends LoginPage{

    By btn_settings = By.xpath("(//a[contains(text(), 'Settings')])[1]");
    By btn_orders = By.xpath("(//a[@href='/settings/orders'])[2]");
    By tbx_cutOffTime = By.xpath("//input[@type='time']");
    By btn_saveChanges = By.xpath("//button[text()='Save Changes']");
    By profileBtn = By.xpath("//div[@class='fade _1v9d984k show']//a[contains(text(),'Profile')]");
    By profileTextField = By.xpath("//label[contains(text(),'Name')]/following-sibling::div//input[@type='text']");
    By saveBtn = By.xpath("//button[contains(text(),'Save')]");
    By profileUpdateSuccessOverlay = By.xpath("//h2[contains(@class,'swal2-title') and contains(text(),'Profile updated successfully')]");
    By businessBtn = By.xpath("//div[@class='fade _1v9d984k show']//a[contains(text(),'Business')]");
    By restaurantNameTextField = By.xpath("//label[contains(text(),'Name')]/following-sibling::div//input[@class='form-control']");
    By companyDetailsUpdateSuccessOverlay = By.xpath("//h2[contains(@class,'swal2-title') and contains(text(),'Company details successfully edited.')]");
    By removeLogoBtn = By.xpath("//button[@class='mt-2 btn btn-link' and contains(text(),'Remove')]");
    By logoImage = By.xpath("//img[contains(@src,'ordering-supplies-images')]");
    By BrowseImgBtn = By.xpath("//*/input[@type='file']");
    By locationsBtn = By.xpath("//div[@class='fade _1v9d984k show']//a[contains(text(),'Locations')]");
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
    By accountingBtn = By.xpath("//div[@class='fade _1v9d984k show']//a[contains(text(),'Accounting')]");
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
    By btn_settings_ = By.xpath("(//a[@href='/my-settings'])[2]");
    By exportBtn = By.xpath("//div[@class='fade _1v9d984k show']//a[contains(text(),'Export')]");
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
        getRestaurantUI().clickWithFallback(btn_settings);
    }
    public void clickOnSettingsBtn(){
        getRestaurantUI().click(btn_settings_);
    }
    public void clickOnOrders(){
        getRestaurantUI().click(btn_orders);
    }

    public void setTime(String time)throws InterruptedException{
        getRestaurantUI().waitForVisibility(tbx_cutOffTime);
        getRestaurantUI().sendKeys(tbx_cutOffTime,time);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickOnSaveChanges()throws InterruptedException{
        getRestaurantUI().click(btn_saveChanges);
        getRestaurantUI().waitForCustom(4000);
    }

    public void clickOnProfile() throws InterruptedException {
        getRestaurantUI().clickWithFallback(profileBtn);
        getRestaurantUI().waitForCustom(3000);
    }

    public void editNameInProfile(String profileName){
        getRestaurantUI().sendKeys(profileTextField,profileName);
    }

    public void clickOnSave(){
        getRestaurantUI().click(saveBtn);
    }

    public boolean isProfileUpdateSuccessMessageDisplayed(){
        return getRestaurantUI().isDisplayed(profileUpdateSuccessOverlay);
    }


    public String getUpdateName(){
        getRestaurantUI().waitForVisibility(profileTextField);
        return getRestaurantUI().getAttributeValue(profileTextField,"value");
    }

    public void clickOnBusiness() throws InterruptedException {
        getRestaurantUI().clickWithFallback(businessBtn);
        getRestaurantUI().waitForCustom(1000);
    }

    public void editNameInRestaurant(String restaurantName){
        getRestaurantUI().sendKeys(restaurantNameTextField,restaurantName);
    }

    public boolean isCompanyDetailsUpdateSuccessMessageDisplayed(){
        return getRestaurantUI().isDisplayed(companyDetailsUpdateSuccessOverlay);
    }

    public String getUpdateRestName(){
        getRestaurantUI().waitForVisibility(restaurantNameTextField);
        return getRestaurantUI().getAttributeValue(restaurantNameTextField,"value");
    }

    public void clickOnRemoveLogoBtn(){
        getRestaurantUI().click(removeLogoBtn);
    }

    public boolean isLogoAvailable(){
        return getRestaurantUI().isDisplayed(logoImage);
    }

    public void fileUpload(String path) {
        getRestaurantUI().sendKeysHiddenElements(BrowseImgBtn, path);
    }

    public void clickOnLocationsBtn() throws InterruptedException {
        getRestaurantUI().clickWithFallback(locationsBtn);
        getRestaurantUI().waitForCustom(1000);
    }

    public void clickOnAddLocation(){
        getRestaurantUI().click(addLocationBtn);
    }

    public boolean isAddLocationOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(addLocationTxt);
    }

    public boolean isEditLocationOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(editLocationTxt);
    }

    public void typeLocationName(String locationName){
        getRestaurantUI().sendKeys(locationNameTextField,locationName);
    }

    public void typeStreetAddress(String streetAddress){
        getRestaurantUI().sendKeys(streetAddressTextField,streetAddress);
    }

    public void clickOnAddLocationOnOverlay(){
        getRestaurantUI().click(getAddLocationBtnInOverlay);
    }

    public boolean isSuccessOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(successOverlayDisplayed);
    }

    public boolean isAddedLocationDisplayed(String location){
        return getRestaurantUI().isDisplayed(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public boolean isEditedLocationDisplayed(String location){
        return getRestaurantUI().isDisplayed(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public void clickTheLocationOnGrid(String location){
        getRestaurantUI().click(By.xpath(locationName.replace("LOCATIONNAME",location)));
    }

    public void clickOnDeleteLocation(){
        getRestaurantUI().click(deleteLocationBtn);
    }

    public boolean isDeleteLocationOverlayDisplayed(){
        return getRestaurantUI().isDisplayed(deleteLocationOverlay);
    }

    public void clickOnYesBtn(){
        getRestaurantUI().click(yesBtnInDeleteLocationOverlay);
    }

    public void clickOnAccountingBtn(){
        getRestaurantUI().clickWithFallback(btn_settings);
        getRestaurantUI().click(accountingBtn);
    }
    public boolean isNavigatedToAccountingCatagory(){
        return getRestaurantUI().isDisplayed(accountCatagory);
    }
    public boolean isNavigatedToProfileSetting() throws InterruptedException {
        getRestaurantUI().waitForVisibility(txt_profile);
        return getRestaurantUI().isDisplayed(txt_profile);
    }
    public boolean isNavigatedToRestaurantSettings(){
        return getRestaurantUI().isDisplayed(txt_restaurant);
    }
    public boolean isNavigatedToLocationSettings(){
        return getRestaurantUI().isDisplayed(txt_locations);
    }
    public int getRowCount(){
        return getRestaurantUI().countElements(numberOfRows);
    }

    public void clickCreateCatagory(){
        getRestaurantUI().click(createCategoryBtn);
    }

    public void clickOnCreatedCategoryCode(){
        getRestaurantUI().click(categoryCodeEmpty);
    }

    public void clickOnCreatedCategoryName(){
        getRestaurantUI().click(categoryNameEmpty);
    }

    public void typeCategoryItemCode(String categoryCode){
        getRestaurantUI().sendKeys(typeCategoryCode,categoryCode);
    }

    public void typeCategoryItemName(String categoryName){
        getRestaurantUI().sendKeys(typeCategoryCode,categoryName);
    }

    public void saveCreatedCategoryCodeOrName(){
        getRestaurantUI().click(saveCreatedCategoryCode);
    }

    public boolean isCategoryItemCodeAdded(String categoryCode){
        return getRestaurantUI().isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryCode)));
    }

    public boolean isCategoryItemNameAdded(String categoryCode){
        return getRestaurantUI().isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryCode)));
    }

    public void clickOnCategoryDeleteBtn(String categoryName){
        getRestaurantUI().click(By.xpath(CategoryDeleteBtn.replace("CATEGORYNAME",categoryName)));
        getRestaurantUI().acceptAlert();
    }

    public boolean isCategoryDeleted(String categoryName){
       return getRestaurantUI().isDisplayed(By.xpath(addedCategoryCodeOrName.replace("CATEGORYCODE",categoryName)));
    }
    public void clickOnExportBtn() throws InterruptedException {
        getRestaurantUI().clickWithFallback(exportBtn);
        getRestaurantUI().waitForCustom(1000);
    }
    public boolean isExportDataTextDisplayed()throws InterruptedException{
        try {
            getRestaurantUI().waitForVisibility(txt_exportData);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_exportData);
    }
    public void clickExportTypeDropDown()throws InterruptedException{
        getRestaurantUI().click(selectExportTypeDropDown);
    }
    public void clickExportTypeOption(String type)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(exportTypeOption.replace("TYPE",type)));
        getRestaurantUI().click(By.xpath(exportTypeOption.replace("TYPE",type)));
    }
    public void clickGenerateExport()throws InterruptedException{
        getRestaurantUI().click(btn_generateExport);
    }
    public boolean isOrderSettingsTextDisplayed() throws InterruptedException {
        try {
            getRestaurantUI().waitForVisibility(txt_orderSettings);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_orderSettings);
    }
    public void enterOrderMinimum(String amount) throws InterruptedException {
        getRestaurantUI().clear(tbx_orderMinimum);
        getRestaurantUI().waitForVisibility(tbx_orderMinimum);
        getRestaurantUI().sendKeys(tbx_orderMinimum, amount);
        getRestaurantUI().waitForCustom(3000);
    }
    public void setOrderMinimums(boolean enable) {
        getRestaurantUI().waitForVisibility(sel_OrderMinimums);
        if (getRestaurantUI().isCheckboxOrRadioBtnSelected(sel_OrderMinimums ) != enable){
            getRestaurantUI().click(sel_OrderMinimums);
        }
    }
    public void selectOrderMinimum(boolean enable) {

        String handlePosition = getRestaurantUI().getElement(orderMinimumToggleOrderSettingStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(19px)");

        if (enable && !isEnabled) {
            getRestaurantUI().clickWithScrollAndHover(orderMinimumToggleOrderSettingStable1);
        } else if (!enable && isEnabled) {
            getRestaurantUI().clickWithScrollAndHover(orderMinimumToggleOrderSettingStable1);
        }
    }


}
