package com.cutanddry.qa.functions;

import com.cutanddry.qa.pages.SuppliersPage;


public class Suppliers {

    static SuppliersPage suppliersPage = new SuppliersPage();

    public static void goToSuppliers(){
        suppliersPage.clickSuppliers();
    }

    public static boolean isUserNavigatedToSupplier(){
        return suppliersPage.isSuppliersTextDisplayed();
    }

    public static void addSupplier(String supplierName) throws InterruptedException {
        suppliersPage.clickAddSupplier();
        suppliersPage.clickContinue();
        suppliersPage.typeSupplierName(supplierName);
        suppliersPage.clickContinue();
        suppliersPage.clickSave();
    }

    public static boolean isSupplierCreated(){
        return suppliersPage.isTestSupplierCreated();
    }


    public static void editSupplier(String editSupplierName) throws InterruptedException {
        suppliersPage.clickOnTestSupplier();
        suppliersPage.editSupplierName(editSupplierName);
        suppliersPage.clickSave();
    }

    public static boolean isSupplierEdited(){
        return suppliersPage.isTestSupplierEditCreated();
    }

    public static void deleteSupplier() throws InterruptedException {
        suppliersPage.clickOnTestSupplierEdit();
        suppliersPage.clickOnDelete();
        suppliersPage.clickOnYes();
    }

}
