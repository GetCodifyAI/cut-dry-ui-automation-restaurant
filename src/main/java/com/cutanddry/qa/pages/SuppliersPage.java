package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class SuppliersPage extends TestBase {

    By btn_suppliers = By.xpath("//div[normalize-space(text()) = 'Suppliers']");
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




    public void clickSuppliers(){ restaurantUI.click(btn_suppliers); }

    public boolean isSuppliersTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_suppliers);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_suppliers);
    }

    public void clickAddSupplier() throws InterruptedException {
        restaurantUI.click(btn_addSupplier);
        restaurantUI.waitForCustom(2000);
    }

    public void typeSupplierName(String supplierName) throws InterruptedException {
        restaurantUI.sendKeys(tbx_suppliers,supplierName);
        restaurantUI.waitForCustom(2000);
    }

    public void clickContinue() throws InterruptedException {
        restaurantUI.click(btn_continue);
        restaurantUI.waitForCustom(2000);
    }

    public void clickSave() throws InterruptedException {
        restaurantUI.click(btn_save);
        restaurantUI.waitForCustom(2000);
    }
    public void clickOnOneSupplier(String supplier) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
        restaurantUI.click(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
    }

    public void editSupplierName(String editSupplierName) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.clear(tbx_editSupplier);
        restaurantUI.waitForCustom(2000);
        restaurantUI.sendKeys(tbx_editSupplier,editSupplierName);
        restaurantUI.waitForCustom(2000);
    }
    public void clickOnDelete() throws InterruptedException {
        restaurantUI.click(btn_deleteSupplier);
        restaurantUI.waitForCustom(2000);
    }

    public void clickOnYes() throws InterruptedException {
        restaurantUI.click(btn_yes  );
        restaurantUI.waitForCustom(6000);
    }
    public boolean isAddSuppliersPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_addSupplier);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_addSupplier);
    }
    public void typeSupplierName2(String supplierName) throws InterruptedException {
        restaurantUI.sendKeys(tbx_suppliers2,supplierName);
        restaurantUI.waitForCustom(2000);
    }
    public boolean isAddedSupplierDisplayed(String supplier)throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
        return restaurantUI.isDisplayed(By.xpath(addedSupplier.replace("SUPPLIER",supplier)));
    }
    public void clickOk(){
        restaurantUI.click(btn_ok);
    }
    public boolean isEditSuppliersPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(editSupplierPopUp);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(editSupplierPopUp);
    }
    public void clickOnArchived() throws InterruptedException {
        restaurantUI.click(btn_archivedSupplier);
        restaurantUI.waitForCustom(2000);
    }
    public void clickViewArchived()throws InterruptedException{
        restaurantUI.waitForCustom(2000);
        restaurantUI.waitForVisibility(btn_viewArchivedSupplier);
        restaurantUI.waitForClickability(btn_viewArchivedSupplier);
        restaurantUI.clickUsingJavaScript(btn_viewArchivedSupplier);
    }
    public boolean isArchivedSupplierPopUpDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_archivedSupplier);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_archivedSupplier);
    }
    public void clickUnarchived(String supplier)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        restaurantUI.clickUsingJavaScript(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        restaurantUI.waitForCustom(2000);
    }

    public void clickCloseArchived(){
        restaurantUI.click(btn_close);
    }
    public boolean isArchivedSupplierDisplayed(String supplier)throws InterruptedException{
        try {
            restaurantUI.waitForVisibility(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(btn_unArchived.replace("SUPPLIER",supplier)));
    }
}
