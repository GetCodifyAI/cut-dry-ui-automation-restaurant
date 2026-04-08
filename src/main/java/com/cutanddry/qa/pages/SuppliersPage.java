package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SuppliersPage extends TestBase {

    By btn_suppliers = By.xpath("(//div[normalize-space(text()) = 'Suppliers'])[1]");
    By txt_suppliers = By.xpath("//th[text()='Supplier Name']");
    By btn_addSupplier = By.xpath("//button[text()='Add Supplier']");
    By tbx_suppliers = By.xpath("//input[@placeholder='Supplier Name'][1]");
    By btn_continue= By.xpath("//button[b[text()='Continue']]");
    By btn_save= By.xpath("//button[text()='Save']");
    By tbx_editSupplier = By.xpath("//input[@class='form-control']");
    By btn_deleteSupplier= By.xpath("//button[text()='Delete Supplier']");
    By btn_yes= By.xpath("//button[contains(text(), 'Yes')]");
    By txt_addSupplier = By.xpath("//div[contains(text(),'Add Your Suppliers')]");
    By tbx_suppliers2 = By.xpath("(//input[@placeholder='Supplier Name'])[2]");
    String addedSupplier = "//td[(text()= 'SUPPLIER')]";
    By btn_ok = By.xpath("//button[text()='OK']");
    By editSupplierPopUp = By.xpath("//div[contains(text(), 'Edit Supplier')]");
    By btn_archivedSupplier= By.xpath("//button[text()='Archive Supplier']");
    By btn_viewArchivedSupplier = By.xpath("//button[contains(text(),'View Archived Suppliers')]");
    By txt_archivedSupplier = By.xpath("//div[text()='Archived Suppliers']");
    String btn_unArchived = "//td[text()='SUPPLIER']/following-sibling::td[4]//button";
    By btn_close = By.xpath("//button[@class='close']/span[text()='×']");




    public void clickSuppliers(){ getRestaurantUI().clickWithFallback(btn_suppliers); }

    public boolean isSuppliersTextDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_suppliers);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_suppliers);
    }

    public void clickAddSupplier() throws InterruptedException {
        getRestaurantUI().click(btn_addSupplier);
        getRestaurantUI().waitForCustom(2000);
    }

    public void typeSupplierName(String supplierName) throws InterruptedException {
        getRestaurantUI().sendKeys(tbx_suppliers,supplierName);
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickContinue() throws InterruptedException {
        getRestaurantUI().click(btn_continue);
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickSave() throws InterruptedException {
        getRestaurantUI().click(btn_save);
        getRestaurantUI().waitForCustom(2000);
    }
    public void clickOnOneSupplier(String supplier) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
        getRestaurantUI().click(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
    }

    public void editSupplierName(String editSupplierName) throws InterruptedException {
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().clear(tbx_editSupplier);
        getRestaurantUI().waitForCustom(2000);
        getRestaurantUI().sendKeys(tbx_editSupplier,editSupplierName);
        getRestaurantUI().waitForCustom(2000);
    }
    public void clickOnDelete() throws InterruptedException {
        getRestaurantUI().click(btn_deleteSupplier);
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickOnYes() throws InterruptedException {
        getRestaurantUI().click(btn_yes  );
        getRestaurantUI().waitForCustom(6000);
    }
    public boolean isAddSuppliersPopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_addSupplier);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_addSupplier);
    }
    public void typeSupplierName2(String supplierName) throws InterruptedException {
        getRestaurantUI().sendKeys(tbx_suppliers2,supplierName);
        getRestaurantUI().waitForCustom(2000);
    }
    public boolean isAddedSupplierDisplayed(String supplier)throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
        return getRestaurantUI().isDisplayed(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickOk(){
        getRestaurantUI().click(btn_ok);
    }
    public boolean isEditSuppliersPopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(editSupplierPopUp);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(editSupplierPopUp);
    }
    public void clickOnArchived() throws InterruptedException {
        getRestaurantUI().click(btn_archivedSupplier);
        getRestaurantUI().waitForCustom(2000);
    }
    public void clickViewArchived()throws InterruptedException{
        getRestaurantUI().waitForVisibility(btn_viewArchivedSupplier);
        getRestaurantUI().waitForClickability(btn_viewArchivedSupplier);
        getRestaurantUI().clickUsingJavaScript(btn_viewArchivedSupplier);
    }
    public boolean isArchivedSupplierPopUpDisplayed(){
        try {
            getRestaurantUI().waitForVisibility(txt_archivedSupplier);
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(txt_archivedSupplier);
    }
    public void clickUnarchived(String supplier)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        getRestaurantUI().waitForCustom(2000);
    }

    public void clickCloseArchived(){
        getRestaurantUI().click(btn_close);
    }
    public boolean isArchivedSupplierDisplayed(String supplier)throws InterruptedException{
        try {
            getRestaurantUI().waitForVisibility(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
    }
}
