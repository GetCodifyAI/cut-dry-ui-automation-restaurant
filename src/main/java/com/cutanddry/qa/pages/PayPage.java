package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class PayPage extends TestBase{

    By btn_pay = By.xpath("//a[contains(@data-tip, 'View Invoices')]");
    By btn_paymentSettings = By.xpath("//button[contains(text(),'Payment Settings')]");
    By txt_paymentSettings = By.xpath("//h2[@class='_5kripx' and text()='Payment Settings']");
    By text_visibilityOfPaySuppliers = By.xpath("//h2[contains(text(),'Pay Suppliers')]");
    By btn_payOption = By.xpath("(//button[text()='Pay'])[1]");
    By txt_invoiceIdNo = By.xpath("//div[contains(@class,'_ozzg7w')]");
    By btn_addPaymentMethod = By.xpath("//div[contains(text(),'Add Payment Method')]");
    By text_visibilityOfAddPaymentMethod = By.xpath("//h2[contains (text(),'Add payment method')]");
    By btn_bankAccountOption = By.xpath("//div[contains(text(),'Bank account')]");
    By txt_visibilityOfAddBankAccount = By.xpath("//h2[contains (text(),'Add bank account')]");
    By txb_accNo = By.xpath("//label[contains(text(),'Account Number')]/following-sibling::input");
    By txt_routNo = By.xpath("//label[contains(text(),'Routing Number')]/following-sibling::input");
    By btn_accType = By.xpath("//label[contains(text(),'Account Type')]/..//div[contains(@class,'themed_select__single-value')]");
    By btn_accTypeOption = By.xpath("//div[contains(text(),'Checking account')]");
    By btn_next = By.xpath("//button[contains(text(),'Next')]");
    By txt_nickname = By.xpath("//label[contains(text(),'Nickname')]/following-sibling::input");
    By btn_save = By.xpath("//button[contains (text(),'Save')]");
    By btn_paymentMethod = By.xpath("//div[text()='TestKaty']/following-sibling::div/button[contains(text(),'Edit')]");
    By txt_visibilityOfNickname = By.xpath("//h2[contains (text(),'Edit TestKaty 2220')]");
    By btn_removePayment = By.xpath("//button[contains(@class,'pr-0 btn btn-link')]");
    By txt_removeConfirmation = By.xpath("//h2[contains(text(),'Are you sure?')]");
    By btn_remYesConfirmation = By.xpath("//button[contains(@class,'swal2-confirm')]");
    By txt_removeSuccessMsg = By.xpath("//h2[contains(text(),'Payment method has been removed')]");
    By btn_OK = By.xpath("//button[contains(@class,'swal2-confirm swal2-styled')]");
    By btn_paymentSettingsRemove = By.xpath("//div[text()='TestKaty01']/following-sibling::div/button[contains(text(),'Edit')]");
    By txt_paySettingsNickname = By.xpath("//h2[contains (text(),'Edit TestKaty01 2220')]");
    By tbx_editNickname = By.xpath("(//input[contains(@class,'form-control')])[2]");
    By invoice = By.xpath("(//td[contains(@class,'align-middle')])[1]");
    By txt_invoiceId = By.xpath("//h2[contains(@class,'my-2 font-weight')]");
    By btn_invoiceStatus = By.xpath("(//div[contains(@class,'dropdown-indicator')]/*)[1]");
    By btn_statusPastDue = By.xpath("//div[contains(text(),'Past due')]");
    By pastDue = By.xpath("//div[contains(text(),'Past due')]");
    By txt_searchedStatus = By.xpath("//td[contains (@class,'align-middle text-danger')]");
    By btn_paidTab = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOpQRSTUVWXYZ', 'abcdefghijklmnoPqrstuvwxyz'), 'Paid')]");
    By btn_threeDots = By.xpath("(//button[contains(@class,'_g0pr2tf border-0')])[1]");
    By btn_downloadReceipt = By.xpath("(//a[contains(@class,'dropdown-item')])[1]");
    By btn_statusPaid = By.xpath("(//div[contains(@class,'themed_select__dropdown-indicator css-tlfecz-indicatorContainer')])[2]");
    By paidInvoice = By.xpath("//div[contains(text(),'Paid')]");
    By statusPaid = By.xpath("//div[contains(text(),'Paid')]");
    By txt_filteredStatus = By.xpath("//td[@class='align-middle' and text()='Paid']");
    By btn_printReceipt = By.xpath("//a[@class='dropdown-item']//span[text()='Print Receipt']");
    By btn_selectPaidInvoice = By.xpath("(//div[contains(text(),'Payment Date')]/ancestor::thead/following-sibling::tbody/tr[contains(@class,'_13xlah4')]//div[contains(@class,'align-middle _du1frc')])[1]");
    By btn_selectOutstandingInvoice =By.xpath("(//div[contains(text(),'Due Date')]/ancestor::thead/following-sibling::tbody/tr[contains(@class,'_13xlah4')]//div[contains(@class,'align-middle _du1frc')])[1]");
    By btn_autoPay = By.xpath("//button[@class='mr-1 font-weight-bold btn btn-primary' and text()='Enable Auto Pay']");
    By txt_highlightAutoPay = By.xpath("//a[@data-rb-event-key='Auto Pay Settings' and @aria-selected='true' and contains(@class, 'nav-link')]");
    By btn_batchAction = By.xpath("//button[@class='dropdown-toggle btn btn-outline-primary']");
    By btn_downloadInvoice = By.xpath("//a[@class='dropdown-item' and text()='Download Invoices']");
    By txt_downloadInvoice = By.xpath("//h2[@id='swal2-title']");
    By btn_ok = By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']");
    By paymentMethodSuccessTxt = By.xpath("//h2[contains(text(),'Payment method has been added successfully.')]");

    public void clickOnPay(){restaurantUI.click(btn_pay);}

    public boolean isPaySupplierTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfPaySuppliers);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfPaySuppliers);
    }

    public void clickOnPayOption()throws InterruptedException{
        restaurantUI.click(btn_payOption);
        restaurantUI.waitForCustom(800);
    }

    public boolean isInvoiceIDNoDisplayed()throws InterruptedException{
        try {
            restaurantUI.waitForVisibility(txt_invoiceIdNo);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_invoiceIdNo);
    }

    public void clickOnAddPaymentMethod()throws InterruptedException{
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_addPaymentMethod);
    }

    public boolean isAddPaymentMethodTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(text_visibilityOfAddPaymentMethod);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfAddPaymentMethod);
    }

    public void clickOnBankAccountOption(){restaurantUI.click(btn_bankAccountOption);}

    public boolean isAddBankAccountTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_visibilityOfAddBankAccount);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_visibilityOfAddBankAccount);
    }

    public void typeAccountNumber(String accountNumber)throws InterruptedException {
        restaurantUI.sendKeys(txb_accNo,accountNumber);
        restaurantUI.waitForCustom(800);
    }
    public void typeRouteNumber(String routeNumber)throws InterruptedException {
        restaurantUI.sendKeys(txt_routNo,routeNumber);
        restaurantUI.waitForCustom(800);
    }

    public void addAccountType()throws InterruptedException{
        restaurantUI.click(btn_accType);
        restaurantUI.click(btn_accTypeOption);
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_next);
    }

    public void typeNickname(String nickname)throws InterruptedException {
        restaurantUI.sendKeys(txt_nickname,nickname);
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_save);
    }

    public boolean isPaymentMethodAddSuccessOverlayDisplayed(){
        return restaurantUI.isDisplayed(paymentMethodSuccessTxt);
    }

    public void clickOnPaymentSetting(){restaurantUI.click(btn_paymentSettings);}

    public void clickOnRemovePaymentSetting(){restaurantUI.click(btn_paymentMethod);}

    public boolean isEditNicknameTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_visibilityOfNickname);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_visibilityOfNickname);
    }

    public void clickOnRemovePayment(){restaurantUI.click(btn_removePayment);}

    public boolean isRemoveConfirmationTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_removeConfirmation);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_removeConfirmation);
    }

    public void clickOnConfirmYes(){restaurantUI.click(btn_remYesConfirmation);}

    public void editNickName(String editNickname)throws InterruptedException{
        restaurantUI.doubleClick(tbx_editNickname);
        restaurantUI.waitForClickability(tbx_editNickname);
        restaurantUI.sendKeys(tbx_editNickname,editNickname);
    }

    public boolean isRemoveSuccessTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_removeSuccessMsg);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_removeSuccessMsg);
    }

    public void clickOnOk(){restaurantUI.click(btn_OK);}

    public void clickPaymentSettingsRemove(){
        restaurantUI.click(btn_paymentSettingsRemove);
    }

    public boolean isPaymentSettingsNicknameTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_paySettingsNickname);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_paySettingsNickname);
    }

    public void clickOnOneInvoice(){restaurantUI.click(invoice);}

    public boolean isInvoiceIdTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_invoiceId);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_invoiceId);
    }

    public void clickOnInvoiceStatus()throws InterruptedException{
        restaurantUI.waitForCustom(500);
        restaurantUI.click(btn_invoiceStatus);
    }

    public void clickOnPastDue(){restaurantUI.click(btn_statusPastDue);}

    public boolean isSearchedTextDisplayed(){
        String searchStatusName = restaurantUI.getText(pastDue);
        String searchResult = restaurantUI.getText(txt_searchedStatus);
        try {
            return searchStatusName.equals(searchResult);
        } catch (Exception e){
            return false;
        }

    }

    public void clickOnPaidTab()throws InterruptedException{
        restaurantUI.click(btn_paidTab);
        restaurantUI.waitForCustom(100);
    }

    public void clickOnPaidInvoiceStatus()throws InterruptedException{
        restaurantUI.waitForCustom(300);
        restaurantUI.click(btn_statusPaid);
    }

    public void clickOnPaidStatusOption()throws InterruptedException{
        restaurantUI.click(paidInvoice);
        restaurantUI.waitForCustom(300);
    }

    public boolean isPaidSearchedTextDisplayed(){
        String filteredStatusName = restaurantUI.getText(statusPaid);
        String filteredResult = restaurantUI.getText(txt_filteredStatus);
        try {
            return filteredStatusName.equals(filteredResult) && filteredStatusName.equals("Paid");
        } catch (Exception e){
            return false;
        }

    }

    public void clickOnOneInvoiceDownloadReceipt(){
        restaurantUI.click(btn_threeDots);
        restaurantUI.click(btn_downloadReceipt);
    }
    public boolean isPaymentSettingsDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_paymentSettings);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_paymentSettings);
    }
    public void clickOnOneInvoicePrintReceipt(){
        restaurantUI.click(btn_threeDots);
        restaurantUI.click(btn_printReceipt);
    }
    public void clickSelectPaidInvoice() throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        restaurantUI.clickUsingJavaScript(btn_selectPaidInvoice);
    }
    public void clickSelectOutstandingInvoice() throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        restaurantUI.clickUsingJavaScript(btn_selectOutstandingInvoice);
    }

    public void clickBatchActions(){
        restaurantUI.click(btn_batchAction);
    }
    public void clickDownloadInvoices(){
        restaurantUI.click(btn_downloadInvoice);
    }
    public boolean isInvoicesSentPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_downloadInvoice);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_downloadInvoice);
    }
    public void clickOk(){
        restaurantUI.click(btn_ok);
    }
    public void clickAutoPay(){
        restaurantUI.click(btn_autoPay);
    }
    public boolean isAutoPaySettingsHighlighted(){
        try {
            restaurantUI.waitForVisibility(txt_highlightAutoPay);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_highlightAutoPay);
    }

}

