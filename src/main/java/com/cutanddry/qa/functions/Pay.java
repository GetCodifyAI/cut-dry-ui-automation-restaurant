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

    public static void editPaymentSettings(){PayPage.clickOnEditPaymentSetting();}

    public static void editPaymentMethodNickName(String editNickname)throws InterruptedException{
        PayPage.clickOnEditPaymentSetting();
        PayPage.editNickName(editNickname);
    }

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

}
