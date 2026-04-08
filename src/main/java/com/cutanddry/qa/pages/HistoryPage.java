package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class HistoryPage extends TestBase {
    By btn_close = By.xpath("//span[text()='×']");
    By btn_history = By.xpath("(//a[contains(., 'History')])[1]");
    By txt_history = By.xpath("//h2[text()='Order History']");
    By btn_search = By.xpath("//input[@placeholder='Search' and contains(@class, 'form-control')]");
    By first_row_order_details = By.xpath("//tr[2]/td[4]");
    By btn_items = By.xpath("//a[@role='tab' and @data-rb-event-key='Items']");
    By header_items_table = By.xpath("//thead/tr/th[1]//div[text()='Item']");
    By btn_timeline = By.xpath("//a[@role='tab' and @data-rb-event-key='Timeline']");
    By header_timeline_table = By.xpath("//thead/tr/th[1][text()='Timestamp']");
    String search_result = "//tr[contains(@href,'/orders-revised/view-one')][1]//following-sibling::td[contains(.,'ORDERID')]";
    By btn_more_filters = By.xpath("//button[@type='button' and contains(text(), 'More Filters')]");
    By txt_filter_orders = By.xpath("//div[contains(text(), 'Filter Orders')]");
    By btn_location = By.xpath("//form/div[1]/div/div");
    By btn_option = By.xpath("//div[@class='themed_select__option css-yt9ioa-option' and text()='Hayes']");
    By btn_save = By.xpath("//button[text()='Save']");
    String filter_result = "//tr//td[3]//div[text()='LOCATION']";
    By btn_more_options = By.xpath("//span[text() = 'More Options']");
    By btn_print_order =By.xpath("//div[text() ='Print Order']");
    By txt_order_section = By.xpath("//div[starts-with(text(), 'Order #')]");
    By btn_add_note =By.xpath("//span[contains(normalize-space(),'Add notes to this order')]");
    By txt_add_note = By.xpath("//div[@class = 'mont modal-title h4' and text()='Add Order Notes']");
    By btn_textarea =By.xpath("//textarea[@class = 'form-control']");
    By btn_save_changes =By.xpath("//button[@class='mt-2 btn btn-primary btn-block' and text() = 'Save Changes']");
    String order_note_result ="//span[@class='_14u1hku _du1frc' and text()='NOTE']";
    By btn_checkin = By.xpath("//span[text() = 'Check-In Order']");
    By txt_checkin_order_section = By.xpath("//h2[@class='mb-0 _1vx3fhy' and starts-with(text(), 'Check-In Order #')]");
    By btn_checkin_all = By.xpath("//button[@class = 'btn btn-primary' and text()='Check-In All']");
    By txt_chekin_popup = By.xpath("//h2[@id = 'swal2-title' and text()='Check-in all items?']");
    By btn_confirm =By.xpath("//button[@class = 'swal2-confirm swal2-styled' and text()='Confirm']");
    By txt_checkin_status = By.xpath("//span[text()='Status']/following-sibling::span[text()='Checked In']");
    By btn_cancel_order = By.xpath("//span[text() = 'Cancel Order']");
    By txt_cancel_order = By.xpath("//h2[@id = 'swal2-title' and text() = 'Cancel Order?']");
    By btn_confirm_order = By.xpath("//button[@class = 'swal2-confirm order-2 swal2-styled' and text()='Confirm']");
    By btn_edit_order = By.xpath("//span[text() = 'Edit Order']");
    By txt_edit_order = By.xpath("//h2[@id = 'swal2-title' and text() = 'Edit Order?']");
    By btn_edit_quantity = By.xpath("(//div[contains(@class,'align-middle')]/*[contains(@data-icon,'plus')])[1]");
    By btn_checkout_edit_order = By.xpath("//button[contains(@data-tip, 'Click here to checkout')][normalize-space()!='']");
    By btn_submit_edit_order = By.xpath("//button[@id='submit-order-button' and text()='Submit Order Edits']");
//    By txt_review_order = By.xpath("//div[@class='d-flex align-items-center _5h4pkd _11zeigs' and text()='Review Order']");
    By txt_review_order = By.xpath("//div[text()='Review Order']");
    By btn_ok_edit_order = By.xpath("//button[text()='OK']");
    By txt_ok_edit_order = By.xpath("//*[contains(text(),'Order edit requested')]");
    By btn_recreate_order = By.xpath("//div[text() ='Recreate Order']");
    By lastOrderId = By.xpath("(//tr[contains(@href,'/orders-revised/view-one')])[last()]//td//*[contains(text(),'#')]");
    By lbl_orderDateDropdown = By.xpath("//label[contains(text(),'Order Date:')]/following-sibling::div");
    By lbl_statusDropdown = By.xpath("//label[contains(text(),'Order Status:')]/following-sibling::div");
    String days = "//div[text()='DATE']";
    String date = "//td[text()='DATE']";
    String sts = "//div[text()='STATUS']";
    By txt_status = By.xpath("(//td[10])[1]/div[1]");
    String status = "//td/span[text()='STATUS']";
    By btn_uploadInvoices = By.xpath("//button[contains(text(),'Upload Invoice')]");
    By txt_uploadInvoices = By.xpath("//div[contains(text(),'Upload & Scan Invoice')]");
    By selectSupplierDropDown = By.xpath("//label[contains(text(),'Select the supplier of this order')]/following-sibling::div");
    By restaurantLocationDropDown = By.xpath("//label[contains(text(),'To which restaurant location was this order for?')]/following-sibling::div");
    By invoiceUploadedPopUp = By.xpath("//h2[text()='Invoice Uploaded']");
    By btn_ok = By.xpath("//button[text()='OK']");
    String dropDownOption = "//div[text()='OPTION']";
    String locationDropDownOption = "//div[contains(@class,'themed_select__option') and text()='OPTION']";
    By invoiceUploadStatus = By.xpath("(//td//span[text()='Invoice Upload'])[1]");
    By btn_orderCheckoutReview = By.xpath("//div[text()='Total']/following-sibling::div[normalize-space()!='']");
    By btn_orderItemCountReview = By.xpath("//div[text()='Total Qty']/following-sibling::*//span[1]");
    String orderTitle = "//*[contains(text(),'Order Number #ORDER_ID')]";
    By btn_submittedOrderTotal = By.xpath("(//*[contains(text(), 'Total')]/following-sibling::*[normalize-space()!=''])[last()]");
    By lbl_orderTableColumn = By.xpath("//table/thead/tr/th");
    String lbl_orderTableColumnName = "//table/thead/tr/th[COUNT]/span";
    By lbl_orderTableRow = By.xpath("//tbody/tr");
    String lbl_orderTableRef = "//tbody/tr[TR_COUNT]/td[TH_COUNT]";
    By btn_invoice = By.xpath("//a[@role='tab' and @data-rb-event-key='Invoice']");
    By btn_downloadInvoice = By.xpath("//button[contains(text(),'Download Invoice')]");
    By btn_printInvoice = By.xpath("//button[contains(text(),'Print Invoice')]");

    By lbl_orderDateColumn = By.xpath("//span[contains(text(),'Order Date')]");
    By lbl_orderDateArrowUp = By.xpath("//span[contains(text(),'Order Date')]/*[name()='svg' and contains(@data-icon, 'arrow-up')]");
    By lbl_orderDateArrowDown = By.xpath("//span[contains(text(),'Order Date')]/*[name()='svg' and contains(@data-icon, 'arrow-down')]");
    By icon_deleteSearchItem = By.xpath("(//*[local-name()='svg' and @data-icon='circle-xmark'])[1]");
    By txt_addToOrder = By.xpath("//h2[text() = 'Add to Order?']");



    public void clickClose(){
        getRestaurantUI().waitForVisibility(btn_close);
        getRestaurantUI().click(btn_close);
    }
    public void clickHistory(){
        getRestaurantUI().clickWithFallback(btn_history);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isHistoryTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_history);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_history);
    }

    public void clickOnSearch(){
        getRestaurantUI().click(btn_search);
    }
    public void typeOnSearch(String orderID) throws InterruptedException {
        getRestaurantUI().clear(btn_search);
        getRestaurantUI().click(icon_deleteSearchItem);
        getRestaurantUI().sendKeys(btn_search, orderID);
        getRestaurantUI().waitForCustom(400);
    }

    public boolean checkIfSearchedElementVisible(String orderID) {
        getRestaurantUI().waitForVisibility(By.xpath(search_result.replace("ORDERID",orderID)));
        if (!getRestaurantUI().isDisplayed(By.xpath(search_result.replace("ORDERID",orderID)))) {
            getRestaurantUI().refreshPage();
        }
        return getRestaurantUI().isDisplayed(By.xpath(search_result.replace("ORDERID",orderID)));
    }

    public boolean checkIfFilteredElementVisible(String location){
        return getRestaurantUI().isDisplayed(By.xpath(filter_result.replace("LOCATION",location)));
    }

    public void clickOnFirstItemOfOrderHistory(){
        getRestaurantUI().waitForVisibility(first_row_order_details);
        getRestaurantUI().click(first_row_order_details);
    }
    public boolean isOrderSectionDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_order_section);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_order_section);
    }

    public void clickOnItems(){
        getRestaurantUI().click(btn_items);
    }
    public boolean checkIfItemSectionVisible() {
        getRestaurantUI().waitForVisibility(header_items_table);
        return getRestaurantUI().isDisplayed(header_items_table);
    }
    public void clickOnTimeline(){
        getRestaurantUI().click(btn_timeline);
    }
    public boolean checkIfTimelineSectionVisible() {
        return getRestaurantUI().isDisplayed(header_timeline_table);
    }
    public void clickOnMoreFilters(){
        getRestaurantUI().waitForVisibility(btn_more_filters);
        getRestaurantUI().click(btn_more_filters);
    }
    public boolean isFilterOrdersPopupDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_filter_orders);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_filter_orders);
    }

    public void clickLocation(){
        getRestaurantUI().click(btn_location);
    }

    public void clickOption(){
        getRestaurantUI().click(btn_option);
    }

    public void clickSave(){
        getRestaurantUI().click(btn_save);
    }
    public void clickMoreOptions(){
        getRestaurantUI().click(btn_more_options);
    }
    public void clickPrintOrder(){
        getRestaurantUI().click(btn_print_order);
    }
    public void clickAddNotes(){
        getRestaurantUI().click(btn_add_note);
    }
    public boolean isAddNotePopUpWindowDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_add_note);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_add_note);
    }
    public void clickTextarea(){
        getRestaurantUI().click(btn_textarea);
    }
    public void typeOrderNote(String orderNote) throws InterruptedException {
        getRestaurantUI().clear(btn_textarea);
        getRestaurantUI().sendKeys(btn_textarea, orderNote);
        getRestaurantUI().waitForCustom(400);
    }
    public void clickSaveChanges(){
        getRestaurantUI().click(btn_save_changes);
    }
    public boolean checkOrderNoteVisible(String orderNote){
        return getRestaurantUI().isDisplayed(By.xpath(order_note_result.replace("NOTE",orderNote)));
    }
    public void clickCheckIn(){
        getRestaurantUI().click(btn_checkin);
    }
    public boolean isCheckInOrderSectionDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_checkin_order_section);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_checkin_order_section);
    }
    public void clickCheckInAll(){
        getRestaurantUI().click(btn_checkin_all);
    }
    public boolean isCheckInAllPopupDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_chekin_popup);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_chekin_popup);
    }
    public void clickConfirm(){
        getRestaurantUI().click(btn_confirm);
    }
    public boolean isCheckInOrderStatusDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_checkin_status);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_checkin_status);
    }
    public void clickCancel(){
        getRestaurantUI().click(btn_cancel_order);
    }
    public boolean isCancelOrderPopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_cancel_order);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_cancel_order);
    }
    public void clickConfirmCancelOrder(){
        getRestaurantUI().click(btn_confirm_order);
    }
    public void clickEditOrder(){
        getRestaurantUI().waitForVisibility(btn_edit_order);
        getRestaurantUI().click(btn_edit_order);
    }
    public boolean isEditOrderPopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_edit_order);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_edit_order);
    }
    public void clickConfirmEditOrder(){
        getRestaurantUI().click(btn_confirm_order);
        try {
            getRestaurantUI().waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isReviewOrderTextDisplayed(){
//        getRestaurantUI().waitForVisibility(txt_review_order);
        return getRestaurantUI().isDisplayed(txt_review_order,3);

    }
    public void increaseFirstRowQtyByOne()throws InterruptedException{
        getRestaurantUI().click(btn_edit_quantity);
        getRestaurantUI().waitForCustom(4000);

    }
    public void clickSubmitEditOrder(){
        getRestaurantUI().click(btn_submit_edit_order);
    }
    public void clickCheckOutEditOrder(){
        getRestaurantUI().click(btn_checkout_edit_order);
    }
    public boolean isOrderEditRequestPopupDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_ok_edit_order);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_ok_edit_order);
    }
    public void clickOkEditOrder(){
        getRestaurantUI().click(btn_ok_edit_order);
    }
    public void clickRecreateOrder(){
        getRestaurantUI().click(btn_recreate_order);
    }

    public String getLastOrderReference(){
        return getRestaurantUI().getText(lastOrderId).split("#")[1];
    }
    public String getLastWorkingDate() {
        return getRestaurantUI().getLastWorkingDay();
    }
    public void selectOrderDate(String day){
        getRestaurantUI().click(lbl_orderDateDropdown);
        getRestaurantUI().waitForVisibility(By.xpath(days.replace("DATE", day)));
        getRestaurantUI().click(By.xpath(days.replace("DATE", day)));
    }
    public boolean isOrderDateChanged(String day){
        try {
            return getRestaurantUI().isDisplayed(By.xpath(days.replace("DATE", day)));
        } catch (Exception e){
            return false;
        }
    }
    public Boolean isFilteredOrdersCorrectOld(String OrdersDate){
        getRestaurantUI().waitForVisibility(By.xpath("("+ date.replace("DATE", OrdersDate) + ")" + "[last()]"));
        //getRestaurantUI().scrollToElementStable(By.xpath("("+ date.replace("DATE", OrdersDate) + ")" + "[last()]"));
        return getRestaurantUI().isDisplayed(By.xpath("("+ date.replace("DATE", OrdersDate) + ")" + "[last()]"));
    }

    public Boolean isFilteredOrdersCorrect(String OrdersDate) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        By orderDateXPath = By.xpath("(" + date.replace("DATE", OrdersDate) + ")[last()]");
        getRestaurantUI().scrollToElementStable(orderDateXPath, 5);
        if (getRestaurantUI().isDisplayed(orderDateXPath, 5)) {
            return true;
        }
        return false;
    }

    public void selectOrderStatus(String stat){
        getRestaurantUI().click(lbl_statusDropdown);
        getRestaurantUI().waitForVisibility(By.xpath(sts.replace("STATUS", stat)));
        getRestaurantUI().click(By.xpath(sts.replace("STATUS", stat)));
    }
    public boolean isOrderStatusChanged(String stat){
        try {
            getRestaurantUI().isDisplayed(By.xpath(sts.replace("STATUS", stat)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(sts.replace("STATUS", stat)));
    }
    public Boolean isFilteredOrderStatusCorrect(String OrdersStatus){
        getRestaurantUI().waitForVisibility(txt_status);
        String s = getRestaurantUI().getText(txt_status);
        getRestaurantUI().scrollToElement(By.xpath("("+ status.replace("STATUS", s) + ")" + "[last()]"));
        return getRestaurantUI().validateFilteredElements(By.xpath(status.replace("STATUS", s)),OrdersStatus);
    }
    public void clickUploadInvoices()throws InterruptedException{
        getRestaurantUI().click(btn_uploadInvoices);
    }
    public boolean isUploadInvoicesWindowDisplayed()throws InterruptedException{
        try {
            getRestaurantUI().waitForVisibility(txt_uploadInvoices);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_uploadInvoices);
    }
    public void selectSupplierInvoice(String option)throws InterruptedException{
        getRestaurantUI().waitForVisibility(selectSupplierDropDown);
        getRestaurantUI().click(selectSupplierDropDown);
        getRestaurantUI().click(By.xpath(dropDownOption.replace("OPTION", option)));
    }
    public void selectRestaurantLocation(String option)throws InterruptedException{
        getRestaurantUI().waitForVisibility(restaurantLocationDropDown);
        getRestaurantUI().click(restaurantLocationDropDown);
        getRestaurantUI().click(By.xpath(locationDropDownOption.replace("OPTION", option)));
    }
    public boolean isInvoicesUploadedPopUpDisplayed()throws InterruptedException{
        try {
            getRestaurantUI().waitForVisibility(invoiceUploadedPopUp);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(invoiceUploadedPopUp);
    }
    public void clickOkInvoice()throws InterruptedException{
        getRestaurantUI().click(btn_ok);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().refreshPage();
    }
    public boolean isInvoicesUploadedStatusDisplayed()throws InterruptedException{
        try {
            getRestaurantUI().waitForVisibility(invoiceUploadStatus);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(invoiceUploadStatus);
    }

    public Double getItemPriceOnMultiOUM() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_orderCheckoutReview);
        String priceText = getRestaurantUI().getText(btn_orderCheckoutReview).replace("$", "").replace(",", "");
        return Double.valueOf(priceText);
    }

    public Double getItemCountOnReviewMultiOUM() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_orderItemCountReview);
        String priceText = getRestaurantUI().getText(btn_orderItemCountReview);
        return Double.valueOf(priceText);
    }

    public boolean isOrderIdDisplayed(String orderId) {
        getRestaurantUI().waitForVisibility(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
        return getRestaurantUI().isDisplayed(By.xpath(orderTitle.replace("ORDER_ID", orderId)));
    }

    public Double getItemPriceOnSubmittedOrder() throws InterruptedException {
        getRestaurantUI().waitForVisibility(btn_submittedOrderTotal);
        String priceText = getRestaurantUI().getText(btn_submittedOrderTotal).replace("$", "").replace(",", "");
        return Double.valueOf(priceText);
    }

   /* public void clickOnOrder(String orderId) {
        for (int i = 1; i <= getRestaurantUI().countElements(lbl_orderTableColumn); i++) {
            if ("Reference".equalsIgnoreCase(getRestaurantUI().getText(By.xpath(lbl_orderTableColumnName.replace("COUNT", String.valueOf(i)))))) {
                for (int j = 1; j <= getRestaurantUI().countElements(lbl_orderTableRow); j++) {
                    String xpath = lbl_orderTableRef.replace("TR_COUNT", String.valueOf(j)).replace("TH_COUNT", String.valueOf(i));

                    String referenceData;
                    try {
                        referenceData = getRestaurantUI().getText(2,By.xpath(xpath)).trim();
                    } catch (Exception e) {
                        continue;
                    }

                    if (!referenceData.isEmpty() && orderId.equalsIgnoreCase(referenceData.replace("Order",""))) {
                        getRestaurantUI().click(By.xpath(xpath));
                        return;
                    }
                }
            }
        }
    }*/

    public void clickOnOrder(String orderId) {
        int maxRecords = 15;
        for (int i = 1; i <= getRestaurantUI().countElements(lbl_orderTableColumn); i++) {
            String columnName = getRestaurantUI().executeJSForText(By.xpath(lbl_orderTableColumnName.replace("COUNT", String.valueOf(i))));

            if ("Reference".equalsIgnoreCase(columnName)) {
                int totalRows = Math.min(getRestaurantUI().countElements(lbl_orderTableRow), maxRecords);
                for (int j = 1; j <= totalRows; j++) {
                    String xpath = lbl_orderTableRef.replace("TR_COUNT", String.valueOf(j)).replace("TH_COUNT", String.valueOf(i));

                    String referenceData;
                    try {
                        referenceData = getRestaurantUI().executeJSForText(By.xpath(xpath));
                    } catch (Exception e) {
                        continue;
                    }

                    if (!referenceData.isEmpty() && orderId.equalsIgnoreCase(referenceData.replace("Order", "").trim())) {
                        getRestaurantUI().click(By.xpath(xpath));  // You can replace this with JS click if needed
                        return;
                    }
                }
            }
        }
    }
    public void clickOnInvoiceTab(){
        getRestaurantUI().click(btn_invoice);
    }
    public void clickOnDownloadInvoice(){
        getRestaurantUI().click(btn_downloadInvoice);
    }
    public void clickOnPrintInvoice(){
        getRestaurantUI().click(btn_printInvoice);
    }

    public void ensureOrderDateSortedDescending() throws InterruptedException {

        getRestaurantUI().waitForVisibility(lbl_orderDateColumn);
        getRestaurantUI().click(lbl_orderDateColumn);

        if (getRestaurantUI().isDisplayed(lbl_orderDateArrowUp)) {
            getRestaurantUI().click(lbl_orderDateColumn);
            getRestaurantUI().waitForCustom(2000);
        }

    }
    public void refreshHistoryPage(){
        getRestaurantUI().refreshPage();
    }
    public boolean isAddToOrderPopUpDisplayed(){
        return getRestaurantUI().isDisplayed(txt_addToOrder);
    }
}
