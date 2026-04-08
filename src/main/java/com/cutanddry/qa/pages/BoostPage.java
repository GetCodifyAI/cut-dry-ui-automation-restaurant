package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class BoostPage extends TestBase {

    By btn_boost = By.xpath("(//a[@data-tip='Boost'])[last()]");
    By txt_boost = By.xpath("//h2[normalize-space()='Boost']");
    By tab_suggestiveSales = By.xpath("//a[text()='Suggestive Sales']");
    By txt_topCategoryPicks = By.xpath("//td[text()='Top Category Picks']");
    By btn_topPicks_config = By.xpath("//tr[td[contains(text(), 'Top Category Picks')]]//button[contains(text(), 'View & Configure')]");
    By txt_popupTopCategoryPick = By.xpath("//div[text()='Select a category to configure']");
    By toggleSwitch = By.xpath(" //td[text()='All Items']/parent::tr//div[contains(@class, 'react-switch-handle')]");
    By enableSwitch = By.xpath("//td[text()='All Items']/parent::tr//div[contains(@class, 'react-switch-handle') and contains(@style, 'transform: translateX(19px);')]");
    By btn_allItemConfig = By.xpath("//tr[td[text()='All Items']]//button[contains(text(), 'Configure')]");
    By btn_close = By.xpath("//button[@class='close']");
    String txt_inactive_state =  "//tr[td[contains(text(), \"Type\")] and td[contains(text(), 'Inactive')]]";
    By btn_similar_config = By.xpath("//tr[td[contains(text(), 'Compare Similar Items')]]//button[contains(text(), 'View & Configure')]");
    By txt_popupCompareSimilarItems = By.xpath("//div[text()='Configure item recommendation carousel']");
    By toggle_carouselDisplayStatus = By.xpath("//div[@class='react-switch-handle']");
    By btn_recCustomer_config = By.xpath("//tr[td[contains(text(), 'Recommended for Customer')]]//button[contains(text(), 'View & Configure')]");
    By txt_popupRecommendForCustomer = By.xpath("//div[text()='Configure item recommendation carousel']");
    By btn_recSales_config = By.xpath("//tr[td[contains(text(), 'Recommended by Sales Rep')]]//button[contains(text(), 'View & Configure')]");
    By txt_popupRecommendedBySalesRep = By.xpath("//div[text()='Select a sales rep to configure']");
    String btn_salesRepConfig = "//tr[td[text()='NAME']]//button[text()='Configure']";
    By txt_popupSalesRepConfig = By.xpath("//div[text()='Configure item recommendation carousel']");
    By btn_addItems = By.xpath("//button[text()='Add Items']");
    By input_addItem = By.xpath("//div[text()='Search items by name or code']/following-sibling::div//input");
    String txt_itemAdded = "//div[contains(text(), 'CODE')]";
    By btn_add = By.xpath("//button[text()='Add']");
    String btn_removeItem = "//tr[td[text()='CODE']]//button[text()='Remove']";
    By toggleCarouselDisplayStatus = By.xpath("//div[@class='ml-4']//input[@type='checkbox' and @role='switch' and @checked]");
    By btn_dontforget_config = By.xpath("//tr[td[contains(text(), \"Don't Forget to Order\")]]//button[contains(text(), \"View & Configure\")]");
    By btn_morefrom_config = By.xpath("//tr[td[contains(text(), 'More from this Brand')]]//button[contains(text(), 'View & Configure')]");
    By btn_viewMore = By.xpath("//*[local-name() = 'svg' and @data-icon='cdDotsGrid']");







    public void clickOnBoost(){
        getRestaurantUI().hoverOverElement(btn_viewMore);
        getRestaurantUI().scrollToElement(btn_boost);
        getRestaurantUI().click(btn_boost);
    }
    public boolean isBoostTextDisplayed() {
        try {
            getRestaurantUI().waitForVisibility(txt_boost);
        } catch (Exception e) {
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_boost);
    }
    public void clickSuggestiveSales() {
        getRestaurantUI().click(tab_suggestiveSales);
    }
    public boolean isSuggestiveTabDisplayed() {
        return getRestaurantUI().isDisplayed(txt_topCategoryPicks);
    }
    public void clickTopCategoryPicksConfig() {
        getRestaurantUI().click(btn_topPicks_config);
    }
    public boolean isTopCategoryPopupDisplayed() {
        return getRestaurantUI().isDisplayed(txt_popupTopCategoryPick);
    }
    public void ensureTopCategoryPicksDisplayStatus(boolean enable) throws InterruptedException {
        getRestaurantUI().waitForClickability(toggleSwitch);
        boolean isCurrentlyEnabled = getRestaurantUI().isDisplayed(enableSwitch);
        if (isCurrentlyEnabled != enable) {
            getRestaurantUI().click(toggleSwitch);
            getRestaurantUI().waitForCustom(2000);
        }
    }
    public void clickAllItemsConfig() {
        getRestaurantUI().waitForVisibility(btn_allItemConfig);
        getRestaurantUI().click(btn_allItemConfig);
    }
    public void clickClose() throws InterruptedException {
        getRestaurantUI().click(btn_close);
        getRestaurantUI().waitForCustom(2000);
    }
    public boolean checkInactive(String type) throws InterruptedException {
        getRestaurantUI().waitForCustom(1000);
        return getRestaurantUI().isDisplayed(By.xpath(txt_inactive_state.replace("Type", type)));
    }
    public void clickCompareSimilarItemsConfig() {
        getRestaurantUI().click(btn_similar_config);
    }
    public boolean isCompareSimilarPopupDisplayed() {
        return getRestaurantUI().isDisplayed(txt_popupCompareSimilarItems);
    }
    public void toggleOnCarouselDisplayStatus(boolean inactive) throws InterruptedException {
        if (inactive){
            getRestaurantUI().click(toggle_carouselDisplayStatus);
        }
        getRestaurantUI().waitForCustom(1000);
    }
    public void toggleOffCarouselDisplayStatus() {
        getRestaurantUI().click(toggle_carouselDisplayStatus);
    }
    public void clickRecommendForCustomerConfig() {
        getRestaurantUI().click(btn_recCustomer_config);
    }
    public boolean isRecommendForCustomerPopupDisplayed() {
        return getRestaurantUI().isDisplayed(txt_popupRecommendForCustomer);
    }
    public void clickRecommendBySalesRepConfig() {
        getRestaurantUI().click(btn_recSales_config);
    }
    public boolean isRecommendBySalesRepPopupDisplayed() {
        return getRestaurantUI().isDisplayed(txt_popupRecommendedBySalesRep);
    }
    public void clickSalesRepConfig(String name) {
        getRestaurantUI().waitForVisibility(By.xpath(btn_salesRepConfig.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(btn_salesRepConfig.replace("NAME", name)));
    }
    public boolean isSalesRepConfigPopupDisplayed() {
        return getRestaurantUI().isDisplayed(txt_popupSalesRepConfig);
    }
    public void clickAddItems() {
        getRestaurantUI().clickWithScrollAndHover(btn_addItems);
    }
    public void addItem(String code) {
        getRestaurantUI().waitForVisibility(input_addItem);
        getRestaurantUI().sendKeys(input_addItem, code);
        getRestaurantUI().waitForVisibility(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
        getRestaurantUI().hoverOverElement(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
        getRestaurantUI().click(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
    }
    public void clickAdd() {
        getRestaurantUI().waitForVisibility(btn_add);
        getRestaurantUI().click(btn_add);
    }
    public boolean isItemAdded(String code) {
        return getRestaurantUI().isDisplayed(By.xpath(txt_itemAdded.replace("CODE", code)));
    }
    public void removeItem(String code) {
        getRestaurantUI().clickWithScrollAndHover(By.xpath(btn_removeItem.replace("CODE", code)));
    }
    public boolean isItemInCarouselPreview(String code) {
        return getRestaurantUI().isDisplayed(By.xpath(txt_itemAdded.replace("CODE", code)));
    }
    public void ensureCarouselDisplayStatus(boolean enable) throws InterruptedException {
        if (getRestaurantUI().isCheckboxOrRadioBtnSelected(toggleCarouselDisplayStatus ) != enable){
            getRestaurantUI().click(toggle_carouselDisplayStatus);
        }
        getRestaurantUI().waitForCustom(2000);
    }
    public void clickDontForgetToOrderConfig() {
        getRestaurantUI().click(btn_dontforget_config);
    }
    public void clickMoreFromThisConfig() {
        getRestaurantUI().click(btn_morefrom_config);
    }



}
