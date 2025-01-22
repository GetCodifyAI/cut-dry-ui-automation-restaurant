package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SettingsPage;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class Settings {
    static SettingsPage settingsPage = new SettingsPage();

    public static void goToOrderSettings(){
        settingsPage.clickOnSettings();
        settingsPage.clickOnOrders();
    }
    public static void clickOnSettingsBtn(){
        settingsPage.clickOnSettingsBtn();
    }
    public static void setAfterCutOffTime()throws InterruptedException {

        // LocalDateTime currentTime = LocalDateTime.now();
        // LocalDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(695));
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Subtract 10 minutes from the current time to get the cutoff time
        ZonedDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(4));

        // Format the cutoff time in "hhmma" pattern (e.g., "0230PM")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmma");
        String cutoffTimeStr = cutoffTime.format(formatter);

        // Assuming settingsPage.setTime is the method where you set the cutoff time
        settingsPage.setTime(cutoffTimeStr);
    }

    public static void setBeforeCutOffTime() throws InterruptedException {

        // LocalDateTime currentTime = LocalDateTime.now();
        // LocalDateTime cutoffTime = currentTime.plus(Duration.ofMinutes(685));
        // Get the current time in the "America/Los_Angeles" time zone
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));

        // Subtract 10 minutes from the current time to get the cutoff time
        ZonedDateTime cutoffTime = currentTime.minus(Duration.ofMinutes(10));

        // Format the cutoff time in "hhmma" pattern (e.g., "0230PM")
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hhmma");
        String cutoffTimeStr = cutoffTime.format(formatter);

        // Assuming settingsPage.setTime is the method where you set the cutoff time
        settingsPage.setTime(cutoffTimeStr);
    }

    public static void saveChanges()throws InterruptedException{
        settingsPage.clickOnSaveChanges();
    }

    public static void clickOnProfileUnderSettings() throws InterruptedException {
        settingsPage.clickOnSettings();
        settingsPage.clickOnProfile();
    }

    public static void editNameInProfile(String profileName){
        settingsPage.editNameInProfile(profileName);
    }

    public static void saveProfileChanges(){
        settingsPage.clickOnSave();
    }

    public static boolean isSuccessfulUserProfileUpdateOverlayDisplayed(){
        return settingsPage.isProfileUpdateSuccessMessageDisplayed();
    }

    public static String getUpdatedProfileName(){
        return settingsPage.getUpdateName();
    }

    public static void clickOnBusinessUnderSettings() throws InterruptedException {
        settingsPage.clickOnSettings();
        settingsPage.clickOnBusiness();
    }

    public static void editNameInRestaurant(String restaurantName){
        settingsPage.editNameInRestaurant(restaurantName);
    }

    public static void saveRestaurantChanges(){
        settingsPage.clickOnSave();
    }

    public static boolean isSuccessfulCompanyDetailsUpdateOverlayDisplayed(){
        return settingsPage.isCompanyDetailsUpdateSuccessMessageDisplayed();
    }

    public static String getUpdatedRestaurantName(){
        return settingsPage.getUpdateRestName();
    }

    public static void removeLogo(){
        if(settingsPage.isLogoAvailable()) {
            settingsPage.clickOnRemoveLogoBtn();
        }
    }

    public static boolean isRestaurantLogoRemoved(){
        return settingsPage.isLogoAvailable();
    }

    public static boolean isRestaurantLogoAdded(){
        return settingsPage.isLogoAvailable();
    }

    public static void uploadFile(String path) {
        settingsPage.fileUpload(path);
    }

    public static void clickOnLocationsUnderSettings() throws InterruptedException {
        settingsPage.clickOnSettings();
        settingsPage.clickOnLocationsBtn();
    }

    public static void AddLocation(){
        settingsPage.clickOnAddLocation();
    }

    public static void enterLocationName(String locationName){
        settingsPage.typeLocationName(locationName);
    }

    public static boolean isAddLocationOverlayDisplayed(){
        return settingsPage.isAddLocationOverlayDisplayed();
    }

    public static boolean isEditLocationOverlayDisplayed(){
        return settingsPage.isEditLocationOverlayDisplayed();
    }

    public static void enterStreetAddress(String streetAddress){
        settingsPage.typeStreetAddress(streetAddress);
    }

    public static void clickAddLocationBtnInOverlay(){
        settingsPage.clickOnAddLocationOnOverlay();
    }

    public static boolean isSuccessOverlayDisplayed(){
        return settingsPage.isSuccessOverlayDisplayed();
    }

    public static boolean isAddedLocationDisplayedInLocations(String locationName){
        return settingsPage.isAddedLocationDisplayed(locationName);
    }

    public static boolean isEditedLocationDisplayedInLocations(String locationName){
        return settingsPage.isEditedLocationDisplayed(locationName);
    }

    public static void clickOnLocationInGrid(String locationName){
        settingsPage.clickTheLocationOnGrid(locationName);
    }

    public static void DeleteLocation(){
        settingsPage.clickOnDeleteLocation();
    }

    public static boolean isDeleteLocationOverlayDisplayed(){
        return settingsPage.isDeleteLocationOverlayDisplayed();
    }

    public static void clickYesOnDeleteLocationOverlay(){
        settingsPage.clickOnYesBtn();
    }

    public static void clickOnAccounting(){
        settingsPage.clickOnAccountingBtn();
    }

    public static boolean isNavigatedToAccountingCatagoryPage(){
        return settingsPage.isNavigatedToAccountingCatagory();
    }

    public static boolean isNavigatedToProfileSetting(){
        return settingsPage.isNavigatedToProfileSetting();
    }

    public static boolean isNavigatedToRestaurantSettings(){
        return settingsPage.isNavigatedToRestaurantSettings();
    }
    public static boolean isNavigatedToLocationSettings(){
        return settingsPage.isNavigatedToLocationSettings();
    }

    public static int getAccountingCategoryCount(){
        return settingsPage.getRowCount();
    }

    public static void createCategory(){
        settingsPage.clickCreateCatagory();
    }

    public static void clickOnCreatedCategoryCodeInGrid(){
        settingsPage.clickOnCreatedCategoryCode();
    }

    public static void clickOnCreatedCategoryNameInGrid(){
        settingsPage.clickOnCreatedCategoryName();
    }

    public static void fillCategoryItemCode(String categoryCode){
        settingsPage.typeCategoryItemCode(categoryCode);
    }

    public static void fillCategoryItemName(String categoryCode){
        settingsPage.typeCategoryItemName(categoryCode);
    }

    public static void saveCreatedCategoryItemCodeOrName(){
        settingsPage.saveCreatedCategoryCodeOrName();
    }

    public static boolean isCreatedCategoryItemCodeDisplayed(String categoryItemCode){
        return settingsPage.isCategoryItemCodeAdded(categoryItemCode);
    }

    public static boolean isCreatedCategoryItemNameDisplayed(String categoryItemCode){
        return settingsPage.isCategoryItemNameAdded(categoryItemCode);
    }

    public static void deleteCategory(String categoryName){
        settingsPage.clickOnCategoryDeleteBtn(categoryName);
    }

    public static boolean isCategoryDeleted(String categoryName){
        return settingsPage.isCategoryDeleted(categoryName);
    }
    public static void clickOnExportUnderSettings() throws InterruptedException {
        settingsPage.clickOnSettings();
        settingsPage.clickOnExportBtn();
    }
    public static boolean isExportDataTextDisplayed()throws InterruptedException{
        return settingsPage.isExportDataTextDisplayed();
    }
    public static void selectExportType(String type)throws InterruptedException{
        settingsPage.clickExportTypeDropDown();
        settingsPage.clickExportTypeOption(type);
    }
    public static void clickGenerateExport()throws InterruptedException{
        settingsPage.clickGenerateExport();
    }

}