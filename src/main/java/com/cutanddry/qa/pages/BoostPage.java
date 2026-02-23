package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class BoostPage extends TestBase {

    By btn_boost = By.xpath("(//a[@data-tip='Boost'])[last()]");
    By txt_boost = By.xpath("//li[contains(text(),'Boost')]");
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
        restaurantUI.hoverOverElement(btn_viewMore);
        restaurantUI.scrollToElement(btn_boost);
        restaurantUI.click(btn_boost);
    }
    public boolean isBoostTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_boost);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_boost);
    }
    public void clickSuggestiveSales() {
        restaurantUI.click(tab_suggestiveSales);
    }
    public boolean isSuggestiveTabDisplayed() {
        return restaurantUI.isDisplayed(txt_topCategoryPicks);
    }
    public void clickTopCategoryPicksConfig() {
        restaurantUI.click(btn_topPicks_config);
    }
    public boolean isTopCategoryPopupDisplayed() {
        return restaurantUI.isDisplayed(txt_popupTopCategoryPick);
    }
    public void ensureTopCategoryPicksDisplayStatus(boolean enable) throws InterruptedException {
        restaurantUI.waitForClickability(toggleSwitch);
        boolean isCurrentlyEnabled = restaurantUI.isDisplayed(enableSwitch);
        if (isCurrentlyEnabled != enable) {
            restaurantUI.click(toggleSwitch);
            restaurantUI.waitForCustom(2000);
        }
    }
    public void clickAllItemsConfig() {
        restaurantUI.waitForVisibility(btn_allItemConfig);
        restaurantUI.click(btn_allItemConfig);
    }
    public void clickClose() throws InterruptedException {
        restaurantUI.click(btn_close);
        restaurantUI.waitForCustom(2000);
    }
    public boolean checkInactive(String type) throws InterruptedException {
        restaurantUI.waitForCustom(1000);
        return restaurantUI.isDisplayed(By.xpath(txt_inactive_state.replace("Type", type)));
    }
    public void clickCompareSimilarItemsConfig() {
        restaurantUI.click(btn_similar_config);
    }
    public boolean isCompareSimilarPopupDisplayed() {
        return restaurantUI.isDisplayed(txt_popupCompareSimilarItems);
    }
    public void toggleOnCarouselDisplayStatus(boolean inactive) throws InterruptedException {
        if (inactive){
            restaurantUI.click(toggle_carouselDisplayStatus);
        }
        restaurantUI.waitForCustom(1000);
    }
    public void toggleOffCarouselDisplayStatus() {
        restaurantUI.click(toggle_carouselDisplayStatus);
    }
    public void clickRecommendForCustomerConfig() {
        restaurantUI.click(btn_recCustomer_config);
    }
    public boolean isRecommendForCustomerPopupDisplayed() {
        return restaurantUI.isDisplayed(txt_popupRecommendForCustomer);
    }
    public void clickRecommendBySalesRepConfig() {
        restaurantUI.click(btn_recSales_config);
    }
    public boolean isRecommendBySalesRepPopupDisplayed() {
        return restaurantUI.isDisplayed(txt_popupRecommendedBySalesRep);
    }
    public void clickSalesRepConfig(String name) {
        restaurantUI.waitForVisibility(By.xpath(btn_salesRepConfig.replace("NAME", name)));
        restaurantUI.click(By.xpath(btn_salesRepConfig.replace("NAME", name)));
    }
    public boolean isSalesRepConfigPopupDisplayed() {
        return restaurantUI.isDisplayed(txt_popupSalesRepConfig);
    }
    public void clickAddItems() {
        restaurantUI.clickWithScrollAndHover(btn_addItems);
    }
    public void addItem(String code) {
        restaurantUI.waitForVisibility(input_addItem);
        restaurantUI.sendKeys(input_addItem, code);
        restaurantUI.waitForVisibility(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
        restaurantUI.hoverOverElement(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
        restaurantUI.click(By.xpath(txt_itemAdded.replace("CODE", code+" : ")));
    }
    public void clickAdd() {
        restaurantUI.waitForVisibility(btn_add);
        restaurantUI.click(btn_add);
    }
    public boolean isItemAdded(String code) {
        return restaurantUI.isDisplayed(By.xpath(txt_itemAdded.replace("CODE", code)));
    }
    public void removeItem(String code) {
        restaurantUI.clickWithScrollAndHover(By.xpath(btn_removeItem.replace("CODE", code)));
    }
    public boolean isItemInCarouselPreview(String code) {
        return restaurantUI.isDisplayed(By.xpath(txt_itemAdded.replace("CODE", code)));
    }
    public void ensureCarouselDisplayStatus(boolean enable) throws InterruptedException {
        if (restaurantUI.isCheckboxOrRadioBtnSelected(toggleCarouselDisplayStatus ) != enable){
            restaurantUI.click(toggle_carouselDisplayStatus);
        }
        restaurantUI.waitForCustom(2000);
    }
    public void clickDontForgetToOrderConfig() {
        restaurantUI.click(btn_dontforget_config);
    }
    public void clickMoreFromThisConfig() {
        restaurantUI.click(btn_morefrom_config);
    }



}
