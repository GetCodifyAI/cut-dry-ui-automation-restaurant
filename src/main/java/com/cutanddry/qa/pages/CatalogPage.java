package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CatalogPage extends LoginPage {

    String multiUomDropDown = "(//div[text()='NAME']/../../following-sibling::*//div/*[local-name()='svg'])[last()]";
    String multiUomDropDownOption ="//div[text()='OPTION']";
    String btn_addToCartPlusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'plus')])[UOM]";
    String btn_editQuantities = "//div[text()='Organic Bananas - 2 LB']/../../following-sibling::*//div//button[text()='Edit Quantities']";
    String btn_addToCartMinusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'minus')])[UOM]";
    By btn_addToCart = By.xpath("(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//button[text()='Add to Cart']");
    String getPriceUOM = "(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div//span[contains(text(),'$')])[UOM]";
    By btn_backToCatalog = By.xpath("//button[contains(text(),'Back')]");
    String multiUomDropDownOG = "(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg'])[1]";
    String btn_OGAddToCartPlusQuantity ="(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg' and @data-icon='plus'])[UOM]";
    String getOGPriceUOM ="(//td[text()='CODE']/ancestor::tr/td[5]/div/div/div/div/span[contains(@class,'prioritizedPrice')])[UOM]";
    By multiUomOption =By.xpath("//div[text()='Multiple Units']");
    String txt_orderIdMulti = "(//div[contains(text(),'Order Number #')])[UOM]";
    By getTotalItemCount = By.xpath("//td[text()='Items:']/following-sibling::td");
    By getTotalItemPrice = By.xpath("//td[text()='Total:']/following-sibling::td");
    By getTotalEndlessAislePriceReviewOrder = By.xpath("//td[contains(text(),'Endless Aisle Total')]/following-sibling::td");
    By getTotalEndlessAisleSubTotalPriceReviewOrder = By.xpath("//td[contains(text(),'Endless Aisle Subtotal')]/following-sibling::td");
    By getSubTotalOrderPrice = By.xpath("//*[contains(text(),'Subtotal')]/following-sibling::div");
    By getTotalPriceReviewOrder = By.xpath("//td[text()='Total:']/following-sibling::td");
    By getTotalQuantityReviewOrder = By.xpath("//td[contains(text(),'Total Quantity:')]/following-sibling::td");
    By getDeliveryFeesReviewOrder = By.xpath("//td[contains(text(),'Delivery Fee')]/following-sibling::td");
//    By getTotalOrderQuantity = By.xpath("//div[contains(text(),'Items')]/../following-sibling::td");
    By getTotalOrderQuantity = By.xpath("//div[contains(text(),'Total Qty')]/following-sibling::div");
//    By getTotalOrderPrice = By.xpath("//div[contains(text(),'Total')]/../following-sibling::td");
    By getTotalOrderPrice = By.xpath("//div[text()='Total']/following-sibling::div");
    By itemTypeDropDown = By.xpath("//div[contains(text(), 'Item Type')]");
    By itemTypeDropDownOption = By.xpath("//div[contains(text(), 'Item Type')]/../../following-sibling::div//*[name()='svg' and @data-icon='square']/following-sibling::div[contains(text(), 'Special Order')]");
    By txt_catalog = By.xpath("//div[contains(text(),'Manage Your Digital Catalog')]");
    By searchField = By.xpath("//div//input[contains(@placeholder,'Find Item in Catalog')]");
    String itemInTheGrid = "//tr[contains(@class,'_du1frc')]//td[text()='ITEMCODE']";
    By ItemCodeInCatalogData = By.xpath("//div[normalize-space(.)='Product Code (SKU)']/ancestor::div[2]/following-sibling::div//input");
    By substituteTab = By.xpath("//div[contains(text(),'Product Substitutes')]");
    String deleteSubstituteItemBtn = "//div[contains(text(),'ITEMCODE')]//following-sibling::div/*[local-name()='svg']";
    By saveChangesBtn = By.xpath("//button[text()='Save']");
    By addSubstitutionsBtn = By.xpath("//div[contains(text(),'+ Add Substitution')]");
    By selectSubstituteTxtField = By.xpath("//div[contains(text(),'Select...')]");
    By substituteItemInputField = By.xpath("//div[contains(text(),'Select...')]/following::input[@type='text' and @aria-autocomplete='list']");
    String selectItemFromDropdown = "(//div[contains(text(),'ITEMCODE')])[last()]";
    By substituteAddBtn = By.xpath("//button[contains(text(),'Add')]");
    By substituteCancelBtn = By.xpath("//button[contains(text(),'Cancel')]");
    String substituteItemNameTxt = "//div[contains(text(),\"ITEMNAME\")]";
    By successOverlay = By.xpath("//div[contains(text(),'successfully saved!')]");
    By btn_deleteSubstitute = By.xpath("//div/*[local-name()='svg' and @data-icon='circle-xmark']");
    String getPriceUOMJIT = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//div//span[contains(text(),'(')][1])[UOM]";
    By txt_category = By.xpath("//div[text()='Category']");
    By purchaseHistory = By.xpath("//div[text()='Purchase History']");
    String priceColumn = "//th[text()='PRICE']";
    String lastOrderPrice = "//span[contains(text(),'PRICE')]";
    By btn_showSub = By.xpath("//label[text()='Show Subs']");
    By btn_dontShowSub = By.xpath("//label[text()=concat(\"Don\", \"'\", \"t Show Subs\")]\n");
    By dealsTypeDropDown = By.xpath("//div[contains(text(), 'Deals')]");
    By dealsTypeDownOption = By.xpath("//div[contains(text(), 'Deals')]/../../following-sibling::div//*[name()='svg' and @data-icon='square']/following-sibling::div[contains(text(), 'GPO Contracted Items')]");
    By txt_dealsTypeDownOption = By.xpath("//div[contains(text(), 'Deals')]/../../following-sibling::div//*[name()='svg' and @data-icon='square-check']/following-sibling::div[contains(text(), 'GPO Contracted Items')]");
    By productConfigsEditBtn = By.xpath("//*[contains(text(),'Product Configuration')]/following-sibling::button");
    By productCatalogEditBtn =  By.xpath("//button[normalize-space()='Edit']");
    By productStatusDropdown = By.xpath("//div[normalize-space()='Product Status']/following::div[@id='config-active']");
    String productStatus = "(//div[contains(text(),'PRODSTATUS')])[last()]";
    By itemStatusDropdown = By.xpath("(//div[contains(text(),'All Results')]/../following-sibling::div//div[contains(@class,'value-container')])[3]");
    String itemStatusOption = "(//div[contains(text(),'ITEMSTATUS') and contains(@class,'themed_select__option')])[last()]";







    public void ClickOnMultiUomDropDown(String name)throws InterruptedException{
//        getRestaurantUI().waitForVisibility(By.xpath(multiUomDropDown.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(multiUomDropDown.replace("NAME", name)));
        getRestaurantUI().clickUsingJavaScript(By.xpath(multiUomDropDown.replace("NAME", name)));
    }
    public void ClickOnMultiUomDropDownOption(String option){
        getRestaurantUI().waitForVisibility(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
        getRestaurantUI().click(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
    }
    public void clickAddToCartPlusIcon(String uom)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        getRestaurantUI().click(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        getRestaurantUI().waitForVisibility(btn_addToCart);
    }
    public void clickAddToCartMinusIcon(String uom) throws InterruptedException {
        getRestaurantUI().waitForVisibility(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
        getRestaurantUI().click(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
        getRestaurantUI().waitForVisibility(btn_addToCart);
    }
    public void ClickOnEditQuantities(String name)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(btn_editQuantities.replace("NAME", name)));
        getRestaurantUI().click(By.xpath(btn_editQuantities.replace("NAME", name)));
    }
    public boolean isEditQuantitiesButtonDisplayed(String name){
        try {
            getRestaurantUI().waitForVisibility(By.xpath(btn_editQuantities.replace("NAME", name)));
        } catch (Exception e){
            return false;
        }
        return getRestaurantUI().isDisplayed(By.xpath(btn_editQuantities.replace("NAME", name)));
    }
    public boolean isAddToCartButtonDisplayed(){
        return getRestaurantUI().isDisplayed(btn_addToCart);
    }
    public double getPDPPriceUOM(String uom) throws InterruptedException {
        try {
            return extractPrice(By.xpath(getPriceUOM.replace("UOM", uom)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(By.xpath(getPriceUOM.replace("UOM", uom)));
        }
    }
    private double extractPrice(By priceLocator) {
        getRestaurantUI().waitForVisibility(priceLocator);

        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);

        // ✅ Extract only numbers and decimal
        String numericPrice = priceText.replaceAll("[^0-9.]", "");

        return Double.parseDouble(numericPrice);
    }

    public void clickOnBackToCatalog(){
        getRestaurantUI().waitForVisibility(btn_backToCatalog);
        getRestaurantUI().waitForClickability(btn_backToCatalog);
        getRestaurantUI().clickUsingJavaScript(btn_backToCatalog);
    }
    public void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        getRestaurantUI().click(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        getRestaurantUI().click(multiUomOption);
        getRestaurantUI().waitForInvisibility(multiUomOption);
    }
    public void clickOGAddToCartPlusIcon(String code,String uom)throws InterruptedException{
        getRestaurantUI().waitForVisibility(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().click(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        getRestaurantUI().waitForVisibility(By.xpath(getOGPriceUOM.replace("CODE", code).replace("UOM", uom)));
    }
    public double getOGPriceUOM(String code ,String uom) throws InterruptedException {
        try {
            return extractPrice(By.xpath(getOGPriceUOM.replace("CODE", code).replace("UOM", uom)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(By.xpath(getOGPriceUOM.replace("CODE", code).replace("UOM", uom)));
        }
    }
    public String getMultiOrderedId(String uom) {
        String orderId = getRestaurantUI().getText(By.xpath(txt_orderIdMulti.replace("UOM", uom)));
        return orderId.substring(orderId.indexOf("#") + 1).trim();
    }
    public double getTotalPriceUOM() throws InterruptedException {
        try {
            return extractPrice(getTotalItemPrice);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getTotalItemPrice);
        }
    }
    public String getTotalItemCount() throws InterruptedException {
        getRestaurantUI().waitForElementEnabledState(getTotalItemCount,true);
        return getRestaurantUI().getText(getTotalItemCount);
    }
    public double getTotalEndlessAislePriceInReviewOrder() throws InterruptedException {
        try {
            return extractPrice(getTotalEndlessAislePriceReviewOrder);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getTotalEndlessAislePriceReviewOrder);
        }
    }
    public double getTotalEndlessAisleSubTotalPriceInReviewOrder() throws InterruptedException {
        try {
            return extractPrice(getTotalEndlessAisleSubTotalPriceReviewOrder);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getTotalEndlessAisleSubTotalPriceReviewOrder);
        }
    }
    public double getSubTotalPriceInOrder() throws InterruptedException {
        try {
            return extractPrice(getSubTotalOrderPrice);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getSubTotalOrderPrice);
        }
    }
    public double getTotalPriceInReviewOrder() throws InterruptedException {
        try {
            return extractPrice(getTotalPriceReviewOrder);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getTotalPriceReviewOrder);
        }
    }
    public String getTotalQuantityInReviewOrder(){
        return getRestaurantUI().getText(getTotalQuantityReviewOrder);
    }
    public double getDeliveryFeesPriceInReviewOrder() throws InterruptedException {
        try {
            return extractPrice(getDeliveryFeesReviewOrder);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getDeliveryFeesReviewOrder);
        }
    }
    public String getTotalQuantityInOrder(){
        return getRestaurantUI().getText(getTotalOrderQuantity);
    }
    public double getTotalPriceInOrder() throws InterruptedException {
        try {
            return extractPrice(getTotalOrderPrice);
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPrice(getTotalOrderPrice);
        }
    }
    public void clickItemType()throws InterruptedException{
        getRestaurantUI().click(itemTypeDropDown);
        getRestaurantUI().click(itemTypeDropDownOption);
    }
    public boolean isCatalogTextDisplayed() {
        getRestaurantUI().waitForVisibility(txt_catalog);
        return getRestaurantUI().isDisplayed(txt_catalog);
    }
    public void clickSearchItemInCatalog(String itemName){
        getRestaurantUI().click(searchField);
        getRestaurantUI().sendKeys(searchField,itemName);
    }
    public void clickonItemOnCatalogPage(String itemCode){
        getRestaurantUI().waitForVisibility(By.xpath(itemInTheGrid.replace("ITEMCODE",itemCode)));
        getRestaurantUI().click(By.xpath(itemInTheGrid.replace("ITEMCODE",itemCode)));
    }
    public String getItemCodeFromCatalogDataPage(){
        getRestaurantUI().waitForVisibility(ItemCodeInCatalogData);
        return getRestaurantUI().getText(ItemCodeInCatalogData,"value");
    }
    public void clickOnSubstituteTab(){
        getRestaurantUI().clickUsingJavaScript(substituteTab);
    }
    public boolean isDeleteSubstituteItemDisplayed(String itemCode){
        return  getRestaurantUI().isDisplayed(By.xpath(deleteSubstituteItemBtn.replace("ITEMCODE",itemCode)));
    }
    public void clickOnDeleteSubstituteItemBtn(String itemCode){
        getRestaurantUI().waitForVisibility(By.xpath(deleteSubstituteItemBtn.replace("ITEMCODE",itemCode)));
        getRestaurantUI().click(By.xpath(deleteSubstituteItemBtn.replace("ITEMCODE",itemCode)));
    }
    public void clickOnSaveChangesBtn(){
        getRestaurantUI().waitForVisibility(saveChangesBtn);
        getRestaurantUI().click(saveChangesBtn);
    }
    public void clickAddSubstitutionBtn(){
        getRestaurantUI().waitForVisibility(addSubstitutionsBtn);
        getRestaurantUI().scrollToElement(addSubstitutionsBtn);
        getRestaurantUI().click(addSubstitutionsBtn);
    }
    public String getSubstituteItemName(String substituteItem){
        getRestaurantUI().click(selectSubstituteTxtField);
        getRestaurantUI().sendKeys(substituteItemInputField,substituteItem);
        getRestaurantUI().waitForVisibility(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        getRestaurantUI().waitForClickability(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        String ItemName = getRestaurantUI().getText(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        String cleanedItemName = ItemName.split(":")[1].split("\\(")[0].trim();
        getRestaurantUI().click(substituteCancelBtn);
        getRestaurantUI().click(substituteAddBtn);
        return cleanedItemName;
    }
    public void searchSubstituteItem(String substituteItem){
        getRestaurantUI().click(selectSubstituteTxtField);
        getRestaurantUI().sendKeysWaitAndSelectDropdownOptionByEnter(substituteItemInputField,substituteItem);
    }
    public void addSubstitutionsBtn(){
        getRestaurantUI().click(substituteAddBtn);
    }
    public boolean isSuccessOverlayDisplayed(){
        getRestaurantUI().waitForVisibility(successOverlay);
        boolean isDisplayed = getRestaurantUI().isDisplayed(successOverlay);
        if (isDisplayed) {
            getRestaurantUI().waitForInvisibility(successOverlay);
        }
        return isDisplayed;
    }
    public boolean isSubstituteItemDisplayed(String substituteItem){
        getRestaurantUI().waitForVisibility(By.xpath(substituteItemNameTxt.replace("ITEMNAME",substituteItem)));
        return getRestaurantUI().isDisplayed(By.xpath(substituteItemNameTxt.replace("ITEMNAME",substituteItem)));
    }
    public void deleteSubstitute(){
        getRestaurantUI().click(btn_deleteSubstitute);
    }
    public double getPDPPriceUOMJIT(String uom) throws InterruptedException {
        try {
            return extractPrice(By.xpath(getPriceUOMJIT.replace("UOM", uom)));
        } catch (Exception e) {
            System.out.println("Fallback to alternative price locator due to: " + e.getMessage());
            return extractPriceJIT(By.xpath(getPriceUOMJIT.replace("UOM", uom)));
        }
    }
    private double extractPriceJIT(By priceLocator) {
        getRestaurantUI().waitForVisibility(priceLocator);
        String tagName = getRestaurantUI().getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = getRestaurantUI().getText(priceLocator, "value");
        } else {
            priceText = getRestaurantUI().getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);

        // Remove currency symbols, slashes, unit info, and non-digit characters except dot and minus
        String cleaned = priceText.replaceAll("[^0-9.-]", "");

        return Double.valueOf(cleaned);
    }
    public boolean isCategoryDisplayed(){
        getRestaurantUI().waitForVisibility(txt_category);
       return getRestaurantUI().isDisplayed(txt_category);
    }
    public void clickPurchaseHistory(){
        getRestaurantUI().scrollToElement(purchaseHistory);
        getRestaurantUI().click(purchaseHistory);
    }
    public boolean isPriceColumnDisplay(String price){
        return getRestaurantUI().isDisplayed(By.xpath(priceColumn.replace("PRICE",price)));
    }
    public boolean isLastOrderPriceDisplay(String price){
        return getRestaurantUI().isDisplayed(By.xpath(lastOrderPrice.replace("PRICE",price)));
    }
    public void clickShowSub(){
        getRestaurantUI().click(btn_showSub);
    }
    public void clickDontShowSub(){
        getRestaurantUI().click(btn_dontShowSub);
    }
    public void clickDealsType()throws InterruptedException{
        getRestaurantUI().click(dealsTypeDropDown);
        getRestaurantUI().click(dealsTypeDownOption);
    }
    public boolean isGPOContractedDisplay()throws InterruptedException{
        return getRestaurantUI().isDisplayed(txt_dealsTypeDownOption);
    }
    public void clickEditOnProductConfigs(){
        getRestaurantUI().waitForVisibility( productCatalogEditBtn);
        getRestaurantUI().click(productCatalogEditBtn);
    }

    public void clickEditOnProductCatalogControl(){
        getRestaurantUI().waitForVisibility(productCatalogEditBtn);
        getRestaurantUI().click(productCatalogEditBtn);
    }

    public void clickOnInactiveOrInactive(String prodStatus){
        getRestaurantUI().click(productStatusDropdown);
        getRestaurantUI().waitForVisibility(By.xpath(productStatus.replace("PRODSTATUS",prodStatus)));
        getRestaurantUI().click(By.xpath(productStatus.replace("PRODSTATUS",prodStatus)));
    }
    public void clickOnItemStatus(String itemStatus){
        getRestaurantUI().click(itemStatusDropdown);
        getRestaurantUI().waitForVisibility(By.xpath(itemStatusOption.replace("ITEMSTATUS",itemStatus)));
        getRestaurantUI().click(By.xpath(itemStatusOption.replace("ITEMSTATUS",itemStatus)));
    }


}
