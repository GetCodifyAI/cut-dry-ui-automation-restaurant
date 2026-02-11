package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import com.cutanddry.qa.common.Constants;
import org.openqa.selenium.By;

public class PayPage extends TestBase {

    By btn_pay = By.xpath("(//a[contains(@data-tip, 'View Invoices')])[1]");
    By btn_paymentSettings = By.xpath("//button[contains(text(),'Payment Settings')]");
    By txt_paymentSettings = By.xpath("//h2[@class='_5kripx' and text()='Payment Settings']");
    By text_visibilityOfPaySuppliers = By.xpath("//h2[contains(text(),'Invoices')]");
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
    String btn_paymentSettingsRemove = "//div[text()='NICKNAME']/following-sibling::div/button[contains(text(),'Edit')]";
    String txt_paySettingsNickname = "//h2[contains (text(),'NICKNAME')]";
    By tbx_editNickname = By.xpath("(//input[contains(@class,'form-control')])[2]");
    By invoice = By.xpath("(//td[contains(@class,'align-middle')])[1]");
    By txt_invoiceId = By.xpath("//h2[contains(@class,'my-2 font-weight')]");
    By btn_invoiceStatus = By.xpath("(//div[contains(text(),'Status')]//*[contains(@class,'dropdown-indicator')])[1]");
    By btn_statusPastDue = By.xpath("//div[contains(text(),'Past due')]");
    By pastDue = By.xpath("//div[contains(text(),'Past due')]");
    By txt_searchedStatus = By.xpath("//td[contains (@class,'align-middle text-danger')]");
    By btn_paidTab = By.xpath("//a[contains(translate(text(), 'ABCDEFGHIJKLMNOpQRSTUVWXYZ', 'abcdefghijklmnoPqrstuvwxyz'), 'Paid')]");
    By btn_threeDots = By.xpath("(//button[contains(@class,'_g0pr2tf border-0')])[1]");
    By btn_downloadReceipt = By.xpath("(//a[contains(@class,'dropdown-item')])[1]");
    By btn_statusPaid = By.xpath("(//div[contains(text(),'Status')]//*[contains(@class,'dropdown-indicator')])[2]");
    By paidInvoice = By.xpath("//div[contains(text(),'Paid')]");
    By statusPaid = By.xpath("//td[contains(text(),'Paid')]");
    By txt_filteredStatus = By.xpath("//td[@class='align-middle' and text()='Paid']");
    By btn_printReceipt = By.xpath("//a[@class='dropdown-item']//span[text()='Print Receipt']");
    By btn_selectPaidInvoice = By.xpath("(//div[contains(text(),'Payment Date')]/ancestor::thead/following-sibling::tbody/tr//div)[1]");
    By btn_selectOutstandingInvoice = By.xpath("(//div[contains(text(),'Due Date')]/ancestor::thead/following-sibling::tbody/tr//div)[1]");
    By btn_autoPay = By.xpath("//button[ text()='Enable Auto Pay']");
    By txt_highlightAutoPay = By.xpath("//a[@data-rb-event-key='Auto Pay Settings' and @aria-selected='true' and contains(@class, 'nav-link')]");
    By btn_batchAction = By.xpath("//button[text()='Batch Actions(1)']");
    By btn_downloadInvoice = By.xpath("//a[@class='dropdown-item' and text()='Download Invoices']");
    By txt_downloadInvoice = By.xpath("//h2[@id='swal2-title']");
    By btn_ok = By.xpath("//button[@class='swal2-confirm swal2-styled' and text()='OK']");
    By paymentMethodSuccessTxt = By.xpath("//h2[contains(text(),'Payment method has been added successfully.')]");
    By batchPaymentTxt = By.xpath("//div[contains(text(),'Batch Payment')]");
    By nextBtn = By.xpath("//button[contains(text(),'Next')]");
    By navigatePaidTab = By.xpath("//a[@aria-selected='true' and text()='Paid']");
    By cutAndDryPayToggleStable = By.xpath("//div[contains(text(), 'Cut+Dry Pay')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']");
    By cutAndDryPayToggleStable1 = By.xpath("//div[contains(text(), 'Cut+Dry Pay')]/following-sibling::div//div[@class='react-switch-bg']/following-sibling::div[@class='react-switch-handle']/parent::div/div[1]");
    By btn_markInvoiceYes = By.xpath("//button[contains(text(),'Yes')]");
    String cbox_invoiceRecord = "//div[contains(text(),'Due Date')]/ancestor::table/tbody/tr[ROW_COUNT]/td[1]//*[name()='svg']";
    By btn_createBatch = By.xpath("(//button[contains(text(),'Create Batch')])[1]");
    By creditMemoDisplay = By.xpath("//div[text()='Credit Memos (0)']");
    By txt_batchPayment = By.xpath("//div[text()='Batch Payment']");
    String selectInvoice = "//div[contains(text(),'Invoice Id')]/ancestor::table/tbody/tr/td[text()='INVOICEID']";
    By downloadInvoice = By.xpath("(//h2[contains(text(),'Invoice')]/../../../following-sibling::div[2]//*[local-name()='svg'])[1]");
    By PrintInvoice = By.xpath("(//h2[contains(text(),'Invoice')]/../../../following-sibling::div[2]//*[local-name()='svg'])[2]");
    By publicPayView = By.xpath("//*[contains(text(),'Payment Summary')]");
    By firstUnpaidInvoice = By.xpath("//tbody/tr[td[5][text()='Past due']]/td[2]");
    By btn_cardOption = By.xpath("//div[contains(text(),'Card')]");
    By cardNumber = By.xpath("//input[@id='ccnumber']");
    By cardCVV = By.xpath("//input[@id='cvv']");
    By cardExp = By.xpath("//input[contains(@name,'ccexp')]");
    By cardZipCode = By.xpath("//label[contains(text(),'Zip Code')]/following-sibling::input");
    By switchIframeCardNumber = By.xpath("//iframe[contains(@id,'CollectJSInlineccnumber')]");
    By switchIframeCardExp = By.xpath("//iframe[contains(@id,'CollectJSInlineccexp')]");
    By switchIframeCardCVV = By.xpath("//iframe[contains(@id,'CollectJSInlinecvv')]");
    By btn_publicPay = By.xpath("//button[contains(@class,'btn-block') and not(@disabled)]");
    By transactionRejectedPopUp = By.xpath("//*[contains(text(),'Transaction was rejected by gateway.')]");
    By txt_totalUnpaidInvoices = By.xpath("//*[contains(text(),'Total Unpaid Invoices')]");
    By txt_totalCredits = By.xpath("//*[contains(text(),'Total Credits')]");
    By txt_pastDueAmount = By.xpath("//*[contains(text(),'Past Due')]");
    By txt_currentBalance = By.xpath("//*[contains(text(),'Current')]");
    By btn_invoiceType = By.xpath("(//div[contains(text(),'Type')]//*[contains(@class,'dropdown-indicator')])[1]");
    By btn_typeCreditMemo = By.xpath("//div[contains(text(),'Credit Memo')]");
    By filteredInvoices = By.xpath("//tr[contains(@class,'_13xlah4')]");
    By totalCreditsAmount = By.xpath("//*[contains(text(),'Total Credits')]/../following::div[1]");
    By totalPastDueAmount = By.xpath("//*[contains(text(),'Past Due')]/../span[1]");
    By totalUnpaidInvoicesAmount = By.xpath("//*[contains(text(),'Past Due')]/../span[1]");
    By clearInvoiceTypeDropdown = By.xpath("(//div[contains(text(),'Type')]//*[contains(@class,'clear-indicator')])[1]");
    By clearInvoiceStatusDropDown = By.xpath("(//div[contains(text(),'Status')]//*[contains(@class,'clear-indicator')])[1]");
    By btn_typeInvoice = By.xpath("//*[contains(text(),'Type')][1]/div/div[2]/div/div[contains(text(),'Invoice')]");
    By btn_statusUnpaid = By.xpath("//div[contains(text(),'Unpaid')]");
    By lst_unpaidInvoices = By.xpath("//button[contains(text(),'Pay')]/ancestor::td/../td[9]");
    By lst_creditMemos = By.xpath("//td[contains(text(),'N/A')]/following::td[3]");
    By lst_pastDueInvoices = By.xpath("//td[contains(text(),'Past due')]/following::td[2]");
    By paymentSummeryText = By.xpath("//div[contains(text(),'Payment Summary')]");
    By paymentSuccessMessage = By.xpath("//*[contains(text(),'Payment Successful!')]");
    By supplierDropDown = By.xpath("(//div[contains(text(),'Supplier')])[last()-1]/div");
    String supplier = "//div[contains(@class,'menu-list')]//div[contains(text(),'SUPPLIER')]";
    By supplierInPaidTable = By.xpath("//table//tr/td[contains(text(),'Paid')]/../td[3]");
    By txt_paymentSuccessful = By.xpath("//h2[contains(text(),'Payment Successful!')]");



    public void clickOnPay() {
        restaurantUI.clickWithFallback(btn_pay);
    }

    public boolean isPaySupplierTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(text_visibilityOfPaySuppliers);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfPaySuppliers);
    }

    public void clickOnPayOption() throws InterruptedException {
        restaurantUI.click(btn_payOption);
        restaurantUI.waitForCustom(800);
    }

    public boolean isInvoiceIDNoDisplayed() throws InterruptedException {
        try {
            restaurantUI.waitForVisibility(txt_invoiceIdNo);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_invoiceIdNo);
    }

    public void clickOnAddPaymentMethod() throws InterruptedException {
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_addPaymentMethod);
    }

    public boolean isAddPaymentMethodTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(text_visibilityOfAddPaymentMethod);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(text_visibilityOfAddPaymentMethod);
    }

    public void clickOnBankAccountOption() {
        restaurantUI.click(btn_bankAccountOption);
    }

    public boolean isAddBankAccountTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_visibilityOfAddBankAccount);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_visibilityOfAddBankAccount);
    }

    public void typeAccountNumber(String accountNumber) throws InterruptedException {
        restaurantUI.sendKeys(txb_accNo, accountNumber);
        restaurantUI.waitForCustom(800);
    }

    public void typeRouteNumber(String routeNumber) throws InterruptedException {
        restaurantUI.sendKeys(txt_routNo, routeNumber);
        restaurantUI.waitForCustom(800);
    }

    public void addAccountType() throws InterruptedException {
        restaurantUI.click(btn_accType);
        restaurantUI.click(btn_accTypeOption);
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_next);
    }

    public void typeNickname(String nickname) throws InterruptedException {
        restaurantUI.sendKeys(txt_nickname, nickname);
        restaurantUI.waitForCustom(800);
        restaurantUI.click(btn_save);
    }

    public boolean isPaymentMethodAddSuccessOverlayDisplayed() {
        return restaurantUI.isDisplayed(paymentMethodSuccessTxt);
    }

    public void clickOnPaymentSetting() {
        restaurantUI.scrollToElement(btn_paymentSettings);
        restaurantUI.clickUsingJavaScript(btn_paymentSettings);
    }

    public void clickOnRemovePaymentSetting() {
        restaurantUI.click(btn_paymentMethod);
    }

    public boolean isEditNicknameTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_visibilityOfNickname);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_visibilityOfNickname);
    }

    public void clickOnRemovePayment() {
        restaurantUI.click(btn_removePayment);
    }

    public boolean isRemoveConfirmationTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_removeConfirmation);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_removeConfirmation);
    }

    public void clickOnConfirmYes() {
        restaurantUI.click(btn_remYesConfirmation);
    }

    public void editNickName(String editNickname) throws InterruptedException {
        restaurantUI.doubleClick(tbx_editNickname);
        restaurantUI.waitForClickability(tbx_editNickname);
        restaurantUI.sendKeys(tbx_editNickname, editNickname);
    }

    public boolean isRemoveSuccessTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_removeSuccessMsg);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_removeSuccessMsg);
    }

    public void clickOnOk() {
        restaurantUI.click(btn_OK);
    }

    public void clickPaymentSettingsRemove(String nickName) {
        restaurantUI.click(By.xpath(btn_paymentSettingsRemove.replace("NICKNAME", nickName)));
    }

    public boolean isPaymentSettingsNicknameTextDisplayed(String Nickname) {
        try {
            restaurantUI.waitForVisibility(By.xpath(txt_paySettingsNickname.replace("NICKNAME", Nickname)));
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(txt_paySettingsNickname.replace("NICKNAME", Nickname)));
    }

    public void clickOnOneInvoice() {
        restaurantUI.click(invoice);
    }

    public boolean isInvoiceIdTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_invoiceId);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_invoiceId);
    }

    public void clickOnInvoiceStatus() throws InterruptedException {
        restaurantUI.waitForCustom(500);
        restaurantUI.click(btn_invoiceStatus);
    }

    public void clickOnPastDue() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_statusPastDue);
        restaurantUI.click(btn_statusPastDue);
        restaurantUI.waitForCustom(10000);
    }

    public boolean isSearchedTextDisplayed() {
        String searchStatusName = restaurantUI.getText(pastDue);
        String searchResult = restaurantUI.getText(txt_searchedStatus);
        try {
            return searchStatusName.equals(searchResult);
        } catch (Exception e) {
            return false;
        }

    }

    public void clickOnPaidTab() throws InterruptedException {
        restaurantUI.click(btn_paidTab);
        restaurantUI.waitForCustom(2000);
    }

    public void clickOnPaidInvoiceStatus() throws InterruptedException {
        restaurantUI.waitForCustom(300);
        restaurantUI.click(btn_statusPaid);
    }

    public void clickOnPaidStatusOption() throws InterruptedException {
        restaurantUI.click(paidInvoice);
        restaurantUI.waitForCustom(300);
    }

    public boolean isPaidSearchedTextDisplayed() {
        return restaurantUI.isDisplayed(statusPaid);
    }

    public void clickOnOneInvoiceDownloadReceipt() {
        restaurantUI.click(btn_threeDots);
        restaurantUI.click(btn_downloadReceipt);
    }

    public boolean isPaymentSettingsDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_paymentSettings);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_paymentSettings);
    }

    public void clickOnOneInvoicePrintReceipt() {
        restaurantUI.click(btn_threeDots);
        restaurantUI.click(btn_printReceipt);
    }

    public void clickSelectPaidInvoice() throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.waitForClickability(btn_selectPaidInvoice);
        restaurantUI.clickUsingJavaScript(btn_selectPaidInvoice);
    }

    public void clickSelectOutstandingInvoice() throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.clickUsingJavaScript(btn_selectOutstandingInvoice);
    }

    public void clickBatchActions() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_batchAction);
        restaurantUI.click(btn_batchAction);
    }

    public void clickDownloadInvoices() {
        restaurantUI.click(btn_downloadInvoice);
    }

    public boolean isInvoicesSentPopUpDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_downloadInvoice);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_downloadInvoice);
    }

    public void clickOk() {
        restaurantUI.click(btn_ok);
    }

    public void clickAutoPay() {
        restaurantUI.scrollToElement(btn_autoPay);
        restaurantUI.clickUsingJavaScript(btn_autoPay);
    }

    public boolean isAutoPaySettingsHighlighted() {
        try {
            restaurantUI.waitForVisibility(txt_highlightAutoPay);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_highlightAutoPay);
    }

    public boolean isBatchPaymentOverlayDisplayed() {
        return restaurantUI.isDisplayed(batchPaymentTxt);
    }

    public void clickNextButton() {
        restaurantUI.click(nextBtn);
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isNavigatePaidDisplayed() {
        try {
            restaurantUI.waitForVisibility(navigatePaidTab);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(navigatePaidTab);
    }

    public void clickCutAndDryPayToggle(boolean enable) {

        String handlePosition = restaurantUI.getElement(cutAndDryPayToggleStable).getAttribute("style");
        boolean isEnabled = handlePosition.contains("translateX(66px)");

        if (enable && !isEnabled) {
            restaurantUI.clickWithScrollAndHover(cutAndDryPayToggleStable1);
            restaurantUI.click(btn_markInvoiceYes);
        } else if (!enable && isEnabled) {
            restaurantUI.clickWithScrollAndHover(cutAndDryPayToggleStable1);
            restaurantUI.click(btn_markInvoiceYes);
        }
    }

    public void clickOnInvoiceRecord(int rowNo) {
        String row_count = String.valueOf(rowNo);
        By lbl_invoiceRecord = By.xpath(cbox_invoiceRecord.replace("ROW_COUNT", row_count));
        restaurantUI.waitForVisibility(lbl_invoiceRecord);
        restaurantUI.click(lbl_invoiceRecord);
    }

    public void clickCreateBatch() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_createBatch);
        restaurantUI.click(btn_createBatch);
    }

    public boolean isBatchPaymentDisplayed() throws InterruptedException {
        return restaurantUI.isDisplayed(txt_batchPayment);
    }

    public boolean isCreditMemoDisplayed() throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        return restaurantUI.isDisplayed(creditMemoDisplay);
    }

    public void clickSelectInvoice(String invoice) {
        restaurantUI.scrollToElement(By.xpath(selectInvoice.replace("INVOICEID", invoice)));
        restaurantUI.clickUsingJavaScript(By.xpath(selectInvoice.replace("INVOICEID", invoice)));
    }

    public void clickDownloadInvoice() throws InterruptedException {
        restaurantUI.click(downloadInvoice);
        restaurantUI.waitForCustom(2000);
    }

    public void clickPrintInvoice() throws InterruptedException {
        restaurantUI.click(PrintInvoice);
        restaurantUI.waitForCustom(2000);
    }

    public void navigateToPublicPayView(String vendorID){
        try {
            restaurantUI.waitForCustom(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.navigateToURL(Constants.PUBLIC_PAY_URL+ vendorID);
        restaurantUI.waitForVisibility(publicPayView);
    }

    public boolean isNavigatedToPublicPayView() {
        return restaurantUI.isDisplayed(publicPayView);
    }

    public void openUnpaidInvoice() {
        restaurantUI.click(firstUnpaidInvoice);
    }
    public boolean isInvoiceOpened(){
        return restaurantUI.isDisplayed(paymentSummeryText);
    }

    public void clickOnCardOption() {
        restaurantUI.click(btn_cardOption);
    }

    public void enterCardNumber(String cardNum) throws InterruptedException {
        restaurantUI.switchToFrameByElement(switchIframeCardNumber);
        restaurantUI.sendKeys(cardNumber, cardNum);
        restaurantUI.switchToDefaultContent();
    }

    public void enterCVVNumber(String cvvNumber) throws InterruptedException {
        restaurantUI.switchToFrameByElement(switchIframeCardCVV);
        restaurantUI.sendKeys(cardCVV, cvvNumber);
        restaurantUI.switchToDefaultContent();
    }

    public void enterZipCode(String zipCode) throws InterruptedException {
        restaurantUI.sendKeys(cardZipCode, zipCode);
        restaurantUI.waitForCustom(800);
    }

    public void enterExpirationDate(String expiriationDate) throws InterruptedException {
        restaurantUI.switchToFrameByElement(switchIframeCardExp);
        restaurantUI.sendKeys(cardExp, expiriationDate);
        restaurantUI.switchToDefaultContent();
    }

    public void clickOnPublicPay() {
        restaurantUI.click(btn_publicPay);
    }

    public boolean isTransactionRejectedPopUpDisplayed() {
        return restaurantUI.isDisplayed(transactionRejectedPopUp);
    }

    public boolean isTotalUnpaidInvoicesTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_totalUnpaidInvoices);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_totalUnpaidInvoices);
    }

    public boolean isTotalCreditsTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_totalCredits);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_totalCredits);
    }

    public boolean isPastDueTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_pastDueAmount);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_pastDueAmount);
    }

    public void clickOnInvoiceType() throws InterruptedException {
        restaurantUI.waitForCustom(500);
        restaurantUI.click(btn_invoiceType);
    }

    public void clickOnTypeCreditMemo() throws InterruptedException {
        restaurantUI.waitForClickability(btn_typeCreditMemo);
        restaurantUI.click(btn_typeCreditMemo);
        restaurantUI.waitForCustom(500);
    }

    public void clickOnTypeInvoice() throws InterruptedException {
        restaurantUI.waitForClickability(btn_typeInvoice);
        restaurantUI.click(btn_typeInvoice);
        restaurantUI.waitForCustom(500);
    }

    public void clickOnStatusUnpaid()throws InterruptedException{
        restaurantUI.waitForClickability(btn_statusUnpaid);
        restaurantUI.click(btn_statusUnpaid);
        restaurantUI.waitForCustom(500);
    }

    public float getCreditMemosTotalAmount() {
        float total = 0f;
        int creditMemos = restaurantUI.countElements(lst_creditMemos);
        for (int i = 1; i <= creditMemos; i++) {
            By amountLocator = By.xpath("(" + lst_creditMemos.toString().replace("By.xpath: ", "") + ")[" + i + "]");
            String amountText = restaurantUI.getText(amountLocator);
            if (amountText != null && !amountText.isEmpty()) {
                amountText = amountText.replaceAll("[^\\d.]", "");
                total += Float.parseFloat(amountText);
            }
        }
        return total;
    }

    public float getTotalCreditsAmount(){
        float TotalCreditsAmount = 0f;
        String CreditsAmountTotal = restaurantUI.getText(totalCreditsAmount);
        String creditsAmountTotal = CreditsAmountTotal.replaceAll("[^\\d.]", "");
        try {
            TotalCreditsAmount = Float.parseFloat(creditsAmountTotal);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing credits amount: " + e.getMessage());
        }
        return TotalCreditsAmount;
    }

    public float getPastDueInvoicesTotalAmount() {
        float totalPastDueAmount = 0f;
        int pastDueInvoices = restaurantUI.countElements(lst_pastDueInvoices);
        for (int i = 1; i <=pastDueInvoices ; i++) {
            By amountLocator = By.xpath("(" + lst_pastDueInvoices.toString().replace("By.xpath: ", "") + ")[" + i + "]");
            String amountText = restaurantUI.getText(amountLocator);
            if (amountText != null && !amountText.isEmpty()) {
                amountText = amountText.replaceAll("[^\\d.]", "");
                totalPastDueAmount += Float.parseFloat(amountText);
            }
        }
        return totalPastDueAmount;
    }

    public float getTotalPastDueInvoicesAmount(){
        float TotalPastDueInvoicesAmount = 0f;
        String PastDueInvoicesAmountTotal = restaurantUI.getText(totalPastDueAmount);
        String pastDueInvoicesAmountTotal = PastDueInvoicesAmountTotal.replaceAll("[^\\d.]", "");
        try {
            TotalPastDueInvoicesAmount = Float.parseFloat(pastDueInvoicesAmountTotal);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing credits amount: " + e.getMessage());
        }
        return TotalPastDueInvoicesAmount;
    }

    public void clearInvoiceTypeDropDownOption()throws InterruptedException {
        restaurantUI.click(clearInvoiceTypeDropdown);
        restaurantUI.waitForCustom(800);
    }
    public void clearInvoiceStatusDropDownOption()throws InterruptedException{
        restaurantUI.click(clearInvoiceStatusDropDown);
        restaurantUI.waitForCustom(800);

    }

    public float getUnpaidInvoicesTotalAmount() {
        float totalUnpaidInvoicesAmount = 0f;
        int unpaidInvoices = restaurantUI.countElements(lst_unpaidInvoices);
        for (int i = 1; i <=unpaidInvoices ; i++) {
            By amountLocator = By.xpath("(" + lst_unpaidInvoices.toString().replace("By.xpath: ", "") + ")[" + i + "]");
            String amountText = restaurantUI.getText(amountLocator);
            if (amountText != null && !amountText.isEmpty()) {
                amountText = amountText.replaceAll("[^\\d.]", "");
                totalUnpaidInvoicesAmount += Float.parseFloat(amountText);
            }
        }
        return totalUnpaidInvoicesAmount;
    }

    public float getTotalUnpaidInvoicesAmount(){
        float TotalUnpaidInvoicesAmount = 0f;
        String UnpaidInvoicesTotalAmount = restaurantUI.getText(totalUnpaidInvoicesAmount);
        String unpaidInvoicesTotalAmount = UnpaidInvoicesTotalAmount.replaceAll("[^\\d.]", "");
        try {
            TotalUnpaidInvoicesAmount = Float.parseFloat(unpaidInvoicesTotalAmount);
        } catch (NumberFormatException e) {
            System.out.println("Error parsing credits amount: " + e.getMessage());
        }
        return TotalUnpaidInvoicesAmount;

    }
    public boolean isPaymentSuccessfulOverlayDisplayed(){
        return restaurantUI.isDisplayed(paymentSuccessMessage);
    }

    public void clickOnSupplierDropdown(String supplierName) throws InterruptedException {
        restaurantUI.waitForCustom(3000);
        restaurantUI.click(supplierDropDown);
        restaurantUI.click(By.xpath(supplier.replace("SUPPLIER",supplierName)));
    }

    public boolean isAllInvoicesDisplayedAreForSupplier(String supplierName) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        return restaurantUI.checkTextInElementsList(supplierInPaidTable,supplierName);
    }
    public boolean isPaymentSuccessfulPopUpDisplayed() {
        return restaurantUI.isDisplayed(txt_paymentSuccessful);
    }




}

