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
    By txt_editOrderGuide = By.xpath("//span[contains(text(), 'Edit Order Guide')]");
    By btn_moreOptions = By.xpath("//span[contains(text(), 'More Options')]");
    By btn_exportOrderGuide = By.xpath("//a[contains(text(), 'Export Order Guide (XLSX)')]");
    By btn_importOrderGuide = By.xpath("//a[contains(text(), 'Import Order Guide (XLSX)')]");
    By btn_uploadToOrder = By.xpath("//a[contains(text(), 'Upload to Order')]");
    By btn_create = By.xpath("//button[contains(text(), 'Create')]");
    By tbx_OrderGuideName = By.xpath("//input[@placeholder='Enter Name']");
    By btn_submitOrderGuide = By.xpath("//button[contains(text(), 'Submit')]");
    By btn_addFromCatalog = By.xpath("//div[contains(text(), 'Add from Catalog')]");
    By btn_addToOrderGuide = By.xpath("//button[@data-tip='Add to Order Guide']");
    By btn_closeEditor = By.xpath("//button[contains(text(), 'Close Editor')]");
    By btn_removeFromOrderGuide = By.xpath("//button[@data-tip='Remove from Order Guide']");
    By btn_sortCustomOrder = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Custom Order']");
    By btn_sortItemCategory = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Item Categories']");
    By btn_sortAlphabetical = By.xpath("//div[contains(@class, 'cd_themed_select__single-value') and text()='Alphabetical (A-Z)']");
    By btn_selectCustomOrder = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Custom Order')]");
    By btn_selectItemCategory = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Item Categories')]");
    By btn_selectAlphabetical = By.xpath("//div[contains(@class, 'cd_themed_select__option') and contains(text(), 'Alphabetical (A-Z)')]");
    By txt_seaFood = By.xpath("//div[contains(text(), 'seafood')]");
    By btn_browse = By.xpath("//input[@type='file']");
    By btn_uploadFile = By.xpath("//button[contains(text(), 'Upload File')]");
    By btn_next = By.xpath("//button[contains(text(), 'Next')]");
    By btn_confirm = By.xpath("//button[contains(text(), 'Confirm')]");
    By txt_successfulOrderGuide = By.xpath("//h2[contains(text(), 'Order guide updated successfully')]");
    By txt_substitutions = By.xpath("//div[contains(text(), 'Substitutions (1 of 1)')]");
    By txt_invalidDeliveryDate = By.xpath("//h2[text()='Error! Invalid Delivery Date']");
    By btn_close = By.xpath("//button[contains(text(), 'Close')]");
    By btn_deliveryDate = By.xpath("//div[@class='cd_themed_select__control css-sa5o0q-control']");
    By btn_selectDeliveryDateFirstLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[1]");
    By btn_selectDeliveryDateSecondLine = By.xpath("(//div[contains(@class, 'cd_themed_select__option')])[2]");
    By btn_orderGuideSettings = By.xpath("//a[contains(text(), 'Order Guide Settings')]");
    By btn_orderApproval = By.xpath("//div[contains(@class, 'react-switch-handle')]");
    By btn_save = By.xpath("//button[contains(@class, 'btn btn-primary') and contains(text(), 'Save')]");
    By btn_previousDraftOrderNo = By.xpath("//div[contains(text(),'previous draft order')]/..//div[text()='No']");
    By btn_placeOrder = By.xpath("//a[contains(@class, 'btn-primary') and contains(text(), 'Place Order')]");
    By btn_increaseQtyFirstRowInWL = By.xpath("//tr[2]/td[6]/div/div/div/div[3]");
    By btn_decreaseQtyFirstRowInWL = By.xpath("//tr[2]/td[6]/div/div/div/div[1]");
    By txt_foodServiceDistCenter = By.xpath("//span[text()='Food Service Distribution Centre']");
    By txt_retailDistCenter = By.xpath("//span[text()='Retail Distribution Centre']");
    String txt_orders = "(//div[contains(text(), 'Order #')])[NUM]";
    By lbl_itemNameListWL = By.xpath("//td//span/div[@data-tip='View Product Details']");

    public boolean isPreviousDraftOrderNoDisplayed() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(btn_previousDraftOrderNo, true);
        restaurantUI.waitForCustom(2000);
        return restaurantUI.isDisplayed(btn_previousDraftOrderNo);
    }

    public void clickPreviousDraftOrderNo() throws InterruptedException {
        restaurantUI.click(btn_previousDraftOrderNo);
    }

    public String getItemNameFirstRow() {
        return restaurantUI.getText(lbl_itemNameList);
    }

    public void clickPlusQryFirstRow() {
        restaurantUI.click(btn_increaseQtyFirstRow);
    }

    public void clickPlusQrySecondRow() {
        restaurantUI.click(btn_increaseQtySecondRow);
    }

    public void clickMinusQryFirstRow() {
        restaurantUI.click(btn_decreaseQtyFirstRow);
    }

    public void clickMinusQrySecondRow() {
        restaurantUI.click(btn_decreaseQtySecondRow);
    }

    public void clickPlusCatalog() {
        restaurantUI.click(btn_increaseQtyCatalog);
    }

    public void clickMinusCatalog() {
        restaurantUI.click(btn_decreaseQtyCatalog);
    }

    public String getItemNameSecondRow() {
        return restaurantUI.getText(lbl_itemNameList, 1);
    }

    public void clickOnCheckoutButton() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(btn_checkout, true);
        restaurantUI.click(btn_checkout);
        restaurantUI.waitForCustom(4000);
    }

    public boolean isCatalogTextDisplayed() {
        return restaurantUI.isDisplayed(txt_catalog);
    }

    public void clickOnCatalogButton() {
        restaurantUI.click(btn_catalog);
    }

    public void typeToSearchOnCatalog(String item) {
        restaurantUI.sendKeys(tbx_catalogSearch, item);
    }

    public void typeToSearchOnOrderGuide(String item) {
        restaurantUI.sendKeys(tbx_orderGuideSearch, item);
    }

    public String getFirstItemNameFrmSearchResults() {
        return restaurantUI.getText(lbl_catalogSearchItemList, 0);
    }

    public void clickAddToCartCatalog() throws InterruptedException {
        restaurantUI.waitForClickability(btn_addToCart);
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_addToCart);
        restaurantUI.waitForElementEnabledState(btn_checkout, true);
    }

    public String getItemQtyFirstRow() {
        return restaurantUI.getText(tbx_itemQuantityFirstRow, "value");
    }

    public String getItemQtyCatalog() {
        return restaurantUI.getText(tbx_itemQuantityCatalog, "value");
    }

    public Double getItemPriceCatalogSearch() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceSearchCatalogList).replace("$", ""));
    }

    public Double getItemPriceFirstRow() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceFirstRow).replace("$", ""));
    }

    public Double getItemPriceOnCheckoutButton() {
        return Double.valueOf(restaurantUI.getText(btn_checkout).replace("$", ""));
    }

    public boolean isAddToCartTextDisplayed() {
        return restaurantUI.isDisplayed(txt_addToCart);
    }

    public Double getItemPriceReviewCart() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCart).replace("$", ""));
    }

    public void clickPlusReviewCart() {
        restaurantUI.click(btn_increaseQtyReviewCart);
    }

    public void clickMinusReviewCart() {
        restaurantUI.click(btn_decreaseQtyReviewCart);
    }

    public String getItemQtyReviewCart() {
        return restaurantUI.getText(tbx_itemQuantityReviewCart, "value");
    }

    public Double getItemPriceReviewCartFirstRow() {
        return Double.valueOf(restaurantUI.getText(lbl_itemPriceReviewCartFirstRow).replace("$", ""));
    }

    public boolean isDuplicatePopupDisplayed() {
        try {
            return restaurantUI.isDisplayed(btn_duplicateOrderYes);
        } catch (Exception e) {
            return false;
        }
    }

    public void clickYesDuplicatePopup() {
        restaurantUI.waitForClickability(btn_duplicateOrderYes);
        restaurantUI.click(btn_duplicateOrderYes);
        restaurantUI.waitForInvisibility(btn_duplicateOrderYes);
    }

    public boolean isThankingForOrderPopupDisplayed() {
        try {
            restaurantUI.waitForClickability(lbl_thankYouForOrder);
            return restaurantUI.isDisplayed(lbl_thankYouForOrder);
        } catch (Exception e) {
            return false;
        }
    }

    public void submitOrder() {
        restaurantUI.waitForClickability(btn_submitOrder);
        restaurantUI.click(btn_submitOrder);
    }

    public void clickCompanyDropdown() {
        restaurantUI.waitForClickability(btn_companyDropdown);
        restaurantUI.click(btn_companyDropdown);
    }

    public boolean isCompanyDropdownTextDisplayed() {
        return restaurantUI.isDisplayed(txt_companyDropdownText);
    }

    public void clickOnPrint() {
        restaurantUI.waitForClickability(btn_print);
        restaurantUI.click(btn_print);
    }

    public void clickOnDownloadOrderGuide() {
        restaurantUI.waitForClickability(btn_downloadOrderGuide);
        restaurantUI.click(btn_downloadOrderGuide);
    }

    public boolean isPrintFriendlyPopupDisplayed() {
        return restaurantUI.isDisplayed(lbl_printFriendlyOrderGuide);
    }

    public void clickOnEdit() {
        restaurantUI.waitForClickability(btn_edit);
        restaurantUI.click(btn_edit);
    }

    public boolean isEditOrderGuideTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_editOrderGuide);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_editOrderGuide);
    }

    public void clickOnMoreOptions() {
        restaurantUI.waitForClickability(btn_moreOptions);
        restaurantUI.click(btn_moreOptions);
    }

    public void clickOnExportOrderGuide() {
        restaurantUI.waitForClickability(btn_exportOrderGuide);
        restaurantUI.click(btn_exportOrderGuide);
    }

    public void clickOnImportOrderGuide() {
        restaurantUI.waitForClickability(btn_importOrderGuide);
        restaurantUI.click(btn_importOrderGuide);
    }

    public void clickOnUploadToOrder() {
        restaurantUI.waitForClickability(btn_uploadToOrder);
        restaurantUI.click(btn_uploadToOrder);
    }

    public void clickOnCreate() {
        restaurantUI.waitForClickability(btn_create);
        restaurantUI.click(btn_create);
    }

    public void typeOrderGuideName(String orderGuideName) {
        restaurantUI.sendKeys(tbx_OrderGuideName, orderGuideName);
    }

    public void clickSubmitOrderGuide() {
        restaurantUI.waitForClickability(btn_submitOrderGuide);
        restaurantUI.click(btn_submitOrderGuide);
    }

    public void clickOnAddFromCatalog() {
        restaurantUI.waitForClickability(btn_addFromCatalog);
        restaurantUI.click(btn_addFromCatalog);
    }

    public void clickOnAddTOOrderGuide() {
        restaurantUI.waitForVisibility(btn_addToOrderGuide);
        restaurantUI.click(btn_addToOrderGuide);
    }

    public void clickOnCloseEditor() {
        restaurantUI.click(btn_closeEditor);
    }

    public void clickOnRemoveFromOrderGuide() throws InterruptedException {
        restaurantUI.waitForVisibility(btn_removeFromOrderGuide);
        restaurantUI.click(btn_removeFromOrderGuide);
        restaurantUI.waitForCustom(4000);
    }

    public void clickDropDownCustomerOrder() {
        restaurantUI.click(btn_sortCustomOrder);
    }

    public void clickDropDownItemCategory() {
        restaurantUI.click(btn_sortItemCategory);
    }

    public void clickDropDownAlphabetical() {
        restaurantUI.click(btn_sortAlphabetical);
    }

    public void selectDropDownCustomerOrder() {
        restaurantUI.click(btn_selectCustomOrder);
    }

    public void selectDropDownItemCategory() {
        restaurantUI.click(btn_selectItemCategory);
    }

    public void selectDropDownAlphabetical() {
        restaurantUI.click(btn_selectAlphabetical);
    }

    public boolean isSeaFoodTextDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_seaFood);
        } catch (Exception e) {
            return false;
        }
        return restaurantUI.isDisplayed(txt_seaFood);
    }

    public void clickOnUploadFile() {
        restaurantUI.waitForClickability(btn_uploadFile);
        restaurantUI.click(btn_uploadFile);
    }

    public void clickOnNext() {
        restaurantUI.waitForClickability(btn_next);
        restaurantUI.click(btn_next);
    }

    public void clickOnConfirm() {
        restaurantUI.waitForClickability(btn_confirm);
        restaurantUI.click(btn_confirm);
    }

    public boolean isOrderGuideSuccessfulTextDisplayed() {
        return restaurantUI.isDisplayed(txt_successfulOrderGuide);
    }

    public boolean isSubstitutionTextDisplayed() {
        return restaurantUI.isDisplayed(txt_substitutions);
    }

    public void fileUpload(String path) {
        restaurantUI.sendKeysHiddenElements(btn_browse, path);
    }

    public boolean isInvalidDeliveryTextDisplayed() {
        return restaurantUI.isDisplayed(txt_invalidDeliveryDate);
    }

    public void clickOnClose() throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_close);

    }


    public void clickOnDeliveryDate() throws InterruptedException{
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_deliveryDate);
    }

    public void selectDeliveryDateFirstLine() {
        restaurantUI.click(btn_selectDeliveryDateFirstLine);
    }
    public void selectDeliveryDateSecondLine()  throws InterruptedException {
        restaurantUI.waitForCustom(4000);
        restaurantUI.click(btn_selectDeliveryDateSecondLine);
        restaurantUI.waitForCustom(4000);
    }
    public void clickOnOrderGuideSettings() {
        restaurantUI.waitForClickability(btn_orderGuideSettings);
        restaurantUI.click(btn_orderGuideSettings);
    }
    public void clickOnOrderApproval() throws InterruptedException {
        restaurantUI.click(btn_orderApproval);
        restaurantUI.waitForCustom(4000);
    }
    public void clickOnSave() {
        restaurantUI.click(btn_save );
    }

    public void clickOnPlaceOrder() {
        restaurantUI.click(btn_placeOrder );
    }

    public void clickPlusQryFirstRowInWL() throws InterruptedException {
        restaurantUI.waitForCustom(1000);
        restaurantUI.click(btn_increaseQtyFirstRowInWL);
    }

    public boolean isMultiDistCentersDisplayed() {
        try {
            restaurantUI.waitForVisibility(txt_foodServiceDistCenter);
            restaurantUI.isDisplayed(txt_foodServiceDistCenter);
            restaurantUI.waitForVisibility(txt_retailDistCenter);
            restaurantUI.isDisplayed(txt_retailDistCenter);
        } catch (Exception e){
            return false;
        }
        return true;
    }
    public int getOrderCount(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (restaurantUI.isDisplayed(By.xpath(txt_orders.replace("NUM", String.valueOf(i))))){
                count += 1;
            };
        }
        return count;
    }
    public String getItemNameFirstRowWL() throws InterruptedException {
        restaurantUI.waitForElementEnabledState(lbl_itemNameListWL,true);
        restaurantUI.waitForCustom(3000);
        return restaurantUI.getText(lbl_itemNameListWL);
    }
}