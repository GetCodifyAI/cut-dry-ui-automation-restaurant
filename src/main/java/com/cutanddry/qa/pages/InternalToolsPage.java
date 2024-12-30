package com.cutanddry.qa.pages;

import com.cutanddry.qa.base.TestBase;
import org.openqa.selenium.By;

public class InternalToolsPage extends TestBase {
    By configureSupplierLink = By.xpath("//a[contains(text(),'Configure Supplier')]");
    String editDetails = "//td[contains(text(),'SUPPLIER')]/..//td//a[contains(text(),'Edit Details')]";
    By payDetailsBtn = By.xpath("//a[contains(text(),'Pay Details')]");
    String configureInternalToolsChanges = "//label[contains(text(),'CONFIGURATION')]/..//input";
    By saveBtn = By.xpath("//button[contains(text(),'Run Invoice Sync')]/following-sibling::button[contains(text(),'Save')]");
    By successOverlay = By.xpath("//h2[contains(text(),'Succcess')]");
    By okBtn = By.xpath("//button[contains(text(),'OK')]");

    public void clickConfigureSuppliers(){
        restaurantUI.click(configureSupplierLink);
    }

    public void clickEditDetails(String Distributor){
        restaurantUI.click(By.xpath(editDetails.replace("SUPPLIER",Distributor)));
    }

    public void clickOnPayDetailsSection(){
        restaurantUI.click(payDetailsBtn);
    }

    public void clickUncheckFromInternalTools(String Configuration){
        restaurantUI.waitForVisibility(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION",Configuration)));
        if(restaurantUI.isCheckboxSelected(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION",Configuration)))) {
            restaurantUI.click(By.xpath(configureInternalToolsChanges.replace("CONFIGURATION", Configuration)));
        }
    }

    public void clickSave(){
        restaurantUI.click(saveBtn);
    }

    public boolean isSuccessOverlayDisplayed(){
        return restaurantUI.isDisplayed(successOverlay);
    }

    public void clickOK(){
        restaurantUI.click(okBtn);
    }



}
