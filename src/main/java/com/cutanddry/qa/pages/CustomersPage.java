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
    By tbx_orderGuideSearch = By.xpath("//input[@placeholder='Search order guide...']");
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
    By btn_companyDropdown = By.xpath("//button[.//span[text()='Company:']]");
    By txt_companyDropdownText = By.xpath("//a[contains(text(), 'Independent Foods Co')]");
    By btn_print = By.xpath("//button[contains(text(), 'Print')]");
    By btn_downloadOrderGuide = By.xpath("//button[contains(text(), 'Download Order Guide')]");
    By lbl_printFriendlyOrderGuide = By.xpath("//h5[contains(text(), 'Print-Friendly Order Guide')]");
    By btn_edit = By.xpath("//button[contains(., 'Edit')]");
    By txt_editOrderGuide= By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_moreOptions = By.xpath("//span[contains(text(), 'More Options')]");
    By btn_exportOrderGuide = By.xpath("//a[contains(text(), 'Export Order Guide (XLSX)')]");
    By btn_create = By.xpath("//button[contains(text(), 'Create')]");
    By tbx_OrderGuideName = By.xpath("//input[@placeholder='Enter Name']");
    By btn_submitOrderGuide = By.xpath("//button[contains(text(), 'Submit')]");
    By btn_addFromCatalog = By.xpath("//div[contains(text(), 'Add from Catalog')]");
    By btn_addToOrderGuide = By.xpath("//button[@data-tip='Add to Order Guide']");
    By btn_closeEditor = By.xpath("//button[contains(text(), 'Close Editor')]");
    By btn_removeFromOrderGuide = By.xpath("//button[@data-tip='Remove from Order Guide']");









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
    public void clickOnCheckoutButton()throws InterruptedException {
        restaurantUI.waitForElementEnabledState(btn_checkout,true);
        restaurantUI.click(btn_checkout);
        restaurantUI.waitForCustom(4000);
    }
    public boolean isCatalogTextDisplayed(){
        return restaurantUI.isDisplayed(txt_catalog);}
    public void clickOnCatalogButton(){
        restaurantUI.click(btn_catalog);
    }
    public void typeToSearchOnCatalog(String item){
        restaurantUI.sendKeys(tbx_catalogSearch,item);
    }
    public void typeToSearchOnOrderGuide(String item){
        restaurantUI.sendKeys(tbx_orderGuideSearch,item);
    }
    public String getFirstItemNameFrmSearchResults(){
        return restaurantUI.getText(lbl_catalogSearchItemList, 0);
    }
    public void clickAddToCartCatalog()throws InterruptedException {
        restaurantUI.waitForClickability(btn_addToCart);
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_addToCart);
        restaurantUI.waitForElementEnabledState(btn_checkout,true);
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
    public void clickCompanyDropdown(){
        restaurantUI.waitForClickability(btn_companyDropdown);
        restaurantUI.click(btn_companyDropdown);
    }
    public boolean isCompanyDropdownTextDisplayed(){
        return restaurantUI.isDisplayed(txt_companyDropdownText);}
    public void clickOnPrint(){
        restaurantUI.waitForClickability(btn_print);
        restaurantUI.click(btn_print);
    }
    public void clickOnDownloadOrderGuide(){
        restaurantUI.waitForClickability(btn_downloadOrderGuide);
        restaurantUI.click(btn_downloadOrderGuide);
    }
    public boolean isPrintFriendlyPopupDisplayed(){
        return restaurantUI.isDisplayed(lbl_printFriendlyOrderGuide);}
    public void clickOnEdit(){
        restaurantUI.waitForClickability(btn_edit);
        restaurantUI.click(btn_edit);
    }
    public boolean isEditOrderGuideTextDisplayed(){
        try {
            restaurantUI.waitForVisibility(txt_editOrderGuide);
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(txt_editOrderGuide);
    }
    public void clickOnMoreOptions(){
        restaurantUI.waitForClickability(btn_moreOptions);
        restaurantUI.click(btn_moreOptions);
    }
    public void clickOnExportOrderGuide(){
        restaurantUI.waitForClickability(btn_exportOrderGuide);
        restaurantUI.click(btn_exportOrderGuide);
    }
    public void clickOnCreate(){
        restaurantUI.waitForClickability(btn_create);
        restaurantUI.click(btn_create);
    }
    public void typeOrderGuideName(String orderGuideName){
        restaurantUI.sendKeys(tbx_OrderGuideName,orderGuideName);
    }
    public void clickSubmitOrderGuide(){
        restaurantUI.waitForClickability(btn_submitOrderGuide);
        restaurantUI.click(btn_submitOrderGuide);
    }
    public void clickOnAddFromCatalog(){
        restaurantUI.waitForClickability(btn_addFromCatalog);
        restaurantUI.click(btn_addFromCatalog);
    }
    public void clickOnAddTOOrderGuide(){
        restaurantUI.waitForVisibility(btn_addToOrderGuide);
        restaurantUI.click(btn_addToOrderGuide);
    }
    public void clickOnCloseEditor(){
        restaurantUI.click(btn_closeEditor);
    }
    public void clickOnRemoveFromOrderGuide(){
        restaurantUI.waitForVisibility(btn_removeFromOrderGuide);
        restaurantUI.click(btn_removeFromOrderGuide);
    }
}