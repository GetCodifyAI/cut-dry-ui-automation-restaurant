package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.PayPage;

public class Pay {
    static com.cutanddry.qa.pages.PayPage PayPage = new PayPage();

    public static void navigateToPay(){PayPage.clickOnPay();}

    public static boolean isPaySupplierTextDisplayed(){return PayPage.isPaySupplierTextDisplayed();}

    public static void payOption()throws InterruptedException {
        PayPage.clickOnPayOption();
    }

    public static boolean isInvoiceIDNoDisplayed()throws InterruptedException{
        return PayPage.isInvoiceIDNoDisplayed();
    }

    public static void addPaymentMethod()throws InterruptedException{
        PayPage.clickOnAddPaymentMethod();
    }

    public static boolean isAddPaymentMethodTextDisplayed(){return PayPage.isAddPaymentMethodTextDisplayed();}

    public static void bankAccountOption(){PayPage.clickOnBankAccountOption();}

    public static boolean isAddBankAccountTextDisplayed(){return PayPage.isAddBankAccountTextDisplayed();}

    public static void addAccountNumber(String accountNumber)throws InterruptedException{
        PayPage.typeAccountNumber(accountNumber);
    }

    public static void addRouteNumber(String routeNumber)throws InterruptedException{
        PayPage.typeRouteNumber(routeNumber);
    }

    public static void selectAccountTypeOption()throws InterruptedException{
        PayPage.addAccountType();
    }

    public static void addNickname(String nickname)throws InterruptedException{
        PayPage.typeNickname(nickname);
    }

    public static boolean isPaymentMethodSuccessfullyAddedTxtDisplayed(){
        return PayPage.isPaymentMethodAddSuccessOverlayDisplayed();
    }

    public static void clickOkAndCloseAddPaymentMethodOverlay(){
        PayPage.clickOnOk();
        Customer.clickClose();
    }

    public static void paymentSettings(){PayPage.clickOnPaymentSetting();}

    public static void removePaymentSettings(){PayPage.clickOnRemovePaymentSetting();}

    public static boolean isNicknameTextDisplayed(){return PayPage.isEditNicknameTextDisplayed();}

    public static void editPaymentMethodNickName(String editNickname)throws InterruptedException{
        PayPage.clickOnRemovePaymentSetting();
        PayPage.editNickName(editNickname);
    }

    public static void clickOnRemovePaymentOption(){PayPage.clickOnRemovePayment();}

    public static boolean isRemoveConfirmationMessageDisplayed(){return PayPage.isRemoveConfirmationTextDisplayed();}

    public static void clickOnRemoveOption(){PayPage.clickOnConfirmYes();}

    public static boolean isRemoveSuccessMessageDisplayed(){return PayPage.isRemoveSuccessTextDisplayed();}

    public static void clickOnOkOption(){PayPage.clickOnOk();}

    public static void clickOnPaymentSettingsRemoveOption(String nickName){PayPage.clickPaymentSettingsRemove(nickName);}

    public static boolean isPaymentSettingsNicknameTextDisplayed(String nickName){return PayPage.isPaymentSettingsNicknameTextDisplayed(nickName);}

    public static void clickOnInvoice(){PayPage.clickOnOneInvoice();}

    public static boolean isInvoiceIdTextDisplayed(){return PayPage.isInvoiceIdTextDisplayed();}

    public static void clickOnInvoiceStatusDropdownMenu()throws InterruptedException{PayPage.clickOnInvoiceStatus();}

    public static void clickOnPastDueOption() throws InterruptedException {PayPage.clickOnPastDue();}

    public static boolean isSearchedTextDisplayed(){return PayPage.isSearchedTextDisplayed();}

    public static void clickOnPaidInvoiceTab()throws InterruptedException{PayPage.clickOnPaidTab();}

    public static void clickOnPaidInvoiceStatusDropdownMenu()throws InterruptedException{PayPage.clickOnPaidInvoiceStatus();}

    public static void clickOnInvoicePaidStatusOption()throws InterruptedException{PayPage.clickOnPaidStatusOption();}

    public static boolean isPaidSearchedTextDisplayed(){return PayPage.isPaidSearchedTextDisplayed();}

    public static void clickOnDownloadReceiptPaidInvoice(){PayPage.clickOnOneInvoiceDownloadReceipt();}

    public static boolean isPaymentSettingsDisplayed(){
        return PayPage.isPaymentSettingsDisplayed();
    }
    public static void clickOnOneInvoicePrintReceipt(){PayPage.clickOnOneInvoicePrintReceipt();}
    public static void clickSelectPaidInvoice()throws InterruptedException{
        if (PayPage.isNavigatePaidDisplayed()){
            PayPage.clickSelectPaidInvoice();
        }
    }
    public static void clickSelectOutstandingPaidInvoice()throws InterruptedException{PayPage.clickSelectOutstandingInvoice();}
    public static void clickBatchActions()throws InterruptedException{PayPage.clickBatchActions();}
    public static void clickDownloadInvoices(){PayPage.clickDownloadInvoices();}
    public static boolean isInvoicesSentPopUpDisplayed(){
        return PayPage.isInvoicesSentPopUpDisplayed();
    }
    public static void clickOk(){PayPage.clickOk();}
    public static void clickAutoPay(){PayPage.clickAutoPay();}

    public static boolean isAutoPaySettingsHighlighted(){
        return PayPage.isAutoPaySettingsHighlighted();
    }

    public static void clickNextOnBatchPaymentOverlay(){
        if(PayPage.isBatchPaymentOverlayDisplayed()) {
            PayPage.clickNextButton();
        }
    }
    public static boolean isNavigatePaidDisplayed(){
        return PayPage.isNavigatePaidDisplayed();
    }
    public static void clickCutAndDryPayToggle(boolean status){
        PayPage.clickCutAndDryPayToggle(status);
    }
    public static void clickOnInvoiceRecord(int rowCount) {
        for (int i = 1; i <= rowCount; i++) {
            PayPage.clickOnInvoiceRecord(i);
        }
    }
    public static void clickCreateBatch() throws InterruptedException {
        PayPage.clickCreateBatch();
    }
    public static boolean isBatchPaymentDisplayed() throws InterruptedException {
        return PayPage.isBatchPaymentDisplayed();
    }
    public static boolean isCreditMemoDisplayed() throws InterruptedException {
        return PayPage.isCreditMemoDisplayed();
    }
    public static void clickSelectInvoice(String invoice){
        PayPage.clickSelectInvoice(invoice);
    }
    public static void clickDownloadInvoice() throws InterruptedException {
        PayPage.clickDownloadInvoice();
    }
    public static void clickPrintInvoice() throws InterruptedException {
        PayPage.clickPrintInvoice();
    }

    public static void navigateToPublicPayView(String vendorID){
        PayPage.navigateToPublicPayView(vendorID);
    }
    public static boolean isNavigatedToPublicPayView(){
        return PayPage.isNavigatedToPublicPayView();
    }
    public static void openUnpaidInvoice(){
        PayPage.openUnpaidInvoice();
    }
    public static boolean isNavigatedToInvoiceView(){
        return PayPage.isInvoiceOpened();
    }
    public static void clickOnCardOption(){
        PayPage.clickOnCardOption();
    }
    public static void enterCardNumber(String cardNumber)throws InterruptedException{
        PayPage.enterCardNumber(cardNumber);
    }
    public static void enterCVV(String cvvNumber)throws InterruptedException{
        PayPage.enterCVVNumber(cvvNumber);
    }
    public static void enterZipCode(String zipCode)throws InterruptedException{
        PayPage.enterZipCode(zipCode);
    }
    public static void enterExpirationDate(String expiriationDate)throws InterruptedException{
        PayPage.enterExpirationDate(expiriationDate);
    }
    public static void clickOnPublicPay(){
        PayPage.clickOnPublicPay();
    }
    public static boolean isTransactionRejectedPopUpDisplayed(){
        return PayPage.isTransactionRejectedPopUpDisplayed();
    }
    public static boolean isTotalUnpaidInvoicesTextDisplayed(){
        return PayPage.isTotalUnpaidInvoicesTextDisplayed();
    }
    public static boolean isTotalCreditsTextDisplayed(){
        return PayPage.isTotalCreditsTextDisplayed();
    }
    public static boolean isPastDueTextDisplayed(){
        return PayPage.isPastDueTextDisplayed();
    }
    public static void clickOnInvoiceTypeDropdownMenu()throws InterruptedException{
        PayPage.clickOnInvoiceType();
    }
    public static void clickOnCreditMemoOption() throws InterruptedException{
        PayPage.clickOnTypeCreditMemo();
    }
    public static void clickOnInvoiceOption() throws InterruptedException{
        PayPage.clickOnTypeInvoice();
    }
    public static float getCreditMemosTotalAmount(){
        return PayPage.getCreditMemosTotalAmount();
    }
    public static float getTotalCreditsAmount(){
        return PayPage.getTotalCreditsAmount();
    }
    public static float getPastDueInvoicesTotalAmount(){
        return PayPage.getPastDueInvoicesTotalAmount();
    }
    public static float getTotalPastDueAmount(){
        return PayPage.getTotalPastDueInvoicesAmount();
    }
    public static void clearInvoiceTypeDropDownOption() throws InterruptedException {
        PayPage.clearInvoiceTypeDropDownOption();
    }
    public static void clearInvoiceStatusDropDownOption() throws InterruptedException{
        PayPage.clearInvoiceStatusDropDownOption();
    }
    public static void clickOnUnpaidOption() throws InterruptedException {
        PayPage.clickOnStatusUnpaid();
    }
    public static float getUnpaidInvoicesTotalAmount (){
        return PayPage.getUnpaidInvoicesTotalAmount();
    }
    public static float getTotalUnpaidInvoicesAmount(){
        return PayPage.getTotalUnpaidInvoicesAmount();
    }

    public static boolean isTransactionSuccessOverlayDisplayed(){
        return PayPage.isPaymentSuccessfulOverlayDisplayed();
    }

    public static void selectSupplierFromDropdown(String SupplierName) throws InterruptedException {
        PayPage.clickOnSupplierDropdown(SupplierName);
    }

    public static boolean isAllDisplayedSupplierAreTheSearchedSupplier(String SupplierName) throws InterruptedException {
        return PayPage.isAllInvoicesDisplayedAreForSupplier(SupplierName);
    }

}
