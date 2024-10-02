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
    By btn_testSupplier= By.xpath("//td[contains(text(), 'TestSupplier')]");
    By tbx_editSupplier = By.xpath("//input[@class='form-control']");
    By btn_testSupplierEdit= By.xpath("//td[contains(text(), 'TestSupplierEdit')]");
    By btn_deleteSupplier= By.xpath("//button[text()='Delete Supplier']");
    By btn_yes= By.xpath("//button[contains(text(), 'Yes')]");




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

    public boolean isTestSupplierCreated(){
        try {
            restaurantUI.waitForVisibility(btn_testSupplier);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(btn_testSupplier);
    }

    public void clickOnTestSupplier() throws InterruptedException {
        restaurantUI.click(btn_testSupplier);
    }

    public void editSupplierName(String editSupplierName) throws InterruptedException {
        restaurantUI.waitForCustom(2000);
        restaurantUI.clear(tbx_editSupplier);
        restaurantUI.waitForCustom(2000);
        restaurantUI.sendKeys(tbx_editSupplier,editSupplierName);
        restaurantUI.waitForCustom(2000);
    }

    public boolean isTestSupplierEditCreated(){
        try {
            restaurantUI.waitForVisibility(btn_testSupplierEdit);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(btn_testSupplierEdit);
    }

    public void clickOnTestSupplierEdit() throws InterruptedException {
        restaurantUI.click(btn_testSupplierEdit);
    }

    public void clickOnDelete() throws InterruptedException {
        restaurantUI.click(btn_deleteSupplier);
        restaurantUI.waitForCustom(2000);
    }

    public void clickOnYes() throws InterruptedException {
        restaurantUI.click(btn_yes  );
        restaurantUI.waitForCustom(6000);
    }
}
