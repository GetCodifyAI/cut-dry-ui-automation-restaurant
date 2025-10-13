package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

import static org.apache.commons.lang3.BooleanUtils.or;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//div[text()='Place Order']");
    By btn_placeOrder = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes = By.xpath("//div[contains(text(), 'Hayes')]");
    By txt_OrderGuide = By.xpath("//span[contains(text(), 'Order Guide')]");
    By btn_TestAutomation = By.xpath("//div[contains(text(), 'Test_Automation') and contains(@class, 'w-100')]");
    By txt_draftOrder = By.xpath("//div[contains(@class, 'text-center') and contains(text(), 'continue your previous draft order')]");
    By btn_noDraftOrder = By.xpath("//span[text()='×']");
    By NoBtnDraftOrder = By.xpath("//div[contains(text(),'No')]");
    By txt_disDashboard = By.xpath("//li[contains(text(),'Dashboard')]");
    By btn_cooksCompanyProduce = By.xpath("//div[contains(text(), 'Cooks Company Produce')]");
    By txt_approvals = By.xpath("//div[contains(text(), 'Approvals')]");
    By btn_Reports = By.xpath("//a[contains(@data-tip, 'Reports')]");
    By btn_approvals = By.xpath("//a[contains(@data-tip, 'Approvals')]");
    By btn_drafts = By.xpath("//a[contains(@data-tip, 'View Drafts')]");
    By btn_chats = By.xpath("//a[contains(@data-tip, 'Chat')]");
    By btn_pay = By.xpath("//a[contains(@data-tip, 'View Invoices')]");
    By txt_drafts = By.xpath("//div[contains(text(), 'Drafts')]");
    By txt_chats = By.xpath("//li[contains(text(), 'Your Suppliers')]");
    By txt_pay = By.xpath("//h2[contains(text(), 'Invoices')]");
    By btn_customers = By.xpath("//a[@data-tip='Customers']");
    By btn_order = By.xpath("//a[@data-tip='Place Order']");
    String supplierTxt = "//tr[@class='_du1frc _14u3xd3 py-3']//div[text()='SUPPLIERNAME']";
    By MaxiesSLTxt = By.xpath("//div[@class='_hp19hv mx-3 aling-items-center d-flex']//span[@data-tip='Maxies SL']//div[text()='Maxies SL']");
    By btn_Rewards = By.xpath("//a[contains(@data-tip, 'Rewards')]");
    By txt_dp_dashboard = By.xpath("//h3[text()='Dashboard']");
    By btn_credit_requests = By.xpath("//a[@data-for='sideNavSupplierMenuOptions' and @href='/credit-requests']");
    By users = By.xpath("//div[contains(text(),'Users')]");
    By tbx_msg = By.xpath("//input[@placeholder='Message...']");
    String customerNameText = "//img[contains(@data-tip,'SUPPLIERNAME')]";
    By locationFilter = By.xpath("(//div[text()='Place Order']/following-sibling::div//div)[1]");
    By locationOption = By.xpath("//div[text()='Place Order']/following-sibling::*//div[contains(@id,'react-select') and contains(text(), 'All Locations')]");
    By btn_catalog = By.xpath("//a[@data-tip='View Catalog']");
    By btn_settings = By.xpath("//a[@role='button' and contains(text(), 'Settings')]");
    By btn_orderSettings = By.xpath("//div[@arrowprops]//a[text()='Orders']");
    By txt_productCatalog = By.xpath("//div[text()='Choose your product catalog']");
    String chooseProductCatalog = "//span[text()='NAME']";
    By btn_home = By.xpath("//a[@data-tip='Home']");
    By txt_home = By.xpath("//li[text()='Home']");
    By btn_switch1932Saval = By.xpath("//button[text()='Switch to 1932 by Saval']");
    By btn_category = By.xpath("//div[text()='Shop Our Catalog']/following-sibling::*//div//p[text()='Beverages']");
    By NoBtnDraftOrderCatalog = By.xpath("//div[text()='No']");
    By btn_switchSavalFood = By.xpath("//button[text()='Switch to Saval Foodservice']");
    By txt_MaxiesOrderGuide = By.xpath("//div[contains(text(), 'Order Guide')]");
    By savalFoodServiceLogo = By.xpath("//img[@class='_1mht6os' and contains(@src,'ordering-supplies-images')]");
    By savalFoodBanner = By.xpath("//div[contains(@class,'carousel-item')]");
    String parentDpName = "//div//span[contains(text(),'NAME')]";
    By btn_colonnade = By.xpath("//div[contains(text(), 'Colonnade')]");
    String txt_profile = "//div[text()='NAME']";
    By signOutProfile = By.xpath("//a[text()='Sign Out']");
    By outSideModal = By.xpath("//div[@role='dialog' and not(descendant::*[@class='modal-content'])]");
    By btn_chatWithUs = By.xpath("//span[text()='Chat with us']");
    By txt_selectOrderGuide = By.xpath("//div[text()='Select Order Guide']");
    By selectOrderGuide = By.xpath("//div[text()='Independent Foods Co']");
    By btn_selectOrderGuideCustom = By.xpath("//div[contains(text(),'Select Order Guide')]/following-sibling::div/div[1]");



    public boolean isDashboardTextDisplayed(){
//        try {
//            restaurantUI.waitForVisibility(txt_dashboard);
//        } catch (Exception e){
//            return false;
//        }
        return restaurantUI.isDisplayed(txt_dashboard,60);
    }
    public boolean isChatTextDisplayed(){
        boolean out;
        try {
            out = restaurantUI.isDisplayed(txt_chats) | restaurantUI.isDisplayed(tbx_msg);
        } catch (Exception e){
            return false;
        }
        return out;
    }
    public boolean isDraftsTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_drafts);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_drafts);
    }
    public boolean isPayTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_pay);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_pay);
    }
    public boolean isApprovalsTabDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_approvals);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_approvals);
    }
    public void clickOnPlaceOrder() {
        restaurantUI.click(btn_placeOrder);}
    public void clickOnHayes() {
        restaurantUI.click(btn_hayes);}
    public boolean isOrderGuideTextDisplayed(){
        return restaurantUI.isDisplayed(txt_OrderGuide);
    }
    public boolean isMaxiesOrderGuideTextDisplayed(){
        return restaurantUI.isDisplayed(txt_MaxiesOrderGuide);
    }
    public boolean isTestAutomationPopupDisplayed(){
        return restaurantUI.isDisplayed(btn_TestAutomation,5);
    }
    public void clickOnTestAutomationPopup(){
        restaurantUI.waitForClickability(btn_TestAutomation);
        restaurantUI.click(btn_TestAutomation);
        restaurantUI.waitForInvisibility(btn_TestAutomation);
    }
    public boolean isDraftOrderPopUpDisplayed(){
        try {
            return restaurantUI.isDisplayed(txt_draftOrder);
        } catch (Exception e){
            return false;
        }
    }
    public void clickOnNoDraftOrder(){
        restaurantUI.click(btn_noDraftOrder);
    }

    public void clickNoBtnOnDraftCheckOverlay(){
        restaurantUI.click(NoBtnDraftOrder);
    }
    public boolean isDisDashboardTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_disDashboard);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_disDashboard);
    }
    public void clickOnCooksCompanyProduce() {
        restaurantUI.click(btn_cooksCompanyProduce);}

    public void clickOnDrafts() {
        restaurantUI.click(btn_drafts);}
    public void clickOnChats() {
        restaurantUI.click(btn_chats);}
    public void clickOnReports() {
        restaurantUI.click(btn_Reports);}
    public void clickOnPay() {
        restaurantUI.click(btn_pay);}
    public void clickOnApprovals() {
        restaurantUI.click(btn_approvals);}
    public void clickOnCustomers(){
        restaurantUI.click(btn_customers);
    }
    public void clickOnOrder() throws InterruptedException {
        restaurantUI.click(btn_order);
        restaurantUI.waitForCustom(2000);
    }

    public void clickOnSupplier(String supplierName){
        restaurantUI.waitForVisibility(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
        restaurantUI.click(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
    }

    public boolean isNavigatedToMaxiesSLOrderGuide() throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        return restaurantUI.isDisplayed(MaxiesSLTxt);
    }

    public boolean isNavigatedToOrderGuide(String Supplier) throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        restaurantUI.waitForVisibility(By.xpath(customerNameText.replace("SUPPLIERNAME",Supplier)),30);
        return restaurantUI.isDisplayed(By.xpath(customerNameText.replace("SUPPLIERNAME",Supplier)));
    }

    public void clickOnUsers(){
        restaurantUI.click(users);
    }

    public void clickOnRewards(){
        restaurantUI.click(btn_Rewards);
    }

    public boolean isDistributorDashboardTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_dp_dashboard);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_dp_dashboard);
    }
    public void clickOnCreditRequests(){
        restaurantUI.click(btn_credit_requests);
    }
    public void clickLocationFilter(){
        restaurantUI.click(locationFilter);
    }
    public void clickOnLocationOption() throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(locationOption);
        restaurantUI.click(locationOption);
    }
    public void clickOnCatalog(){
        restaurantUI.click(btn_catalog);
    }
    public void clickOnOrderSettings(){
        restaurantUI.scrollToElement(btn_settings);
        restaurantUI.clickUsingJavaScript(btn_settings);
        restaurantUI.hoverOverElement(btn_orderSettings);
        restaurantUI.clickWithFallback(btn_orderSettings);
    }
    public boolean isChooseProductCatalogDisplayed()throws InterruptedException{
        restaurantUI.waitForCustom(3000);
        restaurantUI.waitForVisibility(txt_productCatalog);
        return restaurantUI.isDisplayed(txt_productCatalog);
    }
    public void chooseProductCatalog(String name)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(chooseProductCatalog.replace("NAME",name)));
        restaurantUI.click(By.xpath(chooseProductCatalog.replace("NAME",name)));
    }
    public void clickOnHome() throws InterruptedException {
        restaurantUI.click(btn_home);
        restaurantUI.waitForCustom(2000);
    }
    public boolean isUserNavigateHome()throws InterruptedException{
        return restaurantUI.isDisplayed(txt_home);
    }
    public void switch1932Saval()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_switch1932Saval);
        restaurantUI.uiScrollTop();
        restaurantUI.click(btn_switch1932Saval);
        restaurantUI.waitForCustom(3000);
    }
    public void clickCategory()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_category);
        restaurantUI.clickUsingJavaScript(btn_category);
    }
    public void clickNoBtnOnDraftCheckOverlayCatalog(){
        restaurantUI.hoverOverElement(NoBtnDraftOrderCatalog);
        restaurantUI.clickUsingJavaScript(NoBtnDraftOrderCatalog);
    }
    public void switchSavalFood()throws InterruptedException{
        restaurantUI.waitForVisibility(btn_switchSavalFood);
        restaurantUI.click(btn_switchSavalFood);
    }
    public boolean isCatalogDataDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_category);
    }
    public boolean isSavalFoodServiceLogoDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(savalFoodServiceLogo);
    }
    public boolean isSavalFoodServiceBannerDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(savalFoodBanner);
    }
    public boolean isSwitch1932SavalDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_switch1932Saval);
    }
    public boolean isSwitchSavalFoodDisplayed()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_switchSavalFood);
    }
    public boolean isParentDpNameDisplayed(String name)throws InterruptedException{
        return restaurantUI.isDisplayed(By.xpath(parentDpName.replace("NAME",name)));
    }
    public void clickOnColonnade() {
        restaurantUI.click(btn_colonnade);
    }

    public boolean isChooseCompanyDisplay(String name)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(chooseProductCatalog.replace("NAME",name)));
        return restaurantUI.isDisplayed(By.xpath(chooseProductCatalog.replace("NAME",name)));
    }
    public void clickOnProfile(String name) {
        restaurantUI.click(By.xpath(txt_profile.replace("NAME",name)));
    }
    public void clickOnSignOutProfile() {
        restaurantUI.click(signOutProfile);
    }
    public void clickOutsideModal()throws InterruptedException{
         restaurantUI.clickUsingJavaScript(outSideModal);
    }
    public boolean isChatSectionDisplay()throws InterruptedException{
        return restaurantUI.isDisplayed(btn_chats);
    }
    public boolean isChatWithUsDisplay()throws InterruptedException{
        restaurantUI.waitForCustom(3000);
        return restaurantUI.isDisplayed(btn_chatWithUs);
    }
    public boolean isSelectOrderGuidePopUpDisplayed(){
        return restaurantUI.isDisplayed(txt_selectOrderGuide);
    }
    public void selectOrderGuide(){
        restaurantUI.click(selectOrderGuide);
    }
    public void selectOrderGuideCustom(){
        restaurantUI.click(btn_selectOrderGuideCustom);
    }

}
