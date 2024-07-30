package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CustomersPage;

public class Customer {
    static CustomersPage customersPage = new CustomersPage();

    public static void increaseFirstRowQtyByOne(){
        customersPage.clickPlusQryFirstRow();
    }
    public static void increaseSecondRowQtyByOne(){customersPage.clickPlusQrySecondRow();}
    public static String getItemNameFirstRow(){
        return customersPage.getItemNameFirstRow();
    }
    public static String getItemNameSecondRow(){return customersPage.getItemNameSecondRow();}
    public static void checkoutItems(){
        customersPage.clickOnCheckoutButton();
    }
    public static void NavigateToCatalog(){customersPage.clickCatalogButton();}
    public static boolean isUserNavigatedToCatalog(){return customersPage.isCatalogTextDisplayed();
    }}