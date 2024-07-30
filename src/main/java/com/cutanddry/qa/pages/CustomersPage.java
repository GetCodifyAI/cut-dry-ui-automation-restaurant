package com.cutanddry.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CustomersPage extends LoginPage {

    By lbl_itemNameList = By.xpath("//td//span/div[@data-tip='View Item Details']");
    By btn_increaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[3]");
    By btn_decreaseQtyFirstRow = By.xpath("//tr[1]/td[6]/div/div/div/div[1]");
    By btn_decreaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[1]");
    By btn_increaseQtySecondRow = By.xpath("//tr[2]/td[6]/div/div/div/div[3]");
    By btn_checkout = By.xpath("//button[@data-for='cartCheckoutButton']");
    By txt_catalog = By.xpath("//div[text()='All Items']");
    By btn_catalog = By.xpath("//div[text()='Catalog']");
    By tbx_catalogSearch = By.xpath("//input[@placeholder='Search catalog...']");
    By lbl_catalogSearchItemList = By.xpath("//div[contains(text(), 'Artichoke')]");
    By btn_addToCart = By.xpath("//button[text()='Add to Cart']");
    By tbx_itemQuantityFirstRow = By.xpath("//tr[1]//td[6]//input");
    By lbl_itemPriceFirstRow = By.xpath("//tr[1]//td[5]/div");
    By btn_increaseQtyCatalog = By.xpath("//div[3]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[4]/div/div[2]/div/div/div[2]/div/div[3]");
    By btn_decreaseQtyCatalog = By.xpath("//div[3]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[4]/div/div[2]/div/div/div[2]/div/div[1]");
    By tbx_itemQuantityCatalog = By.xpath("//div[3]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[1]/div[4]/div/div[2]/div/div/div[2]/div/div[2]/input");
    By txt_addToCart = By.xpath("//button[contains(text(), 'Add to Cart')]");

    public String getItemNameFirstRow(){
        return driver.findElements(lbl_itemNameList).getFirst().getText();
    }
    public void clickPlusQryFirstRow(){
        driver.findElement(btn_increaseQtyFirstRow).click();
    }
    public void clickPlusQrySecondRow(){driver.findElement(btn_increaseQtySecondRow).click();}
    public void clickMinusQryFirstRow(){
        driver.findElement(btn_decreaseQtyFirstRow).click();
    }
    public void clickMinusQrySecondRow(){
        driver.findElement(btn_decreaseQtySecondRow).click();
    }
    public void clickPlusCatalog(){
        driver.findElement(btn_increaseQtyCatalog).click();
    }
    public void clickMinusCatalog(){driver.findElement(btn_decreaseQtyCatalog).click();}
    public String getItemNameSecondRow(){return driver.findElements(lbl_itemNameList).get(1).getText();}
    public void clickOnCheckoutButton(){wait.until(ExpectedConditions.elementToBeClickable(btn_checkout));driver.findElement(btn_checkout).click();}
    public boolean isCatalogTextDisplayed(){return driver.findElement(txt_catalog).isDisplayed();}
    public void clickOnCatalogButton(){
        driver.findElement(btn_catalog).click();
    }
    public void typeToSearchOnCatalog(String item){
        driver.findElement(tbx_catalogSearch).sendKeys(item);
    }
    public String getFirstItemNameFrmSearchResults(){return driver.findElements(lbl_catalogSearchItemList).getFirst().getText();}
    public void clickAddToCartCatalog(){driver.findElement(btn_addToCart).click();}
    public String getItemQtyFirstRow(){return driver.findElement(tbx_itemQuantityFirstRow).getAttribute("value");}
    public String getItemQtyCatalog(){return driver.findElement(tbx_itemQuantityCatalog).getAttribute("value");}
    public Double getItemPriceFirstRow(){return Double.valueOf(driver.findElement(lbl_itemPriceFirstRow).getText().replace("$",""));}
    public Double getItemPriceOnCheckoutButton(){return Double.valueOf(driver.findElement(btn_checkout).getText().replace("$",""));}
    public boolean isAddToCartTextDisplayed(){return driver.findElement(txt_addToCart).isDisplayed();}

}