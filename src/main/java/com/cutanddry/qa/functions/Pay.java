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

    public static void clickOnPaymentSettingsRemoveOption(){PayPage.clickPaymentSettingsRemove();}

    public static boolean isPaymentSettingsNicknameTextDisplayed(){return PayPage.isPaymentSettingsNicknameTextDisplayed();}

    public static void clickOnInvoice(){PayPage.clickOnOneInvoice();}

    public static boolean isInvoiceIdTextDisplayed(){return PayPage.isInvoiceIdTextDisplayed();}

    public static void clickOnInvoiceStatusDropdownMenu()throws InterruptedException{PayPage.clickOnInvoiceStatus();}

    public static void clickOnPastDueOption(){PayPage.clickOnPastDue();}

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
    public static void clickSelectPaidInvoice()throws InterruptedException{PayPage.clickSelectPaidInvoice();}
    public static void clickSelectOutstandingPaidInvoice()throws InterruptedException{PayPage.clickSelectOutstandingInvoice();}
    public static void clickBatchActions(){PayPage.clickBatchActions();}
    public static void clickDownloadInvoices(){PayPage.clickDownloadInvoices();}
    public static boolean isInvoicesSentPopUpDisplayed(){
        return PayPage.isInvoicesSentPopUpDisplayed();
    }
    public static void clickOk(){PayPage.clickOk();}
    public static void clickAutoPay(){PayPage.clickAutoPay();}

    public static boolean isAutoPaySettingsHighlighted(){
        return PayPage.isAutoPaySettingsHighlighted();
    }

}
