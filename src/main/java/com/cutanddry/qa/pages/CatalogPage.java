package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class CatalogPage extends LoginPage {

    String multiUomDropDown = "(//div[text()='NAME']/../../following-sibling::*//div/*[local-name()='svg'])[last()]";
    String multiUomDropDownOption ="//div[text()='OPTION']";
    String btn_addToCartPlusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'plus')])[UOM]";
    String btn_editQuantities = "//div[text()='Organic Bananas - 2 LB']/../../following-sibling::*//div//button[text()='Edit Quantities']";
    String btn_addToCartMinusQuantity = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//*[name()='svg' and contains(@data-icon, 'minus')])[UOM]";
    By btn_addToCart = By.xpath("(//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::div//button[text()='Add to Cart']");
    String getPriceUOM = "((//button[contains(@data-for,'add-to-order-guide')]/ancestor::div[2]/following-sibling::div)[1]/following-sibling::*//div//span[contains(text(),'$')])[UOM]";
    By btn_backToCatalog = By.xpath("//button[contains(text(),'Back')]");
    String multiUomDropDownOG = "(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg'])[1]";
    String btn_OGAddToCartPlusQuantity ="(//td[text()='CODE']/following-sibling::*//div/*[local-name()='svg' and @data-icon='plus'])[UOM]";
    String getOGPriceUOM ="(//td[text()='CODE']/ancestor::tr/td[5]/div/div/div/div/span[contains(@class,'prioritizedPrice')])[UOM]";
    By multiUomOption =By.xpath("//div[text()='Multiple Units']");
    String txt_orderIdMulti = "(//div[contains(text(),'Order #')])[UOM]";
    By getTotalItemCount = By.xpath("//td[text()='Items:']/following-sibling::td");
    By getTotalItemPrice = By.xpath("//td[text()='Total:']/following-sibling::td");


    public void ClickOnMultiUomDropDown(String name)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(multiUomDropDown.replace("NAME", name)));
        restaurantUI.click(By.xpath(multiUomDropDown.replace("NAME", name)));
    }
    public void ClickOnMultiUomDropDownOption(String option){
        restaurantUI.waitForVisibility(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
        restaurantUI.click(By.xpath(multiUomDropDownOption.replace("OPTION", option)));
    }
    public void clickAddToCartPlusIcon(String uom)throws InterruptedException{
        restaurantUI.waitForVisibility(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_addToCartPlusQuantity.replace("UOM", uom)));
        restaurantUI.waitForCustom(2000);
    }
    public void clickAddToCartMinusIcon(String uom){
        restaurantUI.waitForVisibility(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
        restaurantUI.click(By.xpath(btn_addToCartMinusQuantity.replace("UOM", uom)));
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
        return Double.valueOf(priceText.replace("$", "").replace("/cs", "").replace("/pkg", "").trim());
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

}
