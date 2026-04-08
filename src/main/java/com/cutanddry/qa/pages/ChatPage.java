package com.cutanddry.qa.pages;

import org.openqa.selenium.By;

public class ChatPage extends LoginPage {

    By btn_chat_restaurant = By.xpath("//div[contains(text(), 'Independent Foods Co')]");
    By btn_hayes_restaurant = By.xpath("//div[text()='Hayes']");
    By tbx_Message = By.xpath("//input[@placeholder='Message...']");
    By icon_send = By.xpath("//span[contains(@class, '_1j33wau')]");
    String txt_lastMessage = "(//div[contains(text(),'MESSAGE')])[last()]";
    By txt_defaultMsg = By.xpath("//div[text()='Send us messages through this chat interface to clarify issues with products and orders.']");

    public void clickOnRestaurantChat() {
        getRestaurantUI().waitForVisibility(btn_chat_restaurant);
        getRestaurantUI().click(btn_chat_restaurant);
        getRestaurantUI().waitForVisibility(btn_hayes_restaurant);
        getRestaurantUI().click(btn_hayes_restaurant);
    }
    public void clickOnMessage(){
        getRestaurantUI().waitForVisibility(tbx_Message);
        getRestaurantUI().click(tbx_Message);
    }
    public void typeOnMessage(String msg) {
        getRestaurantUI().clear(tbx_Message);
        getRestaurantUI().waitForClickability(tbx_Message);
        getRestaurantUI().sendKeys(tbx_Message, msg);
    }
    public void clickSendButton(){
        getRestaurantUI().waitForElementEnabledState(icon_send,true);
        getRestaurantUI().waitForClickability(icon_send);
        getRestaurantUI().click(icon_send);
        getRestaurantUI().waitForVisibility(icon_send);
    }
    public String getLastMessageDisplayed(String message) throws InterruptedException {
        getRestaurantUI().waitForCustom(5000);
        getRestaurantUI().refreshPage();
        return getRestaurantUI().getText(By.xpath(txt_lastMessage.replace("MESSAGE",message)));
    }
    
}
