package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

import static org.apache.commons.lang3.BooleanUtils.or;

public class DashboardPage extends LoginPage{
    By txt_dashboard = By.xpath("//div[text()='Place Order']");
    By btn_placeOrder = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_placeOrder_Cashback_Foods = By.xpath("//div[contains(text(), 'Cashback Foods')]");
    By btn_hayes = By.xpath("//div[contains(text(), 'Hayes')]");
    By txt_OrderGuide = By.xpath("//span[contains(text(), 'Order Guide')]");
    By btn_TestAutomation = By.xpath("//div[contains(text(), 'Test_Automation') and contains(@class, 'w-100')]");
    By txt_draftOrder = By.xpath("//div[contains(@class, 'text-center') and contains(text(), 'continue your previous draft order')]");
    By btn_noDraftOrder = By.xpath("//span[text()='×']");
    By NoBtnDraftOrder = By.xpath("//div[text()='No']");
    By txt_disDashboard = By.xpath("//li[contains(text(),'Dashboard')]");
    By btn_cooksCompanyProduce = By.xpath("//div[contains(text(), 'Cooks Company Produce')]");
    By txt_approvals = By.xpath("(//a[contains(@data-tip, 'Approvals')])[2]");
    By btn_Reports = By.xpath("(//a[contains(@data-tip, 'Reports')])[1]");
    By btn_approvals = By.xpath("(//a[contains(@data-tip, 'Approvals')])[1]");
    By btn_drafts = By.xpath("(//a[contains(@data-tip, 'View Drafts')])[1]");
    By btn_chats = By.xpath("(//a[contains(@data-tip, 'Chat')])[1]");
    By btn_chats_visible = By.xpath("(//a[contains(@data-tip, 'Chat')])[2]");
    By btn_pay = By.xpath("(//a[contains(@data-tip, 'View Invoices')])[1]");
    By txt_drafts = By.xpath("//li[@aria-current='page' and normalize-space()='Drafts']");
    By txt_chats = By.xpath("//li[contains(text(), 'Your Suppliers')]");
    By txt_pay = By.xpath("//h2[contains(text(), 'Invoices')]");
    By btn_customers = By.xpath("(//a[@data-tip='Customers'])[1]");
    By btn_order = By.xpath("(//a[@data-tip='Place Order'])[1]");
    String supplierTxt = "//tr[@class='_du1frc _14u3xd3 py-3']//div[text()='SUPPLIERNAME']";
    By MaxiesSLTxt = By.xpath("//div[@class='_hp19hv mx-3 aling-items-center d-flex']//span[@data-tip='Maxies SL']//div[text()='Maxies SL']");
    By btn_Rewards = By.xpath("(//a[contains(@data-tip, 'Rewards')])[1]");
    By txt_dp_dashboard = By.xpath("//h3[text()='Dashboard']");
    By btn_credit_requests = By.xpath("(//a[contains(.,'Credit Req') and contains(@href,'credit-requests')])[2]");
    By users = By.xpath("(//div[contains(text(),'Users')])[1]");
    By tbx_msg = By.xpath("//input[@placeholder='Message...']");
    String customerNameText = "//img[contains(@data-tip,'SUPPLIERNAME')]";
    By locationFilter = By.xpath("(//div[text()='Place Order']/following-sibling::div//div)[1]");
    By locationOption = By.xpath("//div[text()='Place Order']/following-sibling::*//div[contains(@id,'react-select') and contains(text(), 'All Locations')]");
    By btn_catalog = By.xpath("(//a[@data-tip='View Catalog'])[1]");
    By btn_settings = By.xpath("(//a[@role='button' and contains(text(), 'Settings')])[last()]");
    By btn_orderSettings = By.xpath("//div[contains(@class,'fade')]/a[text()='Orders']");
    By txt_productCatalog = By.xpath("//div[text()='Choose your product catalog']");
    String chooseProductCatalog = "//span[text()='NAME']";
    By btn_home = By.xpath("(//a[@data-tip='Home'])[1]");
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
    By btn_viewMore = By.xpath("//*[local-name() = 'svg' and @data-icon='cdDotsGrid']");
    static By wordAfterCompanyLocator = By.xpath("//span[text()='Company:']/following-sibling::span");
    static By dropdownToggle = By.xpath("//span[text()='Company:']/ancestor::button[contains(@class, 'dropdown-toggle')]");
    static By independentFoodOption = By.xpath("//a[text()='Cut & Dry Test Account']");


    public boolean isDashboardTextDisplayed(){
//        try {
//            getRestaurantUI().waitForVisibility(txt_dashboard);
//        } catch (Exception e){
//            return false;
//        }
        return getRestaurantUI().isDisplayed(txt_dashboard,60);
    }
    public boolean isChatTextDisplayed(){
        boolean out;
        try {
            out = getRestaurantUI().isDisplayed(txt_chats) | getRestaurantUI().isDisplayed(tbx_msg);
        } catch (Exception e){
            return false;
        }
        return out;
    }
    public boolean isDraftsTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_drafts);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_drafts);
    }
    public boolean isPayTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_pay);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_pay);
    }
    public boolean isApprovalsTabDisplayed(){
        getRestaurantUI().waitForVisibility(txt_approvals);
        return getRestaurantUI().isDisplayed(txt_approvals);
    }
    public void clickOnPlaceOrder() {
        getRestaurantUI().clickWithFallback(btn_placeOrder);}

    public void clickOnPlaceOrder_Cashback_Foods() {
        getRestaurantUI().click(btn_placeOrder_Cashback_Foods);}

    public void clickOnHayes() {
        getRestaurantUI().click(btn_hayes);}
    public boolean isOrderGuideTextDisplayed(){
        return getRestaurantUI().isDisplayed(txt_OrderGuide);
    }
    public boolean isMaxiesOrderGuideTextDisplayed(){
        return getRestaurantUI().isDisplayed(txt_MaxiesOrderGuide);
    }
    public boolean isTestAutomationPopupDisplayed(){
        return getRestaurantUI().isDisplayed(btn_TestAutomation,5);
    }
    public void clickOnTestAutomationPopup(){
        getRestaurantUI().waitForClickability(btn_TestAutomation);
        getRestaurantUI().click(btn_TestAutomation);
        getRestaurantUI().waitForInvisibility(btn_TestAutomation);
    }
    public boolean isDraftOrderPopUpDisplayed(){
        try {
            return getRestaurantUI().isDisplayed(txt_draftOrder);
        } catch (Exception e){
            return false;
        }
    }
    public void clickOnNoDraftOrder(){
        getRestaurantUI().click(btn_noDraftOrder);
    }

    public void clickNoBtnOnDraftCheckOverlay(){
        getRestaurantUI().click(NoBtnDraftOrder);
    }
    public boolean isDisDashboardTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_disDashboard);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_disDashboard);
    }
    public void clickOnCooksCompanyProduce() {
        getRestaurantUI().click(btn_cooksCompanyProduce);}

    public void clickOnDrafts() {
        getRestaurantUI().clickWithFallback(btn_drafts);}
    public void clickOnChats() {
        getRestaurantUI().clickWithFallback(btn_chats);}
    public void clickOnReports() {
        getRestaurantUI().clickWithFallback(btn_Reports);}
    public void clickOnPay() {
        getRestaurantUI().clickWithFallback(btn_pay);}
    public void clickOnApprovals() {
        getRestaurantUI().clickWithFallback(btn_approvals);}
    public void clickOnCustomers(){
        getRestaurantUI().clickWithFallback(btn_customers);
    }
    public void clickOnOrder() {
        getRestaurantUI().clickWithFallback(btn_order);
        getRestaurantUI().waitForVisibility(txt_dashboard);
    }

    public void clickOnSupplier(String supplierName){
        getRestaurantUI().waitForVisibility(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
        getRestaurantUI().click(By.xpath(supplierTxt.replace("SUPPLIERNAME",supplierName)));
    }


    public boolean isNavigatedToMaxiesSLOrderGuide() {
        getRestaurantUI().waitForVisibility(MaxiesSLTxt);
        return getRestaurantUI().isDisplayed(MaxiesSLTxt);
    }

    public boolean isNavigatedToOrderGuide(String Supplier) {
        getRestaurantUI().waitForVisibility(By.xpath(customerNameText.replace("SUPPLIERNAME",Supplier)),30);
        return getRestaurantUI().isDisplayed(By.xpath(customerNameText.replace("SUPPLIERNAME",Supplier)));
    }

    public void clickOnUsers(){
        getRestaurantUI().clickWithFallback(users);
    }

    public void clickOnRewards() throws InterruptedException {
        getRestaurantUI().clickWithFallback(btn_Rewards);
    }
    public boolean isDistributorDashboardTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_dp_dashboard);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_dp_dashboard);
    }
    public void clickOnCreditRequests(){
        getRestaurantUI().click(btn_credit_requests);
    }
    public void clickLocationFilter(){
        getRestaurantUI().click(locationFilter);
    }
    public void clickOnLocationOption() {
        getRestaurantUI().waitForVisibility(locationOption);
        getRestaurantUI().click(locationOption);
    }
    public void clickOnCatalog(){
        getRestaurantUI().clickWithFallback(btn_catalog);
    }
    public void clickOnOrderSettings(){
        getRestaurantUI().hoverOverElement(btn_viewMore);
        getRestaurantUI().scrollToElement(btn_settings);
        getRestaurantUI().clickUsingJavaScript(btn_settings);
        getRestaurantUI().hoverOverElement(btn_orderSettings);
        getRestaurantUI().clickWithFallback(btn_orderSettings);
    }
    public boolean isChooseProductCatalogDisplayed(){
        getRestaurantUI().waitForVisibility(txt_productCatalog);
        return getRestaurantUI().isDisplayed(txt_productCatalog);
    }
    public void chooseProductCatalog(String name)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(chooseProductCatalog.replace("NAME",name)));
        getRestaurantUI().click(By.xpath(chooseProductCatalog.replace("NAME",name)));
    }
    public void clickOnHome() {
        getRestaurantUI().clickWithFallback(btn_home);
        getRestaurantUI().waitForVisibility(txt_home);
    }
    public boolean isUserNavigateHome()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_home);
    }
    public void switch1932Saval()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_switch1932Saval);
        getRestaurantUI().uiScrollTop();
        getRestaurantUI().click(btn_switch1932Saval);
        getRestaurantUI().waitForCustom(3000);
    }
    public void clickCategory()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_category);
        getRestaurantUI().clickUsingJavaScript(btn_category);
    }
    public void clickNoBtnOnDraftCheckOverlayCatalog(){
        getRestaurantUI().hoverOverElement(NoBtnDraftOrderCatalog);
        getRestaurantUI().clickUsingJavaScript(NoBtnDraftOrderCatalog);
    }
    public void switchSavalFood()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_switchSavalFood);
        getRestaurantUI().click(btn_switchSavalFood);
    }
    public boolean isCatalogDataDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_category);
    }
    public boolean isSavalFoodServiceLogoDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(savalFoodServiceLogo);
    }
    public boolean isSavalFoodServiceBannerDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(savalFoodBanner);
    }
    public boolean isSwitch1932SavalDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_switch1932Saval);
    }
    public boolean isSwitchSavalFoodDisplayed()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_switchSavalFood);
    }
    public boolean isParentDpNameDisplayed(String name)throws InterruptedException{
        return getRestaurantUI().isDisplayed(By.xpath(parentDpName.replace("NAME",name)));
    }
    public void clickOnColonnade() {
        getRestaurantUI().click(btn_colonnade);
    }

    public boolean isChooseCompanyDisplay(String name)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(chooseProductCatalog.replace("NAME",name)));
        return getRestaurantUI().isDisplayed(By.xpath(chooseProductCatalog.replace("NAME",name)));
    }
    public void clickOnProfile(String name) {
        getRestaurantUI().click(By.xpath(txt_profile.replace("NAME",name)));
    }
    public void clickOnSignOutProfile() {
        getRestaurantUI().click(signOutProfile);
    }
    public void clickOutsideModal()throws InterruptedException{
         getRestaurantUI().clickUsingJavaScript(outSideModal);
    }
    public boolean isChatSectionDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(btn_chats_visible);
    }
    public boolean isChatWithUsDisplay(){
        getRestaurantUI().waitForVisibility(btn_chatWithUs);
        return getRestaurantUI().isDisplayed(btn_chatWithUs);
    }
    public boolean isSelectOrderGuidePopUpDisplayed(){
        return getRestaurantUI().isDisplayed(txt_selectOrderGuide);
    }
    public void selectOrderGuide(){
        getRestaurantUI().click(selectOrderGuide);
    }
    public void selectOrderGuideCustom(){
        getRestaurantUI().click(btn_selectOrderGuideCustom);
    }
    public static String getTextAfterCompany() {
        getRestaurantUI().waitForVisibility(wordAfterCompanyLocator);
        return getRestaurantUI().getText(wordAfterCompanyLocator);
    }
    public static void selectIndependentFoodCo() {
        // Click the dropdown
        getDriver().findElement(dropdownToggle).click();
        System.out.println("Dropdown clicked.");

        // Wait for the 'Independent Foods Co' option to be visible and click it
        getRestaurantUI().waitForVisibility(independentFoodOption);
        getDriver().findElement(independentFoodOption).click();

        System.out.println("Company name changed to 'Independent Foods Co'.");
    }

}
