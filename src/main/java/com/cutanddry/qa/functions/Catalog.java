package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.CatalogPage;

public class Catalog {
    static CatalogPage catalogPage = new CatalogPage();

    public static void ClickOnMultiUomDropDown(String name)throws InterruptedException{
        catalogPage.ClickOnMultiUomDropDown(name);
    }
    public static void ClickOnMultiUomDropDownOption(String option)throws InterruptedException{
        catalogPage.ClickOnMultiUomDropDownOption(option);
    }
    public static void clickAddToCartPlusIcon(int count, String uom) throws InterruptedException{
        for (int i=0; i<count;i++){
            catalogPage.clickAddToCartPlusIcon(uom);
        }
    }
    public static void clickAddToCartMinusIcon(int count, String name) {
        for (int i=0; i<count;i++){
            catalogPage.clickAddToCartMinusIcon(name);
        }
    }
    public static boolean isEditQuantitiesButtonDisplayed(String name){
        return catalogPage.isEditQuantitiesButtonDisplayed(name);
    }
    public static void ClickOnEditQuantities(String name)throws InterruptedException{
        catalogPage.ClickOnEditQuantities(name);
    }
    public static boolean isAddToCartButtonDisplayed(){
        return catalogPage.isAddToCartButtonDisplayed();
    }
    public static double getPDPPriceUOM(String uom) throws InterruptedException {
        return catalogPage.getPDPPriceUOM(uom);
    }
    public static void clickBackToCatalog(){
        catalogPage.clickOnBackToCatalog();
    }
}
