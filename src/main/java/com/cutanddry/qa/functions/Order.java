package com.cutanddry.qa.functions;


import com.cutanddry.qa.pages.DashboardPage;
import com.cutanddry.qa.pages.OrderPage;

public class Order {
    static OrderPage orderPage = new OrderPage();
    static DashboardPage dashboardPage = new DashboardPage();

    public static void clickAddNewSupplier(){
        orderPage.clickAddNewSupplier();
    }
    public static boolean isAddedNewSupplierDisplayed(String supplier)throws InterruptedException{
        return orderPage.isAddedNewSupplierDisplayed(supplier);
    }
    public static void goToOrder(){
        orderPage.clickOrder();
    }
    public static boolean isPlaceOrderTextDisplayed(){
        return orderPage.isPlaceOrderTextDisplayed();
    }
    public static void selectOneSupplier(String editSupplierName) throws InterruptedException {
        orderPage.clickOnOneSupplier(editSupplierName);
    }
    public static void clickFinishSetup(String supplier)throws InterruptedException{
        orderPage.clickFinishSetup(supplier);
    }
    public static boolean isNavigateEditOrderGuide(){
        return orderPage.isNavigateEditOrderGuide();
    }
    public static void clickUploadFile(){
        orderPage.clickUploadFile();
    }
    public static void clickNext(){
        orderPage.clickNext();
    }
    public static void clickConfirm(){
        orderPage.clickConfirm();
    }
    public static void clickOK()throws InterruptedException{
        orderPage.clickOK();
    }
    public static boolean isNewlyAddedOrderGuideDisplayed(){
        return orderPage.isNewlyAddedOrderGuideDisplayed();
    }
    public static void clickEditSupplier(String supplier)throws InterruptedException{
        orderPage.clickThreeDotDropDown(supplier);
        orderPage.clickEditSupplierOption();
    }
    public static void clickCreateItems(){
        orderPage.clickCreateItems();
    }
    public static boolean isAddItemToOrderGuidePopUpDisplayed(){
        return orderPage.isAddItemToOrderGuidePopUpDisplayed();
    }
    public static void addItemName(String itemName) throws InterruptedException{
        orderPage.addItemName(itemName);
    }
    public static void addItemCode(String itemCode) throws InterruptedException{
        orderPage.addItemCode(itemCode);
    }
    public static void addItemPrice(String itemPrice) throws InterruptedException{
        orderPage.addItemPrice(itemPrice);
    }
    public static void addItemPar(String itemPar) throws InterruptedException{
        orderPage.addItemPar(itemPar);
    }
    public static void clickAccountingCategory() throws InterruptedException{
        orderPage.clickAccountingCategoryDropDown();
        orderPage.clickAccountingCategoryOption();
    }
    public static void clickSaveItem()throws InterruptedException{
        orderPage.clickSaveItem();
    }
    public static void clickLocationFilter(){
        orderPage.clickLocationFilter();
    }
    public static void clickOnLocationOption(String location)throws InterruptedException{
        orderPage.clickOnLocationOption(location);
    }
    public static boolean isLocationFilterWork(String location){
        return orderPage.isLocationFilterWork(location);
    }
    public static void clickOnCheckIn() {
        orderPage.clickOnCheckIn();
    }
    public static boolean isCheckInOrderIdDisplayed(String orderId) throws InterruptedException {
        return orderPage.isCheckInOrderIdDisplayed(orderId);
    }
    public static void clickOnCheckInAll() {
        orderPage.clickOnCheckInAll();
    }
    public static boolean isCheckInAllPopupDisplayed() {
        return orderPage.isCheckInAllPopupDisplayed();
    }
    public static boolean isOrderStatusDisplayed(String status) throws InterruptedException {
        return orderPage.isOrderStatusDisplayed(status);
    }
    public static void clickChatSupplier(String supplier)throws InterruptedException{
        orderPage.clickThreeDotDropDown(supplier);
        orderPage.clickChatSupplierOption();
        dashboardPage.clickOnHayes();
    }
    public static void clickOnThreeDot(String supplier) throws InterruptedException {
        orderPage.clickThreeDotDropDown(supplier);
    }
    public static boolean isChatOptionDisplay(){
        return orderPage.isChatOptionDisplay();
    }
    public static boolean isAreYouSurePopUpDisplayed(){
        return orderPage.isAreYouSurePopUpDisplayed();
    }
    public static void clickYes() throws InterruptedException {
        orderPage.clickYes();
    }
    public static void editOrderGuideName(String name) throws InterruptedException {
        orderPage.editOrderGuideName(name);
    }
    public static void editOrderGuideDescription(String name) throws InterruptedException {
        orderPage.editOrderGuideDescription(name);
    }
    public static void clickOnSave(){
        orderPage.clickOnSave();
    }
    public static boolean editedOrderGuideNameDisplay(String name){
        return orderPage.editedOrderGuideNameDisplay(name);
    }
    public static boolean editedOrderGuideDescriptionDisplay(String name){
        return orderPage.editedOrderGuideDescriptionDisplay(name);
    }
    public static void removeOrderGuideLocation()throws InterruptedException{
        orderPage.removeOrderGuideLocation();
    }
    public static void addOrderGuideLocation()throws InterruptedException{
        orderPage.clickOrderGuideLocationDropDown();
        orderPage.clickOrderGuideLocationDropDownOption();
    }
    public static void clickFindMoreInCatalog()throws InterruptedException{
        orderPage.clickFindMoreInCatalog();
    }
    public static boolean isInactiveItemDetectedPopUpDisplay()throws InterruptedException{
        return orderPage.isInactiveItemDetectedPopUpDisplay();
    }
    public static boolean isThreeDotDropDownOptionDisplayed(String option)throws InterruptedException{
        return orderPage.isThreeDotDropDownOptionDisplayed(option);
    }
    public static void clickEditGuideOption()throws InterruptedException{
        orderPage.clickEditGuideOption();
    }
    public static boolean isSelectLocationPopUpDisplayed()throws InterruptedException{
        return orderPage.isSelectLocationPopUpDisplayed();
    }
    public static void selectLocationSupplier(String location)throws InterruptedException{
         orderPage.selectLocationSupplier(location);
    }
    public static void clickViewCatalogOption()throws InterruptedException{
        orderPage.clickViewCatalogOption();
    }



}
