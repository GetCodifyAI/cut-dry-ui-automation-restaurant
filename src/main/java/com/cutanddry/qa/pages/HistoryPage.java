package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class HistoryPage extends TestBase {
    By btn_close = By.xpath("//span[text()='×']");
    By btn_history = By.xpath("//a[contains(., 'History')]");
    By txt_history = By.xpath("//h2[text()='Order History']");
    By btn_search = By.xpath("//input[@placeholder='Search' and contains(@class, 'form-control')]");
    By first_row_order_details = By.xpath("//tr[2]/td[4]");
    By btn_items = By.xpath("//a[@role='tab' and @data-rb-event-key='Items']");
    By header_items_table = By.xpath("//thead/tr/th[1][text()='Item']");
    By btn_timeline = By.xpath("//a[@role='tab' and @data-rb-event-key='Timeline']");
    By header_timeline_table = By.xpath("//thead/tr/th[1][text()='Timestamp']");
    String search_result = "//tr[contains(@href,'/orders-revised/view-one')][1]//following-sibling::td[contains(.,'ORDERID')]";
    By btn_more_filters = By.xpath("//button[@type='button' and contains(text(), 'More Filters')]");
    By txt_filter_orders = By.xpath("//div[contains(text(), 'Filter Orders')]");
    By btn_location = By.xpath("//form/div[1]/div/div");
    By btn_option = By.xpath("//div[@class='themed_select__option css-yt9ioa-option' and text()='Hayes']");
    By btn_save = By.xpath("//button[text()='Save']");
    String filter_result = "//tr//td[3]//div[text()='LOCATION']";
    By btn_more_options = By.xpath("//button[@class='dropdown-toggle btn btn-link']");
    By btn_print_order =By.xpath("//a[@class='_gozzbg dropdown-item' and text() ='Print Order']");
    By txt_order_section = By.xpath("//h2[@class='mb-0 _1vx3fhy' and starts-with(text(), 'Order #')]");
    By btn_add_note =By.xpath("//div[@class='col-auto col']");
    By txt_add_note = By.xpath("//div[@class = 'mont modal-title h4' and text()='Add Order Notes']");
    By btn_textarea =By.xpath("//textarea[@class = 'form-control']");
    By btn_save_changes =By.xpath("//button[@class='mt-2 btn btn-primary btn-block' and text() = 'Save Changes']");
    String order_note_result ="//span[@class='_14u1hku _du1frc' and text()='NOTE']";
    By btn_checkin = By.xpath("//button[@class = 'mr-3 btn btn-outline-primary' and text() = 'Check-In Order']");
    By txt_checkin_order_section = By.xpath("//h2[@class='mb-0 _1vx3fhy' and starts-with(text(), 'Check-In Order #')]");
    By btn_checkin_all = By.xpath("//button[@class = 'btn btn-primary' and text()='Check-In All']");
    By txt_chekin_popup = By.xpath("//h2[@id = 'swal2-title' and text()='Check-in all items?']");
    By btn_confirm =By.xpath("//button[@class = 'swal2-confirm swal2-styled' and text()='Confirm']");
    By txt_checkin_status = By.xpath("//div[@class = 'themed_select__single-value css-1uccc91-singleValue' and text()='Order Status: Checked In']");
    By btn_cancel_order = By.xpath("//button[@class = 'mr-3 btn btn-outline-danger' and text() = 'Cancel Order']");
    By txt_cancel_order = By.xpath("//h2[@id = 'swal2-title' and text() = 'Cancel Order?']");
    By btn_confirm_order = By.xpath("//button[@class = 'swal2-confirm order-2 swal2-styled' and text()='Confirm']");
    By btn_edit_order = By.xpath("//button[@class = 'mr-3 btn btn-outline-primary' and text() = 'Edit Order']");
    By txt_edit_order = By.xpath("//h2[@id = 'swal2-title' and text() = 'Edit Order?']");
    By btn_edit_quantity = By.xpath("(//div[contains(@class,'align-middle')]/*[contains(@data-icon,'plus')])[1]");
    By btn_submit_edit_order = By.xpath("//button[@id='submit-order-button' and text()='Submit Order Edits']");
    By txt_review_order = By.xpath("//div[@class='d-flex align-items-center _5h4pkd _11zeigs' and text()='Review Order']");
    By btn_ok_edit_order = By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']");
    By txt_ok_edit_order = By.xpath("//h2[@id='swal2-title' and text()='Order edit request has been sent.']");
    By btn_recreate_order = By.xpath("//a[@class='_gozzbg dropdown-item' and text() ='Recreate Order']");
    By lastOrderId = By.xpath("(//tr[contains(@href,'/orders-revised/view-one')])[last()]//td[contains(text(),'#')]");

    public void clickClose(){
        restaurantUI.click(btn_close);
    }
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

    public boolean checkIfFilteredElementVisible(String location){
        return restaurantUI.isDisplayed(By.xpath(filter_result.replace("LOCATION",location)));
    }

    public void clickOnFirstItemOfOrderHistory(){
        try {
            restaurantUI.waitForCustom(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(first_row_order_details);
    }
    public boolean isOrderSectionDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_order_section);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_order_section);
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

    public void clickOption(){
        restaurantUI.click(btn_option);
    }

    public void clickSave(){
        restaurantUI.click(btn_save);
    }
    public void clickMoreOptions(){
        restaurantUI.click(btn_more_options);
    }
    public void clickPrintOrder(){
        restaurantUI.click(btn_print_order);
    }
    public void clickAddNotes(){
        restaurantUI.click(btn_add_note);
    }
    public boolean isAddNotePopUpWindowDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_add_note);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_add_note);
    }
    public void clickTextarea(){
        restaurantUI.click(btn_textarea);
    }
    public void typeOrderNote(String orderNote) throws InterruptedException {
        restaurantUI.clear(btn_textarea);
        restaurantUI.sendKeys(btn_textarea, orderNote);
        restaurantUI.waitForCustom(400);
    }
    public void clickSaveChanges(){
        restaurantUI.click(btn_save_changes);
    }
    public boolean checkOrderNoteVisible(String orderNote){
        return restaurantUI.isDisplayed(By.xpath(order_note_result.replace("NOTE",orderNote)));
    }
    public void clickCheckIn(){
        restaurantUI.click(btn_checkin);
    }
    public boolean isCheckInOrderSectionDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_checkin_order_section);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_checkin_order_section);
    }
    public void clickCheckInAll(){
        restaurantUI.click(btn_checkin_all);
    }
    public boolean isCheckInAllPopupDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_chekin_popup);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_chekin_popup);
    }
    public void clickConfirm(){
        restaurantUI.click(btn_confirm);
    }
    public boolean isCheckInOrderStatusDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_checkin_status);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_checkin_status);
    }
    public void clickCancel(){
        restaurantUI.click(btn_cancel_order);
    }
    public boolean isCancelOrderPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_cancel_order);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_cancel_order);
    }
    public void clickConfirmCancelOrder(){
        restaurantUI.click(btn_confirm_order);
    }
    public void clickEditOrder(){
        restaurantUI.click(btn_edit_order);
    }
    public boolean isEditOrderPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_edit_order);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_edit_order);
    }
    public void clickConfirmEditOrder(){
        restaurantUI.click(btn_confirm_order);
    }
    public boolean isReviewOrderTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_review_order);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_review_order);

    }
    public void increaseFirstRowQtyByOne()throws InterruptedException{
        restaurantUI.click(btn_edit_quantity);
        restaurantUI.waitForCustom(4000);

    }
    public void clickSubmitEditOrder(){
        restaurantUI.click(btn_submit_edit_order);
    }
    public boolean isOrderEditRequestPopupDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_ok_edit_order);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_ok_edit_order);
    }
    public void clickOkEditOrder(){
        restaurantUI.click(btn_ok_edit_order);
    }
    public void clickRecreateOrder(){
        restaurantUI.click(btn_recreate_order);
    }

    public String getLastOrderReference(){
        return restaurantUI.getText(lastOrderId).split("#")[1];
    }

}
