package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class HistoryPage extends TestBase {

    By btn_history = By.xpath("//a[contains(., 'History')]");
    By txt_history = By.xpath("//h2[text()='Order History']");
    By btn_search = By.xpath("//input[@placeholder='Search' and contains(@class, 'form-control')]");
    By first_row_order_details = By.xpath("//tr[2]/td[4]");
    By btn_items = By.xpath("//a[@role='tab' and @data-rb-event-key='Items']");
    By header_items_table = By.xpath("//thead/tr/th[1][text()='Item']");
    By btn_timeline = By.xpath("//a[@role='tab' and @data-rb-event-key='Timeline']");
    By header_timeline_table = By.xpath("//thead/tr/th[1][text()='Timestamp']");
    String search_result = "//tr[contains(@href,'/orders-revised/view-one')]//following-sibling::td[contains(.,'ORDERID')]";
    By btn_more_filters = By.xpath("//button[@type='button' and contains(text(), 'More Filters')]");
    By txt_filter_orders = By.xpath("//div[contains(text(), 'Filter Orders')]");
    By btn_location = By.xpath("//html/body/div[6]/div/div/div/div[2]/form/div[1]/div/div");

    public void clickHistory(){ restaurantUI.click(btn_history); }

    public boolean isHistoryTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_history);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_history);
    }

    public void clickOnSearch(){
        restaurantUI.click(btn_search);
    }
    public void typeOnSearch(String orderID) throws InterruptedException {
        restaurantUI.clear(btn_search);
        restaurantUI.sendKeys(btn_search, orderID);
        restaurantUI.waitForCustom(400);
    }

    public boolean checkIfSearchedElementVisible(String orderID) {

    return restaurantUI.isDisplayed(By.xpath(search_result.replace("ORDERID",orderID)));
    }

    public void clickOnFirstItemOfOrderHistory(){
        try {
            restaurantUI.waitForCustom(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(first_row_order_details);
    }

    public boolean isErrorTextNotDisplayed() {
    try {
        restaurantUI.waitForCustom(3000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    return restaurantUI.isDisplayed(header_items_table);
    }

    public void clickOnItems(){
        restaurantUI.click(btn_items);
    }

    public boolean checkIfItemSectionVisible() {
        restaurantUI.waitForVisibility(header_items_table);
    return restaurantUI.isDisplayed(header_items_table);
    }
    public void clickOnTimeline(){
        restaurantUI.click(btn_timeline);
    }
    public boolean checkIfTimelineSectionVisible() {
        return restaurantUI.isDisplayed(header_timeline_table);
    }
    public void clickOnMoreFilters(){
        restaurantUI.waitForVisibility(btn_more_filters);
        restaurantUI.click(btn_more_filters);
    }
    public boolean isFilterOrdersPopupDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_filter_orders);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_filter_orders);
    }

    public void clickLocation(){
        restaurantUI.click(btn_location);
    }










}
