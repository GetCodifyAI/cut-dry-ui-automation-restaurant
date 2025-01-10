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

    public static void enterSupplier(String supplierName) throws InterruptedException {
        suppliersPage.typeSupplierName(supplierName);
    }
    public static void selectOneSupplier(String editSupplierName) throws InterruptedException {
        suppliersPage.clickOnOneSupplier(editSupplierName);
    }
    public static void editSupplierName(String editSupplierName)throws InterruptedException {
        suppliersPage.editSupplierName(editSupplierName);
    }
    public static void deleteSupplier() throws InterruptedException {
        suppliersPage.clickOnDelete();
        suppliersPage.clickOnYes();
    }
    public static void clickAddSupplier()throws InterruptedException{
        suppliersPage.clickAddSupplier();
    }
    public static boolean isAddSuppliersPopUpDisplayed(){
        return suppliersPage.isAddSuppliersPopUpDisplayed();
    }
    public static void clickContinue()throws InterruptedException{
        suppliersPage.clickContinue();
    }
    public static void enterSupplier2(String supplierName2)throws InterruptedException {
        suppliersPage.typeSupplierName2(supplierName2);
    }
    public static void clickSave()throws InterruptedException{
        suppliersPage.clickSave();
    }
    public static boolean isSupplierDisplayed(String supplier)throws InterruptedException{
        return suppliersPage.isAddedSupplierDisplayed(supplier);
    }
    public static void clickOk(){
        suppliersPage.clickOk();
    }
    public static boolean isEditSuppliersPopUpDisplayed(){
        return suppliersPage.isEditSuppliersPopUpDisplayed();
    }
    public static void clickOnArchived() throws InterruptedException {
        suppliersPage.clickOnArchived();
    }
    public static void clickViewArchived()throws InterruptedException{
        suppliersPage.clickViewArchived();
    }
    public static boolean isArchivedSupplierPopUpDisplayed(){
        return suppliersPage.isArchivedSupplierPopUpDisplayed();
    }
    public static void clickUnarchived(String supplier)throws InterruptedException{
        suppliersPage.clickUnarchived(supplier);
    }
    public static void clickCloseArchived(){
        suppliersPage.clickCloseArchived();
    }
    public static boolean isArchivedSupplierDisplayed(String supplier)throws InterruptedException{
        return suppliersPage.isArchivedSupplierDisplayed(supplier);
    }

}
