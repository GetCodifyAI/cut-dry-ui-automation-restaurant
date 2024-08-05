package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CustomersPage;
import lombok.SneakyThrows;


public class Customer {
    static CustomersPage customersPage = new CustomersPage();

    public static void increaseFirstRowQtyByOne(){
        customersPage.clickPlusQryFirstRow();
    }
    public static void increaseSecondRowQtyByOne(){customersPage.clickPlusQrySecondRow();}
    public static void decreaseFirstRowQtyByOne(){
        customersPage.clickMinusQryFirstRow();
    }
    public static void decreaseSecondRowQtyByOne(){
        customersPage.clickMinusQrySecondRow();
    }
    public static void increaseFirstRowQtyByThree(){
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
        customersPage.clickPlusQryFirstRow();
    }
    public static void decreaseFirstRowQtyByThree(){
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
        customersPage.clickMinusQryFirstRow();
    }
    @SneakyThrows
    public static void increaseCatalogQtyByThree(){
        customersPage.clickPlusCatalog();
        customersPage.clickPlusCatalog();
        Thread.sleep(4000);
    }
    @SneakyThrows
    public static void decreaseCatalogQtyByThree(){
        customersPage.clickMinusCatalog();
        customersPage.clickMinusCatalog();
        customersPage.clickMinusCatalog();
        Thread.sleep(4000);
    }

    public static void increaseReviewCartQtyByThree(){
        customersPage.clickPlusReviewCart();
        customersPage.clickPlusReviewCart();
    }
    public static void decreaseReviewCartQtyByThree(){
        customersPage.clickMinusReviewCart();
        customersPage.clickMinusReviewCart();
        customersPage.clickMinusReviewCart();
    }

    public static String getItemNameFirstRow(){
        return customersPage.getItemNameFirstRow();
    }
    public static String getItemNameSecondRow(){return customersPage.getItemNameSecondRow();}
    public static void checkoutItems(){
        customersPage.clickOnCheckoutButton();
    }
    public static boolean isUserNavigatedToCatalog(){return customersPage.isCatalogTextDisplayed();}
    public static void goToCatalog(){
        customersPage.clickOnCatalogButton();
    }
    public static void searchItemOnCatalog(String item){
        customersPage.typeToSearchOnCatalog(item);
    }
    public static String getFirstElementFrmSearchResults(){return customersPage.getFirstItemNameFrmSearchResults();}
    public static void addItemToCartCatalog(){
        customersPage.clickAddToCartCatalog();
    }
    public static Double getItemPriceCatalogSearch(){return customersPage.getItemPriceCatalogSearch();}
    public static String getItemQtyFirstRow(){
        return customersPage.getItemQtyFirstRow();
    }
    public static String getItemQtyCatalog(){
        return customersPage.getItemQtyCatalog();
    }
    public static double getItemPriceFirstRow(){
        return customersPage.getItemPriceFirstRow();
    }
    public static double getItemPriceOnCheckoutButton(){
        return customersPage.getItemPriceOnCheckoutButton();
    }
    public static boolean isAddToCartTextDisplayed(){return customersPage.isAddToCartTextDisplayed();}
    public static double getItemPriceReviewCart(){return customersPage.getItemPriceReviewCart();}
    public static String getItemQtyReviewCart(){
        return customersPage.getItemQtyReviewCart();
    }
    public static double getItemPriceReviewCartFirstRow(){
        return customersPage.getItemPriceReviewCartFirstRow();
    }
    public static void submitOrder(){customersPage.submitOrder();if (customersPage.isDuplicatePopupDisplayed()){customersPage.clickYesDuplicatePopup();}}
    public static boolean isThankingForOrderPopupDisplayed(){return customersPage.isThankingForOrderPopupDisplayed();}
}