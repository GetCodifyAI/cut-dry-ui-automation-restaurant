package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CatalogPage extends LoginPage {

    String multiUomDropDown = "(//div[text()='NAME']/../../following-sibling::*//div/*[local-name()='svg'])[last()]";
    String multiUomDropDownOption ="//div[text()='OPTION']";
    String btn_addToCartPlusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'plus')])[UOM]";
    String btn_editQuantities = "//div[text()='Organic Bananas - 2 LB']/../../following-sibling::*//div//button[text()='Edit Quantities']";
    String btn_addToCartMinusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'minus')])[UOM]";
    By btn_addToCart = By.xpath("(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//button[text()='Add to Cart']");
    String getPriceUOM = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//div//span[contains(text(),'$')][1])[UOM]";
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
    By getSubTotalOrderPrice = By.xpath("//*[contains(text(),'Subtotal')]/following-sibling::td");
    By getTotalPriceReviewOrder = By.xpath("//td[text()='Total:']/following-sibling::td");
    By getTotalQuantityReviewOrder = By.xpath("//td[contains(text(),'Total Quantity:')]/following-sibling::td");
    By getDeliveryFeesReviewOrder = By.xpath("//td[contains(text(),'Delivery Fee')]/following-sibling::td");
//    By getTotalOrderQuantity = By.xpath("//div[contains(text(),'Items')]/../following-sibling::td");
    By getTotalOrderQuantity = By.xpath("//td[contains(text(),'Total Quantity')]/following-sibling::td");
//    By getTotalOrderPrice = By.xpath("//div[contains(text(),'Total')]/../following-sibling::td");
    By getTotalOrderPrice = By.xpath("//td[text()='Total']/following-sibling::td");
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




    public void ClickOnMultiUomDropDown(String name)throws InterruptedException{
//        restaurantUI.waitForVisibility(By.xpath(multiUomDropDown.replace("NAME", name)));
        restaurantUI.click(By.xpath(multiUomDropDown.replace("NAME", name)));
        restaurantUI.clickUsingJavaScript(By.xpath(multiUomDropDown.replace("NAME", name)));
    }
    public void ClickOnMultiUomDropDownOption(String option){
        restaurantUI.waitForVisibility(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
        restaurantUI.click(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
    }
    public void clickAddToCartPlusIcon(String uom)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        restaurantUI.waitForCustom(4000);
    }
    public void clickAddToCartMinusIcon(String uom) throws InterruptedException {
        restaurantUI.waitForVisibility(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
        restaurantUI.waitForCustom(4000);
    }
    public void ClickOnEditQuantities(String name)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_editQuantities.replace("NAME", name)));
        restaurantUI.click(By.xpath(btn_editQuantities.replace("NAME", name)));
    }
    public boolean isEditQuantitiesButtonDisplayed(String name){
        try {
            restaurantUI.waitForVisibility(By.xpath(btn_editQuantities.replace("NAME", name)));
        } catch (Exception e){
            return false;
        }
        return restaurantUI.isDisplayed(By.xpath(btn_editQuantities.replace("NAME", name)));
    }
    public boolean isAddToCartButtonDisplayed(){
        return restaurantUI.isDisplayed(btn_addToCart);
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
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else {
            priceText = restaurantUI.getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);
        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/lb", "").replace("/pkg", "").trim());
    }
    public void clickOnBackToCatalog(){
        restaurantUI.waitForVisibility(btn_backToCatalog);
        restaurantUI.waitForClickability(btn_backToCatalog);
        restaurantUI.clickUsingJavaScript(btn_backToCatalog);
    }
    public void ClickOnMultiUomDropDownOG(String code)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        restaurantUI.click(By.xpath(multiUomDropDownOG.replace("CODE", code)));
        restaurantUI.click(multiUomOption);
        restaurantUI.waitForCustom(3000);
    }
    public void clickOGAddToCartPlusIcon(String code,String uom)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_OGAddToCartPlusQuantity.replace("CODE", code).replace("UOM", uom)));
        restaurantUI.waitForCustom(2000);
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
        String orderId = restaurantUI.getText(By.xpath(txt_orderIdMulti.replace("UOM", uom)));
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
        restaurantUI.waitForElementEnabledState(getTotalItemCount,true);
        return restaurantUI.getText(getTotalItemCount);
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
        return restaurantUI.getText(getTotalQuantityReviewOrder);
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
        return restaurantUI.getText(getTotalOrderQuantity);
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
        restaurantUI.click(itemTypeDropDown);
        restaurantUI.click(itemTypeDropDownOption);
    }
    public boolean isCatalogTextDisplayed() {
        restaurantUI.waitForVisibility(txt_catalog);
        return restaurantUI.isDisplayed(txt_catalog);
    }
    public void clickSearchItemInCatalog(String itemName){
        restaurantUI.click(searchField);
        restaurantUI.sendKeys(searchField,itemName);
    }
    public void clickonItemOnCatalogPage(String itemCode){
        try {
            restaurantUI.waitForCustom(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.waitForVisibility(By.xpath(itemInTheGrid.replace("ITEMCODE",itemCode)));
        restaurantUI.click(By.xpath(itemInTheGrid.replace("ITEMCODE",itemCode)));
    }
    public String getItemCodeFromCatalogDataPage(){
        restaurantUI.waitForVisibility(ItemCodeInCatalogData);
        return restaurantUI.getText(ItemCodeInCatalogData,"value");
    }
    public void clickOnSubstituteTab(){
        restaurantUI.clickUsingJavaScript(substituteTab);
    }
    public boolean isDeleteSubstituteItemDisplayed(String itemCode){
        return  restaurantUI.isDisplayed(By.xpath(deleteSubstituteItemBtn.replace("ITEMCODE",itemCode)));
    }
    public void clickOnDeleteSubstituteItemBtn(String itemCode){
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        restaurantUI.click(By.xpath(deleteSubstituteItemBtn.replace("ITEMCODE",itemCode)));
    }
    public void clickOnSaveChangesBtn(){
        restaurantUI.waitForVisibility(saveChangesBtn);
        restaurantUI.click(saveChangesBtn);
    }
    public void clickAddSubstitutionBtn(){
        restaurantUI.waitForVisibility(addSubstitutionsBtn);
        restaurantUI.scrollToElement(addSubstitutionsBtn);
        restaurantUI.click(addSubstitutionsBtn);
    }
    public String getSubstituteItemName(String substituteItem){
        restaurantUI.click(selectSubstituteTxtField);
        restaurantUI.sendKeys(substituteItemInputField,substituteItem);
        restaurantUI.waitForVisibility(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        restaurantUI.waitForClickability(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        try {
            restaurantUI.waitForCustom(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String ItemName = restaurantUI.getText(By.xpath(selectItemFromDropdown.replace("ITEMCODE",substituteItem)));
        String cleanedItemName = ItemName.split(":")[1].split("\\(")[0].trim();
        restaurantUI.click(substituteCancelBtn);
        restaurantUI.click(substituteAddBtn);
        return cleanedItemName;
    }
    public void searchSubstituteItem(String substituteItem){
        restaurantUI.click(selectSubstituteTxtField);
        restaurantUI.sendKeysWaitAndSelectDropdownOptionByEnter(substituteItemInputField,substituteItem);
    }
    public void addSubstitutionsBtn(){
        restaurantUI.click(substituteAddBtn);
    }
    public boolean isSuccessOverlayDisplayed(){
        restaurantUI.waitForVisibility(successOverlay);
        boolean isDisplayed = restaurantUI.isDisplayed(successOverlay);
        if (isDisplayed) {
            restaurantUI.waitForInvisibility(successOverlay);
        }
        return isDisplayed;
    }
    public boolean isSubstituteItemDisplayed(String substituteItem){
        try {
            restaurantUI.waitForCustom(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return restaurantUI.isDisplayed(By.xpath(substituteItemNameTxt.replace("ITEMNAME",substituteItem)));
    }
    public void deleteSubstitute(){
        restaurantUI.click(btn_deleteSubstitute);
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
        restaurantUI.waitForVisibility(priceLocator);
        String tagName = restaurantUI.getElement(priceLocator).getTagName();
        String priceText;

        if (tagName.equals("input")) {
            priceText = restaurantUI.getText(priceLocator, "value");
        } else {
            priceText = restaurantUI.getText(priceLocator);
        }

        System.out.println("Extracted Price: " + priceText);

        // Remove currency symbols, slashes, unit info, and non-digit characters except dot and minus
        String cleaned = priceText.replaceAll("[^0-9.-]", "");

        return Double.valueOf(cleaned);
    }
    public boolean isCategoryDisplayed()throws InterruptedException{
        restaurantUI.waitForCustom(3000);
        restaurantUI.waitForVisibility(txt_category);
       return restaurantUI.isDisplayed(txt_category);
    }
    public void clickPurchaseHistory(){
        restaurantUI.scrollToElement(purchaseHistory);
        restaurantUI.click(purchaseHistory);
    }
    public boolean isPriceColumnDisplay(String price){
        return restaurantUI.isDisplayed(By.xpath(priceColumn.replace("PRICE",price)));
    }
    public boolean isLastOrderPriceDisplay(String price){
        return restaurantUI.isDisplayed(By.xpath(lastOrderPrice.replace("PRICE",price)));
    }
    public void clickShowSub(){
        restaurantUI.click(btn_showSub);
    }
    public void clickDontShowSub(){
        restaurantUI.click(btn_dontShowSub);
    }


}
