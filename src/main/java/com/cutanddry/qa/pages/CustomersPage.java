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
    By btn_increaseQtyCatalog = By.xpath("//div[contains(@class, 'd-flex') and contains(@class, 'btn-primary')]/*[name()='svg' and contains(@data-icon, 'plus')]");
    By btn_decreaseQtyCatalog = By.xpath("//div[contains(@class, 'd-flex') and contains(@class, 'btn-primary')]/*[name()='svg' and @data-icon='minus']");
    By tbx_itemQuantityCatalog = By.xpath("//input[@type='number']");
    By lbl_itemPriceSearchCatalogList = By.xpath("//div[4]/div/div[1]/div/span[contains(text(), '$')]");
    By txt_addToCart = By.xpath("//button[contains(text(), 'Add to Cart')]");
    By lbl_itemPriceReviewCart = By.xpath("//tbody[2]/tr[2]/td[2]");
    By btn_increaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div[3]");
    By btn_decreaseQtyReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div[1]");
    By tbx_itemQuantityReviewCart = By.xpath("//tr[2]/td[4]/div/div/div/div[2]/input");
    By lbl_itemPriceReviewCartFirstRow = By.xpath("//tr[2]/td[3]/div/span");
    By btn_submitOrder = By.xpath("//button[contains(text(),'Submit Order')]");
    By btn_duplicateOrderYes = By.xpath("//button[contains(text(), 'Yes')]");
    By lbl_thankYouForOrder = By.xpath("//*[contains(text(),'Thank you for your order!')]");


    public String getItemNameFirstRow(){
        return restaurantUI.getText(lbl_itemNameList);
    }
    public void clickPlusQryFirstRow(){
        restaurantUI.click(btn_increaseQtyFirstRow);
    }
    public void clickPlusQrySecondRow(){
        restaurantUI.click(btn_increaseQtySecondRow);
    }
    public void clickMinusQryFirstRow(){
        restaurantUI.click(btn_decreaseQtyFirstRow);
    }
    public void clickMinusQrySecondRow(){
        restaurantUI.click(btn_decreaseQtySecondRow);
    }
    public void clickPlusCatalog(){
        restaurantUI.click(btn_increaseQtyCatalog);
    }
    public void clickMinusCatalog(){
        restaurantUI.click(btn_decreaseQtyCatalog);
    }
    public String getItemNameSecondRow(){
        return restaurantUI.getText(lbl_itemNameList,1);
    }
    public void clickOnCheckoutButton(){
        restaurantUI.click(btn_checkout);}
    public boolean isCatalogTextDisplayed(){
        return restaurantUI.isDisplayed(txt_catalog);}
    public void clickOnCatalogButton(){
        restaurantUI.click(btn_catalog);
    }
    public void typeToSearchOnCatalog(String item){
        restaurantUI.sendKeys(tbx_catalogSearch,item);
    }
    public String getFirstItemNameFrmSearchResults(){
        return restaurantUI.getText(lbl_catalogSearchItemList, 0);
    }
    public void clickAddToCartCatalog(){
        restaurantUI.click(btn_addToCart);
        restaurantUI.waitForClickability(btn_checkout);
    }
    public String getItemQtyFirstRow(){
        return restaurantUI.getText(tbx_itemQuantityFirstRow,"value");}
    public String getItemQtyCatalog(){
        return restaurantUI.getText(tbx_itemQuantityCatalog,"value");}
    public Double getItemPriceCatalogSearch(){
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceSearchCatalogList).replace("$",""));}
    public Double getItemPriceFirstRow(){
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceFirstRow).replace("$",""));}
    public Double getItemPriceOnCheckoutButton(){
        return Double.valueOf(restaurantUI.getText(btn_checkout).replace("$",""));}
    public boolean isAddToCartTextDisplayed(){
        return restaurantUI.isDisplayed(txt_addToCart);}
    public Double getItemPriceReviewCart(){
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCart).replace("$",""));}
    public void clickPlusReviewCart(){
        restaurantUI.click(btn_increaseQtyReviewCart);}
    public void clickMinusReviewCart(){
        restaurantUI.click(btn_decreaseQtyReviewCart);}
    public String getItemQtyReviewCart(){
        return restaurantUI.getText(tbx_itemQuantityReviewCart,"value");}
    public Double getItemPriceReviewCartFirstRow(){
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCartFirstRow).replace("$",""));}
    public boolean isDuplicatePopupDisplayed(){
        try {
            return restaurantUI.isDisplayed(btn_duplicateOrderYes);}
        catch (Exception e){return false;}}
    public void clickYesDuplicatePopup(){
        restaurantUI.waitForClickability(btn_duplicateOrderYes);
        restaurantUI.click(btn_duplicateOrderYes);
        restaurantUI.waitForInvisibility(btn_duplicateOrderYes);
    }
    public boolean isThankingForOrderPopupDisplayed(){
        try {
            restaurantUI.waitForClickability(lbl_thankYouForOrder);
            return restaurantUI.isDisplayed(lbl_thankYouForOrder);}
        catch (Exception e){return false;}}
    public void submitOrder(){
        restaurantUI.waitForClickability(btn_submitOrder);
        restaurantUI.click(btn_submitOrder);}

}